package paiement;

import java.awt.BorderLayout;

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

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.Dimension;

import menu.*;


public class Agent_formpaiement extends JFrame implements ActionListener{

	//public static Connection maco=null;
	//public static Statement st=null;
	//public static ResultSet rs=null;

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel loj = null;

	private JPanel pan = null;

	private JLabel num = null;

	private JLabel NOM = null;

	private JLabel PRENOM = null;

	private JLabel DATENAI = null;

	private JLabel LIEU = null;

	private JLabel NATIONALITE = null;

	private JLabel ADRESSE = null;

	private JPanel pane = null;

	private JButton valider = null;

	private JButton annuler = null;

	private JButton precedent = null;

	private JButton quitter = null;

	private JLabel lab = null;

	private JLabel classe = null;

	  public JLabel txtnum = null;

	public JLabel txtnom = null;

	public JLabel txtprenom = null;

	public JLabel txtdatenaisse = null;

	public JLabel txtlieunaisse = null;

	public JLabel txtnationalite = null;

	public JComboBox txtmontants = null;

	public JLabel txtclasse = null;

	private JLabel mois = null;

	private JComboBox txtdate = null;

	public JLabel ZZZZ = null;

	private JLabel FLECHE = null;

	private JButton aide = null;

	private JPanel panA1 = null;

	private JPanel panA11 = null;
	
	//déclaration des fenêtres
	private NewMenuAgent menuAgent = new NewMenuAgent();

	//private int montante;
	/**
	 * This is the default constructor
	 */
	public Agent_formpaiement() {
		
		super();
		initialize();
		//remplir();
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
		this.setTitle("Formulaire Paiement");
	setVisible(true);
	menuAgent.setVisible(false);

	}
	
	 
	public static Connection initConnection(){
	       Connection co=null;
	       String url="jdbc:mysql://localhost/base_gfs";
	       try{
	       	   Class.forName("org.gjt.mm.mysql.Driver");
	       	   co=DriverManager.getConnection(url,"root","Sc0rpions");

           //System.out.println("ok");
           JOptionPane.showMessageDialog(null,"connexion ok");
		   }
		   catch(ClassNotFoundException fe){
	       	    System.out.println("drv intro");
	       	   }
		   catch(SQLException se){
		   System.out.println("Connection impossible");
		   }
		   return co;

	}
	
	
	public void actionPerformed(ActionEvent e)
	{
			if(e.getSource()==annuler)
			{
				this.dispose();

				menuAgent.setVisible(true);

			}
			else
				if(e.getSource()==precedent)
				{
					this.dispose();

					menuAgent.setVisible(true);
					
				}
				else
					
					if(e.getSource()==quitter)
					{
						this.dispose();

						menuAgent.setVisible(true);					}
	
			
			
			

			if(e.getSource()==valider){
				
				remplir();
				this.dispose();
				menuAgent.setVisible(true);
	
			}
			if(e.getSource()==aide){
				ZZZZ.setEnabled(true);
		}
	}
	

