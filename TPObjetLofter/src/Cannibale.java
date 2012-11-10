import java.awt.Color;
import java.awt.Graphics;

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
		int[] a = new int[this.environnement.getPopulation().size()];
		int[] b = new int[this.environnement.getPopulation().size()];
		int[] c = new int[this.environnement.getPopulation().size()];
		int l=0;
		
		for(int k=0;k<this.environnement.getPopulation().size();k++){
			a[k]=this.environnement.getPopulation().get(k).getPosition().getPositionx()-this.position.getPositionx();
			b[k]=this.environnement.getPopulation().get(k).getPosition().getPositiony()-this.position.getPositiony();
			c[k]=a[k]*a[k]+b[k]*b[k];
		
		}
		for(int k=0;k<this.environnement.getPopulation().size()-1;k++){	
			if (c[k]!=0 &&  c[k]>c[k+1]){ //
				l=k+1;
			}
		}
		if(a[l]>0){
			this.position.setPositionx(this.position.getPositionx()+1);
		}else if (a[l]<0){
			this.position.setPositionx(this.position.getPositionx()-1);
		}
		if(b[l]>0){
			this.position.setPositiony(this.position.getPositiony()+1);
		}else if( b[l]<0){
			this.position.setPositiony(this.position.getPositiony()-1);
		}
	}
		

	/* (non-Javadoc)
	 * @see Vorace#manger(Commestible)
	 */
	@Override
	public void manger(Commestible nourriture) {
		int max=this.position.getReserves().size();
		Nourriture[] effacer= new Nourriture[max];
		for (int i=0; i<max;i++){
			double test=Math.random();
			if(test<0.3){
				this.position.getReserves().get(i).donneEnergie(this);
				effacer[i]=this.position.getReserves().get(i);
			}
		}
		for(int i=0;i<max;i++){
				this.position.getReserves().remove(effacer[i]);
		}
		System.out.println("test");

		for(Neuneu n:this.environnement.getPopulation()){
			//if(this.getPosition().compareTo(n.getPosition())){
			if(this.position.getPositionx()==n.getPosition().getPositionx() && this.position.getPositiony()==n.getPosition().getPositiony() && !this.equals(n)){	
				n.donneEnergie(this);
				this.environnement.supprimerNeuneu(n);
				System.out.println(this.getNom()+" dŽvore " +n.getNom());
				break;
			}
		}		
		
	}

	
	public void cycleDeVie() {
		this.seDeplacer();
		this.setEnergie(this.getEnergie()-2);
		
			this.manger(new Nourriture("n", 0));
		
				
		for(Neuneu n:this.getEnvironnement().getPopulation()){
			if(this.getPosition().compareTo(n.getPosition())){
				this.seReproduire(n);
				break;
			}
		}		
	}
	
	
	/* (non-Javadoc)
	 * @see Erratique#dessinerObjet(java.awt.Graphics)
	 */
	@Override
	public void dessinerObjet(Graphics g) {
		int x = this.getPosition().getPositionx();
        int y = this.getPosition().getPositiony();
        int squaresize = ZoneGraphique.PIXEL_SIZE;
        int squaregap = (int) Math.round(0.2 * (float) ZoneGraphique.PIXEL_SIZE);
        g.setColor(Color.GREEN);
        g.fillOval(x * squaresize + squaregap, y * squaresize + squaregap, squaresize - 2 * squaregap, squaresize - 2 * squaregap);
	
	}
	
	
	
}

