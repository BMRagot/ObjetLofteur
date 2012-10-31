import java.awt.Graphics;

/**
 * 1 oct. 2012
 * Nourriture.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public  class Nourriture extends Commestible{
	protected String nom;
	protected int energie;
	
	public Nourriture(){
		//TODO constructeur random appel de l'enmeration
		int a =(int) Math.random()*5;
		
		this.nom=Tartine.values()[a].getNom();
		this.energie=Tartine.values()[a].getEnergie();
	}
	
	public Nourriture(String nom, int energie){
		this.nom=nom;
		this.energie=energie;
	}

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

	@Override
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		//TODO bug on a pas la positon de la nourriture comment utiliser l'interface maintenant... ??
	}
	
}
