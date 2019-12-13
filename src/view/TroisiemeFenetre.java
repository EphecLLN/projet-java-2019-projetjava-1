package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.*;
import controller.Controller;
import model.Ecole;
import model.Implantation;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TroisiemeFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////

	public JPanel contentPane;
	public JFrame j3;
	private JTextField champNom;
	private JLabel lblNeuf;
	private JTextField aa;
	private JTextField ee;
	private JLabel lblBon;
	private JLabel lblUse;
	private JLabel lblCritique;
	private JTextField cc;
	private JTextField bb;
	private JTextField gg;
	private JTextField ff;
	private JTextField dd;
	private JTextField hh;
	private JLabel lblErreur;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	/**
	 * Create the frame.
	 */
	public TroisiemeFenetre(Ecole model, Controller controller, Implantation implantation) {
		super(model, controller);
		
		j3 = new JFrame();
		j3.setVisible(true);
		j3.setTitle("Ajouter Local");
		j3.setBounds(100, 100, 330, 306);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j3.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 250, 422, -248);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setBounds(22, 24, 42, 16);
		contentPane.add(lblNom);
		
		JLabel lblNombreDeChaises = new JLabel("chaises");
		lblNombreDeChaises.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDeChaises.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreDeChaises.setBounds(115, 86, 64, 16);
		contentPane.add(lblNombreDeChaises);
		
		JLabel lblNombreDeTables = new JLabel("tables");
		lblNombreDeTables.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDeTables.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreDeTables.setBounds(220, 86, 58, 16);
		contentPane.add(lblNombreDeTables);
		
		champNom = new JTextField();
		champNom.setHorizontalAlignment(SwingConstants.CENTER);
		champNom.setBounds(77, 21, 40, 22);
		contentPane.add(champNom);
		champNom.setColumns(10);
		
		gg = new JTextField();
		gg.setColumns(10);
		gg.setBounds(230, 174, 40, 22);
		contentPane.add(gg);
		
		JCheckBox chckbxLocalInformatique = new JCheckBox("");
		chckbxLocalInformatique.setBounds(283, 20, 28, 23);
		contentPane.add(chckbxLocalInformatique);
		
		JLabel lblLocalInformatique = new JLabel("Local informatique :");
		lblLocalInformatique.setBounds(149, 24, 129, 16);
		contentPane.add(lblLocalInformatique);
		
		lblErreur = new JLabel("Saisie du nom incorrecte !");
		lblErreur.setVisible(false);
		lblErreur.setForeground(Color.RED);
		lblErreur.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblErreur.setHorizontalAlignment(SwingConstants.CENTER);
		lblErreur.setBounds(6, 253, 209, 16);
		contentPane.add(lblErreur);
		
		ee = new JTextField();
		ee.setBounds(230, 114, 40, 22);
		contentPane.add(ee);
		ee.setColumns(10);
		
		cc = new JTextField();
		cc.setColumns(10);
		cc.setBounds(128, 174, 40, 22);
		contentPane.add(cc);
		
		ff = new JTextField();
		ff.setColumns(10);
		ff.setBounds(230, 143, 40, 22);
		contentPane.add(ff);
		
		lblNeuf = new JLabel("Neuf");
		lblNeuf.setBounds(22, 117, 35, 16);
		contentPane.add(lblNeuf);
		
		aa = new JTextField();
		aa.setHorizontalAlignment(SwingConstants.CENTER);
		aa.setToolTipText("");
		aa.setBounds(128, 114, 40, 22);
		contentPane.add(aa);
		aa.setColumns(10);
		
		lblBon = new JLabel("Bon");
		lblBon.setBounds(22, 146, 35, 16);
		contentPane.add(lblBon);
		
		lblUse = new JLabel("Use");
		lblUse.setBounds(22, 177, 35, 16);
		contentPane.add(lblUse);
		
		lblCritique = new JLabel("Critique");
		lblCritique.setBounds(22, 206, 58, 16);
		contentPane.add(lblCritique);
		
		bb = new JTextField();
		bb.setColumns(10);
		bb.setBounds(128, 143, 40, 22);
		contentPane.add(bb);
		
		dd = new JTextField();
		dd.setColumns(10);
		dd.setBounds(128, 203, 40, 22);
		contentPane.add(dd);
		
		hh = new JTextField();
		hh.setBounds(230, 203, 40, 22);
		contentPane.add(hh);
		hh.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(champNom.getText().contains("L") && champNom.getText().length() == 3) {
					try {
						int[] chaises = {Integer.parseInt(aa.getText()), Integer.parseInt(bb.getText()), Integer.parseInt(cc.getText()), Integer.parseInt(dd.getText())};
						int[] tables = {Integer.parseInt(ee.getText()), Integer.parseInt(ff.getText()), Integer.parseInt(gg.getText()), Integer.parseInt(hh.getText())};

						controller.genererLocal(champNom.getText(), chckbxLocalInformatique.isSelected(), chaises, tables, implantation);
						lblErreur.setForeground(Color.GREEN);
						lblErreur.setText("Local ajouté");
						lblErreur.setVisible(true);
						
					}catch (Exception er) {
						lblErreur.setText("Les champs tables et chaises doivent être remplis avec des nombres");
						lblErreur.setVisible(true);
					}
				}
				else {
					lblErreur.setText("Le numéro du local doit être du type : LXX");
					lblErreur.setVisible(true);
				}
			}
		});
		
		btnValider.setBounds(227, 250, 97, 25);
		contentPane.add(btnValider);
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
