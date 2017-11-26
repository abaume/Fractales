/**
 * 
 */
package Application;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author baume
 * 
 */
public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titre;
	JPanel panel;

	/**
	 * @author baume
	 * @category constructeur
	 */
	public Fenetre (String titre) {
		this.titre = titre;

		/* taille de la fenêtre */	
		this.setBounds(300, 100, 700, 500);
		panel = new JPanel();
		add(panel);

		// on lui ajoute le dessin
//		this.setContentPane(new Dessin());
		//		buttonPlus.addActionListener(this);

		/* ferme quand on clique sur la croix */
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		System.out.println("je suis fenetre");
	}
}
