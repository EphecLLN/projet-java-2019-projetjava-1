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

public class AjouterInterventionFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////


	private JPanel contentPane;
	private JFrame j14;
	private JTextField txtNom;
	private JTextField txtCom;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	

	/**
	 * Cr�ation de la fen�tre
	 */
	public AjouterInterventionFenetre(Ecole model, Controller controller) {
		super(model, controller);
		
		j14 = new JFrame();
		j14.setTitle("Ajouter Intervention");
		j14.setVisible(true);
		j14.setBounds(100, 100, 385, 131);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j14.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 365, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// cr�ation du libell� du nom
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNom.setBounds(22, 23, 56, 16);
		panel.add(lblNom);
		
		// cr�ation du libell� du commentaire
		JLabel lblCommentaire = new JLabel("Commentaire");
		lblCommentaire.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCommentaire.setBounds(22, 52, 95, 16);
		panel.add(lblCommentaire);
		
		// cr�ation du champ texte de r�cup�ration du nom
		txtNom = new JTextField();
		txtNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNom.setBounds(58, 20, 170, 22);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		// cr�ation du champ texte de r�cup�ration du commentaire
		txtCom = new JTextField();
		txtCom.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCom.setBounds(106, 49, 122, 22);
		panel.add(txtCom);
		txtCom.setColumns(10);
		
		// cr�ation du bouton valider
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnValider.setBounds(247, 19, 97, 52);
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
