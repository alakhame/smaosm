package network.structure;

import java.util.ArrayList;

public class Arc {

	private Coordonnees debut, fin;
	private int idArc;
	private int order;
	private ArrayList<PositionStationnement> pointsArc;
	private int nbreplaceslibres = 1;
	private int nbrePlaces = 0;
	private int nbrepositionplace = 1;

	public boolean equals(Arc a){
		return (debut.equals(a.debut) && fin.equals(a.fin));
	}
	
	public boolean estExtremite(Coordonnees c){
// retourne vraie si la c correspond à debut ou fin
		return debut.equals(c) || fin.equals(c);
	}
	
	public Arc(ArrayList<Coordonnees> coord, int id) {
		order = Reseau.arcCount();
		debut = coord.get(0);
		fin = coord.get(coord.size() - 1);
		idArc = id;
		pointsArc = new ArrayList<PositionStationnement>();

		//int i = debut.getX();
		//int j = debut.getY();
		int p;

		for (Coordonnees c : coord) {
			pointsArc.add(new PositionStationnement(c));
			nbrePlaces++;
		}
		 
		
		for (int s = 0; s < nbrepositionplace; s++) {
			p = 0;
			while ((p == 0) || (p >= nbrePlaces)) {
				p = (int) (Math.random() * nbrePlaces);
				if (p < nbrePlaces - 1)
					if (pointsArc.get(p).place)
						p = 0;
			}
			if(order%2==0)
			pointsArc.get(p).place = true;
			else pointsArc.get(p).place = false;
		}
		
	}

	public Coordonnees getDebut() {
		return debut;
	}

	public Coordonnees getPositionArc(int index) {
		if (index < pointsArc.size() && (index >= 0))
			return pointsArc.get(index).position;
		return null;
	}

// longueur selon la distance euclidienne
/*	public double longeurArc() {
		double longueur = 0.0;
		for (int k = 0; k < pointsArc.size() - 1; k++) {
			longueur += Math
					.sqrt(Math.pow(
							pointsArc.get(k).position.getX()
									- pointsArc.get(k + 1).position.getX(), 2.0)
							+ (Math.pow(pointsArc.get(k).position.getY()
									- pointsArc.get(k + 1).position.getY(), 2.0)));
		}
		return longueur;
	}

	public void setDebut(Coordonnees d) {
		debut = d;
	}
*/
	public double longueurArc() {
// la longueur d'un arc est égale à sa taille en nombre de positions. 
		return this.pointsArc.size();
	}
	
	public Coordonnees getFin() {
		return fin;
	}

	public void setFin(Coordonnees f) {
		fin = f;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return this.order;
	}

	public ArrayList<Coordonnees> getPointsArc() {
		ArrayList<Coordonnees> pos = new ArrayList<Coordonnees>();
		int i = 0;
		while (i < pointsArc.size()) {
			pos.add(pointsArc.get(i).position);
			i++;
		}
		return pos;
	}

	public boolean isPositionPlace(int pos) {
		return pointsArc.get(pos).place;
	}
	
	public boolean contientPlace(){
		boolean b = false;
		for (int i =0; i<pointsArc.size(); i++){
			if (isPositionPlace(i))
				return true;
		}
		return false;
	}
	
	public Coordonnees getPlace(){
		for (int i =0; i<pointsArc.size(); i++){
			if (isPositionPlace(i))
				return pointsArc.get(i).position;
		}
		return null;
	
	}


	public void setPointsArc(ArrayList<Coordonnees> p) {
		int i = 0;
		while (i < p.size())
			pointsArc.add(new PositionStationnement(p.get(i)));
	}

	public int getId() {
		return idArc;
	}

	public void setNbreplaceslibres(int nbreplaceslibres) {
		this.nbreplaceslibres = nbreplaceslibres;
	}

	public int getNbreplaceslibres() {
		return nbreplaceslibres;
	}

	public void setNbrePlaces(int nbrePlaces) {
		this.nbrePlaces = nbrePlaces;
	}

	public int getNbrePlaces() {
		return nbrePlaces;
	}

	public void diminuerPlace() {
		nbreplaceslibres--;
	}

	public void ajouterPlaceLibre() {
		nbreplaceslibres++;
	}

	public String toString() {
		return idArc + " de " + debut + " fin " + fin + " place " + pointsArc;
	}
	
	

	public class PositionStationnement {
		Coordonnees position;
		boolean place;

		public PositionStationnement(Coordonnees cord) {
			position = cord;
			place = false;
		}
		public String toString(){
			return position.toString() + ":" + place;
		}
	}



	public int getPositionPlacePossible() {
		int j = 0;
		while (j< pointsArc.size()){
			if (pointsArc.get(j).place)
				return j;
			j++;
		}
		return 0; // position par defaut
	}
}
		


