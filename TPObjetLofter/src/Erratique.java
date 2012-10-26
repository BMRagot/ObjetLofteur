import java.util.Random;

/**
 * 1 oct. 2012
 * Erratique.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public class Erratique extends Neuneu{

	public Erratique(String nom, Case position, Loft environnement) {
		super(nom, position, environnement);
}
	public void seDeplacer(){
		
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
	
	public void manger(Commestible nourriture){
		for (Nourriture nourriture1:this.position.getReserves()){
			double test=Math.random();
			if(test<0.3){
				nourriture1.donneEnergie(this);
				this.position.getReserves().remove(nourriture1);
			}
		}
	}
	/* (non-Javadoc)
	 * @see Neuneu#cycleDeVie()
	 */
	@Override
	public void cycleDeVie() {
		this.seDeplacer();
		this.setEnergie(this.getEnergie()-2);
		
		if(this.getPosition().getReserves().size()!=0){
			this.manger(this.getPosition().getReserves().getFirst());
		}
				
		for(Neuneu n:this.getEnvironnement().getPopulation()){
			if(this.getPosition().compareTo(n.getPosition())){
				this.seReproduire(n);
			}
		}		
		
		
	}
	
	
}
