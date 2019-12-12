package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
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
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;


public class SecondeFenetre extends Vue{
	
/////////////////////////////////////////*ATTRIBUTS*//////////////////////////////////////////////////////////////////////////////////////

	public JPanel contentPane;
	public JFrame j2;
	private JTextField choix_txt;
	private JComboBox<Object> choix_imp;
	

////////////////////////////////////////*CONSTRUCTEUR*////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Cr�ation de la fen�tre
	 */
	public SecondeFenetre(Ecole model, Controller controller) {
		super(model, controller);
		
		j2 = new JFrame();
		j2.setVisible(true);
		j2.setTitle("Implantation");
		j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j2.setBounds(100, 100, 450, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j2.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Panel panel = new Panel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		// r�cup�ration des noms des implantations
		String[] imp = {null};
		for(Implantation uneImp : controller.model.implantations)	{
			imp[0] = uneImp.getNom();
		}
		
		// cr�ation du champ texte de demande de choix d'implantation
		choix_txt = new JTextField();
		panel.add(choix_txt);
		choix_txt.setColumns(10);
		choix_txt.setBorder(null);
		choix_txt.setFont(new Font("Poor Richard", Font.BOLD, 22));
		choix_txt.setText("Veuillez choisir une implantation :");
		choix_txt.setBounds(29, 25, 365, 22);
		choix_txt.setOpaque(false);
		
		// cr�ation de la box qui permet de choisir son implantation
		choix_imp = new JComboBox<Object>(imp);
		choix_imp.setToolTipText("Veuillez choisir une implantation :");
		choix_imp.setBounds(29, 60, 365, 37);
		panel.add(choix_imp);
		
		// cr�ation du bouton de validation
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(297, 124, 97, 25);
		panel.add(btnValider);
		btnValider.setBorder(null);
		btnValider.setBackground(new Color(199, 21, 133));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Choix valid� : " + choix_imp.getSelectedItem());
				j2.setVisible(false);
			}
		});
		
		
		
		
		
	
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
