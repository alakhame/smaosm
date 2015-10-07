package approche.locale.turtles;

import java.awt.Color;
import java.util.ArrayList;
import java.util.TreeSet;

import network.turtles.TurtleNetWorkTurtle;
import network.turtles.TurtleState;
import network.structure.Arc;
import network.structure.CalculReseau;
import network.structure.ComparatorDistance;
import network.structure.Coordonnees;
import network.structure.PlaceLiberee;
import network.structure.Place;
import network.structure.Reseau;
import simulateur.Main;
import turtlekit.kernel.Turtle;
import turtlekit.kernel.TurtleScheduler;
import madkit.messages.ACLMessage;

public class AssistantApprocheLocaleFull extends TurtleNetWorkTurtle {
	public static int range ;
	public static int nbMessageCentralise = 0;
	private static final long serialVersionUID = 1L;
	boolean placeGivenByCentralAgent=false;
	protected Place placeChoisie;
	protected int tempsAccesPlaceChoisie = -1;

	protected ModuleUtilitaire mu = new ModuleUtilitaire();
	protected ModuleGestionDesListes mgdl = new ModuleGestionDesListes();
	protected ModuleCommunication mc = new ModuleCommunication();
	protected int dateAccesPlaceChoisie;

	@Override
	public void trace(){
	/*	if (this.getName().equals("turtle1")){
//		System.out.println();
		System.out.println(TurtleScheduler.iteration + " A:"+cr.getArcCourant() + " "+ sens + " " + position + " coordonn�es " 
		+ cr.getArcCourant().getPositionArc(position) + " etat " + this.state);
		System.out.println("cible: " + placeChoisie + " direction " + cr.getChemin());
		}
*/		
	}
	
	/*
	 * 
	 * Constructeur / initialisation
	 * 
	 */
		public AssistantApprocheLocaleFull(String s) {
			super(s);
			mgdl.listePlaces = new ArrayList<PlaceLiberee>();
			this.placeChoisie = null;
		}

		public AssistantApprocheLocaleFull() {
			super();
		}

		public AssistantApprocheLocaleFull(String string, boolean b) {
			super(string,b);
		}

		public AssistantApprocheLocaleFull(String s, int temps) {
			super(s,true);
			mgdl.listePlaces = new ArrayList<PlaceLiberee>();
			this.placeChoisie = null;

		}
		/*
		 * initialisation : en appelant cette m�thode, l'agent circule au d�but de
		 * son execution
		 */
		public String debutCirculer() {
			setState(TurtleState.vadrouille);
			initialisation();
			position = Reseau.getPositionInitialisation(cr.getArcCourant());
			setXY(cr.getArcCourant().getPositionArc(position).getX(), cr
					.getArcCourant().getPositionArc(position).getY());
			return "live";
		}
		/*
		 * Initialisation : si la place choisie au hasard est prise il est en
		 * vadrouille sinon � l'arr�t
		 */

// simplification de la m�thode avec une seule place par arc.		
		public String debutStationner() {
			position = cr.getArcCourant().getPositionPlacePossible();
			if (!positionCouranteLibre()){
				debutCirculer();
			}else{
				initialisation();
				position = Reseau.getPositionPlace(cr.getArcCourant());
				setXY(cr.getArcCourant().getPositionArc(position).getX(), cr.getArcCourant().getPositionArc(position).getY());	
					setState(TurtleState.arret);
					mu.incNbMessageCentralise();
	//				Reseau.incNombreStationnement();
					Reseau.diminuerPlaceArc(cr.getArcCourant());
			// A decommenter??:		Reseau.incNbreCycleTotalRecherche(cycleCherche);		
				//	Reseau.incNombrePlaceTrouveHasard();
					placeChoisie = null;
					cr.setChemin(new ArrayList<Arc>());
					// retrait de la place des places libres
					mgdl.retraitPlaceLibre(cr.getArcCourant().getId());
//					System.out.println(getName()  + " debute � " + cr.getArcCourant() + " position " + cr.getArcCourant().getPositionArc(position));
//					cycleCherche = 0;
				}
			return ("live");
			}

