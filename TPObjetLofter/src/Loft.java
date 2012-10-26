import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 1 oct. 2012
 * Loft.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public class Loft {
	protected Case[][] terrain;
	protected int hauteur;
	protected int largeur;
	protected ArrayList<Neuneu> population;
	
	/**
	 * 
	 * @param l
	 * @param h
	 * @param POP
	 */
	public Loft(int l, int h, ArrayList<Neuneu> POP){		
		this.population=POP;
		this.largeur=l;
		this.hauteur=h;
		for(int j=1;j<=hauteur;j++){
			for(int i=1; i<=largeur; i++){
				LinkedList<Nourriture>Bouff=new LinkedList<Nourriture>();
				double test=Math.random();
				if (test<0.5){
					
				}else if(test<0.75){
					Bouff.add( new Nourriture());
					}else if(test<0.95){
					Bouff.add(new Nourriture());
					Bouff.add(new Nourriture());
					Bouff.add(new Nourriture());
				}else{
					Bouff.add(new Nourriture());
					Bouff.add(new Nourriture());
					Bouff.add(new Nourriture());
					Bouff.add(new Nourriture());
					Bouff.add(new Nourriture());
					Bouff.add(new Nourriture());
				}
				terrain[i][j]= new Case(i,j,Bouff);		
			}
		}
	}
	
	public Loft(ArrayList<Neuneu> POP){
		this.population=POP;
	}
	
	
	/**
	 * @return the terrain
	 */
	public Case[][] getTerrain() {
		return terrain;
	}

	/**
	 * @param terrain the terrain to set
	 */
	public void setTerrain(Case[][] terrain) {
		this.terrain = terrain;
	}

	/**
	 * @return the hauteur
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * @param hauteur the hauteur to set
	 */
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	/**
	 * @return the largeur
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 * @param largeur the largeur to set
	 */
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	/**
	 * @return the population
	 */
	public ArrayList<Neuneu> getPopulation() {
		return population;
	}

	/**
	 * @param population the population to set
	 */
	public void setPopulation(ArrayList<Neuneu> population) {
		this.population = population;
	}

	/**
	 * Methods to add Neuneu in loft
	 * @param arrivant
	 */
	public void ajouterNeuneu(Neuneu arrivant){
		population.add(arrivant);
	}
	
	/**
	 * Mthods to remove Neuneu in loft
	 * @param partant
	 */
	public void supprimerNeuneu(Neuneu partant){
		population.remove(partant);
	}
	
	public void cycleDeVie(){
		while (!this.population.isEmpty()){
			System.out.println("Il reste "+this.population.size()+" Neuneus!");
			for(Neuneu a:this.population){
				a.cycleDeVie();
				if (a.getEnergie()<=0){
					this.supprimerNeuneu(a);
					System.out.println("Il reste "+a.getEnergie()+" d'énergie à "+a.getNom()+" !");
				}
			}
		}
			
		
	}
}
