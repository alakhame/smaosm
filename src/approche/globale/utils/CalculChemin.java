package approche.globale.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import network.structure.Arc;
import network.structure.CheminArc;
import network.structure.Coordonnees;
import network.structure.Place;
import network.structure.Reseau;

public class CalculChemin {
	private static Arc[] plusCourtChemin(Arc debut)
	{
	 		Arc[]precedent=new Arc[Reseau.getNbreArc()];
			int taille =Reseau.getNbreArc();
			ArrayList<Arc> listeArcs=Reseau.getListeArc();
			
			CheminArc[] liste=new CheminArc[Reseau.getNbreArc()];
			for(int j=0;j<Reseau.getNbreArc();j++)
			{
				if(listeArcs.get(j).getId()!=debut.getId())
					liste[j]=new CheminArc(listeArcs.get(j),340000000);
				else
					liste[j]=new CheminArc(listeArcs.get(j),0);
			}
			while(taille!=0)
			{
				int indice=minimum(liste,taille);
				if(indice!=-1)
				{
				
				Arc n=liste[indice].getArc();
				
				HashSet<Integer> suivant=Reseau.getListeArcSuivant(n.getId());
				
				Iterator<Integer> iterateur=suivant.iterator();
				int h;
				Arc s;
				while(iterateur.hasNext())
				{
					s=Reseau.getArc(iterateur.next());		
					h=0;
					while((liste[h].getArc().getId()!=s.getId())&&(h<taille))
						h++;
					
					if(h<taille)
					{
					if(liste[h].getParcouru()>liste[indice].getParcouru()+distanceArc(n,s))
					{
						liste[h].setParcouru(liste[indice].getParcouru()+distanceArc(n,s));
						precedent[s.getId()-1]=n;
						
					}
					}
				}
				//supprimer l'élément de la liste
				for(int k=indice;k<taille-1;k++)
				{
					liste[k]=liste[k+1];
				}
				taille--;				
				}
			}
			return precedent;
		}
		

		//le chemin le plus court pour arriver à une destination dans le cas de recherche de place
		private static ArrayList<Arc> getChemin(Arc debut,Arc fin,Arc[] courtPrecedent )
		{
			 Arc n=fin;
			 ArrayList<Arc> listearcchemin= new ArrayList<Arc>();
			 while(n.getId()!=debut.getId())
			 {
				 listearcchemin.add(0, n);
				 if(courtPrecedent[n.getId()-1]!=null)
					 n=courtPrecedent[n.getId()-1];
				 else
					 n=debut;
			 }	
			 return listearcchemin;
		}
		
		//méthode utilisée pour le calcul du plus court chemin
		 private static int minimum(CheminArc[] t,int nbreElem)
		{
			int min;
			if(nbreElem!=0)
			{
				min=0;
				if(nbreElem>1)
				{
					for(int s=1;s<nbreElem;s++)
						if(t[min].getParcouru()>t[s].getParcouru())
							min=s;
				}
				return min;
			}
			return -1;
			
		}
		 
		 private static double distanceArc(Arc a1,Arc a2)
			{
				double dist=a1.longeurArc()+a2.longeurArc();
				return dist;
			}
		
		
		 public static double distanceChemin(Arc debut,Coordonnees pos,boolean sensdep,Place pl)
		 {
			 Arc fin=Reseau.getArc(pl.getIdArc());
			 ArrayList<Arc> ch=getChemin(debut, fin, plusCourtChemin(debut));
			 double dist=0;
			 if(debut.getId()==fin.getId())
			 {
				 dist=distancePosition(pos, pl.getCoordonnees());
				 return dist;
			 }
			 else
			 {
				 dist=distanceCourante(debut,pos,sensdep);
				 if(ch.size()>1)
				 {
					 for(int i=0;i<ch.size()-1;i++)
						 dist=+ch.get(i).longeurArc();
					 if(((ch.get(ch.size()-1).getDebut().getX()==ch.get(ch.size()-2).getDebut().getX())&&(ch.get(ch.size()-1).getDebut().getY()==ch.get(ch.size()-2).getDebut().getY()))||
							 (ch.get(ch.size()-1).getDebut().getX()==ch.get(ch.size()-2).getFin().getX())&&(ch.get(ch.size()-1).getDebut().getY()==ch.get(ch.size()-2).getFin().getY()))
						 dist=+distanceCourante(ch.get(ch.size()-1), pl.getCoordonnees(), true);
					 else
						 if(((ch.get(ch.size()-1).getFin().getX()==ch.get(ch.size()-2).getDebut().getX())&&(ch.get(ch.size()-1).getFin().getY()==ch.get(ch.size()-2).getDebut().getY()))||
								 (ch.get(ch.size()-1).getFin().getX()==ch.get(ch.size()-2).getFin().getX())&&(ch.get(ch.size()-1).getFin().getY()==ch.get(ch.size()-2).getFin().getY()))
							 dist=+distanceCourante(ch.get(ch.size()-1), pl.getCoordonnees(), false);
				 }
				 else
				 {
					 if(((fin.getDebut().getX()==debut.getDebut().getX())&&(fin.getDebut().getY()==debut.getDebut().getY()))||
							 (fin.getDebut().getX()==debut.getFin().getX())&&(fin.getDebut().getY()==debut.getFin().getY()))
						 dist=+distanceCourante(ch.get(ch.size()-1), pl.getCoordonnees(), true);
					 else
						 if(((fin.getFin().getX()==debut.getDebut().getX())&&(fin.getFin().getY()==debut.getDebut().getY()))||
								 (fin.getFin().getX()==debut.getFin().getX())&&(fin.getFin().getY()==debut.getFin().getY()))
							 dist=+distanceCourante(ch.get(ch.size()-1), pl.getCoordonnees(), false);
				 }
				 
				 
			 }
			 return dist;
		 }
		 private static double distanceCourante(Arc a,Coordonnees pos,boolean sensdepl)
		 {
			 double dist1;
			 if(sensdepl)
				dist1=distancePosition(pos, a.getFin());
			 else
				 dist1=distancePosition(pos, a.getDebut());
			 return dist1; 
		 }
		 private static double distancePosition(Coordonnees posActuelle,Coordonnees posFinale)
		 {
			 return (Math.sqrt(Math.pow(posActuelle.getX()-posFinale.getX(), 2.0)+Math.pow(posActuelle.getY()-posFinale.getY(), 2.0)));
		 }
		

}
