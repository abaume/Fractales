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
	private String titre;
	JPanel buttonsPanel;
	JButton bouton = new JButton("banane");

	/**
	 * @author baume
	 * @category constructeur
	 */
	public Fenetre (String titre) {
		this.titre = titre;
		this.setBounds(500, 200, 400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		buttonsPanel = new JPanel();
//		buttonsPanel.setBackground(Color.black);
		buttonsPanel.add(bouton);
		this.setContentPane(buttonsPanel);
		
		bouton.addActionListener(this);
		setLayout(new BorderLayout(10,10));
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
