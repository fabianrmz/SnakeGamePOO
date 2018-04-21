import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class DrawGame extends JPanel implements KeyListener, Runnable{
	
	private int posx;
	private int posy;
	private boolean Barriba,Babajo,
							Bizquierda,
							Bderecha;
	private int comidaX,
				comidaY;
	private Random random;
	private Puntaje puntajeH;
	
	private Snake anterior;
	
	private ArrayList<Snake> CuerpoCoordenadas;
	
	public DrawGame(Puntaje p) {
		super();
		CuerpoCoordenadas = new ArrayList<>(1);
		CuerpoCoordenadas.add(0,new Snake(300,300));
		this.puntajeH=p;
		random = new Random();
		this.Random();
		this.Barriba=false;
		this.Babajo=false;
		this.Bderecha=false;
		this.Bizquierda=false;
		this.setPreferredSize(new Dimension(600,600));
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
	
	public void Random() {
		int x=random.nextInt(600);
		int y =this.comidaY=random.nextInt(600);
		if(x%20!=0 || y%20!=0) {
			while(x%20!=0 || y%20!=0) {
				x=random.nextInt(600);
				y =this.comidaY=random.nextInt(600);
			}
		}
		this.comidaX=x;
		this.comidaY=y;
		
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
		g.setColor(Color.decode("#b0dd56"));
		g.fillRect(0, 0, this.getWidth(),this.getHeight());
		g.setColor(Color.decode("#97d125"));
		for(int i=0;i<600;i+=40) {
			g.fillRect(i, 0, 20,600);
			g.fillRect(0, i+20, 600,20);
		}
		g.setColor(Color.black);
		//g.fillRect(20, 60, this.getWidth()-40, 10);barra de arriba
		//g.fillRect(20, 90, this.getWidth()-40, 10);Contorno
		//g.fillRect(20, 600, this.getWidth()-40, 10);
		
		for (int i = 0;i<this.CuerpoCoordenadas.size();i++) {
			g.fillRect(this.CuerpoCoordenadas.get(i).getX(), this.CuerpoCoordenadas.get(i).getY(), 20, 20);//Serpiente
		}
		
		
		g.fillRect(this.comidaX, this.comidaY, 20, 20);//Comida
		repaint();
		
		
		
	}

	
	public void run() {
		try {
			while(true) {
					if(this.CuerpoCoordenadas.size()==1) {
						if(this.Barriba) {
							this.CuerpoCoordenadas.get(0).setY(-20);
							repaint();
						}
						else if(this.Babajo) {
							
							this.CuerpoCoordenadas.get(0).setY(20);
							repaint();
						}
						else if(this.Bderecha) {
							
							this.CuerpoCoordenadas.get(0).setX(20);
							repaint();
						}
						else if(this.Bizquierda) {
							this.CuerpoCoordenadas.get(0).setX(-20);
							repaint();
						}
					} else {
						for(int i=1;i<this.CuerpoCoordenadas.size();i++) {
							 this.anterior=this.CuerpoCoordenadas.get(i-1);
							this.CuerpoCoordenadas.set(i,new Snake(anterior.getX(),anterior.getY()));
							
							if(this.Barriba) {
								this.CuerpoCoordenadas.get(0).setY(-20);
								repaint();
							}
							else if(this.Babajo) {
								
								this.CuerpoCoordenadas.get(0).setY(20);
								repaint();
							}
							else if(this.Bderecha) {
								
								this.CuerpoCoordenadas.get(0).setX(20);
								repaint();
							}
							else if(this.Bizquierda) {
								this.CuerpoCoordenadas.get(0).setX(-20);
								repaint();
							}
						}
						
					}
					

				
				Thread.sleep(80);
				FrutaAtrapada();
				
			}
			
		}
			catch(InterruptedException e){
				System.out.println("Se interrumpio el programa");
			}
		
	}
	public void FrutaAtrapada() {
		if(this.comidaX==this.CuerpoCoordenadas.get(0).getX() && this.comidaY==this.CuerpoCoordenadas.get(0).getY()) {
			Random();
			if(this.CuerpoCoordenadas.size()==1) {
				this.CuerpoCoordenadas.add(this.CuerpoCoordenadas.get(0));
			}else {
				this.CuerpoCoordenadas.add(this.anterior);
				for(int i =0;i<this.CuerpoCoordenadas.size();i++) {
					System.out.println(this.CuerpoCoordenadas.get(i));
				}
			}
			repaint();
			
		}
	}

}
