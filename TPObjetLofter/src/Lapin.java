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
		int[] a = null;
		int[] b = null;
		int[] c = null;
		int l=0;
		
		for(int k=0;k<this.environnement.getPopulation().size();k++){
			a[k]=this.environnement.getPopulation().get(k).getPosition().getPositionx()-this.position.getPositionx();
			b[k]=this.environnement.getPopulation().get(k).getPosition().getPositiony()-this.position.getPositiony();
			c[k]=a[k]*a[k]+b[k]*b[k];
			
			if (c[k]>c[k-1] && k>1){
				l=k;
			}
		}
		this.position.setPositionx(this.position.getPositionx()+a[l]/Math.abs(a[l]));
		this.position.setPositiony(this.position.getPositiony()+b[l]/Math.abs(b[l]));
	
	//se déplace vers le neuneu le plus proche. mange ensuite??
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
			System.out.println("Vous ne pouvez pas manger Áa!");
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
			}
		}		
	}
}
