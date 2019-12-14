package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Ecole;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AjouterPCFenetre extends Vue {
	
/////////////////////////////////////////*ATTRIBUTS*//////////////////////////////////////////////////////////////////////////////////////

	private JPanel contentPane;
	private JFrame j8;
	private JLabel lblType;
	private JLabel lblToure;
	private JLabel lblEcran;
	private JLabel lblClavier;
	private JLabel lblSouris;
	private JLabel lblCommentaire;
	private JTextField txtType;
	private JTextField txtToure;
	private JTextField txtEcran;
	private JTextField txtClavier;
	private JTextField txtSouris;
	private JTextField txtCommentaire;
	private JButton btnAjouter;

////////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Creation de la fenetre 
	 */
	public AjouterPCFenetre(Ecole model, Controller controller) {
		super(model,controller);
		j8 = new JFrame();
		j8.setVisible(true);
		j8.setBounds(100, 100, 275, 264);
		contentPane = new JPanel();
		j8.setTitle("Ajouter PC");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j8.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 259, 225);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Creation du label Type
		lblType = new JLabel("Type");
		lblType.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblType.setBounds(10, 10, 45, 13);
		panel.add(lblType);
		
		//Creation du label Tour
		lblToure = new JLabel("Tour");
		lblToure.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblToure.setBounds(10, 44, 45, 13);
		panel.add(lblToure);
		
		//Creation du label Ecran
		lblEcran = new JLabel("Ecran");
		lblEcran.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEcran.setBounds(10, 77, 45, 13);
		panel.add(lblEcran);
		
		//Creation du label Clavier
		lblClavier = new JLabel("Clavier");
		lblClavier.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblClavier.setBounds(10, 108, 45, 13);
		panel.add(lblClavier);
		
		//Creation du label Souris
		lblSouris = new JLabel("Souris");
		lblSouris.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblSouris.setBounds(10, 137, 45, 13);
		panel.add(lblSouris);
		
		//Creation du label Commentaire
		lblCommentaire = new JLabel("Commentaire");
		lblCommentaire.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCommentaire.setBounds(10, 166, 84, 13);
		panel.add(lblCommentaire);
		
		//Creation du champs permettant de renseigner le type
		txtType = new JTextField();
		txtType.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtType.setBounds(65, 8, 96, 19);
		panel.add(txtType);
		txtType.setColumns(10);
		
		//Creation du champs permettant de renseigner la tour
		txtToure = new JTextField();
		txtToure.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtToure.setBounds(65, 42, 96, 19);
		panel.add(txtToure);
		txtToure.setColumns(10);
		
		//Creation du champs permettant de renseigner l'ecran
		txtEcran = new JTextField();
		txtEcran.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEcran.setBounds(65, 75, 96, 19);
		panel.add(txtEcran);
		txtEcran.setColumns(10);
		
		//Creation du champs permettant de renseigner le clavier
		txtClavier = new JTextField();
		txtClavier.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtClavier.setBounds(65, 104, 96, 19);
		panel.add(txtClavier);
		txtClavier.setColumns(10);
		
		//Creation du champs permettant de renseigner la souris
		txtSouris = new JTextField();
		txtSouris.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtSouris.setBounds(65, 133, 96, 19);
		panel.add(txtSouris);
		txtSouris.setColumns(10);
		
		//Creation du champs permettant de mettre un commentaire
		txtCommentaire = new JTextField();
		txtCommentaire.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCommentaire.setBounds(98, 162, 139, 19);
		panel.add(txtCommentaire);
		txtCommentaire.setColumns(10);
		
		//Creation d'un bouton permettant d'ajouter un pc
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouter.setBounds(0, 199, 85, 21);
		panel.add(btnAjouter);
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
