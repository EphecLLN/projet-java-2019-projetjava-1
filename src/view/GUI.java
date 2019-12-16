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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Controller;
import model.Ecole;
import javax.swing.JLabel;

@SuppressWarnings("deprecation")
public class GUI extends Vue{

	/////////////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////


	private JFrame j;
	private JPanel contentPane;
	private JTextField utiTxt;
	private JTextField mdpTxt;
	private JLabel identTxt;
	private JLabel coEchouee;


	/////////////////////////////////////////////*CONSTRUCTEURS*/////////////////////////////////////////////////////////////////////////////////


	public GUI(Ecole model, Controller controller) {
		super(model, controller);

		//creation de la fenetre principale et du contentPane

		j = new JFrame();
		j.setTitle("1formatik");
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setBounds(100, 100, 450, 184);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(8, 7, 3, 2));
		j.setContentPane(contentPane);
		contentPane.setLayout(null);

		//creation du champ texte de demande d'identifiants
		identTxt = new JLabel();
		identTxt.setBounds(6, 17, 438, 17);
		contentPane.add(identTxt);
		identTxt.setHorizontalAlignment(SwingConstants.CENTER);
		identTxt.setBorder(null);
		identTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		identTxt.setText("Veuillez entrer vos identifiants : ");
		identTxt.setOpaque(false);

		// creation du champ texte du mot de passe
		JLabel mdp = new JLabel();
		mdp.setBounds(43, 87, 96, 16);
		contentPane.add(mdp);
		mdp.setFont(new Font("Dialog", Font.BOLD, 13));
		mdp.setText("Mot de passe :");
		mdp.setForeground(Color.BLACK);
		mdp.setOpaque(false);

		// creation du champ texte du nom d'utilisateur
		JLabel nomUti = new JLabel();
		nomUti.setBounds(43, 59, 123, 16);
		contentPane.add(nomUti);
		nomUti.setFont(new Font("Dialog", Font.BOLD, 13));
		nomUti.setForeground(Color.BLACK);
		nomUti.setText("Nom d'utilisateur :");
		nomUti.setOpaque(false);

		// creation du champ d'insertion du nom d'utilisateur
		utiTxt = new JTextField();
		utiTxt.setFont(new Font("Dialog", Font.PLAIN, 13));
		utiTxt.setBounds(275, 48, 130, 26);
		contentPane.add(utiTxt);
		utiTxt.setHorizontalAlignment(SwingConstants.CENTER);
		utiTxt.setColumns(10);

		// creation du champ d'insertion du mot de passe
		mdpTxt = new JTextField();
		mdpTxt.setFont(new Font("Dialog", Font.PLAIN, 13));
		mdpTxt.setBounds(275, 82, 130, 26);
		contentPane.add(mdpTxt);
		mdpTxt.setHorizontalAlignment(SwingConstants.CENTER);
		mdpTxt.setColumns(10);

		// creation du bouton valider
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(344, 120, 87, 29);
		contentPane.add(btnValider);
		btnValider.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnValider.setBackground(new Color(199, 21, 133));


		//creation du champ de texte de mauvais identifiant au cas où la connexion aurait echouee
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
					@SuppressWarnings("unused")
					ImplantationFenetre impFen = new ImplantationFenetre(model, controller);
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
