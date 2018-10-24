package fr.univangers.ester.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Resultat {
	
	private static final String RED = "#ff3d00";
	private static final String ORANGE = "#ff9100";
	private static final String YELLOW = "#ffea00";
	private static final String GREEN = "#00e676";
	private static final String BLUE = "#2962ff";

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
	
	public void addDataCSV(int index, String... datas) {
		if(index > dataCSV.size())
			return;
		if(index == dataCSV.size())
			dataCSV.add(new ArrayList<>());
		dataCSV.get(index).add(String.join(",", datas));
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
			
		setTitleDataCSV(0,"Categorie","Toujours","Souvent","Rarement","Jamais");
		addDataCSV(0,"Votre travail nécessite-t-il de répêter les mêmes actions plus de 2 à 4 fois environ par minnute ?"
				,"25","25","25","25");
		addAnswer(0,"Souvent");
		addDataCSV(0,"Travailler avec un ou deux bras en l'air (au-dessus des épaules) régulièrement ou de manière prolongée"
				,"25","25","25","25");
		addAnswer(0,"Rarement");
		addDataCSV(0,"Fléchir le(s) coude(s) régulièrement ou de manière prolongée"
				,"15","35","25","25");
		addAnswer(0,"Rarement");
		addDataCSV(0,"Presser ou prendre ferment des objets ou des pièces entre le pouce et l'index"
				,"25","25","35","15");
		addAnswer(0,"Jamais");
		setTitleDataCSV(1,"Categorie","Pas du tout d'accord","Pas d'accord","D'accord","Tout à fait d'accord");
		addDataCSV(1,"J'ai la possibilité d'influencer le déroulement de mon travail"
				,"15","25","45","15");
		addAnswer(1,"Pas du tout d'accord");
		addDataCSV(1,"Les collègues avec qui je travaille m'aident à mener les tàches à bien"
				,"15","55","15","15");
		addAnswer(1,"D'accord");
		
		addRPE("Pas d\'éfort du tout 6", 8.1, GREEN);
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
