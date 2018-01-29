package Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * @author baume
 * @author Romain
 *
 */
public class Fenetre extends JFrame implements ActionListener{

	private JMenuBar menuBar = new JMenuBar();
	public JMenu fractale = new JMenu("Fractale");
	public JMenu zoom = new JMenu("Zoom");
	public JMenu iterations = new JMenu("Itérations");
	public JMenuItem mandelbrotMenu = new JMenuItem("MandelBrot");
	public JMenuItem juliaMenu = new JMenuItem("Julia");
	public JMenuItem newtonMenu = new JMenuItem("Newton");
	public JMenuItem zoomer = new JMenuItem("Zommer");
	public JMenuItem dezoomer = new JMenuItem("Dézoomer");
	public JMenuItem augmenterItérations = new JMenuItem("Itérations *2");
	public JMenuItem diminuerItérations = new JMenuItem("Itérations /2");
	
	private FractalesModèle m;
	private FractalesVue v;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @author baume
	 * @author Romain
	 * @param modèle2 
	 * @category constructeur     
	 */
	public Fenetre (String titre, FractalesVue vue, FractalesModèle modèle) {
		super();
		this.setBounds(10, 0, 961, 880);
		this.setTitle("Fractales - Baumé,Lapicardise - S3B");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.setVisible(true);
		
		this.v = vue;
		this.m = modèle;		

		//Initialisation des menus      
		this.fractale.add(mandelbrotMenu);
		this.fractale.add(juliaMenu);
		this.fractale.add(newtonMenu);
		this.zoom.add(zoomer);
		this.zoom.add(dezoomer);
		this.iterations.add(augmenterItérations);
		this.iterations.add(diminuerItérations);		
		this.menuBar.add(fractale);
		this.menuBar.add(zoom);
		this.menuBar.add(iterations);
		this.setJMenuBar(menuBar);

		mandelbrotMenu.addActionListener(this);
		juliaMenu.addActionListener(this);
		newtonMenu.addActionListener(this);
		zoomer.addActionListener(this);
		dezoomer.addActionListener(this);
		augmenterItérations.addActionListener(this);
		diminuerItérations.addActionListener(this);
		augmenterItérations.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UP, ActionEvent.CTRL_MASK));
		diminuerItérations.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, ActionEvent.CTRL_MASK));
	}

	/**
	 * @author Romain
	 * @author baume 
	 * 
	 */
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
			m.setZoom(350);
			m.setIteration_max(75);
			m.setx1((float)-2.1);
			m.setx2((float)0.6);				
			m.sety1((float)-1.2);
			m.sety2((float)1.2);			
		}
		else if (arg0.getSource() == juliaMenu) {
			m.type = typeFractale.JULIA;
			m.setZoom(350);
			m.setIteration_max(75);
			m.setx1((float)-1.4);
			m.setx2((float)1.6);				
			m.sety1((float)-1.2);
			m.sety2((float)2.2);
		}	
		else if (arg0.getSource() == newtonMenu) {
			m.type = typeFractale.NEWTON;
			m.setZoom(350);
			m.setIteration_max(75);
			m.setx1((float)-1.4);
			m.setx2((float)1.6);				
			m.sety1((float)-1.2);
			m.sety2((float)2.2);
		}	
		else if (arg0.getSource() == zoomer) {			
			m.setx1(xp-(xdif/2));
			m.setx2(xp+(xdif/2));			
			m.sety1(yp-(ydif/2));
			m.sety2(yp+(ydif/2));
			
			m.setZoom(m.getZoom()*2+1);
			m.setIteration_max((int)(m.getIteration_max()*1.3));
		}
		else if (arg0.getSource() == dezoomer) {			
			m.setx1(xp-(xdif*2));
			m.setx2(xp+(xdif*2));				
			m.sety1(yp-(ydif*2));
			m.sety2(yp+(ydif*2));
			
			m.setZoom(m.getZoom()/2+1);
			m.setIteration_max((int)(m.getIteration_max()/1.3));
		}
		else if (arg0.getSource() == augmenterItérations) {
			m.setIteration_max(m.getIteration_max()*2+1);
		}
		else if (arg0.getSource() == diminuerItérations) {
			m.setIteration_max(m.getIteration_max()/2+1);
		}
		m.sety(0);
	}
	
}
