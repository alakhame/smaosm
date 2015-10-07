package approche.locale.turtles;

import java.util.ArrayList;
import java.util.TreeSet;

import approche.locale.turtles.AssistantApprocheLocaleFull.ModuleCommunication;
import approche.locale.turtles.AssistantApprocheLocaleFull.ModuleGestionDesListes;
import approche.locale.turtles.AssistantApprocheLocaleFull.ModuleUtilitaire;
import simulateur.TurtleNetWorkLauncher;
import turtlekit.kernel.TurtleScheduler;
import network.structure.Arc;
import network.structure.ComparatorDistance;
import network.structure.PlaceLiberee;
import network.structure.Reseau;
import network.turtles.TurtleNetWorkTurtle;
import network.turtles.TurtleState;

public class AssistantApprocheLocalCoopetitif extends AssistantApprocheLocaleFull{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		/*
	 * 
	 * Constructeur / initialisation
	 * 
	 */
		public AssistantApprocheLocalCoopetitif(String s) {
			super(s);
			mu = new ModuleUtilitaireCoopetitif();
			mgdl = new ModuleGestionDesListesCoopetitif();
		}

		public AssistantApprocheLocalCoopetitif() {
			super();
			mu = new ModuleUtilitaireCoopetitif();
			mgdl = new ModuleGestionDesListesCoopetitif();
		}

		public AssistantApprocheLocalCoopetitif(String string, boolean b) {
			super(string,b);
			mu = new ModuleUtilitaireCoopetitif();
			mgdl = new ModuleGestionDesListesCoopetitif();
		}

		public AssistantApprocheLocalCoopetitif(String s, int temps) {
			super(s,true);
		}
		
		@Override
		protected void remiseEncausePlaceChoisie() {
			if (placeChoisie != null){
	// remise en cause car la place a �t� identifi�e comme occup�e
				PlaceLiberee pl = new PlaceLiberee(placeChoisie);
				int i = mgdl.listenoire.indexOf(pl); // mgdl.listenoire.contains(pl)
				if (i != -1){ // contient => je cherche une autre
//					if (getName().equals("turtle1")) System.out.println( pl + " est dans liste noire " + mgdl.listenoire);
					placeChoisie = null;
					tempsAccesPlaceChoisie = -1;
					cr.setChemin(new ArrayList<Arc>());
					setState(TurtleState.cherche);
				}else if (state.equals(TurtleState.cherche) || state.equals(TurtleState.versPlace)){
//test si il n'y a pas une meilleure place si j'en cherche une
	//				System.out.println(" cherche mieux " + placeChoisie);
					mu.recherchePlace();
					}		
			}
				
				
		}

	protected class ModuleUtilitaireCoopetitif extends AssistantApprocheLocaleFull.ModuleUtilitaire{
	
		public void recherchePlace() {
			PlaceLiberee pl;
			if (mgdl.listePlaces.size() != 0) {
				println(" searching for a new place among "+ mgdl.listePlaces.toString());
				/******* ADD 2.0 *********************/
				ComparatorDistance comparatorD = new ComparatorDistance(AssistantApprocheLocalCoopetitif.this);
				cr.plusCourtChemin();
				TreeSet<PlaceLiberee> candidates = new TreeSet<PlaceLiberee>(comparatorD);
				candidates.addAll(mgdl.listePlaces);
				pl = candidates.first();
				int distance = comparatorD.testCompare(pl);
// je choisis la place si j'en ai pas d'autres ou j'ai plus proche.	
				
				if ( (placeChoisie == null) || (distance < tempsAccesPlaceChoisie - (TurtleScheduler.iteration - dateAccesPlaceChoisie))){
					//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
					//System.out.println("Before "+mgdl.listePlaces.size()+": "+mgdl.listePlaces);
 					placeChoisie = pl.getPlace(); // on a trouve la plus proche libre
					cr.getChemin(Reseau.getArc(placeChoisie.getIdArc()),cr.getArcCourant());
					tempsAccesPlaceChoisie = distance;
					dateAccesPlaceChoisie = TurtleScheduler.iteration;
					//System.out.println("Candidates "+candidates);
					mgdl.retraitListeBlanche(pl); 
					//System.out.println("Betrayal");
					
					//System.out.println("After "+mgdl.listePlaces.size()+": "+mgdl.listePlaces);
				}
				return;		
			}		
		}
	}
		protected class ModuleGestionDesListesCoopetitif extends AssistantApprocheLocaleFull.ModuleGestionDesListes{
			@Override
			void VerificationListe() {
				super.VerificationListe();
				if (AssistantApprocheLocalCoopetitif.this.placeChoisie != null){
					//System.out.println("************************");
					retraitListeBlanche(new  PlaceLiberee(AssistantApprocheLocalCoopetitif.this.placeChoisie));
					//System.out.println("Betrayal !");
				}
			}
		}

}
