package graphics;

import approche.locale.turtles.AssistantApprocheLocaleFull;
import network.structure.Reseau;
import turtlekit.kernel.Observer;

public class ReseauObserver extends Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5459062570828459776L;

	PlotPanel plot;
	ReseauParam param;

	public ReseauObserver(ReseauParam rp) {
		this.param = rp;
	}

	@Override
	public void activate() {
		 
		super.activate();
	}

	@Override
	public void setup() {
		 
		plot.initialisation();
	}

	@Override
	public void watch() {
		 

		if (param.getName().equals("nbreCycleTotalRecherche")) {
			plot.addPoint((int) Reseau.getNbreCycleTotalRecherche());
		} else if (param.getName().equals("nbremessageechanges")) {
			plot.addPoint((int) Reseau.getNbremessageechanges());
		} else if (param.getName().equals("nbreCycleVadrouilleMin")) {
			plot.addPoint((int) Reseau.cycleVadrouille);
		} else if (param.getName().equals("nbreAgHorsCommunaute")) {
			plot.addPoint((int) Reseau.nbreAgHorsCommunaute);
		} else if (param.getName().equals("nbreAgCommunaute")) {
			plot.addPoint((int) Reseau.nbreAgCommunaute);
		} else if (param.getName().equals("nbrDemandes")) {
			plot.addPoint((int) Reseau.nbredemandestotales);
		} else if (param.getName().equals("nbredemandehorscommunaute")) {
			plot.addPoint((int) Reseau.getNbredemandeTotalHC());
		} else if (param.getName().equals("tempsrecherchehorscommunaute")) {
			plot.addPoint((int) Reseau.getNbreCycleTotalHC());
		} else if (param.getName().equals("nbrMessageCentalise")) {
			plot.addPoint((int) AssistantApprocheLocaleFull.nbMessageCentralise);
		} else if (param.getName().equals("nbreCycleOccupationPlace")) {
			plot.addPoint((int) Reseau.cycleStationnement);
		} else if (param.getName().equals("tempsMoyenRechHC")) {
			plot.addPoint((int) Reseau.tempsMoyenRechHC());
		} else if (param.getName().equals("tempsMoyenRech")) {
			plot.addPoint((int) Reseau.tempsMoyenRecherche());
		} else if (param.getName().equals("nbrePlaceArc")) {
			plot.addPoint((int) Reseau.nbrePlaceArc);
		} else if (param.getName().equals("UR")) {
			plot.addPoint((int) Reseau.tauxUtilisationSysteme());
		} else {

		}

	}

	public void initGUI() {
			setGUIObject(plot = new PlotPanel(param.desc, param.width, param.height));
	}

}
