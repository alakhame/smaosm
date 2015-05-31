package network.turtles;

import java.awt.Color;
import network.structure.Place;
import network.structure.Reseau;

;

public class AgHorsCommunaute extends TurtleNetWorkTurtle {

	private static final long serialVersionUID = 1L;

	String myCommunity = "horscommunaute";
	String myGroup = "membre";
	String myRole = "horsstaionnement";
	boolean ajoutDemande;

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
		case versPlace:
			setColor(Color.yellow);
			break;
		case vadrouille:
			setColor(Color.pink);
			break;
		case attentePlace : setColor(Color.blue);break;
		}
		
	}

	public String lancement() {
		createGroup(true, myCommunity, myGroup, null, null);
		setState(TurtleState.vadrouille); 
		cr.setArcCourant(Reseau.getArcDebut());
		position = Reseau.getPositionDebut(cr.getArcCourant());
		setXY(cr.getArcCourant().getPositionArc(position).getX(), cr.getArcCourant().getPositionArc(position).getY());
		return "live";
	}

	public String lancementb() {
		createGroup(true, myCommunity, myGroup, null, null);
		
		cr.setArcCourant(Reseau.getArcDebut());
		position = Reseau.getPositionDebut(cr.getArcCourant());
		if(cr.getArcCourant().getOrder()%2==0)
		while (!cr.getArcCourant().isPositionPlace(position))
			position = Reseau.getPositionDebut(cr.getArcCourant());
		setXY(cr.getArcCourant().getPositionArc(position).getX(), cr.getArcCourant().getPositionArc(position).getY());
		Place pl = new Place(cr.getArcCourant().getId(), cr.getArcCourant().getPositionArc(position));
		if (Reseau.containPlaceprise(pl)) {
			setState(TurtleState.vadrouille);// etat=3;
		} else {
			Reseau.placeprisedebut.add(pl);
			setState(TurtleState.arret); // etat=0;
		}
		return "live";
	}

	public String live() {
		while (true) {
			step++;
			if (Reseau.getStep() != step)
				Reseau.setStep(step);
			if (state == TurtleState.arret) {
				if (cycleArret > Reseau.nbreCycleOccupationPlace) {
					setState(TurtleState.vadrouille); 
					cycleArret = 0;
				} else
					cycleArret++;
				//checkKill();
			} else if ((state == TurtleState.vadrouille) || (state == TurtleState.cherche)) {
				boolean vadrouilleToCherche=false,vadrouille=false;
				if (state == TurtleState.cherche) {
					cycleRecherche++;
					Reseau.tempsrecherchehorscommunaute++;
				}else if(state == TurtleState.vadrouille){
					vadrouille=true;
				}
				circuler();
				if (state == TurtleState.arret) {// if(etat==0)
					Reseau.tempsrecherchehorscommunaute +=1;
					changementStationner();
				}else if(state == TurtleState.cherche){
					vadrouilleToCherche=true;
				}
				
				if(vadrouille && vadrouilleToCherche){
					Reseau.nbredemandehorscommunaute++;
					cycleRecherche++;
				}

			}
			return "live";
		}

	}

	public void changementStationner() {
		setState(TurtleState.arret);
		if (step > 1) {
		 	Reseau.tempsrecherchehorscommunaute += cycleRecherche;
			//Reseau.nbredemandehorscommunaute ++;
		}
		cycleRecherche = 0;
	}

}
