package simulateur;

import java.util.ArrayList;

import graphics.*;
import approche.locale.turtles.AssistantApprocheLocalCoopetitif;
import approche.locale.turtles.AssistantApprocheLocaleFull;
import madkit.kernel.AbstractAgent;
import madkit.kernel.GraphicShell;
import network.structure.Reseau;
import network.turtles.AgHorsCommunaute;
import network.turtles.TurtleNetWorkTurtle;
import turtlekit.kernel.Launcher;
import turtlekit.kernel.TurtleScheduler;

public class TurtleNetWorkLauncher extends Launcher {

	private static final long serialVersionUID = 1L;
	boolean local;
	boolean graphique;
	ArrayList<ReseauParam> paramTab;
	private String typeAgent;

	public TurtleNetWorkLauncher(int nbCycle, String typeA){
		super(nbCycle);
		typeAgent = typeA;
	}
	
	public TurtleNetWorkLauncher(GraphicShell gui, int communaute, int horsCommunaute, boolean graphique, int nbrCycleOccupation,
									SetStep c, ArrayList<ReseauParam> paramTab, int range, int vitesse,int nbCycle, String typeA) {
		super(nbCycle);
		setWidth(400);
		setHeight(300);
		setCellSize(5);
		this.setCyclePause(vitesse);
		this.setGUIObject(gui);
	//	this.setControleSchedule(new TurtleScheduler("test"));
		this.paramTab = paramTab;
		typeAgent = typeA;

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
		addHorsCommunaute();

		if (local)
			addSimulationAgentsLocal(graphique,typeAgent);
		else
			addSimulationAgentsLocal(graphique,typeAgent);

	}

	public void addHorsCommunaute() {
		for (int j = 0; j < Reseau.nbreAgHorsCommunaute / 2; j++) {
			addTurtle(new AgHorsCommunaute("lancement"));
			addTurtle(new AgHorsCommunaute("lancementb"));
		}
	}

	public void addSimulationAgentsLocal(boolean graphique2, String typeAgent) {
		if (typeAgent.equals("full")){
			Reseau.comAgentType="full";
			for (int i = 0; i < (Reseau.nbreAgCommunaute/2); i++){
				addTurtle(new AssistantApprocheLocaleFull("debutStationner", graphique2));
				addTurtle(new AssistantApprocheLocaleFull("debutCirculer", graphique2));
			}
		}
		 
		else if (typeAgent.equals("coopetitif")){
			Reseau.comAgentType="coopetitif";
			for (int i = 0; i < (Reseau.nbreAgCommunaute/2); i++){
					addTurtle(new AssistantApprocheLocalCoopetitif("debutStationner", graphique2));
					addTurtle(new AssistantApprocheLocalCoopetitif("debutCirculer", graphique2));
			}
		}
			 
	}
	
	public boolean finish() {
		return finish;
	}

}
