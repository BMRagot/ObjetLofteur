

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.JFrame;

/**
 * une classe comportant une zone graphique dans laquelle on peut dessiner ;
 * le dessin est refait automatiquement par la classe Panel associée ; tous
 * les objets de type ObjetDessinable ajoutés à la liste sont redessinés par 
 * un appel à leur méthode dessinerObjet(Graphics g)
 * 
 * @see ObjectDessinable,LoftPanel
 * @author moreau
 *
 */
public class ZoneGraphique extends JFrame {

	/**
	 * la liste d'objets à dessiner
	 */
	LinkedList<ObjetDessinable> liste;
	
    public static final int PIXEL_SIZE = 20;

	
	/**
	 * constructeur
	 *
	 * @param titre le nom de l'application
	 */
	public ZoneGraphique(String titre,int largeur, int hauteur)  {
		// appel au constructeur de base
		super(titre);
		
		// ajout d'une taille par défaut
		setSize(largeur*PIXEL_SIZE,hauteur*PIXEL_SIZE);
		
		// création de la liste d'objets
		liste = new LinkedList<ObjetDessinable>();
		
		// ajout d'un listener
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0) ;
			}
	    	} ) ;

		// création du panneau
		LoftPanel a = new LoftPanel(liste);
		getContentPane().add(a);
		
		setVisible(true);
	}
	
	/**
	 * ajout d'un objet dans la zone graphique
	 */
	void ajouterObjet(ObjetDessinable o) {
		liste.add(o);
	}
	/**
	 * suppression @d'un objet dans la zone graphique
	 * @param o
	 */
	void supprimerObjet(ObjetDessinable o){
		liste.remove(o);
	}
	
	/**
	 * largeur de la partie dessinable
	 */
	public int getWidth() {
		return getContentPane().getWidth();
	}
	
	/**
	 * hauteur de la partie dessinable
	 */
	public int getHeight() {
		return getContentPane().getHeight();
	}
	
}
