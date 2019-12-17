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

public class AjouterInterventionFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////


	private JPanel contentPane;
	private JFrame j14;
	private JTextField txtNom;
	private JTextField txtCom;
	private JLabel lblValidation;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	

	/**
	 * Creation de la fenetre
	 */
	public AjouterInterventionFenetre(Ecole model, Controller controller, Local local) {
		super(model, controller);
		
		j14 = new JFrame();
		j14.setTitle("Ajouter Intervention");
		j14.setVisible(true);
		j14.setBounds(100, 100, 385, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j14.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 365, 107);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// creation du label du nom
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNom.setBounds(22, 23, 56, 16);
		panel.add(lblNom);
		
		// creation du label du commentaire
		JLabel lblCommentaire = new JLabel("Commentaire");
		lblCommentaire.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCommentaire.setBounds(22, 52, 95, 16);
		panel.add(lblCommentaire);
		
		// creation du champ texte de recuperation du nom
		txtNom = new JTextField();
		txtNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNom.setBounds(58, 20, 170, 22);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		// creation du champ texte de recuperation du commentaire
		txtCom = new JTextField();
		txtCom.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCom.setBounds(106, 49, 122, 22);
		panel.add(txtCom);
		txtCom.setColumns(10);
		
		// creation du label de validation
		lblValidation = new JLabel("Ajout effectué");
		lblValidation.setBounds(22, 81, 322, 16);
		panel.add(lblValidation);
		lblValidation.setVisible(false);
		
		// creation du bouton valider
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnValider.setBounds(247, 19, 97, 52);
		panel.add(btnValider);
		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					local.genererIntervention(txtNom.getText(), txtCom.getText());
					lblValidation.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
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
