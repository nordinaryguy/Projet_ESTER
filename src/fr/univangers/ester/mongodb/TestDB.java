package fr.univangers.ester.mongodb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import fr.univangers.ester.beans.UtilisateurEster.Status;

public class TestDB {
	private static final String REUSSITE = " Réussite\n";
	private static final String ECHEC = " Echec\n";
	
	public static void main(String[] args) {
		if(testEntrepriseDB()) {
			System.out.print("\nTest Entreprise :");
			System.out.println(REUSSITE);
		} else {
			System.out.print("\nTest Entreprise :");
			System.err.println(ECHEC);
		}
		
		if(testSalarieDB()) {
			System.out.print("\nTest Salarie :");
			System.out.println(REUSSITE);
		} else {
			System.out.print("\nTest Salarie :");
			System.err.println(ECHEC);
		}
		
		if(testUtilisateurEsterDB()) {
			System.out.print("\nTest UtilisateurEster :");
			System.out.println(REUSSITE);
		} else {
			System.out.print("\nTest UtilisateurEster :");
			System.err.println(ECHEC);
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
		System.out.print("Creation : ");
		if(!entrepriseDB.exist(identifiant)) {
			System.err.print(ECHEC);
			return false;
		} else {
			System.out.print(REUSSITE);
		}
		
		System.out.print("Connexion : ");
		if(!entrepriseDB.connect(identifiant, password)) {
			System.err.print(ECHEC);
			return false;
		} else {
			System.out.print(REUSSITE);
		}
		
		entrepriseDB.changePassword(identifiant, newPassword);
		System.out.print("Changement mot de passe : ");
		if(!entrepriseDB.connect(identifiant, newPassword) || 
				entrepriseDB.connect(identifiant, password)) {
			System.err.print(ECHEC);
			return false;
		} else {
			System.out.print(REUSSITE);
		}

		entrepriseDB.delete(identifiant);
		System.out.print("Suppresion : ");
		if(entrepriseDB.exist(identifiant)) {
			System.err.print(ECHEC);
			return false;
		} else {
			System.out.print(REUSSITE);
		}
		
		return true;
	}

	public static boolean testSalarieDB() {
		SalarieDB salarieDB = new SalarieDB();
		String identifiant = "SalarieTest";
		String entreprise = "Mon Entreprise";
		String userEster = "Mon createur";
		
		salarieDB.add(identifiant, entreprise, userEster);;
		System.out.print("Creation : ");
		if(!salarieDB.exist(identifiant)) {
			System.err.print(ECHEC);
			return false;
		} else {
			System.out.print(REUSSITE);
		}
		
		System.out.print("Connexion : ");
		if(!salarieDB.connect(identifiant)) {
			System.err.print(ECHEC);
			return false;
		} else {
			System.out.print(REUSSITE);
		}

		salarieDB.delete(identifiant);
		System.out.print("Suppresion : ");
		if(salarieDB.exist(identifiant)) {
			System.err.print(ECHEC);
			return false;
		} else {
			System.out.print(REUSSITE);
		}
		
		return true;
	}

	public static boolean testUtilisateurEsterDB() {
		UtilisateurEsterDB UtilisateurEsterDB = new UtilisateurEsterDB();
		String identifiant = "UtilisateurEsterTest";
		String name = "Name";
		String firstName = "First";
		String mail = "test@mail.org";
		String password = "password";
		String newPassword = "password2";
		Status status = Status.MEDECIN;
		
		UtilisateurEsterDB.add(identifiant, name, firstName, mail, password, status);;
		System.out.print("Creation : ");
		if(!UtilisateurEsterDB.exist(identifiant)) {
			System.err.print(ECHEC);
			return false;
		} else {
			System.out.print(REUSSITE);
		}
		
		System.out.print("Connexion : ");
		if(!UtilisateurEsterDB.connect(identifiant, password)) {
			System.err.print(ECHEC);
			return false;
		} else {
			System.out.print(REUSSITE);
		}
		
		UtilisateurEsterDB.changePassword(identifiant, newPassword);
		System.out.print("Changement mot de passe : ");
		if(!UtilisateurEsterDB.connect(identifiant, newPassword) || 
				UtilisateurEsterDB.connect(identifiant, password)) {
			System.err.print(ECHEC);
			return false;
		} else {
			System.out.print(REUSSITE);
		}

		UtilisateurEsterDB.delete(identifiant);
		System.out.print("Suppresion : ");
		if(UtilisateurEsterDB.exist(identifiant)) {
			System.err.print(ECHEC);
			return false;
		} else {
			System.out.print(REUSSITE);
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
