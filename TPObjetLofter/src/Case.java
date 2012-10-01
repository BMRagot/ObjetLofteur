import java.util.LinkedList;

/**
 * 1 oct. 2012
 * Case.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public class Case {
	
	protected LinkedList<Nourriture> reserves;
	protected int positionx;
	protected int positiony;
	
	
	public Case(){
		
	}
	public Case(LinkedList<Nourriture> reserves){
		this.reserves=new LinkedList<Nourriture>();
		this.reserves=reserves;
	}
	public void ajouterNourriture(Nourriture nourritureAjoutee){
		this.reserves.add(nourritureAjoutee);
	}
	public void supprimerNourriture(Nourriture nourritureConsomee){
		this.reserves.remove(nourritureConsomee);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getpositionx(){
		return this.positionx;
	}
	/**
	 * 
	 * @return
	 */
	public int getpositiony(){
		return this.positiony;
	}
}
