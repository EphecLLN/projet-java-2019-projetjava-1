package view;

import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("deprecation")
public class AjouterImplantationFenetre extends Vue {

	////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////


	public JPanel contentPane;
	public JFrame j4;
	private JTextField txtNom;
	private JTextField txtNumero;
	private JTextField txtRue;
	private JTextField txtCodePostal;
	private JTextField txtVille;

	///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////


	/**
	 * Creation de la fenetre
	 */
	public AjouterImplantationFenetre(Ecole model, Controller controller, Implantation implantation) {
		super(model, controller);

		j4 = new JFrame();
		j4.setTitle("Ajouter Implantation");
		j4.setVisible(true);
		j4.setBounds(100, 100, 303, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j4.setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 303, 274);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(UIManager.getFont("ColorChooser.font"));
		lblNom.setBounds(29, 31, 35, 15);
		panel.add(lblNom);

		JLabel lblNumro = new JLabel("Numéro :");
		lblNumro.setFont(UIManager.getFont("ColorChooser.font"));
		lblNumro.setBounds(29, 70, 54, 15);
		panel.add(lblNumro);

		JLabel lblRue = new JLabel("Rue :");
		lblRue.setFont(UIManager.getFont("ColorChooser.font"));
		lblRue.setBounds(29, 110, 30, 15);
		panel.add(lblRue);

		JLabel lblVille = new JLabel("Ville :");
		lblVille.setFont(UIManager.getFont("ColorChooser.font"));
		lblVille.setBounds(29, 188, 32, 15);
		panel.add(lblVille);

		JLabel lblCodePostal = new JLabel("Code Postal :");
		lblCodePostal.setFont(UIManager.getFont("ColorChooser.font"));
		lblCodePostal.setBounds(29, 149, 76, 15);
		panel.add(lblCodePostal);

		txtNom = new JTextField();
		txtNom.setFont(UIManager.getFont("ColorChooser.font"));
		txtNom.setBounds(139, 26, 130, 26);
		panel.add(txtNom);
		txtNom.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setFont(UIManager.getFont("ColorChooser.font"));
		txtNumero.setBounds(139, 65, 130, 26);
		panel.add(txtNumero);
		txtNumero.setColumns(10);

		txtRue = new JTextField();
		txtRue.setFont(UIManager.getFont("ColorChooser.font"));
		txtRue.setBounds(139, 104, 130, 26);
		panel.add(txtRue);
		txtRue.setColumns(10);

		txtCodePostal = new JTextField();
		txtCodePostal.setFont(UIManager.getFont("ColorChooser.font"));
		txtCodePostal.setBounds(139, 143, 130, 26);
		panel.add(txtCodePostal);
		txtCodePostal.setColumns(10);

		txtVille = new JTextField();
		txtVille.setFont(UIManager.getFont("ColorChooser.font"));
		txtVille.setBounds(139, 182, 130, 26);
		panel.add(txtVille);
		txtVille.setColumns(10);

		JLabel lblErreur = new JLabel("Erreur, veuillez réessayer.");
		lblErreur.setVisible(false);
		lblErreur.setHorizontalAlignment(SwingConstants.CENTER);
		lblErreur.setFont(UIManager.getFont("ColorChooser.font"));
		lblErreur.setBounds(16, 215, 192, 53);
		panel.add(lblErreur);

		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnValider.setBounds(212, 239, 85, 29);
		panel.add(btnValider);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.genererImplantationEtAdresse(txtNom.getText(), Integer.parseInt(txtNumero.getText()), txtRue.getText(), Integer.parseInt(txtCodePostal.getText()), txtVille.getText());
					lblErreur.setForeground(Color.GREEN);
					lblErreur.setText("Local ajouté");
					lblErreur.setVisible(true);

				}catch (Exception er) {
					lblErreur.setText("<HTML>Le champ numéro n'accepte que des nombres entiers et codePostal uniquement un entier de 4 chiffres</html>");
					lblErreur.setForeground(Color.RED);
					lblErreur.setVisible(true);
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
