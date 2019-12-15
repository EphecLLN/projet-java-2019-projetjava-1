package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Controller;
import model.Ecole;
import view.VueConsole.ReadInput;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JSpinner;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;

@SuppressWarnings("deprecation")
public class GUI extends Vue{

	/////////////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////

	//loulou doit continuer a faire les methodes pour generer et methode pour afficher les infos


	private JFrame j;
	private JPanel contentPane;
	private JTextField utiTxt;
	private JTextField mdpTxt;
	private JLabel identTxt;
	private JLabel coEchouee;


	/////////////////////////////////////////////*CONSTRUCTEURS*/////////////////////////////////////////////////////////////////////////////////


	public GUI(Ecole model, Controller controller) {
		super(model, controller);

		//création de la fenétre principale et du contentPane

		j = new JFrame();
		j.setTitle("1formatik");
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setBounds(100, 100, 450, 184);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(8, 7, 3, 2));
		j.setContentPane(contentPane);
		contentPane.setLayout(null);

		//création du champ texte de demande d'identifiants
		identTxt = new JLabel();
		identTxt.setBounds(6, 17, 438, 17);
		contentPane.add(identTxt);
		identTxt.setHorizontalAlignment(SwingConstants.CENTER);
		identTxt.setBorder(null);
		identTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		identTxt.setText("Veuillez entrer vos identifiants : ");
		identTxt.setOpaque(false);

		// création du champ texte du mot de passe
		JLabel mdp = new JLabel();
		mdp.setBounds(43, 87, 96, 16);
		contentPane.add(mdp);
		mdp.setFont(new Font("Dialog", Font.BOLD, 13));
		mdp.setText("Mot de passe :");
		mdp.setForeground(Color.BLACK);
		mdp.setOpaque(false);

		// création du champ texte du nom d'utilisateur
		JLabel nomUti = new JLabel();
		nomUti.setBounds(43, 59, 123, 16);
		contentPane.add(nomUti);
		nomUti.setFont(new Font("Dialog", Font.BOLD, 13));
		nomUti.setForeground(Color.BLACK);
		nomUti.setText("Nom d'utilisateur :");
		nomUti.setOpaque(false);

		// création du champ d'insertion du nom d'utilisateur
		utiTxt = new JTextField();
		utiTxt.setFont(new Font("Dialog", Font.PLAIN, 13));
		utiTxt.setBounds(275, 48, 130, 26);
		contentPane.add(utiTxt);
		utiTxt.setHorizontalAlignment(SwingConstants.CENTER);
		utiTxt.setColumns(10);

		// création du champ d'insertion du mot de passe
		mdpTxt = new JTextField();
		mdpTxt.setFont(new Font("Dialog", Font.PLAIN, 13));
		mdpTxt.setBounds(275, 82, 130, 26);
		contentPane.add(mdpTxt);
		mdpTxt.setHorizontalAlignment(SwingConstants.CENTER);
		mdpTxt.setColumns(10);

		// création du bouton valider
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(344, 120, 87, 29);
		contentPane.add(btnValider);
		btnValider.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnValider.setBackground(new Color(199, 21, 133));


		//création du champ de texte de mauvais identifiant au cas où la connexion aurait échouée
		coEchouee = new JLabel();
		coEchouee.setHorizontalAlignment(SwingConstants.CENTER);
		coEchouee.setBounds(83, 125, 157, 16);
		contentPane.add(coEchouee);
		coEchouee.setVisible(false);
		coEchouee.setForeground(new Color(220, 20, 60));
		coEchouee.setText("Identifiants incorrects...");
		coEchouee.setFont(new Font("Dialog", Font.BOLD, 13));
		coEchouee.setBorder(null);
		coEchouee.setOpaque(false);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(controller.login(utiTxt.getText(), mdpTxt.getText())[0] == 1) {
					System.out.println("\n" + "Connexion réussie !");
					j.setVisible(false);

					// création et affichage de la 2e fenêtre
					ImplantationFenetre imp_fenetre = new ImplantationFenetre(model, controller);
				}
				else {
					System.out.println("Connexion pas réussie !");
					coEchouee.setVisible(true);
				}

			}
		});






	}


	/////////////////////////////////////////////*METHODE*/////////////////////////////////////////////////////////////////////////////////


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void affiche(String string) {
		// TODO Auto-generated method stub

	}
}
