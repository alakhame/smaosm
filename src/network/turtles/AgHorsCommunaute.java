package network.turtles;

import java.awt.Color;

import network.structure.Place;
import network.structure.Reseau;

;

public class AgHorsCommunaute extends TurtleNetWorkTurtle {

	private static final long serialVersionUID = 1L;

	String myCommunity = "horscommunaute";
	String myGroup = "membre";

	// int tempsrecherche=0;
	public AgHorsCommunaute(String s) {
		super(s);
	}

	public AgHorsCommunaute() {
		super();
	}

	public AgHorsCommunaute(String string, boolean b) {
		super(string);
		print = b;
	}

	public void setState(TurtleState ts) {
		state = ts;
		switch (state) {
		case arret:
			setColor(Color.white); 
			break;
		case cherche:
			setColor(Color.yellow); 
			break;
		case vadrouille:
			setColor(Color.cyan);  
			break;
		}
		
	}

	public String lancement() {
		initialisation();
		createGroup(true, myCommunity, myGroup, null, null);
		setState(TurtleState.vadrouille); 
		cr.setArcCourant(Reseau.getArcDebut());
		position = Reseau.getPositionInitialisation(cr.getArcCourant());
		setXY(cr.getArcCourant().getPositionArc(position).getX(), cr.getArcCourant().getPositionArc(position).getY());
		// a effacer
	//	Reseau.afficheArcLie();
		//
		return "live";
	}

	public String lancementb() {
		createGroup(true, myCommunity, myGroup, null, null);
		initialisation();
		cr.setArcCourant(Reseau.getArcDebut());
		position = Reseau.getPositionInitialisation(cr.getArcCourant());
		if(cr.getArcCourant().contientPlace())
		while (!cr.getArcCourant().isPositionPlace(position))
			position = Reseau.getPositionInitialisation(cr.getArcCourant());
		setXY(cr.getArcCourant().getPositionArc(position).getX(), cr.getArcCourant().getPositionArc(position).getY());
		Place pl = new Place(cr.getArcCourant().getId(), cr.getArcCourant().getPositionArc(position));
		if (Reseau.containPlaceprise(pl)) {
			setState(TurtleState.vadrouille);// etat=3;
		} else {
			Reseau.placeprisedebut.add(pl);
			setState(TurtleState.arret); // etat=0;
//			Reseau.incNbreStationnementsHC();
		}
		return "live";
	}
		
	@Override
	public void tr_cherche_arret() {
		setState(TurtleState.arret);
		Reseau.incNbreStationnementsHC();
		setGare(true);
//		System.out.println(this.getName() + " : " + cr.getArcCourant() + " : " + cr.getArcCourant().getPositionArc(position));
// A decommenter??:	 	Reseau.incNbreCycleTotalhorscommunaute(cycleCherche);
//		cycleCherche = 0;
	}

	@Override
	protected void miseAjourDemande() {
		Reseau.incNbredemandeTotalHC(this);
	}
	

	public String live() {
		circuler();
		return "live";
}

}
