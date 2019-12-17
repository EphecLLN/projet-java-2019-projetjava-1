package view;

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
import javax.swing.SwingConstants;

@SuppressWarnings("deprecation")
public class AjouterMaterielSpecialFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////


	private JPanel contentPane;
	private JFrame j12;
	private JTextField txtNom;
	private JTextField txtEtat;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	/**
	 * Création de la fenêtre
	 */
	public AjouterMaterielSpecialFenetre(Ecole model, Controller controller, Local local) {
		super(model, controller);
		
		j12 = new JFrame();
		j12.setTitle("Ajouter Materiel Special");
		j12.setBounds(100, 100, 247, 148);
		j12.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j12.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 236, 115);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// création du label du nom 
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNom.setBounds(23, 13, 56, 16);
		panel.add(lblNom);
		
		// création du champ texte de récupération du nom
		txtNom = new JTextField();
		txtNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtNom.setBounds(73, 10, 120, 25);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		// création du libbele de l'etat
		JLabel lblEtat = new JLabel("État :");
		lblEtat.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEtat.setBounds(23, 48, 56, 16);
		panel.add(lblEtat);
		
		// création du champ texte de récupération de l'etat
		txtEtat = new JTextField();
		txtEtat.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtEtat.setBounds(73, 44, 120, 25);
		panel.add(txtEtat);
		txtEtat.setColumns(10);
		
		// création du label de texte de validation ou d'erreur
		JLabel lblValidation = new JLabel("Ajout effectué");
		lblValidation.setHorizontalAlignment(SwingConstants.CENTER);
		lblValidation.setBounds(6, 87, 140, 16);
		panel.add(lblValidation);
		lblValidation.setVisible(false);
		
		// création du bouton de validation
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewButton.setBounds(151, 82, 85, 29);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((txtEtat.getText()).equals("Neuf")) || ((txtEtat.getText()).equals("Bon")) || ((txtEtat.getText()).equals("Use")) || ((txtEtat.getText()).equals("critique"))) {
					try {
						local.genererMaterielSpecial(txtNom.getText(), txtEtat.getText());
						lblValidation.setText("Ajout effectué");
						lblValidation.setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					lblValidation.setText("Veuillez entrez un état correct : Neuf, Bon, Use ou Critique");
					lblValidation.setVisible(true);
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
