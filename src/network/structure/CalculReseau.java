package network.structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import network.turtles.TurtleNetWorkTurtle;

public class CalculReseau {

	private Arc arcCourant;
	private Arc[] precedent;
	private ArrayList<Arc> chemin;
	TurtleNetWorkTurtle agent;

/*	public void printChemin(){
		System.out.println("agent " + agent.getAddress());
		for (Arc a : precedent)
			System.out.println(a);
		System.exit(0);
	}
	*/
	public CalculReseau(TurtleNetWorkTurtle agent) {
		precedent = new Arc[Reseau.getNbreArc()];
		chemin = new ArrayList<Arc>();
		arcCourant = Reseau.getArcDebut();
		this.agent = agent;
	}
	

	/*
	 * Enregistre dans precédent le plus court chemin ?
	 */
	public void plusCourtChemin() {
		precedent = new Arc[Reseau.getNbreArc()];
		int taille = Reseau.getNbreArc();
		ArrayList<Arc> listeArcs = Reseau.getListeArc();

		CheminArc[] liste = new CheminArc[Reseau.getNbreArc()];
		for (int j = 0; j < Reseau.getNbreArc(); j++) {
			if (listeArcs.get(j).getId() != arcCourant.getId())
				liste[j] = new CheminArc(listeArcs.get(j), 340000000);
			else
				liste[j] = new CheminArc(listeArcs.get(j), 0);
		}
		while (taille != 0) {
			int indice = arcDistanceMinimum(liste, taille);
			if (indice != -1) {
				Arc n = liste[indice].getArc();

				HashSet<Integer> suivant = Reseau.getListeArcSuivant((long) n.getId());

				Iterator<Integer> iterateur = suivant.iterator();
				int h;
				Arc s;
				while (iterateur.hasNext()) {
					int k=iterateur.next();
					s = Reseau.getArc(k);
					h = 0;
					if(s==null)System.exit(0); //bug
					while ((liste[h].getArc().getId() != s.getId())
							&& (h < taille)) {

						h++;
					}
					if (h < taille) {
						if (liste[h].getParcouru() > liste[indice]
								.getParcouru() + distanceArc(n, s)) {
							liste[h].setParcouru(liste[indice].getParcouru()
									+ distanceArc(n, s));
							precedent[s.getOrder() - 1] = n;

						}
					}
				}
				// supprimer l'élément de la liste
				for (int k = indice; k < taille - 1; k++) {
					liste[k] = liste[k + 1];
				}
				taille--;
			}
		}
	}
	
	public static CheminArc[] plusCourtCheminStatic(Arc [] precedent, Arc arcCourant) {
		
		int taille = Reseau.getNbreArc();
		ArrayList<Arc> listeArcs = Reseau.getListeArc();
// initialise tous les arc + distance
		CheminArc[] arcPondere = new CheminArc[Reseau.getNbreArc()];
		for (int j = 0; j < Reseau.getNbreArc(); j++) {
			if (listeArcs.get(j).getId() != arcCourant.getId())
				arcPondere[j] = new CheminArc(listeArcs.get(j), 340000000);
			else
				arcPondere[j] = new CheminArc(listeArcs.get(j), 0);
		}
// parcours tous les arcs		
		while (taille != 0) {
// retourne l'indice de l'arc le plus proche			
			int indice = arcDistanceMinimum(arcPondere, taille);
			if (indice != -1) {
				Arc n = arcPondere[indice].getArc();
// récupère les arcs suivants du plus proche
				HashSet<Integer> suivant = Reseau.getListeArcSuivant((long) n.getId());

				Iterator<Integer> iterateur = suivant.iterator();
				int h;
				Arc s;
				while (iterateur.hasNext()) {
					int k=iterateur.next();
// s est un suivant
					s = Reseau.getArc(k);
					h = 0;
					if(s==null)System.exit(0); //bug
//	recherche s dans arcPondere				
					while ((arcPondere[h].getArc().getId() != s.getId()) && (h < taille)) {
						h++;
					}
// je l'ai trouvé
					if (h < taille) {
						if (arcPondere[h].getParcouru() > arcPondere[indice].getParcouru() + distanceArc(n, s)) {
// la nouvelle distance est plus courte
							arcPondere[h].setParcouru(arcPondere[indice].getParcouru()+ distanceArc(n, s));
							precedent[s.getOrder() - 1] = n;
						}
					}
				}// j'ai parcouru tous les suivants
				// supprimer l'élément de la liste
				for (int k = indice; k < taille - 1; k++) {
					arcPondere[k] = arcPondere[k + 1];
				}
				taille--;
			}
		}
		return arcPondere;
	}


