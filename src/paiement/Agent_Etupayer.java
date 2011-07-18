package paiement;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
import menu.*;


public class Agent_Etupayer extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel num = null;

	private JTextField txtnum = null;

	private JButton valider = null;

	private JButton quitter = null;

	private JButton retour = null;

	private JScrollPane scrol = null;

	private JLabel CC = null;

	private JLabel CCX = null;

	private JTable tab = null;


	DefaultTableModel tabl;
	Vector lign1=new Vector();  //  @jve:decl-index=0:
	 Vector col=new Vector();
	// Vector <String>vNomColonne=new Vector<String>();
	 Vector vNomColonne=new Vector();

	
	//déclaration des fenêtres
		private NewMenuAgent menuAgent = new NewMenuAgent();
	
	/**
	 * This is the default constructor
	 */
	public Agent_Etupayer() {
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
		this.setSize(952, 409);
		this.setContentPane(getJContentPane());
		this.setTitle("Paiement par Etudiant");
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
	
	
public void actionPerformed(ActionEvent e){
	if(e.getSource()==retour){
		this.dispose();
		menuAgent.setVisible(true);
	}
	
	if(e.getSource()==quitter){
		this.dispose();
		menuAgent.setVisible(true);

	}
	
	
	if(e.getSource()==valider)
	{
		String x=txtnum.getText();
		int trv=0;
      Connection maCo=initConnection();
      if(maCo==null)return;
      try{
     	 Statement st=maCo.createStatement();
     	
     	 String req="Select  etudiant.nom nom,etudiant.prenom prenom,etudiant.datenais datenais,etudiant.lieunais lieunais,etudiant.classe classe,validerpaiement.Mois Mois  from  etudiant,validerpaiement where  etudiant.numero=validerpaiement.numero and etudiant.numero='"+x+"' ";
     	 ResultSet rs=st.executeQuery(req);
     	 tabl.setRowCount(0);
     	 while(rs.next())
     	    {
     		 trv=1;
     	
     		 
     		Vector ligne=new Vector();
              String dn=rs.getString(3)+"/"+rs.getString(4)+"/"+rs.getString(4);
             // ligne.addElement(rs.getString("numero"));
              ligne.addElement(rs.getString("nom"));
              
              ligne.addElement(rs.getString("prenom"));
              ligne.addElement(rs.getString("datenais"));
              
              ligne.addElement(rs.getString("lieunais"));
             // ligne.addElement(rs.getString("datenais"));
              
              ligne.addElement(rs.getString("classe"));
              ligne.addElement(rs.getString("Mois"));
              
              ligne.addElement(dn);
              
             
             tabl.addRow(ligne);
     	    }

        if(trv==0)JOptionPane.showMessageDialog(null," Numero incorrecte !!! Veillez entrer le bon numero svp!! ");
            rs.close();
            st.close();
       //     c.close();
                       		 
     	 }
      catch(SQLException se){
     	 System.out.println("connexion impossible"+se.getMessage());
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
			CCX = new JLabel();
			CCX.setBounds(new Rectangle(14, 85, 302, 86));
			//CCX.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/111.jpg")));
			CCX.setText(" ");
			CC = new JLabel();
			CC.setBounds(new Rectangle(103, 1, 795, 73));
		//	CC.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/paiementparetudonnee.gif")));
			CC.setText(" ");
			num = new JLabel();
			num.setBounds(new Rectangle(372, 90, 91, 20));
			num.setBackground(Color.blue);
			num.setForeground(Color.blue);
			num.setText("Numero  :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
		//	jContentPane.setBackground(SystemColor.info);
			jContentPane.add(num, null);
			jContentPane.add(getTxtnum(), null);
			jContentPane.add(getValider(), null);
			jContentPane.add(getQuitter(), null);
			jContentPane.add(getRetour(), null);
			jContentPane.add(getScrol(), null);
			jContentPane.add(CC, null);
			jContentPane.add(CCX, null);
			setLocationRelativeTo(null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes txtnum	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtnum() {
		if (txtnum == null) {
			txtnum = new JTextField();
			txtnum.setBounds(new Rectangle(465, 89, 152, 20));
		}
		return txtnum;
	}

	/**
	 * This method initializes valider	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getValider() {
		if (valider == null) {
			valider = new JButton();
			valider.setBounds(new Rectangle(335, 133, 131, 27));
		//	valider.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/enregistrer.gif")));
			valider.setIcon(new ImageIcon("images/enregistrer.gif"));
			valider.setForeground(Color.black);
			valider.setFont(new Font("Elephant", Font.BOLD, 12));
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
			quitter.setBounds(new Rectangle(472, 133, 120, 28));
		//	quitter.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/quitter.gif")));
			quitter.setIcon(new ImageIcon("images/quitter.gif"));
			quitter.setForeground(Color.black);
			quitter.setFont(new Font("Elephant", Font.BOLD, 12));
			quitter.setText("Quitter");
			quitter.addActionListener(this);
		}
		return quitter;
	}

	/**
	 * This method initializes retour	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRetour() {
		if (retour == null) {
			retour = new JButton();
			retour.setBounds(new Rectangle(601, 134, 120, 26));
		//	retour.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/retour.gif")));
			retour.setIcon(new ImageIcon("images/retour.gif"));
			retour.setForeground(Color.black);
			retour.setFont(new Font("Elephant", Font.BOLD, 12));
			retour.setText("Retour");
			retour.addActionListener(this);
		}
		return retour;
	}

	/**
	 * This method initializes scrol	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrol() {
		if (scrol == null) {
			scrol = new JScrollPane();
			scrol.setBounds(new Rectangle(138, 182, 734, 140));
			scrol.setViewportView(getTab());
		}
		return scrol;
	}

	/**
	 * This method initializes tab	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTab() {
		if (tab == null) {
			tab = new JTable();
			
			//vNomColonne.addElement("numero");
			vNomColonne.addElement("nom");

			vNomColonne.addElement("prenom");
			vNomColonne.addElement("datenais");
			vNomColonne.addElement("lieunais");
			
			vNomColonne.addElement("classe");
			vNomColonne.addElement("Mois");
		
		tabl=new DefaultTableModel(vNomColonne,0);
        tab=new JTable(tabl);
        tab.setAutoCreateColumnsFromModel(false);

			
			
		}
		return tab;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
