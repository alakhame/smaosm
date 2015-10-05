package network.structure;

import turtlekit.kernel.TurtleScheduler;

public class PlaceLiberee {

	private Place place;
	private int date;
	private boolean intention; 
	private double distanceToPlace;
	
	public PlaceLiberee(Place place) {
		setDate(TurtleScheduler.iteration);
		setPlace(place);
		setDistanceToPlace(100000);
		setIntention(false);		
		
	}

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
		return place.equals(((PlaceLiberee)p).getPlace());
			
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
	
	public String toString(){
		return place.getIdArc() + ":" + distanceToPlace + ":" + date+":"+intention;
	}

}
