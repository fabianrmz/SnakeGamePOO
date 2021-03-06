import java.awt.BorderLayout;
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
	private JButton Instrucciones;//ver instrucciones
	private JButton Exit;//boton para salir
	private Menu menu;
	
	public MenuView(Menu menu) {
		super();
		this.menu=menu;
		this.setPreferredSize(new Dimension(600,600));
		//comando para ubicacion de botones
		this.setLayout(null);
		this.press=new ImageIcon("background.gif").getImage();//definir imagen
		this.pressstart=new ImageIcon("24eab460d2f094474e47fb01565c8e28.gif").getImage();
		this.logo=new ImageIcon("logo.png").getImage();
		
		for(int i=0;i<30;i++) {
			this.add(new JLabel("                                                           "));
		}
		
		this.Start=new JButton("START GAME");
		//Cooredenada Botones
		this.Start.setBounds(200, 325, 200, 25);
		
		this.add(this.Start);
		this.Start.addActionListener(this);
		
		
		this.Instrucciones=new JButton("HOW TO PLAY?");
		this.Instrucciones.setBounds(200, 360, 200, 25);
		this.add(this.Instrucciones);
		this.Instrucciones.addActionListener(this);
		
		this.Exit=new JButton("EXIT");
		this.Exit.setBounds(200, 395, 200, 25);
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
		if(e.getSource()==this.Exit) {//presiona para salir
			System.exit(0);
		}else if(e.getSource()==this.Instrucciones) {
			this.menu.dispose();
			HowToPlay inst=new HowToPlay();
			
		}else  if(e.getSource()==this.Start){
			this.menu.dispose();
			StartGame Start=new StartGame();
		}else {
		}
		
	}

	

		

	
}
