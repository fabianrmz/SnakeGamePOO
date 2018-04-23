import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Puntaje extends JPanel {
	
	private Image IMGpuntaje;
	
	private int Puntuacion;
	private int PuntacionMA;
	private DrawGame g;
	private int score;
	private DrawGame game;
	private JButton pausa;
	
	public Puntaje(DrawGame game) {
		this.game=g;
		this.setSize(new Dimension(150,600));
		this.setBackground(Color.decode("#96cc2c"));
		this.IMGpuntaje=new ImageIcon("score-icon-8.png").getImage();
		this.pausa=new JButton("Pausa");
		this.add(pausa);
	}


	public void addScore(int nivel) {
		this.Puntuacion+=(100*nivel);
	}
	
	
	public void PaintComponent(Graphics g) {
		super.paint(g);
		g.drawImage(this.IMGpuntaje, 35, 100, 40, 40, this);
		g.drawString(this.Puntuacion+""+this.Puntuacion , 50, 100);
	}


	
}
