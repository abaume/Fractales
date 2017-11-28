/**
 * 
 */
package Application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author baume
 * 
 */
public class Fenetre extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @author baume
	 * @category constructeur
	 */
	public Fenetre (String titre) {
		this.setBounds(10, 0, 961, 880);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
