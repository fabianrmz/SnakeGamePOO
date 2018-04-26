import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class HowToPlayWindow extends JPanel implements ActionListener{
	private Image background,
				  title,
				  flechas,
				  esc,
				  Instructive;
	
	private JButton back;
	
	private HowToPlay htp;
	
	public HowToPlayWindow(HowToPlay htp) {
		super();
		this.htp=htp;
		//Dimensiones de la ventana
		this.setPreferredSize(new Dimension(600,600));
		//Inicializando imagenes
		this.background=new ImageIcon("howtoplay.gif").getImage();
		this.title=new ImageIcon("instructionstitle.png").getImage();
		this.flechas=new ImageIcon("arrowKeys-300x205.png").getImage();
		this.esc=new ImageIcon("computer_key_Esc.png").getImage();
		this.Instructive=new ImageIcon("INSTRUCT.png").getImage();
		
		this.setLayout(null);
		//Inicializando boton
		this.back=new JButton("GO BACK");
		this.back.setBounds(250, 570, 120, 25);
		this.add(this.back);
		this.back.addActionListener(this);
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.background, 0, 0, 972, 622, this);
		g.drawImage(this.title, 135, 60,291,45, this);
		g.drawImage(this.flechas, 100, 200, 150, 102, this);
		g.drawImage(this.esc, 145, 350, 70, 70, this);
		g.drawImage(this.Instructive, 300, 120, 182, 425, this);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.htp.dispose();
		Menu m=new Menu();
		
	}

}
