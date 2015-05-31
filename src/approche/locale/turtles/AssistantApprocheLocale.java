package approche.locale.turtles;

import java.util.ArrayList;

import network.structure.*;
import network.turtles.TurtleNetWorkTurtle;
import network.turtles.TurtleState;
import network.structure.PlaceLiberee;
import network.structure.Place;
import network.structure.Reseau;
import turtlekit.kernel.Turtle;
import madkit.messages.ACLMessage;

public class AssistantApprocheLocale extends TurtleNetWorkTurtle {
	public static int range ;
	private static final long serialVersionUID = 1L;
	private ArrayList<PlaceLiberee> listePlaces;
	public static int nbMessageCentralise = 0;
	private ArrayList<PlaceLiberee> listenoire = new ArrayList<PlaceLiberee>();
	boolean placeGivenByCentralAgent=false;

	public static void incNbMessageCentralise() {
		nbMessageCentralise++;
	}

	public AssistantApprocheLocale(String s) {
		super(s);
		listePlaces = new ArrayList<PlaceLiberee>();
		this.placeChoisie = null;
	}

	public AssistantApprocheLocale() {
		super();
	}

	public AssistantApprocheLocale(String string, boolean b) {
		super(string);
		print = b;
	}

	public AssistantApprocheLocale(String s, int temps) {
		super(s);
		listePlaces = new ArrayList<PlaceLiberee>();
		this.placeChoisie = null;

	}

	public void setListePlaces(ArrayList<PlaceLiberee> listePlaces) {
		this.listePlaces = listePlaces;
	}

	public ArrayList<PlaceLiberee> getListePlaces() {
		return listePlaces;
	}

	// ajouter une place dans la liste, en vérifiant son existance
	private void ajoutPlace(PlaceLiberee p) {
		if (!listePlaces.contains(p)) {
			if (listePlaces.size() != 0) {
				boolean existe = false;
				int i = 0;
				while ((!existe) && (i < listePlaces.size())) {
					if (p.getPlace().getCoordonnees().estEgal(listePlaces.get(i).getPlace().getCoordonnees()))
						existe = true;
					else
						i++;
				}
				if (existe) {
					int stepnouv = p.getDate();
					int stepancien = listePlaces.get(i).getDate();
					if (stepnouv > stepancien) {
						listePlaces.remove(i);
						listePlaces.add(p);
					}
				} else
					listePlaces.add(p);
			} else
				listePlaces.add(p);
		}
	}

	
	private ArrayList<Turtle> vehiculesVoisins() {
		ArrayList<Turtle> voisins = new ArrayList<Turtle>();

		Turtle[] vehiculesVoisins;
		vehiculesVoisins = turtlesHere();
		for (int k = 0; k < vehiculesVoisins.length; k++) {
			if (vehiculesVoisins[k] instanceof AssistantApprocheLocale) {
				if (((AssistantApprocheLocale) (vehiculesVoisins[k])).state != TurtleState.arret)
					voisins.add(vehiculesVoisins[k]);
			}
		}
		for (int j = -range; j <= range; j++)
			for (int s = -range; s <= range; s++) {
				if ((j != 0) && (s != 0))
					vehiculesVoisins = turtlesAt(cr.getArcCourant().getPositionArc(position).getX()
							+ j, cr.getArcCourant().getPositionArc(position).getY() + s);
				for (int k = 0; k < vehiculesVoisins.length; k++) {
					if (vehiculesVoisins[k] instanceof AssistantApprocheLocale) {
						if (((AssistantApprocheLocale) (vehiculesVoisins[k])).state != TurtleState.arret)
							voisins.add(vehiculesVoisins[k]);
					}
				}
			}
		if (voisins.contains(this))
			voisins.remove(this);
		return voisins;
	}

	// éliminer les places de la liste des places libérées après un certain
	// temps
	private void VerificationListe() {
		for (int j = 0; j < listePlaces.size(); j++) {
			if (listePlaces.get(j).getDate() > Reseau.tempsGardeinfHP)
				listePlaces.remove(j);
		}
	}

	private void verificationListeNoire() {
		for (int j = 0; j < listenoire.size(); j++) {
			if (listenoire.get(j).getDate() > Reseau.tempsGardeinLN) {
				listenoire.remove(j);
			}
		}
	}

