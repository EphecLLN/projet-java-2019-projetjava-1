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

public class TroisiemeFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////

	public JPanel contentPane;
	public JFrame j3;
	private JTextField champNom;
	private JLabel lblNeuf;
	private JLabel lblNeuf2;
	private JTextField textField_3;
	private JTextField aa;
	private JTextField ee;
	private JLabel lblBon;
	private JLabel lblBon2;
	private JLabel lblUse;
	private JLabel lblUse2;
	private JLabel lblCritique;
	private JLabel lblCritique2;
	private JTextField textField_4;
	private JTextField cc;
	private JTextField bb;
	private JTextField gg;
	private JTextField textField_6;
	private JTextField ff;
	private JTextField dd;
	private JTextField hh;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	/**
	 * Create the frame.
	 */
	public TroisiemeFenetre(Ecole model, Controller controller) {
		super(model, controller);
		
		j3 = new JFrame();
		j3.setVisible(true);
		j3.setTitle("Ajouter Local");
		j3.setBounds(100, 100, 276, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j3.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 250, 422, -248);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setBounds(22, 35, 42, 16);
		contentPane.add(lblNom);
		
		JLabel lblNombreDeChaises = new JLabel("Nombre de chaises : ");
		lblNombreDeChaises.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreDeChaises.setBounds(22, 78, 145, 16);
		contentPane.add(lblNombreDeChaises);
		
		JLabel lblNombreDeTables = new JLabel("Nombre de tables : ");
		lblNombreDeTables.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreDeTables.setBounds(23, 249, 144, 16);
		contentPane.add(lblNombreDeTables);
		
		champNom = new JTextField();
		champNom.setBounds(76, 32, 145, 22);
		contentPane.add(champNom);
		champNom.setColumns(10);
		
		gg = new JTextField();
		gg.setColumns(10);
		gg.setBounds(111, 339, 40, 22);
		contentPane.add(gg);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(149, 431, 97, 25);
		contentPane.add(btnValider);
		
		lblNeuf2 = new JLabel("Neuf");
		lblNeuf2.setBounds(64, 287, 35, 16);
		contentPane.add(lblNeuf2);
		
		ee = new JTextField();
		ee.setBounds(111, 284, 40, 22);
		contentPane.add(ee);
		ee.setColumns(10);
		
		lblBon2 = new JLabel("Bon");
		lblBon2.setBounds(64, 313, 35, 16);
		contentPane.add(lblBon2);
		
		lblUse2 = new JLabel("Use");
		lblUse2.setBounds(64, 342, 35, 16);
		contentPane.add(lblUse2);
		
		lblCritique2 = new JLabel("Critique");
		lblCritique2.setBounds(41, 371, 58, 16);
		contentPane.add(lblCritique2);
		
		cc = new JTextField();
		cc.setColumns(10);
		cc.setBounds(111, 174, 40, 22);
		contentPane.add(cc);
		
		ff = new JTextField();
		ff.setColumns(10);
		ff.setBounds(111, 310, 40, 22);
		contentPane.add(ff);
		
		lblNeuf = new JLabel("Neuf");
		lblNeuf.setBounds(64, 117, 35, 16);
		contentPane.add(lblNeuf);
		
		aa = new JTextField();
		aa.setBounds(111, 114, 40, 22);
		contentPane.add(aa);
		aa.setColumns(10);
		
		lblBon = new JLabel("Bon");
		lblBon.setBounds(64, 146, 35, 16);
		contentPane.add(lblBon);
		
		lblUse = new JLabel("Use");
		lblUse.setBounds(64, 177, 35, 16);
		contentPane.add(lblUse);
		
		lblCritique = new JLabel("Critique");
		lblCritique.setBounds(41, 206, 58, 16);
		contentPane.add(lblCritique);
		
		bb = new JTextField();
		bb.setColumns(10);
		bb.setBounds(111, 143, 40, 22);
		contentPane.add(bb);
		
		dd = new JTextField();
		dd.setColumns(10);
		dd.setBounds(111, 203, 40, 22);
		contentPane.add(dd);
		
		hh = new JTextField();
		hh.setBounds(111, 368, 40, 22);
		contentPane.add(hh);
		hh.setColumns(10);
		
		
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
