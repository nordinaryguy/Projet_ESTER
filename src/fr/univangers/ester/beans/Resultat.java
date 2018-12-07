package fr.univangers.ester.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import fr.univangers.ester.mongodb.ReponsesDB;
import fr.univangers.ester.mongodb.SalarieDB;

public class Resultat {
	
	private static final String RED = "#ff3d00";
	private static final String ORANGE = "#ff9100";
	private static final String YELLOW = "#ffea00";
	private static final String GREEN = "#00e676";
	private static final String BLUE = "#2962ff";

	private static final String IDEVALRISKTMS = "Eval-Risk-TMS";
	
	private static final String SALTSA = "Seuil du facteur de risque (SALTSA)";
	private static final String TJ = "Toujours (>4h/jours)";
	private static final String SO = "Souvent (de 2 à 4h/jour)";
	private static final String RA = "Rarement (moins de 2h/jour)";
	private static final String JA = "Jamais";
	
	private static final String VS = "D'accord ou tout à fait d'accord vs pas d'accord ou pas du tout d'accord";
	private static final String PT = "Pas du tout d'accord";
	private static final String PA = "Pas d'accord";
	private static final String DA = "D'accord";
	private static final String TA = "Tout à fait d'accord";
	
	private List<Double> categoriesHisto = new ArrayList<>();
	private List<Double> dataHisto = new ArrayList<>();
	private List<String> colorsHisto = new ArrayList<>();
	
	private List<List<String>> dataCSV = new ArrayList<>();
	private List<List<String>> answers = new ArrayList<>();
	
	private List<String> categoriesRPE = new ArrayList<>();
	private List<Double> dataRPE = new ArrayList<>();
	private List<String> colorsRPE = new ArrayList<>();

	public List<Double> getCategoriesHisto() {
		return categoriesHisto;
	}
	
	public List<Double> getDataHisto() {
		return dataHisto;
	}
	public List<String> getColorsHisto() {
		return colorsHisto;
	}
	
	public void addHisto(double categorie, double data, String color) {
		categoriesHisto.add(categorie);
		dataHisto.add(data);
		colorsHisto.add(color);
	}
	
	public List<String> getCategoriesRPE() {
		return categoriesRPE;
	}
	
	public List<Double> getDataRPE() {
		return dataRPE;
	}
	public List<String> getColorsRPE() {
		return colorsRPE;
	}
	
	public void addRPE(String categorie, double data, String color) {
		categoriesRPE.add(categorie);
		dataRPE.add(data);
		colorsRPE.add(color);
	}
	
	public void addAnswer(int index, String answer) {
		if(index > answers.size())
			return;
		if(index == answers.size())
			answers.add(new ArrayList<>());
		answers.get(index).add(answer);
	}
	
	public List<String> getAnswers(int index) {
		if(index > answers.size())
			return Collections.emptyList();
		return answers.get(index);
	}
	
	public int sizeDataCSV() {
		return dataCSV.size();
	}
	
	public String getDataCSV(int index) {
		if(index >= dataCSV.size())
			return null;
		return String.join("\n", dataCSV.get(index));
	}
	
	public void setTitleDataCSV(int index, String... titles) {
		if(index > dataCSV.size())
			return;
		if(index == dataCSV.size())
			dataCSV.add(new ArrayList<>());
		if(dataCSV.get(index).isEmpty())
			dataCSV.get(index).add(0, String.join(",", titles));
		else
			dataCSV.get(index).set(0, String.join(",", titles));
	}
	
	public void addDataCSV(int index, int plot, String... datas) {
		if(index > dataCSV.size())
			return;
		if(index == dataCSV.size())
			dataCSV.add(new ArrayList<>());
		List<String> datasPlot = new ArrayList<>(Arrays.asList(datas));
		if(plot == 1) {
			datasPlot.add(2, "0");
			datasPlot.add(4, "0");
			datasPlot.add(6, "1");
		} else if(plot == 2) {
			datasPlot.add(2, "0");
			datasPlot.add(4, "1");
			datasPlot.add(6, "0");
		} else {
			datasPlot.add(2, "1");
			datasPlot.add(4, "0");
			datasPlot.add(6, "0");
		}
		dataCSV.get(index).add(String.join(",", datasPlot));
	}
	
