/**
 * 1 oct. 2012
 * Commestible.java
 * @author bastien marichal-ragot & antoine veron
 */

/**
 * Definiton d'une classe abstrait Commestible implementant l'interface ObjetDessinable
 * @author bastien marichal-ragot & antoine veron
 * @version 1.0
 */
public abstract class Commestible implements ObjetDessinable{
	/**
	 * Methode abstraite donneEnergie
	 * @param lofteur
	 */
	public void donneEnergie(Neuneu lofteur) {
	}
	/**
	 * 
	 * @return
	 */
	public int getEnergie(){
		return 0;
	}

}
