package view;


import controller.Controller;
import model.Ecole;
import model.Implantation;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("deprecation")
public class AjouterLocalFenetre extends Vue {

////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////

	private JPanel contentPane;
	private JFrame j3;
	private JTextField champNom;
	private JLabel lblNeuf;
	private JTextField txtChaiseNeuf;
	private JTextField txtTableNeuf;
	private JLabel lblBon;
	private JLabel lblUse;
	private JLabel lblCritique;
	private JTextField txtChaiseUse;
	private JTextField txtChaiseBon;
	private JTextField txtTableUse;
	private JTextField txtTableBon;
	private JTextField txtChaiseCritique;
	private JTextField txtTableCritique;
	private JLabel lblErreur;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	/**
	 * Creation de la fenetre
	 */
	public AjouterLocalFenetre(Ecole model, Controller controller, Implantation implantation) {
		super(model, controller);

		j3 = new JFrame();
		j3.setVisible(true);
		j3.setTitle("Ajouter Local");
		j3.setBounds(100, 100, 341, 334);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j3.setContentPane(contentPane);
		contentPane.setLayout(null);

		// creation du label Nom
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNom.setBounds(22, 24, 42, 16);
		contentPane.add(lblNom);

		// creation du label chaises
		JLabel lblNombreDeChaises = new JLabel("chaises");
		lblNombreDeChaises.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDeChaises.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombreDeChaises.setBounds(115, 86, 64, 16);
		contentPane.add(lblNombreDeChaises);

		// creation du label tables
		JLabel lblNombreDeTables = new JLabel("tables");
		lblNombreDeTables.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDeTables.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombreDeTables.setBounds(220, 86, 58, 16);
		contentPane.add(lblNombreDeTables);

		// creation du champ de récupération du nom
		champNom = new JTextField();
		champNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		champNom.setHorizontalAlignment(SwingConstants.CENTER);
		champNom.setBounds(77, 21, 40, 22);
		contentPane.add(champNom);
		champNom.setColumns(10);

		// creation du champ de recuperation d'une table use
		txtTableUse = new JTextField();
		txtTableUse.setHorizontalAlignment(SwingConstants.CENTER);
		txtTableUse.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtTableUse.setColumns(10);
		txtTableUse.setBounds(230, 174, 40, 22);
		contentPane.add(txtTableUse);

		// creation de la checkbox
		JCheckBox chckbxLocalInformatique = new JCheckBox("");
		chckbxLocalInformatique.setBounds(283, 20, 28, 23);
		contentPane.add(chckbxLocalInformatique);

		// creation du label local informatique 
		JLabel lblLocalInformatique = new JLabel("Local informatique :");
		lblLocalInformatique.setBounds(149, 24, 129, 16);
		contentPane.add(lblLocalInformatique);

		// creation du label saisir du nom incorrecte
		lblErreur = new JLabel("Saisie du nom incorrecte !");
		lblErreur.setHorizontalTextPosition(SwingConstants.CENTER);
		lblErreur.setVisible(false);
		lblErreur.setForeground(Color.RED);
		lblErreur.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblErreur.setHorizontalAlignment(SwingConstants.CENTER);
		lblErreur.setBounds(32, 241, 279, 30);
		contentPane.add(lblErreur);

		// creation du champ de recuperation d'une table neuve
		txtTableNeuf = new JTextField();
		txtTableNeuf.setHorizontalAlignment(SwingConstants.CENTER);
		txtTableNeuf.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtTableNeuf.setBounds(230, 114, 40, 22);
		contentPane.add(txtTableNeuf);
		txtTableNeuf.setColumns(10);

		// creation du champ de recuperation d'une chaise usée
		txtChaiseUse = new JTextField();
		txtChaiseUse.setHorizontalAlignment(SwingConstants.CENTER);
		txtChaiseUse.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtChaiseUse.setColumns(10);
		txtChaiseUse.setBounds(128, 174, 40, 22);
		contentPane.add(txtChaiseUse);

		// creation du champ de recuperation d'une table en bon état
		txtTableBon = new JTextField();
		txtTableBon.setHorizontalAlignment(SwingConstants.CENTER);
		txtTableBon.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtTableBon.setColumns(10);
		txtTableBon.setBounds(230, 143, 40, 22);
		contentPane.add(txtTableBon);

		// creation du label Neuf
		lblNeuf = new JLabel("Neuf");
		lblNeuf.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNeuf.setBounds(22, 117, 35, 16);
		contentPane.add(lblNeuf);

		// creation du champ de recuperation d'une chaise neuve
		txtChaiseNeuf = new JTextField();
		txtChaiseNeuf.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtChaiseNeuf.setHorizontalAlignment(SwingConstants.CENTER);
		txtChaiseNeuf.setToolTipText("");
		txtChaiseNeuf.setBounds(128, 114, 40, 22);
		contentPane.add(txtChaiseNeuf);
		txtChaiseNeuf.setColumns(10);

		// creation du label Bon
		lblBon = new JLabel("Bon");
		lblBon.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblBon.setBounds(22, 146, 35, 16);
		contentPane.add(lblBon);

		// creation du label Usé
		lblUse = new JLabel("Use");
		lblUse.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblUse.setBounds(22, 177, 35, 16);
		contentPane.add(lblUse);

		// creation du label Critique
		lblCritique = new JLabel("Critique");
		lblCritique.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCritique.setBounds(22, 206, 58, 16);
		contentPane.add(lblCritique);

		// creation du champ de recuperation d'un chaise en bon état
		txtChaiseBon = new JTextField();
		txtChaiseBon.setHorizontalAlignment(SwingConstants.CENTER);
		txtChaiseBon.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtChaiseBon.setColumns(10);
		txtChaiseBon.setBounds(128, 143, 40, 22);
		contentPane.add(txtChaiseBon);

		// creation du champ de recuperation d'une chaise critique
		txtChaiseCritique = new JTextField();
		txtChaiseCritique.setHorizontalAlignment(SwingConstants.CENTER);
		txtChaiseCritique.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtChaiseCritique.setColumns(10);
		txtChaiseCritique.setBounds(128, 203, 40, 22);
		contentPane.add(txtChaiseCritique);

		// creation du champ de recuperation d'une table critique
		txtTableCritique = new JTextField();
		txtTableCritique.setHorizontalAlignment(SwingConstants.CENTER);
		txtTableCritique.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtTableCritique.setBounds(230, 203, 40, 22);
		contentPane.add(txtTableCritique);
		txtTableCritique.setColumns(10);

		// creation du bouton de validation
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(230, 273, 97, 25);
		contentPane.add(btnValider);
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(champNom.getText().contains("L") && champNom.getText().length() == 3) {
					try {
						int[] chaises = {Integer.parseInt(txtChaiseNeuf.getText()), Integer.parseInt(txtChaiseBon.getText()), Integer.parseInt(txtChaiseUse.getText()), Integer.parseInt(txtChaiseCritique.getText())};
						int[] tables = {Integer.parseInt(txtTableNeuf.getText()), Integer.parseInt(txtTableBon.getText()), Integer.parseInt(txtTableUse.getText()), Integer.parseInt(txtTableCritique.getText())};

						controller.genererLocal(champNom.getText(), chckbxLocalInformatique.isSelected(), chaises, tables, implantation);
						lblErreur.setForeground(Color.GREEN);
						lblErreur.setText("Local ajouté");
						lblErreur.setVisible(true);

					}catch (Exception er) {
						lblErreur.setText("<HTML>Les champs chaises et tables n'acceptent que des nombres entiers</html>");
						lblErreur.setVisible(true);
					}
				}
				else {
					lblErreur.setText("Le numéro du local doit être du type : LXX");
					lblErreur.setVisible(true);
				}
			}
		});

	
	}


/////////////////////////////////////////////////*METHODES*////////////////////////////////////////////////////////////////////////////////

	@Override
	public void update(Observable o, Object arg) {

	}

	@Override
	public void affiche(String string) {

	}
}
