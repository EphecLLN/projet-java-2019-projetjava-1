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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ActualiserMaterielFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////


	private JPanel contentPane;
	private JFrame j9;
	private JTextField txtChaiseNeuf;
	private JTextField txtTableNeuf;
	private JTextField txtChaiseBon;
	private JTextField txtChaiseUse;
	private JTextField txtChaiseCritique;
	private JTextField txtTableBon;
	private JTextField txtTableUse;
	private JTextField txtTableCritique;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	/**
	 * Creation de la fenetre
	 */
	public ActualiserMaterielFenetre(Ecole model, Controller controller, Local local) {
		super(model, controller);
		j9 = new JFrame();
		j9.setTitle("Actualiser Matériel");
		j9.setVisible(true);
		j9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j9.setBounds(100, 100, 308, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j9.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 308, 232);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// creation du label neuf
		JLabel lblNeuf = new JLabel("Neuf");
		lblNeuf.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNeuf.setBounds(44, 53, 56, 16);
		panel.add(lblNeuf);
		
		// creation du label bon
		JLabel lblBon = new JLabel("Bon");
		lblBon.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblBon.setBounds(44, 82, 56, 16);
		panel.add(lblBon);
		
		// creation du label usé
		JLabel lblUs = new JLabel("Usé");
		lblUs.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblUs.setBounds(44, 118, 56, 16);
		panel.add(lblUs);
		
		// creation du label critique
		JLabel lblCritique = new JLabel("Critique");
		lblCritique.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCritique.setBounds(31, 150, 56, 16);
		panel.add(lblCritique);
		
		
		// creation du label Chaises
		JLabel lblChaises = new JLabel("Chaises");
		lblChaises.setFont(new Font("Dialog", Font.BOLD, 12));
		lblChaises.setBounds(98, 24, 56, 16);
		panel.add(lblChaises);
		
		// creation du label Tables
		JLabel lblTables = new JLabel("Tables");
		lblTables.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTables.setBounds(186, 24, 56, 16);
		panel.add(lblTables);
		
		// creation du champ de recuperation du nombre de chaises neuves
		txtChaiseNeuf = new JTextField();
		txtChaiseNeuf.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtChaiseNeuf.setHorizontalAlignment(SwingConstants.CENTER);
		txtChaiseNeuf.setBounds(98, 53, 47, 22);
		panel.add(txtChaiseNeuf);
		txtChaiseNeuf.setColumns(10);
		
		// creation du champ de recuperation du nombre de tables neuves
		txtTableNeuf = new JTextField();
		txtTableNeuf.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtTableNeuf.setBounds(185, 53, 47, 22);
		panel.add(txtTableNeuf);
		txtTableNeuf.setColumns(10);
		
		// creation du champ de recuperation du nombre de chaise en bon état
		txtChaiseBon = new JTextField();
		txtChaiseBon.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtChaiseBon.setHorizontalAlignment(SwingConstants.CENTER);
		txtChaiseBon.setColumns(10);
		txtChaiseBon.setBounds(98, 86, 47, 22);
		panel.add(txtChaiseBon);
		
		// creation du champ de recuperation du nombre de chaises usées
		txtChaiseUse = new JTextField();
		txtChaiseUse.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtChaiseUse.setHorizontalAlignment(SwingConstants.CENTER);
		txtChaiseUse.setColumns(10);
		txtChaiseUse.setBounds(98, 118, 47, 22);
		panel.add(txtChaiseUse);
		
		// creation du champ de recuperation du nombre de chaises critiques
		txtChaiseCritique = new JTextField();
		txtChaiseCritique.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtChaiseCritique.setHorizontalAlignment(SwingConstants.CENTER);
		txtChaiseCritique.setColumns(10);
		txtChaiseCritique.setBounds(98, 147, 47, 22);
		panel.add(txtChaiseCritique);
		
		// creation du champ de recuperation du nombre de tables en bon état
		txtTableBon = new JTextField();
		txtTableBon.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtTableBon.setHorizontalAlignment(SwingConstants.CENTER);
		txtTableBon.setColumns(10);
		txtTableBon.setBounds(186, 86, 47, 22);
		panel.add(txtTableBon);
		
		// creation du champ de recuperation du nombre de tables usées
		txtTableUse = new JTextField();
		txtTableUse.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtTableUse.setHorizontalAlignment(SwingConstants.CENTER);
		txtTableUse.setColumns(10);
		txtTableUse.setBounds(186, 118, 47, 22);
		panel.add(txtTableUse);
		
		// creation du champ de recuperation du nombre de tables critiques
		txtTableCritique = new JTextField();
		txtTableCritique.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtTableCritique.setHorizontalAlignment(SwingConstants.CENTER);
		txtTableCritique.setColumns(10);
		txtTableCritique.setBounds(186, 147, 47, 22);
		panel.add(txtTableCritique);

		// creation du bouton de validation
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(31, 194, 226, 25);
		panel.add(btnValider);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] chaises = new int[4];
				int[] tables = new int[4];
				try {
					local.getNbChaises().supprimer();
					local.getNbTables().supprimer();
					
					chaises[0] = Integer.parseInt(txtChaiseNeuf.getText());
					chaises[1] = Integer.parseInt(txtChaiseBon.getText());
					chaises[2] = Integer.parseInt(txtChaiseUse.getText());
					chaises[3] = Integer.parseInt(txtChaiseCritique.getText());
					tables[0] = Integer.parseInt(txtTableNeuf.getText());
					tables[1] = Integer.parseInt(txtTableBon.getText());
					tables[2] = Integer.parseInt(txtTableUse.getText());
					tables[3] = Integer.parseInt(txtTableCritique.getText());
					
					local.genererMateriels(chaises, tables);
					
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
