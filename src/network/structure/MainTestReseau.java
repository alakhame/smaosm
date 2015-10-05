package network.structure;

import java.util.ArrayList;

public class MainTestReseau {

	public static void main(String[] args) {
		//Reseau.instancierReseau();
		
		
		
		System.out.println(Reseau.getNbreArc());
		Arc [] precedent = new Arc[Reseau.getNbreArc()];
		Arc arcCourant = Reseau.getArcDebut();
		CalculReseau.plusCourtCheminStatic(precedent, arcCourant);
		ArrayList<Arc> resultat = CalculReseau.getCheminStatic(precedent, precedent[2], precedent[19]);
		System.out.println(" arc après plusCourt ");
		for (int i = 0; i < 10; i++){
			System.out.println(Reseau.getArcI(i));
		}
		
		System.out.println("depuis " + precedent[2] + " a " + precedent[19]);
//		System.out.println("chemin " + resultat);
	/*	for (Arc a : precedent)
			System.out.println(a);
		*/
		
		for (Arc ca : resultat)
			System.out.println(ca);
		 
		//CalculReseau.distanceCourante(a, arcCourant, p, turtle)

	}

}
