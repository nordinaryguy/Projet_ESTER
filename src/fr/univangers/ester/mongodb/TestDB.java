package fr.univangers.ester.mongodb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.univangers.ester.beans.UtilisateurEster.Status;

public class TestDB {
	private static final String REUSSITE = "Réussite";
	private static final String ECHEC = "Echec";
	private static final String CREATION = "Creation : ";
	private static final String CONNEXION = "Connexion : ";
	private static final String SUPPRESION = "Suppresion : ";
	private static final String CHANGEMENTMDP = "Changement mot de passe : ";
	private static Logger logger = Logger.getLogger("Test");
	
	public static void main(String[] args) {
		if(testEntrepriseDB()) {
			logger.log(Level.INFO, "Test Entreprise : " + REUSSITE);
		} else {
			logger.log(Level.WARNING, "Test Entreprise : " + ECHEC);
		}
		
		if(testSalarieDB()) {
			logger.log(Level.INFO, "Test Salarie : " + REUSSITE);
		} else {
			logger.log(Level.WARNING, "Test Salarie : " + ECHEC);
		}
		
		if(testUtilisateurEsterDB()) {
			logger.log(Level.INFO, "Test UtilisateurEster : " + REUSSITE);
		} else {
			logger.log(Level.WARNING, "Test UtilisateurEster : " + ECHEC);
		}
		
		addEvalRiskTMS();
	}

	public static boolean testEntrepriseDB() {
		EntrepriseDB entrepriseDB = new EntrepriseDB();
		String identifiant = "EntrepriseTest";
		String name = "Super Entreprise";
		String password = "password";
		String newPassword = "password2";
		
		entrepriseDB.add(identifiant, name, password);
		if(!entrepriseDB.exist(identifiant)) {
			logger.log(Level.WARNING, CREATION + ECHEC);
			return false;
		} else {
			logger.log(Level.INFO, CREATION + REUSSITE);
		}
		
		if(!entrepriseDB.connect(identifiant, password)) {
			logger.log(Level.WARNING, CONNEXION + ECHEC);
			return false;
		} else {
			logger.log(Level.INFO, CONNEXION + REUSSITE);
		}
		
		entrepriseDB.changePassword(identifiant, newPassword);
		if(!entrepriseDB.connect(identifiant, newPassword) || 
				entrepriseDB.connect(identifiant, password)) {
			logger.log(Level.WARNING, CHANGEMENTMDP + ECHEC);
			return false;
		} else {
			logger.log(Level.INFO, CHANGEMENTMDP + REUSSITE);
		}

		entrepriseDB.delete(identifiant);
		if(entrepriseDB.exist(identifiant)) {
			logger.log(Level.WARNING, SUPPRESION + ECHEC);
			return false;
		} else {
			logger.log(Level.INFO, SUPPRESION + REUSSITE);
		}
		
		return true;
	}

	public static boolean testSalarieDB() {
		SalarieDB salarieDB = new SalarieDB();
		String identifiant = "SalarieTest";
		String entreprise = null;
		String userEster = "Mon createur";
		
		salarieDB.add(identifiant, entreprise, userEster);
		if(!salarieDB.exist(identifiant)) {
			logger.log(Level.WARNING, CREATION + ECHEC);
			return false;
		} else {
			logger.log(Level.INFO, CREATION + REUSSITE);
		}
		
		if(!salarieDB.connect(identifiant)) {
			logger.log(Level.WARNING, CONNEXION + ECHEC);
			return false;
		} else {
			logger.log(Level.INFO, CONNEXION + REUSSITE);
		}

		salarieDB.delete(identifiant);
		if(salarieDB.exist(identifiant)) {
			logger.log(Level.WARNING, SUPPRESION + ECHEC);
			return false;
		} else {
			logger.log(Level.INFO, SUPPRESION + REUSSITE);
		}
		
		return true;
	}

	public static boolean testUtilisateurEsterDB() {
		UtilisateurEsterDB utilisateurEsterDB = new UtilisateurEsterDB();
		String identifiant = "UtilisateurEsterTest";
		String name = "Name";
		String firstName = "First";
		String mail = "test@mail.org";
		String password = "password";
		String newPassword = "password2";
		Status status = Status.MEDECIN;
		
		utilisateurEsterDB.add(identifiant, name, firstName, mail, password, status);
		if(!utilisateurEsterDB.exist(identifiant)) {
			logger.log(Level.WARNING, CREATION + ECHEC);
			return false;
		} else {
			logger.log(Level.INFO, CREATION + REUSSITE);
		}
		
		if(!utilisateurEsterDB.connect(identifiant, password)) {
			logger.log(Level.WARNING, CONNEXION + ECHEC);
			return false;
		} else {
			logger.log(Level.INFO, CONNEXION + REUSSITE);
		}
		
		utilisateurEsterDB.changePassword(identifiant, newPassword);
		if(!utilisateurEsterDB.connect(identifiant, newPassword) || 
				utilisateurEsterDB.connect(identifiant, password)) {
			logger.log(Level.WARNING, CHANGEMENTMDP + ECHEC);
			return false;
		} else {
			logger.log(Level.INFO, CHANGEMENTMDP + REUSSITE);
		}

		utilisateurEsterDB.delete(identifiant);
		if(utilisateurEsterDB.exist(identifiant)) {
			logger.log(Level.WARNING, SUPPRESION + ECHEC);
			return false;
		} else {
			logger.log(Level.INFO, SUPPRESION + REUSSITE);
		}
		
		return true;
	}
	
	public static void addEvalRiskTMS() {
		QuestionnairesDB questionnaires = new QuestionnairesDB();
        String fileName = "WebContent/src/evalrisktms.html";
        String identifiant = "Eval-Risk-TMS";
        String html = "";

        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

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
            logger.log(Level.INFO, 
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            logger.log(Level.INFO, 
                "Error reading file '" 
                + fileName + "'");
        }
	}
	
}
