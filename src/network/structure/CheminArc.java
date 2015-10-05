package network.structure;

public class CheminArc {

	private Arc arc;
	private double parcouru;

	public CheminArc(Arc a, double p) {
		setArc(a);
		setParcouru(p);
	}

	public void setArc(Arc arc) {
		this.arc = arc;
	}

	public Arc getArc() {
		return arc;
	}

	public void setParcouru(double parcouru) {
		this.parcouru = parcouru;
	}

	public double getParcouru() {
		return parcouru;
	}
	
	public String toString(){
		return arc + " : " + parcouru;
	}
}