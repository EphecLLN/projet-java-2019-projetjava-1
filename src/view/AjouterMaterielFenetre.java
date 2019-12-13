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
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AjouterMaterielFenetre extends Vue {

////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////

	private JPanel contentPane;
	private JFrame j10;
	private JTextField txtChaise;
	private JTextField txtTable;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////


	/**
	 * Création de la fenêtre
	 */
	public AjouterMaterielFenetre(Ecole model, Controller controller) {
		super(model, controller);
		j10 = new JFrame();
		j10.setTitle("Ajouter Mat\u00E9riel");
		j10.setVisible(true);
		j10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j10.setBounds(100, 100, 450, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j10.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 422, 115);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// creation du libellé des chaises
		JLabel lblChaise = new JLabel("Chaise ");
		lblChaise.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblChaise.setBounds(26, 19, 56, 16);
		panel.add(lblChaise);
		
		// creation du champ texte de récupération des chaises
		txtChaise = new JTextField();
		txtChaise.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtChaise.setBounds(80, 16, 116, 22);
		panel.add(txtChaise);
		txtChaise.setColumns(10);
		
		// création du libellé des tables
		JLabel lblTable = new JLabel("Table");
		lblTable.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTable.setBounds(221, 19, 56, 16);
		panel.add(lblTable);
		
		// création du champ texte de récupération des tables
		txtTable = new JTextField();
		txtTable.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtTable.setBounds(268, 16, 116, 22);
		panel.add(txtTable);
		txtTable.setColumns(10);
		
		//création du bouton de validation
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnValider.setBounds(26, 66, 358, 25);
		panel.add(btnValider);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
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
