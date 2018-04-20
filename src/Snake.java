
public class Snake {
	private int posx,
				posy;
	
	public Snake() {
		this.posx=300;
		this.posy=300;
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
}
