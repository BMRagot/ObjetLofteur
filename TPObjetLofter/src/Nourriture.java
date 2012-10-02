/**
 * 1 oct. 2012
 * Nourriture.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public class Nourriture implements Commestible{
	protected String nom;
	protected int energie;
	
	public Nourriture(String nom, int energie){
		this.nom=nom;
		this.energie=energie;
	}

	@Override
	public void donneEnergie(Neuneu lofteur) {
		lofteur.setEnergie(lofteur.getEnergie()+ this.energie);
		//this.energie=0; peut etre 
		
	}

	/* (non-Javadoc)
	 * @see Commestible#getEnergie()
	 */
	@Override
	public int getEnergie() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
