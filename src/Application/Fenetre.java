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
	public JMenuItem juliaMenu = new JMenuItem("Julia");
	public JMenuItem zoomer = new JMenuItem("Zommer");
	public JMenuItem dezoomer = new JMenuItem("Dézoomer");
	
	private FractalesModèle m;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @author baume
	 * @category constructeur     
	 */
	public Fenetre (String titre) {
		super();
		this.setBounds(10, 0, 961, 880);
		this.setTitle("Fractales - Baumé,Lapicardise - S3B");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.setVisible(true);
		
		

		//On initialise nos menus      
		this.fractale.add(mandelbrotMenu);
		this.fractale.add(juliaMenu);
		this.zoom.add(zoomer);
		this.zoom.add(dezoomer);

		mandelbrotMenu.addActionListener(this);
		juliaMenu.addActionListener(this);


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
		if (arg0.getSource() == mandelbrotMenu) {
			m.type = typeFractale.MANDELBROT;
			System.out.print("patate");
		}
		else if (arg0.getSource() == juliaMenu) {
			m.type = typeFractale.JULIA;
			System.out.println("banane");
		}
	}
}
