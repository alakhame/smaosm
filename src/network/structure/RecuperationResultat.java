package network.structure;

import madkit.kernel.*;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;


import approche.locale.turtles.AssistantApprocheLocaleFull;

public class RecuperationResultat { //extends Agent {

	private static final long serialVersionUID = 1L;

	String myCommunity = "Resultats";
	String myGroup = "resultat";
	String myRole = "member";
	String nom_fichier;
	String nom_feuille;
	boolean fini = false;
	int nbreappel = 0;

	public RecuperationResultat() {
		super();
		nom_fichier = "resultatSimulation/CompetitionEntreAgents/resultats_" + Reseau.nbreAgCommunaute + "_"
				+ Reseau.nbreAgHorsCommunaute + "_"
				+ Reseau.cycleStationnement + "_"
				+ Reseau.tempsGardeinfHP + ".xls";
		System.out.println("New FILE "+nom_fichier);
	}

/*	public void activate() {
		createGroup(true, myCommunity, myGroup, null, null);

	}
*/
	public void setNomFeuille(String nf) {
		nom_feuille = nf;
	}

	public void creationfichier() {
		try {

			File fichier = new File(nom_fichier);
			System.out.println("creation fichier");
			WritableWorkbook workbook = null;
			WritableSheet sheet;

			if (!fichier.exists()) {
				workbook = Workbook.createWorkbook(fichier);
				System.out.println("le fichier n'existe pas");
				sheet = workbook.createSheet("Resultats", 0);
				System.out.println("apres feuille");

				// creation des labels
				Label label = new Label(0, 0, "agCommunaute");
				Label label2 = new Label(1, 0, "agHorsCommunaute");
				Label label3 = new Label(2, 0, "nbreCycleVadrouilleMin");
				Label label4 = new Label(3, 0, "nbreCycleOccupationPlace");
				Label label5 = new Label(4, 0, "nbre de Places par Arc");
				Label label9 = new Label(5, 0, "nbre de recherche dans la communaut�");
				Label label10 = new Label(6, 0, "temps total de recherche");
				Label label6 = new Label(7, 0, "Temps Moyen de Recherche dans la communaut�");
				Label label7 = new Label(8, 0, "TauxUtilisationSysteme");
				Label label8 = new Label(11, 0,"Temps Moyen de Recherche hors la communaut�");
				Label label11 = new Label(9, 0, "Nbre de recherches hors communaut�");
				Label label12 = new Label(10, 0, "temps total de recherche hors la communaut�");
				Label label13 = new Label(12, 0, "Nbre de messages envoy�s");
				Label label14 = new Label(13, 0, "Nbre de messages centralise");
// ajout� pour conna�tre le nombre de place trouv�
				Label label5b = new Label(14, 0, "nombre de places");
				Label label11b = new Label(15, 0, "nombre de places HC");
				Label labelRange = new Label(16, 0, "rayon");
				Label labelComAgentType = new Label(17,0,"Community Agent Type");
				
				
				// ajout des labels
				sheet.addCell(label);
				sheet.addCell(label2);
				sheet.addCell(label3);
				sheet.addCell(label4);
				sheet.addCell(label5);
				sheet.addCell(label6);
				sheet.addCell(label7);
				sheet.addCell(label8);
				sheet.addCell(label9);
				sheet.addCell(label10);
				sheet.addCell(label11);
				sheet.addCell(label12);
				sheet.addCell(label13);
				sheet.addCell(label14);
				sheet.addCell(label5b);
				sheet.addCell(label11b);
				sheet.addCell(labelRange);
				sheet.addCell(labelComAgentType);
			} else {
				Workbook wk = Workbook.getWorkbook(fichier);
				System.out.println("no exception");
				workbook = Workbook.createWorkbook(fichier, wk);
				sheet = workbook.getSheet(0);

			}

			int i = sheet.getRows();

			System.out.println("recuperation des resultats"); 
			Number number = new Number(4, i, Reseau.nbrePlaceArc);
			Number number1;
			Number number2;
			Number number9;
	//		if (Reseau.getNbredemandes() != 0) {
				number1 = new Number(7, i,  Reseau.tempsMoyenRecherche());
				number2 = new Number(8, i, Reseau.tauxUtilisationSysteme());
	//		} else {
		//		number1 = new Number(7, i, 0);
			//	number2 = new Number(8, i, 0);
	//		}
			if (Reseau.getNbredemandeTotalHC()!= 0)
				number9 = new Number(11, i, Reseau.tempsMoyenRechHC());
			else
				number9 = new Number(11, i, 0);
			Number number3 = new Number(3, i, Reseau.cycleStationnement);
			Number number4 = new Number(2, i, Reseau.cycleVadrouille);
			Number number5 = new Number(1, i, Reseau.nbreAgHorsCommunaute);
			Number number6 = new Number(0, i, Reseau.nbreAgCommunaute);
			Number number7 = new Number(5, i, Reseau.getNbredemandes()); // AssistantLocal
			Number number8 = new Number(6, i, Reseau.getNbreCycleTotalRecherche());
			Number number10 = new Number(9,  i, Reseau.getNbredemandeTotalHC());
			Number number12 = new Number(10, i, Reseau.getNbreCycleTotalHC());
			Number number13 = new Number(12, i, Reseau.getNbremessageechanges());
			Number number14 = new Number(13, i, AssistantApprocheLocaleFull.nbMessageCentralise);
			
			Number number5b = new Number(14, i, Reseau.getNbreStationnements());
			Number number11b = new Number(15, i, Reseau.getNbreStationnementsHC());
			Number numberRange = new Number(16, i, AssistantApprocheLocaleFull.range);
			Label ComAgentType = new Label(17,i, Reseau.comAgentType);
			
			System.out.println("insertion des r�sultats");
			sheet.addCell(number);
			sheet.addCell(number1);
			sheet.addCell(number2);
			sheet.addCell(number3);
			sheet.addCell(number4);
			sheet.addCell(number5);
			sheet.addCell(number6);
			sheet.addCell(number7);
			sheet.addCell(number8);
			sheet.addCell(number9);
			sheet.addCell(number10);
			sheet.addCell(number12);
			sheet.addCell(number13);
			sheet.addCell(number14);
			sheet.addCell(number5b);
			sheet.addCell(number11b);
			sheet.addCell(numberRange);
			sheet.addCell(ComAgentType);

			workbook.write();
			workbook.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void calculMoyenne(String nomFichier) throws BiffException, IOException{
		File fichier = new File(nomFichier);
		System.out.println("creation fichier");
		WritableWorkbook workbook = null;
		Sheet sheet;
		
		Workbook wk = Workbook.getWorkbook(fichier);
		workbook = Workbook.createWorkbook(fichier, wk);
		sheet = workbook.getSheet(0);
		double moyenne = 0;
		
		// affichage nombre de Agent Communaut�
		System.out.println("nb agents communaut�: " + sheet.getCell(0,1).getContents());
		System.out.println("nb agents hors communaut�: " + sheet.getCell(0,2).getContents());
		System.out.println("Nbre Recherche hors Communaut� " + calculMoyenneColonne(9,sheet));
		
	}
	public double calculMoyenneColonne(int colonne, Sheet s){
		int somme = 0;
		for (int i = 1; i < 52;i++)
			somme += Double.parseDouble(s.getCell(colonne, i).getContents());
		return somme/50;
	}
	
	public static void main(String[] args) throws BiffException, IOException{
		RecuperationResultat rr = new RecuperationResultat();
		rr.calculMoyenne("C:\\Users\\flavien.balbo\\ownCloud\\recherche\\Plateforme\\Stationnement(avec OSM)\\resultatSimulation\\"
		+ "resultats_0_400_10_15.xls" );
	}
}
