import javax.swing.JFrame;

public class HowToPlay extends JFrame{
	public HowToPlay() {
		super("H O W  T O  P L A Y ?       S N A K E");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(new HowToPlayWindow());
		this.pack();
		
		this.setResizable(false);
		this.setLocationRelativeTo(null); 
		this.setVisible(true);
	}
}
