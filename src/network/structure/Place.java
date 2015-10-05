package network.structure;

import java.util.Comparator;

public class Place implements Comparator<Place> {
	private int idArc;
	private Coordonnees coord;
	private Dimension dimension;
	private int distanceVoiture;

	public Place(int id, Coordonnees c) {
		setIdArc(id);
		setCoordonnees(c);
	}

	public int getIdArc() {
		return idArc;
	}

	public void setIdArc(int id) {
		idArc = id;
	}

	public Coordonnees getCoordonnees() {
		return coord;
	}

	public void setCoordonnees(Coordonnees c) {
		coord = c;
	}

	public int hashCode() {
		return (idArc + coord.getX() + coord.getY());
	}

	public boolean equals(Object p) {
		return (//(p instanceof Place) &&
				(this.getCoordonnees().getX() == ((Place) p).getCoordonnees().getX())
				&& (this.getCoordonnees().getY() == ((Place) p).getCoordonnees().getY()));
	}

	public String toString() {
		return "n°" + idArc + coord;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public int getDistanceVoiture() {
		return distanceVoiture;
	}

	public void setDistanceVoiture(int distanceVoiture) {
		this.distanceVoiture = distanceVoiture;
	}

	@Override
	public int compare(Place o1, Place o2) {
		int poidsPlace = 10, poidsDimension = 1;
		int v1 = (int) (poidsDimension * o1.getDimension().val() + poidsPlace * o1.getDistanceVoiture());
		int v2 = (int) (poidsDimension * o2.getDimension().val() + poidsPlace * o2.getDistanceVoiture());

		return v1 - v2;
	}
}
