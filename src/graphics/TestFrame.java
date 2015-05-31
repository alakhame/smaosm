package graphics;

import java.awt.*;

import javax.swing.JFrame;

import network.structure.Arc;
import network.structure.Coordonnees;
import network.structure.Reseau;

public class TestFrame extends JFrame  {

	private static final long serialVersionUID = -2664591691038542351L;

	public TestFrame() {
		this.setPreferredSize(new Dimension(400, 300));
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Arc a: Reseau.listeArc)
			for(Coordonnees c : a.getPointsArc())
				g.drawLine(c.getX(),300-c.getY(),c.getX(),300-c.getY());
	}

	public static void main(String[] args) {
		Reseau.instancierReseau();
		int s=0;
		System.out.println(Reseau.listeArc.size());
		for(Arc a: Reseau.listeArc){
			s+=a.getNbrePlaces();
		}System.out.println(s);
		TestFrame test = new TestFrame();
		test.setVisible(true);
	}
}
