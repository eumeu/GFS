package authentification;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.util.*;
import javax.swing.JTable;
import java.awt.event.*;

import javax.swing.JScrollPane;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import menu.*;
public class AuthenEtu extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel titre = null;

	private JLabel LOGIN = null;

	private JLabel lo = null;

	private JPanel pan = null;

	private JButton valider = null;

	private JButton quitter = null;

	private JTextField txtnum = null;
protected Object[][]data;
private JTable tab;

//déclaration des fenêtres
private MenuGeneral menuGen = new MenuGeneral();
	/**
	 * This is the default constructor
	 */
	public AuthenEtu() {
		super();
		initialize();
		remplir();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	/**


	 */
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(545, 370);
		this.setContentPane(getJContentPane());
		this.setTitle("Authentification Etudiant");
	setVisible(true);
	}
	
	
	public void creer_liste(){
		setLayout(new BorderLayout());
		remplir();
		String[] column={"numero","nom","prenom","datenais","lieunais","nationalite","moisInscript","classe","Mois","Montant"};
	
	 tab=new JTable(data,column);
	 //remplir();
		add(new JScrollPane(tab),BorderLayout.CENTER);
		
	}
	public void remplir(){
		String x=txtnum.getText();
		int count;
		//int trv=0;
		Vector col1=new Vector();
		Vector col2=new Vector();
		Vector col3=new Vector();
		Vector col4=new Vector();
		Vector col5=new Vector();
		Vector col6=new Vector();
		Vector col7=new Vector();
		Vector col8=new Vector();
		Vector col9=new Vector();
		Vector col10=new Vector();
		
		{
		
		
		try{
			int trv=0;
			
			Statement state = authentification.Connect.getInstance()
			.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY
			);				
			
			String req="Select etudiant.numero numero, etudiant.nom nom ,etudiant.prenom prenom ,etudiant.datenais datenais ,etudiant.lieunais lieunais, etudiant.nationalite nationalite, etudiant.moisInscript moisInscript, etudiant.classe classe ,validerpaiement.Mois Mois,paiement.Montant Montant from etudiant,validerpaiement,paiement where etudiant.numero=validerpaiement.numero and validerpaiement.numero_recu=paiement.numero_recu and etudiant.numero='"+x+"'  ";
		ResultSet rs=state.executeQuery(req);
while(rs.next()){
	if(x.equals(rs.getString("numero")))
	{
		trv=1;
		col1.addElement(rs.getString("numero"));
		col2.addElement(rs.getString("nom"));
		col3.addElement(rs.getString("prenom"));
		col4.addElement(rs.getString("datenais"));
		col5.addElement(rs.getString("lieunais"));
		col6.addElement(rs.getString("nationalite"));
		col7.addElement(rs.getString("moisInscript"));
		col8.addElement(rs.getString("classe"));
		col9.addElement(rs.getString("Mois"));
		col10.addElement(rs.getString("Montant"));
		
		
	}
	
}
       
rs.close();
state.close();

		}
		catch(SQLException se){
			System.out.println("Echec connexion bdd"+se.getMessage());
		}
		
		count=col1.size();
		data=new Object[col1.size()][10];
		for(int i=0;i<col1.size();i++){
			data[i][0]=col1.elementAt(i);
			}
		for(int i=0;i<col1.size();i++){
			data[i][1]=col2.elementAt(i);
		}
		for(int i=0;i<col1.size();i++){
			data[i][2]=col3.elementAt(i);
		}
		for(int i=0;i<col1.size();i++){
			data[i][3]=col4.elementAt(i);
		}
		for(int i=0;i<col1.size();i++){
			data[i][4]=col5.elementAt(i);
		}
		for(int i=0;i<col1.size();i++){
			data[i][5]=col6.elementAt(i);
		}
		for(int i=0;i<col1.size();i++){
			data[i][6]=col7.elementAt(i);
		}
		for(int i=0;i<col1.size();i++){
			data[i][7]=col8.elementAt(i);
		}
		for(int i=0;i<col1.size();i++){
			data[i][8]=col9.elementAt(i);
		}
		for(int i=0;i<col1.size();i++){
			data[i][9]=col10.elementAt(i);
		}
		
		}
		
		
	}
	public void actionPerformed (ActionEvent e){
	if(e.getSource()==valider)
	{
		int trv=0;
	String x=txtnum.getText();
		try{
			
			Statement state = authentification.Connect.getInstance()
			.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY
			);				
			
			String req1="select *from etudiant";
			ResultSet rst=state.executeQuery(req1);
			while(rst.next()){
			if(x.equals(rst.getString("numero")))
			{	
			trv=1;
			
			
		JFrame pano=new JFrame();
		JPanel pa=new JPanel();
		remplir();
		pa.setLayout(new BorderLayout());
		//pa.setBackground(Color.cyan);
		String[] column={"numero","nom","prenom","datenais","lieunais","nationalite","moisInscript","classe","Mois","Montant"};
		JTable tabe=new JTable(data,column);
		
		pa.add(tabe);
		pano.setContentPane(pa);
		pano.setSize(new Dimension(1000,300));
	//	pano.setBackground(Color.cyan);
		pano.setTitle("Consultation pour le Paiement d'un Etudiant ");
		pano.setVisible(true);
		
			}
			
			}
			rst.close();
			state.close();
			if(trv==0)JOptionPane.showMessageDialog(null,"votre numero n'est pas dans la base de donnee");
		}
		catch(SQLException se){
			System.out.println("Echec connexion bdd "+se.getMessage());
		
			
		
	                
		}
		}
	if(e.getSource()==quitter){
		this.dispose();
		menuGen.setVisible(true);
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
			LOGIN.setBounds(new Rectangle(133, 201, 86, 21));
			LOGIN.setBackground(Color.blue);
			LOGIN.setForeground(Color.blue);
			LOGIN.setFont(new Font("Elephant", Font.BOLD, 12));
			LOGIN.setText("Numero :");
			titre = new JLabel();
			titre.setBounds(new Rectangle(4, 3, 501, 30));
			titre.setFont(new Font("Elephant", Font.BOLD, 12));
			titre.setBackground(Color.blue);
			titre.setForeground(Color.blue);
			titre.setText("Veuillez donner votre Numero pour Verifier vos Paiements Svp");
			titre.setText("Merci de respecter la casse !");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			//jContentPane.setBackground(SystemColor.info);
			jContentPane.add(titre, null);
			jContentPane.add(LOGIN, null);
			jContentPane.add(lo, null);
			jContentPane.add(getPan(), null);
			jContentPane.add(getTxtnum(), null);
			setLocationRelativeTo(null);
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
			pan = new JPanel();
			pan.setLayout(null);
			pan.setBounds(new Rectangle(114, 245, 328, 54));
		//	pan.setBackground(Color.pink);
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
		//	quitter.setBackground(Color.cyan);
			quitter.setFont(new Font("Elephant", Font.BOLD, 12));
			quitter.setIcon(new ImageIcon("images/quitter.gif"));

			quitter.setText("Quitter");
			quitter.addActionListener(this);
		}
		return quitter;
	}

	/**
	 * This method initializes txtnum	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtnum() {
		if (txtnum == null) {
			txtnum = new JTextField();
			txtnum.setBounds(new Rectangle(221, 202, 195, 20));
		}
		return txtnum;
	}

}  //  @jve:decl-index=0:visual-constraint="164,21"