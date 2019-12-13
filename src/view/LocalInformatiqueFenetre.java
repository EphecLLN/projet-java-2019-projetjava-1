package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Ecole;

public class LocalInformatiqueFenetre extends Vue {
	
/////////////////////////////////////////*ATTRIBUTS*//////////////////////////////////////////////////////////////////////////////////////

	private JPanel contentPane;
    private JFrame j7;
    private JTextField txtLocal;
	private JTextField txtChaise;
	private JTextField txtTable;
	private JTextField txtNombrePc;
	private JTextField txtType;
	private JTextField txtToure;
	private JTextField txtEcran;
	private JTextField txtClavier;
	private JTextField txtSouris;
	private JTextField txtCommentaire;
    
////////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Create the frame.
	 */
	public LocalInformatiqueFenetre(Ecole model, Controller controller) {
		super(model, controller);
		j7.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		j7 = new JFrame();
		j7.setTitle("Local Informatique");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j7.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 506, 484);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Creation du champs de texte indiquant le local
		txtLocal = new JTextField();
		txtLocal.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtLocal.setBounds(10, 10, 96, 19);
		panel.add(txtLocal);
		txtLocal.setColumns(10);
		
		//Creation du label Materiels
		JLabel lblNewLabel = new JLabel("Mat\u00E9riels :");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 39, 96, 16);
		panel.add(lblNewLabel);
		
		//Creation du label chaise
		JLabel lblChaises = new JLabel("Chaises");
		lblChaises.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblChaises.setBounds(10, 65, 54, 13);
		panel.add(lblChaises);
		
		//Creation du label Table
		JLabel lblTables = new JLabel("Tables");
		lblTables.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTables.setBounds(10, 82, 48, 19);
		panel.add(lblTables);
		
		//Creation du boutton permettant d'actualiser le nombre de table et chaise
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnActualiser.setBounds(89, 37, 112, 21);
		panel.add(btnActualiser);
		
		//Creation du label Materiel special
		JLabel lblMaterielSpecial = new JLabel("Materiel special :");
		lblMaterielSpecial.setFont(new Font("Dialog", Font.BOLD, 12));
		lblMaterielSpecial.setBounds(10, 111, 96, 19);
		panel.add(lblMaterielSpecial);
		
		//Creation d'une box permettant de selectionner un Materiel special du local
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox.setBounds(10, 140, 96, 21);
		panel.add(comboBox);
		
		//Creation d'un bouton permettant de changer l'etat d'un materiel sppecial
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnModifier.setBounds(127, 140, 101, 21);
		panel.add(btnModifier);
		
		//Creation du label intervention
		JLabel lblIntervention = new JLabel("Intervention :");
		lblIntervention.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIntervention.setBounds(13, 171, 93, 18);
		panel.add(lblIntervention);
		
		//Creation d'une box permettant de selectionner une intervention 
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox_1.setBounds(10, 199, 96, 21);
		panel.add(comboBox_1);
		
		//Creation d'un permettant de modifier une intervention 
		JButton btnModifier_1 = new JButton("Modifier");
		btnModifier_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnModifier_1.setBounds(127, 199, 101, 22);
		panel.add(btnModifier_1);
		
		//Creation du champs affichant le nombre de chaise
		txtChaise = new JTextField();
		txtChaise.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtChaise.setBounds(63, 63, 43, 19);
		panel.add(txtChaise);
		txtChaise.setColumns(10);
		
		//Creation du champs affichant le nombre de table
		txtTable = new JTextField();
		txtTable.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtTable.setBounds(63, 83, 43, 19);
		panel.add(txtTable);
		txtTable.setColumns(10);
		
		//Creation d'un bouton qui ouvre une fenetre permettant d'ajouter du materiel
		JButton btnAjouterMateriel = new JButton("Ajouter Materiel");
		btnAjouterMateriel.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouterMateriel.setBounds(10, 240, 119, 25);
		panel.add(btnAjouterMateriel);
		
		//Creation d'un bouton qui ouvre une fenetre permettant d'ajouter du materiel special
		JButton btnAjouterMaterielSpecial = new JButton("Ajouter Materiel Special");
		btnAjouterMaterielSpecial.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouterMaterielSpecial.setBounds(137, 240, 160, 24);
		panel.add(btnAjouterMaterielSpecial);
		
		//Creation du label Nombre de PC
		JLabel lblNombreDePc = new JLabel("Nombre de PC :");
		lblNombreDePc.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNombreDePc.setBounds(10, 286, 93, 19);
		panel.add(lblNombreDePc);
		
		//Creation du champs affichant le nombre de PC
		txtNombrePc = new JTextField();
		txtNombrePc.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNombrePc.setBounds(116, 287, 48, 19);
		panel.add(txtNombrePc);
		txtNombrePc.setColumns(10);
		
		//Creation du label Etat PC
		JLabel lblEtatPc = new JLabel("Etat PC ");
		lblEtatPc.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEtatPc.setBounds(10, 323, 54, 16);
		panel.add(lblEtatPc);
		
		//Creation d'une box permettant d'afficher les pc 
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox_2.setBounds(61, 322, 68, 21);
		panel.add(comboBox_2);
		
		//Creation d'un bouton permettant de valider le choix d'un pc et d'afficher ses caractéristiques
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewButton.setBounds(143, 321, 85, 22);
		panel.add(btnNewButton);
		
		//Creation du label Type
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 363, 45, 13);
		panel.add(lblNewLabel_1);
		
		//Creation du label Toure
		JLabel lblToure = new JLabel("Toure");
		lblToure.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblToure.setBounds(10, 391, 45, 13);
		panel.add(lblToure);
		
		//Creation du label Ecran
		JLabel lblNewLabel_2 = new JLabel("Ecran");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 414, 45, 13);
		panel.add(lblNewLabel_2);
		
		//Creation du champs affichant le type du pc 
		txtType = new JTextField();
		txtType.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtType.setBounds(63, 361, 96, 19);
		panel.add(txtType);
		txtType.setColumns(10);
		
		//Creation du champs affichant les informations sur la toure
		txtToure = new JTextField();
		txtToure.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtToure.setBounds(63, 389, 96, 19);
		panel.add(txtToure);
		txtToure.setColumns(10);
		
		//Creation du champs affichant les informations de l'ecran
		txtEcran = new JTextField();
		txtEcran.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEcran.setBounds(63, 414, 96, 19);
		panel.add(txtEcran);
		txtEcran.setColumns(10);
		
		//Creation du label Clavier
		JLabel lblNewLabel_3 = new JLabel("Clavier");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(197, 364, 45, 13);
		panel.add(lblNewLabel_3);
		
		//Creation du label Souris
		JLabel lblNewLabel_4 = new JLabel("Souris");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(197, 392, 45, 13);
		panel.add(lblNewLabel_4);
		
		//Creation du label Commentaire
		JLabel lblNewLabel_5 = new JLabel("Commentaire");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(197, 415, 85, 13);
		panel.add(lblNewLabel_5);
		
		//Creation du champs affichant les informations du clavier
		txtClavier = new JTextField();
		txtClavier.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtClavier.setBounds(284, 412, 191, 19);
		panel.add(txtClavier);
		txtClavier.setColumns(10);
		
		//Creation du champs affichant les informations sur la souris
		txtSouris = new JTextField();
		txtSouris.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtSouris.setBounds(284, 389, 96, 19);
		panel.add(txtSouris);
		txtSouris.setColumns(10);
		
		//Creation du champs affichants les commentaires
		txtCommentaire = new JTextField();
		txtCommentaire.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCommentaire.setBounds(284, 361, 96, 19);
		panel.add(txtCommentaire);
		txtCommentaire.setColumns(10);
	
		//Creation creation d'un bouton qui ouvre une fenetre permettant d'ajouter un pc
		JButton btnNewButton_1 = new JButton("Ajouter PC");
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewButton_1.setBounds(10, 453, 96, 21);
		panel.add(btnNewButton_1);
		
		//Creation d'un bouton qui supprimera le pc selectioné
		JButton btnNewButton_2 = new JButton("Supprimer PC");
		btnNewButton_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewButton_2.setBounds(116, 453, 112, 21);
		panel.add(btnNewButton_2);
		
		//Creation d'une box permettant de selectioner le pc a supprimer
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox_3.setBounds(238, 454, 59, 21);
		panel.add(comboBox_3);
		
		j7.setVisible(true);
	}
	
///////////////////////////////////////*METHODES*/////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affiche(String string) {
		// TODO Auto-generated method stub
		
	}
}
