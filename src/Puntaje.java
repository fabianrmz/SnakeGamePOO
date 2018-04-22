import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Puntaje extends JPanel {
	
	private Button Pausa;
	
	private int Puntuacion;
	private int PuntacionMA;
	private DrawGame g;
	private int score;
	private DrawGame game;
	public Puntaje(DrawGame game) {
		this.game=g;
		this.setSize(new Dimension(150,600));
		this.setBackground(Color.decode("#96cc2c"));
		this.add(new JLabel("                          "));
		
		
		
	}


	public void addScore(int nivel) {
		this.Puntuacion+=(100*nivel);
	}
	
	
	public void PaintComponent(Graphics g) {
		super.paint(g);
		g.drawString(this.Puntuacion+"", 0, 0);
	}


	
}
