package fr.univangers.ester.beans;

import java.util.ArrayList;
import java.util.List;

public class Charts {
	private List<Double> totallyAgree = new ArrayList<>();
	private List<Double> agree = new ArrayList<>();
	private List<Double> disagree = new ArrayList<>();
	private List<Double> notAtAllAgree = new ArrayList<>();
	private List<String> questions = new ArrayList<>();
	
	private List<String> dataCSV = new ArrayList<>();
	public String getDataCSV() {
		return String.join("\n", dataCSV);
	}
	public void setTitleDataCSV(String title) {
		dataCSV.add(0, title);
	}
	public void addDataCSV(String data) {
		dataCSV.add(data);
	}
	
	public Charts() {
		addQuestions(10,20,50,20,"Votre travail nécessite-t-il de répêter les mêmes actions plus de 2 à 4 fois environ par minute ?");
		addQuestions(15,20,50,15,"Travailler avec un ou deux bras en l'air (au-dessus des épaules) régulièrement ou de manière prolongée");
		addQuestions(5,30,40,25,"Fléchir le(s) coude(s) régulièrement ou de manière prolongée");
		addQuestions(5,30,40,25,"Presser ou prendre ferment des objets ou des pièces entre lr pouce et l'index");
		
		setTitleDataCSV("Categorie,A,B,C,D");
		addDataCSV("Q1,40,30,20,10");
		addDataCSV("Q2,40,30,20,10");
		
	}
	
	public List<Double> getTotallyAgree() {
		return totallyAgree;
	}
	
	public List<Double> getAgree() {
		return agree;
	}
	
	public List<Double> getDisagree() {
		return disagree;
	}
	
	public List<Double> getNotAtAllAgree() {
		return notAtAllAgree;
	}
	
	public List<String> getQuestions() {
		return questions;
	}
	
	public void addQuestions(double totallyAgree,double agree, double disagree, double notAtAllAgree, String question) {
		this.totallyAgree.add(totallyAgree);
		this.agree.add(agree);
		this.disagree.add(disagree);
		this.notAtAllAgree.add(notAtAllAgree);
		this.questions.add(question);
	}
	
	
}
