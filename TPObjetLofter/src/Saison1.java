import java.util.ArrayList;



public class Saison1 {

	public static int nombreLofteurs = 5;
	public static int largeur= 30;
	public static int hauteur= 30;
	public static float proportionErratique = 0.3f;
	public static float proportionVorace = 0.4f;
	public static float proportionCannibale = 0.2f;
	public static float proportionLapin = 0.1f;

	public ArrayList<Neuneu> pop;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Saison1().primeTime();
	}
	
	public void primeTime() {
		ZoneGraphique zone = new ZoneGraphique("Mon premier loft",largeur,hauteur);
		
		//loft.remplissageAleatoire(0.1f);
		//zone.ajouterObjet(loft);
		//TODO corriger la positoon des neuneus avec  la largeur et la hauteur come paramtetre
		pop=new ArrayList<Neuneu>();
		Loft loft = new Loft(largeur,hauteur,pop,zone);
		
		for (int i=0 ; i<nombreLofteurs ; i++) {
			double x = Math.random();
			if (x<proportionVorace) {
				loft.ajouterNeuneu(new Vorace(Name.values()[(int)(Math.random()*22)].getNom(), loft.getTerrain()[(int)(Math.random()*largeur)][(int)(Math.random()*hauteur)],loft));
			}
			else {
				x -= proportionVorace;
				if (x<proportionErratique) {
					loft.ajouterNeuneu((new Erratique(Name.values()[(int)(Math.random()*22)].getNom(), loft.getTerrain()[(int)(Math.random()*largeur)][(int)(Math.random()*hauteur)],loft)));
				}
				else {
					x -= proportionErratique;
					if (x<proportionCannibale) {
						loft.ajouterNeuneu(new Cannibale(Name.values()[(int)(Math.random()*22)].getNom(), loft.getTerrain()[(int)(Math.random()*largeur)][(int)(Math.random()*hauteur)],loft));
					}
					else{
						x -= proportionCannibale;
						if (x<proportionLapin) {
							loft.ajouterNeuneu(new Lapin(Name.values()[(int)(Math.random()*22)].getNom(), loft.getTerrain()[(int)(Math.random()*largeur)][(int)(Math.random()*hauteur)],loft));
						}
					}
				}
			}
		}
		// ajout de la population au loft
		loft.setPopulation(pop);
		// lancement du cylce de vie du loft
		loft.cycleDeVie();
	}

}
