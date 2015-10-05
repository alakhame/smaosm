package network.structure;

public class Coordonnees {

	private int x;
	private int y;

	public Coordonnees(int a, int o) {
		setX(a);
		setY(o);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean equals(Coordonnees posit) {
		return ((this.x == posit.getX()) && (this.y == posit.getY()));
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
