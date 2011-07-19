package etudiant;

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
import menu.*;

public class FormInscription extends JFrame implements ActionListener {

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

	private JTextField txtnum = null;

	private JTextField txtnom = null;

	private JTextField txtprenom = null;

	private JTextField txtdatenaisse = null;

	private JTextField txtlieunaisse = null;

	private JTextField txtnationalite = null;

	private JTextField txtadresse = null;

	private JPanel pane = null;

			JButton valider = null;

	private JButton annuler = null;

	private JButton precedent = null;

	private JButton quitter = null;

	private JLabel annee = null;

	private JComboBox txtclasse = null;

	private JTextField txtdate = null;

	private JLabel MONTANTINS = null;

	private JTextField txtmontant = null;

	private JLabel anneeinscript = null;

	private JTextField txtinscript = null;

	private JLabel jLabel = null;

	private JPanel panA1 = null;

	private JPanel panA11 = null;

	private JPanel panA12 = null;

	 /**
	 * This is the default constructor
	 */
	
	private MenuSecre menuSec = new MenuSecre();
	
	public FormInscription() {
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
	

	public void actionPerformed(ActionEvent e)
	{
		
		
		if(e.getSource()==txtclasse){
			if((txtclasse.getSelectedItem().toString().compareTo("LicPro")==0))
			{
				//txtmontant.removeAllItems();
				//txtmontant.setText("10000");
			}
			if((txtclasse.getSelectedItem().toString().compareTo("M1 SIR")==0))
			{
			//	txtmontant.removeAllItems();
				//txtmontant.addItem("11000");
			}
			if((txtclasse.getSelectedItem().toString().compareTo("M1 RETEL")==0))
			{
				//txtmontant.removeAllItems();
				//txtmontant.addItem("12000");
			}
			if((txtclasse.getSelectedItem().toString().compareTo("M2 SIR")==0))
			{
				//txtmontant.removeAllItems();
				//txtmontant.addItem("13000");
			}
			if((txtclasse.getSelectedItem().toString().compareTo("M2 RETEL")==0))
			{
				//txtmontant.removeAllItems();
				//txtmontant.addItem("14000");
			}
		}
		
			if(e.getSource()==annuler)
			{
				txtnum.setText("");
				txtnom.setText("");
				txtprenom.setText("");
				txtdatenaisse.setText("");
				txtlieunaisse.setText("");
				txtnationalite.setText("");
				txtadresse.setText("");
				txtmontant.setText("");
				txtinscript.setText("");


				
			}
			if(e.getSource()==txtinscript){
				if((txtinscript.getText().toString().compareTo("2010-2011")==0))
				{
			JOptionPane.showMessageDialog(null," veuillez choisir svp l'annee en cours...");
			}
			}
			else
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
					else
		if(e.getSource()==valider)
		{
			
			if (txtnum.getText().equals("")|| txtnom.getText().equals("") ||txtprenom.getText().equals("")|| txtdatenaisse.getText().equals("")|| txtlieunaisse.getText().equals("")|| txtnationalite.getText().equals("")|| txtadresse.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Veuillez saisir svp  les champs vides...");
			}
			else
			{	
			
	        String num=(txtnum.getText());
			String nom=txtnom.getText();
			String prenom=txtprenom.getText();
			String datenaiss=txtdatenaisse.getText();
			String lieunaiss=txtlieunaisse.getText();
			String nationalite=txtnationalite.getText();
			String adresse=txtadresse.getText();
			String date=(String)txtdate.getText();
			
			String annee=(String)txtinscript.getText();
			
				String classe=(String)txtclasse.getSelectedItem();
			
			String monta=(String)txtmontant.getText();
			
			
			try{
				
				Statement state = authentification.Connect.getInstance()
				.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE, 
							ResultSet.CONCUR_READ_ONLY
				);				
				
				String req3="select * from etudiant   ";
				ResultSet rst=state.executeQuery(req3);
				
				while(rst.next())
				{  String cla=rst.getString("classe");
				String ann=rst.getString("moisInscript");
				if(num.equals(rst.getString("numero"))&&(txtclasse.getSelectedItem().equals(rst.getString("classe"))&&(txtinscript.getText().equals(rst.getString("moisInscript"))))) 
				
					JOptionPane.showMessageDialog(null,"Ce numero :"+num+" est deja inscrit en classe "+cla+" pour l'annee "+ann+" ");
		
				}
				
						
	        String req2="INSERT INTO `etudiant` VALUES('"+num+"','"+nom+"','"+prenom+"','"+datenaiss+"','"+lieunaiss+"','"+nationalite+"','"+adresse+"','"+date+" "+annee+"','"+classe+"','"+monta+"')";

	       int c=state.executeUpdate(req2);
	        if(c==1)
				JOptionPane.showMessageDialog(null," Insertion reussie.....");
	        txtnum.setText("");
			txtnom.setText("");
			txtprenom.setText("");
			txtdatenaisse.setText("");
			txtlieunaisse.setText("");
			txtnationalite.setText("");
			txtadresse.setText("");
			txtinscript.setText("");
			txtmontant.setText("");
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
			anneeinscript = new JLabel();
			anneeinscript.setBounds(new Rectangle(32, 257, 131, 16));
			anneeinscript.setForeground(Color.blue);
			anneeinscript.setText("Annee Inscription");
			anneeinscript.setFont(new Font("Elephant", Font.BOLD, 12));
			MONTANTINS = new JLabel();
			MONTANTINS.setBounds(new Rectangle(31, 309, 126, 22));
			MONTANTINS.setForeground(Color.blue);
			MONTANTINS.setText("Montant Inscription");
			MONTANTINS.setFont(new Font("Elephant", Font.BOLD, 12));
			annee = new JLabel();
			annee.setBounds(new Rectangle(32, 231, 124, 16));
			annee.setForeground(Color.blue);
			annee.setText("Mois_Inscription");
			annee.setFont(new Font("Elephant", Font.BOLD, 12));
			CLASE = new JLabel();
			CLASE.setBounds(new Rectangle(32, 282, 114, 19));
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
			DATENAI.setText("Date Naissance  :");
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
			pan.setBounds(new Rectangle(472, 280, 413, 341));
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
			pan.add(getTxtclasse(), null);
			pan.add(getTxtdate(), null);
			pan.add(MONTANTINS, null);
			pan.add(getTxtmontant(), null);
			pan.add(anneeinscript, null);
			pan.add(getTxtinscript(), null);
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
	private JTextField getTxtdatenaisse() {
		if (txtdatenaisse == null) {
			txtdatenaisse = new JTextField();
			txtdatenaisse.setBounds(new Rectangle(158, 110, 203, 20));
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
			txtlieunaisse.setBounds(new Rectangle(159, 140, 202, 21));
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
			txtnationalite.setBounds(new Rectangle(158, 171, 203, 23));
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
			txtadresse.setBounds(new Rectangle(158, 203, 201, 20));
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
	private JComboBox getTxtclasse() {
		if (txtclasse == null) {
			txtclasse = new JComboBox();
		
			txtclasse.addItem("LicPro");
			txtclasse.addItem("M1 SIR");
			txtclasse.addItem("M1 RETEL");
			txtclasse.addItem("M2 SIR");
			txtclasse.addItem("M2 RETEL");
			
			txtclasse.setBounds(new Rectangle(163, 282, 134, 20));
			txtclasse.addActionListener(this);
		}
		return txtclasse;
	}

	/**
	 * This method initializes txtdate	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JTextField getTxtdate() {
		if (txtdate == null) {
			txtdate = new JTextField();
			//txtdate.addItem("OCTOBRE");
			//txtdate.addItem("NOVEMBRE");
			//txtdate.addItem("DECEMBRE");
			txtdate.setBounds(new Rectangle(165, 227, 131, 21));
			txtdate.addActionListener(this);
		}
		return txtdate;
	}

	/**
	 * This method initializes txtmontant	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JTextField getTxtmontant() {
		if (txtmontant == null) {
			txtmontant = new JTextField();
			txtmontant.setBounds(new Rectangle(163, 312, 134, 22));
			txtmontant.addActionListener(this);
		}
		return txtmontant;
	}

	/**
	 * This method initializes txtinscript	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JTextField getTxtinscript() {
		if (txtinscript == null) {
			txtinscript = new JTextField();
			//txtinscript.addItem("2010-2011");
			txtinscript.setBounds(new Rectangle(165, 255, 131, 21));
			txtinscript.addActionListener(this);
		}
		return txtinscript;
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
