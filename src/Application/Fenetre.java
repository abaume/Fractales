/**
 * 
 */
package Application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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

	private JPanel pan = new JPanel();
	private JButton bouton = new JButton("Mon bouton");
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @author baume
	 * @category constructeur     
	 */
	public Fenetre (String titre) {
		super();
		this.setBounds(10, 0, 961, 880);
		this.setTitle("Fractales");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		//setContentPane(buildContentPane());
	    this.setVisible(true);
	}
	
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JButton bouton = new JButton("Cliquez ici !");
		bouton.setBounds(961, 0, 30, 30);
		panel.add(bouton);
		
		JButton bouton2 = new JButton("Ou là !");
		panel.add(bouton2);
		bouton2.setBounds(961, 200, 30, 30);
		
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
