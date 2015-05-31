package simulateur;


import java.util.ArrayList;

import approche.locale.turtles.AssistantApprocheLocale;
import network.structure.RecuperationResultat;
import network.structure.Reseau;
import environnementG.AbstractMadkitBooter;
import graphics.ReseauParam;
import madkit.kernel.Kernel;

public class Main {


	public static void main(String[] args) {
		
		int nombreSimulation = 	1; 		// nombre de simulations
		int nbreAgComm		=	100;	// Agents de la communauté
		int nbreAgHORSComm	=	200;	// Agents en dehors de la communauté
		int nbreIterations	=	100;	// Nombre de pas d'une simulation
		int range  			= 	5; 		//rayon d'actions des voitures 
		int vitesse			=	500;		// "vitesse" de la simulation
		
		Reseau.instancierReseau();	
		simule(nombreSimulation,nbreAgComm,nbreAgHORSComm,25,25,nbreIterations,range, vitesse);
		
		System.exit(0);
	}

	
	public static void simule(int nombreSimulation, int nbreAgentCommunaute, int nbreAgentHCommunaute, 
								int nbreCycleOccupation, int temps, int simTime, int range, int vitesse){
		
		for (int i = 0; i < nombreSimulation ; i++){
			
			//// instancier le tableau des parametres à observer 
			ArrayList<ReseauParam> paramTab = new ArrayList<ReseauParam>();
			//paramTab.add(new ReseauParam("nbreCycleTotalRecherche", "Temps de recherche",simTime,40000));
			paramTab.add(new ReseauParam("tempsMoyenRech", "Temps Moyen de recherche ",simTime,400));
			paramTab.add(new ReseauParam("nbremessageechanges", " Nombre de messages echangés",simTime,100000));
			//paramTab.add(new ReseauParam("nbreCycleVadrouilleMin", " Cycle Vadrouille Minimum",simTime,400));
			//paramTab.add(new ReseauParam("nbreAgHorsCommunaute", " Nombre Agent Hors Communaute",simTime,400));
			//paramTab.add(new ReseauParam("nbreAgCommunaute", "Nombre Agent  Communaute",simTime,400));
			paramTab.add(new ReseauParam("nbrDemandes", "Nombre de demandes",simTime,4000));
			//paramTab.add(new ReseauParam("nbredemandehorscommunaute", "Nombre de demandes hors communanuté",simTime,400));
			//paramTab.add(new ReseauParam("tempsrecherchehorscommunaute", "Temps de recherche hors communanuté",simTime,400));
			//paramTab.add(new ReseauParam("nbrMessageCentalise", "Nombre de messages centralisés",simTime,400));
			//paramTab.add(new ReseauParam("nbreCycleOccupationPlace", "cycle occupation de place",simTime,400));
			//paramTab.add(new ReseauParam("tempsMoyenRechHC", " temps de recherche moyen hors Communaté ",simTime,400));
			//paramTab.add(new ReseauParam("nbrePlaceArc", "Nombre de place des arcs",simTime,400));
			paramTab.add(new ReseauParam("UR", "System Use",simTime,400));
			 
			
			
			Kernel theKernel = new Kernel( "Approche Locale");
			AbstractMadkitBooter gui = new AbstractMadkitBooter(theKernel);
			TurtleNetWorkLauncher pwe = new TurtleNetWorkLauncher(gui, nbreAgentCommunaute,nbreAgentHCommunaute,true,
											nbreCycleOccupation,temps, new SetStep(simTime ),paramTab, range, vitesse);
			theKernel.launchAgent(new RecuperationResultat(), "agent excel", theKernel, false);
			theKernel.launchAgent (pwe, "network agent",theKernel,false);		    	
			
			while(!pwe.finish()){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			theKernel.stopKernel();
			AssistantApprocheLocale.nbMessageCentralise  = 0;
			System.out.println("la liste des places libres par cycles");
			for(int k=0;k<Reseau.nbrePlaceLibresCycle.size();k++)
				System.out.print(""+Reseau.nbrePlaceLibresCycle.get(k)+" , ");
			System.out.println("la liste du nbre de rech par cycles");
			for(int k=0;k<Reseau.nbrePlaceLibresCycle.size();k++)
				System.out.print(""+Reseau.nbreRechCycle.get(k)+" , ");
			System.out.println("la liste du nbre de cir par cycles");
			for(int k=0;k<Reseau.nbreCirCycle.size();k++)
				System.out.print(""+Reseau.nbreCirCycle.get(k)+" , ");
			System.out.println("la liste du nbre de stat par cycles");
			for(int k=0;k<Reseau.nbreStatCycle.size();k++)
				System.out.print(""+Reseau.nbreStatCycle.get(k)+" , ");
		}
	}
		
}
