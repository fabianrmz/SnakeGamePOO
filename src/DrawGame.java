import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class DrawGame extends JPanel implements KeyListener, Runnable{
	
	private int posx;
	private int posy;
	private boolean Barriba,Babajo,
							Bizquierda,
							Bderecha;
	public DrawGame() {
		super();
		this.posx=0;
		this.posy=0;
		this.Barriba=false;
		this.Babajo=false;
		this.Bderecha=false;
		this.Bizquierda=false;
		this.setPreferredSize(new Dimension(800,640));
		this.addKeyListener(this);
		setFocusable(true);
		long start = System.currentTimeMillis();
		Thread hilo=new Thread(this);
		hilo.start();
	}
	
	public void keyPressed (KeyEvent e) {
        int c = e.getKeyCode ();
        if (c==KeyEvent.VK_UP) { //movimiento arriba
            //this.posy-=5;
        		this.Barriba=true;
        		this.Babajo=false;
        		this.Bderecha=false;
        		this.Bizquierda=false;
        		
        } else if(c==KeyEvent.VK_DOWN) { //movimiento abajo
        	 //this.posy+=5;
        	this.Barriba=false;
    		this.Babajo=true;
    		this.Bderecha=false;
    		this.Bizquierda=false;
        } else if(c==KeyEvent.VK_LEFT) {      //movimiento izquiera
        	//this.posx-=5;
        	this.Barriba=false;
    		this.Babajo=false;
    		this.Bderecha=false;
    		this.Bizquierda=true;
        } else if(c==KeyEvent.VK_RIGHT) {   //movimiento derecha             
        //	this.posx+=5;
        	this.Barriba=false;
    		this.Babajo=false;
    		this.Bderecha=true;
    		this.Bizquierda=false;
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
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, this.getWidth(),this.getHeight());
		g.setColor(Color.black);
		g.fillRect(20, 60, this.getWidth()-40, 10);//barra de arriba
		g.fillRect(20, 90, this.getWidth()-40, 10);//Contorno
		g.fillRect(20, 600, this.getWidth()-40, 10);
		
		
		g.fillRect(400+this.posx, 320+this.posy, 20, 20);
	}

	
	public void run() {
		try {
			while(true) {
				if(this.Barriba) {
					
					this.posy-=5;
					repaint();
				}
				else if(this.Babajo) {
					
					this.posy+=5;
					repaint();
				}
				else if(this.Bderecha) {
					
					this.posx+=5;
					repaint();
				}
				else if(this.Bizquierda) {
					
					this.posx-=5;
					repaint();
				}
				Thread.sleep(15);
			}
			
		}
			catch(InterruptedException e){
				System.out.println("Se interrumpio el programa");
			}
		
	}
	

}
