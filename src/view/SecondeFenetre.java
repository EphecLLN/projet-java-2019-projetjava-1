package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.*;
import controller.Controller;
import model.Ecole;
import model.Implantation;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class SecondeFenetre extends Vue{
	
/////////////////////////////////////////*ATTRIBUTS*//////////////////////////////////////////////////////////////////////////////////////

	public JPanel contentPane;
	public JFrame j2;
	private JLabel choix_txt;
	

////////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Création de la fenêtre
	 */
	@SuppressWarnings("rawtypes")
	public SecondeFenetre(Ecole model, Controller controller) {
		super(model, controller);
		
		j2 = new JFrame();
		j2.setVisible(true);
		j2.setTitle("Implantation");
		j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j2.setBounds(100, 100, 450, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j2.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Panel panel = new Panel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		// création du champ texte de demande de choix d'implantation
		choix_txt = new JLabel();
		panel.add(choix_txt);
		choix_txt.setBorder(null);
		choix_txt.setFont(new Font("Dialog", Font.BOLD, 13));
		choix_txt.setText("Veuillez choisir une implantation :");
		choix_txt.setBounds(29, 25, 365, 22);
		choix_txt.setOpaque(false);
		
		// création de la box qui permet de choisir son implantation
		@SuppressWarnings("unchecked")
		JComboBox choix_imp = new JComboBox(controller.recupererImp());
		choix_imp.setBounds(29, 60, 365, 22);
		panel.add(choix_imp);
		
		// création du label affichage du nombre de locaux
		JLabel txtNbLocaux = new JLabel("Nombre de locaux :");
		txtNbLocaux.setBounds(29, 161, 112, 16);
		panel.add(txtNbLocaux);
		txtNbLocaux.setVisible(false);

		// création du label affichage du nombre de locaux
		JLabel nbLocaux = new JLabel("");
		nbLocaux.setBounds(162, 161, 56, 16);
		panel.add(nbLocaux);
		nbLocaux.setVisible(false);

		// création du label affichage du nombre de locaux informatiques
		JLabel txtNbLocInfo = new JLabel("Nombre de locaux informatiques :");
		txtNbLocInfo.setBounds(29, 190, 194, 16);
		panel.add(txtNbLocInfo);
		txtNbLocInfo.setVisible(false);

		// création du label affichage du nombre de locaux informatiques
		JLabel nbLocInfo = new JLabel("");
		nbLocInfo.setBounds(235, 190, 56, 16);
		panel.add(nbLocInfo);
		nbLocInfo.setVisible(false);
		
		// création de la box de la liste des locaux
		JComboBox boxListeLocal = new JComboBox();
		boxListeLocal.setBounds(29, 255, 365, 22);
		panel.add(boxListeLocal);
		boxListeLocal.setVisible(false);
		
		// création du bouton de validation
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(297, 95, 97, 25);
		panel.add(btnValider);
		btnValider.setBorder(null);
		btnValider.setBackground(new Color(199, 21, 133));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Choix validé : " + choix_imp.getSelectedItem());
					// TODO afficher tous les labels ci dessous
				txtNbLocaux.setVisible(true);
				nbLocaux.setVisible(true);
				txtNbLocInfo.setVisible(true);
				nbLocInfo.setVisible(true);
				boxListeLocal.setVisible(true);
				}
				
		});
		

		
		JButton btnAjouterLocal = new JButton("Ajouter Local");
		btnAjouterLocal.setBounds(29, 357, 149, 25);
		panel.add(btnAjouterLocal);
		
		JButton btnAjouterImplentation = new JButton("Ajouter Implentation");
		btnAjouterImplentation.setBounds(29, 388, 149, 25);
		panel.add(btnAjouterImplentation);
		
		JButton btnMenuUtilisateur = new JButton("Menu Utilisateur");
		btnMenuUtilisateur.setBounds(245, 388, 149, 25);
		panel.add(btnMenuUtilisateur);
		
		
		

		
				
	}




///////////////////////////////////////*METHODES*/////////////////////////////////////////////////////////////////////////////////////////

	


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void affiche(String string) {
		
	}
}
