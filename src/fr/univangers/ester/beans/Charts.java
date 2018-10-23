package fr.univangers.ester.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Charts {
	
	private List<List<String>> dataCSV = new ArrayList<>();
	private List<List<String>> answers = new ArrayList<>();
	
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
	
	public Charts() {
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
	}
	
	
}
