import java.awt.Color;
import java.awt.Graphics;

/**
 * 1 oct. 2012
 * Nourriture.java
 * @author bastien marichal-ragot & antoine veron
 */

/**
 * Class Nourriture harite de la classe mere abstraite Commestible
 * Definit les objets commestible "standard"
 * @author bastien marichal-ragot & antoine veron
 * @version 1.0
 */
public  class Nourriture extends Commestible{
	protected String nom;
	protected int energie;
	protected int X;
	protected int Y;
	//TODO pourquoi avoir mis X ET Y???
	
	/**
	 * Constructeur avec aleatoire de nourriture
	 * @param x
	 * @param y
	 */
	public Nourriture(int x, int y){
		int a =(int) Math.random()*5;
		
		this.nom=Tartine.values()[a].getNom();
		this.energie=Tartine.values()[a].getEnergie();
		
		this.X=x;
		this.Y=y;
		
	}
	/**
	 * Constructeur nominatif
	 * @param nom
	 * @param energie
	 */
	public Nourriture(String nom, int energie){
		this.nom=nom;
		this.energie=energie;
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return X;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		X = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return Y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		Y = y;
	}

	/**
	 * implementation de la methode donneEnergie
	 * Nourriture fournit de l'energie au lofteur
	 */
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
	/**
	 * Affichage Graphique
	 * l'affichage grphique de la nourriture est directement 
	 * pris en compte dans l'affichage de la case
	 */
	@Override
	public void dessinerObjet(Graphics g) {
	}
}
