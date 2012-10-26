import java.awt.Graphics;
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
public class Loft implements ObjetDessinable {
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
	@SuppressWarnings("null")
	public Loft(int l, int h, ArrayList<Neuneu> POP){		
		this.population=POP;
		this.largeur=l;
		this.hauteur=h;
		this.terrain=new Case[largeur][hauteur];
		for(int j=1;j<=hauteur;j++){
			for(int i=1; i<=largeur; i++){
				LinkedList<Nourriture>Bouff=new LinkedList<Nourriture>();
				double test=Math.random();
				if (test<0){
					int o=1;
				}else if(test<0.75){
					Bouff.add(new Nourriture());
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
				terrain[i-1][j-1]= new Case(i-1,j-1,Bouff);
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
			int nb=this.population.size();
			int i=0;
			while(i<this.population.size()){
				this.population.get(i).cycleDeVie();
				//System.out.println("Il reste "+this.population.get(i).getEnergie()+" d'énergie à "+this.population.get(i).getNom()+" !");
				//TODO gros bug sur le trip, des neuneu meurent lors de leur cycle de vie?? bug un canniba se mange tout seul a coup sur!
				i=i+1;
			}
			i=0;
			while (i<this.population.size()){
				if(this.population.get(i).getEnergie()<=0){
					this.supprimerNeuneu(this.population.get(i));
				}else{
					i=i+1;
				}
			}
		}
	}

	@Override
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
