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
    
    //M√©thodes

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
    
    public Neuneu seReproduire(Neuneu partenaire){
       //TODO a completer
    	this.setEnergie(this.getEnergie()-50);
        partenaire.setEnergie(partenaire.getEnergie()-50);
        //...
        Neuneu nouveauNe= new Neuneu();
        environnement.ajouterNeuneu(nouveauNe);
        return nouveauNe; 
        
    }
    
    public void donneEnergie(Neuneu lofteur){
    	//TODO a modifier 
    	//energie canibalisme es de combien l'energie du bouffé?
		lofteur.setEnergie(lofteur.getEnergie()+ 50);
    }
    
    public void cycleDeVie(){
    	//TODO : deplacer puis manger puis reproduire??? 
    	// privilegier la reproductoion?
    	// consideration de l'energie restante les neuneus sont fleimard..
    	// puis mort
    	
    }

}
