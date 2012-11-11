/**
 * Name.java
 * @author bastien marichal-ragot & antoine véron
 */

/**
 * Enum des noms des differents neuneus
 * @author bastien marichal-ragot & antoine véron
 *
 */
public enum Name {

	ANTOINE("antoine"), 
	GAETAN("gaetan"), 
	ROBERT("robert"), 
	RICHARD("richard"), 
	GINETTE("ginette"),
	ANAIRE("anaire"),
	ARACANO("Aracáno"),
	ARAFINWE("Arafinwë"), 
	ARANWE("Aranwë"), 
	ARTAHER("Artaher"), 
	ARTANIS("Artanis"), 
	AULENDI("Aulendil"), 
	AULENDUR("Aulendur"), 
	CURUFINWE("Curufinwë"), 
	EARXWEN("Eärwen"), 
	ELDALOTE("Eldalótë"), 
	ELEMMACIL("Elemmacil"), 
	ELEMIRE("Elemmíre"), 
	ELENWE("Elenwë"), 
	FEANARO("Fëanáro"), 
	FINDAMBAR("Findambar"), 
	FINDECANO("Findecáno");
	
	
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
