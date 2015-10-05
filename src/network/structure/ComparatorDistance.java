package network.structure;

import java.util.ArrayList;
import java.util.Comparator;

import network.turtles.TurtleNetWorkTurtle;

public class ComparatorDistance implements Comparator<PlaceLiberee> {

	TurtleNetWorkTurtle agent;
	
	public ComparatorDistance( TurtleNetWorkTurtle agent) {
	this.agent = agent;
	}
	@Override
	public int compare(PlaceLiberee arg0, PlaceLiberee arg1) {
	//	System.out.println()
		return distance(agent.cr.calculerChemin(Reseau.getArc(arg0.getPlace().getIdArc()), agent.cr.getArcCourant())) -
		       distance(agent.cr.calculerChemin(Reseau.getArc(arg1.getPlace().getIdArc()),agent.cr.getArcCourant())) ;
//		return CalculReseau.distanceCourante(agent.cr.getArcCourant(), arg0.getPlace(), agent) 
//				- CalculReseau.distanceCourante(agent.cr.getArcCourant(), arg1.getPlace(), agent);
		
	}
	
	private int distance(ArrayList<Arc> che){
	int somme = 0;
	if (che.isEmpty()){// je suis sur le bon arc.
		int positionPlace = agent.cr.getArcCourant().getPositionPlacePossible();
		if ( ((positionPlace > agent.position) && agent.sens)  || ((positionPlace < agent.position) && !agent.sens) )// la place est sur mon chemin
			somme = Math.abs(agent.position-positionPlace);
		else if (positionPlace == agent.position)
			 somme = 0; // je suis déjà à la place
		else
			somme = 2 * (agent.cr.getArcCourant().getPointsArc().size() - 1 - agent.position) + Math.abs(agent.position-positionPlace);; // je dois faire un demi tour.
		return somme;
	}else {
		
	// premier arc : si sens est positif et fin != suivant => taille - position + taille 
		if (agent.sens){			
			somme = agent.cr.getArcCourant().getPointsArc().size() - 1 - agent.position; // je dois aller au bout de l'arc
			if (che.get(0).estExtremite(agent.cr.getArcCourant().getDebut()))
				somme +=  agent.cr.getArcCourant().getPointsArc().size(); // je dois faire demi tour 
		}else {
			somme += agent.position;
			if (che.get(0).estExtremite(agent.cr.getArcCourant().getFin()))
				somme +=  agent.cr.getArcCourant().getPointsArc().size(); // je dois faire demi tour
		}
	}		
	somme += che.size(); // prendre en compte le temps de latence aux carrefours

	for (int j = 0; j < che.size();j++){ // mettre à -1 pour traiter le dernier
			somme += che.get(j).getPointsArc().size();
	}
	
	
	
	// traitement du dernier: je ne le parcours qu'en partie. TO DO
	
	
		return somme;
	}
	
	public int testCompare(PlaceLiberee arg0){
		Arc dest = Reseau.getArc(arg0.getPlace().getIdArc());
		Arc orig = agent.cr.getArcCourant();
		ArrayList<Arc> ch = agent.cr.calculerChemin(dest,orig);
		int i = distance(ch); 
		return i ;
	}
	
		
}
