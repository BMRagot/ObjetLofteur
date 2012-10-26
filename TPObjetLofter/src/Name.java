/**
 * 
 */

/**
 * @author bastienmarichalragot
 *
 */
public enum Name {

	ANTOINE("antoine"), GAETAN("gaetan"), ROBERT("robert"), RICHARD("richard"), GINETTE("ginette");
	
	private String nom;
	
	private Name(String n){
		this.nom=n;
	}
	
	public String getNom(){
		 return nom;
	 }
	
}
