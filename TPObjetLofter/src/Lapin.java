/**
 * 1 oct. 2012
 * Lapin.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public class Lapin extends Neuneu{
	public Lapin(String nom){
		super(nom);
	}
	
	/**
	 * 
	 */
	public void seDeplacer(){
		
	}
	/**
	 * 
	 * @param nourriture
	 */
	public void manger(Commestible nourriture){
		nourriture.donneEnergie(this);
		this.position.supprimerNourriture(nourriture);
	}
}
