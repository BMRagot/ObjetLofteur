/**
 * 1 oct. 2012
 * Cannibale.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public class Cannibale extends Vorace{
	
	public Cannibale( String nom, Case position, Loft environnement){
		super(nom, position, environnement);
	}
	
	/**
	 * 
	 */
	public void seDeplacer(){
		//deplace vers le neuneu le plus proche.
		int[] a = null;
		int[] b = null;
		int[] c = null;
		int l=0;
		
		for(int k=0;k<this.environnement.getPopulation().size();k++){
			a[k]=this.environnement.getPopulation().get(k).getPosition().getPositionx()-this.position.getPositionx();
			b[k]=this.environnement.getPopulation().get(k).getPosition().getPositiony()-this.position.getPositiony();
			c[k]=a[k]*a[k]+b[k]*b[k];
			
			if (c[k]>c[k-1] && k>1){
				l=k;
			}
		}
		this.position.setPositionx(this.position.getPositionx()+a[l]/Math.abs(a[l]));
		this.position.setPositiony(this.position.getPositiony()+b[l]/Math.abs(b[l]));
	}
}

