import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HowToPlayWindow extends JPanel{
	private Image background;
	
	public HowToPlayWindow() {
		super();
		this.setPreferredSize(new Dimension(600,600));
		this.background=new ImageIcon("howtoplay.gif").getImage();
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.background, 0, 0, 972, 622, this);
		
	}

}
