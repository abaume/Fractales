package Application;

public class FractalesControleur{

	public FractalesModèle model;

	public FractalesControleur(FractalesModèle modele) {
		// TODO Auto-generated constructor stub
		this.model = modele;
	}
	
	/*
	 * 
	 */
	public float fractale(int x, int y) {
		float x1 = model.getx1();
		float x2 = model.getx2();
		float y1 = model.gety1();
		float y2 = model.gety2();

		float zoom = model.getZoom();
		int iteration_max = model.getItMax();
		
		float i = 0;
		switch (model.type) {
		case JULIA :
			i = model.Julia(x, y, x1, y1, zoom, iteration_max);
		case MANDELBROT :
			i = model.Mandelbrot(x, y, x1, y1, zoom, iteration_max);
//		case BOUDDHA :
//			i = model.Bouddhabrot(x, y, x1, y1, zoom, iteration_max, pixels);
		default:
			break;		
		}
		return i;
	}
}


