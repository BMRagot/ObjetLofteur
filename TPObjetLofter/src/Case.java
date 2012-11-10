import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 * 1 oct. 2012
 * Case.java
 * @author bastien marichal-ragot & antoine veron
 */

/**
 * Classe Case definit une case du loft.
 * une case est reperee par ses coordonnees et contient une reserve de nourriture
 * @author bastien marichal-ragot & antoine veron
 * @version 1.0
 */
public class Case implements ObjetDessinable {
	
	protected LinkedList<Nourriture> reserves;
	protected int positionx;
	protected int positiony;
	
	/**
	 * Constructeur sans reserves
	 * @param x
	 * @param y
	 */
	public Case(int x, int y){
		this.positionx=x;
		this.positiony=y;
	}
	/**
	 * Constructeur avec reserves
	 * @param x
	 * @param y
	 * @param reserves
	 */
	public Case(int x ,int y, LinkedList<Nourriture> reserves){
		this.reserves=new LinkedList<Nourriture>();
		this.reserves=reserves;
		this.positionx=x;
		this.positiony=y;
	}
	
	/**
	 * getteur des reserves
	 * @return the reserves
	 */
	public LinkedList<Nourriture> getReserves() {
		return reserves;
	}
	
	/**
	 * setteur des reserves de la case
	 * @param object the reserves to set
	 */
	public void setReserves(LinkedList<Nourriture> object) {
		this.reserves = object;
	}
	
	/**
	 * Methode pour ajouter un item de nourriture aux reserves de la case
	 * @param nourritureAjoutee
	 */
	public void ajouterNourriture(Nourriture nourritureAjoutee){
		this.reserves.add(nourritureAjoutee);
	}
	
	/**
	 * Methode pour supprimer un item de nourriture des reserves de la case 
	 * @param nourriture
	 */
	public void supprimerNourriture( Commestible nourriture){
		this.reserves.remove(nourriture);
	}
	
	/**
	 * 
	 * @return the positionx
	 */
	public int getPositionx() {
		return positionx;
	}
	
	/**
	 * @param positionx the positionx to set
	 */
	public void setPositionx(int positionx) {
		this.positionx = positionx;
	}
	/**
	 * @return the positiony
	 */
	public int getPositiony() {
		return positiony;
	}
	/**
	 * @param positiony the positiony to set
	 */
	public void setPositiony(int positiony) {
		this.positiony = positiony;
	}
	/**
	 * methode calculant l'energie totale disponible sur la case
	 * @return
	 */
	public int getEnergieTotale(){
		int a=0;
		for( Nourriture n:this.getReserves()){
			a=a+n.getEnergie();
		}
		return a; 
	}
	/**
	 * methode pour comparer la position de deux cases
	 * @param position
	 * @return
	 */
	public boolean compareTo(Case position) {
		if(this.positionx==position.getPositionx() &&this.positiony==position.getPositiony()){
			return true;
		}else{
			return false;	
		}
	}
	/**
	 * Affichage graphique
	 * une case vide est representee par un carre gris
	 * une case contenant de la nourritur est reprsente par un carre bleu
	 */
	@Override
	public void dessinerObjet(Graphics g) {
		int x = this.getPositionx();
        int y = this.getPositiony();
        int squaresize = ZoneGraphique.PIXEL_SIZE;
        int squaregap = (int) Math.round(0.1 * (float) ZoneGraphique.PIXEL_SIZE);
        if(this.getEnergieTotale()>0){
        	g.setColor(Color.BLUE);
        }else{
            g.setColor(Color.GRAY);        	
        }
        g.fill3DRect(x * squaresize + squaregap, y * squaresize + squaregap, squaresize - 2 * squaregap, squaresize - 2 * squaregap, true);
	}
}
