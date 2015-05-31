package network.structure;

public class PlaceLiberee {

	private Place place;
	private int date;
	private boolean intention; 
	private double distanceToPlace;
	
	public void setPlace(Place place) {
		this.place = place;
	}

	public Place getPlace() {
		return place;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getDate() {
		return date;
	}

	public int hashCode() {
		return (place.getIdArc() + place.getCoordonnees().getX() + place.getCoordonnees().getY());
	}

	public boolean equals(Object p) {
		return ((p instanceof PlaceLiberee)
				&& (this.place.getCoordonnees().getX() == ((PlaceLiberee) p).getPlace().getCoordonnees().getX())
				&& (this.place.getCoordonnees().getY() == ((PlaceLiberee) p).getPlace().getCoordonnees().getY()));
	}
	
	/////////////////
	
	public double getDistanceToPlace() {
		return distanceToPlace;
	}
	public void setDistanceToPlace(double distanceToPlace) {
		this.distanceToPlace = distanceToPlace;
	}
	public boolean isIntention() {
		return intention;
	}
	public void setIntention(boolean intention) {
		this.intention = intention;
	}

}
