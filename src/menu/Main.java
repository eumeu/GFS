package menu;

import javax.swing.SwingUtilities;

import java.awt.*;
import javax.swing.*;
public class Main
{
JProgressBar progress;
Thread monThread;
int rappidite;
JFrame cadre;
public static void main(String[] args)
{
Main prgs= new Main();
prgs.go(50);
}
public void go(int rappid)
{
rappidite=rappid;
// Création de l'interface
cadre = new JFrame("En cours de chargement");
JPanel panneau = new JPanel();
JLabel texte = new JLabel("Veuillez patienter pendant le chargement...");
progress = new JProgressBar(0, 100);
panneau.add("Center", progress);
panneau.add("Center", texte);
cadre.getContentPane().add(BorderLayout.CENTER, panneau);
cadre.setSize(275,85);
cadre.setVisible(true);
cadre.setResizable(false);
cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Création de thread
monThread= new Thread(new MonRunnable());
monThread.start();
}
public class MonRunnable implements Runnable
{
public void run()
{
for (int j = 1; j < 100; j++) // on fait une boucle pour que la JProgressBar "avance"
{
progress.setValue(j);
try
{
Thread.sleep(rappidite);
}
catch(Exception e)
{
e.printStackTrace();
}
}
cadre.dispose(); //on ferme le cadre (le chargement est fini!)
SwingUtilities.invokeLater(new Runnable() {
	public void run() {
		MenuGeneral application = new MenuGeneral();
		application.setVisible(true);
	}
});

}
}
} 