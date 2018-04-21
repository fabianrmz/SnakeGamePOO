import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class DrawGame extends JPanel implements Runnable, KeyListener {
	
	private boolean Barriba,
					Babajo,
					Bizquierda,
					Bderecha,
					Gameplay;
					
	private int comidaX,
				comidaY,
				cuerpo,
				 posx,
				 posy;
	
	private Random random;
	private Puntaje puntajeH;
	
	
	
	
	private Thread hilo;
	
	private ArrayList<Snake> CuerpoCoordenadas;
	

	
	public DrawGame(Puntaje p) {
		super();
		//Array de coordenadas de la serpiente
		CuerpoCoordenadas = new ArrayList<>();
		//Posición inicial
		CuerpoCoordenadas.add(0,new Snake(300,300));
		//Panel puntaje
		this.puntajeH=p;
		//Variable útil para parar el juego
		this.Gameplay=true;
		//Crea la posición de la fruta random
		random = new Random();
		this.Random();
		//Booleanos de movimiento
		this.Barriba=false;
		this.Babajo=false;
		this.Bderecha=false;
		this.Bizquierda=false;
		//Dimensiones
		this.setPreferredSize(new Dimension(600,600));
		//Keylistener
		this.addKeyListener(this);
		setFocusable(true);
		long start = System.currentTimeMillis();
		
		hilo=new Thread(this);
		hilo.start();
	}
	
	//Detectar movimientos
	public void keyPressed (KeyEvent e) {
        int c = e.getKeyCode ();
        
        if (c==KeyEvent.VK_UP && (!this.Babajo)) { //movimiento arriba
        		this.Barriba=true;
        		this.Bderecha=false;
        		this.Bizquierda=false;
        		
        } else if(c==KeyEvent.VK_DOWN && (!this.Barriba)) { //movimiento abajo
    		this.Babajo=true;
    		this.Bderecha=false;
    		this.Bizquierda=false;
        } else if(c==KeyEvent.VK_LEFT && (!this.Bderecha)) {      //movimiento izquiera
        	this.Barriba=false;
    		this.Babajo=false;
    		this.Bizquierda=true;
        } else if(c==KeyEvent.VK_RIGHT && (!this.Bizquierda)) {   //movimiento derecha             
        	this.Barriba=false;
    		this.Babajo=false;
    		this.Bderecha=true;
        }
        repaint();
    }
	
	//Crea un nuevo número random en caso de conseguir la fruta
	public void Random() {
		int x=random.nextInt(600);
		int y =this.comidaY=random.nextInt(600);
		//Solo pueden ser multiplos de 20, esto con el propósito
		//de hacer que coincida con el movimiento de la sepriente
		while(x%20!=0 || y%20!=0) {
				x=random.nextInt(600);
				y=this.comidaY=random.nextInt(600);
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
		//Color verde
		g.setColor(Color.decode("#b0dd56"));
		//Retcnagulo de fondo
		g.fillRect(0, 0, this.getWidth(),this.getHeight());
		//Color verde claro
		g.setColor(Color.decode("#97d125"));
		//Crea los cuadrados en multiplos de 20
		for(int i=0;i<600;i+=40) {
			g.fillRect(i, 0, 20,600);
			g.fillRect(0, i+20, 600,20);
		}
		//Color de la comida y de la serpiente
		g.setColor(Color.black);
		for (int i = 0;i<this.CuerpoCoordenadas.size();i++) {
			g.fillRect(this.CuerpoCoordenadas.get(i).getX(), this.CuerpoCoordenadas.get(i).getY(), 20, 20);//Serpiente
		}
		
		
		g.fillRect(this.comidaX, this.comidaY, 20, 20);//Comida
		repaint();
		
	
	}

	
	public void run() {
		try {
			while(this.Gameplay) {
				//Velocidad del juego
				Thread.sleep(80);
				//Que hacer cuando atrapa la fruta
				this.FrutaAtrapada();
				//Movimiento de la serpiente
				this.mover();
				
				repaint();
			
			}
			
		}
		catch(InterruptedException e){
			System.out.println("Se interrumpio el programa");
		}
		
	}
	
	public void mover() {
		//Este ciclo sirve para hacer que el cuerpo de la sepriente siga la cabeza
		for (int i = this.cuerpo; i > 0; i--) {
			//Este if previene nullpointerexceptions
			if(i<this.CuerpoCoordenadas.size()) {
				this.CuerpoCoordenadas.set(i, new Snake(this.CuerpoCoordenadas.get(i-1).getX(),this.CuerpoCoordenadas.get(i-1).getY()));
			}else {
				this.CuerpoCoordenadas.add(null);
				this.CuerpoCoordenadas.set(i, new Snake(this.CuerpoCoordenadas.get(i-1).getX(),this.CuerpoCoordenadas.get(i-1).getY()));
			}
		     
		}
		//Mueve la cabeza hacia arriba
		if(this.Barriba) {
			this.CuerpoCoordenadas.get(0).setY(-20);
		}
		//Mueve la cabeza hacia abajo
		else if(this.Babajo) {												
			this.CuerpoCoordenadas.get(0).setY(20);
		}
		//Mueve la cabeza hacia la derecha
		else if(this.Bderecha) {
				
			this.CuerpoCoordenadas.get(0).setX(20);
		}
		//Mueve la cabeza hacia la izquierda
		else if(this.Bizquierda) {
			this.CuerpoCoordenadas.get(0).setX(-20);
			
		}
	}
	
	public void FrutaAtrapada() {
		//Si las coordenadas de la cabeza coinciden con las coordenadas de la fruta
		if(this.comidaX==this.CuerpoCoordenadas.get(0).getX() && this.comidaY==this.CuerpoCoordenadas.get(0).getY()) {
			//Aumenta el tamaño del cuerpo
			this.cuerpo++;
			//Crea nuevas coordenadas para la fruta
			this.Random();
			
		}
	}
	

}
