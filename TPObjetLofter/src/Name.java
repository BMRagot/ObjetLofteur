/**
 * Name.java
 * @author bastien marichal-ragot & antoine v�ron
 */

/**
 * Enum des noms des differents neuneus
 * @author bastien marichal-ragot & antoine v�ron
 *
 */
public enum Name {

	ANTOINE("antoine"), GAETAN("gaetan"), ROBERT("robert"), RICHARD("richard"), GINETTE("ginette");
	
	private String nom;
	/**
	 * Constructeur
	 * @param n nom a donner
	 */
	private Name(String n){
		this.nom=n;
	}
	/**
	 * 
	 * @return nom
	 */
	public String getNom(){
		 return nom;
	 }
	
}
