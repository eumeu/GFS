package menu;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Rectangle;
import javax.swing.JLabel;
//import javax.swing.ImageIcon;

//import authentification.AuthenEtu;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class MenuGeneral extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel LOGO = null;

	private JPanel PAN = null;

	private JButton EspEtudiant = null;

	private JButton Espadmin = null;

	private JButton quitter = null;

	private JLabel jLabel1 = null;

	private JLabel jLabel2 = null;

	private JLabel TITRE = null;

	private JLabel clss = null;

	private JPanel xxx = null;

	private JPanel imag = null;

	private JPanel imag1 = null;
	
	

	/**
	 * This is the default constructor
	 */
	public MenuGeneral() {
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
		this.setSize(1284, 795);
		this.setContentPane(getJContentPane());
		Image icone = Toolkit.getDefaultToolkit().getImage("images/ucad.jpg");
		this.setIconImage(icone);
		this.setTitle("Menu General");
	    
	}
public void actionPerformed(ActionEvent e){
	if(e.getSource()==Espadmin){
		new MenuAdministra();
		this.setVisible(false);
	}
	
	if(e.getSource()==EspEtudiant){
		new authentification.AuthenEtu();
		this.setVisible(false);
		
	}if(e.getSource()==quitter){
		int p=JOptionPane.showConfirmDialog(null,"Voulez-vous Quitter l'application?","Confirmation",JOptionPane.YES_NO_OPTION);
		if(p==0){
		this.dispose();
		authentification.Deconnexion prgs= new authentification.Deconnexion();
		prgs.go(50);
		} 

	}
}/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			clss = new JLabel();
			clss.setBounds(new Rectangle(1, 101, 1029, 115));
			clss.setText(" ");
			TITRE = new JLabel();
			TITRE.setBounds(new Rectangle(0, 0, 1268, 105));
			TITRE.setText("FST - Gestion des Fonctions de Services ");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(127, 136, 84, 96));
			jLabel2.setText(" ");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(16, 266, 66, 64));
			jLabel1.setText(" ");
			LOGO = new JLabel();
			LOGO.setBounds(new Rectangle(548, 228, 170, 157));
			LOGO.setIcon(new ImageIcon("images/ucad.jpg"));
			LOGO.setText(" ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(LOGO, null);
			jContentPane.add(getPAN(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(TITRE, null);
			jContentPane.add(clss, null);
			jContentPane.add(getXxx(), null);
			jContentPane.add(getImag(), null);
			jContentPane.add(getImag1(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes PAN	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPAN() {
		if (PAN == null) {
			PAN = new JPanel();
			PAN.setLayout(null);
			PAN.setBounds(new Rectangle(511, 400, 250, 268));
			PAN.add(getEspEtudiant(), null);
			PAN.add(getEspadmin(), null);
			PAN.add(getQuitter(), null);
		}
		return PAN;
	}

	/**
	 * This method initializes EspEtudiant	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getEspEtudiant() {
		if (EspEtudiant == null) {
			EspEtudiant = new JButton();
			EspEtudiant.setBounds(new Rectangle(21, 25, 207, 42));
			EspEtudiant.setFont(new Font("Elephant", Font.BOLD, 14));
			EspEtudiant.setForeground(Color.black);
			EspEtudiant.setText("Espace Etudiant");
			EspEtudiant.addActionListener(this);
		}
		return EspEtudiant;
	}

	/**
	 * This method initializes Espadmin	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getEspadmin() {
		if (Espadmin == null) {
			Espadmin = new JButton();
			Espadmin.setBounds(new Rectangle(23, 88, 204, 37));
			Espadmin.setFont(new Font("Elephant", Font.BOLD, 14));
			Espadmin.setForeground(Color.black);
			Espadmin.setText("Espace Administratif");
			Espadmin.addActionListener(this);
		}
		return Espadmin;
	}

	/**
	 * This method initializes quitter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getQuitter() {
		if (quitter == null) {
			quitter = new JButton();
			quitter.setBounds(new Rectangle(24, 149, 201, 36));
			quitter.setFont(new Font("Elephant", Font.BOLD, 14));
			quitter.setForeground(Color.black);
			quitter.setText("Quitter");
			quitter.addActionListener(this);
		}
		return quitter;
	}

	/**
	 * This method initializes xxx	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getXxx() {
		if (xxx == null) {
			xxx = new JPanel();
			xxx.setLayout(null);
			xxx.setBounds(new Rectangle(-2, 386, 1282, 10));
			xxx.setBackground(Color.black);
			xxx.add(jLabel2, null);
		}
		return xxx;
	}

	/**
	 * This method initializes imag	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getImag() {
		if (imag == null) {
			imag = new JPanel();
			imag.setLayout(null);
			imag.setBounds(new Rectangle(-1, 216, 1282, 10));
			imag.setBackground(Color.black);
		}
		return imag;
	}

	/**
	 * This method initializes imag1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getImag1() {
		if (imag1 == null) {
			imag1 = new JPanel();
			imag1.setLayout(null);
			imag1.setBounds(new Rectangle(-2, 386, 1282, 10));
			imag1.setBackground(Color.black);
		}
		return imag1;
	}

}  