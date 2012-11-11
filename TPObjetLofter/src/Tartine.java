/**
 * @author bastien marichal-ragot & antoine veron
 */

/**
 * Enumertion tartine contient l'ensemble des items de nourriture
 * @author bastien marichal-ragot & antoine veron
 *
 */
public enum Tartine {
	
		 TACOS("TACOS",27), NUTELLA("NUTELLA",22), ORANGINA("ORANGINA",2), SALADE("SALADE",0), BIERE("BIERE",25);
		 
		 private String nom;
		 private int energie;
		 /**
		  * Constructeur
		  * @param n
		  * @param c
		  */
		 private Tartine(String n,int c) {
		   energie = c;
		   nom=n;
		 }
		 /**
		  * 
		  * @return energie de l'item
		  */
		 public int getEnergie() {
		   return energie;
		 }
		 /**
		  * 
		  * @return le nom de l'item
		  */
		 public String getNom(){
			 return nom;
		 }
}
