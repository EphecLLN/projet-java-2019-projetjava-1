package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Ecole;
import model.Local;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class LocalFenetre extends Vue {

/////////////////////////////////////////*ATTRIBUTS*//////////////////////////////////////////////////////////////////////////////////////
	
	private JPanel contentPane;
	private JFrame j6;
////////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Creation de la fenetre
	 */
	public LocalFenetre(Ecole model, Controller controller, Local local) {
		super (model, controller);
		
		
		j6 = new JFrame();
		j6.setVisible(true);
		j6.setBounds(100, 100, 307, 447);
		j6.setTitle(local.getNom());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j6.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 289, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Creation du label Materiels
		JLabel lblNewLabel = new JLabel("Mat\u00E9riels :");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 13, 96, 16);
		panel.add(lblNewLabel);
		
		//Creation du label chaise
		JLabel lblChaises = new JLabel("Chaises");
		lblChaises.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblChaises.setBounds(10, 63, 54, 13);
		panel.add(lblChaises);
		
		//Creation du label Table
		JLabel lblTables = new JLabel("Tables");
		lblTables.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTables.setBounds(20, 89, 48, 19);
		panel.add(lblTables);
		
		//Creation du boutton permettant d'actualiser le nombre de table et chaise
		JButton btnActualiserMateriels = new JButton("Actualiser");
		btnActualiserMateriels.setHorizontalTextPosition(SwingConstants.CENTER);
		btnActualiserMateriels.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnActualiserMateriels.setBounds(185, 122, 87, 25);
		panel.add(btnActualiserMateriels);
		btnActualiserMateriels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualiserMaterielFenetre fen = new ActualiserMaterielFenetre(model, controller, local);
			}
		});
		
		
		//Creation du label Materiel special
		JLabel lblMaterielSpecial = new JLabel("Materiel special :");
		lblMaterielSpecial.setFont(new Font("Dialog", Font.BOLD, 12));
		lblMaterielSpecial.setBounds(10, 170, 96, 19);
		panel.add(lblMaterielSpecial);
		
		//Creation d'un bouton permettant de changer l'etat d'un materiel sppecial
		JButton btnModifierMatSpec = new JButton("Modifier");
		btnModifierMatSpec.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnModifierMatSpec.setBounds(178, 202, 75, 25);
		panel.add(btnModifierMatSpec);
		btnModifierMatSpec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ActualiserMaterielSpecialFenetre modifSpec = new ActualiserMaterielSpecialFenetre(model, controller);
			}
		});
	
		
		//Creation du label intervention
		JLabel lblIntervention = new JLabel("Intervention :");
		lblIntervention.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIntervention.setBounds(10, 241, 93, 18);
		panel.add(lblIntervention);
		
		//Creation d'une box permettant de selectionner une intervention 
		@SuppressWarnings("unchecked")
		JComboBox boxIntervention = new JComboBox(controller.recupInterventionNom(local.getInterventions()));
		boxIntervention.setBounds(10, 272, 156, 21);
		panel.add(boxIntervention);
		
		//Creation d'une box permettant de selectionner un Materiel special du local
		@SuppressWarnings("unchecked")
		JComboBox boxMatSpec = new JComboBox(controller.recupMatSpecNom(local.getMaterielsSpeciaux()));
		boxMatSpec.setBounds(10, 202, 156, 21);
		panel.add(boxMatSpec);
		
		
		//Creation d'un permettant de modifier une intervention 
		JButton btnModifierIntervention = new JButton("Modifier");
		btnModifierIntervention.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnModifierIntervention.setBounds(178, 271, 75, 25);
		panel.add(btnModifierIntervention);
		btnModifierIntervention.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierInterventionFenetre modif = new ModifierInterventionFenetre(model, controller);
			}
		});
		
		//Creation d'un bouton qui ouvre une fenetre permettant d'ajouter du materiel
		JButton btnAjouterMateriel = new JButton("Ajouter Materiel");
		btnAjouterMateriel.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouterMateriel.setBounds(80, 324, 117, 25);
		panel.add(btnAjouterMateriel);
		btnAjouterMateriel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterMaterielFenetre addMat = new AjouterMaterielFenetre(model, controller);
			}
		});
		
		
		//Creation d'un bouton qui ouvre une fenetre permettant d'ajouter du materiel special
		JButton btnAjouterMaterielSpecial = new JButton("Ajouter Materiel Special");
		btnAjouterMaterielSpecial.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouterMaterielSpecial.setBounds(58, 362, 161, 25);
		panel.add(btnAjouterMaterielSpecial);
		btnAjouterMaterielSpecial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterMaterielSpecialFenetre addMatSpec = new AjouterMaterielSpecialFenetre(model, controller);
			}
		});
		
		// Creation du label Neuf
		JLabel lblNeuf = new JLabel("Neuf");
		lblNeuf.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNeuf.setBounds(73, 42, 56, 16);
		panel.add(lblNeuf);
		
		// Creation du label Bon
		JLabel lblBon = new JLabel("Bon");
		lblBon.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblBon.setBounds(127, 42, 56, 16);
		panel.add(lblBon);
		
		// Creation du label Usé
		JLabel lblUse = new JLabel("Usé");
		lblUse.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblUse.setBounds(185, 42, 56, 16);
		panel.add(lblUse);
		
		// Creation du label Critique
		JLabel lblCrtitique = new JLabel("Crtitique");
		lblCrtitique.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCrtitique.setBounds(234, 42, 56, 16);
		panel.add(lblCrtitique);
		
		// Creation du label d'affichage du nombre de chaises neuves
		JLabel lblChaiseNeuf = new JLabel("");
		lblChaiseNeuf.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblChaiseNeuf.setHorizontalAlignment(SwingConstants.CENTER);
		lblChaiseNeuf.setBounds(58, 61, 56, 16);
		panel.add(lblChaiseNeuf);
		lblChaiseNeuf.setText(String.valueOf(local.getNbChaises().getNeuf()));
		
		// Creation du label d'affichage du nombre de tables neuves
		JLabel lblTableNeuf = new JLabel("");
		lblTableNeuf.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTableNeuf.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableNeuf.setBounds(58, 93, 56, 16);
		panel.add(lblTableNeuf);
		lblTableNeuf.setText(String.valueOf(local.getNbTables().getNeuf()));
		
		// Creation du label d'affichage du nombre de chaises neuves
		JLabel lblChaiseBon = new JLabel("");
		lblChaiseBon.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblChaiseBon.setHorizontalAlignment(SwingConstants.CENTER);
		lblChaiseBon.setBounds(114, 64, 56, 16);
		panel.add(lblChaiseBon);
		lblChaiseBon.setText(String.valueOf(local.getNbChaises().getBon()));
		
		// Creation du label d'affichage du nombre de table en bon état
		JLabel lblTableBon = new JLabel("");
		lblTableBon.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTableBon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableBon.setBounds(114, 93, 56, 16);
		panel.add(lblTableBon);
		lblTableBon.setText(String.valueOf(local.getNbTables().getBon()));
		
		// Creation du label d'affichage du nombre de chaises usées
		JLabel lblChaiseUse = new JLabel("");
		lblChaiseUse.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblChaiseUse.setHorizontalAlignment(SwingConstants.CENTER);
		lblChaiseUse.setBounds(168, 63, 56, 16);
		panel.add(lblChaiseUse);
		lblChaiseUse.setText(String.valueOf(local.getNbChaises().getUse()));
		
		// Creation du label d'affichage du nombre de tables usées
		JLabel lblTableUse = new JLabel("");
		lblTableUse.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTableUse.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableUse.setBounds(168, 93, 56, 16);
		panel.add(lblTableUse);
		lblTableUse.setText(String.valueOf(local.getNbTables().getUse()));
		
		// Creation du label d'affichage du nombre de chaises critiques
		JLabel lblChaiseCritique = new JLabel("");
		lblChaiseCritique.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblChaiseCritique.setHorizontalAlignment(SwingConstants.CENTER);
		lblChaiseCritique.setBounds(223, 63, 56, 16);
		panel.add(lblChaiseCritique);
		lblChaiseCritique.setText(String.valueOf(local.getNbChaises().getCritique()));
		
		// Creation du label d'affichage du nombre de tables critiques
		JLabel lblTableCritique = new JLabel("");
		lblTableCritique.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTableCritique.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableCritique.setBounds(223, 93, 56, 16);
		panel.add(lblTableCritique);
		lblTableCritique.setText(String.valueOf(local.getNbTables().getCritique()));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(1, 160, 289, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 309, 300, 2);
		panel.add(separator_1);
		
		
		
	}

///////////////////////////////////////*METHODES*/////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void affiche(String string) {
		// TODO Auto-generated method stub
		
	}
}
