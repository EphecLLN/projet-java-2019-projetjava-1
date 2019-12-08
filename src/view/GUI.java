package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Ecole;
import view.VueConsole.ReadInput;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class GUI extends Vue{
	

	private JFrame j;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	protected Scanner sc;
	

	/**
	 * Launch the application.
	 */
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI(model, controller);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public GUI(Ecole model, Controller controller) {
	super(model, controller);
		
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setBounds(100, 100, 450, 207);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(8, 7, 3, 2));
		contentPane.setBorder(null);
		j.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrNomDutilisateur = new JTextArea();
		txtrNomDutilisateur.setFont(new Font("Poor Richard", Font.BOLD, 30));
		txtrNomDutilisateur.setForeground(new Color(0, 128, 128));
		txtrNomDutilisateur.setText("Nom d'utilisateur :");
		txtrNomDutilisateur.setBounds(12, 13, 245, 55);
		txtrNomDutilisateur.setEditable(false);
		txtrNomDutilisateur.setOpaque(false);
		contentPane.add(txtrNomDutilisateur);
		
		JTextArea txtrMotDePasse = new JTextArea();
		txtrMotDePasse.setFont(new Font("Poor Richard", Font.BOLD, 30));
		txtrMotDePasse.setText("Mot de passe :");
		txtrMotDePasse.setForeground(new Color(0, 128, 128));
		txtrMotDePasse.setBounds(12, 70, 245, 39);
		txtrMotDePasse.setEditable(false);
		txtrMotDePasse.setOpaque(false);
		contentPane.add(txtrMotDePasse);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudo = "", mdp = "" , imp = "",var = "", var2= "";
				do {
					System.out.print("Utilisateur : ");
					Scanner scan = new Scanner (System.in);
					pseudo = scan.nextLine();
					System.out.print("Mot de passe : ");
					Scanner scan2 = new Scanner(System.in);
					mdp = scan2.nextLine();
				}
				while(!controller.login(pseudo, mdp));
				System.out.println("Connexion réussie !");

			}
		});
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnValider.setBackground(new Color(199, 21, 133));
		btnValider.setBounds(323, 135, 97, 25);
		contentPane.add(btnValider);
		
		textField = new JTextField();
		textField.setDisabledTextColor(new Color(139, 0, 0));
		textField.setCaretColor(new Color(240, 248, 255));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(270, 27, 150, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(211, 84, 150, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affiche(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}
