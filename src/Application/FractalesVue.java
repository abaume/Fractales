package Application;

import java.util.Observable;
import java.util.Observer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class FractalesVue extends JComponent implements Observer, MouseWheelListener, MouseListener, ActionListener {

	// variables de la zone � dessiner
	private static final long serialVersionUID = 1L;
	private FractalesControleur controleur;
	private FractalesMod�le model;
	private float x1debut;
	private float x2debut;
	private float y1debut;
	private float y2debut;

	Image img;
	BufferedImage bufferedImage = new BufferedImage(961,880,BufferedImage.TYPE_INT_RGB);
	Graphics g = bufferedImage.getGraphics();

	/**
	 * @author Romain
	 * @author baume
	 * @param controleur
	 * @param modele
	 */
	public FractalesVue(FractalesControleur controleur, FractalesMod�le modele) {
		super();
		this.controleur = controleur;
		this.model = modele;
		this.addMouseWheelListener(this);
		this.addMouseListener(this);
	}

	/**
	 * Affiche l'image � partir du buffer d'image
	 * @author Romain
	 */
	public void paint(Graphics g) {
		img = createImage();
		g.drawImage(img, 0, 0,this);
	}

	/*
	 * Affiche l'image � partir du buffer d'image
	 * @author baume
	 * @author Romain
	 */
	public Image createImage() {
		// d�finition de la zone � dessiner 
		float x1 = model.getx1();
		float x2 = model.getx2();
		float y1 = model.gety1();
		float y2 = model.gety2();
		float y = model.gety();
		float zoom = model.getZoom();
		int iteration_max = model.getIteration_max();
		float i;

		// taille de l'image par rapport au zoom
		float image_x = (x2 - x1) * zoom;
		float image_y = (y2 - y1) * zoom;		 

		for (int x = 0; x < image_x ; x++) {
			i = controleur.fractale(x, (int)y);
			if (model.type == typeFractale.NEWTON) {
				// dessiner le point
				g.setColor(Color.BLACK);
				g.drawLine(x, (int)y, x+1, (int)y+1);
				((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.setColor(Color.getHSBColor(1, 255, (float)i*zoom/iteration_max));
				g.drawLine(x, (int)y, x+1, (int)y+1);				
			} 
			else {
				if ( i == iteration_max) {
					// dessiner le point
					g.setColor(Color.BLACK);
					g.drawLine(x, (int)y, x+1, (int)y+1);
					((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				}
				else {
					g.setColor(Color.getHSBColor(1, 255, (float)i*zoom/iteration_max));
					g.drawLine(x, (int)y, x+1, (int)y+1);
					((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				}
			}
		}

		if (model.gety() < image_y)
		{		
			model.sety(model.gety()+1);
			repaint();
		}
		return bufferedImage;
	}

	/**
	 * @author Romain
	 * @author baume
	 * @param args
	 */
	public static void main(String[] args) {
		FractalesMod�le mod�le = new FractalesMod�le((float)-2.1, (float)0.6, (float)-1.2, (float)1.2, typeFractale.MANDELBROT);
		FractalesControleur controller = new FractalesControleur(mod�le);
		FractalesVue view = new FractalesVue(controller,mod�le);		
		Fenetre fen = new Fenetre("Fractales", view, mod�le);

		fen.add(view);

		mod�le.addObserver(view);

		view.repaint();
		
		fen.setSize(960,880);
	}
	
	/**
	 * zoom et d�zoom en fonction du roulement de la souris
	 * @author Romain
	 * @author baume
	 */
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
		model.sety(0);
		createImage();
	}

	/**
	 * @author Romain
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * @author Romain
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage image = model.getImage();
		int w = Math.min(image.getWidth(), getWidth()),
				h = Math.min(image.getHeight(), getHeight());
		g.drawImage(image, 0, 0, w, h, 0, 0, w, h, null);
	}

	/**
	 * @author Romain
	 */
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	/**
	 * @author Romain
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * @author Romain
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * @author Romain
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Calcule les coordonn�s lors d'un appuie sur la souris
	 * @author Romain
	 */
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
	
	/**
	 * D�place la fractale au relachement de la souris
	 * @author Romain
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
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
		model.sety(model.gety1());
		createImage();
	}
}
