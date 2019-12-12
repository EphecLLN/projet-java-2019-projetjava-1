package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.*;

public class CinquiemeFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////


	public JPanel contentPane;
	public JFrame j5;

///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////



	/**
	 * Create the frame.
	 */
	public CinquiemeFenetre(Ecole model, Controller controller) {
		super(model, controller);
		
		j5 = new JFrame();
		j5.setVisible(true);
		j5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j5.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		j5.setContentPane(contentPane);
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