	/*
	 * le chemin le plus court pour arriver à une destination dans le cas de
	 * recherche de place
	 */
	public void getChemin(Arc fin, Arc debut) {
		Arc n = fin;
		chemin = new ArrayList<Arc>();
		while (n.getId() != debut.getId()) {
			chemin.add(0, n);
			if (precedent[n.getOrder() - 1] != null)
				n = precedent[n.getOrder() - 1];
			else
				n = debut;
		}
	}
	public ArrayList<Arc> calculerChemin(Arc fin, Arc debut) {
		Arc[] nPrecedent = new Arc[precedent.length];
		
		for (int i = 0; i < precedent.length; i++)
			nPrecedent[i] = precedent[i];
		
		Arc n = fin;
		ArrayList<Arc>nChemin = new ArrayList<Arc>();
		while (n.getId() != debut.getId()) {
			nChemin.add(0, n);
			if (nPrecedent[n.getOrder() - 1] != null)
				n = nPrecedent[n.getOrder() - 1];
			else
				n = debut;
		}
		return nChemin;
	}
	
	
	public static ArrayList<Arc> getCheminStatic(Arc [] precedent, Arc fin, Arc debut) {
		Arc n = fin;
		ArrayList<Arc> chemin = new ArrayList<Arc>();
		while (n.getId() != debut.getId()) {
			chemin.add(0, n);
			if (precedent[n.getOrder() - 1] != null)
				n = precedent[n.getOrder() - 1];
			else
				n = debut;
		}
		return chemin;
	}
	/*
	 * méthode utilisée pour le calcul du plus court chemin
	 */
	private static int arcDistanceMinimum(CheminArc[] t, int nbreElem) {
		int min;
		if (nbreElem != 0) {
			min = 0;
			if (nbreElem > 1) {
				for (int s = 1; s < nbreElem; s++)
					if (t[min].getParcouru() > t[s].getParcouru())
						min = s;
			}
			return min;
		}
		return -1;
	}

	/*
	 * calculer la distance entre deux arcs du début du premier jusqu'à la fin
	 * du 2eme
	 */
	private static double distanceArc(Arc a1, Arc a2) {
		double dist = a1.longueurArc() + a2.longueurArc();
		return dist;
	}

/*	private double distanceChemin(Arc fin, Place pl, ArrayList<Arc> ch) {
		double dist = 0;
		if (ch.size() < 1)
			dist=distanceCoord(pl.getCoordonnees(), arcCourant.getPositionArc(agent.position));
			
		else if (ch.size() == 1) {
			if ((arcCourant.getFin().equals(fin.getDebut())) || (arcCourant.getDebut().equals(fin.getDebut())))
				dist = distancePlaceArc(arcCourant, arcCourant.getPositionArc(agent.position), !agent.sens)
						+ distancePlaceArc(fin, pl.getCoordonnees(), false);
			else
				dist = distancePlaceArc(arcCourant,arcCourant.getPositionArc(agent.position), !agent.sens)
						+ distancePlaceArc(fin, pl.getCoordonnees(), true);
		} else {
			dist = distanceCourante(arcCourant, null);
			for (int i = 0; i < ch.size() - 1; i++)
				dist = +ch.get(i).longeurArc();
			if (((ch.get(ch.size() - 1).getDebut().getX() == ch.get(ch.size() - 2).getDebut().getX()) 
					&& (ch.get(ch.size() - 1).getDebut().getY() == ch.get(ch.size() - 2).getDebut().getY()))
					|| (ch.get(ch.size() - 1).getDebut().getX() == ch.get(ch.size() - 2).getFin().getX())
					&& (ch.get(ch.size() - 1).getDebut().getY() == ch.get(ch.size() - 2).getFin().getY()))
				
				dist = +distancePlaceArc(ch.get(ch.size() - 1),pl.getCoordonnees(), false);
			
			else if (((ch.get(ch.size() - 1).getFin().getX() == ch.get(ch.size() - 2).getDebut().getX()) 
						&& (ch.get(ch.size() - 1).getFin().getY() == ch.get(ch.size() - 2).getDebut().getY()))
						|| (ch.get(ch.size() - 1).getFin().getX() == ch.get(ch.size() - 2).getFin().getX())
						&& (ch.get(ch.size() - 1).getFin().getY() == ch.get(ch.size() - 2).getFin().getY()))
				
				dist = +distancePlaceArc(ch.get(ch.size() - 1),pl.getCoordonnees(), true);
		}
		return dist;
	}
*/
	public int distanceCourante(Place p) {
		return distanceCourante(arcCourant, p, agent);
	}

	public static int distanceCourante(Arc arcCourant, Place p, TurtleNetWorkTurtle turtle) {
		int x, y;
		if (p != null) {
			x = p.getCoordonnees().getX();
			y = p.getCoordonnees().getY();
		} else {
			if (turtle.sens) {
				x = arcCourant.getFin().getX();
				y = arcCourant.getFin().getY();
			} else {
				x = arcCourant.getDebut().getX();
				y = arcCourant.getDebut().getY();
			}
		}

		int d;
		d = (int) distanceCoord(arcCourant.getPositionArc(turtle.position), new Coordonnees(x, y));
		return d;
	}

	
	
	public int distancePlaceArc(Arc a, Coordonnees p, boolean direction) {
		int reste;
		if (direction)
			reste=(int) distanceCoord(a.getFin(), p);
		else
			reste=(int) distanceCoord(a.getDebut(), p);
		return reste;
	}

	public static double distanceCoord(Coordonnees a, Coordonnees b) {
		double dist;
		dist = Math.sqrt(Math.pow(Math.abs(a.getX() - b.getX()), 2)
				+ Math.pow(Math.abs(a.getY() - b.getY()), 2));
		return dist;
	}
	
	
	
	public Arc getArcCourant() {
		return arcCourant;
	}

	public void setArcCourant(Arc arcCourant) {
		this.arcCourant = arcCourant;
	}

	public Arc[] getPrecedent() {
		return precedent;
	}

	public void setPrecedent(Arc[] precedent) {
		this.precedent = precedent;
	}

	public ArrayList<Arc> getChemin() {
		return chemin;
	}

	public void setChemin(ArrayList<Arc> chemin) {
		this.chemin = chemin;
	}

}
