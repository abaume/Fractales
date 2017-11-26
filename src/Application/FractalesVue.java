package Application;

import java.util.Observable;
import java.util.Observer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.*;

public class FractalesVue extends JComponent implements Observer, ActionListener {

	private static final long serialVersionUID = 1L;
	private FractalesControleur controleur;
	private FractalesModèle model;

	private Ellipse2D circle = new Ellipse2D.Double(102.57, 26.8, 42.8, 42.8);

	@Override
	public void update(Observable o, Object arg) {
		//		
		//		displayDataS.setText(Integer.toString(this.modele.getSeconde()));

	}

	public FractalesVue(FractalesControleur controleur, FractalesModèle modele) {
		super();
		this.controleur = controleur;
		this.model = modele;		
	}

	public void actionPerformed(ActionEvent e) {}
	//		if (e.getSource() == buttonPlus) {
	//			
	//			}

/*
 * @author baume
 * @
 */
	public void paint(Graphics g) {
		// définition de la zone à dessiner sachant que l'ensemble
		// de Mandelbrot est toujours compris entre les coordonnées suivantes
		model.setx1((float)-2.1); 
		float x1 = model.getx1();
		model.setx2((float)0.6);
		float x2 = model.getx2();
		model.sety1((float)-1.2);
		float y1 = model.gety1();
		model.sety2((float)1.2);
		float y2 = model.gety2();
//		model.setx1(0); 
//		float x1 = model.getx1();
//		model.setx2(500);
//		float x2 = model.getx2();
//		model.sety1(0);
//		float y1 = model.gety1();
//		model.sety2(500);
//		float y2 = model.gety2();
//		
		System.out.println("je suis paintComponent");

//		// on utilise le paint de la classe JFrame
		super.paint(g);

		float zoom = model.getZoom();
		int iteration_max = model.getItMax();
		float i;

		// taille de l'image par rapport au zoom
		float image_x = (x2 - x1) * zoom;
		float image_y = (y2 - y1) * zoom;

		System.out.println("je suis presque la");

		for (int x = 0; x < image_x ; x++) {
			for (int y = 0; y < image_y ; y++) {
				i = controleur.Mandelbrot(x, y, x1, y1, zoom, iteration_max);
				if ( i == iteration_max) {
					System.out.println("je suis la");
					// dessiner le point
					g.fillOval(x, y, 1, 1);
					this.repaint();
				}
			}
		}
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("je suis exécutée");
		Graphics2D g2d = (Graphics2D) g.create();
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.darkGray);
        g2d.fill(circle);
        g2d.dispose();
        
	}
	

	public static void main(String[] args) {

		//new Fenetre("Fractales");

		FractalesModèle model = new FractalesModèle();
		FractalesControleur controller = new FractalesControleur(model);
		FractalesVue view = new FractalesVue(controller, model);
		//Dessin g = new Dessin();		
		
		JFrame f = new JFrame();
        f.add(view);
        f.setSize(400, 300);
        
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
		
		model.addObserver(view);
		//view.afficherMandelBrot(g);
	}
}
