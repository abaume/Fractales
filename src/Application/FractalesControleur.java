package Application;

public class FractalesControleur{

	public FractalesModèle model;

	/**
	 * @author baume
	 * @param modele
	 */
	public FractalesControleur(FractalesModèle modele) {
		// TODO Auto-generated constructor stub
		this.model = modele;
	}

	/**
	 * @author baume
	 * @param x
	 * @param y
	 * @return
	 */
	public float fractale(int x, int y) {
		float x1 = model.getx1();
		float y1 = model.gety1();
		float zoom = model.getZoom();
		int iteration_max = model.getIteration_max();

		float i = 0;
		switch (model.type) {
		case JULIA :
			i = model.Julia(x, y, x1, y1, zoom, iteration_max);
			break;
		case MANDELBROT :
			i = model.Mandelbrot(x, y, x1, y1, zoom, iteration_max);
			break;
		case NEWTON :
			i = model.Newton(x, y, x1, y1, zoom, iteration_max);
			break;
		default:
			i = model.Mandelbrot(x, y, x1, y1, zoom, iteration_max);
			break;		
		}
		return i;
	}
}


