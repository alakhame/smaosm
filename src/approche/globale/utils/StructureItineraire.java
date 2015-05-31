package approche.globale.utils;

import network.structure.Place;

public class StructureItineraire {
	private Place place;
	private double dist;
	private int nbreCycle;
	public void setPlace(Place p) {
		this.place = p;
	}
	public Place getPlace() {
		return place;
	}
	public void setDist(double dist) {
		this.dist = dist;
	}
	public double getDist() {
		return dist;
	}
	public void setNbreCycle(int nbreCycle) {
		this.nbreCycle = nbreCycle;
	}
	public int getNbreCycle() {
		return nbreCycle;
	}
	public String toString(){
		return place.toString();
	}
}
