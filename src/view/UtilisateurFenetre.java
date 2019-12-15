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
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;

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

	


	/**
	 * Creation de la fenetre
	 */
	@SuppressWarnings("unchecked")
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
		
		// creation du label Nom
		lblNom = new JLabel("Nom :");
		lblNom.setBounds(18, 11, 38, 16);
		contentPane.add(lblNom);
		
		// creation du label Prenom
		lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(18, 49, 55, 16);
		contentPane.add(lblPrenom);
		
		// creation du label Grade
		lblGrade = new JLabel("Grade :");
		lblGrade.setBounds(18, 87, 44, 16);
		contentPane.add(lblGrade);
		
		// creation du label Pseudo
		lblPseudo = new JLabel("Pseudo :");
		lblPseudo.setBounds(18, 125, 53, 16);
		contentPane.add(lblPseudo);
		
		// creation du label Mot de passe
		lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(18, 163, 91, 16);
		contentPane.add(lblMotDePasse);
		
		// creation du champ de recuperation du nom
		txtNom = new JTextField();
		txtNom.setBounds(135, 6, 130, 26);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		// creation du champ de recuperation du prenom
		txtPrenom = new JTextField();
		txtPrenom.setBounds(135, 44, 130, 26);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		// creation du champ de recuperation du mot de passe
		txtMdp = new JTextField();
		txtMdp.setBounds(135, 158, 130, 26);
		contentPane.add(txtMdp);
		txtMdp.setColumns(10);
		
		// creation du champ de recuperation du pseudo
		txtPseudo = new JTextField();
		txtPseudo.setBounds(135, 120, 130, 26);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		// creation du label d'erreur
		JLabel lblErreur = new JLabel("Erreur. Veuillez réessayer.");
		lblErreur.setHorizontalAlignment(SwingConstants.CENTER);
		lblErreur.setVisible(false);
		lblErreur.setFont(UIManager.getFont("ColorChooser.font"));
		lblErreur.setBounds(18, 210, 162, 16);
		contentPane.add(lblErreur);

		// creation de box du grade
		JComboBox boxGrade = new JComboBox();
		boxGrade.setFont(new Font("Dialog", Font.PLAIN, 12));
		boxGrade.setModel(new DefaultComboBoxModel(new String[] {"Super administrateur", "Administrateur d'implantation", "Informaticien", "Utilisateur"}));
		boxGrade.setSelectedIndex(3);
		boxGrade.setBounds(135, 83, 130, 27);
		contentPane.add(boxGrade);
		
		// creation du bouton ajouter
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(192, 205, 90, 29);
		contentPane.add(btnAjouter);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErreur.setVisible(false);
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
					lblErreur.setText("Uilisateur ajouté.");
					lblErreur.setForeground(Color.GREEN);
					lblErreur.setVisible(true);
				} catch (SQLException e1) {
					lblErreur.setText("Erreur, veuillez Réessayer");
					lblErreur.setForeground(Color.RED);
					lblErreur.setVisible(true);
				}
			}
		});
		
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
