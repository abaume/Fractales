package Application;

public class FractalesControleur{
    
    public FractalesModèle model;

    public FractalesControleur(FractalesModèle modele) {
   	 // TODO Auto-generated constructor stub
   	 this.model = modele;
    }
    
    public void Mandelbrot() {
    	// définition de la zone à dessiner sachant que l'ensemble
    	// de Mandelbrot est toujours compris entre les coordonnées suivantes
    	float x1 = (float)-2.1; 
    	float x2 = (float)0.6;
    	float y1 = (float)-1.2;
    	float y2 = (float)1.2;
    	
    	int zoom = 100; // distance 1 sur plan = 100px sur image
    	int iteration_max = 50;
    	
    	// taille de l'image par rapport au zoom
    	float image_x = (x2 - x1) * zoom;
    	float image_y = (y2 - y1) * zoom;
    	
    	for (int x = 0; x < image_x; x++) {
    		for (int y = 0; y < image_y; y++) {
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
            	
            	if ( i == iteration_max) {
            		// dessiner le point
            		System.out.print(".");
            	}
    		}
    		
    	}
    	
    }

}


