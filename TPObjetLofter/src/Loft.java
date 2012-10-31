import java.awt.Color;
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
	protected ZoneGraphique zone;
	
	/**
	 * 
	 * @param l
	 * @param h
	 * @param POP
	 * @param zone2 
	 */
	@SuppressWarnings("null")
	public Loft(int l, int h, ArrayList<Neuneu> POP, ZoneGraphique zone2){		
		this.population=POP;
		this.largeur=l;
		this.hauteur=h;
		this.zone=zone2;
		this.terrain=new Case[largeur][hauteur];
		for(int j=0;j<hauteur;j++){
			for(int i=0; i<largeur; i++){
				LinkedList<Nourriture>Bouff=new LinkedList<Nourriture>();
				double test=Math.random();
				if (test<0){
					int o=1;
				}else if(test<1){
					Bouff.add(new Nourriture(i,j));
				}else if(test<0.95){
					Bouff.add(new Nourriture(i,j));
					Bouff.add(new Nourriture(i,j));
					Bouff.add(new Nourriture(i,j));
				}else{
					Bouff.add(new Nourriture(i,j));
					Bouff.add(new Nourriture(i,j));
					Bouff.add(new Nourriture(i,j));
					Bouff.add(new Nourriture(i,j));
					Bouff.add(new Nourriture(i,j));
					Bouff.add(new Nourriture(i,j));
				}
				terrain[i][j]= new Case(i,j,Bouff);
				for(Nourriture n:Bouff){
					//zone.ajouterObjet(n);
				}
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
		zone.ajouterObjet(arrivant);
	}
	
	/**
	 * Mthods to remove Neuneu in loft
	 * @param partant
	 */
	public void supprimerNeuneu(Neuneu partant){
		population.remove(partant);
		zone.supprimerObjet(partant);
	}
	
	public void cycleDeVie(){
		while (!this.population.isEmpty()){
			System.out.println("Il reste "+this.population.size()+" Neuneus!");
			int nb=this.population.size();
			int i=0;
			while(i<this.population.size()){
				System.out.println("Il reste "+this.population.get(i).getEnergie()+" d'énergie à "+this.population.get(i).getNom()+" !");

				this.population.get(i).cycleDeVie();
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
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//zone.repaint();
			
			//Graphics g = null;
			this.dessinerObjet(zone.getGraphics());
		}
		//TODO message de fin...
	}

	@Override
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		for(int j=0;j<hauteur;j++){
			for(int i=0; i<largeur; i++){
				terrain[i][j].dessinerObjet(g);
				for(Nourriture n:terrain[i][j].getReserves()){
					n.dessinerObjet(g);
				}
			}	
		}
		for(Neuneu lofter:this.population){
			lofter.dessinerObjet(g);
		}
	}
}
