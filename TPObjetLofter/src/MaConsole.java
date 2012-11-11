import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class MaConsole extends JFrame {
	
	private JLabel Texte1;
	private JLabel Texte2;
	private JLabel Texte3;
	private JLabel Texte4;
	private JLabel Texte5;
	private JLabel Texte6;

	private JLabel Texte7;
	private JLabel Texte8;
	private JLabel Texte9;
	private JLabel Texte10;
	private JLabel Texte11;
	private JLabel Texte12;

	
	private Container contenu;

	
	public MaConsole(int NbJour, Loft l){
		
		setTitle("Mon Loft");
		setBounds(0,0,250,250) ;
		contenu = getContentPane(); 
		contenu.setLayout(null);

		
		Texte1=new JLabel("Jour: "+NbJour);
		contenu.add(Texte1);
		Texte1.setBounds(10, 10, 100, 30) ;
		
		Texte2=new JLabel("Nombre de Neuneus: " + l.getPopulation().size());
		contenu.add(Texte2);
		Texte2.setBounds(10, 30, 300, 30);
		
		int nbErr=0;
		int nbVor=0;
		int nbCan=0;
		int nbLap=0;
		
		for(Neuneu n:l.getPopulation()){
			if(n.getRace().equals("Erratique")){
				nbErr = nbErr + 1;
			}else if (n.getRace().equals("Vorace")){
				nbVor = nbVor + 1;
			}else if (n.getRace().equals("Cannibale")){
				nbCan = nbCan + 1;
			}else if (n.getRace().equals("Lapin")){
				nbLap = nbLap + 1;
			}
		}
		
		
		Texte3=new JLabel("Nombre de Erratiques: " + nbErr);
		contenu.add(Texte3);
		Texte3.setBounds(20, 50, 300, 30);
		
		Texte4=new JLabel("Nombre de Voraces: " + nbVor);
		contenu.add(Texte4);
		Texte4.setBounds(20, 70, 300, 30);
		
		Texte5=new JLabel("Nombre de Cannibales: " + nbCan);
		contenu.add(Texte5);
		Texte5.setBounds(20, 90, 300, 30);
		
		Texte6=new JLabel("Nombre de Lapins: " + nbLap);
		contenu.add(Texte6);
		Texte6.setBounds(20, 110, 300, 30);
		
		Texte7=new JLabel("Tour: ");
		contenu.add(Texte7);
		Texte7.setBounds(20, 140, 300, 30);
	
		Texte8=new JLabel();
		Texte9=new JLabel();
		Texte10=new JLabel();
		contenu.add(Texte8);
		contenu.add(Texte9);
		contenu.add(Texte10);
		
		contenu.validate();
		
		this.setVisible(true);
	}
	
	public void update(int NbJour, Loft l,int i){
		
		contenu.remove(Texte1);
		contenu.remove(Texte2);
		contenu.remove(Texte3);
		contenu.remove(Texte4);
		contenu.remove(Texte5);
		contenu.remove(Texte6);
		contenu.remove(Texte8);
		contenu.remove(Texte9);
		contenu.remove(Texte10);
		
		
		
		Texte1=new JLabel("Jour: "+NbJour,(int) CENTER_ALIGNMENT);
		contenu.add(Texte1);
		Texte1.setBounds(10, 10, 100, 30) ;
		
		Texte2=new JLabel("Nombre de Neuneus: " + l.getPopulation().size());
		contenu.add(Texte2);
		Texte2.setBounds(10, 30, 300, 30);
		
		int nbErr=0;
		int nbVor=0;
		int nbCan=0;
		int nbLap=0;
		
		for(Neuneu n:l.getPopulation()){
			if(n.getRace().equals("Erratique")){
				nbErr = nbErr + 1;
			}else if (n.getRace().equals("Vorace")){
				nbVor = nbVor + 1;
			}else if (n.getRace().equals("Cannibale")){
				nbCan = nbCan + 1;
			}else if (n.getRace().equals("Lapin")){
				nbLap = nbLap + 1;
			}
		}
		
		
		Texte3=new JLabel("Nombre de Erratiques: " + nbErr);
		contenu.add(Texte3);
		Texte3.setBounds(20, 50, 300, 30);
		
		Texte4=new JLabel("Nombre de Voraces: " + nbVor);
		contenu.add(Texte4);
		Texte4.setBounds(20, 70, 300, 30);
		
		Texte5=new JLabel("Nombre de Cannibales: " + nbCan);
		contenu.add(Texte5);
		Texte5.setBounds(20, 90, 300, 30);
		
		Texte6=new JLabel("Nombre de Lapins: " + nbLap);
		contenu.add(Texte6);
		Texte6.setBounds(20, 110, 300, 30);
		
		Texte8=new JLabel("Le " + l.getPopulation().get(i).getRace() + ", "+ l.getPopulation().get(i).getNom() + " joue :");
		contenu.add(Texte8);
		Texte8.setBounds(30, 160, 300, 30);
		
		Texte9=new JLabel("Position : X: " + l.getPopulation().get(i).getPosition().getPositionx() +" ; Y: "+l.getPopulation().get(i).getPosition().getPositiony());
		contenu.add(Texte9);
		Texte9.setBounds(40, 180, 300, 30);
		
		Texte10=new JLabel("Energie: "+ l.getPopulation().get(i).getEnergie());
		contenu.add(Texte10);
		Texte10.setBounds(40, 200, 300, 30);
		
		
		
		contenu.validate();
		
		
	}

}
