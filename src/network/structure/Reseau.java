package network.structure;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import network.turtles.TurtleNetWorkTurtle;

import approche.locale.turtles.AssistantApprocheLocaleFull;
import mapping.utils.EnvHelper;

public class Reseau {

// globaleVariable
	private static Random hasardCycle = new Random(); 
	public static int cycleStationnement = 10;
	public static int cycleVadrouille = 10;
// gestion structure du r�seau
	public static int arcCount = 0;
	public static ArrayList<Arc> listeArc;
	public static HashSet<Integer> listeArcSuivant;
	public static HashMap<Long, HashSet<Integer>> arcLies;

	public static int nbrePlaceArc = 1;
	private static int nbreCycleVadrouilleMin = 5;
	private static int nbreCycleOccupationPlace ;
	public static int nbreAgCommunaute ;
	public static int nbreAgHorsCommunaute ;
	public static int tempsGardeinfHP = 15;
	public static int tempsGardeinLN = 15;

// nombre de demande communaute
	private static long nbredemandesTotal = 0; 
	private static int nbredemandeTotalhorscommunaute = 0;
	private static int NombrePlaceTrouveHasard = 0;

	// type des agents de la communauté {full, coopetitf}
	
	public static String comAgentType="";
	public static int callCheck=0;

	// nombre total de cycle de recherche
	private static int nbreCycleTotalRecherche = 0;
	private static int nbreCycleTotalRechercheHC = 0;
			
// nombre d'utilisation du system
	private static int utilisationSysteme;
			
	public static ArrayList<Place> placeprisedebut;
	private static int nbremessageechanges = 0;
	public static int nbredemandesannulees = 0;
// a voir
	public static int nbredemandestotales = 0;
	public static int nbreAppels = 1;
	public static int simTime;
	private static int nbreStationnements=0;
	private static int nbreStationnementsHC=0;

// liste pour conna�tre les valeurs par cycle
	public static ArrayList<Integer> nbrePlaceLibresCycle;
	public static ArrayList<Integer> nbreRechCycle;
	public static ArrayList<Integer> nbreStatCycle;
	public static ArrayList<Integer> nbreCirCycle;

	public static int arcCount() {
		Reseau.arcCount++;
		return Reseau.arcCount;
	}
	
	public static int getTempsOccupation(){
		return nbreCycleOccupationPlace + hasardCycle.nextInt(cycleStationnement);
	}
	
	public static int getTempsVadrouille() {
		return nbreCycleVadrouilleMin + hasardCycle.nextInt(cycleVadrouille);
		}
	
	public static void afficheArcLie(){
		for (Map.Entry<Long, HashSet<Integer>> me : arcLies.entrySet()){
			System.out.println(me.getKey() + ":" + me.getValue());
			for (Integer i : me.getValue())
				System.out.println(getArc(i));
		}
			
	}
	public static long getNbredemandesTotal() {
		return nbredemandesTotal;
	}

	public static void incNbredemandesTotal(TurtleNetWorkTurtle agent) {
		if (!agent.isGare())
			Reseau.nbredemandesTotal++;
	}

	public static int getNbredemandeTotalHC() {		
		return nbredemandeTotalhorscommunaute;
	}

	public static void incNbredemandeTotalHC(TurtleNetWorkTurtle agent) {
		if (!agent.isGare())
			Reseau.nbredemandeTotalhorscommunaute++;
	}

	public static int getNbreCycleTotalHC() {
		return nbreCycleTotalRechercheHC;
	}

