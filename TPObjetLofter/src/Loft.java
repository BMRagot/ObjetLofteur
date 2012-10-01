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
		//a completer
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
