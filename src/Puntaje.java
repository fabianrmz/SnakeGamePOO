import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Puntaje extends JPanel{
	
	private Button Pausa;
	public Puntaje() {
		this.setSize(new Dimension(600,600));
		this.setBackground(Color.decode("#96cc2c"));
		this.Pausa=new Button("Pausa");
		this.add(this.Pausa);
	}
	
	
	
}
