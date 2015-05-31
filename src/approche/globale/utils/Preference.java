package approche.globale.utils;

import java.util.ArrayList;
import network.structure.Arc;

public class Preference {
	//private AgentAddress adresse;
	private ArrayList<Arc> preference;
	private double distance;//distance por arriver à la place;
	//public Preference(AgentAddress a, ArrayList<Arc> p)
	public Preference(ArrayList< Arc> p,double dist)
	{
		//setAdresse(a);
		setPreference(p);
		setDistance(dist);
	}
	/*public void setAdresse(AgentAddress adresse) {
		this.adresse = adresse;
	}
	public AgentAddress getAdresse() {
		return adresse;
	}*/
	public void setPreference(ArrayList<Arc> preference) {
		this.preference = preference;
	}
	public ArrayList<Arc> getPreference() {
		return preference;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getDistance() {
		return distance;
	}
	
}
