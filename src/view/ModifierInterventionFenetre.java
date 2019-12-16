package view;

import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("deprecation")
public class ModifierInterventionFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////


	private JPanel contentPane;
	private JFrame j13;
	private JTextField txtNom;
	private JTextField txtCom;
	private JButton btnValider;

	
///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	/**
	 * Creation de la fenetre
	 */
	public ModifierInterventionFenetre(Ecole model, Controller controller, Intervention inter) {
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
		
		// creation du libelle du nom
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNom.setBounds(12, 13, 56, 16);
		panel.add(lblNom);
		
		// creation du champ texte de recuperation du nom
		txtNom = new JTextField();
		txtNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNom.setBounds(51, 10, 214, 22);
		panel.add(txtNom);
		txtNom.setColumns(10);
		txtNom.setText(inter.getNom());
		
		// creation du libelle du commentaire
		JLabel lblNouveauCommentaire = new JLabel("Nouveau commentaire");
		lblNouveauCommentaire.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNouveauCommentaire.setBounds(12, 42, 140, 16);
		panel.add(lblNouveauCommentaire);
		
		// creation du champ texte de recuperation du commentaire
		txtCom = new JTextField();
		txtCom.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCom.setBounds(149, 39, 116, 22);
		panel.add(txtCom);
		txtCom.setColumns(10);
		txtCom.setText(inter.getCommentaires());
		
		// creation du bouton de validation
		btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnValider.setBounds(288, 9, 97, 55);
		panel.add(btnValider);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					inter.majIntervention(txtNom.getText(), txtCom.getText());
					model.synchroImplantationsEtAdresses();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
	}
	
/////////////////////////////////////////////////*METHODES*////////////////////////////////////////////////////////////////////////////////


	@Override
	public void update(Observable o, Object arg) {
	}

	@Override
	public void affiche(String string) {
	}

}
