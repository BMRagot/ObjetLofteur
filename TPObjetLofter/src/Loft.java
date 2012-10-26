import java.util.ArrayList;

/**
 * 1 oct. 2012
 * Loft.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public class Loft {
	protected Case[][] terrain;
	protected int hauteur;
	protected int largeur;
	protected ArrayList<Neuneu> population;
	
	/**
	 * Constructor
	 */
	public Loft(){
		//TODO:a completer
		
		
		
	}
	
	/**
	 * @return the terrain
	 */
	public Case[][] getTerrain() {
		return terrain;
	}

	/**
	 * @param terrain the terrain to set
	 */
	public void setTerrain(Case[][] terrain) {
		this.terrain = terrain;
	}

	/**
	 * @return the hauteur
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * @param hauteur the hauteur to set
	 */
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	/**
	 * @return the largeur
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 * @param largeur the largeur to set
	 */
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	/**
	 * @return the population
	 */
	public ArrayList<Neuneu> getPopulation() {
		return population;
	}

	/**
	 * @param population the population to set
	 */
	public void setPopulation(ArrayList<Neuneu> population) {
		this.population = population;
	}

	/**
	 * Methods to add Neuneu in loft
	 * @param arrivant
	 */
	public void ajouterNeuneu(Neuneu arrivant){
		population.add(arrivant);
	}
	
	/**
	 * Mthods to remove Neuneu in loft
	 * @param partant
	 */
	public void supprimerNeuneu(Neuneu partant){
		population.remove(partant);
	}
}