	public static void parametreSimulation(int agC, int agHC,int nbrCycleOccupation, int st, int range) {
		/* ajout */
		nbreStationnements = 0;
		nbreStationnementsHC = 0;
		nbreAppels = 1;
		/* fin ajout */
		
		nbreAgCommunaute = agC;
		nbreAgHorsCommunaute = agHC;
		nbreCycleOccupationPlace = nbrCycleOccupation;
		nbredemandesTotal = 0;
		nbreCycleTotalRecherche = 0;
		nbrePlaceLibresCycle = new ArrayList<Integer>();
		nbreRechCycle = new ArrayList<Integer>();
		nbreStatCycle = new ArrayList<Integer>();
		nbreCirCycle = new ArrayList<Integer>();
		utilisationSysteme = 0;
		nbremessageechanges = 0;
		nbredemandesannulees = 0;
		nbredemandeTotalhorscommunaute = 0;
		nbreCycleTotalRechercheHC = 0;
		nbredemandestotales = 0;
		simTime=st;
		AssistantApprocheLocaleFull.range=range;
		NombrePlaceTrouveHasard = 0;
		

	}

	public static void instancierReseau() {
		EnvHelper generateurEnvironnement = new EnvHelper();
		try {
			generateurEnvironnement.genEnv();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void instancierReseauBis() {
		Reseau.arcLies = new HashMap<Long, HashSet<Integer>>();
		
		HashSet<Integer> arc1 = new HashSet<Integer>();
	//	arc1.add(e)
		//Reseau.arcLies.put(new Long(1),);
		
	
	}

	public static void setNbreAgCommunaute(int nbreAgCommunaute) {
		Reseau.nbreAgCommunaute = nbreAgCommunaute;
	}

	public static void setNbreAgHorsCommunaute(int nbreAgHorsCommunaute) {
		Reseau.nbreAgHorsCommunaute = nbreAgHorsCommunaute;
	}

	public static boolean containPlaceprise(Place p) {
		boolean existe = false;
		int i = 0;
		while ((i < placeprisedebut.size()) && (!existe)) {
			if (placeprisedebut.get(i).equals(p))
				return true;
			i++;
		}

		return existe;
	}

	public static int getNbreArc() {
		return arcCount;
	}

	public static ArrayList<Arc> getListeArc() {
		return listeArc;
	}

	public static HashSet<Integer> getArcLies(long l) {
		if (arcLies.containsKey(l))
			return arcLies.get(l);
		else
			System.out.println("NOPE !!!");
		return null;
	}
	
	public static Arc getArcI(int i){
		return listeArc.get(i);
	}

	public static Arc getArc(int id) {
		int i = 0;
		while ((i < listeArc.size()) && (listeArc.get(i).getId() != id)) {
			i++;
		}
		if (i < listeArc.size())
			return listeArc.get(i);
		return null;
	}

	public static Arc getArcSuivant(Arc a, Coordonnees c) {

		HashSet<Integer> suivant=getArcLies(a.getId());
		Iterator<Integer> it=suivant.iterator();
		Arc b;
		ArrayList<Arc> suiv=new ArrayList<Arc>();
		int idsuiv;
			while(it.hasNext())
			{
				idsuiv=it.next();
				b=getArc(idsuiv);
				if
					( (b.getDebut().getX()==c.getX() ) && (b.getDebut().getY()==c.getY())
					|| (b.getFin().getX()==c.getX() ) &&  (b.getFin().getY()==c.getY())
					)
					suiv.add(b);
			}
		
/*		if (suiv.size()==1) {
			System.out.println("potentiel : " + suivant);
			System.out.println("retenu : " + suiv);
		}
*/
		if(suiv.isEmpty())
			return null;
		else if (suiv.size()==1)
			return suiv.get(0);
		else
		{	int i=0;
			do{
				i=(int)(Math.random()*(suiv.size()));
			}while(suiv.get(i)==null || suiv.get(i).equals(a));
			return suiv.get(i);
			
		}
	}

	public static Arc getArcDebut() {
		int i = -1;
		while ((i < 0) || (i > arcCount))
			i = (int) (Math.random() * arcCount);
		return listeArc.get(i);
	}

	public static int getPositionInitialisation(Arc a) {
		int nbreposition = a.getNbrePlaces();
		int i = -1;
		while ((i < 0) || (i > nbreposition + 1))
			i = (int) (Math.random() * nbreposition);
		return i;
	}

	public static void setNull() {
		System.out.println("nbre de recherche est " + getNbredemandes());
		System.out.println("le nbre de cycle totale de recherche est: "+ getNbreCycleTotalRecherche());
		System.out.println("le nbre de cycle moyen de recherche: "+ tempsMoyenRecherche());
		System.out.println("le taux d'utlisation du systeme est: "+ tauxUtilisationSysteme() + "%");
		listeArc = null;
		listeArcSuivant = null;
	}

	public static void diminuerPlaceArc(Arc a) {
		a.diminuerPlace();
	}

	public static void libererPlaceArc(Arc a) {
		a.ajouterPlaceLibre();
	}

	public static long getNbredemandes() {
		return nbredemandesTotal;
	}


	public static int getNbreCycleTotalRecherche() {
		return nbreCycleTotalRecherche;
	}

	public static HashSet<Integer> getListeArcSuivant(long i) {
		return arcLies.get(i);
	}

	public static int getUtilisationSysteme() {
		return utilisationSysteme;
	}

	public static void utiliserSysteme() {
		utilisationSysteme++;
	//	System.out.println("a trouve une place");
		
	}

	public static int getNbreStationnements(){
		return nbreStationnements;
	}
	
	public static  int getNbreStationnementsHC(){
		return nbreStationnementsHC;
	}
	
	
	public static int getNbremessageechanges() {
		return nbremessageechanges;
	}

	public static void setNbremessageechanges(int nbremessageechanges) {
		Reseau.nbremessageechanges = nbremessageechanges;
	}

	public static void intNbremessageechanges() {
		Reseau.nbremessageechanges++;
	}
	
	public static double tauxUtilisationSysteme() {
		return (((double) utilisationSysteme) /nbreStationnements) * 100.0;
	}

	public static float tempsMoyenRecherche() {
		return ((float) (nbreCycleTotalRecherche)) /getNbredemandes();
	}

	public static void annulerdemande() {
		nbredemandesannulees++;
	}

	public static double tempsMoyenRechHC() {
		return ((double) nbreCycleTotalRechercheHC / nbredemandeTotalhorscommunaute);
	}

	public static int getNbrePlacelibreReseau() {
		int nbpl = 0;
		for (int i = 0; i < listeArc.size(); i++)
			nbpl = nbpl + listeArc.get(i).getNbreplaceslibres();
		return nbpl;

	}

	public static void incNbreCycleTotalhorscommunaute(int cycleCherche, TurtleNetWorkTurtle agent) {
		if (!agent.isGare())
			Reseau.nbreCycleTotalRechercheHC += cycleCherche;		
//		System.out.println("AJOUT:" + cycleCherche);
	}
	public static void incNbreCycleTotalRecherche(int cycleCherche, TurtleNetWorkTurtle agent) {
		if (!agent.isGare())
			Reseau.nbreCycleTotalRecherche += cycleCherche;		
	}


	public static void incNombrePlaceTrouveHasard() {
		NombrePlaceTrouveHasard++;
		
	}

	public static void printState() {
		System.out.println("nombre de place trouve total Communaut�:" + Reseau.nbreStationnements);
		System.out.println("nombre de place trouve total Hors Communaut�:" + Reseau.nbreStationnementsHC);
		
		System.out.println("nombre de place trouve systeme :" + Reseau.getUtilisationSysteme());
		System.out.println("nombre de place trouve hasard :" + Reseau.NombrePlaceTrouveHasard);
		
	}

	public static int getPositionPlace(Arc arcCourant) {
		for (int i = 0; i < arcCourant.getPointsArc().size(); i++)
			if (arcCourant.isPositionPlace(i))
				return i;
		return -1;
	}

	public static void incNbreStationnementsHC() {
		nbreStationnementsHC++;
		
	}
	public static void incNombreStationnement() {
		Reseau.nbreStationnements++;
		
	}

	

}
