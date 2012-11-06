import java.awt.Color;
import java.awt.Graphics;

/**
 * 1 oct. 2012
 * Lapin.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public class Lapin extends Neuneu{
	public Lapin(String nom, Case position, Loft environnement){
		super(nom, position, environnement);
	}
	
	/**
	 * Move the "lapin" just wants to fuck
	 * @see Neuneu#seDeplacer()
	 */
	public void seDeplacer(){		
		
		
		if( this.energie>50){
			
			int[] a = new int[this.environnement.getPopulation().size()];;
			int[] b = new int[this.environnement.getPopulation().size()];;
			int[] c = new int[this.environnement.getPopulation().size()];;
			int l=0;
			
			for(int k=0;k<this.environnement.getPopulation().size();k++){
				a[k]=this.environnement.getPopulation().get(k).getPosition().getPositionx()-this.position.getPositionx();
				b[k]=this.environnement.getPopulation().get(k).getPosition().getPositiony()-this.position.getPositiony();
				c[k]=a[k]*a[k]+b[k]*b[k];
			}	
			for(int k=0;k<this.environnement.getPopulation().size()-1;k++){	
				if (c[k]!=0 && c[k]>c[k+1]){
					l=k+1;
				}
			}

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

			int a= this.position.getPositionx();
			int b= this.position.getPositiony();
		
			while (a<0 && a>this.environnement.largeur){
				a=a +(int)(Math.random() * (3)) - 1;
			}
			while(b<0 && b>this.environnement.hauteur){
				b=b+(int)(Math.random() * (3)) - 1;
			}
			
			this.position.setPositionx(a);
			this.position.setPositiony(b);
			
		}
		
	}
		
	
	/**
	 * 
	 * @param nourriture
	 */
	public void manger(Commestible nourriture){
		
		if (nourriture.getClass().getName().equals("Nourriture")){
			nourriture.donneEnergie(this);
			this.position.supprimerNourriture(nourriture);
		}
		
		else {
			System.out.println("Vous ne pouvez pas manger ça!");
		}		
	}
	
	public void cycleDeVie() {
		this.seDeplacer();
		this.setEnergie(this.getEnergie()-2);
		
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

	@Override
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		int x = this.getPosition().getPositionx();
        int y = this.getPosition().getPositiony();
        int squaresize = ZoneGraphique.PIXEL_SIZE;
        int squaregap = (int) Math.round(0.2 * (float) ZoneGraphique.PIXEL_SIZE);
        g.setColor(Color.BLUE);
        g.fillOval(x * squaresize + squaregap, y * squaresize + squaregap, squaresize - 2 * squaregap, squaresize - 2 * squaregap);
	
	}
}
