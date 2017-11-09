package Application;

import java.util.Observable;
import java.util.Observer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FractalesVue extends JFrame implements Observer, ActionListener {

	private static final long serialVersionUID = 1L;
	private FractalesControleur controleur;
	private FractalesMod�le modele;
	private String titre;
	JPanel panel;

	@Override
	public void update(Observable o, Object arg) {
//		
//		displayDataS.setText(Integer.toString(this.modele.getSeconde()));

	}

	public FractalesVue(FractalesControleur controleur, FractalesMod�le modele, String titre) {
		super(titre);
		this.titre = titre;
		this.controleur = controleur;
		this.modele = modele;

//		displayPoints2 = new JLabel(":");
		
		/* taille de la fen�tre */		
		setBounds(300, 100, 700, 500);
//		panel = new JPanel();
//		add(panel);
		
//		buttonPlus.addActionListener(this);
		
		/* ferme quand on clique sur la croix */
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == buttonPlus) {
//			
//			}
	}

	public static void main(String[] args) {

		FractalesMod�le model = new FractalesMod�le();
		FractalesControleur controller = new FractalesControleur(model);

		FractalesVue view = new FractalesVue(controller, model, "Fractales");
		model.addObserver(view);

	
	}
}
