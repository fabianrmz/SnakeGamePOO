import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class StartGame extends JFrame{
	
	public StartGame() {
		super("Start to play");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		DrawGame game=new DrawGame(this);
		Puntaje punt=new Puntaje(game);
		this.add(game);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (pantalla.width - 600) / 2, (pantalla.height - 800) / 2);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}
	
	
}
