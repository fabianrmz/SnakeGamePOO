//Erick David Mendoza Velasco A01631093
//Óscar Fabián Ramírez González A01630024
//Programación Orientado a Objetos


import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Menu extends JFrame{
	
	
	public Menu() {
		super("S N A K E  G A M E");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		MenuView mv=new MenuView(this);
		this.add(mv);
		this.pack();
		this.setLocationRelativeTo(null); 
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		Menu mv=new Menu();
	}
	
}
