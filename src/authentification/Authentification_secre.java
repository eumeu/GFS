package authentification;

//import java.awt.BorderLayout;



import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

import javax.swing.*;


import menu.*;
public class Authentification_secre extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel titre = null;

	private JLabel PASSWORD = null;

	private JLabel LOGIN = null;

	private JTextField txtpassword = null;

	private JPasswordField txtlogin = null;

	private JLabel lo = null;

	private JPanel pan = null;

	private JButton valider = null;

	private JButton quitter = null;
	
	
	//déclaration des fenêtres
	private MenuAdministra menuAdmin = new MenuAdministra();

	/**
	 * This is the default constructor
	 */
	public Authentification_secre() {
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
		this.setSize(545, 370);
		this.setContentPane(getJContentPane());
		this.setTitle("Authentification Secretaire");
		setVisible(true);
		menuAdmin.setVisible(false);
	}
	public void actionPerformed (ActionEvent e){
		boolean verif;
	    verif =false;
		
	if(e.getSource()==valider){
		
		try{
			Statement state = authentification.Connect.getInstance()
			.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY
			);
			ResultSet r = state.executeQuery("select login,password from utilisateurs where profil = 'secretaire'");
			while (r.next()) {
			String LoginRecup = r.getString("Login");
			String log = txtlogin.getText();
			String pssw = txtpassword.getText();
			String pw = new String(pssw);
			String MPRecup = r.getString("Password");
			if (LoginRecup.equals(log)& MPRecup.equals(pw) ) {

			verif = true;
			new menu.MenuSecre();
			this.dispose();


			}
			}
			if (!verif) {
			JOptionPane.showMessageDialog(null, "Verifier Login / Mot de passe", "Message d'erreur:", JOptionPane.ERROR_MESSAGE);
			txtlogin.setText("");
			txtpassword.setText("");
			}
			r.close();
			state.close();
			} catch (Exception a) {
			System.out.println(a);
			} 
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
			lo = new JLabel();
			lo.setBounds(new Rectangle(200, 36, 170, 156));
			lo.setIcon(new ImageIcon("images/ucad.jpg"));
			lo.setText(" ");
			
			LOGIN = new JLabel();
			LOGIN.setBounds(new Rectangle(133, 201, 88, 21));
			LOGIN.setBackground(Color.blue);
			LOGIN.setForeground(Color.blue);
			LOGIN.setFont(new Font("Elephant", Font.BOLD, 12));
			LOGIN.setText("Login  :");
			
			PASSWORD = new JLabel();
			PASSWORD.setBounds(new Rectangle(132, 224, 89, 26));
			PASSWORD.setBackground(Color.blue);
			PASSWORD.setForeground(Color.blue);
			PASSWORD.setFont(new Font("Elephant", Font.BOLD, 12));
			PASSWORD.setText("Password :");
			
			titre = new JLabel();
			titre.setBounds(new Rectangle(135, 3, 288, 30));
			titre.setFont(new Font("Elephant", Font.BOLD, 12));
			titre.setBackground(Color.blue);
			titre.setForeground(Color.blue);
			titre.setText("Veuillez  Vous Authentifier  Svp   :");
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			//jContentPane.setBackground(SystemColor.info);
			jContentPane.add(titre, null);
			jContentPane.add(PASSWORD, null);
			jContentPane.add(LOGIN, null);
			jContentPane.add(getTxtpassword(), null);
			jContentPane.add(getTxtlogin(), null);
			jContentPane.add(lo, null);
			jContentPane.add(getPan(), null);
			setLocationRelativeTo(null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes txtpassword	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtpassword() {
		if (txtpassword == null) {
			txtpassword = new JTextField();
			txtpassword.setBounds(new Rectangle(221, 199, 196, 24));
		}
		return txtpassword;
	}

	/**
	 * This method initializes txtlogin	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getTxtlogin() {
		if (txtlogin == null) {
			txtlogin = new JPasswordField();
			txtlogin.setBounds(new Rectangle(221, 226, 197, 25));
		}
		return txtlogin;
	}

	/**
	 * This method initializes pan	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPan() {
		if (pan == null) {
			pan = new JPanel();
			pan.setLayout(null);
			pan.setBounds(new Rectangle(116, 264, 328, 54));
			//pan.setBackground(Color.pink);
			pan.add(getValider(), null);
			pan.add(getQuitter(), null);
		}
		return pan;
	}

	/**
	 * This method initializes valider	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getValider() {
		if (valider == null) {
			valider = new JButton();
			valider.setBounds(new Rectangle(21, 11, 137, 33));
			valider.setForeground(Color.black);
			//valider.setBackground(Color.cyan);
			valider.setFont(new Font("Elephant", Font.BOLD, 12));
			valider.setIcon(new ImageIcon("images/enregistrer.gif"));

			valider.setText("Valider");
			valider.addActionListener(this);
		}
		return valider;
	}

	/**
	 * This method initializes quitter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getQuitter() {
		if (quitter == null) {
			quitter = new JButton();
			quitter.setBounds(new Rectangle(185, 11, 126, 34));
			quitter.setForeground(Color.black);
			//quitter.setBackground(Color.cyan);
			quitter.setFont(new Font("Elephant", Font.BOLD, 12));
			quitter.setIcon(new ImageIcon("images/quitter.gif"));

			quitter.setText("Quitter");
			quitter.addActionListener(this);
		}
		return quitter;
	}

}  