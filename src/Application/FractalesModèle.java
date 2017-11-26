package Application;

import java.util.Observable;

public class FractalesModèle extends Observable{

    private int iteration_max = 50;
    
    // variables de la zone à dessiner
    private float x1; 
	private float x2;
	private float y1;
	private float y2;
	
	private float zoom = 10; // distance 1 sur plan = 100px sur image


    public FractalesModèle() {
   	 // TODO Auto-generated constructor stub
   	 
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


