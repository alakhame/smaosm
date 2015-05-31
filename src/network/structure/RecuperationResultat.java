package network.structure;

import madkit.kernel.*;
import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;

import java.io.File;

import approche.locale.turtles.AssistantApprocheLocale;

public class RecuperationResultat extends Agent {

	private static final long serialVersionUID = 1L;

	String myCommunity = "Resultats";
	String myGroup = "resultat";
	String myRole = "member";
	final int TempsExcecution = 50;
	String nom_fichier;
	String nom_feuille;
	boolean fini = false;
	int nbreappel = 0;

	public RecuperationResultat() {
		super();
		nom_fichier = "resultats_" + Reseau.nbreAgCommunaute + "_"
				+ Reseau.nbreAgHorsCommunaute + "_"
				+ Reseau.nbreCycleOccupationPlace + "_"
				+ Reseau.tempsGardeinfHP + ".xls";
	}

	public void activate() {
		createGroup(true, myCommunity, myGroup, null, null);

	}

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
				Label label9 = new Label(5, 0, "nbre de demande dans la communauté");
				Label label10 = new Label(6, 0, "temps total de recherche");
				Label label6 = new Label(7, 0, "Temps Moyen de Recherche dans la communauté");
				Label label7 = new Label(8, 0, "TauxUtilisationSysteme");
				Label label8 = new Label(11, 0,"Temps Moyen de Recherche hors la communauté");
				Label label11 = new Label(9, 0, "Nbre de recherches hors communauté");
				Label label12 = new Label(10, 0, "temps total de recherche hors la communauté");
				Label label13 = new Label(12, 0, "Nbre de messages envoyés");
				Label label14 = new Label(13, 0, "Nbre de messages centralise");
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
			if (Reseau.getNbredemandes() != 0) {
				number1 = new Number(7, i,  Reseau.tempsMoyenRecherche());
				number2 = new Number(8, i, Reseau.tauxUtilisationSysteme());
			} else {
				number1 = new Number(7, i, 0);
				number2 = new Number(8, i, 0);
			}
			if (Reseau.nbredemandehorscommunaute != 0)
				number9 = new Number(11, i, Reseau.tempsMoyenRechHC());
			else
				number9 = new Number(11, i, 0);
			Number number3 = new Number(3, i, Reseau.nbreCycleOccupationPlace);
			Number number4 = new Number(2, i, Reseau.nbreCycleVadrouilleMin);
			Number number5 = new Number(1, i, Reseau.nbreAgHorsCommunaute);
			Number number6 = new Number(0, i, Reseau.nbreAgCommunaute);
			Number number7 = new Number(5, i, Reseau.getNbredemandes());
			Number number8 = new Number(6, i, Reseau.getNbreCycleTotalRecherche());
			Number number10 = new Number(9,  i, Reseau.nbredemandehorscommunaute);
			Number number12 = new Number(10, i, Reseau.tempsrecherchehorscommunaute);
			Number number13 = new Number(12, i, Reseau.nbremessageechanges);
			Number number14 = new Number(13, i, AssistantApprocheLocale.nbMessageCentralise);

			System.out.println("insertion des résultats");
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

			workbook.write();
			workbook.close();

			end();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void live() {

		while (!fini) {
			if (Reseau.getStep() == TempsExcecution) {
				nbreappel++;
				if (nbreappel == Reseau.nbreAgCommunaute + Reseau.nbreAgHorsCommunaute) {
					creationfichier();
					fini = true;
				}
			}
		}

	}

	public void end() {
		println("\t That's it !!! Bye ");
	}

}
