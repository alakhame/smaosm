package approche.globale.turtles;


import java.util.ArrayList;
import approche.globale.utils.*;
import network.structure.*;
import network.turtles.TurtleNetWorkTurtle;
import network.turtles.TurtleState;
import madkit.kernel.AgentAddress;
import madkit.kernel.Message;
import madkit.messages.ACLMessage;

public class AssistantApprocheGlobale extends TurtleNetWorkTurtle {

	private static final long serialVersionUID = 1L;
	AgentAddress AddAgStationnement; //Adresse de l'agent Stationnement
	public AssistantApprocheGlobale(){
		super();
	}
	public AssistantApprocheGlobale(String s){
		super(s);
	}
	public AssistantApprocheGlobale(String s, boolean print){
		super(s,print);
	}

	public void setup(){
		playRole("Assistant");
	}

	public void envoyer(AgentAddress ag, ACLMessage m){
		println("envoi :" +m.getAct());
		sendMessage(AddAgStationnement,m);
	}

	public void libererPlace(){
		//println("methode liberer place");
		ACLMessage msg=new ACLMessage("liberer_place");
		msg.setField("place", placeChoisie);
		envoyer(AddAgStationnement,msg);
		changementLiberer();
	}
	public void DemandePlace(){
		ACLMessage m=new ACLMessage("demande_places_libres");
		//demande de places libres avec nbreMaxPlace=3;
		Demande d=new Demande(cr.getArcCourant(),10);
		d.setPosition(cr.getArcCourant().getPositionArc(position));
		d.setSensDeplacement(sens);
		m.setField("demande_places_libres", d);
		envoyer(AddAgStationnement,m);
		setState(TurtleState.attentePlace);//etat=4;
	}

	public ArrayList<StructureItineraire> itineraireListe(ArrayList<Place> liste){
		ArrayList<StructureItineraire> it =new ArrayList<StructureItineraire>();
		cr.setPrecedent(new Arc[Reseau.getNbreArc()]);
		cr.plusCourtChemin();
		for(int i=0;i<liste.size();i++){
			StructureItineraire s=new StructureItineraire();
			double dist;
			s.setPlace(liste.get(i));
			cr.getChemin(Reseau.getArc(liste.get(i).getIdArc()), cr.getArcCourant());
			dist=cr.distanceChemin(Reseau.getArc(liste.get(i).getIdArc()),liste.get(i), cr.getChemin());
			s.setDist(dist);
			int nbcycle=(int)(dist/5);
			s.setNbreCycle(nbcycle+Reseau.getStep()+3);
			it.add(s);
		}
		return it;
	}
	private void stationnerAvancerPlace(boolean resultat){
		ACLMessage mst;
		if(resultat && (state==TurtleState.arret)){//(etat==0))
			//println("place libre et occupation");
			mst=new ACLMessage("liberer_place");
			mst.setField("place", placeChoisie);
			envoyer(AddAgStationnement,mst);
		}else if((!resultat) && (state==TurtleState.cherche)){//(etat==1))
			//println("place occupee");
			mst =new ACLMessage("notification");
			mst.setField("place",placeChoisie);
			envoyer(AddAgStationnement, mst);
			placeChoisie=null;
		}else if((!resultat) && (state==TurtleState.arret)){//(etat==0))
			mst=new ACLMessage("AnnulationPrereservation");
			mst.setField("place", placeChoisie);
			envoyer(AddAgStationnement, mst);
		}
	}

