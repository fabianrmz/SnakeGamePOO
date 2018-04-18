import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class DrawGame extends JPanel implements KeyListener{
	
	private int posx;
	private int posy;
	public DrawGame() {
		super();
		this.posx=0;
		this.posy=0;
		this.setPreferredSize(new Dimension(800,640));
		this.addKeyListener(this);
		setFocusable(true);
		long start = System.currentTimeMillis();
	}
	
	public void keyPressed (KeyEvent e) {
        int c = e.getKeyCode ();
        if (c==KeyEvent.VK_UP) { //movimiento arriba
            this.posy-=5;
        } else if(c==KeyEvent.VK_DOWN) { //movimiento abajo
        	 this.posy+=5;
        } else if(c==KeyEvent.VK_LEFT) {      //movimiento izquiera
        	this.posx-=5;
        } else if(c==KeyEvent.VK_RIGHT) {   //movimiento derecha             
        	this.posx+=5;
        }
        repaint();
    }

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(400+this.posx, 320+this.posy, 20, 20);
	}
}
