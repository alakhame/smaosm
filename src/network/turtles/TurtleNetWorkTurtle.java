package network.turtles;

import java.awt.Color;

import approche.locale.turtles.AssistantApprocheLocale;
import network.structure.*;
import network.turtles.AgHorsCommunaute;
import network.turtles.TurtleNetWorkTurtle;
import turtlekit.kernel.Turtle;

public class TurtleNetWorkTurtle extends Turtle {
	public CalculReseau cr;
	public int nbredemande = 0;
	public int nbrenotif = 0;
	public Place placeChoisie;
	public int step;
	public int cycleArret = 0;
	public int cycleRecherche = 0;
	public boolean sens;
	public boolean print = false;
	public int position;
	public int cycleVadrouille = 0;
	private static final long serialVersionUID = 1L;
	public TurtleState state;

	public TurtleNetWorkTurtle(String s, boolean print) {
		super(s);
		cr = new CalculReseau(this);
		this.print = print;
	}

	public TurtleNetWorkTurtle(String s) {
		super(s);
		this.print = true;
		cr = new CalculReseau(this);
	}

	public TurtleNetWorkTurtle() {
		super();
		cr = new CalculReseau(this);
	}

	public void setup() {
		playRole("Car");
	}

	public void println(String m) {
		if (print)
			super.println(m);
	}

	public void initialisation() {
		step = 0;
		cycleRecherche = 0;
		cycleArret = 0;
		cycleVadrouille = 0;
		sens = true;
	}

	public void setState(TurtleState ts) {
		state = ts;
		switch (state) {
		case arret:
			setColor(Color.red);
			break;
		case cherche:
			setColor(Color.blue);
			break;
		case versPlace:
			setColor(Color.blue);
			break;
		case vadrouille:
			setColor(Color.green);
			break;
		case attentePlace:
			setColor(Color.blue);
			break;
		}
	}

	/*
	 * Initialisation : si la place choisie au hasard est prise il est en
	 * vadrouille sinon à l'arrêt
	 */
	public String debutStationner() {
		initialisation();
		position = Reseau.getPositionDebut(cr.getArcCourant());
		if(cr.getArcCourant().getOrder()%2==0)
		while (!cr.getArcCourant().isPositionPlace(position))
			position = Reseau.getPositionDebut(cr.getArcCourant());
		
		setXY(cr.getArcCourant().getPositionArc(position).getX(), cr.getArcCourant().getPositionArc(position).getY());
		Place pl = new Place(cr.getArcCourant().getId(), cr.getArcCourant().getPositionArc(position));
		if (Reseau.containPlaceprise(pl)) {
			setState(TurtleState.vadrouille);
		} else {
			Reseau.placeprisedebut.add(pl);
			Reseau.diminuerPlaceArc(cr.getArcCourant());
			placeChoisie = pl;
			changementStationner();
		}
		return ("live");
	}

	/*
	 * initialisation : en appelant cette méthode, l'agent circule au début de
	 * son execution
	 */
	public String debutCirculer() {
		setState(TurtleState.vadrouille); 
		initialisation();
		position = Reseau.getPositionDebut(cr.getArcCourant());
		setXY(cr.getArcCourant().getPositionArc(position).getX(), cr.getArcCourant().getPositionArc(position).getY());
		return "live";
	}

	/*
	 * passe de l'état arret à l'état vadrouille
	 */
	public void changementLiberer() {
		setState(TurtleState.vadrouille); 
		Reseau.libererPlaceArc(cr.getArcCourant());
		placeChoisie = null;
		cycleArret = 0;
		cycleVadrouille = 0;
	}

	/*
	 * passe à l'état arret. sauf pour le premier pas (?) cela ajoute une
	 * demande : on suppose que l'agent venait de faire une demande
	 */
	public void changementStationner() {
		setState(TurtleState.arret);
		AssistantApprocheLocale.incNbMessageCentralise();
		if (step > 1) {
			nbredemande++;
			Reseau.nbreStationnements++;
			Reseau.diminuerPlaceArc(cr.getArcCourant());
			Reseau.setNbredemandes();
			Reseau.setNbreCycleTotalRecherche(cycleRecherche);
		}
		cycleRecherche = 0;
	}

