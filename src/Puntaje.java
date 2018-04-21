import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Puntaje extends JPanel{
	
	private Button Pausa;
	private JLabel Score;
	private JLabel HScore;
	
	private int Puntuacion;
	private int PuntacionMA;
	
	
	public Puntaje() {
		this.setSize(new Dimension(600,600));
		this.setBackground(Color.decode("#96cc2c"));
		this.Pausa=new Button("Pausa");
		this.add(this.Pausa);
		this.Score=new JLabel("aaaa");
		this.add(this.Score);
	}
	
	
	
}
