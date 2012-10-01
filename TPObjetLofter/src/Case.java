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
	
}
