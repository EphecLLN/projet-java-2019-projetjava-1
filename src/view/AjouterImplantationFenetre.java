package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class AjouterImplantationFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////


	public JPanel contentPane;
	public JFrame j4;
	private JTextField txtNom;
	private JTextField txtNum;
	private JTextField txtRue;
	private JTextField txtVille;
	private JTextField txtCodePostal;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////


	/**
	 * Creation de la fenetre
	 */
	public AjouterImplantationFenetre(Ecole model, Controller controller) {
		super(model, controller);
		
		j4 = new JFrame();
		j4.setTitle("Ajouter Implantation");
		j4.setVisible(true);
		j4.setBounds(100, 100, 321, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j4.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 303, 274);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Creation du label Nom
		JLabel lblNom = new JLabel("Nom ");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setBounds(23, 23, 56, 16);
		panel.add(lblNom);
		
		// Creation du label Adresse
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdresse.setBounds(23, 65, 87, 16);
		panel.add(lblAdresse);
		
		// Creation du label Numerp
		JLabel lblNumro = new JLabel("Numero ");
		lblNumro.setBounds(43, 105, 132, 16);
		panel.add(lblNumro);
		
		// Creation du label Rue
		JLabel lblRue = new JLabel("Rue ");
		lblRue.setBounds(43, 134, 56, 16);
		panel.add(lblRue);
		
		// Creation du label Ville
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(43, 163, 56, 16);
		panel.add(lblVille);
		
		// Creation du label Code Postal
		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setBounds(42, 192, 97, 16);
		panel.add(lblCodePostal);
		
		// Creation du champ de recuperation du nom
		txtNom = new JTextField();
		txtNom.setBounds(59, 20, 198, 22);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		// Creation du champ de recuperation du numero
		txtNum = new JTextField();
		txtNum.setBounds(109, 102, 148, 22);
		panel.add(txtNum);
		txtNum.setColumns(10);
		
		// Creation du champ de recuperation de la rue
		txtRue = new JTextField();
		txtRue.setBounds(86, 134, 171, 22);
		panel.add(txtRue);
		txtRue.setColumns(10);
		
		// Creation du champ de recuperation de la ville
		txtVille = new JTextField();
		txtVille.setBounds(86, 160, 171, 22);
		panel.add(txtVille);
		txtVille.setColumns(10);
		
		// Creation du champ de recuperation du code postal
		txtCodePostal = new JTextField();
		txtCodePostal.setBounds(123, 189, 134, 22);
		panel.add(txtCodePostal);
		txtCodePostal.setColumns(10);
		
		// Creation du bouton de validation
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(109, 249, 97, 25);
		panel.add(btnValider);
	}

/////////////////////////////////////////////////*METHODES*////////////////////////////////////////////////////////////////////////////////

	


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void affiche(String string) {
		// TODO Auto-generated method stub
		
	}

}
