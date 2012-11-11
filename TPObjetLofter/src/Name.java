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

	ANTOINE("antoine"), 
	GAETAN("gaetan"), 
	ROBERT("robert"), 
	RICHARD("richard"), 
	GINETTE("ginette"),
	ANAIRE("anaire"),
	ARACANO("Arac�no"),
	ARAFINWE("Arafinw�"), 
	ARANWE("Aranw�"), 
	ARTAHER("Artaher"), 
	ARTANIS("Artanis"), 
	AULENDI("Aulendil"), 
	AULENDUR("Aulendur"), 
	CURUFINWE("Curufinw�"), 
	EARXWEN("E�rwen"), 
	ELDALOTE("Eldal�t�"), 
	ELEMMACIL("Elemmacil"), 
	ELEMIRE("Elemm�re"), 
	ELENWE("Elenw�"), 
	FEANARO("F�an�ro"), 
	FINDAMBAR("Findambar"), 
	FINDECANO("Findec�no");
	
	
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
