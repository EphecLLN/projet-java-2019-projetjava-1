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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class AjouterMaterielSpecialFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////


	private JPanel contentPane;
	private JFrame j12;
	private JTextField txtNom;
	private JTextField txtEtat;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	/**
	 * Creation de la fenetre
	 */
	public AjouterMaterielSpecialFenetre(Ecole model, Controller controller, Local local) {
		super(model, controller);
		
		j12 = new JFrame();
		j12.setTitle("Ajouter Materiel Special");
		j12.setBounds(100, 100, 426, 153);
		j12.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j12.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 397, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// creation du libelle du nom 
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNom.setBounds(23, 13, 56, 16);
		panel.add(lblNom);
		
		// creation du champ texte de recuperation du nom
		txtNom = new JTextField();
		txtNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNom.setBounds(73, 10, 116, 22);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		// creation du libbele de l'etat
		JLabel lblEtat = new JLabel("Etat");
		lblEtat.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEtat.setBounds(207, 13, 56, 16);
		panel.add(lblEtat);
		
		// creation du champ texte de recuperation de l'etat
		txtEtat = new JTextField();
		txtEtat.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEtat.setBounds(254, 10, 116, 22);
		panel.add(txtEtat);
		txtEtat.setColumns(10);
		
		// creation du bouton de validation
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewButton.setBounds(23, 60, 346, 25);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					local.genererMaterielSpecial(txtNom.getText(), txtEtat.getText());
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
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