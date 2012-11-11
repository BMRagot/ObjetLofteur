/**
 * 1 oct. 2012
 * Neuneu.java
 * @author bastien marichal-ragot & antoine veron
 */

/**
 * Classe abstraite Neuneu herite de Commestible
 * 
 * @author bastien marichal-ragot & antoine veron
 *
 */
public abstract class Neuneu extends Commestible{
    
    //Attributs
    protected String nom;
    protected Case position;
    protected int energie;
    protected Loft environnement;
    protected String type;
    
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
    
    //MÃ©thodes

    /**
     * @return l'energie d'un neuneu
     */
    public int getEnergie() {
        return energie;
    }
    /**
     * 
     * @param energie ˆ donner au neuneu
     */
    public void setEnergie(int energie) {
        this.energie = energie;
    }
    /**
     * 
     * @return retourne l'environnement du lofteur
     */
    public Loft getEnvironnement() {
        return environnement;
    }
    /**
     * 
     * @param environnement
     */
    public void setEnvironnement(Loft environnement) {
        this.environnement = environnement;
    }
    /**
     * 
     * @return nom du neuneu
     */
    public String getNom() {
        return nom;
    }
    /**
     * 
     * @param nom ˆ donner au neuneu
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * 
     * @return la case ou se situe ce neuneu
     */
    public Case getPosition() {
        return position;
    }
    /**
     * 
     * @param position o placer ce neuneu
     */
    public void setPosition(Case position) {
        this.position = position;
    }
    /**
     * mŽthode abstraite definit dans les classes filles pour le deplacement des neuneus
     */
    public abstract void seDeplacer();
    /**
     * methode abstraite definit dans les classes filles pour l'alimentation des neuneus
     * @param nourriture
     */
    public abstract void manger(Commestible nourriture);
    /**
     * methode de reproduction des neuneus
     * @param partenaire avec qui se reproduire
     */
    public void seReproduire(Neuneu partenaire){
       /* if ((this.getEnergie()>50)&&(partenaire.getEnergie()>50)){
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
	        
			
        }*/
    }
    /**
     * methode de transfert d'energie
     */
    public void donneEnergie(Neuneu lofteur){
		lofteur.setEnergie(lofteur.getEnergie()+ this.getEnergie());
    }
    /**
     * methode de cycleDeVie
     */
    public void cycleDeVie(){
    	
    }
    /**
     * methode qui renvoie la race de neuneu
     * @return la race du neuneu
     */
    public String getRace(){
		return type;
    	
    }
}