	// diffuser la liste des places au près des véhicules voisins
	public void diffuser() {
		if (listePlaces.size() != 0)
			VerificationListe();
		if (listenoire.size() != 0)
			verificationListeNoire();
		ArrayList<Turtle> voisins = vehiculesVoisins();
		println("IN BROADCAST -- sending "+voisins.size()+" msg -- nb places : "+listePlaces.size());
		if ((listePlaces.size() != 0) && (voisins.size() != 0)) {
			// diffuser l'informaion de la libération de la place au près des
			// autres vehicules voisins
			ACLMessage msg = new ACLMessage("listeplaces");
			msg.setField("liste", listePlaces);
			msg.setField("listenoire", listenoire);
			
			for (int i = 0; i < voisins.size(); i++)
				if (((AssistantApprocheLocale) (voisins.get(i))).state != TurtleState.arret) {
					sendMessage(voisins.get(i).getAddress(), msg);
					Reseau.nbremessageechanges = Reseau.nbremessageechanges + 1;
				}
		}
	}

	// methode qui permet de chercher une place selon le critère de distance
	public void recherchePlace() {
		PlaceLiberee pl;
		
		/*********** for logging *******************/
//		println(" Recherche place ****");
//		println(" ++ Liste Blanche");
//		println(listePlaces.toString());
//		println(" -- Liste Noire");
//		println(listenoire.toString());
		/*********** end logging ******************/
		if (listePlaces.size() != 0) {
			pl = listePlaces.get(0);
			placeChoisie = pl.getPlace();
			ArrayList<Arc> ch1;
			if (listePlaces.size() > 1) {
				cr.plusCourtChemin();
				cr.getChemin(Reseau.getArc(placeChoisie.getIdArc()),cr.getArcCourant());
				double d, d1;
				ch1 = cr.getChemin();
				d = cr.distanceChemin(Reseau.getArc(placeChoisie.getIdArc()),placeChoisie, ch1);
				for (int i = 1; i < listePlaces.size(); i++) {
					cr.plusCourtChemin();
					cr.getChemin(
							Reseau.getArc(listePlaces.get(i).getPlace().getIdArc()), cr.getArcCourant());
					d1 = cr.distanceChemin(Reseau.getArc(listePlaces.get(i).getPlace().getIdArc()),
											listePlaces.get(i).getPlace(), cr.getChemin());
					if (d1 < d) {
						pl = listePlaces.get(i);
						placeChoisie = pl.getPlace();
						d = d1;
						ch1 = cr.getChemin();
					}
				}
				// chemin=ch1;
			}
			if (listePlaces.contains(pl))
				listePlaces.remove(pl);
		}

	}

	private void libererPlace() {
		
		PlaceLiberee placelib = new PlaceLiberee();
		placelib.setDate(step);
		placelib.setPlace(new Place(cr.getArcCourant().getId(), cr.getArcCourant().getPositionArc(position)));
		listenoire.remove(placelib);
		ajoutPlace(placelib);
		println(" I'm leaving a new place ("+listePlaces+") -- ( "+xcor()+" , "+ ycor() +" )" );
		
		changementLiberer();
	}

	// methode qui traite une liste LN d'un autre agent
	private void traitementLNRecu(ArrayList<PlaceLiberee> lnb) {
		int ind;
		for (PlaceLiberee pl : lnb) {
			if (listePlaces.contains(pl)) {
				ind = listePlaces.indexOf(pl);
				if (listePlaces.get(ind).getDate() < pl.getDate()) {
					listePlaces.remove(ind);
					listenoire.add(pl);
				}
			} else
				ajoutPlaceLN(pl);
		}
	}

	// methode qui traite une liste LP d'un autre agent
	private void traitementLPRecu(ArrayList<PlaceLiberee> lpb) {
		int ind;
		for (PlaceLiberee plb : lpb) {
			if (listenoire.contains(plb)) {
				ind = listenoire.indexOf(plb);
				if (plb.getDate() >= listenoire.get(ind).getDate()) {
					listenoire.remove(plb);
					ajoutPlace(plb);
				}
			} else
				ajoutPlace(plb);
		}
	}

	// ajout d'une place ds LN en vérifiant son existance
	private void ajoutPlaceLN(PlaceLiberee plocc) {
		if (listenoire.contains(plocc)) {
			int ind = listenoire.indexOf(plocc);
			if (listenoire.get(ind).getDate() < plocc.getDate()) {
				(listenoire.get(ind)).setDate(plocc.getDate());

			}
		} else
			listenoire.add(plocc);
	}

	// traitement des messages
	@SuppressWarnings("unchecked")
	public void handleMessage() {
		 while (!isMessageBoxEmpty()) {
			ACLMessage m = (ACLMessage) nextMessage();

			/*********** for logging *******************/
			println(" I've got some info from   " + m.getSender().toString());
			/*********** end logging ******************/
			if (m.getAct().equalsIgnoreCase("listeplaces")) {
				traitementLPRecu((ArrayList<PlaceLiberee>) (m.getFieldValue("liste")));
				traitementLNRecu((ArrayList<PlaceLiberee>) (m.getFieldValue("listenoire")));
			}
		}
	}

