package view;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

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
	
	//création de la fenêtre principale et du contentPane
		
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
	
			
		// création du pannel de connexion		
		connexion = new JPanel();
		connexion.setBounds(0, 0, 432, 160);
		contentPane.add(connexion);
		connexion.setVisible(true);
		connexion.setLayout(null);
		
		//création du champ texte de demande d'identifiants
		identTxt = new JLabel();
		connexion.add(identTxt);
		identTxt.setBorder(null);
		identTxt.setFont(new Font("Dialog", Font.BOLD, 20));
		identTxt.setText("Veuillez entrer vos identifiants : ");
		identTxt.setBounds(59, 13, 333, 27);
		identTxt.setOpaque(false);
				
		// création du champ texte du mot de passe
		JLabel mdp = new JLabel();
		mdp.setBounds(41, 92, 118, 39);
		connexion.add(mdp);
		mdp.setFont(new Font("Dialog", Font.BOLD, 17));
		mdp.setText("Mot de passe :");
		mdp.setForeground(new Color(0, 128, 128));
		mdp.setOpaque(false);
		
		// création du champ texte du nom d'utilisateur
		JLabel nomUti = new JLabel();
		nomUti.setBounds(12, 61, 156, 39);
		connexion.add(nomUti);
		nomUti.setFont(new Font("Dialog", Font.BOLD, 17));
		nomUti.setForeground(new Color(0, 128, 128));
		nomUti.setText("Nom d'utilisateur :");
		nomUti.setOpaque(false);
				
		// création du champ d'insertion du nom d'utilisateur
		utiTxt = new JTextField();
		utiTxt.setBounds(178, 66, 150, 22);
		connexion.add(utiTxt);
		utiTxt.setHorizontalAlignment(SwingConstants.CENTER);
		utiTxt.setColumns(10);
		
		// création du champ d'insertion du mot de passe
		mdpTxt = new JTextField();
		mdpTxt.setBounds(178, 102, 150, 22);
		connexion.add(mdpTxt);
		mdpTxt.setHorizontalAlignment(SwingConstants.CENTER);
		mdpTxt.setColumns(10);
		
		// création du bouton valider
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(301, 133, 107, 27);
		connexion.add(btnValider);
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnValider.setBackground(new Color(199, 21, 133));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if(controller.login(utiTxt.getText(), mdpTxt.getText())[0] == 1) {
					System.out.println("\n" + "Connexion réussie !");
					j.setVisible(false);
						
					// création et affichage de la 2e fenêtre
					SecondeFenetre imp_fenetre = new SecondeFenetre(model, controller);	
				}
				else {
					System.out.println("Connexion pas réussie !");
					coEchouee.setVisible(true);
				}

			}
		});
				
		
		//création du champ de texte de mauvais identifiant au cas où la connexion aurait échouée	
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
