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
	private Image logo;//imagen logo
	private JButton Start;//boton para iniciar juego
	private JButton Score;//ver historial de puntajes
	private JButton Instrucciones;//ver instrucciones
	private JButton Exit;//boton para salir
	public MenuView() {
		super();
		this.setPreferredSize(new Dimension(600,600));
		this.press=new ImageIcon("background.gif").getImage();//definir imagen
		this.logo=new ImageIcon("logo.png").getImage();
		
		for(int i=0;i<30;i++) {
			this.add(new JLabel("                                                                                   "));
		}
		this.Start=new JButton("START GAME");
		this.add(this.Start);
		this.Start.addActionListener(this);
		
		this.Exit=new JButton("EXIT");
		this.add(this.Exit);
		this.Exit.addActionListener(this);
		
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.press, 0, 0, this.getWidth(), this.getHeight(), this);//poner fondo
		g.drawImage(this.logo, 200, 150, 216, 154, this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.Start) {//si presiona start debe iniciar
			StartGame string=new StartGame();
			System.out.println("jugar");
		}else if(e.getSource()==this.Exit) {//presiona para salir
			System.exit(0);
		}
		
	}
}
