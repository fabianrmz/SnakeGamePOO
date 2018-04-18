import java.awt.BorderLayout;

import javax.swing.JFrame;

public class StartGame extends JFrame{
	
	public StartGame() {
		super("Start to play");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		DrawGame game=new DrawGame();
		
		this.add(game);
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		StartGame a=new StartGame();
		
	}
}
