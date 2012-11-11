import java.awt.Color;
import java.awt.Graphics;

/**
 * 1 oct. 2012
 * Cannibale.java
 * @author bastien marichal-ragot & antoine vŽron
 */

/**
 * Classe Cannibale hŽrite de la classe Vorace. Definit les Neuneu de type Cannibale 
 * se nourrissant en prioritŽ des autres neuneus
 * @author bastien marichal-ragot & antoine vŽron 
 * @version 1.0
 */
public class Cannibale extends Vorace{
	
	public Cannibale( String nom, Case position, Loft environnement){
		super(nom, position, environnement);
		this.type="Cannibale";
	}
	
	/**
	 * MŽthode seDeplacer() definit le dŽplacement des cannibales
	 * Il recherche le neuneu le plus proche de lui pour aller le dŽvorer
	 */
	public void seDeplacer(){
		//on calcule la distance sŽparant le cannibale des autres neuneus
		int[] a = new int[this.environnement.getPopulation().size()];
		int[] b = new int[this.environnement.getPopulation().size()];
		int[] c = new int[this.environnement.getPopulation().size()];
		
		for(int k=0;k<this.environnement.getPopulation().size();k++){
			a[k]=this.environnement.getPopulation().get(k).getPosition().getPositionx()-this.position.getPositionx();
			b[k]=this.environnement.getPopulation().get(k).getPosition().getPositiony()-this.position.getPositiony();
			c[k]=a[k]*a[k]+b[k]*b[k];
		}
		//on sŽlectionne le plus proche
		int l=0;
		while(c[l]==0 && l<this.environnement.getPopulation().size()){
			l=l+1;
		}
		for(int k=0;k<this.environnement.getPopulation().size();k++){	
			if (c[k]!=0 &&  c[l]>c[k]){ //
				l=k;
			}
		}
		// on definit les dŽplacements nŽcessaires pour l'atteindre
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
	}
		

	/**
	 * Methode manger() surchage de la methode hŽritŽe de Vorace
	 * @see Vorace#manger(Commestible)
	 * @param Commestible
	 */
	@Override
	public void manger(Commestible nourriture) {
		//un cannibale peut manger de la nourriture standard de fa�on alŽatoire s'il en trouve
		int max=this.position.getReserves().size();
		Nourriture[] effacer= new Nourriture[max];
		for (int i=0; i<max;i++){
			double test=Math.random();
			if(test<0.3){
				this.position.getReserves().get(i).donneEnergie(this);
				effacer[i]=this.position.getReserves().get(i);
			}
		}
		for(int i=0;i<max;i++){
				this.position.getReserves().remove(effacer[i]);
		}
		//canibalisme s'il atteind sa cible
		for(Neuneu n:this.environnement.getPopulation()){
			if(this.position.getPositionx()==n.getPosition().getPositionx() && this.position.getPositiony()==n.getPosition().getPositiony() && !this.equals(n)){	
				n.donneEnergie(this);
				this.environnement.supprimerNeuneu(n);
				System.out.println(this.getNom()+" dŽvore " +n.getNom());
				break;
			}
		}		
	}

	/**
	 * Methode cycleDeVie() definition de la classe abstract Neuneu
	 * definit le cycle de vie du cannibale privilŽgieant la chasse
	 */
	public void cycleDeVie() {
		// se deplace en direction de sa cible
		this.seDeplacer();
		// perd de l'energie du a dŽplacement
		this.setEnergie(this.getEnergie()-2);
		//dŽvore un neuneu ou se nourri normalement
		this.manger(new Nourriture("n", 0));
		// se reproduit 
		for(Neuneu n:this.getEnvironnement().getPopulation()){
			if(this.getPosition().compareTo(n.getPosition())){
				this.seReproduire(n);
				break;
			}
		}		
	}
	
	
	/**
	 * Affichage graphique
	 * les cannibales sont visualisŽs par des points verts.
	 * @see Erratique#dessinerObjet(java.awt.Graphics)
	 */
	@Override
	public void dessinerObjet(Graphics g) {
		int x = this.getPosition().getPositionx();
        int y = this.getPosition().getPositiony();
        int squaresize = ZoneGraphique.PIXEL_SIZE;
        int squaregap = (int) Math.round(0.2 * (float) ZoneGraphique.PIXEL_SIZE);
        g.setColor(Color.GREEN);
        g.fillOval(x * squaresize + squaregap, y * squaresize + squaregap, squaresize - 2 * squaregap, squaresize - 2 * squaregap);
	}
	
	
	
}

