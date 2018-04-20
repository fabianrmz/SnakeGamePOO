import java.awt.BorderLayout;

import javax.swing.JFrame;

public class StartGame extends JFrame{
	
	public StartGame() {
		super("Start to play");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Puntaje punt=new Puntaje();
		DrawGame game=new DrawGame(punt);
		
		this.add(game);
		this.add(punt,BorderLayout.EAST);
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		StartGame a=new StartGame();
	}
}
