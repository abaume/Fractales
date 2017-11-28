package Application;

import java.util.Observable;

public class FractalesModèle extends Observable{

	private int iteration_max = 50;

	// variables de la zone à dessiner
	private float x1; 
	private float x2;
	private float y1;
	private float y2;
	public typeFractale type;
	private float zoom = 350; // distance 1 sur plan = 100px sur image


	public FractalesModèle(float x1, float x2, float y1, float y2, typeFractale t) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.type = t;
		
	}


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
	
	public float Lisa(float x, float y, float x1, float y1, float zoom, float iteration_max ) {
		float i =0;
		
		
		
		
		
		return i;
	}

	public float getx1 () { return this.x1; }

	public float getx2 () { return this.x2; }

	public float gety1 () { return this.y1; }

	public float gety2 () { return this.y2; }

	public float getZoom() { return this.zoom; }

	public int getItMax() { return iteration_max; }

	public void setx1 (float x) { this.x1 = x; setChanged(); notifyObservers(); }

	public void setx2 (float x) { this.x2 = x; setChanged(); notifyObservers(); }

	public void sety1 (float x) { this.y1 = x; setChanged(); notifyObservers(); }

	public void sety2 (float x) { this.y2 = x; setChanged(); notifyObservers(); }

	public void setZoom (float x) { this.zoom = x; setChanged(); notifyObservers(); }

}


