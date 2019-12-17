package view;

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
import javax.swing.SwingConstants;

@SuppressWarnings("deprecation")
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
		j14.setBounds(100, 100, 279, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j14.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 0, 267, 126);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// creation du label du nom
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNom.setBounds(6, 19, 56, 16);
		panel.add(lblNom);
		
		// creation du label du commentaire
		JLabel lblCommentaire = new JLabel("Commentaires :");
		lblCommentaire.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCommentaire.setBounds(6, 57, 95, 16);
		panel.add(lblCommentaire);
		
		// creation du champ texte de recuperation du nom
		txtNom = new JTextField();
		txtNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNom.setBounds(126, 15, 120, 25);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		// creation du champ texte de recuperation du commentaire
		txtCom = new JTextField();
		txtCom.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCom.setBounds(126, 53, 120, 25);
		panel.add(txtCom);
		txtCom.setColumns(10);
		
		// creation du label de validation
		lblValidation = new JLabel("Ajout effectué");
		lblValidation.setHorizontalAlignment(SwingConstants.CENTER);
		lblValidation.setBounds(20, 99, 145, 16);
		panel.add(lblValidation);
		
		// creation du bouton valider
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(182, 95, 85, 29);
		panel.add(btnValider);
		btnValider.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					local.genererIntervention(txtNom.getText(), txtCom.getText());
					lblValidation.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblValidation.setVisible(false);
		
	}

/////////////////////////////////////////////////*METHODES*////////////////////////////////////////////////////////////////////////////////

	@Override
	public void update(Observable o, Object arg) {
		
	}

	@Override
	public void affiche(String string) {
		
	}

}
