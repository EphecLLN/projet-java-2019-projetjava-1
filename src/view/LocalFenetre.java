package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Ecole;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class LocalFenetre extends Vue {

/////////////////////////////////////////*ATTRIBUTS*//////////////////////////////////////////////////////////////////////////////////////
	
	private JPanel contentPane;
	private JFrame j6;
	private JTextField txtLocal;
	private JTextField txtChaise;
	private JTextField txtTable;

////////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Creation de la fenetre
	 */
	public LocalFenetre(Ecole model, Controller controller) {
		super (model, controller);
		j6 = new JFrame();
		j6.setBounds(100, 100, 333, 326);
		j6.setTitle("Local");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j6.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 327, 293);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Creation du champs de texte indiquant le local
		txtLocal = new JTextField();
		txtLocal.setFont(new Font("Dialogue", Font.PLAIN, 12));
		txtLocal.setBounds(10, 10, 96, 19);
		panel.add(txtLocal);
		txtLocal.setColumns(10);
		
		//Creation du label
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
		comboBox_1.setBounds(10, 199, 96, 21);
		panel.add(comboBox_1);
		
		JButton btnModifier_1 = new JButton("Modifier");
		btnModifier_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnModifier_1.setBounds(127, 199, 101, 22);
		panel.add(btnModifier_1);
		
		txtChaise = new JTextField();
		txtChaise.setBounds(63, 63, 43, 19);
		panel.add(txtChaise);
		txtChaise.setColumns(10);
		
		txtTable = new JTextField();
		txtTable.setBounds(63, 83, 43, 19);
		panel.add(txtTable);
		txtTable.setColumns(10);
		
		JButton btnAjouterMateriel = new JButton("Ajouter Materiel");
		btnAjouterMateriel.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouterMateriel.setBounds(10, 252, 119, 25);
		panel.add(btnAjouterMateriel);
		
		JButton btnAjouterMaterielSpecial = new JButton("Ajouter Materiel Special");
		btnAjouterMaterielSpecial.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAjouterMaterielSpecial.setBounds(143, 252, 160, 24);
		panel.add(btnAjouterMaterielSpecial);
		j6.setVisible(true);
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
