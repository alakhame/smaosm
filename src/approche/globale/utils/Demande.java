package approche.globale.utils;
import network.structure.*;

//import madkit.kernel.AgentAddress;

public class Demande {
	
	//private AgentAddress adresse;
	private Arc arcCourant;
	private Coordonnees position;
	private int nbreMaxPlace;
	private boolean sensDeplacement;
	public Demande(Arc a,int nbre)
	{
		setArcCourant(a);
		setNbreMaxPlace(nbre);
	}
	/*public void setAdresse(AgentAddress adresse) {
		this.adresse = adresse;
	}
	public AgentAddress getAdresse() {
		return adresse;
	}*/
	public void setArcCourant(Arc arcCourant) {
		this.arcCourant = arcCourant;
	}
	public Arc getArcCourant() {
		return arcCourant;
	}
	public void setNbreMaxPlace(int nbreMaxPlace) {
		this.nbreMaxPlace = nbreMaxPlace;
	}
	public int getNbreMaxPlace() {
		return nbreMaxPlace;
	}
	public void setPosition(Coordonnees position) {
		this.position = position;
	}
	public Coordonnees getPosition() {
		return position;
	}
	public void setSensDeplacement(boolean sensDeplacement) {
		this.sensDeplacement = sensDeplacement;
	}
	public boolean isSensDeplacement() {
		return sensDeplacement;
	}
	

}
