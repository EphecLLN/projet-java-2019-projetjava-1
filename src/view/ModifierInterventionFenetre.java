package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.*;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifierInterventionFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////


	private JPanel contentPane;
	private JFrame j13;
	private JTextField txtNom;
	private JTextField txtCom;
	private JButton btnValider;

	
///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	/**
	 * Création de la fenêtre
	 */
	public ModifierInterventionFenetre(Ecole model, Controller controller) {
		super(model, controller);
		
		j13 = new JFrame();
		j13.setTitle("Modifier Intervention");
		j13.setVisible(true);
		j13.setBounds(100, 100, 428, 126);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j13.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 403, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// création du libellé du nom
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNom.setBounds(12, 13, 56, 16);
		panel.add(lblNom);
		
		// création du champ texte de récupération du nom
		txtNom = new JTextField();
		txtNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNom.setBounds(51, 10, 214, 22);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		// création du libellé du commentaire
		JLabel lblNouveauCommentaire = new JLabel("Nouveau commentaire");
		lblNouveauCommentaire.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNouveauCommentaire.setBounds(12, 42, 140, 16);
		panel.add(lblNouveauCommentaire);
		
		// création du champ texte de récupération du commentaire
		txtCom = new JTextField();
		txtCom.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCom.setBounds(149, 39, 116, 22);
		panel.add(txtCom);
		txtCom.setColumns(10);
		
		// création du bouton de validation
		btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnValider.setBounds(288, 9, 97, 55);
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
