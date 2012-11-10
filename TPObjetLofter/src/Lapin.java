import java.awt.Color;
import java.awt.Graphics;

/**
 * 1 oct. 2012
 * Lapin.java
 * @author bastien marichal-ragot & antoine veron
 */

/**
 *
 * @author bastien marichal-ragot & antoine veron
 *
 */
public class Lapin extends Neuneu{
	public Lapin(String nom, Case position, Loft environnement){
		super(nom, position, environnement);
		this.type="Lapin";
	}
	
	/**
	 * Methode de deplacement du lapin qui ne cherche qu'à courir après un partenaire sexuel
	 * @see Neuneu#seDeplacer()
	 */
	public void seDeplacer(){		
		// si le lapin possede suffisament d'energie pour se reproduire alors il par à la recherche d'un partenaire
		if( this.energie>50 && this.environnement.getPopulation().size()>1){
			//calcul des distance séparant les lapins des autres neuneu
			int[] a = new int[this.environnement.getPopulation().size()];;
			int[] b = new int[this.environnement.getPopulation().size()];;
			int[] c = new int[this.environnement.getPopulation().size()];;
			
			for(int k=0;k<this.environnement.getPopulation().size();k++){
				a[k]=this.environnement.getPopulation().get(k).getPosition().getPositionx()-this.position.getPositionx();
				b[k]=this.environnement.getPopulation().get(k).getPosition().getPositiony()-this.position.getPositiony();
				c[k]=a[k]*a[k]+b[k]*b[k];
			}
			//selection du partenaire le plus proche
			int l=0;
			while(c[l]==0 && l<this.environnement.getPopulation().size()){
				l=l+1;
			}
			for(int k=0;k<this.environnement.getPopulation().size();k++){	
				if (c[k]!=0 && c[l]>c[k]){
					l=k;
				}
			}
			// calcul des déplacements necessaires
			if(a[l]>0){
				this.position.setPositionx(this.position.getPositionx()+1);
			}else if (a[l]<0){
				this.position.setPositionx(this.position.getPositionx()-1);
			}
			if(b[l]>0){
				this.position.setPositiony(this.position.getPositiony()+1);
			}else if( b[l]<0){
				this.position.setPositiony(this.position.getPositiony()-1);
			}
		}else{
			// si le lapin n'a pas assez d'énergie, il se déplace de facon aleatoire à l arecherche d'énergie
			int a= this.position.getPositionx();
			int b= this.position.getPositiony();
		
			a=a +(int)(Math.random() * (3)) - 1;
			while (a<0 || a>this.environnement.largeur-1){
				a=a +(int)(Math.random() * (3)) - 1;
			}
			b=b+(int)(Math.random() * (3)) - 1;
			while(b<0 || b>this.environnement.hauteur-1){
				b=b+(int)(Math.random() * (3)) - 1;
			}
			
			this.position.setPositionx(a);
			this.position.setPositiony(b);
		}
	}
		
	//TODO bug sur la methode manger ne gagne pas denergie?? a verifier
	/**
	 * 
	 * @param nourriture
	 */
	public void manger(Commestible nourriture){
		
		if (nourriture.getClass().getName().equals("Nourriture")){
			nourriture.donneEnergie(this);
			this.energie=this.energie + nourriture.getEnergie();
			this.position.supprimerNourriture(nourriture);
		}
		
		else {
			System.out.println("Vous ne pouvez pas manger Áa!");
		}		
	}
	/**
	 * Methode cycleDeVie() du lapin
	 */
	public void cycleDeVie() {
		//Le Lapin commence par se dÈplacer
		this.seDeplacer();
		this.setEnergie(this.getEnergie()-2);
		
		//Si de la nourriture est prÈsente sur la case, il mange le premier item
		if(this.getPosition().getReserves().size()!=0){
			this.manger(this.getPosition().getReserves().getFirst());
		}
				
		for(Neuneu n:this.getEnvironnement().getPopulation()){
			if(this.getPosition().compareTo(n.getPosition())){
				this.seReproduire(n);
				break;
			}
		}		
	}
	/**
	 * Affichage graphique
	 * les lapins sont représentés par des points roses
	 * 
	 */
	@Override
	public void dessinerObjet(Graphics g) {
		int x = this.getPosition().getPositionx();
        int y = this.getPosition().getPositiony();
        int squaresize = ZoneGraphique.PIXEL_SIZE;
        int squaregap = (int) Math.round(0.2 * (float) ZoneGraphique.PIXEL_SIZE);
        g.setColor(Color.PINK);
        g.fillOval(x * squaresize + squaregap, y * squaresize + squaregap, squaresize - 2 * squaregap, squaresize - 2 * squaregap);
	}
}
