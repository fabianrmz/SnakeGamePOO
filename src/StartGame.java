import java.awt.BorderLayout;

import javax.swing.JFrame;

public class StartGame extends JFrame{
	
	public StartGame() {
		super("Start to play");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Puntaje punt=new Puntaje();
		DrawGame game=new DrawGame(punt);
		
		this.add(game);
		this.add(punt,BorderLayout.WEST);
		this.pack();
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
}
