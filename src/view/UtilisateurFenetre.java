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
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UtilisateurFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////


	public JPanel contentPane;
	public JFrame j5;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblGrade;
	private JLabel lblPseudo;
	private JLabel lblMotDePasse;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtMdp;
	private JTextField txtPseudo;
	private JButton btnAjouter;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	//TODO renommer variable et ajouter commentaire


	/**
	 * Create the frame.
	 */
	public UtilisateurFenetre(Ecole model, Controller controller, Implantation implantation) {
		super(model, controller);
		
		j5 = new JFrame();
		j5.setTitle("Ajouter un utilisateur");
		j5.setVisible(true);
		j5.setBounds(100, 100, 288, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j5.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNom = new JLabel("Nom :");
		lblNom.setBounds(18, 11, 38, 16);
		contentPane.add(lblNom);
		
		lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(18, 49, 55, 16);
		contentPane.add(lblPrenom);
		
		lblGrade = new JLabel("Grade :");
		lblGrade.setBounds(18, 87, 44, 16);
		contentPane.add(lblGrade);
		
		lblPseudo = new JLabel("Pseudo :");
		lblPseudo.setBounds(18, 125, 53, 16);
		contentPane.add(lblPseudo);
		
		lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(18, 163, 91, 16);
		contentPane.add(lblMotDePasse);
		
		txtNom = new JTextField();
		txtNom.setBounds(135, 6, 130, 26);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(135, 44, 130, 26);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtMdp = new JTextField();
		txtMdp.setBounds(135, 158, 130, 26);
		contentPane.add(txtMdp);
		txtMdp.setColumns(10);
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(135, 120, 130, 26);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);

		JComboBox boxGrade = new JComboBox();
		boxGrade.setFont(new Font("Dialog", Font.PLAIN, 12));
		boxGrade.setModel(new DefaultComboBoxModel(new String[] {"Super administrateur", "Administrateur d'implantation", "Informaticien", "Utilisateur"}));
		boxGrade.setSelectedIndex(3);
		boxGrade.setBounds(135, 83, 130, 27);
		contentPane.add(boxGrade);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int grade = 3;
				switch (boxGrade.getSelectedItem().toString()) {
				case "Super administrateur":
					grade = 0;
					break;
				case "Administrateur d'implantation":
					grade = 1;
					break;
				case "Informaticien":
					grade = 2;
					break;
				case "Utilisateur":
					grade = 3;
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + boxGrade.getSelectedItem().toString());
				}
				try {
					implantation.genererUtilisateur(txtNom.getText(), txtPrenom.getText(), grade, txtPseudo.getText(), txtMdp.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAjouter.setBounds(192, 205, 90, 29);
		contentPane.add(btnAjouter);
		
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