		@Override
		protected void miseAjourDemande() {
			Reseau.incNbredemandesTotal(this);
		}
	
/*
 *  
 *  Methode utilitaire
 *  	
 */
	protected class ModuleUtilitaire{
	
	public void incNbMessageCentralise() {
		nbMessageCentralise++;
	}
	
	// methode qui permet de chercher une place selon le crit�re de distance
	public void recherchePlace() {
	
		PlaceLiberee pl;
		if (mgdl.listePlaces.size() != 0) {
			println(" searching for a new place among "+ mgdl.listePlaces.toString());
			/******* ADD 2.0 *********************/
			ComparatorDistance comparatorD = new ComparatorDistance(AssistantApprocheLocaleFull.this);
			cr.plusCourtChemin();
			TreeSet<PlaceLiberee> candidates = new TreeSet<PlaceLiberee>(comparatorD);
			candidates.addAll(mgdl.listePlaces);
			PlaceLiberee plParDefaut = candidates.first();
			pl = null;
			trace();
			//System.out.println("Before "+mgdl.listePlaces.size()+": "+mgdl.listePlaces);
			 while(candidates.size()>0){
				pl=candidates.pollFirst(); // on a trouve la plus proche libre
				// je suis plus proche ou la place n'int�resse personne
				int distance =	comparatorD.testCompare(pl); 
				double distancePlaceactualise = pl.getDistanceToPlace() - (TurtleScheduler.iteration - pl.getDate()); 
				if( (!pl.isIntention()) || (distance < distancePlaceactualise)){
			//		System.out.println(getName() + " est � " + distance + " au lieu de " + pl.getDistanceToPlace());
/*					if (getName().equals("turtle1")){
						System.out.println("place conserv�e :" + pl.toString() + " ma distance :" + distance);
					}
*/
					pl.setIntention(true); // met � jour listePlace
					pl.setDistanceToPlace(distance);
					pl.setDate(TurtleScheduler.iteration);
					placeChoisie = pl.getPlace();
					tempsAccesPlaceChoisie = distance;
					dateAccesPlaceChoisie = TurtleScheduler.iteration;
					cr.getChemin(Reseau.getArc(placeChoisie.getIdArc()),cr.getArcCourant());
//					if (getName().equals("turtle1")) System.out.println("listePlaces apr�s " + mgdl.listePlaces);
					return;
				}
				
			 }
			 //System.out.println("After "+mgdl.listePlaces.size()+": "+mgdl.listePlaces);// fin while
// rien trouv� : tout est choisie et distance + courte					
/*			 placeChoisie = plParDefaut.getPlace();
			 cr.plusCourtChemin();
			 cr.getChemin(Reseau.getArc(placeChoisie.getIdArc()),cr.getArcCourant());
*/				
//				mgdl.listePlaces.remove(mgdl.listePlaces.indexOf(plFinale));
//				mgdl.listePlaces.add(plFinale);
//				if (getName().equals("turtle1")) System.out.println("listePlaces apr�s " + mgdl.listePlaces);
			}
			
	}
	}
/*
 * 
 * Gestion des listes
 * 	
 */
	protected class ModuleGestionDesListes{
		protected ArrayList<PlaceLiberee> listePlaces = 	new ArrayList<PlaceLiberee>();
		protected ArrayList<PlaceLiberee> listenoire = new ArrayList<PlaceLiberee>();

		
	public void retraitListeBlanche(PlaceLiberee pl){
		
		/*System.out.println("Liste "+listePlaces.toString());
		System.out.println("Place :"+pl.toString());
		System.out.println("Before deletion "+listePlaces.size());
		if(listePlaces.indexOf(pl)>-1) //System.exit(0);
		listePlaces.remove(pl);
		System.out.println("After deletion "+listePlaces.size());
		System.out.println("-------------------------------------");
		*/
		listePlaces.remove(pl);
		
	}
		
	public void setListePlaces(ArrayList<PlaceLiberee> listePlaces) {
		this.listePlaces = listePlaces;
	}

	public ArrayList<PlaceLiberee> getListePlaces() {
		return listePlaces;
	}
	private void creationPlace(PlaceLiberee p){
		listePlaces.add(p);
	}
	// ajouter une place dans la liste, en v�rifiant son existence
	private void ajoutPlace(PlaceLiberee p) {
// on regarde si la place existe d�j� (m�me coordonn�e)
				int index = listePlaces.indexOf(p);
// la place existe
					if (index != -1){
// elle est plus r�cente
						if (p.getDate() > listePlaces.get(index).getDate()){
							listePlaces.remove(index);
							listePlaces.add(p);
						}
// else : mon info est plus r�cente : je ne fais rien
				}else
// je n'ai pas trouv� la place.
				listePlaces.add(p);
	}

	// �liminer les places de la liste des places lib�r�es apr�s un certain
	// temps
	void VerificationListe() {
		for (int j = 0; j < listePlaces.size(); j++) {
			if ( (listePlaces.get(j).getDate() + Reseau.tempsGardeinfHP) < TurtleScheduler.iteration)
				listePlaces.remove(j);
		}
	}

	private void verificationListeNoire() {
		for (int j = 0; j < listenoire.size(); j++) {
			if ( (listenoire.get(j).getDate() + Reseau.tempsGardeinLN) < TurtleScheduler.iteration) {
				listenoire.remove(j);
			}
		}
	}
	// methode qui traite une liste LN d'un autre agent
	private void traitementLNRecu(ArrayList<PlaceLiberee> lnb) {
		int index;
		for (PlaceLiberee pl : lnb) {
			index = listePlaces.indexOf(pl);
			if (index != -1) {
// j'ai trouv� la place dans celle connue comme libre
				if (listePlaces.get(index).getDate() < pl.getDate()) {
// l'info est plus r�cente : je retire la place des dispos et l'ajoute dans les noirs				
					listePlaces.remove(index);
					listenoire.add(pl);
				}
// else : je ne fais rien
			} else
// la place est nouvellement connu comme occup�, ajoute � la liste noire (peut �ventuellement d�j� y �tre)
				ajoutPlaceLN(pl);
		}
	}

// methode qui traite une liste LP d'un autre agent
	private void traitementLPRecu(ArrayList<PlaceLiberee> lpb) {
		int ind;
		for (PlaceLiberee plb : lpb) {
// cas 1 : la place est connue dans la liste Noire
			ind = listenoire.indexOf(plb);
			if (ind != -1) {
	//???			if (plb.getDistanceToPlace() < listenoire.get(ind).getDistanceToPlace()) {
// cas 1.1 : une place qui n'est plus occup�e => on la retire de la liste noire et on l'enregiste.			
					if (plb.getDate() > listenoire.get(ind).getDate() ){
						listenoire.remove(plb);
						ajoutPlace(plb);
				}
// cas 1.2 : notre info est plus r�cente : on fait rien.
			} else
// cas 2 : la place n'est pas ds liste noire.
				ajoutPlace(plb);
		}
	}

	// ajout d'une place ds LN en v�rifiant son existence
	private void ajoutPlaceLN(PlaceLiberee plocc) {
			int ind = listenoire.indexOf(plocc);
// je la connait d�j�
			if (ind != -1){
// mise � jour si plus r�cente.
			if (listenoire.get(ind).getDate() < plocc.getDate()) {
				(listenoire.get(ind)).setDate(plocc.getDate());
			}
		} else
// je ne la connais pas.
			listenoire.add(plocc);
	}

	public boolean retraitPlaceLibre(int idArc) {
		for (PlaceLiberee p : listePlaces)
			if (p.getPlace().getIdArc() == idArc){
				listePlaces.remove(p);
				return true;
			}
		return false;
	}

	}
/*
 * 
 * Methode pour la communication
 * 
 */
	protected class ModuleCommunication{
		
	private ArrayList<TurtleNetWorkTurtle> vehiculesVoisins() {
		
		ArrayList<TurtleNetWorkTurtle> voisins = new ArrayList<TurtleNetWorkTurtle>();
		Turtle[] vehiculesVoisins;
		vehiculesVoisins = turtlesHere();
		for (Turtle voisin : vehiculesVoisins) {
			if (voisin instanceof AssistantApprocheLocaleFull) {
				if (((TurtleNetWorkTurtle)voisin).state != TurtleState.arret){
					voisins.add((TurtleNetWorkTurtle)voisin);
					
				}
				//System.out.print( ((TurtleNetWorkTurtle)voisin).state+ " --- ");
			}
		} //System.out.println();
		
		for (int j = -range; j <= range; j++)
			for (int s = -range; s <= range; s++) {
				if ((j != 0) && (s != 0))
					vehiculesVoisins = turtlesAt(cr.getArcCourant().getPositionArc(position).getX()
							+ j, cr.getArcCourant().getPositionArc(position).getY() + s);
				for (Turtle voisin : vehiculesVoisins) {
					if (voisin instanceof AssistantApprocheLocaleFull) {
						if (((TurtleNetWorkTurtle)voisin).state != TurtleState.arret)
							voisins.add((TurtleNetWorkTurtle)voisin);
					}
				}
			}
		if (voisins.contains(this))
			voisins.remove(this);
		 
		return voisins;
	}


	// diffuser la liste des places au pr�s des v�hicules voisins
	public void diffuser() {
		
		mgdl.VerificationListe();
		mgdl.verificationListeNoire();
		ArrayList<TurtleNetWorkTurtle> voisins = vehiculesVoisins();
		//if ( ( voisins.size() != 0) )  Reseau.callCheck+=voisins.size();
		if ((mgdl.listePlaces.size() != 0) && (voisins.size() != 0)) {
			// diffuser l'informaion de la lib�ration de la place aux vehicules voisins
			println("IN BROADCAST -- sending "+voisins.size()+" msg -- nb places : "+mgdl.listePlaces.size());
			ACLMessage msg = new ACLMessage("listeplaces");
			msg.setField("liste", mgdl.listePlaces);
			msg.setField("listenoire", mgdl.listenoire); 
			for (int i = 0; i < voisins.size(); i++){
				
				sendMessage(voisins.get(i).getAddress(), msg);
				Reseau.intNbremessageechanges();
			}
		}
	}
	
	// traitement des messages
	@SuppressWarnings("unchecked")
	public void handleMessage() {
		 while (!isMessageBoxEmpty()) {
			ACLMessage m = (ACLMessage) nextMessage();

			/*********** for logging *******************/
			println(" I've got some info from   " + m.getSender().toString());
			/*********** end logging ******************/
			if (m.getSender() == AssistantApprocheLocaleFull.this.getAddress())
				System.out.println("mon propre message");
			else if (m.getAct().equalsIgnoreCase("listeplaces")) {
				mgdl.traitementLPRecu((ArrayList<PlaceLiberee>) (m.getFieldValue("liste")));
				mgdl.traitementLNRecu((ArrayList<PlaceLiberee>) (m.getFieldValue("listenoire")));
			}
		}
	}


	public void viderBoiteMail() {
		 while (!isMessageBoxEmpty()) {
				ACLMessage m = (ACLMessage) nextMessage();
		 }
		}
	}
/*
 * 
 * Methode comportementale
 * 
 */
	@Override
	protected void tr_arret_vadrouille() {
		super.tr_arret_vadrouille();
		PlaceLiberee placelib =
				new PlaceLiberee(new Place(cr.getArcCourant().getId(), cr.getArcCourant().getPositionArc(position)));
		mgdl.listenoire.remove(placelib);
		mgdl.ajoutPlace(placelib);
		placeChoisie = null;
		println(" I'm leaving a new place ("+mgdl.listePlaces+") -- ( "+xcor()+" , "+ ycor() +" )" );
	}
	
	@Override
	protected  Arc arcSuivant(){
		Arc suiv = null;
// j'ai une place en vue
	    if (placeChoisie != null){
// il me reste du chemin	    	
	    	if (cr.getChemin().size() > 0){
// regarde le suivant
			suiv = cr.getChemin().get(0);
// cas 1 : correspond � ma position
			Coordonnees posCoord = cr.getArcCourant().getPositionArc(position);
			
			if (posCoord.equals(suiv.getDebut()) || posCoord.equals(suiv.getFin())){
				cr.getChemin().remove(0);
			}else 
// cas 2 : demi tour
				suiv = cr.getArcCourant();
	    	}
// je suis sur le bon arc : je fais demi-tour
   		if (placeChoisie.getIdArc() == cr.getArcCourant().getId()){ 
	    			suiv = cr.getArcCourant();
	    		}
		}else
// j'en ai pas : je me d�place au hasard
			suiv = super.arcSuivant();
	return suiv;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////		
	// A decommenter remplac� par circuler
	//	avancer(cr.getArcCourant().getPositionArc(position).getX(), cr.getArcCourant().getPositionArc(position).getY());
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	// comportement de l'agent
	public String live() {
		
// traite les messages sauf � l'arret
		if (state != TurtleState.arret){
			mc.handleMessage();
			remiseEncausePlaceChoisie();
		}
		else
			mc.viderBoiteMail();
// mettre � jour les places selon le temps : peu efficace de v�rifier 2 fois mais c'est plus s�r
/*		mgdl.VerificationListe();
		mgdl.verificationListeNoire();
		*/
// modifie son �tat
		circuler();
// diffuse		
		if (state != TurtleState.arret){
			mc.diffuser();
		  	mu.incNbMessageCentralise();
		}
		Main.memUsage = Main.rt.totalMemory()-Main.rt.freeMemory();
		
		System.out.println("Memory usage :"+(Main.memUsage-Main.memory0)/(1024L*1024L));
		
		return "live";
	}	
	
	protected void remiseEncausePlaceChoisie() {
		if (placeChoisie != null){
// remise en cause car la place a �t� identifi�e comme occup�e
			PlaceLiberee pl = new PlaceLiberee(placeChoisie);
			int i = mgdl.listenoire.indexOf(pl); // mgdl.listenoire.contains(pl)
			if (i != -1){
//				if (getName().equals("turtle1")) System.out.println( pl + " est dans liste noire " + mgdl.listenoire);
				placeChoisie = null;
				tempsAccesPlaceChoisie = -1;
				cr.setChemin(new ArrayList<Arc>());
				setState(TurtleState.cherche);
			}else {
// la place est tjrs dans liste blanche
				i = mgdl.listePlaces.indexOf(pl);
				if (i != -1){
					double tempsAccesPlaceEnregistre = mgdl.listePlaces.get(i).getDistanceToPlace() - (TurtleScheduler.iteration - mgdl.listePlaces.get(i).getDate());
					double tempsAccesPrevu =  tempsAccesPlaceChoisie - (TurtleScheduler.iteration - dateAccesPlaceChoisie);
					if ( tempsAccesPlaceEnregistre< tempsAccesPrevu ){ // donc l'autre est meilleur
						placeChoisie = null;
						tempsAccesPlaceChoisie = -1;
						cr.setChemin(new ArrayList<Arc>());
//						if (getName().equals("turtle1")) System.out.println( pl + " est dans liste blanche " + mgdl.listePlaces);
						setState(TurtleState.cherche);
					}
			}
		}
	}
	}
	// je suis � la place que je voulais et qui est occup�e
	private void tr_versPlace_recherche() {
		placeGivenByCentralAgent=false;
		
//		System.out.println(getName() + " place est prise " + Reseau.getUtilisationSysteme() + ":" + placeChoisie + " : " + cr.getArcCourant() + nbreStationnePositionBis());
		miseAjourListePlacePrise();	
		setState(TurtleState.cherche);
	//	trace();
	}

	private void miseAjourListePlacePrise() {
// retrait de la place des places libres
		mgdl.retraitPlaceLibre(placeChoisie.getIdArc());
		PlaceLiberee placeoccup = new PlaceLiberee(placeChoisie);
		placeChoisie = null;
		tempsAccesPlaceChoisie = -1;
		dateAccesPlaceChoisie = -1;
		cr.setChemin(new ArrayList<Arc>());
// ajout de la place en liste noire
		mgdl.listenoire.add(placeoccup);
	}


	/*
	 * passe � l'�tat arret. sauf pour le premier pas (?) cela ajoute une
	 * demande : on suppose que l'agent venait de faire une demande
	 */
	@Override
	protected void tr_cherche_arret() {
		setState(TurtleState.arret);
		setGare(true);
//		System.out.println(this.getName() + " a trouve en " + cr.getArcCourant().getId());
		mu.incNbMessageCentralise();
		Reseau.incNombreStationnement();
		Reseau.diminuerPlaceArc(cr.getArcCourant());
// A decommenter??:		Reseau.incNbreCycleTotalRecherche(cycleCherche);		
	//	Reseau.incNombrePlaceTrouveHasard();
		placeChoisie = null;
		cr.setChemin(new ArrayList<Arc>());
		// retrait de la place des places libres
		mgdl.retraitPlaceLibre(cr.getArcCourant().getId());

//		cycleCherche = 0;
	}
	
	
	private void tr_versPlace_arret() {
		setState(TurtleState.arret);
		setGare(true);
		if (placeChoisie.getIdArc() == cr.getArcCourant().getId()){
			Reseau.utiliserSysteme();
			miseAjourListePlacePrise();
			mc.diffuser();
		}
		else
			Reseau.incNombrePlaceTrouveHasard();
		
		Reseau.incNombreStationnement();
		Reseau.diminuerPlaceArc(cr.getArcCourant());
		// A decommenter??:		Reseau.incNbreCycleTotalRecherche(cycleCherche);
//		cycleCherche = 0;
		placeChoisie = null;
		cr.setChemin(new ArrayList<Arc>());
		tempsAccesPlaceChoisie = -1;
	}

// 	il n'y a pas de place � ma position
	public void tr_recherche_vers(){
			mu.recherchePlace();
// premier cas : il y a une place
			if (placeChoisie != null) {
				println(" I found a place to go at  -- "+ placeChoisie.getCoordonnees().toString());
				setState(TurtleState.versPlace);
			/*	if (placeChoisie.getCoordonnees().equals(cr.getArcCourant().getPositionArc(position))){
					System.out.println(getName() + " anormal 1");
					System.out.println(placeChoisie);
					System.out.println(cr.getArcCourant());
					System.out.println(cr.getArcCourant().isPositionPlace(position));
		//			System.exit(0);
				}*/
					
			}
// second cas : je continue � chercher
		else
			tr_cherche_cherche();			
	}
	
	
	
	protected void nouvelleEtat(){ // vadrouille => cherche => arret + versPlace
		String etat = ""+state;
	switch (state) {
		case vadrouille: {
			if (cycleVadrouille > tempsVadrouille) {
				tr_vadrouille_cherche();
				etat += ":cherche";
			}else{
				tr_vadrouille_vadrouille();
				etat += ":vadrouille";
			}
			break;
		}

		case cherche: {
			Reseau.incNbreCycleTotalRecherche(1,this);
// cas 1 : je suis � la position d'une place : mise � arret et mise � 0 des compteurs.
			if (positionCouranteLibre()){
// la place est libre je me gare
					tr_cherche_arret();
					etat += ":arret";
				}else{
// cas 2 :  soit vers versPlace soit reste cherche.
				tr_recherche_vers();
				etat += ":vers";
				//Reseau.callCheck+=turtlesHere().length;
			}
			break;
		}
		case arret: {
			if (cycleArret > tempsStationnement) {
				tr_arret_vadrouille();
				etat += ":vadrouille";
			} else{
				tr_arret_arret();
				etat += ":arret";
			}
			break;
			}
		case versPlace: {
			Reseau.incNbreCycleTotalRecherche(1,this);
	// Premier cas: il y a des places � cette position
			if (positionCouranteLibre()){
	//		il reste des places ******* a priori consid�re une seule place*************
	// ne tient pas compte des arcs.				
					tr_versPlace_arret();
					etat += ":arret";
	// il ne reste pas de place mais c'�tait ma destination => remise en �tat de recherche;
			}else if ((cr.getArcCourant().isPositionPlace(position)) && (placeChoisie.getIdArc() == cr.getArcCourant().getId())){
							tr_versPlace_recherche();	
							etat += ":cherche";
							//Reseau.callCheck+=turtlesHere().length;
	// je continue � chercher			
			} else{
				tr_versPlace_versPlace();
				etat += ":versPlace";
				}
			break;
		}
		default :
			System.out.println(this);
			System.exit(0);
		}
		
	//System.out.println(etat + "==="); 
	trace();
	}	 
	
	
	protected boolean testerExistancePlace() {
// il existe une place sur l'arc courant.
		if (cr.getArcCourant().isPositionPlace(position)){
/*			if (this.getName().equals("turtle1"))
				System.out.println("il y a une place sur l'arc courant");
				*/
			return true;
		}
/*
// il existe une place sur le d�but du suivant qui est la place courante du vehicule
		if (cr.getChemin().size() > 0){
			if (cr.getArcCourant().getPositionArc(position).equals( 
					cr.getChemin().get(0).getDebut()) && cr.getChemin().get(0).isPositionPlace(0)){
				if (this.getName().equals("turtle1"))
					System.out.println("il y a une place au debut");
				return true;
			}
			if (cr.getArcCourant().getPositionArc(position).equals(	cr.getChemin().get(0).getFin())
					&& cr.getChemin().get(0).isPositionPlace(cr.getChemin().get(0).getNbrePlaces()-1))
			{
				if (this.getName().equals("turtle1"))
					System.out.println("il y a une place � la fin");
				return true;
			}
		}
*/
		return false;
	}

	@Override
	protected void nouvellePosition() {
		// je suis � une extremit� de l'arc courant alors que je dois passer au suivant (cas de passage de recherche � versPlace et je ne suis pas dans le bon sens)  
		if (
			(((cr.getArcCourant().getPositionArc(position).equals(cr.getArcCourant().getFin()) && !sens)
				|| (cr.getArcCourant().getPositionArc(position).equals(cr.getArcCourant().getDebut()) && sens)))
			&& 	(cr.getChemin().size() > 0)
			){
			if (cr.getChemin().get(0).estExtremite(cr.getArcCourant().getPositionArc(position))){
			if (cr.getChemin().get(0).getDebut().equals(cr.getArcCourant().getPositionArc(position))){
				position = 0;
				sens = true;
			}else{
				position = cr.getChemin().get(0).getNbrePlaces() - 1;
				sens = false;
				}
			cr.setArcCourant(cr.getChemin().get(0));
			cr.getChemin().remove(0);
			}else
				super.nouvellePosition(); // je ne suis pas � une extremit�
		}else super.nouvellePosition(); // pas de suite, pas une extremit� dans le bon sens
	}
	
	private void tr_versPlace_versPlace() {
		//System.out.println(getName()+ " va vers " + placeChoisie);
//		cycleCherche++;
	}

	@Override
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
		setColor(Color.orange);
		break;
	}
}


}
