package etudiant;


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
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.*;
import menu.MenuSecre;

public class MajEt extends JFrame implements ActionListener{


	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel logo = null;

	private JLabel loj = null;

	private JPanel pan = null;

	private JLabel num = null;

	private JLabel NOM = null;

	private JLabel PRENOM = null;

	private JLabel DATENAI = null;

	private JLabel LIEU = null;

	private JLabel NATIONALITE = null;

	private JLabel ADRESSE = null;

	private JLabel CLASE = null;

	public JTextField txtnum = null;

	public JTextField txtnom = null;

	 public JTextField txtprenom = null;

	 public JTextField txtdatenaisse = null;

	 public JTextField txtlieunaisse = null;

	 public JTextField txtnationalite = null;

	 public JTextField txtadresse = null;

	private JPanel pane = null;

 private JButton annuler = null;

	private JButton precedent = null;

	private JButton quitter = null;

	private JLabel annee = null;

	public JTextField txtdate = null;

	public JButton modifier = null;

	public JButton supprimer = null;

	 public JButton chercher = null;

	 public JTextField txtclasse = null;

 public JButton valider = null;

private JLabel montantin = null;

 public JTextField txtmontant = null;

private JPanel panA1 = null;

private JPanel panA11 = null;

private JPanel panA12 = null;

private MenuSecre menuSec = new MenuSecre();
	/**
	 * This is the default constructor
	 */
	public MajEt() {
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
		this.setTitle("Formulaire Inscription");
		setVisible(true);
		menuSec.setVisible(false);
	
	}
	
	
	/*
	*/
	public void actionPerformed(ActionEvent e)
	{
				if(e.getSource()==precedent)
				{
					this.dispose();
					menuSec.setVisible(true);
				}
				else
					
					if(e.getSource()==quitter)
					{
						this.dispose();
						menuSec.setVisible(true);

					}
				/*	*/

				if(e.getSource()==annuler)
				{
					txtnum.setText("");
					txtnom.setText("");
					txtprenom.setText("");
					txtdatenaisse.setText("");
					txtlieunaisse.setText("");
					txtnationalite.setText("");
					txtadresse.setText("");
					txtdate.setText("");
				}

			if(e.getSource()==chercher){
				int tr=0;
				String numero= JOptionPane.showInputDialog(null,"Numero de l'etudiant a chercher","Recherche etudiant",JOptionPane.QUESTION_MESSAGE);
				
				try{
					Statement state = authentification.Connect.getInstance()
				.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE, 
							ResultSet.CONCUR_READ_ONLY
				);				
				
				String req="Select *from etudiant";
				ResultSet rs=state.executeQuery(req);
				while(rs.next()){
					if(numero.equals(rs.getString("numero"))){
						tr=1;
						String nom=rs.getString("nom");
						String pre=rs.getString("prenom");
						String datenai=rs.getString("datenais");
						String lieunaiss=rs.getString("lieunais");
						String nationa=rs.getString("nationalite");
						String adress=rs.getString("adresse");
						String dateins=rs.getString("moisInscript");
						String classes=rs.getString("classe");
						String mont=rs.getString("monta");
						classes=rs.getString("classe");
						
						txtnum.setText(numero);
						txtnom.setText(nom);
						txtprenom.setText(pre);
						txtdatenaisse.setText(datenai);
						txtlieunaisse.setText(lieunaiss);
						txtnationalite.setText(nationa);						

						txtadresse.setText(adress);
						txtdate.setText(dateins);
						txtclasse.setText(classes);
						txtmontant.setText(mont);
						
						supprimer.setEnabled(true);
						modifier.setEnabled(true);
						chercher.setEnabled(false);
						valider.setEnabled(false);
						txtnum.setEnabled(false);
						txtnom.setEnabled(false);
						txtprenom.setEnabled(false);
						txtdatenaisse.setEnabled(false);
						txtlieunaisse.setEnabled(false);
						txtnationalite.setEnabled(false);
						txtadresse.setEnabled(false);
						txtdate.setEnabled(false);
						txtclasse.setEnabled(false);
						txtmontant.setEnabled(false);
					}
				}
					if(tr==0)JOptionPane.showMessageDialog(null," numero n'est pas dans la base");
				}
				catch(SQLException se){
					System.out.println("Connexion Impossible"+se.getMessage());
				}
			}
			if(e.getSource()==modifier){
				txtnom.setEnabled(true);
				txtprenom.setEnabled(true);
				txtdatenaisse.setEnabled(true);
				txtlieunaisse.setEnabled(true);
				txtnationalite.setEnabled(true);
				txtadresse.setEnabled(true);
				txtdate.setEnabled(true);
				txtclasse.setEnabled(true);
				txtmontant.setEnabled(true);
				modifier.setEnabled(false);
				supprimer.setEnabled(false);
				valider.setEnabled(true);
				chercher.setEnabled(true);
			}
			if(e.getSource()==supprimer){
				String nume=txtnum.getText();
				
				try{
					
					Statement state = authentification.Connect.getInstance()
					.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE, 
								ResultSet.CONCUR_READ_ONLY
					);				
					
					
					String req3="delete from etudiant where numero='"+nume+"'   ";
                      state.executeUpdate(req3);
                      JOptionPane.showMessageDialog(null,"suppression reussie");
                    txtnum.setText("");
          			txtnom.setText("");
          			txtprenom.setText("");
          			txtdatenaisse.setText("");
          			txtlieunaisse.setText("");
          			txtnationalite.setText("");
          			txtadresse.setText("");
          			txtdate.setText("");
         			txtclasse.setText("");
         			txtmontant.setText("");
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
				
				String num=txtnum.getText();
				String nom=txtnom.getText();
				String prenom=txtprenom.getText();
				String datenaiss=txtdatenaisse.getText();
				String lieunaiss=txtlieunaisse.getText();
				String nationalite=txtnationalite.getText();
				String adresse=txtadresse.getText();
				String date=txtdate.getText();
				String classe=txtclasse.getText();
			    String monta=txtmontant.getText();
			
				try{ 
					
					Statement state = authentification.Connect.getInstance()
					.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE, 
								ResultSet.CONCUR_READ_ONLY
					);				
					
					
					String req3="update  etudiant set  nom='"+nom+"',prenom='"+prenom+"',datenais='"+datenaiss+"',lieunais='"+lieunaiss+"',nationalite='"+nationalite+"',adresse='"+adresse+"',moisInscript='"+date+"',classe='"+classe+"',monta='"+monta+"'     where numero='"+num+"'   ";
                      state.executeUpdate(req3);
                      JOptionPane.showMessageDialog(null,"Modification etablie......");
                      	supprimer.setEnabled(true);
						modifier.setEnabled(true);
						chercher.setEnabled(false);
						valider.setEnabled(false);
						txtnum.setEnabled(false);
						txtnom.setEnabled(false);
						txtprenom.setEnabled(false);
						txtdatenaisse.setEnabled(false);
						txtlieunaisse.setEnabled(false);
						txtnationalite.setEnabled(false);
						txtadresse.setEnabled(false);
						txtdate.setEnabled(false);
						txtclasse.setEnabled(false);
						txtmontant.setEnabled(false);
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
			montantin = new JLabel();
			montantin.setBounds(new Rectangle(32, 276, 128, 20));
			montantin.setForeground(Color.blue);
			montantin.setText("Montant Inscrip:");
			montantin.setFont(new Font("Elephant", Font.BOLD, 12));
			annee = new JLabel();
			annee.setBounds(new Rectangle(32, 231, 124, 16));
			annee.setForeground(Color.blue);
			annee.setText("Date Inscription");
			annee.setFont(new Font("Elephant", Font.BOLD, 12));
			CLASE = new JLabel();
			CLASE.setBounds(new Rectangle(32, 249, 114, 19));
			CLASE.setForeground(Color.blue);
			CLASE.setFont(new Font("Elephant", Font.BOLD, 12));
			CLASE.setText("Classe  :");
			ADRESSE = new JLabel();
			ADRESSE.setBounds(new Rectangle(31, 201, 115, 19));
			ADRESSE.setForeground(Color.blue);
			ADRESSE.setFont(new Font("Elephant", Font.BOLD, 12));
			ADRESSE.setText("Adresse  :");
			NATIONALITE = new JLabel();
			NATIONALITE.setBounds(new Rectangle(31, 171, 116, 20));
			NATIONALITE.setForeground(Color.blue);
			NATIONALITE.setFont(new Font("Elephant", Font.BOLD, 12));
			NATIONALITE.setText("Nationalite  :");
			LIEU = new JLabel();
			LIEU.setBounds(new Rectangle(31, 142, 124, 16));
			LIEU.setForeground(Color.blue);
			LIEU.setFont(new Font("Elephant", Font.BOLD, 12));
			LIEU.setText("Lieu_Naissance  :");
			DATENAI = new JLabel();
			DATENAI.setBounds(new Rectangle(31, 112, 125, 16));
			DATENAI.setForeground(Color.blue);
			DATENAI.setFont(new Font("Elephant", Font.BOLD, 12));
			DATENAI.setText("Date_Naissance  :");
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
			num = new JLabel();
			num.setBounds(new Rectangle(29, 24, 118, 16));
			num.setForeground(Color.blue);
			num.setFont(new Font("Elephant", Font.BOLD, 12));
			num.setText("Numero :");
			pan = new JPanel();
			pan.setLayout(null);
			pan.setBounds(new Rectangle(459, 283, 413, 310));
			pan.add(num, null);
			pan.add(NOM, null);
			pan.add(PRENOM, null);
			pan.add(DATENAI, null);
			pan.add(LIEU, null);
			pan.add(NATIONALITE, null);
			pan.add(ADRESSE, null);
			pan.add(CLASE, null);
			pan.add(getTxtnum(), null);
			pan.add(getTxtnom(), null);
			pan.add(getTxtprenom(), null);
			pan.add(getTxtdatenaisse(), null);
			pan.add(getTxtlieunaisse(), null);
			pan.add(getTxtnationalite(), null);
			pan.add(getTxtadresse(), null);
			pan.add(annee, null);
			pan.add(getTxtdate(), null);
			pan.add(getTxtclasse(), null);
			pan.add(montantin, null);
			pan.add(getTxtmontant(), null);
		}
		return pan;
	}

	/**
	 * This method initializes txtnum	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtnum() {
		if (txtnum == null) {
			txtnum = new JTextField();
			txtnum.setBounds(new Rectangle(155, 23, 209, 20));
			txtnum.setBackground(SystemColor.controlLtHighlight);
			txtnum.setFont(new Font("Elephant", Font.BOLD, 14));
		}
		return txtnum;
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
	private JTextField getTxtdatenaisse() {
		if (txtdatenaisse == null) {
			txtdatenaisse = new JTextField();
			txtdatenaisse.setBounds(new Rectangle(158, 110, 203, 20));
			txtdatenaisse.setBackground(SystemColor.controlLtHighlight);
			txtdatenaisse.setFont(new Font("Elephant", Font.BOLD, 14));
		}
		return txtdatenaisse;
	}

	/**
	 * This method initializes txtlieunaisse	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtlieunaisse() {
		if (txtlieunaisse == null) {
			txtlieunaisse = new JTextField();
			txtlieunaisse.setBounds(new Rectangle(159, 142, 202, 19));
			txtlieunaisse.setBackground(SystemColor.controlLtHighlight);
			txtlieunaisse.setFont(new Font("Elephant", Font.BOLD, 14));
		}
		return txtlieunaisse;
	}

	/**
	 * This method initializes txtnationalite	
	 * 	
	 * @return javax.swing.JTextField		
	 */
	private JTextField getTxtnationalite() {
		if (txtnationalite == null) {
			txtnationalite = new JTextField();
			txtnationalite.setBounds(new Rectangle(158, 172, 201, 18));
			txtnationalite.setBackground(SystemColor.controlLtHighlight);
			txtnationalite.setFont(new Font("Elephant", Font.BOLD, 14));
		}
		return txtnationalite;
	}

	/**
	 * This method initializes txtadresse	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtadresse() {
		if (txtadresse == null) {
			txtadresse = new JTextField();
			txtadresse.setBounds(new Rectangle(158, 200, 200, 20));
			txtadresse.setBackground(SystemColor.controlLtHighlight);
			txtadresse.setFont(new Font("Elephant", Font.BOLD, 14));
		}
		return txtadresse;
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
	 * This method initializes txtdate	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtdate() {
		if (txtdate == null) {
			txtdate = new JTextField();
			txtdate.setBounds(new Rectangle(159, 228, 199, 18));
			txtdate.setBackground(SystemColor.controlLtHighlight);
			txtdate.setFont(new Font("Elephant", Font.BOLD, 14));
		}
		return txtdate;
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
	 * This method initializes txtclasse	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtclasse() {
		if (txtclasse == null) {
			txtclasse = new JTextField();
			txtclasse.setBounds(new Rectangle(159, 252, 198, 18));
			txtclasse.setBackground(SystemColor.controlLtHighlight);
			txtclasse.setFont(new Font("Elephant", Font.BOLD, 14));
		}
		return txtclasse;
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
	 * This method initializes txtmontant	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtmontant() {
		if (txtmontant == null) {
			txtmontant = new JTextField();
			txtmontant.setBounds(new Rectangle(159, 277, 198, 19));
			txtmontant.setBackground(SystemColor.controlLtHighlight);
			txtmontant.setFont(new Font("Elephant", Font.BOLD, 14));
		}
		return txtmontant;
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