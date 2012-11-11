import java.awt.Color;
import java.awt.Graphics;

/**
 * 1 oct. 2012
 * Vorace.java
 * @author bastien marichal-ragot & antoine veron
 */

/**
 * Classe Vorace herite de la classe mere Erratique
 * @author bastien marichal-ragot & antoine veron
 *
 */
public class Vorace extends Erratique{
	/**
	 * Constructeur
	 * @param nom
	 * @param position
	 * @param environnement
	 */
	public Vorace(String nom, Case position, Loft environnement) {
		super(nom, position, environnement);
		this.type="Vorace";
	}
	
	/**
	 * Methode seDeplacer() redefinit le deplacement des voraces
	 * se deplace en direction de la case possedant les plus grandes reserves de nourriture
	 */
	public void seDeplacer(){

		int a = 1;
		int b = 1;

		Case c= this.environnement.getTerrain()[0][0];
		for(int j=1;j<this.environnement.getHauteur();j++){
			for(int i=1;i<this.environnement.getLargeur();i++){
				if(this.environnement.getTerrain()[i][j].getEnergieTotale()>c.getEnergieTotale()){
					c=this.environnement.getTerrain()[i][j];
				}
			}
		}
		a=c.getPositionx()-this.position.getPositionx();
		b=c.getPositiony()-this.position.getPositiony();
		if(a>0){
			this.position.setPositionx(this.position.getPositionx()+1);
		}else if (a<0){
			this.position.setPositionx(this.position.getPositionx()-1);
		}
		if(b>0){
			this.position.setPositiony(this.position.getPositiony()+1);
		}else if( b<0){
			this.position.setPositiony(this.position.getPositiony()-1);
		}
	}

	/**
	 * 
	 * @see Erratique#manger(Commestible)
	 */
	@Override
	public void manger(Commestible nourriture) {
		for(Nourriture manger:this.position.getReserves()){
			manger.donneEnergie(this);
		}
		//this.environnement.getTerrain()[position.getPositionx()][position.getPositiony()].setReserves(new LinkedList<Nourriture>());
		this.position.reserves.clear();
	}

	/**
	 * affichage Graphique
	 * les voraces sont rerésetés par des points jaunes
	 * @see Erratique#dessinerObjet(java.awt.Graphics)
	 */
	@Override
	public void dessinerObjet(Graphics g) {
		int x = this.getPosition().getPositionx();
        int y = this.getPosition().getPositiony();
        int squaresize = ZoneGraphique.PIXEL_SIZE;
        int squaregap = (int) Math.round(0.2 * (float) ZoneGraphique.PIXEL_SIZE);
        g.setColor(Color.YELLOW);
        g.fillOval(x * squaresize + squaregap, y * squaresize + squaregap, squaresize - 2 * squaregap, squaresize - 2 * squaregap);
	
	}
	
}
