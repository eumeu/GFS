package Administration;


import menu.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import authentification.MD5Password;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.*;

public class MajUser extends JFrame implements ActionListener{


	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel logo = null;

	private JLabel loj = null;

	private JPanel pan = null;

	private JLabel matricule = null;

	private JLabel NOM = null;

	private JLabel PRENOM = null;

	private JLabel LOGIN = null;

	private JLabel PROFIL = null;
	private JLabel PASSWORD = null;



	public JTextField txtmatricule = null;

	public JTextField txtnom = null;

	 public JTextField txtprenom = null;

	 public JTextField txtpassword = null;

	 public JTextField txtlogin = null;

	 public JTextField txtprofil = null;

	

	private JPanel pane = null;

 private JButton annuler = null;

	private JButton precedent = null;

	private JButton quitter = null;
	public JButton supprimer = null;

	

	

	public JButton modifier = null;


	 public JButton chercher = null;

	

 public JButton valider = null;



private JPanel panA1 = null;

private JPanel panA11 = null;

private JPanel panA12 = null;

//déclaration des fenêtres
private MenuAdmin menuAdmin = new MenuAdmin();
	/**
	 * This is the default constructor
	 */
	public MajUser() {
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
		this.setTitle("Edition utilisateur");
		setVisible(true);
		menuAdmin.setVisible(false);
	
	}
	
	
	/*
	*/
	public void actionPerformed(ActionEvent e)
	{
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
				/*	*/

				if(e.getSource()==annuler)
				{
					txtmatricule.setText("");
					txtnom.setText("");
					txtprenom.setText("");
					txtlogin.setText("");
					txtpassword.setText("");
					txtprofil.setText("");
					
				}

			if(e.getSource()==chercher){
				int tr=0;
				String numero= JOptionPane.showInputDialog(null,"Matricule de l'utilisateur a chercher","Recherche utilisateur",JOptionPane.QUESTION_MESSAGE);
				
				try{
					Statement state = authentification.Connect.getInstance()
				.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE, 
							ResultSet.CONCUR_READ_ONLY
				);				
				
				String req="Select *from utilisateurs";
				ResultSet rs=state.executeQuery(req);
				while(rs.next()){
					if(numero.equals(rs.getString("matricule"))){
						tr=1;
						String mat=rs.getString("matricule");
						String pre=rs.getString("prenom");
						String nom=rs.getString("nom");
						String login=rs.getString("login");
						String pass=rs.getString("password");
						String profil=rs.getString("profil");
					
						txtmatricule.setText(mat);
						txtnom.setText(nom);
						txtprenom.setText(pre);
						txtlogin.setText(login);
						txtpassword.setText("");
						txtprofil.setText(profil);
						
						supprimer.setEnabled(true);
						modifier.setEnabled(true);
						chercher.setEnabled(false);
						valider.setEnabled(false);
						txtmatricule.setEnabled(false);
						txtnom.setEnabled(false);
						txtprenom.setEnabled(false);
						txtlogin.setEnabled(false);
						txtpassword.setEnabled(false);
						txtprofil.setEnabled(false);
					}
				}
					if(tr==0)JOptionPane.showMessageDialog(null," Ce matricule n'est pas dans la base");
				}
				catch(SQLException se){
					System.out.println("Connexion Impossible"+se.getMessage());
				}
			}
			if(e.getSource()==modifier){
				txtmatricule.setEnabled(false);
				txtnom.setEnabled(true);
				txtprenom.setEnabled(true);
				txtlogin.setEnabled(true);
				txtpassword.setEnabled(true);
				txtprofil.setEnabled(false);
				
				modifier.setEnabled(false);
				supprimer.setEnabled(false);
				valider.setEnabled(true);
				chercher.setEnabled(true);
			}
			if(e.getSource()==supprimer){
				String nume=txtmatricule.getText();
				
				try{
					
					Statement state = authentification.Connect.getInstance()
					.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE, 
								ResultSet.CONCUR_READ_ONLY
					);				
					
					String req3="delete from utilisateurs where matricule='"+nume+"'   ";
                      state.executeUpdate(req3);
                      JOptionPane.showMessageDialog(null,"suppression reussie");
                    txtmatricule.setText("");
          			txtnom.setText("");
          			txtprenom.setText("");
          			txtlogin.setText("");
					txtpassword.setText("");
          			txtprofil.setText("");
          	
         			modifier.setEnabled(false);
    				supprimer.setEnabled(false);
    				valider.setEnabled(false);
    				chercher.setEnabled(true);
                    state.close();
                     
			}
				catch(SQLException se){
					System.out.println("Connexion Impossible"+se.getMessage());
				}
				}
			if(e.getSource()==valider){
				
				String num=txtmatricule.getText();
				String nom=txtnom.getText();
				String prenom=txtprenom.getText();
				String login=txtlogin.getText();
				String password=txtpassword.getText();
				String profil=txtprofil.getText();
		
				try{
					
					Statement state = authentification.Connect.getInstance()
					.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE, 
								ResultSet.CONCUR_READ_ONLY
					);				
					
					String passwordencoded = MD5Password.getEncodedPassword(password);
					
					String req3="update  utilisateurs set  nom='"+nom+"',prenom='"+prenom+"',login='"+login+"',password='"+passwordencoded+"',profil='"+profil+"'     where matricule='"+num+"'   ";
                      state.executeUpdate(req3);
                      JOptionPane.showMessageDialog(null,"Modification reussie......");
                      	supprimer.setEnabled(true);
						modifier.setEnabled(true);
						chercher.setEnabled(false);
						valider.setEnabled(false);
						txtmatricule.setEnabled(false);
						txtnom.setEnabled(false);
						txtprenom.setEnabled(false);
						txtlogin.setEnabled(false);
						txtpassword.setEnabled(false);
						txtprofil.setEnabled(false);
					
						state.close();
				}
				
				catch(SQLException se){
						System.out.println("connexion impossible"+se.getMessage());
				}
			}
			
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			loj = new JLabel();
			loj.setBounds(new Rectangle(565, 114, 184, 160));
			loj.setIcon(new ImageIcon("images/ucad.jpg"));
			loj.setText(" ");
			logo = new JLabel();
			logo.setBounds(new Rectangle(1, -1, 1282, 104));
			logo.setText(" ");			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(logo, null);
			jContentPane.add(loj, null);
			jContentPane.add(getPan(), null);
			jContentPane.add(getPane(), null);
			jContentPane.add(getQuitter(), null);
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
			PROFIL.setText("Profil  :");
			PASSWORD = new JLabel();
			PASSWORD.setBounds(new Rectangle(31, 142, 124, 16));
			PASSWORD.setForeground(Color.blue);
			PASSWORD.setFont(new Font("Elephant", Font.BOLD, 12));
			PASSWORD.setText("Re-init pwd:");
			LOGIN = new JLabel();
			LOGIN.setBounds(new Rectangle(31, 112, 125, 16));
			LOGIN.setForeground(Color.blue);
			LOGIN.setFont(new Font("Elephant", Font.BOLD, 12));
			LOGIN.setText("Login  :");
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
			pan.setBounds(new Rectangle(459, 283, 413, 310));
			pan.add(matricule, null);
			pan.add(NOM, null);
			pan.add(PRENOM, null);
			pan.add(LOGIN, null);
			pan.add(PASSWORD, null);
			pan.add(PROFIL, null);
			
			pan.add(getTxtnum(), null);
			pan.add(getTxtnom(), null);
			pan.add(getTxtprenom(), null);
			pan.add(getTxtlogin(), null);
			pan.add(getTxtpassword(), null);

			pan.add(getTxtprofil(), null);
			
		}
		return pan;
	}

	/**
	 * This method initializes txtnum	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtnum() {
		if (txtmatricule == null) {
			txtmatricule = new JTextField();
			txtmatricule.setBounds(new Rectangle(155, 23, 209, 20));
			txtmatricule.setBackground(SystemColor.controlLtHighlight);
			txtmatricule.setFont(new Font("Elephant", Font.BOLD, 14));
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
			txtnom.setBackground(SystemColor.controlLtHighlight);
			txtnom.setFont(new Font("Elephant", Font.BOLD, 14));
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
			txtprenom.setBackground(SystemColor.controlLtHighlight);
			txtprenom.setFont(new Font("Elephant", Font.BOLD, 14));
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
			txtlogin.setBackground(SystemColor.controlLtHighlight);
			txtlogin.setFont(new Font("Elephant", Font.BOLD, 14));
		}
		return txtlogin;
	}
	
	/**
	 * This method initializes txtdatenaisse	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtpassword() {
		if (txtpassword == null) {
			txtpassword = new JTextField();
			txtpassword.setBounds(new Rectangle(159, 142, 202, 19));
			txtpassword.setBackground(SystemColor.controlLtHighlight);
			txtpassword.setFont(new Font("Elephant", Font.BOLD, 14));
		}
		return txtpassword;
	}

	

	

	/**
	 * This method initializes txtadresse	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtprofil() {
		if (txtprofil == null) {
			txtprofil = new JTextField();
			txtprofil.setBounds(new Rectangle(158, 172, 201, 18));
			txtprofil.setBackground(SystemColor.controlLtHighlight);
			txtprofil.setFont(new Font("Elephant", Font.BOLD, 14));
		}
		return txtprofil;
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
			pane.setBounds(new Rectangle(459, 605, 417, 106));
			pane.add(getPrecedent(), null);
			pane.add(getModifier(), null);
			pane.add(getSupprimer(), null);
			pane.add(getChercher(), null);
			pane.add(getAnnuler(), null);
			pane.add(getValider(), null);
		}
		return pane;
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
			annuler.setBounds(new Rectangle(156, 57, 128, 34));
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
			precedent.setBounds(new Rectangle(5, 58, 131, 34));
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
			quitter.setIcon(new ImageIcon("images/quitter.gif"));
			quitter.setBounds(new Rectangle(1091, 694, 116, 35));
			quitter.setText("Quitter");
			quitter.addActionListener(this);
		}
		return quitter;
	}

	
	/**
	 * This method initializes modifier	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getModifier() {
		if (modifier == null) {
			modifier = new JButton();
			modifier.setBounds(new Rectangle(152, 14, 132, 31));
			modifier.setIcon(new ImageIcon("images/modifier.gif"));
			modifier.setText("Modifier");
			modifier.addActionListener(this);
		}
		return modifier;
	}

	/**
	 * This method initializes supprimer	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSupprimer() {
		if (supprimer == null) {
			supprimer = new JButton();
			supprimer.setBounds(new Rectangle(292, 12, 113, 31));
			supprimer.setText("Supprimer");
			supprimer.addActionListener(this);
		}
		return supprimer;
	}

	/**
	 * This method initializes chercher	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getChercher() {
		if (chercher == null) {
			chercher = new JButton();
			chercher.setBounds(new Rectangle(5, 13, 129, 32));
			chercher.setIcon(new ImageIcon("images/consulter.gif"));
			chercher.setText("Chercher");
			chercher.addActionListener(this);
		}
		return chercher;
	}

	
	/**
	 * This method initializes valider	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getValider() {
		if (valider == null) {
			valider = new JButton();
			valider.setText("Valider");
			valider.setBounds(new Rectangle(293, 59, 116, 33));
			valider.setIcon(new ImageIcon("images/enregistrer.gif"));
		valider.addActionListener(this);
		}
		return valider;
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
			panA1.setBounds(new Rectangle(-1, 274, 1284, 10));
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
			panA11.setBounds(new Rectangle(1, 102, 1282, 10));
			panA11.setBackground(Color.black);;
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
			panA12.setBounds(new Rectangle(1, 594, 1283, 10));
			panA12.setBackground(Color.black);;
		}
		return panA12;
	}

} 