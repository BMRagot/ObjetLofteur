/**
 * 1 oct. 2012
 * Vorace.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public class Vorace extends Erratique{

	public Vorace(String nom, Case position, Loft environnement) {
		super(nom, position, environnement);
	}
	
	public void seDeplacer(){
		//TODO : recherche du stock de nourriture le plus proche
		//TODO proivilegier le type de nourriture (alcool)
		
	}

	/* (non-Javadoc)
	 * @see Erratique#manger(Commestible)
	 */
	@Override
	public void manger(Commestible nourriture) {
		// TODO Auto-generated method stub
		super.manger(nourriture);
		for(Nourriture manger:this.position.getReserves()){
			manger.donneEnergie(this);
		}
		this.position.getReserves().clear();
		
	}
	
}
