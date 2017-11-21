/**
 * 
 */
package Application;

import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * @author baume
 *
 */
public class Dessin extends JPanel{
//	private float x;
//	private float y;
//	private float width;
//	private float height;
//
//	public Dessin(float x, float y, float w, float h) {
//		this.x = x;
//		this.y = y;
//		this.width = w;
//		this.height = h;
//	}
	
	public void paintComponent(Graphics g) {
		System.out.println("je suis exécutée");
		g.fillOval(10, 10, 2,2);
	}
}