	// comportement de l'agent
	public String live() {
		step++;
		if (step == 1)
			listePlaces = new ArrayList<PlaceLiberee>();

		if (Reseau.getStep() < step) {
			/*********** for logging *******************/

			/*********** end logging ******************/
			Reseau.setStep(step);
			Reseau.nbrePlaceLibresCycle.add(Reseau.getNbrePlacelibreReseau());
			if ((state == TurtleState.cherche) || (state == TurtleState.versPlace))
				Reseau.nbreRechCycle.add(new Integer(1));
			else
				Reseau.nbreRechCycle.add(new Integer(0));
			if (state == TurtleState.vadrouille)
				Reseau.nbreCirCycle.add(new Integer(1));
			else
				Reseau.nbreCirCycle.add(new Integer(0));
			if (state == TurtleState.arret)
				Reseau.nbreStatCycle.add(new Integer(1));
			else
				Reseau.nbreStatCycle.add(new Integer(0));
		} else if (Reseau.getStep() == step) {
			/*********** for logging *******************/

			/*********** end logging ******************/
			Reseau.nbreAppels++;
			if ((state == TurtleState.cherche)
					|| (state == TurtleState.versPlace)) {
				int s = Reseau.nbreRechCycle.size() - 1;
				int rech = Reseau.nbreRechCycle.get(s).intValue();
				rech++;
				Reseau.nbreRechCycle.remove(s);
				Reseau.nbreRechCycle.add(rech);
			} else if (state == TurtleState.arret) {
				int s = Reseau.nbreStatCycle.size() - 1;
				int rech = Reseau.nbreStatCycle.get(s).intValue();
				rech++;
				Reseau.nbreStatCycle.remove(s);
				Reseau.nbreStatCycle.add(rech);
				
			} else if (state == TurtleState.vadrouille) {
				int s = Reseau.nbreCirCycle.size() - 1;
				int rech = Reseau.nbreCirCycle.get(s).intValue();
				rech++;
				Reseau.nbreCirCycle.remove(s);
				Reseau.nbreCirCycle.add(rech);
			}

			if (Reseau.nbreAppels == Reseau.nbreAgCommunaute) {
				Reseau.nbreAppels = 1;
			}
		}
		
		 
		switch (state) {
		case arret: {
			if(cycleArret>=Reseau.nbreCycleOccupationPlace) {
				/*********** for logging   *******************/
				 
				/*********** end logging  ******************/
				 libererPlace();
				 diffuser();
			  	incNbMessageCentralise();
				
				/*********** for logging   *******************/
				
				 
				/*********** end logging  ******************/
				//this.checkKill();
				 
			} else {
				cycleArret++;
			}
			break;
		}
		case cherche: {
			placeChoisie = null;
			handleMessage();
			if(!placeGivenByCentralAgent){
				incNbMessageCentralise();incNbMessageCentralise();
				placeGivenByCentralAgent=true;
			}
			if (listePlaces.size() != 0) {
				// VerificationListe();
				/*********** for logging *******************/

				println(" searching for a new place among "+ listePlaces.toString());

				/*********** end logging ******************/
				recherchePlace();
			}

			if (placeChoisie != null) {
				/*********** for logging *******************/

				println(" I found a place to go at  -- "+ placeChoisie.getCoordonnees().toString());

				/*********** end logging ******************/

				
				if (placeChoisie.getIdArc() != cr.getArcCourant().getId()) {
					cr.setPrecedent(new Arc[Reseau.getNbreArc()]);
					cr.plusCourtChemin();
					cr.getChemin(Reseau.getArc(placeChoisie.getIdArc()),cr.getArcCourant());
					if (cr.getChemin() != null) {
						if (cr.getChemin().size() == 1) {
							if ((cr.getArcCourant().getDebut().estEgal(Reseau.getArc(placeChoisie.getIdArc()).getDebut()))
									||(cr.getArcCourant().getDebut().estEgal(Reseau.getArc(placeChoisie.getIdArc()).getFin()))) {
								if (sens) {
									sens = false;
								}
							} else if ((cr.getArcCourant().getFin().estEgal(Reseau.getArc(placeChoisie.getIdArc()).getDebut()))
										|| (cr.getArcCourant().getFin().estEgal(Reseau.getArc(placeChoisie.getIdArc()).getFin()))) {
								if (!sens) {
									sens = true;
								}
							}else{
								sens=true;
							}
						} else if (cr.getChemin().size() > 1) {
							if ((cr.getArcCourant().getDebut().estEgal((cr.getChemin().get(0)).getDebut()))
									|| (cr.getArcCourant().getDebut().estEgal((cr.getChemin().get(0)).getFin()))) {
								if (sens) {
									sens = false; 
								}
							} else if ((cr.getArcCourant().getFin().estEgal((cr.getChemin().get(0)).getDebut()))
										|| (cr.getArcCourant().getFin().estEgal((cr.getChemin().get(0)).getFin()))) {
								if (!sens) {
									sens = true;
								}
							}else{
								sens=true;
							}
						}
					}
				} else {
					cr.setChemin(null);
					if (((placeChoisie.getCoordonnees().getX()- cr.getArcCourant().getPositionArc(position).getX() < 0) && sens)
							|| ((placeChoisie.getCoordonnees().getY() - cr.getArcCourant().getPositionArc(position).getY() < 0) && sens)) {
						sens = false;
					} else if (((placeChoisie.getCoordonnees().getX()- cr.getArcCourant().getPositionArc(position).getX() > 0) && (!sens))
							|| ((placeChoisie.getCoordonnees().getY()- cr.getArcCourant().getPositionArc(position).getY() > 0) && (!sens))) {
						sens = true;
					}

				}
				setState(TurtleState.versPlace);
				if (cr.getArcCourant().isPositionPlace(position)) {
					int stationne = nbreStationnePosition();
					if (stationne == 0) {
						placeGivenByCentralAgent=false;
						changementStationner();
						if (placeChoisie.getIdArc() == cr.getArcCourant().getId())
							Reseau.utiliserSysteme();
					} else 
					if (placeChoisie.getCoordonnees().estEgal(cr.getArcCourant().getPositionArc(position))) {
						setState(TurtleState.cherche);
						//incNbMessageCentralise();
						placeGivenByCentralAgent=false;
						if (listenoire == null)
							listenoire = new ArrayList<PlaceLiberee>();
						PlaceLiberee placeoccup = new PlaceLiberee();
						placeoccup.setDate(step);
						placeoccup.setPlace(placeChoisie);
						ajoutPlaceLN(placeoccup);
						placeChoisie = null;
					}
				}
				if (state == TurtleState.versPlace) {
					avancerplace();
					if (state == TurtleState.cherche) {
						PlaceLiberee placeoccup = new PlaceLiberee();
						//incNbMessageCentralise();
						placeGivenByCentralAgent=false;
						placeoccup.setDate(step);
						placeoccup.setPlace(placeChoisie);
						placeChoisie = null;
						ajoutPlaceLN(placeoccup);
					}
				} else if (state == TurtleState.cherche) {
					circuler();
				}

				if (state != TurtleState.arret)
					diffuser();
					/*********** for logging *******************/
					println(" I'm sending some informations ****");
//					println(" ++ Liste Blanche");
//					println(listePlaces.toString());
//					println(" -- Liste Noire");
//					println(listenoire.toString());
					/*********** end logging ******************/
			
			} else {
				cycleRecherche++;
				//incNbMessageCentralise();
				if (cr.getArcCourant().isPositionPlace(position)) {
					int stationne = nbreStationnePosition();
					if (stationne == 0){
						changementStationner();placeGivenByCentralAgent=false;
					}
				}
				if (state != TurtleState.arret)
					circuler();
				if (state != TurtleState.arret)
					diffuser();
			}
			break;
		}

		case versPlace: {
			// else if(etat==2)
			avancerplace();
			if (state != TurtleState.arret)
				diffuser();
			if (state == TurtleState.cherche) {
				//incNbMessageCentralise();
				placeGivenByCentralAgent=false;
				Reseau.utiliserSysteme();
				PlaceLiberee placeoccup = new PlaceLiberee();
				placeoccup.setDate(step);
				placeoccup.setPlace(placeChoisie);
				placeChoisie = null;
				listenoire.add(placeoccup);
			}
			break;
		}
		default: {
			boolean vadrouilleToCherche=false;
			handleMessage();
			diffuser();
			circuler();
			if (state == TurtleState.arret) {// if(etat==0)
				Reseau.tempsrecherchehorscommunaute +=1;
				changementStationner();placeGivenByCentralAgent=false;
			}else if(state == TurtleState.cherche){
				vadrouilleToCherche=true;
			}
			
			if(vadrouilleToCherche){
				Reseau.nbredemandestotales++;
			}
			// etat=3 circuler
			// setColor(Color.green);
			 break;
		}
		} // fin du switch.
			// println(step + ":" + state);
		return "live";
	}

	/*public void end() {
	
		 * println("nbre de recherche est "+Reseau.getNbredemandes());
		 * println("le nbre de cycle totale de recherche est: "
		 * +Reseau.getNbreCycleTotalRecherche());
		 * println("le nbre de cycle moyen de recherche: "
		 * +Reseau.tempsMoyenRecherche()); if(Reseau.getNbredemandes()!=0)
		 * println
		 * ("le taux d'utlisation du systeme est: "+Reseau.tauxUtilisationSysteme
		 * ()+"%");
	}*/
}
