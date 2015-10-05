package network.turtles;

import network.structure.*;
import network.turtles.TurtleNetWorkTurtle;
import turtlekit.kernel.Turtle;

public abstract class TurtleNetWorkTurtle extends Turtle {
	public CalculReseau cr;
	public int cycleArret = 0;
//à decommenter si gestion individuelle du temps de recherche
//	public int cycleCherche = 0;
	public int cycleVadrouille = 0;
// valeur de comportement propre à chaque agent
	protected int tempsStationnement;
	protected int tempsVadrouille;
	public boolean sens;
	public boolean print = false;
	public int position;
	private static final long serialVersionUID = 1L;
	public TurtleState state;
	protected boolean gare = false;

	public boolean isGare() {
		return gare;
	}

	public void setGare(boolean gare) {
		//this.gare = gare;
	}

	public TurtleNetWorkTurtle(String s, boolean print) {
		super(s);
		cr = new CalculReseau(this);
		this.print = print;
		tempsStationnement = Reseau.getTempsOccupation();
		tempsVadrouille = Reseau.getTempsVadrouille();
	}

	public TurtleNetWorkTurtle(String s) {
		this(s, true);
	}

	public TurtleNetWorkTurtle() {
		super();
		cr = new CalculReseau(this);
	}

	public void setup() {
		playRole("Car");
	}

	public void println(String m) {
	//	if (!print)
	//		super.println(m);
	}
	
	public void trace(){

	/*	if (this.getName().equals("turtle1")){
		System.out.println(cr.getArcCourant() + " "+ sens + " " + position + ":" + cr.getArcCourant().getPositionArc(position) + " etat " + this.state);
		}
	*/	
	}
// remise à zéro lorsque l'agent repart
	protected void initialisation() {
//		cycleCherche = 0;
		cycleArret = 0;
		cycleVadrouille = 0;
		sens = true;
	}
// modification de l'état de l'agent
	public abstract void setState(TurtleState ts);


	private void avancer(int x, int y){
		moveTo(x,y);
	}

	protected void circuler(){
// définie mon nouvel état
		nouvelleEtat();
		if (state != TurtleState.arret){
			nouvellePosition();
			avancer(cr.getArcCourant().getPositionArc(position).getX(),
					cr.getArcCourant().getPositionArc(position).getY());
		}
	}
	/*
	 * agent se déplace et choisi son prochain arc. attentePlace => arret (si
	 * placeLibre) vadrouille => cherche si nbreCycle correct
	 */
	
	protected  Arc arcSuivant(){
		if (sens) // dans le sens des arcs donc à la fin
			return Reseau.getArcSuivant(cr.getArcCourant(), cr.getArcCourant().getFin());
		return Reseau.getArcSuivant(cr.getArcCourant(), cr.getArcCourant().getDebut());
	}
	
	protected void nouvellePosition() {
// je suis arrivé au bout de l'arc	
		if ((cr.getArcCourant().getPositionArc(position).equals(cr.getArcCourant().getFin()) && sens)
				|| (cr.getArcCourant().getPositionArc(position).equals(cr.getArcCourant().getDebut()) && !sens)) {

			Arc suiv = arcSuivant();			
//retourne l'arc courant si  le bon arc mais mauvais sens.
			if (suiv.equals(cr.getArcCourant())){// je reste sur le même arc => demi tour
						if (sens)
							position = suiv.getNbrePlaces() - 1;
						else 
							position = 0;
						sens = !sens;
				}else if (sens){ // je suis à la fin de l'arc courant
						if (cr.getArcCourant().getFin().equals(suiv.getDebut())) {
							// je suis au debut de l'arc suivant
							position = 0;
							sens = true;
						} else if (cr.getArcCourant().getFin().equals(suiv.getFin())){
							// je suis à la fin de l'arc suivant
							position = suiv.getNbrePlaces() - 1;
							sens = false;
						} 
					}else // je suis au debut de l'arc courant
						if (cr.getArcCourant().getDebut().equals(suiv.getDebut())) {
							// debut de l'arc suivant
							position = 0;
							sens = true;
						} else if (cr.getArcCourant().getDebut().equals(suiv.getFin())) {
							// fin de l'arc suivant
							position = suiv.getNbrePlaces() - 1;
							sens = false;
							}
			cr.setArcCourant(suiv);
		}else{
			if (sens)
				position++;
			else 
				position--;
			}
	}
	
