package menu;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import javax.swing.JLabel;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.*;
import javax.swing.*;

import menu.MenuGeneral;


public class MenuAdministra extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;  //  @jve:decl-index=0:visual-constraint="10,10"

	private JLabel LOGO = null;

	private JPanel PANO = null;
	
	private JRadioButton secretaire = null;

	private JLabel secre = null;

	private JPanel pano2 = null;

	private JButton valid = null;

	private JButton annuler = null;

	private ButtonGroup  BAG=null;

	private JLabel agentc = null;

	private JRadioButton agentcompta = null;
	
	private JRadioButton administrateur = null;
	
	private JLabel admin = null;

	private JLabel jLabel = null;

	private JLabel cs = null;

	private JPanel panA = null;

	private JPanel panA1 = null;
	
	//déclaration des fenêtres
	
	private MenuGeneral menuGen = new MenuGeneral();
	/**
	 * This is the default constructor
	 */
	
	
	public MenuAdministra() {
		super();
		initialize();
		Image icone = Toolkit.getDefaultToolkit().getImage("images/ucad.jpg");
		this.setIconImage(icone);
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
		this.setTitle("Menu Administratif");
		setVisible(true);
		menuGen.setVisible(false);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==annuler){
			this.dispose();
			menuGen.setVisible(true);
		}
		if(e.getSource()==valid)
		{
			if(secretaire.isSelected()){
				//
				menuGen.setVisible(false);
				this.setVisible(false);
				new authentification.Authentification_secre();
			}
			
		
			
			
			if(agentcompta.isSelected()){
				menuGen.setVisible(false);
			    this.setVisible(false);
				new authentification.AuthenAgen();
				}
			
			if(administrateur.isSelected()){
				menuGen.setVisible(false);
			    this.setVisible(false);
				new authentification.AuthenAdmin();
				}
			
		
			
	}
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			cs = new JLabel();
			cs.setBounds(new Rectangle(1149, 150, 100, 92));
			cs.setText("");
			
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(241, 126, 147, 133));
			jLabel.setText("");
		
			LOGO = new JLabel();
			LOGO.setBounds(new Rectangle(562, 116, 176, 155));
			LOGO.setIcon(new ImageIcon("images/ucad.jpg"));
			LOGO.setText(" ");
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setFont(new Font("Elephant", Font.BOLD, 18));
			jContentPane.setSize(new Dimension(1062, 789));
			jContentPane.add(LOGO, null);
			jContentPane.add(getPANO(), null);
			jContentPane.add(getPano2(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(cs, null);
			jContentPane.add(getPanA(), null);
			jContentPane.add(getPanA1(), null);
			 BAG=new ButtonGroup();
			 BAG.add(getSecretaire());
			 BAG.add(getAgentcompta());
			 BAG.add(getAdministrateur());
			 
		}
		return jContentPane;
	}

	/**
	 * This method initializes PANO	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPANO() {
		if (PANO == null) {//
			agentc = new JLabel();
			agentc.setBounds(new Rectangle(31, 91, 122, 20));
			agentc.setForeground(SystemColor.activeCaptionText);
			agentc.setText("Agent Comptable");
			
			secre = new JLabel();
			secre.setBounds(new Rectangle(30, 31, 120, 23));
			secre.setForeground(SystemColor.activeCaptionText);
			secre.setText("Secretaire");
			
			admin = new JLabel();
			admin.setBounds(new Rectangle(32, 61, 120, 23));
			admin.setForeground(SystemColor.activeCaptionText);
			admin.setText("Administrateur");
			
			PANO = new JPanel();
			PANO.setLayout(null);
			PANO.setBounds(new Rectangle(564, 320, 202, 143));
			PANO.add(getSecretaire(), null);
			PANO.add(secre, null);
			PANO.add(agentc, null);
			PANO.add(admin, null);
			PANO.add(getAgentcompta(), null);
			PANO.add(getAdministrateur(), null);

		
		}
		return PANO;
	}

	/**
	 * This method initializes secretaire	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getSecretaire() {
		if (secretaire == null) {
			secretaire = new JRadioButton();
			secretaire.setBounds(new Rectangle(8, 33, 21, 21));
			secretaire.addActionListener(this);
		}
		return secretaire;
	}
	
	/**
	 * This method initializes agentcompta	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getAgentcompta() {
		if (agentcompta == null) {
			agentcompta = new JRadioButton();
			agentcompta.setBounds(new Rectangle(10, 90, 21, 21));
			agentcompta.addActionListener(this);
		}
		return agentcompta;
	}
	/**
	 * This method initializes secretaire	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getAdministrateur() {
		if (administrateur == null) {
			administrateur = new JRadioButton();
			administrateur.setBounds(new Rectangle(9, 61, 21, 21));
			administrateur.addActionListener(this);
		}
		return administrateur;
	}

	/**
	 * This method initializes pano2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPano2() {
		if (pano2 == null) {
			pano2 = new JPanel();
			pano2.setLayout(null);
			pano2.setBounds(new Rectangle(492, 450, 326, 83));
			pano2.add(getValid(), null);
			pano2.add(getAnnuler(), null);
		}
		return pano2;
	}

	/**
	 * This method initializes valid	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getValid() {
		if (valid == null) {
			valid = new JButton();
			valid.setBounds(new Rectangle(19, 16, 141, 38));
			valid.setForeground(Color.black);
			valid.setFont(new Font("Elephant", Font.BOLD, 14));
			valid.setIcon(new ImageIcon("images/enregistrer.gif"));
			valid.setText("Valider");
			valid.addActionListener(this);
		}
		return valid;
	}

	/**
	 * This method initializes annuler	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAnnuler() {
		if (annuler == null) {
			annuler = new JButton();
			annuler.setBounds(new Rectangle(168, 18, 145, 35));
			annuler.setForeground(Color.black);
			annuler.setFont(new Font("Elephant", Font.BOLD, 14));
			annuler.setIcon(new ImageIcon("images/quitter.gif"));
			annuler.setText("Precedent");
			annuler.addActionListener(this);
		}
		return annuler;
	}

	

	/**
	 * This method initializes panA	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanA() {
		if (panA == null) {
			panA = new JPanel();
			panA.setLayout(null);
			panA.setBounds(new Rectangle(2, 86, 1282, 10));
			panA.setBackground(Color.black);
		}
		return panA;
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
			panA1.setBounds(new Rectangle(1, 261, 1281, 10));
			panA1.setBackground(Color.black);
		}
		return panA1;
	}

}  