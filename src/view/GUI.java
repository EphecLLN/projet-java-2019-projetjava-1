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


	private JPanel connexion;
	private JLabel identTxt;
	private JLabel coEchouee;


/////////////////////////////////////////////*CONSTRUCTEURS*/////////////////////////////////////////////////////////////////////////////////


	public GUI(Ecole model, Controller controller) {
	super(model, controller);

	//cr�ation de la fen�tre principale et du contentPane

		j = new JFrame();
		j.setTitle("1formatik");
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setBounds(100, 100, 450, 207);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(8, 7, 3, 2));
		contentPane.setBorder(null);
		j.setContentPane(contentPane);
		contentPane.setLayout(null);


		// cr�ation du pannel de connexion
		connexion = new JPanel();
		connexion.setBounds(0, 0, 432, 160);
		contentPane.add(connexion);
		connexion.setVisible(true);
		connexion.setLayout(null);

		//cr�ation du champ texte de demande d'identifiants
		identTxt = new JLabel();
		connexion.add(identTxt);
		identTxt.setBorder(null);
		identTxt.setFont(new Font("Dialog", Font.BOLD, 20));
		identTxt.setText("Veuillez entrer vos identifiants : ");
		identTxt.setBounds(59, 13, 333, 27);
		identTxt.setOpaque(false);

		// cr�ation du champ texte du mot de passe
		JLabel mdp = new JLabel();
		mdp.setBounds(41, 92, 118, 39);
		connexion.add(mdp);
		mdp.setFont(new Font("Dialog", Font.BOLD, 17));
		mdp.setText("Mot de passe :");
		mdp.setForeground(new Color(0, 128, 128));
		mdp.setOpaque(false);

		// cr�ation du champ texte du nom d'utilisateur
		JLabel nomUti = new JLabel();
		nomUti.setBounds(12, 61, 156, 39);
		connexion.add(nomUti);
		nomUti.setFont(new Font("Dialog", Font.BOLD, 17));
		nomUti.setForeground(new Color(0, 128, 128));
		nomUti.setText("Nom d'utilisateur :");
		nomUti.setOpaque(false);

		// cr�ation du champ d'insertion du nom d'utilisateur
		utiTxt = new JTextField();
		utiTxt.setBounds(178, 66, 150, 22);
		connexion.add(utiTxt);
		utiTxt.setHorizontalAlignment(SwingConstants.CENTER);
		utiTxt.setColumns(10);

		// cr�ation du champ d'insertion du mot de passe
		mdpTxt = new JTextField();
		mdpTxt.setBounds(178, 102, 150, 22);
		connexion.add(mdpTxt);
		mdpTxt.setHorizontalAlignment(SwingConstants.CENTER);
		mdpTxt.setColumns(10);

		// cr�ation du bouton valider
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(301, 133, 107, 27);
		connexion.add(btnValider);
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnValider.setBackground(new Color(199, 21, 133));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(controller.login(utiTxt.getText(), mdpTxt.getText())[0] == 1) {
					System.out.println("\n" + "Connexion r�ussie !");
					j.setVisible(false);

					// cr�ation et affichage de la 2e fen�tre
					SecondeFenetre imp_fenetre = new SecondeFenetre(model, controller);
				}
				else {
					System.out.println("Connexion pas r�ussie !");
					coEchouee.setVisible(true);
				}

			}
		});


		//cr�ation du champ de texte de mauvais identifiant au cas o� la connexion aurait �chou�e
		coEchouee = new JLabel();
		connexion.add(coEchouee);
		coEchouee.setVisible(false);
		coEchouee.setForeground(new Color(220, 20, 60));
		coEchouee.setText("Identifiants incorrects...");
		coEchouee.setFont(new Font("Dialog", Font.BOLD, 18));
		coEchouee.setBorder(null);
		coEchouee.setBounds(12, 136, 213, 22);
		coEchouee.setOpaque(false);






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
