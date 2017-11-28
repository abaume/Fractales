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

import javax.swing.*;

public class FractalesVue extends JComponent implements Observer, ActionListener {

	private static final long serialVersionUID = 1L;
	private FractalesControleur controleur;
	private FractalesModèle model;
	JPanel panel;

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
		// définition de la zone à dessiner 
		float x1 = model.getx1();
		float x2 = model.getx2();
		float y1 = model.gety1();
		float y2 = model.gety2();

		float zoom = model.getZoom();
		int iteration_max = model.getItMax();
		float i;

		// taille de l'image par rapport au zoom
		float image_x = (x2 - x1) * zoom;
		float image_y = (y2 - y1) * zoom;

		for (int x = 0; x < image_x ; x++) {
			for (int y = 0; y < image_y ; y++) {
				if (model.type.equals(typeFractale.MANDELBROT))
					i = model.Mandelbrot(x, y, x1, y1, zoom, iteration_max);
				else 
					i = 0;
				if ( i == iteration_max) {
					// dessiner le point
					g.setColor(Color.BLACK);
					g.fillRect(x, y, 1, 1);
					((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				}
				else {
					g.setColor(Color.getHSBColor(0, 100, i*255/iteration_max)) ;
					g.fillRect(x, y, 1, 1);
					((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				}
			}
		}
	}

	public static void main(String[] args) {

		Fenetre fen = new Fenetre("Fractales");
		FractalesModèle MandelbrotModel = new FractalesModèle((float)-2.1, (float)0.6, (float)-1.2, (float)1.2, typeFractale.MANDELBROT);
		FractalesControleur controller = new FractalesControleur(MandelbrotModel);
		FractalesVue view = new FractalesVue(controller, MandelbrotModel);
		
		fen.add(view);

		MandelbrotModel.addObserver(view);
	}
}
