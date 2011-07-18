package paiement;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;

import java.util.Vector;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JRadioButton;


import menu.*;

public class DatePayement extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel1 = null;

	private JLabel clas = null;

	private JPanel jPanel = null;

	public JComboBox mois = null;

	private JLabel du = null;

	public JButton etpayer = null;

	 public JButton etnonpayer = null;

	private JScrollPane scrol = null;

//	private JButton quitter = null;

	private JTable tab = null;

	private JButton QUITTER = null;

	private JLabel jLabel2 = null;

public	 JComboBox txtclasse = null;

	private JButton precedent = null;
	
	
	
	
	DefaultTableModel tabl;
	Vector lign1=new Vector();  //  @jve:decl-index=0:
	 Vector col=new Vector();
	// Vector <String>vNomColonne=new Vector<String>();
	 Vector vNomColonne=new Vector();

	private JLabel jLabel = null;

	private JRadioButton rpayer = null;

	private JRadioButton rnonpayer = null;

	private JLabel titre = null;

	private JLabel titre1 = null;

	private JLabel logo = null;

	private JLabel logo1 = null;
ButtonGroup group=null;

private JPanel panA1 = null;

private JPanel panA11 = null;

//déclaration des fenêtres
private NewMenuAgent menuAgent = new NewMenuAgent();
	/**
	 * This is the default constructor
	 */
	public DatePayement() {
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
		this.setSize(1291, 789);
		this.setContentPane(getJContentPane());
		this.setTitle("Formulaire de Relevement de Paiement");
		setVisible(true);
		menuAgent.setVisible(false);
	
	}
	
	public static Connection initConnection(){
	       Connection co=null;
	       String url="jdbc:mysql://localhost/base_gfs";
	       try{
	       	   Class.forName("org.gjt.mm.mysql.Driver");
	       	   co=DriverManager.getConnection(url,"root","Sc0rpions");
	       	   JOptionPane.showMessageDialog(null,"connexion ok");
		   }
		   catch(ClassNotFoundException fe){
	       	    System.out.println("drv intro");
	       	   }
		   catch(SQLException se){
		   System.out.println("Connection Impossible");
		   }
		   return co;

	}

	public void actionPerformed(ActionEvent e){
	if(e.getSource()==QUITTER){
		this.dispose();
		menuAgent.setVisible(true);
	}
	if(e.getSource()==rpayer){
	mois.setEnabled(true);
	txtclasse.setEnabled(true);
	etpayer.setEnabled(true);
	etnonpayer.setEnabled(false);
	}
	if(e.getSource()==rnonpayer){
		txtclasse.setEnabled(true);
		etnonpayer.setEnabled(true);
		mois.setEnabled(false);
    	//txtclasse.setEnabled(false);
    	etpayer.setEnabled(false);
	}
	if(e.getSource()==precedent){
	//	new menu.MenuAgen();
		this.dispose();
		menuAgent.setVisible(true);
		}
	if(e.getSource()==etpayer)
	{int trv=0;
	//	String x=txtnum.getText();
		String y=(String)txtclasse.getSelectedItem();
		String v=(String)mois.getSelectedItem();
      Connection maCo=initConnection();
      if(maCo==null)return;
      try{
     	 Statement st=maCo.createStatement();
     	 String req="Select etudiant.numero numero,etudiant.nom nom,etudiant.prenom prenom,etudiant.datenais datenais,etudiant.lieunais lieunais from  etudiant,validerpaiement where validerpaiement.numero=etudiant.numero and etudiant.classe='"+y+"' and validerpaiement.Mois='"+v+"' ";
     	 ResultSet rs=st.executeQuery(req);
     	 tabl.setRowCount(0);
     	 while(rs.next())
     	    {trv=1;
     	//	 Vector <String>ligne=new Vector<String>();
     		 
     		Vector ligne=new Vector();
              String dn=rs.getString(3)+"/"+rs.getString(4)+"/"+rs.getString(4);
              ligne.addElement(rs.getString("numero"));
              ligne.addElement(rs.getString("nom"));
              
              ligne.addElement(rs.getString("prenom"));
              ligne.addElement(rs.getString("datenais"));
              ligne.addElement(rs.getString("lieunais"));
              ligne.addElement(dn);
              tabl.addRow(ligne);


            }
            rs.close();
            st.close();
            if(trv==0)JOptionPane.showMessageDialog(null," Aucun etudiant de la classe "+y+"  n'a payer ce mois de "+v+" ");    		 
     	 }
      catch(SQLException se){
     	 System.out.println("connexion ipossible"+se.getMessage());
      }
		
      mois.setEnabled(false);
  	txtclasse.setEnabled(false);
  	etpayer.setEnabled(false);
      
	}
	if(e.getSource()==etnonpayer)
	{
	//int trouv=0;
		int trv=0;
			//String x=txtnum.getText();
			String y=(String)txtclasse.getSelectedItem();
			String v=(String)mois.getSelectedItem();
	      Connection maCo=initConnection();
	      if(maCo==null)return;
	      try{
	     	 Statement st=maCo.createStatement();
	     	//String req="Select  etudiant.numero numero,etudiant.nom nom,etudiant.prenom prenom,etudiant.datenais datenais,etudiant.lieunais lieunais from  etudiant where not exists(Select * from validerpaiement where etudiant.numero=validerpaiement.numero )";
	     	String req="Select  etudiant.numero numero,etudiant.nom nom,etudiant.prenom prenom,etudiant.datenais datenais,etudiant.lieunais lieunais,  etudiant.classe classe                          from  etudiant where      not exists(Select * from validerpaiement where etudiant.numero=validerpaiement.numero)   and   etudiant.classe='"+y+"'      ";
	     	 
	     	 
	     	 //String rq="Select count(numero) as nombre from etudiant,validerpaiement where etudiant.numero=validerpaiement.numero and etudiant.classe='"+y+"'";
	     	 ResultSet rs=st.executeQuery(req);
	     	 tabl.setRowCount(0);
	     	 while(rs.next())
	     	    {
	     		 trv=1;
	     	//	 Vector <String>ligne=new Vector<String>();
	     		 
	     		Vector ligne=new Vector();
	              String dn=rs.getString(3)+"/"+rs.getString(4)+"/"+rs.getString(4);
	              ligne.addElement(rs.getString("numero"));
	              ligne.addElement(rs.getString("nom"));
	              
	              ligne.addElement(rs.getString("prenom"));
	              ligne.addElement(rs.getString("datenais"));
	              ligne.addElement(rs.getString("lieunais"));
	              //ligne.addElement(rs.getString("datenais"));
	              ligne.addElement(dn);
	              
	             
	             tabl.addRow(ligne);
	     	    }

	     	if(trv==0)JOptionPane.showMessageDialog(null," aucun etudiant de la classe "+y+"  n'est a jour !!!!!! ");    		 
	            rs.close();
	            st.close();
	       //     c.close();
	                       		 
	     	 }
	      catch(SQLException se){
	     	 System.out.println("connexion ipossible"+se.getMessage());
	      }
			
	      mois.setEnabled(false);
	    	txtclasse.setEnabled(false);
	    	etnonpayer.setEnabled(false);
		}
	
	}


	


	
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			logo1 = new JLabel();
			logo1.setBounds(new Rectangle(539, 298, 25, 17));
			logo1.setText(" ");
			//logo1.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/backdown.jpg")));
			logo1.setIcon(new ImageIcon("images/backdown.jpg"));
			logo = new JLabel();
			logo.setBounds(new Rectangle(539, 277, 25, 16));
		//	logo.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/backdown.jpg")));
			logo.setIcon(new ImageIcon("images/backdown.jpg"));
			logo.setText(" ");
			titre1 = new JLabel();
			titre1.setBounds(new Rectangle(568, 297, 678, 16));
			titre1.setBackground(Color.black);
			titre1.setForeground(Color.black);
			titre1.setText("Cliquez Ici Puis Choisir la Classe et Cliquez sur button \"Etudiant non payer\" pour consulter ceux qui ne sont pas a jour");
			titre = new JLabel();
			titre.setBounds(new Rectangle(567, 279, 621, 16));
			titre.setBackground(Color.black);
			titre.setForeground(Color.black);
			titre.setText("Cliquez Ici Puis choisir Classe et Mois et le Button \"Etudiant Payer\"Pour Consulter les Etudiants a Jour");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(-3, -1, 1283, 104));
		//	jLabel.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/formul17.jpg")));
			jLabel.setText("");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(2, 111, 349, 205));
		//	jLabel2.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/tabet.gif")));
			jLabel2.setText(" ");
			du = new JLabel();
			du.setBounds(new Rectangle(510, 351, 92, 23));
			du.setFont(new Font("Elephant", Font.BOLD, 14));
			du.setBackground(Color.blue);
			du.setForeground(Color.blue);
			du.setText("Mois  :");
			clas = new JLabel();
			clas.setBounds(new Rectangle(511, 320, 90, 20));
			clas.setFont(new Font("Elephant", Font.BOLD, 14));
			clas.setBackground(Color.blue);
			clas.setForeground(Color.blue);
			clas.setText("Classe  :");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(590, 108, 170, 155));
		//	jLabel1.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/ucad.jpg")));
			jLabel1.setIcon(new ImageIcon("images/ucad.jpg"));
			jLabel1.setText(" ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
		//	jContentPane.setBackground(SystemColor.info);
			jContentPane.add(jLabel1, null);
			jContentPane.add(clas, null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getMois(), null);
			jContentPane.add(du, null);
			jContentPane.add(getScrol(), null);
		//	jContentPane.add(getQuitter(), null);
			jContentPane.add(getQUITTER(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getTxtclasse(), null);
			jContentPane.add(getPrecedent(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getRpayer(), null);
			jContentPane.add(getRnonpayer(), null);
			jContentPane.add(titre, null);
			jContentPane.add(titre1, null);
			jContentPane.add(logo, null);
			jContentPane.add(logo1, null);
			jContentPane.add(getPanA1(), null);
			jContentPane.add(getPanA11(), null);
			group=new ButtonGroup();
			group.add(getRpayer());
			group.add(getRnonpayer());
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new Rectangle(393, 384, 535, 48));
		//	jPanel.setBackground(Color.cyan);
			jPanel.add(getEtpayer(), null);
			jPanel.add(getEtnonpayer(), null);
		}
		return jPanel;
	}

	
	private JComboBox getMois() {
		if (mois == null) {
			mois = new JComboBox();
			mois.addItem("DECEMBRE");
			mois.addItem("JANVIER");
			mois.addItem("FEVRIER");
			mois.addItem("MARS");
			mois.addItem("AVRIL");
			mois.addItem("MAI");
			mois.addItem("JUIN");
			mois.addItem("JUILLET");
			
			
			mois.setBounds(new Rectangle(604, 351, 156, 25));
			mois.setForeground(Color.black);
			mois.addActionListener(this);
			
			
		}
		return mois;
	}

	/**
	 * This method initializes etpayer	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getEtpayer() {
		if (etpayer == null) {
			etpayer = new JButton();
			etpayer.setBounds(new Rectangle(73, 8, 165, 32));
			etpayer.setFont(new Font("Elephant", Font.BOLD, 12));
			etpayer.setForeground(Color.black);
			etpayer.setText("Etudiant Payer");
			etpayer.addActionListener(this);
		}
		return etpayer;
	}

	/**
	 * This method initializes etnonpayer	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getEtnonpayer() {
		if (etnonpayer == null) {
			etnonpayer = new JButton();
			etnonpayer.setText("Etudiant non payer");
			etnonpayer.setFont(new Font("Elephant", Font.BOLD, 12));
			etnonpayer.setForeground(Color.black);
			etnonpayer.setBounds(new Rectangle(278, 8, 167, 31));
			etnonpayer.addActionListener(this);
		}
		return etnonpayer;
	}

	/**
	 * This method initializes scrol	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrol() {
		if (scrol == null) {
			scrol = new JScrollPane();
			scrol.setBounds(new Rectangle(192, 436, 922, 231));
			scrol.setViewportView(getTab());
		}
		return scrol;
	}

	/**
	 * This method initializes quitter	
	 * 	
	 * @return javax.swing.JButton	
	 */


	/**
	 * This method initializes tab	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTab() {
		if (tab == null) {
			tab = new JTable();
			
			vNomColonne.addElement("numero");
			vNomColonne.addElement("nom");

			vNomColonne.addElement("prenom");
			vNomColonne.addElement("datenais");
			vNomColonne.addElement("lieunais");
			
			//vNomColonne.addElement("classe");
			//vNomColonne.addElement("datepaiement");
		
		tabl=new DefaultTableModel(vNomColonne,0);
        tab=new JTable(tabl);
        tab.setAutoCreateColumnsFromModel(false);

		}
		return tab;
	}

	/**
	 * This method initializes QUITTER	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getQUITTER() {
		if (QUITTER == null) {
			QUITTER = new JButton();
			QUITTER.setBounds(new Rectangle(1045, 705, 147, 26));
			QUITTER.setText("Quitter");
			//QUITTER.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/quitter.gif")));
			QUITTER.setIcon(new ImageIcon("images/quitter.gif"));

			QUITTER.setFont(new Font("Elephant", Font.BOLD, 12));
			QUITTER.addActionListener(this);
		}
		return QUITTER;
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
			//txtclasse.addItem("LPGI2");
			//txtclasse.addItem("LPGI3");
			//txtclasse.addItem("LPRT1");
			txtclasse.addItem("M1 SIR");
			txtclasse.addItem("M2 RETEL");
			txtclasse.addItem("M2 SIR");
			txtclasse.addItem("M2 RETEL");
		//	txtclasse.addItem("MaDSI");
			txtclasse.setBounds(new Rectangle(603, 319, 154, 23));
			txtclasse.setForeground(Color.black);
			txtclasse.addActionListener(this);
		}
		return txtclasse;
	}

	/**
	 * This method initializes precedent	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getPrecedent() {
		if (precedent == null) {
			precedent = new JButton();
			precedent.setBounds(new Rectangle(891, 707, 143, 26));
			//precedent.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/retour.gif")));
			precedent.setIcon(new ImageIcon("images/retour.gif"));

			precedent.setText("Precedent");
			precedent.setFont(new Font("Elephant", Font.BOLD, 12));
			precedent.addActionListener(this);
		}
		return precedent;
	}

	/**
	 * This method initializes rpayer	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRpayer() {
		if (rpayer == null) {
			rpayer = new JRadioButton();
			rpayer.setBounds(new Rectangle(515, 274, 21, 21));
			rpayer.addActionListener(this);
		}
		return rpayer;
	}

	/**
	 * This method initializes rnonpayer	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRnonpayer() {
		if (rnonpayer == null) {
			rnonpayer = new JRadioButton();
			rnonpayer.setBounds(new Rectangle(516, 296, 21, 21));
			rnonpayer.addActionListener(this);
		}
		return rnonpayer;
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
			panA1.setBounds(new Rectangle(1, 260, 1272, 10));
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
			panA11.setBounds(new Rectangle(1, 102, 1272, 10));
			panA11.setBackground(Color.black);
		}
		return panA11;
	}

}  //  @jve:decl-index=0:visual-constraint="-250,-94"
