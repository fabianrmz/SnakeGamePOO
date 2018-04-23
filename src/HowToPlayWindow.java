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
	public void PaintComponent(Graphics g) {
		super.paint(g);
		
	}

}
