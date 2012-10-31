import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * 1 oct. 2012
 * Erratique.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public class Erratique extends Neuneu{

	public Erratique(String nom, Case position, Loft environnement) {
		super(nom, position, environnement);
}
	public void seDeplacer(){
		
		int a= this.position.getPositionx();
		int b= this.position.getPositiony();
	
		while (a<0 && a>this.environnement.largeur){
			a=a +(int)(Math.random() * (3)) - 1;
		}
		while(b<0 && b>this.environnement.hauteur){
			b=b+(int)(Math.random() * (3)) - 1;
		}
		
		this.position.setPositionx(a);
		this.position.setPositiony(b);
		
	}
	
	public void manger(Commestible nourriture){
		if(this.position.getReserves().size()!=0){
			int max=this.position.getReserves().size();
			Nourriture[] effacer= new Nourriture[max];
			for (int i=0;i<max;i++){
				double test=Math.random();
				if(test<0.3){
					this.position.getReserves().get(i).donneEnergie(this);
					effacer[i]=this.position.getReserves().get(i);
				}
			}
			for(int i=0;i<max;i++){
				this.position.getReserves().remove(effacer[i]);
			}
		}
	}
	/* (non-Javadoc)
	 * @see Neuneu#cycleDeVie()
	 */
	@Override
	public void cycleDeVie() {
		this.seDeplacer();
		this.setEnergie(this.getEnergie()-2);
		
		if(this.getPosition().getReserves().size()!=0){
			this.manger(this.getPosition().getReserves().getFirst());
		}
				
		for(Neuneu n:this.getEnvironnement().getPopulation()){
			if(this.getPosition().compareTo(n.getPosition())){
				this.seReproduire(n);
				break;
			}
		}		
		
		
	}
	@Override
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		int x = this.getPosition().getPositionx();
        int y = this.getPosition().getPositiony();
        int squaresize = ZoneGraphique.PIXEL_SIZE;
        int squaregap = (int) Math.round(0.2 * (float) ZoneGraphique.PIXEL_SIZE);
        g.setColor(Color.RED);
        g.fillOval(x * squaresize + squaregap, y * squaresize + squaregap, squaresize - 2 * squaregap, squaresize - 2 * squaregap);
	}
	
	
}
