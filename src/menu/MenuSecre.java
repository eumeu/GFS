package menu;

//import java.awt.BorderLayout;


import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.WindowConstants;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;

import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;

import menu.MenuAdministra;


public class MenuSecre extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel menu_etudiant = null;

	private JPanel PANO = null;

	private JButton saisie_etudiant = null;


	private JLabel logo = null;

	private JButton quitter = null;

	private JButton majetu = null;
	
	private JLabel valier = null;
	
	private JLabel valier1 = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	private JLabel jLabel3 = null;
	
	private JLabel valierbutton = null;
	
	private JLabel valier1button = null;

	private JLabel jLabel31 = null;

	private JPanel panA1 = null;

	private JPanel panA11 = null;
	
	private JButton cherchEtPaye = null;
	
	private JButton valide_paiement = null;
	
	private MenuAdministra menuAdmin = new MenuAdministra();

	/**
	 * This is the default constructor
	 */
	
	
	public MenuSecre() {
		super();
		initialize();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void//
	 */
	private void initialize() {
		this.setSize(1400,900);
		this.setContentPane(getJContentPane());
		this.setTitle("Menu Secretaire");
		setVisible(true);
		menuAdmin.setVisible(false);
	}
	
	
	
	
	public void afficher(){
		int b=0;
	
		String a=JOptionPane.showInputDialog(null,"donner le numero de l'etudiant !");
		
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
				paiement.FormPayement tr=new paiement.FormPayement();
				tr.txtnum.setText(rs.getString("numero").toString());
				tr.txtnom.setText(rs.getString("nom").toString());
				tr.txtprenom.setText(rs.getString("prenom").toString());
				tr.txtdatenaisse.setText(rs.getString("datenais").toString());
				tr.txtlieunaisse.setText(rs.getString("lieunais").toString());
				tr.txtnationalite.setText(rs.getString("nationalite").toString());
				tr.txtclasse.setText(rs.getString("classe").toString());
				tr.ZZZZ.setEnabled(false);
				
				}	
				}
				
				
			rs.close();
			state.close();
			if(b==0)JOptionPane.showMessageDialog(null, "numero n'existe pas dans la base");
	}
				
		
	
			
	catch(SQLException se){
		System.out.println("Connexion Impossible"+se.getMessage());
		
	}
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==majetu){
			etudiant.MajEt b=	new etudiant.MajEt();
			this.dispose();

			b.modifier.setEnabled(false);
			b.supprimer.setEnabled(false);
			b.valider.setEnabled(false);
			b.txtnum.setEnabled(false);
			b.txtnom.setEnabled(false);
			b.txtprenom.setEnabled(false);
			b.txtdatenaisse.setEnabled(false);
			b.txtlieunaisse.setEnabled(false);
			b.txtnationalite.setEnabled(false);
			b.txtadresse.setEnabled(false);
			b.txtdate.setEnabled(false);
			b.txtclasse.setEnabled(false);
			b.txtmontant.setEnabled(false);
			
		}
		if(e.getSource()==saisie_etudiant){
			new etudiant.FormInscription();
			this.dispose();

		}
		
		if(e.getSource()==valide_paiement )
		{
			afficher();
			this.dispose();
		}
		
		if(e.getSource()==cherchEtPaye ){
			
			new paiement.Etupayer();
			this.dispose();

		}
		if(e.getSource()==quitter){
			this.dispose();
			menuAdmin.setVisible(true);
		}
	}
	
	
	
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(460, 304, 33, 22));
			jLabel3.setIcon(new ImageIcon("images/nextdown.jpg"));
			jLabel3.setText(" ");
			
			
			jLabel31 = new JLabel();
			jLabel31.setBounds(new Rectangle(462, 349, 31, 24));
			jLabel31.setText(" ");
			jLabel31.setIcon(new ImageIcon("images/nextdown.jpg"));
			
			
			valierbutton = new JLabel();
			valierbutton.setBounds(new Rectangle(462, 440, 31, 24));
			valierbutton.setText(" ");
			valierbutton.setIcon(new ImageIcon("images/nextdown.jpg"));
			
			valier1button = new JLabel();
			valier1button.setBounds(new Rectangle(462, 500, 31, 24));
			valier1button.setText(" ");
			valier1button.setIcon(new ImageIcon("images/nextdown.jpg"));

			
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(108, 305, 350, 21));
			jLabel.setForeground(Color.black);
			jLabel.setText("Inscrire un etudiant ");
			
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(107, 353, 352, 21));
			jLabel1.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel1.setForeground(Color.black);
			jLabel1.setText("Editer infos etudiant ");
			
			valier = new JLabel();
			valier.setBounds(new Rectangle(108, 451, 353, 22));
			valier.setFont(new Font("Elephant", Font.BOLD, 12));
			valier.setBackground(Color.black);
			valier.setForeground(Color.black);
			valier.setText("Pour valider paiement etudiant  : ");
			
			
			valier1 = new JLabel();
			valier1.setBounds(new Rectangle(109, 500, 347, 21));
			valier1.setFont(new Font("Elephant", Font.BOLD, 12));
			valier1.setBackground(Color.black);
			valier1.setForeground(Color.black);
			valier1.setText("Pour afficher Paiement d'un etudiant :");
			
			
			logo = new JLabel();
			logo.setBounds(new Rectangle(556, 97, 177, 163));
			logo.setIcon(new ImageIcon("images/ucad.jpg"));
			logo.setText("");
			
			
			menu_etudiant = new JLabel();
			menu_etudiant.setBounds(new Rectangle(556, 97, 177, 163));
			menu_etudiant.setFont(new Font("Elephant", Font.BOLD, 18));
			

			menu_etudiant.setText("");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(menu_etudiant, null);
			jContentPane.add(getPANO(), null);
			jContentPane.add(logo, null);
			jContentPane.add(getQuitter(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel31, null);
			jContentPane.add(valier, null);
			jContentPane.add(valier1, null);
			jContentPane.add(valier1button, null);
			jContentPane.add(valierbutton, null);
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
			PANO.setBounds(new Rectangle(526, 272, 257, 268));
			PANO.add(getSaisie_etudiant(), null);
			PANO.add(getMajetu(), null);
			PANO.add(getValide_paiement(), null);
			PANO.add(getCherchEtPaye(), null);
		}
		return PANO;
	}

	
	/**
	 * This method initializes saisie_etudiant	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSaisie_etudiant() {
		if (saisie_etudiant == null) {
			saisie_etudiant = new JButton();
			saisie_etudiant.setBounds(new Rectangle(12, 25, 232, 31));
			saisie_etudiant.setFont(new Font("Elephant", Font.BOLD, 14));
			saisie_etudiant.setIcon(new ImageIcon("images/enregistrer.gif"));

			saisie_etudiant.setForeground(Color.black);
			saisie_etudiant.setText("Saisie Etudiant");
			saisie_etudiant.addActionListener(this);
		}
		return saisie_etudiant;
	}
	/**
	 * This method initializes majetu	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getMajetu() {
		if (majetu == null) {
			majetu = new JButton();
			majetu.setBounds(new Rectangle(11, 74, 232, 29));
			majetu.setText("Editer etudiant");
			majetu.setIcon(new ImageIcon("images/modifier.gif"));

			majetu.setForeground(Color.black);
			majetu.setFont(new Font("Elephant", Font.BOLD, 14));
			majetu.addActionListener(this);
		}
		return majetu;
	}

	/**
	 * This method initializes valide_paiement	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getValide_paiement() {
		if (valide_paiement == null) {
			valide_paiement = new JButton();
			valide_paiement.setBounds(new Rectangle(14, 168, 233, 28));
			valide_paiement.setFont(new Font("Elephant", Font.BOLD, 14));
			valide_paiement.setText("Valider Paiement");
			valide_paiement.addActionListener(this);
		}
		return valide_paiement;
	}
	
	/**
	 * This method initializes cherchEtPaye	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCherchEtPaye() {
		if (cherchEtPaye == null) {
			cherchEtPaye = new JButton();
			cherchEtPaye.setText("Chercher par etudiant");
			cherchEtPaye.setBounds(new Rectangle(14, 215, 237, 29));
			cherchEtPaye.setFont(new Font("Elephant", Font.BOLD, 14));
			cherchEtPaye.addActionListener(this);
		}
		return cherchEtPaye;
	}
	/**
	 * This method initializes quitter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getQuitter() {
		if (quitter == null) {
			quitter = new JButton();
			quitter.setBounds(new Rectangle(1050, 586, 172, 29));
			quitter.setText("Quitter");
			quitter.setIcon(new ImageIcon("images/quitter.gif"));
			quitter.setFont(new Font("Elephant", Font.BOLD, 14));
	        quitter.addActionListener(this);
		}
		return quitter;
	}

	
	/**
	 * This method initializes panA1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanA1() {
		if (panA1 == null) {
			panA1 = new JPanel();
			panA1.setLayout(null);
			panA1.setBounds(new Rectangle(2, 86, 1282, 10));
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
			panA11.setBounds(new Rectangle(1, 261, 1281, 10));
			panA11.setBackground(Color.black);
		}
		return panA11;
	}

} 


