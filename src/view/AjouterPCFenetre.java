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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnAjouter;

////////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Create the frame.
	 */
	public AjouterPCFenetre(Ecole model, Controller controller) {
		super(model,controller);
		j8 = new JFrame();
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
		
		lblType = new JLabel("Type");
		lblType.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblType.setBounds(10, 10, 45, 13);
		panel.add(lblType);
		
		lblToure = new JLabel("Toure");
		lblToure.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblToure.setBounds(10, 44, 45, 13);
		panel.add(lblToure);
		
		lblEcran = new JLabel("Ecran");
		lblEcran.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEcran.setBounds(10, 77, 45, 13);
		panel.add(lblEcran);
		
		lblClavier = new JLabel("Clavier");
		lblClavier.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblClavier.setBounds(10, 108, 45, 13);
		panel.add(lblClavier);
		
		lblSouris = new JLabel("Souris");
		lblSouris.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblSouris.setBounds(10, 137, 45, 13);
		panel.add(lblSouris);
		
		lblCommentaire = new JLabel("Commentaire");
		lblCommentaire.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCommentaire.setBounds(10, 166, 84, 13);
		panel.add(lblCommentaire);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField.setBounds(65, 8, 96, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_1.setBounds(65, 42, 96, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_2.setBounds(65, 75, 96, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_3.setBounds(65, 104, 96, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_4.setBounds(65, 133, 96, 19);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_5.setBounds(98, 162, 139, 19);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouter.setBounds(0, 199, 85, 21);
		panel.add(btnAjouter);
		j8.setVisible(true);
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
