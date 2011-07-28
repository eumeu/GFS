package paiement;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.event.*;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import menu.*;


public class AffPaiement extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JPanel pano = null;

	private JLabel num = null;

	 JLabel txtrecu = null;

	private JLabel mois = null;

	private JLabel recude = null;

	 JLabel txtnom = null;

	 JLabel txtprenom = null;

	 JLabel txtmois = null;

	private JLabel lasommede = null;

	JLabel txtsomme = null;

	private JLabel cfca = null;

	private JLabel recue = null;

	private JButton quitter = null;
	
	//déclaration des fenêtres
	private MenuSecre menuSec = new MenuSecre();

	/**
	 * This is the default constructor
	 */
	public AffPaiement() {
		super();
		initialize();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(781, 288);
		this.setContentPane(getJContentPane());
		this.setTitle("Votre recu de Paiement");
	setVisible(true);
	menuSec.setVisible(false);

	}
public void actionPerformed(ActionEvent e){
	
	if(e.getSource()==quitter){
		this.dispose();
		menuSec.setVisible(true);

	}
}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			recue = new JLabel();
			recue.setBounds(new Rectangle(235, 0, 312, 33));
			recue.setForeground(Color.cyan);
			recue.setFont(new Font("Lucida Handwriting", Font.BOLD, 24));
			recue.setText("Recu de Paiement");
			txtsomme = new JLabel();
			txtsomme.setText(" ");
			txtsomme.setBounds(new Rectangle(336, 71, 83, 16));
			txtsomme.setForeground(Color.blue);
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(12, 42, 200, 202));
			jLabel.setText(" ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getPano(), null);
			jContentPane.add(recue, null);
			jContentPane.add(getQuitter(), null);
			setLocationRelativeTo(null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes pano	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPano() {
		if (pano == null) {
			cfca = new JLabel();
			cfca.setBounds(new Rectangle(418, 72, 83, 16));
			cfca.setText("FCFA");
			cfca.setForeground(Color.blue);
			lasommede = new JLabel();
			lasommede.setBounds(new Rectangle(230, 71, 106, 16));
			lasommede.setText("Somme de :");
			lasommede.setForeground(Color.blue);
			txtmois = new JLabel();
			txtmois.setBounds(new Rectangle(95, 71, 132, 16));
			txtmois.setText(" ");
			txtmois.setForeground(Color.blue);
			txtprenom = new JLabel();
			txtprenom.setBounds(new Rectangle(230, 42, 185, 16));
			txtprenom.setText(" ");
			txtprenom.setForeground(Color.blue);
			txtnom = new JLabel();
			txtnom.setBounds(new Rectangle(95, 42, 134, 16));
			txtnom.setText(" ");
			txtnom.setForeground(Color.blue);
			recude = new JLabel();
			recude.setBounds(new Rectangle(10, 42, 72, 16));
			recude.setText("Recu de  :");
			recude.setForeground(Color.blue);
			mois = new JLabel();
			mois.setBounds(new Rectangle(9, 71, 85, 16));
			mois.setText(" Mois de  :");
			mois.setForeground(Color.blue);
			txtrecu = new JLabel();
			txtrecu.setBounds(new Rectangle(99, 15, 83, 16));
			txtrecu.setText(" ");
			txtrecu.setForeground(Color.blue);
			num = new JLabel();
			num.setBounds(new Rectangle(10, 14, 87, 16));
			num.setForeground(Color.blue);
			num.setText("Numero Recu :");
			pano = new JPanel();
			pano.setLayout(null);
			pano.setBounds(new Rectangle(215, 46, 539, 121));
			pano.add(num, null);
			pano.add(txtrecu, null);
			pano.add(mois, null);
			pano.add(recude, null);
			pano.add(txtnom, null);
			pano.add(txtprenom, null);
			pano.add(txtmois, null);
			pano.add(lasommede, null);
			pano.add(txtsomme, null);
			pano.add(cfca, null);
		}
		return pano;
	}

	/**
	 * This method initializes quitter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getQuitter() {
		if (quitter == null) {
			quitter = new JButton();
			quitter.setBounds(new Rectangle(624, 203, 125, 24));
			quitter.setIcon(new ImageIcon("images/quitter.gif"));
			quitter.setText("Quitter");
			quitter.addActionListener(this);
		}
		return quitter;
	}

}  //  @jve:decl-index=0:visual-constraint="81,18"
