package Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author baume
 * 
 */
public class Fenetre extends JFrame implements ActionListener{

	private JMenuBar menuBar = new JMenuBar();
	public JMenu fractale = new JMenu("Fractale");
	public JMenu zoom = new JMenu("Zoom");
	public JMenuItem mandelbrotMenu = new JMenuItem("MandelBrot");
	public JMenuItem lisaMenu = new JMenuItem("Lisa");
	public JMenuItem zoomer = new JMenuItem("Zommer");
	public JMenuItem dezoomer = new JMenuItem("Dézoomer");
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
	    this.setVisible(true);
	    
	  //On initialise nos menus      
	  		this.fractale.add(mandelbrotMenu);
	  		this.fractale.add(lisaMenu);
	  		this.zoom.add(zoomer);
	  		this.zoom.add(dezoomer);

	  		//L'ordre d'ajout va d�terminer l'ordre d'apparition dans le menu de gauche � droite
	  		//Le premier ajout� sera tout � gauche de la barre de menu et inversement pour le dernier
	  		this.menuBar.add(fractale);
	  		this.menuBar.add(zoom);
	  		this.setJMenuBar(menuBar);
	}

	public void cliquerZoom (){
		           
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
