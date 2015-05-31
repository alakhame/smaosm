package approche.globale.utils;

import java.util.ArrayList;

import network.structure.*;

import madkit.kernel.AgentAddress;


public class ReponseDemande {
	private AgentAddress adresse;
	private ArrayList<Place> listePlaceLibre;
	public ReponseDemande()
	{
	}
	public void setListePlaceLibre(ArrayList<Place> listePlaceLibre) {
		this.listePlaceLibre = listePlaceLibre;
	}
	public ArrayList<Place> getListePlaceLibre() {
		return listePlaceLibre;
	}
	public void setAdresse(AgentAddress adresse) {
		this.adresse = adresse;
	}
	public AgentAddress getAdresse() {
		return adresse;
	}
	
	public String toString(){
		String st= "";
		for (Place p : listePlaceLibre)
			st += p + "\n";
		return st;
	}
	
}
