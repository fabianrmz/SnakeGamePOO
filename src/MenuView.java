import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuView extends JPanel implements ActionListener{
	
	private Image press;//fondo
	private Image pressstart;//fondo inicio presiona start
	private Image logo;//imagen logo
	private JButton Start;//boton para iniciar juego
	private JButton Score;//ver historial de puntajes
	private JButton Instrucciones;//ver instrucciones
	private JButton Exit;//boton para salir
	
	public MenuView() {
		super();
		this.setPreferredSize(new Dimension(600,600));
		this.press=new ImageIcon("background.gif").getImage();//definir imagen
		this.pressstart=new ImageIcon("24eab460d2f094474e47fb01565c8e28.gif").getImage();
		this.logo=new ImageIcon("logo.png").getImage();
		
		for(int i=0;i<30;i++) {
			this.add(new JLabel("                                                           "));
		}
		
		this.Start=new JButton("START GAME");
		this.add(this.Start);
		this.Start.addActionListener(this);
		
		this.Score=new JButton("HISTORY SCORE");
		this.add(this.Score);
		this.Start.addActionListener(this);
		
		this.Instrucciones=new JButton("HOW TO PLAY?");
		this.add(this.Instrucciones);
		this.Instrucciones.addActionListener(this);
		
		this.Exit=new JButton("EXIT");
		this.add(this.Exit);
		this.Exit.addActionListener(this);
		
		
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.press, 0, 0, this.getWidth(), this.getHeight(), this);//poner fondo
		g.drawImage(this.logo, 200, 175, 213, 152, this);
		//g.drawImage(this.pressstart, 0, 0, this.getWidth(), this.getHeight(), this);       image press start to continue
		
	}

	
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.Start) {//si presiona start debe iniciar
			StartGame string=new StartGame();     
			
			
		}else if(e.getSource()==this.Exit) {//presiona para salir
			System.exit(0);
		}else if(e.getSource()==this.Instrucciones) {
			//see instructions
			
		}else {
			//watch scores
		}
		
	}

	

		

	
}
