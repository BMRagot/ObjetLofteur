/**
 * 1 oct. 2012
 * Neuneu.java
 */

/**
 * @author bastienmarichalragot
 *
 */
public abstract class Neuneu {
    
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
    
    public Neuneu seReproduire(Neuneu partenaire){
       //TODO a completer
    	this.setEnergie(this.getEnergie()-50);
        partenaire.setEnergie(partenaire.getEnergie()-50);
        //...
    }
    
    public void donnerEnergie(Neuneu lofteur){
    	//TODO a completer
    }
    
    public void cycleDeVie(){
    	//TODO : deplacer puis manger puis reproduire??? 
    	// privilegier la reproductoion?
    	// consideration de l'energie restante les neuneus sont fleimard..
    	// puis mort
    	
    }

}
