package view;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UtilisateurFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////


	public JPanel contentPane;
	public JFrame j5;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblGrade;
	private JLabel lblPseudo;
	private JLabel lblMotDePasse;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnAjouter;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	//TODO renommer variable et ajouter commentaire


	/**
	 * Create the frame.
	 */
	public UtilisateurFenetre(Ecole model, Controller controller) {
		super(model, controller);
		
		j5 = new JFrame();
		j5.setTitle("Utilisateurs");
		j5.setVisible(true);
		j5.setBounds(100, 100, 243, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j5.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 422, 248);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNom = new JLabel("Nom");
		lblNom.setBounds(22, 15, 56, 16);
		panel.add(lblNom);
		
		lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(22, 44, 56, 16);
		panel.add(lblPrenom);
		
		lblGrade = new JLabel("Grade");
		lblGrade.setBounds(22, 73, 56, 16);
		panel.add(lblGrade);
		
		lblPseudo = new JLabel("Pseudo");
		lblPseudo.setBounds(22, 102, 56, 16);
		panel.add(lblPseudo);
		
		lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(22, 131, 85, 16);
		panel.add(lblMotDePasse);
		
		textField = new JTextField();
		textField.setBounds(62, 12, 134, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(72, 44, 124, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(62, 73, 134, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(80, 102, 116, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(106, 128, 90, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(22, 176, 174, 25);
		panel.add(btnAjouter);
	}
	
/////////////////////////////////////////////////*METHODES*////////////////////////////////////////////////////////////////////////////////


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affiche(String string) {
		// TODO Auto-generated method stub
		
	}

}
