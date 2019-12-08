/**
 * 
 */
package view;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

import controller.Controller;

/**
 * @author igorv
 *
 */
public class VueGui extends JFrame {

	
	// on peut utiliser des spinners pour plusieurs options
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel core = new JPanel();
	private JPanel next = new JPanel();
	public static String val;
	

	public VueGui() {
		this.setTitle("1Formatik");
		this.setSize(400,200);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(core);
		core.setBackground(Color.orange);
	
		JTextArea textarea = new JTextArea();
		textarea.setPreferredSize(new Dimension (100,30));
		textarea.setEditable(false);
		core.add(textarea);
		
		JTextField text = new JTextField (30);
		text.setPreferredSize (new Dimension (250, 50));
		core.add(text);
		
		
		
		// Création du bouton envoyer
		JButton send = new JButton ("Envoyer");
		this.add(send);
		
		send.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				val = text.getText();
				System.out.println(val);
			}
		});
		
		// Création du bouton quitter
		JButton quit = new JButton("Quitter");
		this.getContentPane().add(quit);
		
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.setVisible(true);
		
		
		
		
	}
	




	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VueGui gui = new VueGui();
		System.out.println(val);
		
	}

}
