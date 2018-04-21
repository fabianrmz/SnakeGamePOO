import java.awt.Graphics;

public class Snake {
	private int posx,
				posy;
	
	public Snake(int x, int y) {
		this.posx=x;
		this.posy=y;
	}
	public void setX(int x) {
		this.posx+=x;
	}
	public void setY(int y) {
		this.posy+=y;
	}
	public int getX() {
		return this.posx;
	}
	public int getY() {
		return this.posy;
	}
	public String toString() {
		return "X"+this.posx+"y"+this.posy;
	}
	
}