	public void remplir(){
		String num=txtnum.getText();
		String mon;
		String dat;
		String date=(String)txtdate.getSelectedItem();
		
		String mont=(String)txtmontants.getSelectedItem();
		Connection maco=initConnection();
		if(maco==null)return;
		try{
			
			Statement st=maco.createStatement();
			
			 
			 String req1="Select * from validerpaiement ";
			 ResultSet rst=st.executeQuery(req1);
           
             
            while(rst.next()){
            	if(num.equals(rst.getString("numero"))&&(date.equals(rst.getString("Mois"))))
            	{
            		JOptionPane.showMessageDialog(null,"cet etudiant dont le numero est:"+num+" a deja payer ce mois de : "+date+" ");
            		st.close();
            	   this.dispose();
            	 }
             }
           
    	 	   String req4="INSERT INTO  `paiement`( `numero_recu` , `montant` , `Mois` ) VALUES (NULL , '"+mont+"','"+date+"' )";
    	 	
    	 	   st.executeUpdate(req4);
    	 	   
    	 	   
    	 	  String req="Select * from paiement ";
                 ResultSet rs=st.executeQuery(req);
                  rs.next();
            	 mon=rs.getString("numero_recu");
       	         dat=rs.getString("Mois");
              
            	String req3="INSERT INTO  `validerpaiement`( `numero` , `numero_recu` , `Mois` ) VALUES ('"+num+"' , '"+mon+"','"+dat+"' )";
                 st.executeUpdate(req3);
			
                 JOptionPane.showMessageDialog(null,"votre paiement a ete valide avec succes");  
                 Agent_affpaiement A=	new Agent_affpaiement();
              	A.setSize(new Dimension(871, 322));
 				A.txtmois.setText((String)txtdate.getSelectedItem());
 				A.txtnom.setText((String)txtnom.getText());
 				A.txtprenom.setText((String)txtprenom.getText());
 				A.txtsomme.setText((String)txtmontants.getSelectedItem());
                A.txtrecu.setText(rs.getString("numero_recu"));
           
		 
            }
	 	   catch(SQLException se){
	 	 System.out.println("connexion impossible"+se.getMessage());
	          }
	}
	


	
	

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			FLECHE = new JLabel();
			FLECHE.setBounds(new Rectangle(120, 156, 26, 25));
			//FLECHE.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/backup.jpg")));
			FLECHE.setIcon(new ImageIcon("images/backup.jpg"));
			FLECHE.setText(" ");
			ZZZZ = new JLabel();
			ZZZZ.setBounds(new Rectangle(5, 182, 251, 408));
			//ZZZZ.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/image14.gif")));
			ZZZZ.setText(" ");
			lab = new JLabel();
			lab.setBounds(new Rectangle(2, 2, 1290, 105));
			//lab.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/payeme.gif")));
			lab.setText(" ");
			loj = new JLabel();
			loj.setBounds(new Rectangle(570, 116, 184, 160));
			//loj.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/ucad.jpg")));
			loj.setIcon(new ImageIcon("images/ucad.jpg"));
			loj.setText(" ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			//jContentPane.setBackground(SystemColor.info);
			jContentPane.add(loj, null);
			jContentPane.add(getPan(), null);
			jContentPane.add(getPane(), null);
			jContentPane.add(getQuitter(), null);
			jContentPane.add(lab, null);
			jContentPane.add(ZZZZ, null);
			jContentPane.add(FLECHE, null);
			jContentPane.add(getAide(), null);
			jContentPane.add(getPanA1(), null);
			jContentPane.add(getPanA11(), null);
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
			mois = new JLabel();
			mois.setBounds(new Rectangle(33, 222, 120, 20));
			mois.setForeground(Color.blue);
			mois.setText("Mois_Paiement  :");
			mois.setFont(new Font("Elephant", Font.BOLD, 12));
			txtclasse = new JLabel();
			txtclasse.setBounds(new Rectangle(159, 198, 200, 16));
			txtclasse.setForeground(Color.blue);
			txtclasse.setText(" ");
			txtclasse.setFont(new Font("Elephant", Font.BOLD, 12));
			txtnationalite = new JLabel();
			txtnationalite.setBounds(new Rectangle(161, 171, 200, 16));
			txtnationalite.setForeground(Color.blue);
			txtnationalite.setText(" ");
			txtnationalite.setFont(new Font("Elephant", Font.BOLD, 12));
			txtlieunaisse = new JLabel();
			txtlieunaisse.setBounds(new Rectangle(161, 140, 199, 16));
			txtlieunaisse.setForeground(Color.blue);
			txtlieunaisse.setText(" ");
			txtlieunaisse.setFont(new Font("Elephant", Font.BOLD, 12));
			txtdatenaisse = new JLabel();
			txtdatenaisse.setBounds(new Rectangle(161, 111, 200, 16));
			txtdatenaisse.setForeground(Color.blue);
			txtdatenaisse.setText(" ");
			txtdatenaisse.setFont(new Font("Elephant", Font.BOLD, 12));
			txtprenom = new JLabel();
			txtprenom.setBounds(new Rectangle(159, 82, 201, 16));
			txtprenom.setForeground(Color.blue);
			txtprenom.setText(" ");
			txtprenom.setFont(new Font("Elephant", Font.BOLD, 12));
			txtnom = new JLabel();
			txtnom.setBounds(new Rectangle(160, 55, 200, 16));
			txtnom.setForeground(Color.blue);
			txtnom.setText(" ");
			txtnom.setFont(new Font("Elephant", Font.BOLD, 12));
			txtnum = new JLabel();
			txtnum.setBounds(new Rectangle(157, 25, 203, 16));
			txtnum.setForeground(Color.blue);
			txtnum.setText(" ");
			txtnum.setFont(new Font("Elephant", Font.BOLD, 12));
			classe = new JLabel();
			classe.setBounds(new Rectangle(31, 199, 113, 16));
			classe.setForeground(Color.blue);
			classe.setText("Classe  :");
			classe.setFont(new Font("Elephant", Font.BOLD, 12));
			ADRESSE = new JLabel();
			ADRESSE.setBounds(new Rectangle(30, 250, 115, 19));
			ADRESSE.setForeground(Color.blue);
			ADRESSE.setFont(new Font("Elephant", Font.BOLD, 12));
			ADRESSE.setText("Montant  :");
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
			pan.setBounds(new Rectangle(460, 284, 413, 295));
			//pan.setBackground(Color.cyan);
			pan.add(num, null);
			pan.add(NOM, null);
			pan.add(PRENOM, null);
			pan.add(DATENAI, null);
			pan.add(LIEU, null);
			pan.add(NATIONALITE, null);
			pan.add(ADRESSE, null);
			pan.add(classe, null);
			pan.add(txtnum, null);
			pan.add(txtnom, null);
			pan.add(txtprenom, null);
			pan.add(txtdatenaisse, null);
			pan.add(txtlieunaisse, null);
			pan.add(txtnationalite, null);
			pan.add(getTxtmontants(), null);
			pan.add(txtclasse, null);
			pan.add(mois, null);
			pan.add(getTxtdate(), null);
		}
		return pan;
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
			pane.setBounds(new Rectangle(463, 587, 417, 80));
		//	pane.setBackground(Color.cyan);
			pane.add(getValider(), null);
			pane.add(getAnnuler(), null);
			pane.add(getPrecedent(), null);
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
			valider.setBounds(new Rectangle(16, 24, 133, 33));
			//valider.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/enregistrer.gif")));
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
			annuler.setBounds(new Rectangle(154, 24, 119, 34));
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
			//precedent.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/retour.gif")));
			precedent.setIcon(new ImageIcon("images/retour.gif"));
			precedent.setBounds(new Rectangle(278, 23, 132, 34));
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
			quitter.setBounds(new Rectangle(1091, 647, 128, 35));
			//quitter.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/quitter.gif")));
			quitter.setIcon(new ImageIcon("images/quitter.gif"));
			quitter.setText("Quitter");
		}
		return quitter;
	}

	/**
	 * This method initializes txtmontants	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getTxtmontants() {
		if (txtmontants == null) {
			txtmontants = new JComboBox();
			txtmontants.addItem("60000");
			//txtmontants.addItem("80000");
			//txtmontants.addItem("30000");
			//txtmontants.addItem("40000");
			txtmontants.addItem("100000");
			txtmontants.setBounds(new Rectangle(159, 250, 113, 19));
			txtmontants.addActionListener(this);
		}
		return txtmontants;
	}

	/**
	 * This method initializes txtdate	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getTxtdate() {
		if (txtdate == null) {
			txtdate = new JComboBox();
			txtdate.addItem("DECEMBRE");
			txtdate.addItem("JANVIER");
			txtdate.addItem("FEVRIER");
			txtdate.addItem("MARS");
			txtdate.addItem("AVRIL");
			txtdate.addItem("MAI");
			txtdate.addItem("JUIN");
			txtdate.addItem("JUILLET");
			
			
			txtdate.setBounds(new Rectangle(161, 222, 109, 20));
			txtdate.addActionListener(this);
		}
		return txtdate;
	}

	/**
	 * This method initializes aide	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAide() {
		if (aide == null) {
			aide = new JButton();
			aide.setBounds(new Rectangle(112, 116, 41, 37));
			//aide.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/aide.gif")));
			aide.setIcon(new ImageIcon("images/aide.gif"));
			aide.addActionListener(this);
		}
		return aide;
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
			panA1.setBounds(new Rectangle(255, 276, 1030, 8));
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
			panA11.setBounds(new Rectangle(0, 107, 1283, 8));
			panA11.setBackground(Color.black);
		}
		return panA11;
	}

}  //  @jve: