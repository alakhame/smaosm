package approche.globale.turtles;

import madkit.kernel.*;
import madkit.messages.ACLMessage;
import madkit.kernel.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import approche.globale.utils.*;
import turtlekit.kernel.Turtle;
import network.structure.*;


public class AgStationnement extends Turtle {

	private static final long serialVersionUID = 1L;
	String myCommunity="Stationnement";
	String myGroup="Gerant"; 
	String myRole="GererStationnement"; 
	ArrayList<ACLMessage> listeDemandes,listePreferences;
	ArrayList<PreReservation> listePreReservation;
	//TraitementMessage traitementMessage;
	HashMap<AgentAddress, Integer> bonus;
	static HashMap<Place,String> listePlace;


	public String initialisation()	{
		// créer un gpe non distribué
		createGroup(true,myCommunity, myGroup, null, null);
		requestRole(myCommunity,myGroup,myRole,null);
		//instancier les listes
		listeDemandes= new ArrayList<ACLMessage>();
		listePreferences= new ArrayList<ACLMessage>();
		listePreReservation= new ArrayList<PreReservation>();
		bonus =new HashMap<AgentAddress, Integer>();
		listePlace=new HashMap<Place,String>();
		return "live";
	}


	public AgStationnement(){
		super();
	}
	public AgStationnement(String s){
		super(s);
	}

	public void setup() {
		setHidden(true);
	} 
	public void classementMessageEntrant()	{
		while(!isMessageBoxEmpty())		{
			Message m= nextMessage();
			if(m instanceof ACLMessage)
				this.handleMessage(m);
		}
	}


	void handleMessage(Message m) {
		//Traitement des message selon leur type

		if (m instanceof ACLMessage){
			String act = ((ACLMessage)m).getAct().toLowerCase();
			//			System.out.println("gp : " + act +" de " +m.getSender().getName());
			//Message de demande de places libres
			if(act.equalsIgnoreCase("demande_places_libres")){
				//synchronized(listeDemandes)
				listeDemandes.add((ACLMessage)m);
				if(bonus.containsKey(m.getSender())){
					int b=(bonus.get(m.getSender())).intValue();
					b=b-1;
					bonus.put(m.getSender(), new Integer(b));
				}else{
					bonus.put(m.getSender(), new Integer(-1));
				}
			}
			//Message de renvoi de places classées selon les préférences de l'assistant
			else if(act.equalsIgnoreCase("renvoi_places_preferences")){
				if(listePreferences.equals(null))
					listePreferences=new ArrayList<ACLMessage>();
				listePreferences.add((ACLMessage)m);
			}
			//message de liberation d'une place
			else if(act.equalsIgnoreCase("liberer_place")){
				Place placeliberee=(Place)(((ACLMessage) m).getFieldValue("place"));
				Arc arcplace=Reseau.getArc(placeliberee.getIdArc());
				//mettre a jour le nbre de places libres sur un arc

				Reseau.libererPlaceArc(arcplace);
				//ajoutPlace(placeliberee, "libre");
				//synchronized (listePlace) 
				//{
				listePlace.put(placeliberee, "libre");
				//}

				//mise à jour du bonus
				if(bonus.containsKey(m.getSender())){
					int b=(bonus.get(m.getSender()));
					b=b+2;
					bonus.put(m.getSender(), new Integer(b));
				}else
					bonus.put(m.getSender(), new Integer(2));
			}else if(act.equalsIgnoreCase("AnnulationDemande")){
				boolean trouverdemande=false;
				int f=0;
				Place placeoccup=(Place)(((ACLMessage) m).getFieldValue("place"));

				Arc arcplace=Reseau.getArc(placeoccup.getIdArc());
				listePlace.put(placeoccup, "occupee");

				Reseau.diminuerPlaceArc(arcplace);
				if(!listeDemandes.isEmpty()){
					while((!trouverdemande)&&(f<listeDemandes.size()))
						if(listeDemandes.get(f).getSender().equals(m.getSender()))
							trouverdemande=true;
						else
							f++;
				}
				if(trouverdemande){
					listeDemandes.remove(f);
				}else{
					int g=0;
					if((listePreferences != null)&&(!listePreferences.isEmpty())){
						while(((!trouverdemande)&&(g<listePreferences.size()))&&(listePreferences.get(g)!=null))
							if(listePreferences.get(g).getSender().equals(m.getSender()))
								trouverdemande=true;
							else
								g++;
						if(trouverdemande){
							listePreferences.remove(g);
						}
					}
					if(!trouverdemande)	{
						int t=0;
						if(!listePreReservation.isEmpty()){
							while((!trouverdemande)&&(t<listePreReservation.size())){
								if(listePreReservation.get(t).getAdresse().equals(m.getSender()))
									trouverdemande=true;
								else
									t++;
							}
							if(trouverdemande){
								Reseau.libererPlaceArc(Reseau.getArc(listePreReservation.get(t).getPlaceReservee().getIdArc()));
								if(listePlace.get(listePreReservation.get(t).getPlaceReservee()).equals("prereserve"))
									listePlace.put(listePreReservation.get(t).getPlaceReservee(), "libre");
								listePreReservation.remove(t);
							}
						}
					}
				}

			}else if(act.equalsIgnoreCase("AnnulationPrereservation")){
				int q=0;
				Place placeoccup=(Place)(((ACLMessage) m).getFieldValue("place"));
				Arc arcplace=Reseau.getArc(placeoccup.getIdArc());
				listePlace.put(placeoccup, "occupee");
				Reseau.diminuerPlaceArc(arcplace);
				boolean trouverprereservation=false;
				while((!trouverprereservation)&&(q<listePreReservation.size()))
					if(listePreReservation.get(q).getAdresse().equals(m.getSender()))
						trouverprereservation=true;
					else
						q++;
				if(trouverprereservation){
					println("xxxxxxxxxxxxxxxxxxxx");
					Reseau.libererPlaceArc(Reseau.getArc(listePreReservation.get(q).getPlaceReservee().getIdArc()));
					if(listePlace.get(listePreReservation.get(q).getPlaceReservee()).equals("prereserve"))
						listePlace.put(listePreReservation.get(q).getPlaceReservee(), "libre");
					listePreReservation.remove(q);
				}			
			}else if(act.equalsIgnoreCase("InformerPrisePlace")){

				Place placeinf=(Place)(((ACLMessage) m).getFieldValue("place"));
				listePlace.put(placeinf, "occupee");
				Arc arcplace=Reseau.getArc(placeinf.getIdArc());
				if(bonus.containsKey(m.getSender())){
					int b=(bonus.get(m.getSender())).intValue();
					b=+1;
					bonus.put(m.getSender(), new Integer(b));
				}else{
					bonus.put(m.getSender(), new Integer(1));
				}
				Reseau.diminuerPlaceArc(arcplace);
			}else{ //Message de type confirmation,notification
				MettreAJourPlace(m);
			}
		}
	}

	void MettreAJourPlace(Message m){
		boolean trouve=false;
		int i=0;
		if((((((ACLMessage)m).getAct()).toLowerCase()).equalsIgnoreCase("confirmation"))||(((((ACLMessage)m).getAct()).toLowerCase()).equalsIgnoreCase("notification")))
		{
			Place place=(Place)(((ACLMessage) m).getFieldValue("place"));
			listePlace.put(place, "occupee");
			Reseau.diminuerPlaceArc(Reseau.getArc(place.getIdArc()));
			//mettre à jour le nbre de places libres sur l'arc pour un confirmation ou pour une notification
			while((!trouve)&&(i<listePreReservation.size()))
			{
				if(listePreReservation.get(i).getAdresse()==m.getSender())
					trouve=true;
				else
					i++;
				if(trouve)
				{
					listePreReservation.remove(i);	
				}
			}	
		}
	}

	public void receptionPreference(ACLMessage m) {

		@SuppressWarnings("unchecked")
		ArrayList<StructureItineraire> d=(ArrayList<StructureItineraire>)(m.getFieldValue("preference"));
		StructureItineraire st=getPlaceLibre(d);

		if(st!=null){
			PreReservation pre=new PreReservation(m.getSender(),st.getPlace(),st.getDist(),st.getNbreCycle());
			if(st.getPlace().equals(d.get(0).getPlace())){
				//ajouter ds les préresrevations
				listePlace.put(st.getPlace(), "prereserve");
				listePreReservation.add(pre);	
			}else{
				ACLMessage notification=new ACLMessage("notification");
				notification.setField("autreplace", st.getPlace());
				sendMessage(m.getSender(), notification);
				listePlace.put(st.getPlace(), "prereserve");
				listePreReservation.add(pre);
			}

			Reseau.diminuerPlaceArc(Reseau.getArc(st.getPlace().getIdArc()));
		}else{
			Set<Place> enspl=listePlace.keySet();
			Object[] tabpl=enspl.toArray();
			int k=0;
			boolean trouve=false;
			while((k<tabpl.length)&&(!trouve))	{
				Place plares=(Place)tabpl[k];
				if(listePlace.get(plares).equals("libre"))
					trouve=true;
				else
					k++;
			}
			if(trouve)	{
				ACLMessage placeechec=new ACLMessage("placeechec");
				placeechec.setField("place", (Place)tabpl[k]);
				sendMessage(m.getSender(), placeechec);
				listePlace.put((Place)tabpl[k],"prereserve");
			}else	{
				ACLMessage echec=new ACLMessage("echec_prereservation");			
				sendMessage(m.getSender(), echec);
			}
		}

	}
	public void receptionDemande(ACLMessage msg) {
		ReponseDemande reponse=new ReponseDemande();
		ACLMessage msgenvoi;
		Demande d =(Demande)(msg.getFieldValue("demande_places_libres"));
		if(d!=null){
			ArrayList<Place> listePlacesLibres=getListePlacesLibres(d);
			if(listePlacesLibres!=null)	{
				reponse.setListePlaceLibre(listePlacesLibres);
				msgenvoi= new ACLMessage("envoi_places_libres");
				msgenvoi.setField("envoi_places_libres",reponse);
			}else
				msgenvoi=new ACLMessage("echec");
		}else
			msgenvoi=new ACLMessage("echec");
		sendMessage(msg.getSender(),msgenvoi);
	}

	//traitement des listes
	public String live(){
/*		System.out.println("nombre places dispo : " + listePlace.size());
		for (Map.Entry  p : listePlace.entrySet())
			System.out.println(p.getKey() + ":" + p.getValue());
*/
		//println("ag stationnement et step: "+Reseau.getStep());
		classementMessageEntrant();
		while(!listePreferences.isEmpty()){
			ArrayList<ACLMessage> packagePreference=new ArrayList<ACLMessage>();
			int limite;
			int i=0;
			int max;
			if(listePreferences.size()<5)
				limite=listePreferences.size();
			else
				limite=5;
			while(i<limite){
				max=0;
				for(int j=1;j<limite-i;j++)	{
					if((getBonus(listePreferences.get(j).getSender()))>(getBonus(listePreferences.get(max).getSender())))
						max=j;
				}
				packagePreference.add(listePreferences.get(max));
				listePreferences.remove(max);
				i++;
			}
			while(!packagePreference.isEmpty())	{
				ACLMessage m=packagePreference.get(0);	
				receptionPreference(m);
				packagePreference.remove(0);
			}
		}
		/*if(!listePreferences.isEmpty())
		{
			int max=0;
			while(!listePreferences.isEmpty())
			{
				max=0;
				for(int j=1;j<listePreferences.size();j++)
				{
					//comparer les bonus
					if((getBonus(listePreferences.get(j).getSender()))>(getBonus(listePreferences.get(max).getSender())))
						max=j;
				}

				ACLMessage m=listePreferences.get(max);
				receptionPreference(m);
				listePreferences.remove(max);

			}
			}*/
		/*while(!listePreferences.isEmpty())
		{
			receptionPreference(listePreferences.get(0));
			listePreferences.remove(0);

		}*/
		//traiement des demandes
		while(!listeDemandes.isEmpty())
		{
			ACLMessage m=listeDemandes.get(0);
			listeDemandes.remove(0);


			if(m!=null)
				receptionDemande(m);
			else
				println("message recu null");
		}
		int c=0;
		while((c<listePreReservation.size())&&(!listePreReservation.isEmpty()))
		{
			if(listePreReservation.get(c).getNbCycle()>Reseau.getStep())
			{
				Reseau.libererPlaceArc(Reseau.getArc(listePreReservation.get(c).getPlaceReservee().getIdArc()));
				listePlace.put(listePreReservation.get(c).getPlaceReservee(),"libre");
				listePreReservation.remove(c);
			}
			else
				c++;	
		}

		return "live";

	}
	//methode qui retourne le bonus d'un agent
	public int getBonus(AgentAddress a)
	{
		return (bonus.get(a)).intValue();
	}
	//methode qui retourne des places libres à partir d'une position
	public static StructureItineraire getPlaceLibre(ArrayList<StructureItineraire> a)
	{
		int i=0;
		Set<Place> lsplace=listePlace.keySet();
		Iterator<Place> it=lsplace.iterator();
		Place pl;

		while(i<a.size())
		{
			while(it.hasNext())
			{
				pl=it.next();
				if((a.get(i).getPlace().equals(pl))&&(listePlace.get(pl).equalsIgnoreCase("libre")))
				{
					return a.get(i);
				}
			}
			i++;
			it=lsplace.iterator();
		}	
		return null;
	}


	public Place getPlaceListe(Place[] lp)
	{
		int i=0;
		while(i<lp.length)
		{
			if(listePlace.get(lp[i]).equalsIgnoreCase("libre"));
			return(lp[i]);
		}

		return null;
	}


	//renvoie une liste de places libres à partir de la position de l'assitant 
	//et le critère nbre max de places à renvoyer
	public ArrayList<Place> getListePlacesLibres(Demande dem)
	{
		if(listePlace.size()!=0)
		{
			ArrayList<Place> placeslibres=new ArrayList<Place>();
			ArrayList<PlaceCalculDistance> pldist=new ArrayList<PlaceCalculDistance>();
			Set<Place> placeServices=listePlace.keySet();
			Iterator<Place> it=placeServices.iterator();
			Place place;
			double dist2;
			while(it.hasNext()){
				place=it.next();
				if(listePlace.get(place).equalsIgnoreCase("libre"))	{
					dist2=CalculChemin.distanceChemin(dem.getArcCourant(), dem.getPosition(),dem.isSensDeplacement(), place);
					pldist.add(new PlaceCalculDistance(place,dist2));
				}

			} 
			
			/*
			while((placeslibres.size()<dem.getNbreMaxPlace())&&(pldist.size()!=0)){
				int mindst=0;
				for(int t=1;t<pldist.size();t++){
					if(pldist.get(mindst).getDistance()>pldist.get(t).getDistance())
						mindst=t;
				}
				placeslibres.add(pldist.get(mindst).getPlace());
			}
			*/
			while((placeslibres.size()<dem.getNbreMaxPlace())&&(pldist.size()!=0)){
				int mindst=0;
				for(int t=1;t<pldist.size();t++){
					if(pldist.get(mindst).getDistance()>pldist.get(t).getDistance())
						mindst=t;
				}
				placeslibres.add(pldist.get(mindst).getPlace());
				pldist.remove(mindst);
			}			
			if(placeslibres.size()!=0)
				return placeslibres;
		}

		return null;
	}

	public void ajoutPlace(Place p,String etat)
	{
		Set<Place> lplace=listePlace.keySet();
		Place pl=p;
		Iterator<Place> it=lplace.iterator();
		boolean existe=false;
		while((it.hasNext())&&(!existe))
		{
			pl=it.next();
			if(pl.equals(p))
				existe=true;
		}
		if(existe)
		{
			if(pl.equals(p))
				listePlace.put(pl, etat);
			else
			{
				listePlace.remove(pl);
				listePlace.put(p, etat);
			}
		}
		else
			listePlace.put(p, etat);
	}

	public void end()
	{
		println("nbre demandes annulees"+Reseau.nbredemandesannulees);
		println("le nbre de places ds le systemeest: "+listePlace.size());
		Reseau.setNull();
	}

	private class PlaceCalculDistance
	{
		private Place p;
		private double distance;
		public PlaceCalculDistance(Place pl,double dist)
		{
			p=pl;
			distance=dist;
		}
		/*	public void setPlace(Place p) {
			this.p = p;
		}
		public void setDistance(double distance) {
			this.distance = distance;
		}
		 */
		public Place getPlace() {
			return p;
		}
		public double getDistance() {
			return distance;
		}
	}

	public static void afficherEtatStationnement() {
		System.out.println("nombre de places : " + listePlace.size());
		for (Map.Entry<Place, String>  p : listePlace.entrySet())
			System.out.println(p.getKey() + ":" + p.getValue());
		
	}
}
