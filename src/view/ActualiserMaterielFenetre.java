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
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActualiserMaterielFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////


	public JPanel contentPane;
	public JFrame j9;
	private JTextField txtNeuf;
	private JTextField txtBon;
	private JTextField txtUse;
	private JTextField txtCritique;


///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	/**
	 * Création de la fenêtre
	 */
	public ActualiserMaterielFenetre(Ecole model, Controller controller) {
		super(model, controller);
		j9 = new JFrame();
		j9.setTitle("Actualiser Mat\u00E9riel");
		j9.setVisible(true);
		j9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j9.setBounds(100, 100, 318, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j9.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 300, 232);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// creation du label neuf
		JLabel lblNeuf = new JLabel("Neuf");
		lblNeuf.setBounds(58, 60, 56, 16);
		panel.add(lblNeuf);
		
		// creation du label bon
		JLabel lblBon = new JLabel("Bon");
		lblBon.setBounds(58, 89, 56, 16);
		panel.add(lblBon);
		
		// creation du label usé
		JLabel lblUs = new JLabel("Us\u00E9");
		lblUs.setBounds(58, 118, 56, 16);
		panel.add(lblUs);
		
		// creation du label critique
		JLabel lblCritique = new JLabel("Critique");
		lblCritique.setBounds(58, 147, 56, 16);
		panel.add(lblCritique);
		
		// creation du bouton de validation
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(98, 194, 97, 25);
		panel.add(btnValider);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtNeuf.getText() = model.local.getNeuf();
			}
		});
		
		// creation du champ texte de recuperation de neuf
		txtNeuf = new JTextField();
		txtNeuf.setBounds(113, 57, 128, 22);
		panel.add(txtNeuf);
		txtNeuf.setColumns(10);
		
		// creation du champ texte de recuperation de bon
		txtBon = new JTextField();
		txtBon.setBounds(113, 86, 128, 22);
		panel.add(txtBon);
		txtBon.setColumns(10);
		
		// creation du champ texte de recuperation de usé
		txtUse = new JTextField();
		txtUse.setBounds(113, 115, 128, 22);
		panel.add(txtUse);
		txtUse.setColumns(10);
		
		// creation du champ texte de recuperation de critique
		txtCritique = new JTextField();
		txtCritique.setBounds(113, 144, 128, 22);
		panel.add(txtCritique);
		txtCritique.setColumns(10);
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
