package network.structure;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import approche.locale.turtles.AssistantApprocheLocale;
import mapping.utils.EnvHelper;

public class Reseau {
	public static int arcCount = 0;
	public static ArrayList<Arc> listeArc;
	public static HashSet<Integer> listeArcSuivant;
	public static HashMap<Long, HashSet<Integer>> arcLies;
	public static int nbrenotification = 0;
	private static long nbredemandes = 0;
	public static int nbreCycleTotalRecherche = 0;
	private static int step = 0;
	private static int utilisationSysteme;
	public static ArrayList<Place> placeprisedebut;
	public static int nbreAgCommunaute ;
	public static int nbreAgHorsCommunaute ;
	public static int nbrePlaceArc = 1;
	public static int nbreCycleVadrouilleMin = 10;
	public static int nbreCycleOccupationPlace ;
	public static int nbremessageechanges = 0;
	public static int nbredemandesannulees = 0;
	public static int nbredemandehorscommunaute = 0;
	public static int tempsrecherchehorscommunaute = 0;
	public static int nbredemandestotales = 0;
	public static int tempsGardeinfHP = 35;
	public static int tempsGardeinLN = 35;
	public static int nbreAppels = 1;
	public static int simTime;
	public static int nbreStationnements=0;
	public static ArrayList<Integer> nbrePlaceLibresCycle;
	public static ArrayList<Integer> nbreRechCycle;
	public static ArrayList<Integer> nbreStatCycle;
	public static ArrayList<Integer> nbreCirCycle;

	public static int arcCount() {
		Reseau.arcCount++;
		return Reseau.arcCount;
	}

	public static void parametreSimulation(int agC, int agHC,int nbrCycleOccupation, int st, int range) {
		nbreAgCommunaute = agC;
		nbreAgHorsCommunaute = agHC;
		nbreCycleOccupationPlace = nbrCycleOccupation;
		nbrenotification = 0;
		nbredemandes = 0;
		nbreCycleTotalRecherche = 0;
		step = 0;
		nbrePlaceLibresCycle = new ArrayList<Integer>();
		nbreRechCycle = new ArrayList<Integer>();
		nbreStatCycle = new ArrayList<Integer>();
		nbreCirCycle = new ArrayList<Integer>();
		utilisationSysteme = 0;
		nbremessageechanges = 0;
		nbredemandesannulees = 0;
		nbredemandehorscommunaute = 0;
		tempsrecherchehorscommunaute = 0;
		nbredemandestotales = 0;
		simTime=st;
		AssistantApprocheLocale.range=range;
	}

	public static void instancierReseau() {
		EnvHelper generateurEnvironnement = new EnvHelper();
		try {
			generateurEnvironnement.genEnv();
		} catch (SQLException e) {
			e.printStackTrace();
		}

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

	public static Arc getArc(int id) {
		int i = 0;
		while ((i < listeArc.size()) && (listeArc.get(i).getId() != id)) {
			i++;
		}
		if (i < listeArc.size())
			return listeArc.get(i);
		return null;
	}

	public static Arc getArcSuivant(Arc a, boolean sens) {

		/*HashSet<Integer> suivant=getArcLies(a.getId());
		Iterator<Integer> it=suivant.iterator();
		Arc b;
		ArrayList<Arc> suiv=new ArrayList<Arc>();
		int nbre=0;
		int idsuiv;
		if(sens)
		{
			while(it.hasNext())
			{
				idsuiv=it.next();
				b=getArc(idsuiv);
				if(((b.getDebut().getX()==a.getFin().getX())&&(b.getDebut().getY()==a.getFin().getY()))||
						((b.getFin().getX()==a.getFin().getX())&&(b.getFin().getY()==a.getFin().getY())))
				{
					suiv.add(b);
					nbre++;
				}
			}
		}
		
		else
		{
			while(it.hasNext())
			{
				idsuiv=it.next();
				b=getArc(idsuiv);
				if(((b.getDebut().getX()==a.getDebut().getX())&&(b.getDebut().getY()==a.getDebut().getY()))||
						((b.getFin().getX()==a.getDebut().getX())&&(b.getFin().getY()==a.getDebut().getY())))
				{
					suiv.add(b);
					nbre++;
				}
			}
		}
		if(nbre==0)
			return null;
		else
		{	int i=0;
			do{
				i=(int)(Math.random()*(nbre));
			}while(suiv.get(i)==null);
			return suiv.get(i);
			
		}*/
		
		
		HashSet<Integer> suivant = getArcLies((long) a.getId());

		Iterator<Integer> it = suivant.iterator();
		Arc b;
		ArrayList<Arc> suiv = new ArrayList<Arc>();
		int nbre = 0;
		int idsuiv;
		
			while (it.hasNext()) {
				idsuiv = it.next();
				b = getArc(idsuiv);
				if (true) {
					suiv.add(b);
					nbre++;
				}
			}

		if (nbre == 0) {
			return null;
		} else {
			int i;
			
			do{
				i = (int) (Math.random() * (nbre));
			}while(suiv.get(i)==null);
			return suiv.get(i);

		}
	}

	public static Arc getArcDebut() {
		int i = -1;
		while ((i < 0) || (i > arcCount))
			i = (int) (Math.random() * arcCount);
		return listeArc.get(i);
	}

	public static int getPositionDebut(Arc a) {
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
		a.minimiserPlace();
	}

	public static void libererPlaceArc(Arc a) {
		a.ajouterPlaceLibre();
	}

	public static void setNbredemandes() {
		Reseau.nbredemandes++;
	}

	public static long getNbredemandes() {
		return nbredemandes;
	}

	public static void setNbreCycleTotalRecherche(int nbre) {
		nbreCycleTotalRecherche +=  nbre;
	}

	public static int getNbreCycleTotalRecherche() {
		return nbreCycleTotalRecherche;
	}

	public static HashSet<Integer> getListeArcSuivant(long i) {
		return arcLies.get(i);
	}

	public static void setStep(int step) {
		Reseau.step = step;
	}

	public static int getStep() {
		return step;
	}

	public static void setUtilisationSysteme(int utilisationSysteme) {
		Reseau.utilisationSysteme = utilisationSysteme;

	}

	public static int getUtilisationSysteme() {
		return utilisationSysteme;
	}

	public static void utiliserSysteme() {
		utilisationSysteme = utilisationSysteme + 1;
	}

	public static double tauxUtilisationSysteme() {
		return (((double) (utilisationSysteme) /nbreStationnements) * 100.0);
	}

	public static float tempsMoyenRecherche() {
		return ((float) (nbreCycleTotalRecherche)) /getNbredemandes();
	}

	public static void annulerdemande() {
		nbredemandesannulees++;
	}

	public static double tempsMoyenRechHC() {
		return ((double) tempsrecherchehorscommunaute / nbredemandehorscommunaute);
	}

	public static int getNbrePlacelibreReseau() {
		int nbpl = 0;
		for (int i = 0; i < listeArc.size(); i++)
			nbpl = nbpl + listeArc.get(i).getNbreplaceslibres();
		return nbpl;

	}
}