	/*
	 * agent se déplace et choisi son prochain arc. attentePlace => arret (si
	 * placeLibre) vadrouille => cherche si nbreCycle correct
	 */
	public void circuler() {
		if ((cr.getArcCourant().getPositionArc(position).estEgal(cr.getArcCourant().getFin()) && sens)
				|| (cr.getArcCourant().getPositionArc(position).estEgal(cr.getArcCourant().getDebut()) && !sens)) {
			Arc suiv = Reseau.getArcSuivant(cr.getArcCourant(), sens);
			Coordonnees posCoord = cr.getArcCourant().getPositionArc(position);
			if (suiv != null) {
				if (cr.distanceCoord(posCoord, suiv.getDebut()) >= cr.distanceCoord(posCoord, suiv.getFin())) {
					position = 0;
					sens = true;
				} else {
					position = suiv.getNbrePlaces() - 1;
					sens = false;
				}
				cr.setArcCourant(suiv);
			} else {
				sens = !sens;
				System.exit(0);
				
			}
		}
		if (sens){
			position++;
		}
		else {
			position--;
		}
		moveTo(cr.getArcCourant().getPositionArc(position).getX(), cr.getArcCourant().getPositionArc(position).getY());

		switch (state) {
			case attentePlace:{
				if (cr.getArcCourant().isPositionPlace(position)) {
					int stationne = nbreStationnePosition();
					if (stationne == 0) {
						changementStationner();
						Place plstat = new Place(cr.getArcCourant().getId(), cr.getArcCourant().getPositionArc(position));
						placeChoisie = plstat;
					}
				}
				break;
			}
	
			case vadrouille:{
				cycleVadrouille++;
				if (cycleVadrouille > Reseau.nbreCycleVadrouilleMin) {
					//Reseau.nbredemandestotales = Reseau.nbredemandestotales + 1;
					if ((this instanceof AgHorsCommunaute)) Reseau.nbredemandehorscommunaute++;
					else Reseau.nbredemandestotales++;
					
					setState(TurtleState.cherche); 
					cycleVadrouille = 0;
				}
				break;
			}
			
			case cherche:{
				//Reseau.nbreCycleTotalRecherche+=1;
				if (cr.getArcCourant().isPositionPlace(position)) {
					int stationne = nbreStationnePosition();
					if (stationne == 0) {
						if (!(this instanceof AgHorsCommunaute)) {
							changementStationner();
							//Reseau.nbreCycleTotalRecherche+=1;
							placeChoisie = new Place(cr.getArcCourant().getId(), cr.getArcCourant().getPositionArc(position));
						} else {
							Reseau.tempsrecherchehorscommunaute++;
							setState(TurtleState.arret);
						}
					}
				}
				break;
			}
		}
	}

