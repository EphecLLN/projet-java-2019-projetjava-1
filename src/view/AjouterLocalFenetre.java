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

public class AjouterLocalFenetre extends Vue {
	
	//TODO renommer les variables
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////

	public JPanel contentPane;
	public JFrame j3;
	private JTextField champNom;
	private JLabel lblNeuf;
	private JTextField textField_3;
	private JTextField aa;
	private JTextField ee;
	private JLabel lblBon;
	private JLabel lblUse;
	private JLabel lblCritique;
	private JTextField textField_4;
	private JTextField cc;
	private JTextField bb;
	private JTextField gg;
	private JTextField textField_6;
	private JTextField ff;
	private JTextField dd;
	private JTextField hh;
	private JLabel lblNewLabel;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	/**
	 * Création de la fenêtre
	 */
	public AjouterLocalFenetre(Ecole model, Controller controller) {
		super(model, controller);
		
		j3 = new JFrame();
		j3.setVisible(true);
		j3.setTitle("Ajouter Local");
		j3.setBounds(100, 100, 353, 335);
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
		lblNom.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNom.setBounds(22, 24, 42, 16);
		contentPane.add(lblNom);
		
		JLabel lblNombreDeChaises = new JLabel("chaises");
		lblNombreDeChaises.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDeChaises.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombreDeChaises.setBounds(115, 86, 64, 16);
		contentPane.add(lblNombreDeChaises);
		
		JLabel lblNombreDeTables = new JLabel("tables");
		lblNombreDeTables.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDeTables.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombreDeTables.setBounds(220, 86, 58, 16);
		contentPane.add(lblNombreDeTables);
		
		champNom = new JTextField();
		champNom.setFont(new Font("Dialog", Font.PLAIN, 12));
		champNom.setHorizontalAlignment(SwingConstants.CENTER);
		champNom.setBounds(77, 21, 40, 22);
		contentPane.add(champNom);
		champNom.setColumns(10);
		
		gg = new JTextField();
		gg.setFont(new Font("Dialog", Font.PLAIN, 12));
		gg.setColumns(10);
		gg.setBounds(230, 174, 40, 22);
		contentPane.add(gg);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnValider.setBounds(227, 250, 97, 25);
		contentPane.add(btnValider);
		
		ee = new JTextField();
		ee.setFont(new Font("Dialog", Font.PLAIN, 12));
		ee.setBounds(230, 114, 40, 22);
		contentPane.add(ee);
		ee.setColumns(10);
		
		cc = new JTextField();
		cc.setFont(new Font("Dialog", Font.PLAIN, 12));
		cc.setColumns(10);
		cc.setBounds(128, 174, 40, 22);
		contentPane.add(cc);
		
		ff = new JTextField();
		ff.setFont(new Font("Dialog", Font.PLAIN, 12));
		ff.setColumns(10);
		ff.setBounds(230, 143, 40, 22);
		contentPane.add(ff);
		
		lblNeuf = new JLabel("Neuf");
		lblNeuf.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNeuf.setBounds(22, 117, 35, 16);
		contentPane.add(lblNeuf);
		
		aa = new JTextField();
		aa.setFont(new Font("Dialog", Font.PLAIN, 12));
		aa.setHorizontalAlignment(SwingConstants.CENTER);
		aa.setToolTipText("");
		aa.setBounds(128, 114, 40, 22);
		contentPane.add(aa);
		aa.setColumns(10);
		
		lblBon = new JLabel("Bon");
		lblBon.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblBon.setBounds(22, 146, 35, 16);
		contentPane.add(lblBon);
		
		lblUse = new JLabel("Use");
		lblUse.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblUse.setBounds(22, 177, 35, 16);
		contentPane.add(lblUse);
		
		lblCritique = new JLabel("Critique");
		lblCritique.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCritique.setBounds(22, 206, 58, 16);
		contentPane.add(lblCritique);
		
		bb = new JTextField();
		bb.setFont(new Font("Dialog", Font.PLAIN, 12));
		bb.setColumns(10);
		bb.setBounds(128, 143, 40, 22);
		contentPane.add(bb);
		
		dd = new JTextField();
		dd.setFont(new Font("Dialog", Font.PLAIN, 12));
		dd.setColumns(10);
		dd.setBounds(128, 203, 40, 22);
		contentPane.add(dd);
		
		hh = new JTextField();
		hh.setFont(new Font("Dialog", Font.PLAIN, 12));
		hh.setBounds(230, 203, 40, 22);
		contentPane.add(hh);
		hh.setColumns(10);
		
		JCheckBox chckbxLocalInformatique = new JCheckBox("");
		chckbxLocalInformatique.setBounds(283, 20, 28, 23);
		contentPane.add(chckbxLocalInformatique);
		
		JLabel lblLocalInformatique = new JLabel("Local informatique :");
		lblLocalInformatique.setFont(new Font("Dialog", Font.BOLD, 12));
		lblLocalInformatique.setBounds(149, 24, 129, 16);
		contentPane.add(lblLocalInformatique);
		
		lblNewLabel = new JLabel("Saisie du nom incorrecte !");
		lblNewLabel.setVisible(false);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 253, 209, 16);
		contentPane.add(lblNewLabel);
		
		
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
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
