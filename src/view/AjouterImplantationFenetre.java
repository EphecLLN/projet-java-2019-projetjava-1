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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////


	/**
	 * Create the frame.
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
		
		JLabel lblNom = new JLabel("Nom ");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setBounds(23, 23, 56, 16);
		panel.add(lblNom);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdresse.setBounds(23, 65, 87, 16);
		panel.add(lblAdresse);
		
		JLabel lblNumro = new JLabel("Num\u00E9ro ");
		lblNumro.setBounds(43, 105, 132, 16);
		panel.add(lblNumro);
		
		JLabel lblRue = new JLabel("Rue ");
		lblRue.setBounds(43, 134, 56, 16);
		panel.add(lblRue);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(43, 163, 56, 16);
		panel.add(lblVille);
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setBounds(42, 192, 97, 16);
		panel.add(lblCodePostal);
		
		textField = new JTextField();
		textField.setBounds(59, 20, 198, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 102, 148, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(86, 134, 171, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(86, 160, 171, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(123, 189, 134, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
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
