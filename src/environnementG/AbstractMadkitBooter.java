/*
* AbstractMadkitBooter.java - Kernel: the kernel of MadKit
* Copyright (C) 1998-2002 Olivier Gutknecht, Fabien Michel, Jacques Ferber
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.

* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.

* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
*/
package environnementG;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


import madkit.kernel.AbstractAgent;
import madkit.kernel.GraphicShell;
import madkit.kernel.Kernel;
import madkit.kernel.OPanel;

/** The standard madkit booter.

    It starts the kernel, and then launch agents defined in a config
    file, with or without GUI.

  @version 1.1
  @author Jacques Ferber, Olivier Gutknecht and Fabien Michel */

public class AbstractMadkitBooter implements GraphicShell
{

 //
  protected Kernel theKernel;

   public AbstractMadkitBooter(Kernel k){
	   theKernel = k;
	   theKernel.registerGUI(this);
       }

    public Object getDefaultGUIObject(AbstractAgent a){
		OPanel o = new OPanel();
		a.setGUIObject(o);
		a.setOutputWriter(o.getOut());
		return o;
    }

    // implements the GraphicShell interface
    public void setupGUI(AbstractAgent a){
	//	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	setupGUI(a,new Point(-1,-1),new Dimension(-1,-1));
    }
    
  @SuppressWarnings("deprecation")
public void setupGUI(AbstractAgent a, Point p, Dimension d){
		JFrame f = new JFrame(a.getName());
		a.initGUI();
                if(p == null)
                    p=new Point(-1,-1);
                if(d == null)
                    d = new Dimension(-1,-1);

		if (a.getGUIObject() != null)
			f.getContentPane().add("Center",(Component)a.getGUIObject());
		f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	//	f.addWindowListener(createWindowHandler(theKernel,a));
		if ((d.width < 0) || (d.height < 0))
			f.pack();
		else
			f.setSize(d);
		if ((p.x < 0) || (p.y < 0)){
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			f.setLocation((int)(screenSize.width/2 - f.getSize().getWidth()/2 + (int) (Math.random()*500)-250),
						(int)(screenSize.height/2 - f.getSize().getHeight()/2) + (int) (Math.random()*500)-250);
		} else {
			f.setLocation(p.x,p.y);
		}
		f.show();
	}

 
    public void disposeGUI(AbstractAgent a)
    {	

    }

    public void disposeGUIImmediatly(AbstractAgent a){
        disposeGUI(a); // default...
    }

    
 /*   void launchAgent(AbstractAgent a, String name, boolean gui, Point p, Dimension d){
    	if (p == null) p = new Point(-1,-1);
		if (d == null) d = new Dimension(-1,-1);
        theKernel.launchAgent(a,name,this,gui,p,d);
    }
    */
}

