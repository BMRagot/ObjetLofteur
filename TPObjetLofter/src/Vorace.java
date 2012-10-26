/**
 * 1 oct. 2012
 * Vorace.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public class Vorace extends Erratique{

	public Vorace(String nom, Case position, Loft environnement) {
		super(nom, position, environnement);
	}
	
	public void seDeplacer(){
		//TODO : recherche du stock de nourriture le plus proche
		//TODO proivilegier le type de nourriture (alcool)
		int a = 0;
		int b = 0;

		Case c= this.environnement.getTerrain()[1][1];
		for(int j=2;j<=this.environnement.getHauteur();j++){
			for(int i=2;i<=this.environnement.getLargeur();i++){
				if(this.environnement.getTerrain()[i][j].getEnergieTotale()>c.getEnergieTotale()){
					c=this.environnement.getTerrain()[i][j];
				}
			}
		}
		a=c.getPositionx()-this.position.getPositionx();
		b=c.getPositiony()-this.position.getPositiony();
			
		this.position.setPositionx(this.position.getPositionx()+a/Math.abs(a));
		this.position.setPositiony(this.position.getPositiony()+b/Math.abs(b));
		
	}

	/* (non-Javadoc)
	 * @see Erratique#manger(Commestible)
	 */
	@Override
	public void manger(Commestible nourriture) {
		super.manger(nourriture);
		for(Nourriture manger:this.position.getReserves()){
			manger.donneEnergie(this);
		}
		this.position.getReserves().clear();
	}
}
