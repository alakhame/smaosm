package approche.globale.utils;

//import java.util.Date;

import madkit.kernel.AgentAddress;
import network.structure.*;

public class PreReservation {
	private AgentAddress adresse;
	private Place placeReservee;
	private double dist;
	private int nbcycle;
	public PreReservation(AgentAddress a, Place p,double d,int cycle)
	{
		setAdresse(a);
		setPlaceReservee(p);
		setDist(d);
	}
	public void setAdresse(AgentAddress adresse) {
		this.adresse = adresse;
	}
	public AgentAddress getAdresse() {
		return adresse;
	}
	public void setPlaceReservee(Place placeReservee) {
		this.placeReservee = placeReservee;
	}
	public Place getPlaceReservee() {
		return placeReservee;
	}
	public void setDist(double dist) {
		this.dist = dist;
	}
	public double getDist() {
		return dist;
	}
	public void setNbCycle(int c) {
		this.nbcycle = c;
	}
	public int getNbCycle() {
		return nbcycle;
	}

}
