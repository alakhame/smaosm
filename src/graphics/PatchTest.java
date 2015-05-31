package graphics;

import java.awt.Color;

import network.structure.Arc;
import network.structure.Coordonnees;
import network.structure.Reseau;

public class PatchTest extends turtlekit.kernel.Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 

	public void setup() {
		for (int i = 0; i < envWidth; i++)
			for (int j = 0; j < envHeight; j++)
				if (ifPositionStat(i, i))
					patchGrid[i][j].setColor(Color.magenta);
				else
					patchGrid[i][j].setColor(Color.black);
	}

	private boolean ifPositionStat(int x, int y) {
		for (Arc a : Reseau.listeArc) {
			Coordonnees c = new Coordonnees(x, y);
			for (int k = 0; k < a.getPointsArc().size(); k++) {
				if (c.equals(a.getPointsArc().get(k)))
					return true;
			}
		}
		return false;
	}
}