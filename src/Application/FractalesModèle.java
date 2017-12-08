package Application;

import java.awt.image.BufferedImage;
import java.util.Observable;

public class FractalesModèle extends Observable{

	// variables de la zone à dessiner
	private float x1; 
	private float x2;
	private float y1;
	private float y2;
	public typeFractale type;
	private int iteration_max = 400;
	private float zoom = 350; // distance 1 sur plan = 100px sur image
	private float y = 0;	
	private BufferedImage image;
	
	/**
	 * @author baume
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 * @param t
	 */
	public FractalesModèle(float x1, float x2, float y1, float y2, typeFractale t) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.type = t;		
	}

	/**
	 * Fractale de Mandelbrot
	 * @author baume
	 * @param x
	 * @param y
	 * @param x1
	 * @param y1
	 * @param zoom
	 * @param iteration_max
	 * @return l'itération en fonction de des coordonnées
	 */
	public float Mandelbrot(float x, float y, float x1, float y1, float zoom, float iteration_max ) {

		float c_r = x / zoom + x1;
		float c_i = y / zoom + y1;
		float z_r = 0;
		float z_i = 0;
		float i = 0;

		while (z_r*z_r + z_i*z_i < 4 && i < iteration_max) {
			float tmp = z_r;
			z_r = z_r*z_r - z_i*z_i + c_r;
			z_i = 2*z_i*tmp + c_i;
			i = i+1;
		}
		return i;
	}
	
	/**
	 * Fractale de Julia 
	 * @author baume
	 * @param x
	 * @param y
	 * @param x1
	 * @param y1
	 * @param zoom
	 * @param iteration_max
	 * @return l'itération en fonction de des coordonnées
	 */
	public float Julia(float x, float y, float x1, float y1, float zoom, float iteration_max ) {
		
		double c_r = 0.285;
		double c_i = 0.01;
		double z_r = x / zoom + x1;
		double z_i = y / zoom + y1;
		float i = 0;
		
		while (z_r*z_r + z_i*z_i < 4 && i < iteration_max) {
			double tmp = z_r;
			z_r = z_r*z_r - z_i*z_i + c_r;
			z_i = 2*z_i*tmp + c_i;
			i = i+1;
		}		
		return i;
	}	
	
	/**
	 * Fractale de Newton
	 * @author baume
	 * @param x
	 * @param y
	 * @param x1
	 * @param y1
	 * @param zoom
	 * @param iteration_max
	 * @return l'itération en fonction de des coordonnées
	 */
	public float Newton(float x, float y, float x1, float y1, float zoom, float iteration_max ) {
				
		double z_r = x / zoom + x1;
		double z_i = y / zoom + y1;
		float i = 0;
		double tmp = 1.0;
		
		while (tmp > 0.000001 && i < iteration_max) {
			double old_r = z_r;
			double old_i = z_i;
			tmp = (z_r*z_r + z_i*z_i)*(z_r*z_r + z_i*z_i);
			z_r = (2*z_r*tmp + z_r*z_r - z_i*z_i) / (3.0*tmp);
			z_i = (2*z_i*(tmp - old_r))/ (3.0*tmp);
			tmp = (z_r - old_r)*(z_r - old_r) + (z_i - old_i)*(z_i - old_i);
			i++;
		}
		return i;
	}

	public float getx1 () { return this.x1; }

	public float getx2 () { return this.x2; }

	public float gety1 () { return this.y1; }

	public float gety2 () { return this.y2; }

	public float getZoom() { return this.zoom; }
	
	public float gety() { return this.y; }

	public void setx1 (float x) { this.x1 = x; setChanged(); notifyObservers(); }

	public void setx2 (float x) { this.x2 = x; setChanged(); notifyObservers(); }

	public void sety1 (float x) { this.y1 = x; setChanged(); notifyObservers(); }

	public void sety2 (float x) { this.y2 = x; setChanged(); notifyObservers(); }

	public void setZoom (float x) { this.zoom = x; setChanged(); notifyObservers(); }
	
	public void sety (float x) { this.y = x; setChanged(); notifyObservers(); }

	public int getIteration_max() {	return iteration_max; }

	public void setIteration_max(int iteration_max) { this.iteration_max = iteration_max; }

	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return image;
	}	

}


