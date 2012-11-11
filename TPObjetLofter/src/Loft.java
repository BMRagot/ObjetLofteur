import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 1 oct. 2012
 * Loft.java
 * @author bastien marichal-ragot & antoine veron
 */

/**
 * Class Loft defninit le Loft et gere l'affichage graphique principal
 * @author bastien marichal-ragot & antoine veron
 * @version 1.0
 */
public class Loft implements ObjetDessinable {
	protected Case[][] terrain;
	protected int hauteur;
	protected int largeur;
	protected ArrayList<Neuneu> population;
	protected ZoneGraphique zone;
	
	/**
	 * Constructeur
	 * @param l
	 * @param h
	 * @param POP
	 * @param zone2 
	 */
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
				if (test<0.7){
					int o=1;
					System.out.print(i+"; "+j+"\n");
				}else if(test<0.8){
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
			}
		}
	}
	
	/**
	 * Constructeur du loft a partir de sa population
	 * @param POP
	 */
	public Loft(ArrayList<Neuneu> POP){
		this.population=POP;
	}
	
	/**
	 *  
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
	 * Methods to remove Neuneu in loft
	 * @param partant
	 */
	public void supprimerNeuneu(Neuneu partant){
		population.remove(partant);
	}
	
	/**
	 *Definition du ccle de vie global du loft 
	 */
	public void cycleDeVie(){
		int nbJour=0;
		MaConsole MC= new MaConsole(nbJour,this);
		
		while (!this.population.isEmpty()){
			//System.out.println("Il reste "+this.population.size()+" Neuneus!");
			int nb=this.population.size();
			int i=0;
			while(i<this.population.size()){
				//System.out.println("Il reste "+this.population.get(i).getEnergie()+" d'énergie à au "+ this.population.get(i).getRace()+":"+this.population.get(i).getNom()+" !"+this.population.get(i).getPosition().getPositionx());
				int x=this.population.get(i).getPosition().getPositionx();
				int y= this.population.get(i).getPosition().getPositiony();
				//System.out.println(this.getTerrain()[x][y].getEnergieTotale());
				//System.out.println(this.population.get(i).getPosition().getEnergieTotale());
				//System.out.println(this.population.get(i).getEnvironnement().getPopulation().size());
				//if (this.population.get(i))
				
				//Neuneu mem= new Neuneu(this.population.get(i));
				this.population.get(i).cycleDeVie();
				this.terrain[x][y].setReserves(this.population.get(i).getPosition().getReserves());
				//this.population.get(i).getEnvironnement().setPopulation(this.population);
				//this.terrain[x][y]=this.population.get(i).getPosition();
				//this.setTerrain(this.population.get(i).getEnvironnement().getTerrain());
				//System.out.println(this.getTerrain()[x][y].getEnergieTotale());

				//TODO gros bug sur le trip, des neuneu meurent lors de leur cycle de vie?? bug un canniba se mange tout seul a coup sur!
				MC.update(nbJour, this,i);
				i=i+1;
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
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
				Thread.sleep(10);
				this.dessinerObjet(zone.getGraphics());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//zone.repaint();
			
			//Graphics g = null;
			nbJour=nbJour+1;
		}
		for(int j=0;j<hauteur;j++){
			for(int i=0; i<largeur; i++){
				//System.out.println(i +";"+ j +" ; " + this.getTerrain()[i][j].getEnergieTotale());
				
			}}
		System.out.println("cette saison a durŽ "+ nbJour +" jours!");
		//TODO message de fin...
	}
	/**
	 * Affichage graphique
	 * Affichage de tous les objets du Loft ˆ chaque tour
	 */
	@Override
	public void dessinerObjet(Graphics g) {

		for(int j=0;j<hauteur;j++){
			for(int i=0; i<largeur; i++){
				this.terrain[i][j].dessinerObjet(g);
			}	
		}
		for(Neuneu lofter:this.population){
			lofter.dessinerObjet(g);
		}
		zone.validate();
	
	}
}
