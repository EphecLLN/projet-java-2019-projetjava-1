package view;

import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Ecole;
import model.Local;
import model.*;


import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

@SuppressWarnings({ "unused", "deprecation" })
public class LocalFenetre extends Vue {

	/////////////////////////////////////////*ATTRIBUTS*//////////////////////////////////////////////////////////////////////////////////////

	private JPanel contentPane;
	private JFrame j6;
	private JComboBox<String> boxListePc;
	private Local local;
	private JPanel panelLocalInfo;

	////////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////


	/**
	 * Creation de la fenetre
	 */
	public LocalFenetre(Ecole model, Controller controller, Local local) {
		super (model, controller);

		j6 = new JFrame();
		this.local = local;
		j6.setVisible(true);
		j6.setBounds(100, 100, 620, 413);
		j6.setTitle(local.getNom());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j6.setContentPane(contentPane);
		contentPane.setLayout(null);
		
				// création du bouton Rafraichir
				JButton btnRefresh = new JButton("Rafraîchir");
				btnRefresh.setBounds(517, 360, 97, 25);
				contentPane.add(btnRefresh);
				btnRefresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						j6.dispose();
						new LocalFenetre(model, controller, local);
					}
				});

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 310, 391);
		contentPane.add(panel);
		panel.setLayout(null);

		//Creation du label Materiels
		JLabel lblNewLabel = new JLabel("Matériels");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setBounds(6, 9, 294, 16);
		panel.add(lblNewLabel);

		//Creation du label chaise
		JLabel lblChaises = new JLabel("Chaises");
		lblChaises.setHorizontalAlignment(SwingConstants.CENTER);
		lblChaises.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblChaises.setBounds(16, 94, 44, 15);
		panel.add(lblChaises);

		//Creation du label Table
		JLabel lblTables = new JLabel("Tables");
		lblTables.setHorizontalAlignment(SwingConstants.CENTER);
		lblTables.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTables.setBounds(16, 62, 44, 15);
		panel.add(lblTables);

		//Creation du boutton permettant d'actualiser le nombre de table et chaise
		JButton btnActualiserMateriels = new JButton("Actualiser");
		btnActualiserMateriels.setHorizontalTextPosition(SwingConstants.CENTER);
		btnActualiserMateriels.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnActualiserMateriels.setBounds(200, 121, 100, 29);
		panel.add(btnActualiserMateriels);
		btnActualiserMateriels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualiserMaterielFenetre fen = new ActualiserMaterielFenetre(model, controller, local);
			}
		});

		//Creation du label Materiel special
		JLabel lblMaterielSpecial = new JLabel("Matériel spécial");
		lblMaterielSpecial.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterielSpecial.setFont(new Font("Dialog", Font.BOLD, 13));
		lblMaterielSpecial.setBounds(6, 162, 290, 19);
		panel.add(lblMaterielSpecial);

		//Creation d'une box permettant de selectionner un Materiel special du local
		JComboBox<String> boxMatSpec = new JComboBox<String>();
		boxMatSpec.setBounds(29, 202, 245, 27);
		panel.add(boxMatSpec);
		for(String str : controller.recupMatSpecNom(local.getMaterielsSpeciaux())) {
			boxMatSpec.addItem(str);
		}

		//Creation d'un bouton permettant de changer l'etat d'un materiel sppecial
		JButton btnModifierMatSpec = new JButton("Modifier");
		btnModifierMatSpec.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnModifierMatSpec.setBounds(209, 241, 91, 29);
		panel.add(btnModifierMatSpec);
		btnModifierMatSpec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualiserMaterielSpecialFenetre modifSpec = new ActualiserMaterielSpecialFenetre(model, controller, local.getMaterielSpecial(boxMatSpec.getSelectedItem().toString()));
			}
		});


		//Creation du label intervention
		JLabel lblIntervention = new JLabel("Intervention ");
		lblIntervention.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntervention.setFont(new Font("Dialog", Font.BOLD, 13));
		lblIntervention.setBounds(6, 288, 294, 18);
		panel.add(lblIntervention);

		//Creation d'une box permettant de selectionner une intervention
		JComboBox<String> boxIntervention = new JComboBox<String>();
		boxIntervention.setBounds(29, 318, 245, 27);
		panel.add(boxIntervention);
		for(String str : controller.recupInterventionNom(local.getInterventions())) {
			boxIntervention.addItem(str);
		}


		//Creation d'un bouton permettant de modifier une intervention
		JButton btnModifierIntervention = new JButton("Modifier");
		btnModifierIntervention.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnModifierIntervention.setBounds(209, 356, 91, 29);
		panel.add(btnModifierIntervention);
		btnModifierIntervention.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(local.getIntervention(boxIntervention.getSelectedItem().toString()));
				ModifierInterventionFenetre modif = new ModifierInterventionFenetre(model, controller, local.getIntervention(boxIntervention.getSelectedItem().toString()));
			}
		});



		//Creation d'un bouton qui ouvre une fenetre permettant d'ajouter du materiel special
		JButton btnAjouterMaterielSpecial = new JButton("Ajouter Matériel Spécial");
		btnAjouterMaterielSpecial.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouterMaterielSpecial.setBounds(6, 241, 180, 29);
		panel.add(btnAjouterMaterielSpecial);
		btnAjouterMaterielSpecial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterMaterielSpecialFenetre addMatSpec = new AjouterMaterielSpecialFenetre(model, controller, local);
			}
		});

		// Creation du label Neuf
		JLabel lblNeuf = new JLabel("Neuf");
		lblNeuf.setHorizontalAlignment(SwingConstants.CENTER);
		lblNeuf.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNeuf.setBounds(67, 42, 56, 16);
		panel.add(lblNeuf);

		// Creation du label Bon
		JLabel lblBon = new JLabel("Bon");
		lblBon.setHorizontalAlignment(SwingConstants.CENTER);
		lblBon.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblBon.setBounds(123, 42, 56, 15);
		panel.add(lblBon);

		// Creation du label Use
		JLabel lblUse = new JLabel("Usé");
		lblUse.setHorizontalAlignment(SwingConstants.CENTER);
		lblUse.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblUse.setBounds(179, 42, 56, 15);
		panel.add(lblUse);

		// Creation du label Critique
		JLabel lblCrtitique = new JLabel("Crtitique");
		lblCrtitique.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrtitique.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCrtitique.setBounds(234, 42, 56, 15);
		panel.add(lblCrtitique);

		// Creation du label d'affichage du nombre de chaises neuves
		JLabel lblChaiseNeuf = new JLabel("");
		lblChaiseNeuf.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblChaiseNeuf.setHorizontalAlignment(SwingConstants.CENTER);
		lblChaiseNeuf.setBounds(67, 61, 56, 16);
		panel.add(lblChaiseNeuf);
		lblChaiseNeuf.setText(String.valueOf(local.getNbChaises().getNeuf()));

		// Creation du label d'affichage du nombre de tables neuves
		JLabel lblTableNeuf = new JLabel("");
		lblTableNeuf.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTableNeuf.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableNeuf.setBounds(67, 93, 56, 16);
		panel.add(lblTableNeuf);
		lblTableNeuf.setText(String.valueOf(local.getNbTables().getNeuf()));

		// Creation du label d'affichage du nombre de chaises neuves
		JLabel lblChaiseBon = new JLabel("");
		lblChaiseBon.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblChaiseBon.setHorizontalAlignment(SwingConstants.CENTER);
		lblChaiseBon.setBounds(123, 61, 56, 16);
		panel.add(lblChaiseBon);
		lblChaiseBon.setText(String.valueOf(local.getNbChaises().getBon()));

		// Creation du label d'affichage du nombre de table en bon état
		JLabel lblTableBon = new JLabel("");
		lblTableBon.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTableBon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableBon.setBounds(123, 93, 56, 16);
		panel.add(lblTableBon);
		lblTableBon.setText(String.valueOf(local.getNbTables().getBon()));

		// Creation du label d'affichage du nombre de chaises usees
		JLabel lblChaiseUse = new JLabel("");
		lblChaiseUse.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblChaiseUse.setHorizontalAlignment(SwingConstants.CENTER);
		lblChaiseUse.setBounds(179, 61, 56, 16);
		panel.add(lblChaiseUse);
		lblChaiseUse.setText(String.valueOf(local.getNbChaises().getUse()));

		// Creation du label d'affichage du nombre de tables usees
		JLabel lblTableUse = new JLabel("");
		lblTableUse.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTableUse.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableUse.setBounds(179, 93, 56, 16);
		panel.add(lblTableUse);
		lblTableUse.setText(String.valueOf(local.getNbTables().getUse()));

		// Creation du label d'affichage du nombre de chaises critiques
		JLabel lblChaiseCritique = new JLabel("");
		lblChaiseCritique.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblChaiseCritique.setHorizontalAlignment(SwingConstants.CENTER);
		lblChaiseCritique.setBounds(234, 61, 56, 16);
		panel.add(lblChaiseCritique);
		lblChaiseCritique.setText(String.valueOf(local.getNbChaises().getCritique()));

		// Creation du label d'affichage du nombre de tables critiques
		JLabel lblTableCritique = new JLabel("");
		lblTableCritique.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTableCritique.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableCritique.setBounds(234, 93, 56, 16);
		panel.add(lblTableCritique);
		lblTableCritique.setText(String.valueOf(local.getNbTables().getCritique()));

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 309, 300, 2);
		panel.add(separator_1);

		// creation du bouton Ajouter Intervention
		JButton btnAjouterIntervention = new JButton("Ajouter Intervention");
		btnAjouterIntervention.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouterIntervention.setBounds(6, 356, 157, 29);
		panel.add(btnAjouterIntervention);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 151, 298, 12);
		panel.add(separator);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(6, 271, 298, 12);
		panel.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(304, 9, 12, 376);
		panel.add(separator_4);


		// creation du panel des informations du Local Informatique
		panelLocalInfo = new JPanel();
		panelLocalInfo.setBounds(309, 0, 310, 362);
		contentPane.add(panelLocalInfo);
		panelLocalInfo.setLayout(null);
		panelLocalInfo.setVisible(false); // ne doit etre true que si le local est un local informatique

		// creation du label Nombre de PC
		JLabel lblNombresDePc = new JLabel("PCs");
		lblNombresDePc.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombresDePc.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNombresDePc.setBounds(6, 9, 284, 16);
		panelLocalInfo.add(lblNombresDePc);

		// creation du label d'affichage du nombre de pc
		JLabel txtNbPC = new JLabel("");
		txtNbPC.setBounds(117, 13, 56, 16);
		panelLocalInfo.add(txtNbPC);

		JPanel panelDetailsPc = new JPanel();
		panelDetailsPc.setVisible(false);
		panelDetailsPc.setBounds(6, 108, 298, 251);
		panelLocalInfo.add(panelDetailsPc);
		panelDetailsPc.setLayout(null);

		// creation du label Etat PC
		JLabel lblDetails = new JLabel("Détails");
		lblDetails.setBounds(0, 17, 298, 16);
		panelDetailsPc.add(lblDetails);
		lblDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetails.setFont(new Font("Dialog", Font.BOLD, 13));

		// creation du label Type
		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(10, 52, 56, 16);
		panelDetailsPc.add(lblType);
		lblType.setFont(new Font("Dialog", Font.BOLD, 12));

		// creation du label Tour
		JLabel lblTour = new JLabel("Tour :");
		lblTour.setBounds(174, 52, 56, 16);
		panelDetailsPc.add(lblTour);
		lblTour.setFont(new Font("Dialog", Font.BOLD, 12));

		// creation du label Ecran
		JLabel lblEcran = new JLabel("Écran :");
		lblEcran.setBounds(10, 92, 56, 16);
		panelDetailsPc.add(lblEcran);
		lblEcran.setFont(new Font("Dialog", Font.BOLD, 12));

		// creation du label Clavier
		JLabel lblClavier = new JLabel("Clavier :");
		lblClavier.setBounds(174, 92, 56, 16);
		panelDetailsPc.add(lblClavier);
		lblClavier.setFont(new Font("Dialog", Font.BOLD, 12));

		// creation du label Souris
		JLabel lblSouris = new JLabel("Souris :");
		lblSouris.setBounds(10, 129, 56, 16);
		panelDetailsPc.add(lblSouris);
		lblSouris.setFont(new Font("Dialog", Font.BOLD, 12));

		// creation du label Commentaire
		JLabel lblCommentaire = new JLabel("Commentaires :");
		lblCommentaire.setBounds(0, 157, 298, 16);
		panelDetailsPc.add(lblCommentaire);
		lblCommentaire.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommentaire.setFont(new Font("Dialog", Font.BOLD, 12));

		// creation du label d'affichage du type
		JLabel txtType = new JLabel("");
		txtType.setBounds(64, 52, 56, 16);
		panelDetailsPc.add(txtType);
		txtType.setHorizontalAlignment(SwingConstants.LEFT);
		txtType.setFont(new Font("Dialog", Font.PLAIN, 12));

		// creation du label d'affichage de l'etat de la tour
		JLabel txtTour = new JLabel("");
		txtTour.setBounds(228, 52, 56, 16);
		panelDetailsPc.add(txtTour);
		txtTour.setHorizontalAlignment(SwingConstants.LEFT);
		txtTour.setFont(new Font("Dialog", Font.PLAIN, 12));

		// creation du label d'affichage de l'etat de l'ecran
		JLabel txtEcran = new JLabel("");
		txtEcran.setBounds(64, 92, 56, 16);
		panelDetailsPc.add(txtEcran);
		txtEcran.setHorizontalAlignment(SwingConstants.LEFT);
		txtEcran.setFont(new Font("Dialog", Font.PLAIN, 12));

		// creation du label d'affichage de l'etat du clavier
		JLabel txtClavier = new JLabel("");
		txtClavier.setBounds(228, 92, 56, 16);
		panelDetailsPc.add(txtClavier);
		txtClavier.setHorizontalAlignment(SwingConstants.LEFT);
		txtClavier.setFont(new Font("Dialog", Font.PLAIN, 12));

		// creation du label d'affichage de l'etat de la souris
		JLabel txtSouris = new JLabel("");
		txtSouris.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtSouris.setBounds(64, 129, 56, 16);
		panelDetailsPc.add(txtSouris);
		txtSouris.setHorizontalAlignment(SwingConstants.LEFT);

		// creation du label d'affichage du commentaire
		JLabel txtCom = new JLabel("");
		txtCom.setBounds(10, 180, 274, 56);
		panelDetailsPc.add(txtCom);
		txtCom.setHorizontalAlignment(SwingConstants.CENTER);
		txtCom.setFont(new Font("Dialog", Font.PLAIN, 12));

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 0, 298, 12);
		panelDetailsPc.add(separator_5);

		boxListePc = new JComboBox<String>();
		boxListePc.setBounds(29, 37, 245, 27);
		panelLocalInfo.add(boxListePc);
		boxListePc.setFont(new Font("Dialog", Font.PLAIN, 12));
		if(local.getClass().getSimpleName().equals("LocalInformatique")) {
			panelLocalInfo.setVisible(true);
		}
		if(local.getClass().getSimpleName().equals("LocalInformatique")) {
			LocalInformatique unLocInfo = (LocalInformatique) local;
			// creation de la box de choix du PC
			for(String nomPc : controller.recupPC(unLocInfo.getPcs())) {
				boxListePc.addItem(nomPc);
			}
		}

		// creation du bouton de validation du choix du pc
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalInformatique unLocInfo = (LocalInformatique) local;
				Pc pc = unLocInfo.getPc(boxListePc.getSelectedItem().toString());
				lblDetails.setText("Détails " + pc.getNom());
				txtType.setText(pc.getType());
				txtTour.setText(pc.getTour());
				txtEcran.setText(pc.getEcran());
				txtClavier.setText(pc.getClavier());
				txtSouris.setText(pc.getSouris());
				txtCom.setText(pc.getCommentaires());
				panelDetailsPc.setVisible(true);
			}
		});
		btnValider.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnValider.setBounds(219, 76, 85, 29);
		panelLocalInfo.add(btnValider);

		// creation du bouton Ajouter PC
		JButton btnAjouterPc = new JButton("Ajouter PC");
		btnAjouterPc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalInformatique unLocInfo = (LocalInformatique) local;
				AjouterPCFenetre ajoutPCFen = new AjouterPCFenetre(model, controller, unLocInfo);
			}
		});
		btnAjouterPc.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouterPc.setBounds(6, 76, 110, 29);
		panelLocalInfo.add(btnAjouterPc);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, -2, -6, 395);
		panelLocalInfo.add(separator_2);
		separator_2.setOrientation(SwingConstants.VERTICAL);

		btnAjouterIntervention.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterInterventionFenetre ajoutIntFen = new AjouterInterventionFenetre(model, controller, local);
			}
		});
	}

	///////////////////////////////////////*METHODES*/////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void update(Observable o, Object arg) {

	}


	@Override
	public void affiche(String string) {

	}
}
