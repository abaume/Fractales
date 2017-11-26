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

		float zoom = model.getZoom();
		int iteration_max = model.getItMax();
		float i;

		// taille de l'image par rapport au zoom
		float image_x = (x2 - x1) * zoom;
		float image_y = (y2 - y1) * zoom;

		for (int x = 0; x < image_x ; x++) {
			for (int y = 0; y < image_y ; y++) {
				i = model.Mandelbrot(x, y, x1, y1, zoom, iteration_max);
				if ( i == iteration_max) {
					// dessiner le point
					g.fillRect(x, y, 1, 1);
					((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				}
			}
		}
	}

	public static void main(String[] args) {

		Fenetre fen = new Fenetre("Fractales");

		FractalesModèle model = new FractalesModèle();
		FractalesControleur controller = new FractalesControleur(model);
		FractalesVue view = new FractalesVue(controller, model);
		
		fen.add(view);

		model.addObserver(view);
	}
}