	public void EnvoiPlacesPreferences(Message m){
		if (m instanceof ACLMessage){
			ReponseDemande rep =(ReponseDemande)(((ACLMessage) m).getFieldValue("envoi_places_libres"));
			ArrayList<StructureItineraire> preferences=new ArrayList<StructureItineraire>();
			/*
			 * Affichage des places reçues
			 */
			println("places reçues pour ma position" + this.position + "sur arc " + cr.getArcCourant());
			println(rep.toString());
			
			ArrayList<StructureItineraire> itineraire =itineraireListe(rep.getListePlaceLibre());
			//classer les places selon les preferences
			while(itineraire.size()>=1)	{
				int min =0;
				for(int j=1;j<itineraire.size();j++)
					if(itineraire.get(j).getDist()<itineraire.get(min).getDist())
						min=j;
				preferences.add(itineraire.get(min));
				itineraire.remove(min);
			}
			/*
			 * Affichage de la place choisie
			 */
			
			if (print){
				println("place possible : ");
				AgStationnement.afficherEtatStationnement();
				println("places choisies");
				for (StructureItineraire si : preferences)
				println(si.toString());
			}

			//envoi msg au service de stationnement
			ACLMessage pref=new ACLMessage("renvoi_places_preferences");
			pref.setField("preference", preferences);
			envoyer(AddAgStationnement, pref);
			//il commence à avancer vers la place preferée
			// placeChoisie=preferences.get(0).getPlace();
			/*
			 * pour pallier le pb de décallage du asynchrone.
			 */
		StructureItineraire st=AgStationnement.getPlaceLibre(preferences);
			if(st!=null){
				placeChoisie=st.getPlace();
				println("je devrais avoir : " + placeChoisie);
				setState(TurtleState.versPlace);//etat=2;
				if(cr.getArcCourant().isPositionPlace(position)){
					int stationne=nbreStationnePosition();
					if(stationne==0){
						changementStationner();
						if(placeChoisie.getIdArc()==cr.getArcCourant().getId())
							Reseau.utiliserSysteme();
						Place pl=new Place(cr.getArcCourant().getId(),cr.getArcCourant().getPositionArc(position));
						if(placeChoisie.equals(pl))
							stationnerAvancerPlace(true);
						else{
							placeChoisie=pl;
							stationnerAvancerPlace(false);
						}
					}
				}
				if(state== TurtleState.versPlace){//(etat==2)
					cycleRecherche--;
					directionPlaceChoisie();
					boolean resavancer=avancerplace();
					if (state == TurtleState.arret)//(etat==0)
						stationnerAvancerPlace(resavancer);
				}
			}else
				setState(TurtleState.cherche);//etat=1;
		}
	}
	void handleMessage(Message m){
		if (m instanceof ACLMessage){
			String act = ((ACLMessage) m).getAct().toLowerCase(); 
			println("message : " + act);
			if(act.equalsIgnoreCase("envoi_places_libres")){
				EnvoiPlacesPreferences(m);
			}else if(act.equalsIgnoreCase("echec_prereservation")){
				setState(TurtleState.cherche);//etat=1;
			}else if(act.equalsIgnoreCase("echec")&& (state == TurtleState.attentePlace)){//(etat==4))//pas de places libres
				setState(TurtleState.cherche);//etat=1;
			}else if(act.equalsIgnoreCase("notification")){
				placeChoisie=(Place)(((ACLMessage) m).getFieldValue("autreplace"));
				directionPlaceChoisie();
				setState(TurtleState.versPlace);//etat=2;
			}else  if(act.equalsIgnoreCase("placeechec")){
				placeChoisie=(Place)((ACLMessage) m).getFieldValue("place");
				directionPlaceChoisie();
				setState(TurtleState.versPlace);//etat=2;
			}
		}
	}
	public void directionPlaceChoisie()	{
		println("j'ai obtenu : " + placeChoisie);
		if(placeChoisie.getIdArc()!=cr.getArcCourant().getId())	{
			cr.plusCourtChemin();
			cr.getChemin(Reseau.getArc(placeChoisie.getIdArc()), cr.getArcCourant());
			if(cr.getChemin().size()!=0){
				Arc asui=cr.getChemin().get(0);
				if(!((sens &&((cr.getArcCourant().getFin().estEgal(asui.getDebut()))||(cr.getArcCourant().getFin().estEgal(asui.getFin()))))||(!sens && ((cr.getArcCourant().getDebut().estEgal(asui.getFin()))||(cr.getArcCourant().getDebut().estEgal(asui.getDebut()))))))
					sens=!sens;
			}
		}else{
			cr.setChemin(new ArrayList<Arc>());
			if(((placeChoisie.getCoordonnees().getX()<cr.getArcCourant().getPositionArc(position).getX())||
					(placeChoisie.getCoordonnees().getY()<cr.getArcCourant().getPositionArc(position).getY()))&&sens)
				sens=false;
			else if(((placeChoisie.getCoordonnees().getX()>cr.getArcCourant().getPositionArc(position).getX())||
					(placeChoisie.getCoordonnees().getY()>cr.getArcCourant().getPositionArc(position).getY()))&& !sens)
				sens=true;		 
		}
	}
	public String live(){
		step++;
		if(step==1)	{
			AddAgStationnement = getAgentWithRole("Stationnement","Gerant","GererStationnement");
			requestRole("Stationnement","Gerant","member",null);
		}

		if(Reseau.getStep()<step)
			Reseau.setStep(step);
		switch (state) {
		case arret :{//if(etat==0)//stationné			
			if(cycleArret>=Reseau.nbreCycleOccupationPlace) {
				libererPlace();
			}else {
				cycleArret++;
			}	 
			break;
		}
		case cherche : {// if(etat==1)//en recherche d'une place
			cycleRecherche++;
			while(!isMessageBoxEmpty()){
				Message m=nextMessage();
				handleMessage(m);
			}
			// setColor(Color.blue);
			if (state == TurtleState.versPlace){ //if(etat==2)
				cycleRecherche--;
				boolean res=avancerplace();
				if ((state == TurtleState.arret) || (state == TurtleState.cherche))//((etat==0)||(etat==1))
					stationnerAvancerPlace(res);
			}else{
				circuler();
				if (state == TurtleState.arret){//if(etat==0)
					ACLMessage msg=new ACLMessage("InformerPrisePlace");
					//Place plste=new Place(arcCourant.getId(),arcCourant.getPositionArc(position));
					msg.setField("place",placeChoisie);
					envoyer(AddAgStationnement, msg);
				} else {
					DemandePlace();
					setState(TurtleState.attentePlace);//etat=4;
				}
			}// fin if (state == TurtleState.versPlace)
			break;
		}
		case versPlace : {//else if(etat==2)//trouver une place et avancer vers elle
			while(!isMessageBoxEmpty())	{
				Message m=nextMessage();
				handleMessage(m);
			}
			if (state == TurtleState.versPlace){ //(etat==2){
				boolean res=avancerplace();
				if ((state == TurtleState.arret) || (state == TurtleState.cherche))//((etat==0)||(etat==1))
					stationnerAvancerPlace(res);
			}else if (state == TurtleState.cherche){//(etat==1){
				circuler();
				if (state == TurtleState.arret){//(etat==0)
					ACLMessage msg=new ACLMessage("InformerPrisePlace");
					//Place plste=new Place(arcCourant.getId(),arcCourant.getPositionArc(position));
					msg.setField("place",placeChoisie);
					envoyer(AddAgStationnement, msg);
				}else{
					DemandePlace();
					setState(TurtleState.attentePlace);//etat=4;
				}
			}
			break;
		}
		case vadrouille : {//else if(etat==3)//circule seulement
			while(!isMessageBoxEmpty())	
				nextMessage();
			//Message msgeffac=nextMessage();
			//!!!setColor(Color.green);
			circuler();
			break;
		}
		case attentePlace : { //else if(etat==4)//recherche et attente de reponse de l'agent Stationnement
			cycleRecherche++;
			//lecture des messages
			while(!isMessageBoxEmpty())	{
				Message m=nextMessage();
				handleMessage(m);
			}
			if (state == TurtleState.attentePlace){//(etat==4)
				circuler();
				if (state == TurtleState.arret){//(etat==0)	{
					println("fauuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuux");
					println("ds live agassistant:envoi msg annulation demande grace a circuler en attente de reponse");
					ACLMessage m=new ACLMessage("AnnulationDemande");
					m.setField("place", placeChoisie);
					envoyer(AddAgStationnement, m);
					Reseau.annulerdemande();
				}
			}	
		}
		}// fin switch
		println(step + ":" + state);
		return "live";
	}

}
