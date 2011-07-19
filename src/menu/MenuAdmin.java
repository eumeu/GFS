package menu;



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
import java.awt.event.KeyEvent;
import menu.MenuAdministra;


public class MenuAdmin extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel menu_user = null;

	private JPanel PANO = null;

	private JButton saisie_user = null;


	private JLabel logo = null;

	private JButton quitter = null;

	private JButton majuser = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	private JLabel jLabel3 = null;

	private JLabel jLabel31 = null;

	private JPanel panA1 = null;

	private JPanel panA11 = null;
	
	
	//déclaration des fenêtres
	private MenuAdministra menuAdministra = new MenuAdministra();

	/**
	 * This is the default constructor);
	 */
	
	
	public MenuAdmin() {
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
		this.setTitle("Menu Administrateur");
		setVisible(true);		
		menuAdministra.setVisible(false);
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		
		if(e.getSource()==majuser){
			this.setVisible(false);
			
			Administration.MajUser b=	new Administration.MajUser();
			
			b.modifier.setEnabled(false);
			b.supprimer.setEnabled(false);
			b.valider.setEnabled(false);
			b.txtmatricule.setEnabled(false);
			b.txtnom.setEnabled(false);
			b.txtprenom.setEnabled(false);
			b.txtlogin.setEnabled(false);
			b.txtprofil.setEnabled(false);
			
			
		}
		if(e.getSource()==saisie_user){
			this.setVisible(false);
			new Administration.NewUser();

		}
		
		
		if(e.getSource()==quitter){
			this.dispose();
			menuAdministra.setVisible(true);
			
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

			
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(108, 305, 350, 21));
			jLabel.setForeground(Color.black);
			jLabel.setText("Ajouter nouvel utilisateur ");
			
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(107, 353, 352, 21));
			jLabel1.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel1.setForeground(Color.black);
			jLabel1.setText("Editer infos utilisateur ");
			
			
			logo = new JLabel();
			logo.setBounds(new Rectangle(556, 97, 177, 163));
			logo.setIcon(new ImageIcon("images/ucad.jpg"));
			logo.setText("");
			
			
			menu_user = new JLabel();
			menu_user.setBounds(new Rectangle(556, 97, 177, 163));
			menu_user.setFont(new Font("Elephant", Font.BOLD, 18));
			

			menu_user.setText("");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			//jContentPane.setBackground(SystemColor.info);
			jContentPane.add(menu_user, null);
			jContentPane.add(getPANO(), null);
			jContentPane.add(logo, null);
			jContentPane.add(getQuitter(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel31, null);

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
			PANO.add(getMajuser(), null);
		
		}
		return PANO;
	}

	
	/**
	 * This method initializes saisie_etudiant	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSaisie_etudiant() {
		if (saisie_user == null) {
			saisie_user = new JButton();
			saisie_user.setBounds(new Rectangle(12, 25, 232, 31));
			saisie_user.setFont(new Font("Elephant", Font.BOLD, 14));
			saisie_user.setIcon(new ImageIcon("images/enregistrer.gif"));

			saisie_user.setForeground(Color.black);
			saisie_user.setText("Nouvel Utilisateur");
			saisie_user.addActionListener(this);
		}
		return saisie_user;
	}
	/**
	 * This method initializes majetu	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getMajuser() {
		if (majuser == null) {
			majuser = new JButton();
			majuser.setBounds(new Rectangle(11, 74, 232, 29));
			majuser.setText("Edition utilisateur");
			majuser.setIcon(new ImageIcon("images/modifier.gif"));

			majuser.setForeground(Color.black);
			majuser.setFont(new Font("Elephant", Font.BOLD, 14));
			majuser.addActionListener(this);
		}
		return majuser;
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

