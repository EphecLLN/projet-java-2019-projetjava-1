package view;

import java.awt.Color;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import model.Ecole;
import model.LocalInformatique;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings({ "rawtypes", "deprecation" })
public class AjouterPCFenetre extends Vue {
	
/////////////////////////////////////////*ATTRIBUTS*//////////////////////////////////////////////////////////////////////////////////////

	private JPanel contentPane;
	private JFrame j8;
	private JTextField txtNom;
	private JTextField txtType;
	private JComboBox boxTour;
	private JComboBox boxEcran;
	private JComboBox boxClavier;
	private JComboBox boxSouris;
	private JTextField txtCommentaires;

////////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Creation de la fenetre 
	 */
	@SuppressWarnings("unchecked")
	public AjouterPCFenetre(Ecole model, Controller controller, LocalInformatique localInformatique) {
		super(model,controller);
		j8 = new JFrame();
		j8.setVisible(true);
		j8.setBounds(100, 100, 275, 276);
		contentPane = new JPanel();
		j8.setTitle("Ajouter PC");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j8.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(125, 8, 130, 26);
		contentPane.add(txtNom);
		
		JLabel label = new JLabel("Nom :");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setBounds(14, 13, 38, 16);
		contentPane.add(label);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblType.setBounds(14, 41, 38, 16);
		contentPane.add(lblType);
		
		JLabel lblTour = new JLabel("Tour :");
		lblTour.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTour.setBounds(14, 69, 37, 16);
		contentPane.add(lblTour);
		
		JLabel lblEcran = new JLabel("Écran :");
		lblEcran.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEcran.setBounds(14, 97, 42, 16);
		contentPane.add(lblEcran);
		
		JLabel lblClavier = new JLabel("Clavier :");
		lblClavier.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblClavier.setBounds(14, 125, 51, 16);
		contentPane.add(lblClavier);
		
		JLabel lblSouris = new JLabel("Souris :");
		lblSouris.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblSouris.setBounds(14, 153, 47, 16);
		contentPane.add(lblSouris);
		
		JLabel lblCommentaires = new JLabel("Commentaires :");
		lblCommentaires.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCommentaires.setBounds(14, 181, 99, 16);
		contentPane.add(lblCommentaires);
		
		txtType = new JTextField();
		txtType.setColumns(10);
		txtType.setBounds(125, 36, 130, 26);
		contentPane.add(txtType);
		
		boxTour = new JComboBox();
		boxTour.setModel(new DefaultComboBoxModel(new String[] {"Neuf", "Bon", "Usé", "Critique"}));
		boxTour.setBounds(125, 64, 130, 26);
		contentPane.add(boxTour);
		
		boxEcran = new JComboBox();
		boxEcran.setModel(new DefaultComboBoxModel(new String[] {"Neuf", "Bon", "Usé", "Critique"}));
		boxEcran.setBounds(125, 92, 130, 26);
		contentPane.add(boxEcran);
		
		boxClavier = new JComboBox();
		boxClavier.setModel(new DefaultComboBoxModel(new String[] {"Neuf", "Bon", "Usé", "Critique"}));
		boxClavier.setBounds(125, 120, 130, 26);
		contentPane.add(boxClavier);
		
		boxSouris = new JComboBox();
		boxSouris.setModel(new DefaultComboBoxModel(new String[] {"Neuf", "Bon", "Usé", "Critique"}));
		boxSouris.setBounds(125, 148, 130, 26);
		contentPane.add(boxSouris);
		
		txtCommentaires = new JTextField();
		txtCommentaires.setColumns(10);
		txtCommentaires.setBounds(125, 176, 130, 26);
		contentPane.add(txtCommentaires);
		
		JLabel lblErreur = new JLabel("Erreur, veuillez réessayer.");
		lblErreur.setVisible(false);
		lblErreur.setHorizontalAlignment(SwingConstants.CENTER);
		lblErreur.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblErreur.setBounds(14, 214, 158, 26);
		contentPane.add(lblErreur);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNom.getText().contains("PC") && txtNom.getText().length() == 5) {
					try {
						localInformatique.genererPc(txtNom.getText(), txtType.getText(), boxTour.getSelectedItem().toString(), boxEcran.getSelectedItem().toString(), boxClavier.getSelectedItem().toString(), boxSouris.getSelectedItem().toString(), txtCommentaires.getText());
						lblErreur.setForeground(Color.GREEN);
						lblErreur.setText("PC ajouté");
						lblErreur.setVisible(true);

						
					} catch (SQLException e1) {
						System.out.println(e1);
						lblErreur.setForeground(Color.RED);
						lblErreur.setText("Erreur, veuillez réessayer.");
						lblErreur.setVisible(true);
					}
				}
				else {
					lblErreur.setForeground(Color.RED);
					lblErreur.setText("<html>Le nom du PC doit être du type PCXXX</html>");
					lblErreur.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(184, 219, 85, 29);
		contentPane.add(btnNewButton);
	}
	
	
///////////////////////////////////////*METHODES*/////////////////////////////////////////////////////////////////////////////////////////


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void affiche(String string) {
		// TODO Auto-generated method stub
		
	}
}
