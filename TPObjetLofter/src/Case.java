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
	 * @param reserves the reserves to set
	 */
	public void setReserves(LinkedList<Nourriture> reserves) {
		this.reserves = reserves;
	}
	public void ajouterNourriture(Nourriture nourritureAjoutee){
		this.reserves.add(nourritureAjoutee);
	}
	public void supprimerNourriture(Nourriture nourriture){
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
	
}
