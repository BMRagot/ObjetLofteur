import java.util.ArrayList;



public class Saison1 {

	public static int nombreLofteurs = 15;
	public static int largeur= 30;
	public static int hauteur= 30;
	public static float proportionErratique = .75f;
	public static float proportionVorace = .25f;
	public static float proportionCannibale = 0f;
	public ArrayList<Neuneu> pop;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Saison1().primeTime();
	}
	
	public void primeTime() {
		ZoneGraphique zone = new ZoneGraphique("Mon premier loft");
		
		//loft.remplissageAleatoire(0.1f);
		//zone.ajouterObjet(loft);
		
		pop=new ArrayList<Neuneu>();
		Loft loft = new Loft(largeur,hauteur,pop);
		
		for (int i=0 ; i<nombreLofteurs ; i++) {
			double x = Math.random();
			if (x<proportionVorace) {
				pop.add(new Vorace(Name.values()[(int)(Math.random()*5)].getNom(), loft.getTerrain()[(int)(Math.random()*29)][(int)(Math.random()*29)],loft));
			}
			else {
				x -= proportionVorace;
				if (x<proportionErratique) {
					pop.add(new Erratique(Name.values()[(int)(Math.random()*5)].getNom(), loft.getTerrain()[(int)(Math.random()*29)][(int)(Math.random()*29)],loft));
				}
				else {
					x -= proportionErratique;
					if (x<proportionCannibale) {
						pop.add(new Cannibale(Name.values()[(int)(Math.random()*5)].getNom(), loft.getTerrain()[(int)(Math.random()*29)][(int)(Math.random()*29)],loft));
					}
				}
			}
		}
		loft.setPopulation(pop);
		zone.ajouterObjet(loft);
		
		loft.cycleDeVie();
	}

}