	protected abstract void miseAjourDemande();
	
	protected void tr_vadrouille_cherche(){
		miseAjourDemande(); // met à jour le nombre de demande selon le type d'agents.
		setState(TurtleState.cherche); // je me met en état de recherche
		cycleVadrouille = 0;
//		cycleCherche = 1;
	}
	/*
	* passe de l'état arret à l'état vadrouille
	* remise à 0 des compteurs
	*/
		protected void tr_arret_vadrouille() {
			setState(TurtleState.vadrouille);
			Reseau.libererPlaceArc(cr.getArcCourant());
			cycleArret = 0;
			cycleVadrouille = 0;
		}
		
		public void tr_vadrouille_vadrouille(){
			cycleVadrouille++;
		}
		
		public void tr_cherche_cherche(){
//			cycleCherche++;
		}


		
		public void tr_arret_arret(){
			cycleArret++;
		}
		/*
		 * passe à l'état arret. sauf pour le premier pas (?) cela ajoute une
		 * demande : on suppose que l'agent venait de faire une demande
		 */
		protected abstract void tr_cherche_arret(); 
	
	/*
	 * je me suis déplacé, je regarde mon nouvel état et me met à jour
	 */
	protected void nouvelleEtat(){ // vadrouille => cherche => arret
	switch (state) {
		case vadrouille: {
			if (cycleVadrouille > tempsVadrouille) {
				tr_vadrouille_cherche();
			}else
				tr_vadrouille_vadrouille();
			break;
		}

		case cherche: {
				Reseau.incNbreCycleTotalhorscommunaute(1,this);
			// je suis à la position d'une place et c'est libre
				int i = turtlesHere().length;
				boolean test = cr.getArcCourant().isPositionPlace(position);
				String testArc = cr.getArcCourant().toString();
			if (positionCouranteLibre()) {
// la place est libre : je me gare
				if (!cr.getArcCourant().getPlace().equals( cr.getArcCourant().getPositionArc(position))){ System.out.println("pb"); System.exit(0);}
					tr_cherche_arret();
				}else
					tr_cherche_cherche();
			break;
			}
		case arret: {
			if (cycleArret > tempsStationnement) {
				tr_arret_vadrouille();
			} else
				tr_arret_arret();
			}
			break;
		}
		trace();
	}
	public int nbreStationnePosition() {
		int nbrestationne = 0;
		Turtle[] turtlehere = turtlesHere();
		for (int k = 0; k < turtlehere.length; k++) {
			if (((TurtleNetWorkTurtle) (turtlehere[k])).state == TurtleState.arret) {
				nbrestationne++;
				
			}
		}
		return nbrestationne;
	}
	
	public int nbreStationnePositionBis() {
		int nbrestationne = 0;
		Turtle[] turtlehere = turtlesHere();
		for (int k = 0; k < turtlehere.length; k++) {
			if (((TurtleNetWorkTurtle) (turtlehere[k])).state == TurtleState.arret) {
				nbrestationne++;
//				System.out.println("agent déja présent : " + turtlehere[k].getName());
			}
		}
		return nbrestationne;
	}
	public boolean positionCouranteLibre() {
		return  (cr.getArcCourant().isPositionPlace(position) &&
				(stationnementLibre()));
	}
	
	public boolean stationnementLibre(){
		Turtle[] turtlehere = turtlesHere();
		for (int k = 0; k < turtlehere.length; k++) {
			if (((TurtleNetWorkTurtle) (turtlehere[k])).state == TurtleState.arret) {
				return false;
//			System.out.println("agent déja présent : " + turtlehere[k].getName());
			}
		}
		return true; // c'est une place et elle est libre;
	}
}
