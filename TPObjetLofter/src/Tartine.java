/**
 * 
 */

/**
 * @author bastienmarichalragot
 *
 */
public enum Tartine {
	
		 TACOS("TACOS",27), NUTELLA("NUTELLA",22), ORANGINA("ORANGINA",2), SALADE("SALADE",0), BIERE("BIERE",25);
		 
		 private String nom;
		 private int energie;
		 
		 private Tartine(String n,int c) {
		   energie = c;
		   nom=n;
		 }
		 
		 public int getEnergie() {
		   return energie;
		 }
		 
		 public String getNom(){
			 return nom;
		 }
}
