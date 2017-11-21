package Application;

import java.util.Observable;
import java.util.Observer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class FractalesVue extends JFrame implements Observer, ActionListener {

	private static final long serialVersionUID = 1L;
	private FractalesControleur controleur;
	private FractalesModèle model;


	@Override
	public void update(Observable o, Object arg) {
		//		
		//		displayDataS.setText(Integer.toString(this.modele.getSeconde()));

	}

	public FractalesVue(FractalesControleur controleur, FractalesModèle modele, String titre) {
		super(titre);
		this.controleur = controleur;
		this.model = modele;

		//		displayPoints2 = new JLabel(":");


	}

	public void actionPerformed(ActionEvent e) {}
	//		if (e.getSource() == buttonPlus) {
	//			
	//			}


	public void paintComponent(Graphics g) {
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

//		// on utilise le paint de la classe JFrame
//		super.paint(g);

		float zoom = model.getZoom();
		int iteration_max = model.getItMax();
		float i;

		BufferedImage I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

		// taille de l'image par rapport au zoom
		float image_x = (x2 - x1) * zoom;
		float image_y = (y2 - y1) * zoom;

		for (int x = 0; x < image_x; x++) {
			for (int y = 0; y < image_y; y++) {

				i = controleur.Mandelbrot(x, y, x1, y1, zoom, iteration_max);
				if ( i == iteration_max) {
					// dessiner le point
					I.setRGB(x, y, (int)i);
				}
			}
		}
		g.drawImage(I, 0, 0, this);
	}

	

	public static void main(String[] args) {

		Fenetre fen = new Fenetre("Fractales");

		FractalesModèle model = new FractalesModèle();
		FractalesControleur controller = new FractalesControleur(model);
		FractalesVue view = new FractalesVue(controller, model, "Fractales");
		
//
//		model.addObserver(view);
//		view.afficherMandelBrot(null);

		Dessin d = new Dessin();
	}
}
