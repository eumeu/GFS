package menu;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

import javax.swing.JOptionPane;
import menu.*;

public class NewMenuAgent extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel PANO = null;

	private JButton valide_paiement = null;

	private JButton liste_paiement = null;

	private JLabel logo = null;

	private JButton quitter = null;

	private JButton cherchEtPaye = null;

	private JLabel valier = null;

	private JLabel AFF = null;

	private JLabel valier1 = null;

	private JLabel XX = null;

	private JLabel XX1 = null;

	private JLabel XX2 = null;

	private JLabel cc = null;
	
	private JPanel panA1 = null;

	private JPanel panA11 = null;

	//dÃ©claration des fenÃªtres
	private MenuAdministra menuAdmin = new MenuAdministra();

	private JButton majEtu;
	/**
	 * This is the default constructor
	 */
	public NewMenuAgent() {
		super();
		initialize();
		this.addWindowListener (new WindowAdapter ( )
		{ public void windowClosing (WindowEvent e)
		{ System.exit (0);
		}});
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1300,800);
		this.setContentPane(getJContentPane());
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(("image/ucad.jpg")));
		this.setTitle("Menu Comptable");
		setVisible(true);
		menuAdmin.setVisible(false);
	}
	
	
	public static Connection initConnection(){
	       Connection co=null;
	       String url="jdbc:mysql://localhost/base_gfs";
	       try{
	       	   Class.forName("org.gjt.mm.mysql.Driver");
	       	   co=DriverManager.getConnection(url,"root","Sc0rpions");

          
           
		   }
		   catch(ClassNotFoundException fe){
	       	    System.out.println("drv intro");
	       	   }
		   catch(SQLException se){
		   System.out.println("Connection Impossible");
		   }
		   return co;

	}
	
	
	public void afficher(){
		int b=0;
	
		String a=JOptionPane.showInputDialog(null,"Donner le numéro de l'etudiant dont vous voulez valider son paiement");
		//String c=JOptionPane.showInputDialog(null,"donner la classe de l'etudiant dont vous voulez valider son paiement");
		Connection maco=initConnection();
		if(maco==null)return;
		try
		{
			Statement st=maco.createStatement();
			String req="select * from etudiant  ";
			ResultSet rs=st.executeQuery(req);
			while(rs.next())
			{
				if(a.equals(rs.getString("numero")))
				{
					b=1;
				paiement.Agent_formpaiement tr=new paiement.Agent_formpaiement();
				tr.txtnum.setText(rs.getString("numero").toString());
				tr.txtnom.setText(rs.getString("nom").toString());
				tr.txtprenom.setText(rs.getString("prenom").toString());
				tr.txtdatenaisse.setText(rs.getString("datenais").toString());
				tr.txtlieunaisse.setText(rs.getString("lieunais").toString());
				tr.txtnationalite.setText(rs.getString("nationalite").toString());
				tr.txtclasse.setText(rs.getString("classe").toString());
				tr.ZZZZ.setEnabled(false);
				//this.dispose();
				
				}	
				}
			maco.close();
			st.close();
			if(b==0)
				JOptionPane.showMessageDialog(null, "Ce numéro n'existe pas dans la base");
		//	this.dispose();
		//	this.setVisible(true);
	}
			
	catch(SQLException se){
		JOptionPane.showMessageDialog(null,"Connexion Impossible"+se.getMessage());
		
	}
		
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		
			if(e.getSource()==valide_paiement )
			{
				afficher();
				this.setVisible(false);
			}
			
			if(e.getSource()==liste_paiement )
			{
				paiement.DatePayement	c=	new paiement.DatePayement();//uniquement pour le comptable
				c.mois.setEnabled(false);
				c.txtclasse.setEnabled(false);
				c.etnonpayer.setEnabled(false);
				c.etpayer.setEnabled(false);
				this.setVisible(false);
			}
	if(e.getSource()==quitter )
	{
		this.dispose();
		menuAdmin.setVisible(true);

	}
	if(e.getSource()==cherchEtPaye ){
	
	new paiement.Agent_Etupayer();
	this.setVisible(false);
	}
	
	
		}

	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			cc = new JLabel();
			cc.setBounds(new Rectangle(3, -2, 1284, 94));
			//cc.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/CHARGE.jpg")));
			cc.setText(" ");
			XX2 = new JLabel();
			XX2.setBounds(new Rectangle(454, 413, 17, 16));
			XX2.setText(" ");
			//XX2.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/btn1.gif")));
			XX1 = new JLabel();
			XX1.setBounds(new Rectangle(453, 365, 16, 16));
			XX1.setText(" ");
			//XX1.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/btn1.gif")));
			XX = new JLabel();
			XX.setBounds(new Rectangle(453, 314, 14, 16));
			//XX.setIcon(new ImageIcon(getClass().getResource("/GFS/ressources/btn1.gif")));
			XX.setText(" ");
			
			valier1 = new JLabel();
			valier1.setBounds(new Rectangle(27, 265, 424, 20));
			valier1.setFont(new Font("Elephant", Font.BOLD, 12));
			valier1.setBackground(Color.black);
			valier1.setForeground(Color.black);
			valier1.setText("Pour afficher Paiement d'un étudiant à partir d'un numéro :");
			
			AFF = new JLabel();
			AFF.setBounds(new Rectangle(27, 215, 400, 19));
			AFF.setFont(new Font("Elephant", Font.BOLD, 12));
			AFF.setBackground(Color.black);
			AFF.setForeground(Color.black);
			AFF.setText("Pour afficher la Liste des Paiements d'une classe donnée :");
			
			valier = new JLabel();
			valier.setBounds(new Rectangle(29, 160, 386, 22));
			valier.setFont(new Font("Elephant", Font.BOLD, 12));
			valier.setBackground(Color.black);
			valier.setForeground(Color.black);
			valier.setText("Pour enregistrer le paiement d'un étudiant : ");
			logo = new JLabel();
			logo.setBounds(new Rectangle(0,0, 177, 163));
			logo.setIcon(new ImageIcon("images/ucad.jpg"));
			logo.setText("");
			
			
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			//jContentPane.setBackground(SystemColor.info);
			jContentPane.add(getPANO(), null);
			jContentPane.add(logo, null);
			jContentPane.add(getQuitter(), null);
			jContentPane.add(valier, null);
			jContentPane.add(AFF, null);
			jContentPane.add(valier1, null);
			jContentPane.add(XX, null);
			jContentPane.add(XX1, null);
			jContentPane.add(XX2, null);
			jContentPane.add(cc, null);
			
			//jContentPane.add(getPanA1(), null);
			//jContentPane.add(getPanA11(), null);
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
			PANO.setBounds(new Rectangle(529, 130, 300, 500));
	//		PANO.setBackground(Color.cyan);
			PANO.add(getValide_paiement(), null);
			PANO.add(getListe_paiement(), null);
			PANO.add(getCherchEtPaye(), null);
			
		}
		return PANO;
	}

		/**
	 * This method initializes valide_paiement	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getValide_paiement() {
		if (valide_paiement == null) {
			valide_paiement = new JButton();
			valide_paiement.setBounds(new Rectangle(25, 19, 240, 34));
			valide_paiement.setIcon(new ImageIcon("images/InBox.gif"));
			valide_paiement.setFont(new Font("Elephant", Font.BOLD, 14));
			valide_paiement.setText("Paiement Mensualité");
			valide_paiement.addActionListener(this);
		}
		return valide_paiement;
	}

	/**
	 * This method initializes liste_paiement	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getListe_paiement() {
		if (liste_paiement == null) {
			liste_paiement = new JButton();
			liste_paiement.setBounds(new Rectangle(26, 75, 240, 32));
			 liste_paiement.setIcon(new ImageIcon("images/consulter.gif"));
			liste_paiement.setFont(new Font("Elephant", Font.BOLD, 14));
			liste_paiement.setText("Liste des Paiements");
			liste_paiement.addActionListener(this);
		}
		return liste_paiement;
	}

	/**
	 * This method initializes quitter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getQuitter() {
		if (quitter == null) {
			quitter = new JButton();
			quitter.setBounds(new Rectangle(580, 640, 171, 35));
			quitter.setText("Quitter");
			quitter.setIcon(new ImageIcon("images/quitter.gif"));
			quitter.setFont(new Font("Elephant", Font.BOLD, 14));
	        quitter.addActionListener(this);
		}
		return quitter;
	}

	/**
	 * This method initializes cherchEtPaye	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCherchEtPaye() {
		if (cherchEtPaye == null) {
			cherchEtPaye = new JButton();
			cherchEtPaye.setText("Paiements Etudiant");
			cherchEtPaye.setIcon(new ImageIcon("images/afficher class.gif"));
			cherchEtPaye.setBounds(new Rectangle(27, 126, 240, 31));
			cherchEtPaye.setFont(new Font("Elephant", Font.BOLD, 14));
			cherchEtPaye.addActionListener(this);
		}
		return cherchEtPaye;
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
			panA1.setBounds(new Rectangle(5, 92, 1281, 17));
			//panA1.setBackground(Color.black);
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
			panA11.setBounds(new Rectangle(1, 274, 1280, 10));
		//	panA11.setBackground(Color.black);
		}
		return panA11;
	}

}  //  @jve:decl-index=0:visual-constraint="-13,-18"
