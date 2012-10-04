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

	
	/**
	 * @return the energie
	 */
	public int getEnergie() {
		return energie;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param energie the energie to set
	 */
	public void setEnergie(int energie) {
		this.energie = energie;
	}
	
	
}
