package Administration;

import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import authentification.MD5Password;
import menu.*;

public class NewUser extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel logo = null;

	private JLabel loj = null;

	private JPanel pan = null;

	private JLabel matricule = null;

	private JLabel NOM = null;

	private JLabel PRENOM = null;

	private JLabel LOGIN = null;
	
	private JLabel PASSWORD = null;

	private JLabel PROFIL = null;

	private JTextField txtmatricule = null;

	private JTextField txtnom = null;

	private JTextField txtprenom = null;

	private JTextField txtlogin = null;
	
	private JTextField txtpassword = null;

	private JComboBox txtprofil = null;

	private JPanel pane = null;

	JButton valider = null;

	private JButton annuler = null;

	private JButton precedent = null;

	private JButton quitter = null;

	private JLabel jLabel = null;

	private JPanel panA1 = null;

	private JPanel panA11 = null;

	private JPanel panA12 = null;

	 /**
	 * This is the default constructor
	 */
	//déclaration des fenêtres
	
	private MenuAdmin menuAdmin = new MenuAdmin();
	
	public NewUser() {
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
		this.setSize(1300, 800);
		this.setContentPane(getJContentPane());
		this.setTitle("Nouvel Utilisateur");
		setVisible(true);
		menuAdmin.setVisible(false);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
			if(e.getSource()==annuler)
			{
				txtmatricule.setText("");
				txtnom.setText("");
				txtprenom.setText("");
				txtlogin.setText("");
				txtpassword.setText("");
			}
		
				if(e.getSource()==precedent)
				{
					this.dispose();
					menuAdmin.setVisible(true);
					
				}
				else
					
					if(e.getSource()==quitter)
					{
					this.dispose();
					menuAdmin.setVisible(true); 
					}
					else
		if(e.getSource()==valider)
		{
			
			if (txtmatricule.getText().equals("")|| txtnom.getText().equals("") ||txtprenom.getText().equals("")|| txtlogin.getText().equals("")|| txtpassword.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Veuillez saisir svp  les champs vides...");
			}
			else
			{	
			
	        String matricule=(txtmatricule.getText());
			String nom=txtnom.getText();
			String prenom=txtprenom.getText();
			String login=txtlogin.getText();
			String password=txtpassword.getText();
			String profil=(String)txtprofil.getSelectedItem();
			
			try{
				
				Statement state = authentification.Connect.getInstance()
				.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE, 
							ResultSet.CONCUR_READ_ONLY
				);				
				
				String req3="select * from utilisateurs   ";
				ResultSet rst=state.executeQuery(req3);
				
				while(rst.next())
				{  String pro=rst.getString("profil");
				if(txtmatricule.equals(rst.getString("matricule"))&&(txtprofil.getSelectedItem().equals(rst.getString("profil")))) 
				
					JOptionPane.showMessageDialog(null,"Ce matricule :"+matricule+" est deja enregistre avec le profil "+pro+" ");
		
				}
			String passwordencoded = MD5Password.getEncodedPassword(password);
						
	        String req2="INSERT INTO `utilisateurs` VALUES('"+matricule+"','"+nom+"','"+prenom+"','"+login+"','"+passwordencoded+"','"+profil+"')";

	       int c=state.executeUpdate(req2);
	        if(c==1)
				JOptionPane.showMessageDialog(null," Insertion reussie.....");
	        txtmatricule.setText("");
			txtnom.setText("");
			txtprenom.setText("");
			txtlogin.setText("");
			txtpassword.setText("");
			rst.close();
			state.close();
			}
				catch(SQLException se){
					System.out.println("connexion impossible erreur: "+se.getMessage());
				}
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
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(3, 109, 301, 407));
			jLabel.setText(" ");
			
			loj = new JLabel();
			loj.setBounds(new Rectangle(593, 108, 184, 160));
			loj.setIcon(new ImageIcon("images/ucad.jpg"));
			loj.setText(" ");
			
			logo = new JLabel();
			logo.setBounds(new Rectangle(-24, -1, 1309, 101));
			logo.setIcon(new ImageIcon("images/inscr.jpg"));
			logo.setText(" ");
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(logo, null);
			jContentPane.add(loj, null);
			jContentPane.add(getPan(), null);
			jContentPane.add(getPane(), null);
			jContentPane.add(getQuitter(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getPanA1(), null);
			jContentPane.add(getPanA11(), null);
			jContentPane.add(getPanA12(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes pan	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPan() {
		if (pan == null) {
			
			PROFIL = new JLabel();
			PROFIL.setBounds(new Rectangle(31, 171, 116, 20));
			PROFIL.setForeground(Color.blue);
			PROFIL.setFont(new Font("Elephant", Font.BOLD, 12));
			PROFIL.setText("Profil :");
			
			PASSWORD = new JLabel();
			PASSWORD.setBounds(new Rectangle(31, 142, 124, 16));
			PASSWORD.setForeground(Color.blue);
			PASSWORD.setFont(new Font("Elephant", Font.BOLD, 12));
			PASSWORD.setText("Password  :");
			
			LOGIN = new JLabel();
			LOGIN.setBounds(new Rectangle(31, 112, 125, 16));
			LOGIN.setForeground(Color.blue);
			LOGIN.setFont(new Font("Elephant", Font.BOLD, 12));
			LOGIN.setText("Login choisi  :");
			
			PRENOM = new JLabel();
			PRENOM.setBounds(new Rectangle(30, 81, 117, 16));
			PRENOM.setForeground(Color.blue);
			PRENOM.setFont(new Font("Elephant", Font.BOLD, 12));
			PRENOM.setText("Prenom  :");
			
			NOM = new JLabel();
			NOM.setBounds(new Rectangle(31, 53, 116, 16));
			NOM.setForeground(Color.blue);
			NOM.setFont(new Font("Elephant", Font.BOLD, 12));
			NOM.setText("Nom  :");
			
			matricule = new JLabel();
			matricule.setBounds(new Rectangle(29, 24, 118, 16));
			matricule.setForeground(Color.blue);
			matricule.setFont(new Font("Elephant", Font.BOLD, 12));
			matricule.setText("Matricule :");
			
			pan = new JPanel();
			pan.setLayout(null);
			pan.setBounds(new Rectangle(472, 280, 413, 341));
			pan.add(matricule, null);
			pan.add(NOM, null);
			pan.add(PRENOM, null);
			pan.add(LOGIN, null);
			pan.add(PASSWORD, null);
			pan.add(PROFIL, null);
			pan.add(getTxtmatricule(), null);
			pan.add(getTxtnom(), null);
			pan.add(getTxtprenom(), null);
			pan.add(getTxtlogin(), null);
			pan.add(getTxtpassword(), null);
			pan.add(getTxtprofil(), null);
		}
		return pan;
	}

	/**
	 * This method initializes txtmatricule	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtmatricule() {
		if (txtmatricule == null) {
			txtmatricule = new JTextField();
			txtmatricule.setBounds(new Rectangle(155, 23, 209, 20));
		}
		return txtmatricule;
	}

	/**
	 * This method initializes txtnom	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtnom() {
		if (txtnom == null) {
			txtnom = new JTextField();
			txtnom.setBounds(new Rectangle(156, 52, 207, 20));
		}
		return txtnom;
	}

	/**
	 * This method initializes txtprenom	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtprenom() {
		if (txtprenom == null) {
			txtprenom = new JTextField();
			txtprenom.setBounds(new Rectangle(157, 80, 205, 20));
		}
		return txtprenom;
	}

	/**
	 * This method initializes txtdatenaisse	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtlogin() {
		if (txtlogin == null) {
			txtlogin = new JTextField();
			txtlogin.setBounds(new Rectangle(158, 110, 203, 20));
		}
		return txtlogin;
	}

	/**
	 * This method initializes txtlieunaisse	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtpassword() {
		if (txtpassword == null) {
			txtpassword = new JTextField();
			txtpassword.setBounds(new Rectangle(159, 140, 202, 21));
		}
		return txtpassword;
	}

	/**
	 * This method initializes pane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPane() {
		if (pane == null) {
			pane = new JPanel();
			pane.setLayout(null);
			pane.setBounds(new Rectangle(472, 632, 417, 55));
			pane.add(getValider(), null);
			pane.add(getPrecedent(), null);
			pane.add(getAnnuler(), null);
		}
		return pane;
	}

	/**
	 * This method initializes valider	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getValider() {
		if (valider == null) {
			valider = new JButton();
			valider.setBounds(new Rectangle(12, 9, 133, 33));
			valider.setIcon(new ImageIcon("images/enregistrer.gif"));
			valider.setText("Valider");
			valider.addActionListener(this);
		}
		return valider;
	}

	/**
	 * This method initializes annuler	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAnnuler() {
		if (annuler == null) {
			annuler = new JButton();
			annuler.setText("Annuler");
			annuler.setBounds(new Rectangle(283, 10, 123, 34));
			annuler.addActionListener(this);
		}
		return annuler;
	}

	/**
	 * This method initializes precedent	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getPrecedent() {
		if (precedent == null) {
			precedent = new JButton();
			precedent.setText("Precedent");
			precedent.setIcon(new ImageIcon("images/retour.gif"));
			precedent.setBounds(new Rectangle(148, 9, 131, 34));
			precedent.addActionListener(this);
		}
		return precedent;
	}

	/**
	 * This method initializes quitter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getQuitter() {
		if (quitter == null) {
			quitter = new JButton();
			quitter.setBounds(new Rectangle(1081, 703, 159, 28));
			quitter.setIcon(new ImageIcon("images/quitter.gif"));
			quitter.setText("Quitter");
			quitter.addActionListener(this);
		}
		return quitter;
	}

	/**
	 * This method initializes txtclasse	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getTxtprofil() {
		if (txtprofil == null) {
			txtprofil = new JComboBox();
			txtprofil.addItem("secretaire");
			txtprofil.addItem("comptable");
			txtprofil.setBounds(new Rectangle(158, 171, 203, 23));
			txtprofil.addActionListener(this);
		}
		return txtprofil;
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
			panA1.setBounds(new Rectangle(-2, 98, 1284, 10));
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
			panA11.setBounds(new Rectangle(-1, 270, 1284, 10));
			panA11.setBackground(Color.black);
		}
		return panA11;
	}

	/**
	 * This method initializes panA12	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanA12() {
		if (panA12 == null) {
			panA12 = new JPanel();
			panA12.setLayout(null);
			panA12.setBounds(new Rectangle(0, 622, 1286, 10));
			panA12.setBackground(Color.black);
		}
		return panA12;
	}

}  
