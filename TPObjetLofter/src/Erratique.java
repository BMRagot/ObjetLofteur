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
		//TODO deplacment random et verifier la non sortie du plateau...
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
		//TODO manger une partie seulement des reserves de nourriture
		//TODO gestion
		for (Nourriture nourriture1:this.position.getReserves()){
			
		}
		
	}
}
