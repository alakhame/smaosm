package simulateur;

import java.util.ArrayList;

import graphics.*;
import approche.globale.turtles.AgStationnement;
import approche.globale.turtles.AssistantApprocheGlobale;
import approche.locale.turtles.AssistantApprocheLocale;
import madkit.kernel.GraphicShell;
import network.structure.Reseau;
import network.turtles.AgHorsCommunaute;
import turtlekit.kernel.Launcher;

public class TurtleNetWorkLauncher extends Launcher {

	private static final long serialVersionUID = 1L;
	boolean local;
	boolean graphique;
	ArrayList<ReseauParam> paramTab;

	public TurtleNetWorkLauncher(GraphicShell gui, int communaute, int horsCommunaute, boolean graphique, int nbrCycleOccupation,
									int temps, SetStep c, ArrayList<ReseauParam> paramTab, int range, int vitesse) {
		
		setWidth(400);
		setHeight(300);
		setCellSize(5);
		this.setCyclePause(vitesse);
		this.setGUIObject(gui);
		this.setControleSchedule(c);
		this.paramTab = paramTab;

		/**
		 * si l == true alors AssistantApprocheLocale sinon assistant de
		 * l'approche globale.
		 */
		local = true;
		Reseau.parametreSimulation(communaute, horsCommunaute,nbrCycleOccupation,  c.getMax(), range);

		setSimulationName(" *** Approche Locale *** ");
		this.graphique = graphique;
	}

	public void addSimulationAgents() {
		if (graphique) {
			addViewer(2);
			for(ReseauParam rp : paramTab)
			 addObserver(new ReseauObserver(rp), true);
		}

		if (local)
			addSimulationAgentsLocal();
		else
			addSimulationAgentsGlobal();

		addHorsCommunaute();
	}

	public void addHorsCommunaute() {
		for (int j = 0; j < Reseau.nbreAgHorsCommunaute / 2; j++) {
			addTurtle(new AgHorsCommunaute("lancement"));
			addTurtle(new AgHorsCommunaute("lancementb"));
		}
	}

	public void addSimulationAgentsLocal() {
		 for (int i = 0; i < (Reseau.nbreAgCommunaute/2); i++){
				addTurtle(new AssistantApprocheLocale("debutStationner"));
				addTurtle(new AssistantApprocheLocale("debutCirculer"));
		}

	}

	public void addSimulationAgentsGlobal() {
		addTurtle(new AgStationnement("initialisation"));;
		for (int i = 0; i < (Reseau.nbreAgCommunaute / 2); i++) {
			addTurtle(new AssistantApprocheGlobale("debutStationner"));
			addTurtle(new AssistantApprocheGlobale("debutCirculer"));
		}

	}

	public boolean finish() {
		return finish;
	}

}
