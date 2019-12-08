/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * @author igorv
 *
 */
public class VueGui extends JFrame {
	
	// on peut utiliser des spinners pour plusieurs option 
	
	private JPanel core = new JPanel();
	private JPanel next = new JPanel();
	private JButton but = new JButton("getvalue");
	private static JFormattedTextField test = new JFormattedTextField("test");
	public static String val;

	public VueGui() {
		this.setTitle("1Formatik");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(core);
		this.setLayout(new BorderLayout()); 
		this.getContentPane().add(but, BorderLayout.WEST);
		this.getContentPane().add(test);
		but.addActionListener(text(val));
		core.setBackground(Color.green);
		this.setVisible(true);
		
		
		
		
		
	}
	
	public void text(String val2) {
		val = test.getText();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VueGui gui = new VueGui();
		System.out.println(val);
		
	}

}
