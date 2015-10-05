package network.structure;

public class PlaceInfo {
	private Place place;
	private boolean intention;
	private int date;
	private double distanceToPlace;
	
	
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public boolean isIntention() {
		return intention;
	}
	public void setIntention(boolean intention) {
		this.intention = intention;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public double getDistanceToPlace() {
		return distanceToPlace;
	}
	public void setDistanceToPlace(double distanceToPlace) {
		this.distanceToPlace = distanceToPlace;
	}
}
