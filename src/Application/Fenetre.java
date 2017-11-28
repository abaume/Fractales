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
<<<<<<< HEAD
		this.titre = titre;
		this.setBounds(300, 50, 700, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		buttonsPanel = new JPanel();
//		buttonsPanel.setBackground(Color.black);
		buttonsPanel.add(bouton);
		this.setContentPane(buttonsPanel);
		
		bouton.addActionListener(this);
		setLayout(new BorderLayout(10,10));
		
=======
		this.setBounds(10, 0, 961, 880);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
>>>>>>> 21b14d18567475e9e6caa8557b8323e6c3dfc52d
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
