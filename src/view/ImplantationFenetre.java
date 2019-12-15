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
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


public class ImplantationFenetre extends Vue{

	/////////////////////////////////////////*ATTRIBUTS*//////////////////////////////////////////////////////////////////////////////////////

	private JPanel contentPane;
	private JFrame j2;
	private JLabel choix_txt;


	////////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Creation de la fenetre
	 */
	@SuppressWarnings("rawtypes")
	public ImplantationFenetre(Ecole model, Controller controller) {
		super(model, controller);

		j2 = new JFrame();
		j2.setVisible(true);
		j2.setTitle("Implantation");
		j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j2.setBounds(100, 100, 450, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j2.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		Panel panel = new Panel();
		contentPane.add(panel);
		panel.setLayout(null);

		// cr�ation du champ texte de demande de choix d'implantation
		choix_txt = new JLabel();
		panel.add(choix_txt);
		choix_txt.setBorder(null);
		choix_txt.setFont(new Font("Dialog", Font.PLAIN, 12));
		choix_txt.setText("Veuillez choisir une implantation :");
		choix_txt.setBounds(16, 13, 365, 22);
		choix_txt.setOpaque(false);

		// cr�ation de la box qui permet de choisir son implantation
		@SuppressWarnings("unchecked")
		JComboBox choix_imp = new JComboBox(controller.recupererImpNom());
		choix_imp.setFont(UIManager.getFont("ColorChooser.font"));
		choix_imp.setBounds(26, 47, 365, 22);
		panel.add(choix_imp);

		// cr�ation du label affichage du nombre de locaux
		JLabel txtNbLocaux = new JLabel("Nombre de locaux :");
		txtNbLocaux.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNbLocaux.setBounds(29, 156, 129, 16);
		panel.add(txtNbLocaux);
		txtNbLocaux.setVisible(false);

		// cr�ation du label affichage du nombre de locaux
		JLabel nbLocaux = new JLabel();
		nbLocaux.setHorizontalTextPosition(SwingConstants.CENTER);
		nbLocaux.setHorizontalAlignment(SwingConstants.CENTER);
		nbLocaux.setBounds(352, 156, 56, 16);
		panel.add(nbLocaux);
		nbLocaux.setVisible(false);

		// cr�ation du label affichage du nombre de locaux informatiques
		JLabel txtNbLocInfo = new JLabel("Nombre de locaux informatiques :");
		txtNbLocInfo.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNbLocInfo.setBounds(29, 184, 220, 16);
		panel.add(txtNbLocInfo);
		txtNbLocInfo.setVisible(false);

		// cr�ation du label affichage du nombre de locaux informatiques
		JLabel nbLocInfo = new JLabel("");
		nbLocInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		nbLocInfo.setHorizontalAlignment(SwingConstants.CENTER);
		nbLocInfo.setBounds(352, 184, 56, 16);
		panel.add(nbLocInfo);
		nbLocInfo.setVisible(false);

		// cr�ation de la box de la liste des locaux
		JComboBox<String> boxListeLocal = new JComboBox<String>();
		boxListeLocal.setVisible(false);
		boxListeLocal.setFont(UIManager.getFont("ColorChooser.font"));
		boxListeLocal.setBounds(26, 255, 365, 22);
		panel.add(boxListeLocal);

		// creation du bouton ouvrir
		JButton btnOuvrir = new JButton("Ouvrir");
		btnOuvrir.setVisible(false);
		btnOuvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Implantation imp = model.getImplantation(choix_imp.getSelectedItem().toString());
				Local local = imp.getLocal(boxListeLocal.getSelectedItem().toString().substring(0,3));
				LocalFenetre loc = new LocalFenetre(model, controller, local);
			}
		});
		btnOuvrir.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnOuvrir.setBounds(342, 289, 79, 29);
		panel.add(btnOuvrir);

		JLabel lblImplantation = new JLabel("Implantation");
		lblImplantation.setVisible(false);
		lblImplantation.setFont(new Font("Dialog", Font.BOLD, 13));
		lblImplantation.setHorizontalTextPosition(SwingConstants.CENTER);
		lblImplantation.setHorizontalAlignment(SwingConstants.CENTER);
		lblImplantation.setBounds(6, 128, 428, 16);
		panel.add(lblImplantation);

		JSeparator separator = new JSeparator();
		separator.setVisible(false);
		separator.setBounds(6, 110, 428, 12);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setVisible(false);
		separator_1.setBounds(6, 318, 428, 12);
		panel.add(separator_1);

		// cr�ation du bouton Ajouter Local
		JButton btnAjouterLocal = new JButton("Ajouter un local");
		btnAjouterLocal.setVisible(false);
		btnAjouterLocal.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouterLocal.setBounds(16, 289, 134, 29);
		panel.add(btnAjouterLocal);
		btnAjouterLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterLocalFenetre ajout = new AjouterLocalFenetre(model, controller, model.getImplantation(choix_imp.getSelectedItem().toString()));
			}
		});

		// cr�ation du bouton Ajouter Implantation
		JButton btnAjouterImplantation = new JButton("Ajouter une implantation");
		btnAjouterImplantation.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouterImplantation.setBounds(16, 79, 186, 29);
		panel.add(btnAjouterImplantation);
		btnAjouterImplantation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterImplantationFenetre ajoutImp = new AjouterImplantationFenetre(model, controller, model.getImplantation(choix_imp.getSelectedItem().toString()));
			}
		});

		// cr�ation du bouton Menu Utilisateur
		JButton btnAjouterUtilisateur = new JButton("Ajouter un utilisateur");
		btnAjouterUtilisateur.setVisible(false);
		btnAjouterUtilisateur.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouterUtilisateur.setBounds(16, 423, 163, 29);
		panel.add(btnAjouterUtilisateur);
		btnAjouterUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UtilisateurFenetre utilFen = new UtilisateurFenetre(model, controller, model.getImplantation(choix_imp.getSelectedItem().toString()));
			}
		});

		JLabel lblChoisissezLeLocal = new JLabel("Choisissez le local que vous souhaitez afficher :");
		lblChoisissezLeLocal.setVisible(false);
		lblChoisissezLeLocal.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblChoisissezLeLocal.setBounds(16, 227, 316, 16);
		panel.add(lblChoisissezLeLocal);

		JLabel lblMenuUtilisateurs = new JLabel("Menu utilisateurs");
		lblMenuUtilisateurs.setVisible(false);
		lblMenuUtilisateurs.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMenuUtilisateurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuUtilisateurs.setFont(new Font("Dialog", Font.BOLD, 13));
		lblMenuUtilisateurs.setBounds(6, 339, 428, 16);
		panel.add(lblMenuUtilisateurs);

		JLabel lblNbUtilisateurs = new JLabel("Nombre d'utilisateurs :");
		lblNbUtilisateurs.setVisible(false);
		lblNbUtilisateurs.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNbUtilisateurs.setBounds(29, 367, 149, 16);
		panel.add(lblNbUtilisateurs);

		JLabel lblNbUti = new JLabel("");
		lblNbUti.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNbUti.setHorizontalAlignment(SwingConstants.CENTER);
		lblNbUti.setVisible(false);
		lblNbUti.setFont(UIManager.getFont("ColorChooser.font"));
		lblNbUti.setBounds(352, 367, 56, 16);
		panel.add(lblNbUti);

		JComboBox<String> boxListeUtilisateurs = new JComboBox<String>();
		boxListeUtilisateurs.setFont(UIManager.getFont("ColorChooser.font"));
		boxListeUtilisateurs.setVisible(false);
		boxListeUtilisateurs.setBounds(26, 392, 365, 27);
		panel.add(boxListeUtilisateurs);


		// cr�ation du bouton de validation
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnValider.setBounds(336, 79, 85, 29);
		panel.add(btnValider);
		btnValider.setBackground(SystemColor.menu);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Implantation impChoisie = model.getImplantation(choix_imp.getSelectedItem().toString());
				separator.setVisible(true);
				separator_1.setVisible(true);
				btnAjouterLocal.setVisible(true);
				btnAjouterImplantation.setVisible(true);
				btnAjouterUtilisateur.setVisible(true);
				lblChoisissezLeLocal.setVisible(true);
				lblMenuUtilisateurs.setVisible(true);
				lblNbUtilisateurs.setVisible(true);
				lblNbUti.setText(String.valueOf(impChoisie.getUtilisateurs().size()));
				lblNbUti.setVisible(true);
				boxListeUtilisateurs.removeAllItems();
				for(Utilisateur utilisateur : impChoisie.getUtilisateurs()) {
					boxListeUtilisateurs.addItem(utilisateur.getNom() + " " + utilisateur.getPrenom());
				}
				boxListeUtilisateurs.setVisible(true);
				lblImplantation.setText(impChoisie.getNom() + "  -  " + impChoisie.getAdresse().toString());
				lblImplantation.setVisible(true);
				nbLocaux.setText(String.valueOf(impChoisie.nombreLocauxTotal()));
				txtNbLocaux.setVisible(true);
				nbLocaux.setVisible(true);  
				nbLocInfo.setText(String.valueOf(impChoisie.nombreLocauxInformatiques()));
				txtNbLocInfo.setVisible(true);
				nbLocInfo.setVisible(true);
				boxListeLocal.removeAllItems();
				for (Local local : impChoisie.getLocaux()) {
					boxListeLocal.addItem(local.getNom() + "                                               interventions : " + local.getInterventions().size());
				}
				boxListeLocal.setVisible(true);
				btnOuvrir.setVisible(true);
			}
		});
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
