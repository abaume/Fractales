package Application;

import java.util.Observable;
import java.util.Observer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.math.*;

import javax.swing.*;

public class FractalesVue extends JComponent implements Observer, MouseWheelListener, MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private FractalesControleur controleur;
	private FractalesModèle model;
	private float x1debut;
	private float x2debut;

	private float y1debut;
	private float y2debut;

	public FractalesVue(FractalesControleur controleur, FractalesModèle modele) {
		super();
		this.controleur = controleur;
		this.model = modele;
		this.addMouseWheelListener(this);
		this.addMouseListener(this);
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		float x1 = model.getx1();
		float x2 = model.getx2();
		float alphax = (x2-x1)/961;
		float xp = MouseInfo.getPointerInfo().getLocation().x*alphax+x1;		
		float xdif = Math.abs(x1-x2)/2;

		float y1 = model.gety1();
		float y2 = model.gety2();
		float alphay = (y2-y1)/880;
		float yp = MouseInfo.getPointerInfo().getLocation().y*alphay+y1;		
		float ydif = Math.abs(y1-y2)/2;


		if (e.getWheelRotation()<0) {
			model.setx1(xp-(xdif/2));
			model.setx2(xp+(xdif/2));	

			model.sety1(yp-(ydif/2));
			model.sety2(yp+(ydif/2));

			model.setZoom(model.getZoom()*2);
			model.setIteration_max((int)(model.getIteration_max()*1.3));
		}
		else {
			model.setx1(xp-(xdif*2));
			model.setx2(xp+(xdif*2));	

			model.sety1(yp-(ydif*2));
			model.sety2(yp+(ydif*2));

			model.setZoom(model.getZoom()/2);
			model.setIteration_max((int)(model.getIteration_max()/1.3));
		}
		repaint();
	}

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
		double i;

		// taille de l'image par rapport au zoom
		float image_x = (x2 - x1) * zoom;
		float image_y = (y2 - y1) * zoom;		

		for (int x = 0; x < image_x ; x++) {
			for (int y = 0; y < image_y ; y++) {
				i = controleur.fractale(x, y) /*+ 1 - (Math.log(2) / controleur.fractale(x, y)) / Math.log(2) */;
				if (model.type == typeFractale.NEWTON) {
					// dessiner le point
					g.setColor(Color.BLACK);
					g.fillRect(x, y, 1, 1);
					((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					//					} else {
					g.setColor(Color.getHSBColor(1, 1, (float)i/iteration_max*zoom));
					g.fillRect(x, y, 1, 1);
					((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					} 
				else {
					if ( i == iteration_max) {
						// dessiner le point
						g.setColor(Color.BLACK);
						g.fillRect(x, y, 1, 1);
						((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					}
					else {
						g.setColor(Color.getHSBColor(1, 1, (float)i/iteration_max*zoom));
						g.fillRect(x, y, 1, 1);
						((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					}
									}
				}
			}
		}

		public static void main(String[] args) {

			FractalesModèle modèle = new FractalesModèle((float)0, (float)0, (float)600, (float)600, typeFractale.NEWTON);
			Fenetre fen = new Fenetre("Fractales", modèle);

			FractalesControleur controller = new FractalesControleur(modèle);
			FractalesVue view = new FractalesVue(controller,modèle);

			fen.add(view);

			modèle.addObserver(view);

			view.repaint();
		}

		@Override
		public void update(Observable o, Object arg) {
			// TODO Auto-generated method stub

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			float x1 = model.getx1();
			float x2 = model.getx2();
			float alphax = (x2-x1)/961;
			float xp = MouseInfo.getPointerInfo().getLocation().x*alphax+x1;		
			float xdif = Math.abs(x1-x2)/2;

			float y1 = model.gety1();
			float y2 = model.gety2();
			float alphay = (y2-y1)/880;
			float yp = MouseInfo.getPointerInfo().getLocation().y*alphay+y1;		
			float ydif = Math.abs(y1-y2)/2;

			x1debut =(xp-(xdif));
			x2debut =(xp+(xdif));	

			y1debut =(yp-(ydif));
			y2debut =(yp+(ydif));
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			float x1 = model.getx1();
			float x2 = model.getx2();
			float alphax = (x2-x1)/961;
			float xp = MouseInfo.getPointerInfo().getLocation().x*alphax+x1;		
			float xdif = Math.abs(x1-x2)/2;

			float y1 = model.gety1();
			float y2 = model.gety2();
			float alphay = (y2-y1)/880;
			float yp = MouseInfo.getPointerInfo().getLocation().y*alphay+y1;		
			float ydif = Math.abs(y1-y2)/2;

			float x1fin =(xp-(xdif));
			float x2fin =(xp+(xdif));	

			float y1fin =(yp-(ydif));
			float y2fin =(yp+(ydif));

			model.setx1(model.getx1()+x1debut-x1fin);
			model.setx2(model.getx2()+x2debut-x2fin);	

			model.sety1(model.gety1()+y1debut-y1fin);
			model.sety2(model.gety2()+y2debut-y2fin);
			repaint();
		}
	}
