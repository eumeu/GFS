package menu;

import java.awt.BorderLayout;


import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

import javax.swing.JOptionPane;
import menu.*;


public class MenuAgen extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel PANO = null;

	private JButton valide_paiement = null;

	private JButton liste_paiement = null;

	private JLabel logo = null;

	private JButton quitter = null;

	//private JButton cherchEtPaye = null;

	private JLabel valier = null;

	private JLabel AFF = null;

	private JLabel valier1 = null;

	private JLabel XX = null;

	private JLabel XX1 = null;

	private JLabel XX2 = null;

	private JLabel cc = null;

	private JPanel panA1 = null;

	private JPanel panA11 = null;

	//déclaration des fenêtres
	private MenuAdministra menuAdmin = new MenuAdministra();
	/**
	 * This is the default constructor
	 */
	public MenuAgen() {
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
		this.setSize(1300,800);
		this.setContentPane(getJContentPane());
		Image icone = Toolkit.getDefaultToolkit().getImage("images/ucad.jpg");
		this.setIconImage(icone);
		this.setTitle("Menu Comptable");
		setVisible(true);
		menuAdmin.setVisible(false);
	}
	
	
	
	public void afficher(){
		int b=0;
	
		String a=JOptionPane.showInputDialog(null,"Donner le numero de l'etudiant !");
		//String c=JOptionPane.showInputDialog(null,"donner la classe de l'etudiant dont vous voulez valider son paiement");
		
		try
		{
			Statement state = authentification.Connect.getInstance()
			.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY
			);				
			String req="select * from etudiant  ";
			ResultSet rs=state.executeQuery(req);
			while(rs.next())
			{
				if(a.equals(rs.getString("numero")))
				{
					b=1;
				
					
				
				paiement.Agent_formpaiement tr=new paiement.Agent_formpaiement();
				tr.txtnum.setText(rs.getString("numero").toString());
				tr.txtnom.setText(rs.getString("nom").toString());
				tr.txtprenom.setText(rs.getString("prenom").toString());
				tr.txtdatenaisse.setText(rs.getString("datenais").toString());
				tr.txtlieunaisse.setText(rs.getString("lieunais").toString());
				tr.txtnationalite.setText(rs.getString("nationalite").toString());
				tr.txtclasse.setText(rs.getString("classe").toString());
				tr.ZZZZ.setEnabled(false);
				//this.dispose();
				
				}	
				}
				
				
					
				
			
			rs.close();
			state.close();
			if(b==0)JOptionPane.showMessageDialog(null, "numero n'existe pas dans la base");
	}
				
		
	
			
	catch(SQLException se){
		System.out.println("connexion impossible"+se.getMessage());
		
	}
		
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		
			if(e.getSource()==valide_paiement )
			{
				afficher();
				this.dispose();
			}
			
			if(e.getSource()==liste_paiement )
			{
				paiement.DatePayement	c=	new paiement.DatePayement();
				c.mois.setEnabled(false);
				c.txtclasse.setEnabled(false);
				c.etnonpayer.setEnabled(false);
				c.etpayer.setEnabled(false);
				this.dispose();

			}
	if(e.getSource()==quitter )
	{
		this.dispose();		
		menuAdmin.setVisible(true);
	}
	//if(e.getSource()==cherchEtPaye ){
	
		/*
		DatePayement	c=	new DatePayement();
		c.txtnum.setEnabled(true);
		c.mois.setEnabled(false);
		c.txtclasse.setEnabled(false);
		c.etnonpayer.setEnabled(false);
		
	c.etpayer.setEnabled(false);
*/
	//new paiement.Etupayer();
		//this.dispose();

	//}
	
	
		}

	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			cc = new JLabel();
			cc.setBounds(new Rectangle(3, -2, 1284, 94));
			//cc.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/CHARGE.jpg")));
			cc.setText(" ");
			XX2 = new JLabel();
			XX2.setBounds(new Rectangle(454, 413, 17, 16));
			XX2.setText(" ");
			XX2.setIcon(new ImageIcon("images/nextdown.jpg"));
			//XX1 = new JLabel();
			//XX1.setBounds(new Rectangle(453, 365, 16, 16));
			//XX1.setText(" ");
		//	XX1.setIcon(new ImageIcon("images/btn1.gif"));
			XX = new JLabel();
			XX.setBounds(new Rectangle(453, 314, 14, 16));
			XX.setIcon(new ImageIcon("images/nextdown.jpg"));
			XX.setText(" ");
			valier1 = new JLabel();
			valier1.setBounds(new Rectangle(27, 411, 424, 20));
			valier1.setFont(new Font("Elephant", Font.BOLD, 12));
			valier1.setBackground(Color.black);
			valier1.setForeground(Color.black);
			valier1.setText("Pour afficher Paiement d'un etudiant  a partir d'un numero :");
			//AFF = new JLabel();
			//AFF.setBounds(new Rectangle(27, 362, 385, 19));
			//AFF.setFont(new Font("Elephant", Font.BOLD, 12));
			//AFF.setBackground(Color.black);
			//AFF.setForeground(Color.black);
			//AFF.setText("Pour afficher Liste des Paiements d'une classe donnee  :");
			valier = new JLabel();
			valier.setBounds(new Rectangle(29, 309, 386, 22));
			valier.setFont(new Font("Elephant", Font.BOLD, 12));
			valier.setBackground(Color.black);
			valier.setForeground(Color.black);
			valier.setText("Pour afficher Liste des Paiements d'une classe donnee  : ");
			logo = new JLabel();
			logo.setBounds(new Rectangle(558, 111, 177, 163));
			logo.setIcon(new ImageIcon("images/ucad.jpg"));
			logo.setText("");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
		//	jContentPane.setBackground(SystemColor.info);
			jContentPane.add(getPANO(), null);
			jContentPane.add(logo, null);
			jContentPane.add(getQuitter(), null);
			jContentPane.add(valier, null);
			//jContentPane.add(AFF, null);
			jContentPane.add(valier1, null);
			jContentPane.add(XX, null);
			//jContentPane.add(XX1, null);
			jContentPane.add(XX2, null);
			jContentPane.add(cc, null);
			jContentPane.add(getPanA1(), null);
			jContentPane.add(getPanA11(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes PANO	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPANO() {
		if (PANO == null) {
			PANO = new JPanel();
			PANO.setLayout(null);
			PANO.setBounds(new Rectangle(529, 284, 257, 205));
			//PANO.setBackground(Color.cyan);
			PANO.add(getValide_paiement(), null);
			PANO.add(getListe_paiement(), null);
		//	PANO.add(getCherchEtPaye(), null);
		}
		return PANO;
	}

	/**
	 * This method initializes valide_paiement	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getValide_paiement() {
		if (valide_paiement == null) {
			valide_paiement = new JButton();
			valide_paiement.setBounds(new Rectangle(25, 19, 200, 34));
			valide_paiement.setFont(new Font("Elephant", Font.BOLD, 14));
			valide_paiement.setText("Valider Paiement");
			valide_paiement.addActionListener(this);
		}
		return valide_paiement;
	}

	/**
	 * This method initializes liste_paiement	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getListe_paiement() {
		if (liste_paiement == null) {
			liste_paiement = new JButton();
			liste_paiement.setBounds(new Rectangle(27, 126, 202, 31));
			liste_paiement.setFont(new Font("Elephant", Font.BOLD, 14));
			liste_paiement.setText("Liste des Paiements");
			liste_paiement.addActionListener(this);
		}
		return liste_paiement;
	}

	/**
	 * This method initializes quitter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getQuitter() {
		if (quitter == null) {
			quitter = new JButton();
			quitter.setBounds(new Rectangle(1046, 624, 171, 35));
			quitter.setText("Quitter");
			//quitter.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/quitter.gif")));
			quitter.setIcon(new ImageIcon("images/quitter.gif"));

			quitter.setFont(new Font("Elephant", Font.BOLD, 14));
	        quitter.addActionListener(this);
		}
		return quitter;
	}

	/**
	 * This method initializes cherchEtPaye	
	 * 	
	 * @return javax.swing.JButton	
	
	private JButton getCherchEtPaye() {
		//if (cherchEtPaye == null) {
			//cherchEtPaye = new JButton();
			//cherchEtPaye.setText("Chercher_Par Etud");
			//cherchEtPaye.setBounds(new Rectangle(27, 126, 202, 31));
			//cherchEtPaye.setFont(new Font("Elephant", Font.BOLD, 14));
			//cherchEtPaye.addActionListener(this);
		//}
		//return cherchEtPaye;
	}

	/**Etudiant
	 * This method initializes panA1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanA1() {
		if (panA1 == null) {
			panA1 = new JPanel();
			panA1.setLayout(null);
			panA1.setBounds(new Rectangle(5, 92, 1281, 17));
			panA1.setBackground(Color.black);
		}
		return panA1;
	}

	/**
	 * This method initializes panA11	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanA11() {
		if (panA11 == null) {
			panA11 = new JPanel();
			panA11.setLayout(null);
			panA11.setBounds(new Rectangle(1, 274, 1280, 10));
			panA11.setBackground(Color.black);
		}
		return panA11;
	}

}  //  @jve:decl-index=0:visual-constraint="-13,-18"

