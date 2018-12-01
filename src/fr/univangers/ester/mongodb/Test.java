package fr.univangers.ester.mongodb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import fr.univangers.ester.beans.Utilisateur.Status;

public class Test {

	public static void main(String[] args) {
		Users users = new Users();
		SalarieDB salarieDB = new SalarieDB();
		users.addUserEster("id1", "Eric", "LeBlanc", "ericLbc@ester.come", "1234", Status.MEDECIN);
		salarieDB.addSalarie("1", "A", "id1");
		salarieDB.addSalarie("2", "A", "id1");
		salarieDB.pushQuestionnaireUnanswered("1", "Eval-Risk-TMS");
		salarieDB.pushQuestionnaireUnanswered("2", "Eval-Risk-TMS");
		addEvalRiskTMS();
		/*
		users.addUserEster("id1", "LeBlanc", "Eric", "eric.lablanc@ester.fr", "1234", Status.MEDECIN);
		//users.addUserEster("id1", "LeBlanc", "Eric", "eric.lablanc@ester.fr", "1234", Status.MEDECIN);
		//users.addEntreprise("entreprise", "Univ-Angers", "12345");
		users.addUserEster("aa", "Admin", "Admin", "admin@ester.fr", "1234", Status.ADMINISTRATEUR);
		/*
		users.addSalarie("s1", 1, null, "homme", 1992, "49", null, null, null, null);
		users.addSalarie("s2", 2, null, "homme", 1985, "49", null, null, null, null);
		System.out.println(users.existSalarie("s1"));
		System.out.println(users.connectSalarie("s1", null));
		System.out.println(users.existEntreprise("id66"));
		System.out.println(users.connectEntreprise("id66", "mdp"));
		
		
		users.addEntreprise("e1", "Marc", "pass");
		users.addEntreprise("id66", "AA", "mdp");
		users.addEntreprise("id55", "TT", "mdp");
		users.addSalarie("id00", 00, "00", "male", 1999, "vendée", "medical", "aide-soignant", "chu angers", "userEster");
		
		/*Questionnaires questionnaires = new Questionnaires();
		questionnaires.addQuestionnaire("Test", "test", "<h1>TEST</h1>", "id0");
		*/
	}

	public static void addEvalRiskTMS() {
		QuestionnairesDB questionnaires = new QuestionnairesDB();
        String fileName = "WebContent/src/evalrisktms.html";
        String identifiant = "Eval-Risk-TMS";
        String html = "";

        try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            String line = null;
            while((line = bufferedReader.readLine()) != null) {
                html += line + "\n";
            }   
          
            if(questionnaires.existQuestionnaire(identifiant))
            	questionnaires.deleteQuestionnaire(identifiant);
    		questionnaires.addQuestionnaire("Eval-Risk-TMS", identifiant, html, "default");
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");
        }
	}
	
}