	public Resultat() {
		addHisto(-1, 11.9, GREEN);
		addHisto(0, 9.6, GREEN);
		addHisto(1, 30, GREEN);
		addHisto(2, 7, BLUE);
		addHisto(3, 16, BLUE);
		addHisto(4, 6.5, BLUE);
		addHisto(5, 8, BLUE);
		addHisto(6, 3, BLUE);
		addHisto(7, 3, BLUE);
		addHisto(8, 1, BLUE);
		addHisto(9, 1, BLUE);
		addHisto(10, 1, BLUE);
		addHisto(11, 0.5, BLUE);
		addHisto(12, 0.5, BLUE);
		addHisto(13, 0.5, BLUE);
		addHisto(14, 0.5, BLUE);
		addHisto(15, 0.5, BLUE);
		
		WebContext ctx = WebContextFactory.get();
		HttpServletRequest req = ctx.getHttpServletRequest();
		HttpSession session = req.getSession();
		ReponsesDB reponsesDB = new ReponsesDB();
		SalarieDB salarieDB = new SalarieDB();
		UtilisateurBeans sessionUser = (UtilisateurBeans) session.getAttribute("sessionUtilisateur");
		
		// Récuperation de l'identifiant du salarie qui a répondu au questionnaire
		String identifiantSalarieQuestionnaire = "";
		
		if(sessionUser != null) {
			String identifiant = sessionUser.getIdentifiant();
			String identifiantSalarie = session.getAttribute("identifiantSalarie") != null ?
					session.getAttribute("identifiantSalarie").toString() :
					"";
			if(sessionUser.isSalarie() && 
					salarieDB.getQuestionnaireUnanswered(identifiant).contains(IDEVALRISKTMS) &&
					reponsesDB.existReponse(identifiant, IDEVALRISKTMS))
				identifiantSalarieQuestionnaire = identifiant;
			else if(sessionUser.isUtilisateur() && !identifiantSalarie.isEmpty() &&
					reponsesDB.existReponse(identifiantSalarie, IDEVALRISKTMS))
				identifiantSalarieQuestionnaire = identifiantSalarie;
		}
		
		if(!identifiantSalarieQuestionnaire.isEmpty()) {
			Map<String, String> reponses = reponsesDB.getReponses(identifiantSalarieQuestionnaire, IDEVALRISKTMS);
			setTitleDataCSV(0,"Categorie",TJ,SALTSA,SO,SALTSA,RA,SALTSA,JA);
			addDataCSV(0,3,"Votre travail nécessite-t-il de répêter les mêmes actions plus de 2 à 4 fois environ par minute ?"
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question2", TJ))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question2", SO))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question2", RA))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question2", JA)));
			addAnswer(0, reponses.get("question2"));
			addDataCSV(0,2,"Travailler avec un ou deux bras en l'air (au-dessus des épaules) régulièrement ou de manière prolongée"
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question3", TJ))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question3", SO))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question3", RA))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question3", JA)));
			addAnswer(0, reponses.get("question3"));
			addDataCSV(0,2,"Devez-vous vous pencher en avant / sur le côté régulièrement ou de manière prolongée?"
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question4", TJ))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question4", SO))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question4", RA))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question4", JA)));
			addAnswer(0, reponses.get("question4"));
			addDataCSV(0,2,"Fléchir le(s) coude(s) régulièrement ou de manière prolongée"
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question5", TJ))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question5", SO))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question5", RA))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question5", JA)));
			addAnswer(0, reponses.get("question5"));
			addDataCSV(0,3,"Presser ou prendre ferment des objets ou des pièces entre le pouce et l'index"
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question6", TJ))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question6", SO))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question6", RA))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question6", JA)));
			addAnswer(0, reponses.get("question6"));
			setTitleDataCSV(1,"Categorie",PT,VS,PA,VS,DA,VS,TA);
			addDataCSV(1,2,"J'ai la possibilité d'influencer le déroulement de mon travail"
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question7", PT))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question7", PA))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question7", DA))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question7", TA)));
			addAnswer(1, reponses.get("question7"));
			addDataCSV(1,2,"Les collègues avec qui je travaille m'aident à mener les tàches à bien"
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question8", PT))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question8", PA))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question8", DA))
					,String.valueOf(reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question8", TA)));
			addAnswer(1, reponses.get("question8"));
			addRPE("6 Pas d\'effort du tout", 
					reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "6 Pas d\'effort du tout"), GREEN);
	    	addRPE("7 Extrêmement léger", 
	    			reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "7 Extrêmement léger"), GREEN);
	    	addRPE("8", 
	    			reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "8"), GREEN);
	    	addRPE("9 Très léger", 
	    			reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "9 Très léger"), GREEN);
	    	addRPE("10", 
	    			reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "10"), YELLOW);
	    	addRPE("11 Léger", 
	    			reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "11 Léger"), YELLOW);
	    	addRPE("12", 
	    			reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "12"), ORANGE);
	    	addRPE("13 Un peu dur",
	    			reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "13 Un peu dur"), ORANGE);
	    	addRPE("14",
	    			reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "14"), ORANGE);
	    	addRPE("15 Dur",
	    			reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "15 Dur"), ORANGE);
	    	addRPE("16",
	    			reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "16"), RED);
	    	addRPE("17 Très dur",
	    			reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "17 Très dur"), RED);
	    	addRPE("18",
	    			reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "18"), RED);
	    	addRPE("19 Extrêment dur",
	    			reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "19 Extrêment dur"), RED);
	    	addRPE("20 Epuisant",
	    			reponsesDB.getPourcentageReponses(IDEVALRISKTMS, "question1", "20 Epuisant "), RED);
		} else {
			setTitleDataCSV(0,"Categorie","Toujours",SALTSA,"Souvent",SALTSA,"Rarement",SALTSA,JA);
			addDataCSV(0,3,"Votre travail nécessite-t-il de répêter les mêmes actions plus de 2 à 4 fois environ par minute ?"
					,"25","25","25","25");
			addAnswer(0, "Souvent");
			addDataCSV(0,2,"Travailler avec un ou deux bras en l'air (au-dessus des épaules) régulièrement ou de manière prolongée"
					,"25","25","25","25");
			addAnswer(0, "Rarement");
			addDataCSV(0,2,"Fléchir le(s) coude(s) régulièrement ou de manière prolongée"
					,"15","35","25","25");
			addAnswer(0, "Rarement");
			addDataCSV(0,3,"Presser ou prendre ferment des objets ou des pièces entre le pouce et l'index"
					,"25","25","35","15");
			addAnswer(0, JA);
			setTitleDataCSV(1,"Categorie",PT,VS,PA,VS,DA,VS,TA);
			addDataCSV(1,2,"J'ai la possibilité d'influencer le déroulement de mon travail"
					,"15","25","45","15");
			addAnswer(1, PT);
			addDataCSV(1,2,"Les collègues avec qui je travaille m'aident à mener les tàches à bien"
					,"15","55","15","15");
			addAnswer(1, DA);
			addRPE("Pas d\'effort du tout 6", 8.1, GREEN);
	    	addRPE("Extrêmement léger 7", 5.1, GREEN);
	    	addRPE("8", 0, GREEN);
	    	addRPE("Très leger 9", 6.8, GREEN);
	    	addRPE("10", 1, YELLOW);
	    	addRPE("Léger 11", 19.5, YELLOW);
	    	addRPE("12", 5.1, ORANGE);
	    	addRPE("Un peu dur 13", 24.3, ORANGE);
	    	addRPE("14", 5.6, ORANGE);
	    	addRPE("Dur 15", 16.2, ORANGE);
	    	addRPE("16", 1.8, RED);
	    	addRPE("Très dur 17", 4.1, RED);
	    	addRPE("18", 0.5, RED);
	    	addRPE("Extrêment dur 19", 0.5, RED);
	    	addRPE("Epuisant 20", 1.5, RED);
		}
		
	}
	
	
}
