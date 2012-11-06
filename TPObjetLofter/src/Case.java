import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 * 1 oct. 2012
 * Case.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public class Case implements ObjetDessinable {
	
	protected LinkedList<Nourriture> reserves;
	protected int positionx;
	protected int positiony;
	
	
	public Case(int x, int y){
		this.positionx=x;
		this.positiony=y;
	}
	public Case(int x ,int y, LinkedList<Nourriture> reserves){
		this.reserves=new LinkedList<Nourriture>();
		this.reserves=reserves;
		this.positionx=x;
		this.positiony=y;
	}
	/**
	 * @return the reserves
	 */
	public LinkedList<Nourriture> getReserves() {
		return reserves;
	}
	/**
	 * @param object the reserves to set
	 */
	public void setReserves(LinkedList<Nourriture> object) {
		this.reserves = object;
	}
	public void ajouterNourriture(Nourriture nourritureAjoutee){
		this.reserves.add(nourritureAjoutee);
	}
	public void supprimerNourriture( Commestible nourriture){
		this.reserves.remove(nourriture);
	}
	
	/**
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
	
	public int getEnergieTotale(){
		int a=0;
		for( Nourriture n:this.getReserves()){
			a=a+n.getEnergie();
		}
		return a; 
	}
	public boolean compareTo(Case position) {
		if(this.positionx==position.getPositionx()&&this.positiony==position.getPositiony()){
			return true;
		}else{
			return false;	
		}
	}
	@Override
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		int x = this.getPositionx();
        int y = this.getPositiony();
        int squaresize = ZoneGraphique.PIXEL_SIZE;
        int squaregap = (int) Math.round(0.1 * (float) ZoneGraphique.PIXEL_SIZE);
        if(this.getEnergieTotale()==0){
        	g.setColor(Color.GRAY);
        }else{
            g.setColor(Color.BLUE);        	
        }
        g.fill3DRect(x * squaresize + squaregap, y * squaresize + squaregap, squaresize - 2 * squaregap, squaresize - 2 * squaregap, true);
   
	}
	
}
