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
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ActualiserMaterielSpecialFenetre extends Vue {

////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////

	private JPanel contentPane;
	private JFrame j11;
	private JTextField txtEtat;
	
///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////


	/**
	 * Creation de la fenetre
	 */
	public ActualiserMaterielSpecialFenetre(Ecole model, Controller controller, MaterielSpecial matSpec) {
		super(model, controller);
		
		j11 = new JFrame();
		j11.setVisible(true);
		j11.setTitle("Acualiser Matériel Spécial");
		j11.setBounds(100, 100, 450, 104);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j11.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 0, 422, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// creation du label texte nouvel etat
		JLabel lblNouveltat = new JLabel("Nouvel état :");
		lblNouveltat.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNouveltat.setBounds(25, 23, 89, 16);
		panel.add(lblNouveltat);
		
		// creation du champ texte de recuperation de l'etat
		txtEtat =new JTextField();
		txtEtat.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEtat.setBounds(99, 20, 190, 22);
		panel.add(txtEtat);
		txtEtat.setColumns(10);
		
		// creation du bouton valider
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnValider.setBounds(313, 19, 97, 25);
		panel.add(btnValider);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					matSpec.majMaterielSpecial(txtEtat.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				j11.dispose();
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
