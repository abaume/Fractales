package Application;
import java.awt.BorderLayout;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * @author baume
 * 
 */
public class Fenetre extends JFrame implements ActionListener{

	private JMenuBar menuBar = new JMenuBar();
	public JMenu fractale = new JMenu("Fractale");
	public JMenu zoom = new JMenu("Zoom");

	public JMenu iterations = new JMenu("Itérations");
	public JMenuItem mandelbrotMenu = new JMenuItem("MandelBrot");
	public JMenuItem juliaMenu = new JMenuItem("Julia");
	public JMenuItem zoomer = new JMenuItem("Zommer");
	public JMenuItem dezoomer = new JMenuItem("Dézoomer");
	public JMenuItem augmenterItérations = new JMenuItem("Itérations *2");
	public JMenuItem diminuerItérations = new JMenuItem("Itérations /2");
	
	private FractalesModèle m;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @author baume
	 * @category constructeur     
	 */
	public Fenetre (String titre, FractalesModèle modele) {
		super();
		this.setBounds(10, 0, 961, 880);
		this.setTitle("Fractales - Baumé,Lapicardise - S3B");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.setVisible(true);
		
		this.m = modele;

		//On initialise nos menus      
		this.fractale.add(mandelbrotMenu);
		this.fractale.add(juliaMenu);
		this.zoom.add(zoomer);
		this.zoom.add(dezoomer);
		this.iterations.add(augmenterItérations);
		this.iterations.add(diminuerItérations);

		mandelbrotMenu.addActionListener(this);
		juliaMenu.addActionListener(this);
		zoomer.addActionListener(this);
		dezoomer.addActionListener(this);
		augmenterItérations.addActionListener(this);
		diminuerItérations.addActionListener(this);
		augmenterItérations.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UP, ActionEvent.CTRL_MASK));
		diminuerItérations.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, ActionEvent.CTRL_MASK));

		//L'ordre d'ajout va d�terminer l'ordre d'apparition dans le menu de gauche � droite
		//Le premier ajout� sera tout � gauche de la barre de menu et inversement pour le dernier
		this.menuBar.add(fractale);
		this.menuBar.add(zoom);
		this.menuBar.add(iterations);
		this.setJMenuBar(menuBar);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		float x1 = m.getx1();
		float x2 = m.getx2();
		float alphax = (x2-x1)/961;
		float xp = 480*alphax+x1;		
		float xdif = Math.abs(x1-x2)/2;
		
		float y1 = m.gety1();
		float y2 = m.gety2();
		float alphay = (y2-y1)/880;
		float yp = 440*alphay+y1;		
		float ydif = Math.abs(y1-y2)/2;
		
		if (arg0.getSource() == mandelbrotMenu) {
			m.type = typeFractale.MANDELBROT;
		}
		else if (arg0.getSource() == juliaMenu) {
			m.type = typeFractale.JULIA;
		}		
		else if (arg0.getSource() == zoomer) {			
			m.setx1(xp-(xdif/2)+1);
			m.setx2(xp+(xdif/2)+1);	
			
			m.sety1(yp-(ydif/2)+1);
			m.sety2(yp+(ydif/2)+1);
			
			m.setZoom(m.getZoom()*2+1);
			m.setIteration_max((int)(m.getIteration_max()*1.3));
		}
		else if (arg0.getSource() == dezoomer) {			
			m.setx1(xp-(xdif*2)+1);
			m.setx2(xp+(xdif*2)+1);	
			
			m.sety1(yp-(ydif*2)+1);
			m.sety2(yp+(ydif*2)+1);
			
			m.setZoom(m.getZoom()/2+1);
			m.setIteration_max((int)(m.getIteration_max()/1.3));
		}
		else if (arg0.getSource() == augmenterItérations) {
			m.setIteration_max(m.getIteration_max()*2+1);
		}
		else if (arg0.getSource() == diminuerItérations) {
			m.setIteration_max(m.getIteration_max()/2+1);
		}
		this.repaint();
	}
	
}
