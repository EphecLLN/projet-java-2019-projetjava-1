package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Ecole;

public class LocalInformatiqueFenetre extends Vue {
	
/////////////////////////////////////////*ATTRIBUTS*//////////////////////////////////////////////////////////////////////////////////////

	private JPanel contentPane;
    private JFrame j7;
    private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
    
////////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Create the frame.
	 */
	public LocalInformatiqueFenetre(Ecole model, Controller controller) {
		super(model, controller);
		j7.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		j7 = new JFrame();
		j7.setTitle("Local Informatique");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j7.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 506, 484);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField.setBounds(10, 10, 96, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mat\u00E9riels :");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 39, 96, 16);
		panel.add(lblNewLabel);
		
		JLabel lblChaises = new JLabel("Chaises");
		lblChaises.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblChaises.setBounds(10, 65, 54, 13);
		panel.add(lblChaises);
		
		JLabel lblTables = new JLabel("Tables");
		lblTables.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTables.setBounds(10, 82, 48, 19);
		panel.add(lblTables);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnActualiser.setBounds(89, 37, 85, 21);
		panel.add(btnActualiser);
		
		JLabel lblMaterielSpecial = new JLabel("Materiel special :");
		lblMaterielSpecial.setFont(new Font("Dialog", Font.BOLD, 12));
		lblMaterielSpecial.setBounds(10, 111, 96, 19);
		panel.add(lblMaterielSpecial);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox.setBounds(10, 140, 96, 21);
		panel.add(comboBox);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnModifier.setBounds(127, 140, 101, 21);
		panel.add(btnModifier);
		
		JLabel lblIntervention = new JLabel("Intervention :");
		lblIntervention.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIntervention.setBounds(13, 171, 93, 18);
		panel.add(lblIntervention);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox_1.setBounds(10, 199, 96, 21);
		panel.add(comboBox_1);
		
		JButton btnModifier_1 = new JButton("Modifier");
		btnModifier_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnModifier_1.setBounds(127, 199, 101, 22);
		panel.add(btnModifier_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_1.setBounds(63, 63, 43, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_2.setBounds(63, 83, 43, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAjouterMateriel = new JButton("Ajouter Materiel");
		btnAjouterMateriel.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouterMateriel.setBounds(10, 240, 119, 25);
		panel.add(btnAjouterMateriel);
		
		JButton btnAjouterMaterielSpecial = new JButton("Ajouter Materiel Special");
		btnAjouterMaterielSpecial.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouterMaterielSpecial.setBounds(137, 240, 160, 24);
		panel.add(btnAjouterMaterielSpecial);
		
		JLabel lblNombreDePc = new JLabel("Nombre de PC :");
		lblNombreDePc.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNombreDePc.setBounds(10, 286, 93, 19);
		panel.add(lblNombreDePc);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_3.setBounds(116, 287, 48, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblEtatPc = new JLabel("Etat PC ");
		lblEtatPc.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEtatPc.setBounds(10, 323, 54, 16);
		panel.add(lblEtatPc);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox_2.setBounds(61, 322, 68, 21);
		panel.add(comboBox_2);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewButton.setBounds(143, 321, 85, 22);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 363, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblToure = new JLabel("Toure");
		lblToure.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblToure.setBounds(10, 391, 45, 13);
		panel.add(lblToure);
		
		JLabel lblNewLabel_2 = new JLabel("Ecran");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 414, 45, 13);
		panel.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(63, 361, 96, 19);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(63, 389, 96, 19);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(63, 414, 96, 19);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Clavier");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(197, 364, 45, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Souris");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(197, 392, 45, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Commentaire");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(197, 415, 85, 13);
		panel.add(lblNewLabel_5);
		
		textField_7 = new JTextField();
		textField_7.setBounds(284, 412, 191, 19);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(284, 389, 96, 19);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(284, 361, 96, 19);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Ajouter PC");
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewButton_1.setBounds(10, 453, 96, 21);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer PC");
		btnNewButton_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewButton_2.setBounds(116, 453, 112, 21);
		panel.add(btnNewButton_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(238, 454, 59, 21);
		panel.add(comboBox_3);
		
		j7.setVisible(true);
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
