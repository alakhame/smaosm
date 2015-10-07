package simulateur;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import approche.locale.turtles.AssistantApprocheLocaleFull;
import network.structure.Arc;
import network.structure.RecuperationResultat;
import network.structure.Reseau;
import environnementG.AbstractMadkitBooter;
import graphics.ReseauParam;
import madkit.kernel.Kernel;

public class Main {
	
	public static Runtime rt = Runtime.getRuntime(); 
	public static long memory0, memUsage;
	public static void main(String[] args) throws FileNotFoundException {
		Main.rt.gc();
	    memory0 = rt.totalMemory() - rt.freeMemory();
		
		int nombreSimulation = 	1; 		// nombre de simulations
//		int nbreAgComm		=	200;	// Agents de la communaut�
//		int nbreAgHORSComm	=	00;	// Agents en dehors de la communaut�
		int simTime	=	1000;		// Nombre de pas d'une simulation + il est important meilleur est le r�sultat ?
		int range  	= 	10; 		//rayon d'actions des voitures 
		int maxRange = 5;
		int vitesse			=	1;	// "vitesse" de la simulation (inversement proportionnelle)
		int nbreCycleOccupation	= 5;
		boolean isGraphic = false;
		String typeAgent = "coopetitif";
		
		Reseau.instancierReseau();
		for (Arc c : Reseau.listeArc)
			System.out.println(c);
		//System.exit(0);
		
		System.out.println(Reseau.getNbreArc());
		
		// premier test 
			// nombre agent Communaut� coopetitif / Fully cooperatif / stupide => seul
			int nbrAgentMin = 40;
			int nbrAccroissement = 20;
			int nbrAgentMax = 400;
			
		//	simule(nombreSimulation,280,0,nbreCycleOccupation,simTime,range, vitesse,isGraphic,typeAgent);
		
		/***** Full vs randon *****/
			int totalAgents = 300; 
			for(int k=0; k<=totalAgents; k+=20){
		 		for (int r = 5; r <= maxRange ; r += 5){ 
					for (int q = 0; q < 10 ; q++){ 
						simule(nombreSimulation,k,totalAgents-k,nbreCycleOccupation,simTime,r, vitesse,isGraphic,"full");
					}
				}
			}
		  
			
			
		/****** Scale sim 
			for (int k = nbrAgentMin; k <= nbrAgentMax ; k+=nbrAccroissement ){ 
				for (int r = 5; r <= maxRange ; r += 5){ 
					for (int q = 0; q < 10 ; q++){ 
						simule(nombreSimulation,k,0,nbreCycleOccupation,simTime,r, vitesse,isGraphic,"full");
					}
					for (int q = 0; q < 10 ; q++){ 
						simule(nombreSimulation,k,0,nbreCycleOccupation,simTime,r, vitesse,isGraphic,"coopetitif");
					}
				}
			}
		****/
			
/*			for (int nbA = nbrAgentMin; nbA < nbrAgentMax ; nbA += nbrAccroissement){
				simule(nombreSimulation,nbA,0,nbreCycleOccupation,simTime,range, vitesse,isGraphic,typeAgent);
				//simule(nombreSimulation,nbA,nbrAgentMax-nbA,nbreCycleOccupation,simTime,range, vitesse,isGraphic);
			}
*/
			
	//	simule(nombreSimulation,0,200,nbreCycleOccupation,simTime,range, vitesse,isGraphic);
		
/*		simule(nombreSimulation,50,50,nbreCycleOccupation,simTime,range, vitesse,isGraphic);
		
		simule(nombreSimulation,100,100,nbreCycleOccupation,simTime,range, vitesse,isGraphic);
		
		simule(nombreSimulation,200,200,nbreCycleOccupation,simTime,range, vitesse,isGraphic);
		
		simule(nombreSimulation,400,400,nbreCycleOccupation,simTime,range, vitesse,isGraphic);
*/		
			System.out.println("check called "+Reseau.callCheck+" times");
	    
			
		System.exit(0);
	}

	
	public static void simule(int nombreSimulation, int nbreAgentCommunaute, int nbreAgentHCommunaute, 
								int nbreCycleOccupation, int simTime, int range, int vitesse, boolean isGraphic,String typeAgent){
		for (int i = 0; i < nombreSimulation ; i++){
			
			//// instancier le tableau des parametres � observer 
			ArrayList<ReseauParam> paramTab = new ArrayList<ReseauParam>();
			//paramTab.add(new ReseauParam("nbreCycleTotalRecherche", "Temps de recherche",simTime,40000));
					//paramTab.add(new ReseauParam("tempsMoyenRech", "Temps Moyen de recherche ",simTime,400));
					//paramTab.add(new ReseauParam("nbremessageechanges", " Nombre de messages echang�s",simTime,100000));
			//paramTab.add(new ReseauParam("nbreCycleVadrouilleMin", " Cycle Vadrouille Minimum",simTime,400));
			//paramTab.add(new ReseauParam("nbreAgHorsCommunaute", " Nombre Agent Hors Communaute",simTime,400));
			//paramTab.add(new ReseauParam("nbreAgCommunaute", "Nombre Agent  Communaute",simTime,400));
					//paramTab.add(new ReseauParam("nbrDemandes", "Nombre de demandes",simTime,4000));
			//paramTab.add(new ReseauParam("nbredemandehorscommunaute", "Nombre de demandes hors communanut�",simTime,400));
			//paramTab.add(new ReseauParam("tempsrecherchehorscommunaute", "Temps de recherche hors communanut�",simTime,400));
			//paramTab.add(new ReseauParam("nbrMessageCentalise", "Nombre de messages centralis�s",simTime,400));
			//paramTab.add(new ReseauParam("nbreCycleOccupationPlace", "cycle occupation de place",simTime,400));
			//paramTab.add(new ReseauParam("tempsMoyenRechHC", " temps de recherche moyen hors Communat� ",simTime,400));
			//paramTab.add(new ReseauParam("nbrePlaceArc", "Nombre de place des arcs",simTime,400));
					//paramTab.add(new ReseauParam("UR", "System Use",simTime,400));
			 
			
			Kernel theKernel = new Kernel( "Approche Locale");
			AbstractMadkitBooter gui = new AbstractMadkitBooter(theKernel);
	
			TurtleNetWorkLauncher pwe = new TurtleNetWorkLauncher(gui, nbreAgentCommunaute,nbreAgentHCommunaute,isGraphic,
											nbreCycleOccupation, new SetStep(simTime ),paramTab, range, vitesse,simTime,typeAgent);
		
			//theKernel.launchAgent(new RecuperationResultat(), "agent excel", theKernel, false);
			theKernel.launchAgent (pwe, "network agent",theKernel,false);		    	
//			Reseau.afficheArcLie();
			
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
			Reseau.printState();
			RecuperationResultat agentExcel = new RecuperationResultat();
			agentExcel.creationfichier();
		 
		}
		
	}
		
}
