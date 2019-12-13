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
import java.awt.event.ActionEvent;

public class ActualiserMaterielFenetre extends Vue {
	
////////////////////////////////////////////////*ATTRIBUTS*///////////////////////////////////////////////////////////////////////////////


	public JPanel contentPane;
	public JFrame j9;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


///////////////////////////////////////////////*CONSTRUCTEURS*////////////////////////////////////////////////////////////////////////////

	/**
	 * Create the frame.
	 */
	public ActualiserMaterielFenetre(Ecole model, Controller controller) {
		super(model, controller);
		j9 = new JFrame();
		j9.setTitle("Actualiser Mat\u00E9riel");
		j9.setVisible(true);
		j9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j9.setBounds(100, 100, 318, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		j9.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 300, 232);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(58, 31, 56, 16);
		panel.add(lblId);
		
		JLabel lblNeuf = new JLabel("Neuf");
		lblNeuf.setBounds(58, 60, 56, 16);
		panel.add(lblNeuf);
		
		JLabel lblBon = new JLabel("Bon");
		lblBon.setBounds(58, 89, 56, 16);
		panel.add(lblBon);
		
		JLabel lblUs = new JLabel("Us\u00E9");
		lblUs.setBounds(58, 118, 56, 16);
		panel.add(lblUs);
		
		JLabel lblCritique = new JLabel("Critique");
		lblCritique.setBounds(58, 147, 56, 16);
		panel.add(lblCritique);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValider.setBounds(98, 194, 97, 25);
		panel.add(btnValider);
		
		textField = new JTextField();
		textField.setBounds(98, 28, 143, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 57, 128, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(108, 86, 133, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(113, 115, 128, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(123, 144, 118, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
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
