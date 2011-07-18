package authentification;

import java.awt.*;
import javax.swing.*;
/**
*
* @author Administrateur
*/
public class Deconnexion {
JProgressBar progress;
Thread monThread;
int rappidite;
JFrame cadre;
public static void main(String[] args){
	Deconnexion prgs= new Deconnexion();
prgs.go(50);
}
public void go(int rappid){
rappidite=rappid;
// Création de l'interface
cadre = new JFrame("Déconnexion en cours...");
Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
cadre.setLocation((screen.width - cadre.getSize().width)/2,(screen.height - cadre.getSize().height)/2);
cadre.setIconImage(Toolkit.getDefaultToolkit().getImage("/images/ucad.jpg"));
JPanel panneau = new JPanel();
JLabel texte = new JLabel("Merci d'avoir utilisé cette application ");
progress = new JProgressBar(0, 100);
panneau.add("Center", progress);
panneau.add("Center", texte);
cadre.getContentPane().add(BorderLayout.CENTER, panneau);
cadre.setSize(275,115);
cadre.setVisible(true);
cadre.setResizable(false);
cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Création de thread
monThread= new Thread(new MonRunnable());
monThread.start();
}
public class MonRunnable implements Runnable{
public void run(){
// on fait une boucle pour que la JProgressBar "avance"
for (int j = 100; j >=1; j--){
progress.setValue(j);
progress.setString(j+" %");
progress.setStringPainted(true);
try{
Thread.sleep(rappidite);
}
catch(Exception e){
e.printStackTrace();
}
}
//on ferme le cadre (le chargement est fini!)
cadre.dispose();
System.exit(0);}
}
}
