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

public class ActualiserMaterielSpecialFenetre extends Vue {

////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////

	private JPanel contentPane;
	private JFrame j11;
	private JTextField txtEtat;
	
///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////


	/**
	 * Création de la fenêtre
	 */
	public ActualiserMaterielSpecialFenetre(Ecole model, Controller controller) {
		super(model, controller);
		
		j11 = new JFrame();
		j11.setVisible(true);
		j11.setTitle("Acualiser Mat\u00E9riel Sp\u00E9cial");
		j11.setBounds(100, 100, 450, 104);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j11.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 0, 422, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// création du label texte nouvel état
		JLabel lblNouveltat = new JLabel("Nouvel \u00E9tat :");
		lblNouveltat.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNouveltat.setBounds(25, 23, 89, 16);
		panel.add(lblNouveltat);
		
		// création du champ texte de récupération de l'état
		txtEtat = new JTextField();
		txtEtat.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEtat.setBounds(99, 20, 190, 22);
		panel.add(txtEtat);
		txtEtat.setColumns(10);
		
		// création du bouton valider
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnValider.setBounds(313, 19, 97, 25);
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
