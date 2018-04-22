import java.awt.BorderLayout;

import javax.swing.JFrame;

public class StartGame extends JFrame{
	
	public StartGame() {
		super("Start to play");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		DrawGame game=new DrawGame();
		Puntaje punt=new Puntaje(game);
		this.add(game);
		this.add(punt,BorderLayout.EAST);
		this.pack();
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
}
