/**
 * 1 oct. 2012
 * Neuneu.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public abstract class Neuneu implements Commestible{
    
    //Attributs
    protected String nom;
    protected Case position;
    protected int energie;
    protected Loft environnement;
    
    /**
     * Constructor
     * @param nom
     * @param position
     * @param environnement
     */
    public Neuneu(String nom, Case position, Loft environnement){
        this.environnement=environnement;
        this.nom=new String(nom);
        this.position=position;
        this.energie=100;
    }
    
    //Méthodes

    /**
     * @return
     */
    public int getEnergie() {
        return energie;
    }

    public void setEnergie(int energie) {
        this.energie = energie;
    }

    public Loft getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(Loft environnement) {
        this.environnement = environnement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }
    
    public abstract void seDeplacer();
    
    public abstract void manger(Commestible nourriture);
    
    public void seReproduire(Neuneu partenaire){
        if ((this.getEnergie()>50)&&(partenaire.getEnergie()>50)){
	    	this.setEnergie(this.getEnergie()-50);
	        partenaire.setEnergie(partenaire.getEnergie()-50);
	        
	        String nom = new String((this.getNom().substring(0, (int)(this.getNom().length()/2)))
	        						+partenaire.getNom().substring((int)(partenaire.getNom().length()/2)));
	        
	        int genome=(int)(Math.random() * (4));
	        
	        int a= this.position.getPositionx();
			int b= this.position.getPositiony();
		
			while (a<0 && a>this.environnement.largeur){
				a=a +(int)(Math.random() * (3)) - 1;
			}
			while(b<0 && b>this.environnement.hauteur){
				b=b+(int)(Math.random() * (3)) - 1;
			}
			
	        if (genome==0){
	        	Neuneu nouveauNe= new Cannibale(nom,this.getEnvironnement().getTerrain()[a][b],this.environnement); 
	        	environnement.ajouterNeuneu(nouveauNe);
	        }
	        else if(genome==1){
	        	Neuneu nouveauNe= new Erratique(nom,this.getEnvironnement().getTerrain()[a][b],this.environnement);
	        	environnement.ajouterNeuneu(nouveauNe);
	        }
	        else if(genome==2){
	        	Neuneu nouveauNe= new Lapin(nom,this.getEnvironnement().getTerrain()[a][b],this.environnement);
	        	environnement.ajouterNeuneu(nouveauNe);
	        }
	        else{
	        	Neuneu nouveauNe= new Vorace(nom,this.getEnvironnement().getTerrain()[a][b],this.environnement);
	        	environnement.ajouterNeuneu(nouveauNe);
	        }
	        
			
        }
    }
    
    public void donneEnergie(Neuneu lofteur){
		lofteur.setEnergie(lofteur.getEnergie()+ this.getEnergie());
    }
    
    public void cycleDeVie(){
    	
    }

}
