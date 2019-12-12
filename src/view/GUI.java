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

@SuppressWarnings("deprecation")
public class GUI extends Vue{
	
/////////////////////////////////////////////*ATTRIBUTS*/////////////////////////////////////////////////////////////////////////////////

	//loulou doit continuer a faire les methodes pour generer et methode pour afficher les infos
	
	
	private JFrame j;
	private JPanel contentPane;
	private JTextField utiTxt;
	private JTextField mdpTxt;
	

	private JPanel connexion;
	private JTextField identTxt;
	private JTextField coEchouee;
	

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
		identTxt = new JTextField();
		connexion.add(identTxt);
		identTxt.setBorder(null);
		identTxt.setFont(new Font("Poor Richard", Font.BOLD, 22));
		identTxt.setText("Veuillez entrer vos identifiants : ");
		identTxt.setBounds(59, 13, 333, 27);
		identTxt.setEditable(false);
		identTxt.setColumns(10);
		identTxt.setOpaque(false);
				
		// cr�ation du champ texte du mot de passe
		JTextArea mdp = new JTextArea();
		mdp.setBounds(50, 97, 118, 39);
		connexion.add(mdp);
		mdp.setFont(new Font("Poor Richard", Font.BOLD, 20));
		mdp.setText("Mot de passe :");
		mdp.setForeground(new Color(0, 128, 128));
		mdp.setEditable(false);
		mdp.setOpaque(false);
		
		// cr�ation du champ texte du nom d'utilisateur
		JTextArea nomUti = new JTextArea();
		nomUti.setBounds(12, 61, 156, 39);
		connexion.add(nomUti);
		nomUti.setFont(new Font("Poor Richard", Font.BOLD, 20));
		nomUti.setForeground(new Color(0, 128, 128));
		nomUti.setText("Nom d'utilisateur :");
		nomUti.setEditable(false);
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
		coEchouee = new JTextField();
		connexion.add(coEchouee);
		coEchouee.setVisible(false);
		coEchouee.setForeground(new Color(220, 20, 60));
		coEchouee.setText("Identifiants incorrects...");
		coEchouee.setFont(new Font("Poor Richard", Font.BOLD, 18));
		coEchouee.setBorder(null);
		coEchouee.setBounds(12, 136, 213, 22);
		coEchouee.setEditable(false);
		coEchouee.setOpaque(false);
		coEchouee.setColumns(10);
				
		
	
				
				
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