	public boolean avancerplace() {
		boolean memePlaceChoisie = true;// indique si la place prise est celle
										// fixée au début ou pas
		cycleRecherche++;
		
		if(cr.getArcCourant().getPositionArc(position)==null){ 
			System.out.println(position +" ** "+cr.getArcCourant());
			position=0;
		}
			if ((cr.getArcCourant().getPositionArc(position).estEgal(cr.getArcCourant().getFin()) && sens)
				|| (cr.getArcCourant().getPositionArc(position).estEgal(cr.getArcCourant().getDebut()) && !sens)) {
			if (cr.getChemin() != null) {
				if (cr.getChemin().size() != 0) {
					Arc suiv = cr.getChemin().get(0);
					Coordonnees posCoord = cr.getArcCourant().getPositionArc(position);
					if (cr.getArcCourant().getPositionArc(position).estEgal(suiv.getDebut())) {
						position = 0;
						sens = true;
						cr.setArcCourant(suiv);
						cr.getChemin().remove(0);
					}
					else if (cr.getArcCourant().getPositionArc(position).estEgal(suiv.getFin())) {
						position = suiv.getNbrePlaces() - 1;
						sens = false;
						cr.setArcCourant(suiv);
						cr.getChemin().remove(0);
					} else {
						sens = !sens;
					}
				}
			} else {
				if (placeChoisie.getIdArc() == cr.getArcCourant().getId())
					sens = !sens;
			}
		}
		if (sens)
			position++;
		else
			position--;
		if(position==-1)
			position=cr.getArcCourant().getNbrePlaces()-1;
		
		if(cr.getArcCourant().getPositionArc(position)==null){ 
			System.out.println(position +" ** "+cr.getArcCourant());
			position=0;
		}
		moveTo(cr.getArcCourant().getPositionArc(position).getX(), cr.getArcCourant().getPositionArc(position).getY());
		if (cr.getArcCourant().isPositionPlace(position)) {
			int stationne = nbreStationnePosition();
			Place pl = new Place(cr.getArcCourant().getId(), cr.getArcCourant().getPositionArc(position));
			if (stationne == 0) {
				changementStationner();
				if (placeChoisie.getIdArc() == cr.getArcCourant().getId()) {
					Reseau.utiliserSysteme();
				}
				if (placeChoisie.equals(pl)) {
					memePlaceChoisie = true;
				}
				else {
					placeChoisie = pl;
					memePlaceChoisie = false;
				}
			} else if (placeChoisie.equals(pl)) {
				nbrenotif++;
				Reseau.nbrenotification = Reseau.nbrenotification + 1;
				memePlaceChoisie = false;
				setState(TurtleState.cherche);
				//Reseau.nbredemandestotales++;
			}
		}

		return memePlaceChoisie;
	}

	public int nbreStationnePosition() {
		int nbrestationne = 0;
		Turtle[] turtlehere = turtlesHere();
		for (int k = 0; k < turtlehere.length; k++) {
			if (((TurtleNetWorkTurtle) (turtlehere[k])).state == TurtleState.arret) {
				nbrestationne++;
			}
		}
		return nbrestationne;
	}

	public void checkKill(){
		if(step>Reseau.simTime/4){
			TurtleNetWorkTurtle al;
			int ran =(int) (Math.round(Math.random()));
			if(this instanceof AssistantApprocheLocale){
				if(ran<1)
					al= (AssistantApprocheLocale)new AssistantApprocheLocale("debutStationner");
				else
					al= (AssistantApprocheLocale)new AssistantApprocheLocale("debutCirculer");
			}
			else {
				if(ran<1)
					al= (AgHorsCommunaute) new AgHorsCommunaute("lancement");
				else
					al= (AgHorsCommunaute) new AgHorsCommunaute("lancementb");
			}
			println("BYE BYE");		
			this.createTurtle(al);
			this.killAgent(this);
	 	}
	}
	
	/*
	 * public void end() { if(Reseau.getNbredemandes()!=0) {
	 * println("nbre de recherche est "+Reseau.getNbredemandes());
	 * println("le nbre de cycle totale de recherche est: "
	 * +Reseau.getNbreCycleTotalRecherche());
	 * println("le nbre de cycle moyen de recherche: "
	 * +Reseau.tempsMoyenRecherche());
	 * println("le taux d'utlisation du systeme est: "
	 * +Reseau.tauxUtilisationSysteme()+"%");
	 * println("le nbre de demande de cet ag est: "+nbredemande);
	 * println("le tnbretotal de de recherches: "
	 * +Reseau.nbredemandestotales+"et le le nbe de trouvaille de places est: "
	 * +Reseau
	 * .getNbredemandes()+" et le nebre d utilisation systeme est :"+Reseau
	 * .getUtilisationSysteme()); }
	 * println("le nbre de notif de cet ag est: "+nbrenotif
	 * +", et le total est "+Reseau.nbrenotification); }
	 */
}
