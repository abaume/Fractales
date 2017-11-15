package Application;

public class FractalesControleur{

	public FractalesModèle model;

	public FractalesControleur(FractalesModèle modele) {
		// TODO Auto-generated constructor stub
		this.model = modele;
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
}


