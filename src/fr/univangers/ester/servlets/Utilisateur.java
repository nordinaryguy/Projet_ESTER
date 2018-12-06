package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univangers.ester.beans.UtilisateurBeans;
import fr.univangers.ester.beans.UtilisateurEster;
import fr.univangers.ester.beans.UtilisateurEster.Status;
import fr.univangers.ester.mail.Mail;
import fr.univangers.ester.mdp.PwdGenerator;
import fr.univangers.ester.mongodb.QuestionnairesDB;
import fr.univangers.ester.mongodb.SalarieDB;
import fr.univangers.ester.mongodb.ServerMailDB;
import fr.univangers.ester.mongodb.UtilisateurEsterDB;

/*
 * Servlet utilisé pour la page des utilisateurs (Adminsitrateur/Médecin/
 * Préventeur/Assistant/Infirmier)
 */

@WebServlet("/utilisateur")

public class Utilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_MSG_WARNING = "Warning";
    public static final String ATT_MSG_SUCCESS = "Success";
    public static final String ATT_MSG_ERROR= "Error";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ATT_FIRST_CNX = "FirstConnexion";

    
    public Utilisateur() {
    	super();
    }
   
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	UtilisateurBeans sessionUser = (UtilisateurBeans) session.getAttribute(ATT_SESSION_USER);
        if (sessionUser != null && sessionUser.isUtilisateur()) {
        	//gestion première connexion utilisateur ester 
        	if(sessionUser.isFirstConnection()) {
        		request.setAttribute("id", sessionUser.getIdentifiant());
        		request.setAttribute(ATT_FIRST_CNX, true);
        	}else {
        		request.setAttribute(ATT_FIRST_CNX, false);
        	}
        	 if (sessionUser.isAdministrateur()) { // Pour un utilisateur de type Administrateur
					if(request.getParameter("page") != null && request.getParameter("page").equals("configurationServeurMail")) { // Configuration du serveur Mail
						ServerMailDB serverMailDB = new ServerMailDB();
						request.setAttribute("email", serverMailDB.getServerMail() );
						request.setAttribute("pass", serverMailDB.getServerMailPass());
						request.setAttribute("host", serverMailDB.getServerHost());
						request.setAttribute("port", serverMailDB.getServerPort());
					}
        	 }	

	 		if(request.getParameter("page") != null && request.getParameter("page").equals("donnerQuestionnaire")) { //Attribution de questionnaires aux salariés
	 			QuestionnairesDB questionnairesDB = new QuestionnairesDB();
	     		session.setAttribute("ListeQuestionnaires", questionnairesDB.getIdentifiantQuestionnaires());
	 			SalarieDB salarieDB = new SalarieDB();
	     		session.setAttribute("ListeSalaries", salarieDB.getIdentifiantSalaries());
	 		}
        } 
		this.getServletContext().getRequestDispatcher("/utilisateur/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UtilisateurBeans sessionUser = (UtilisateurBeans) session.getAttribute(ATT_SESSION_USER);
        if (sessionUser != null && sessionUser.isUtilisateur()) {
        	UtilisateurEsterDB user = new UtilisateurEsterDB();
        	ServerMailDB serverMailDB = new ServerMailDB();
        	serverMailDB.addDefautServer();     
        	
    		
        	/*
        	 * Récupération des éléments dans la page ModifierMotDePasse 
        	 * pour le changement de mot de passe
        	 */
    		if(request.getParameter("page") != null && request.getParameter("page").equals("ModifierMotDePasse")) { 
        			String oldPassword=request.getParameter("oldPassword");
        			String newPassword=request.getParameter("newPassword");
        			String confirm=request.getParameter("confirm");
        			if (oldPassword.equals(((UtilisateurEster)sessionUser).getPassword())) {
        				if (newPassword.equals(confirm)) {
        					user.changePassword(sessionUser.getIdentifiant(), newPassword);
        					((UtilisateurEster)sessionUser).setPassword(newPassword);
        	    			request.setAttribute("Success", "Mot de passe modifié");
        				}
        				else {
        					request.setAttribute("Warning", "Mot de passe de confirmation différent");
        				}
        			}
        			else {
        				request.setAttribute("Warning", "Ancien Mot de passe incorrecte");
        			}
        			
        	}
    		
    		/*
    		 * Appel des éléments dans la page donnerQuestionnaire
    		 * pour attribuer des questionnaires à des salariés
    		 */

	 		if(request.getParameter("page") != null && request.getParameter("page").equals("donnerQuestionnaire")) {
        		String identifiantQuestionnaire = request.getParameter("IdentifiantQuestionnaire");
        		String identifiantSalarie = request.getParameter("IdentifiantSalarie");
        		SalarieDB salarieDB = new SalarieDB();
	 			QuestionnairesDB questionnairesDB = new QuestionnairesDB();
        		if(salarieDB.getQuestionnaireAnswered(identifiantSalarie).contains(identifiantQuestionnaire)) {
    	     		session.setAttribute("ListeQuestionnaires", questionnairesDB.getIdentifiantQuestionnaires());
    	     		session.setAttribute("ListeSalaries", salarieDB.getIdentifiantSalaries());
        			request.setAttribute("Warning", "Questionnaire a déja été répondu");
        		} else if(salarieDB.getQuestionnaireUnanswered(identifiantSalarie).contains(identifiantQuestionnaire)) {
    	     		session.setAttribute("ListeQuestionnaires", questionnairesDB.getIdentifiantQuestionnaires());
    	     		session.setAttribute("ListeSalaries", salarieDB.getIdentifiantSalaries());
					request.setAttribute("Warning", "Questionnaire a déja été ajouté");	
        		} else {
        			salarieDB.pushQuestionnaireUnanswered(identifiantSalarie, identifiantQuestionnaire);
    	     		session.setAttribute("ListeQuestionnaires", questionnairesDB.getIdentifiantQuestionnaires());
    	     		session.setAttribute("ListeSalaries", salarieDB.getIdentifiantSalaries());
        			request.setAttribute("Success", "Questionnaire ajouté");
        		}
	 		}
	 		
        	if (sessionUser.isAdministrateur()) { // Concernant l'Administrateur

        		/* 
        		 * Partie permettant de récupérer les éléments de la page
        		 * configurationServeurMail 
        		 */
				if(request.getParameter("page") != null && request.getParameter("page").equals("configurationServeurMail")) {
					request.setAttribute("Success", "Serveur mail modifié");
					serverMailDB.addServerMail(request.getParameter("emailSender"), request.getParameter("password"),request.getParameter("host"),request.getParameter("port"));
				}
			}
        	
        	/*
        	 * Partie permettant de créer un nouveau salarié en appelant une fonction de génération
        	 * d'un Identifiant puis stockage dans la Base de données
        	 */
        	if (sessionUser.isMedecin()||sessionUser.isAdministrateur()||sessionUser.isPreventeur()) {
        		if(request.getParameter("page") != null && request.getParameter("page").equals("createSalarie")) {
        			String  code=PwdGenerator.generateCode();
        			request.setAttribute("message",code );
        			//ajout à la base
        			SalarieDB salarieDB = new SalarieDB();
        			salarieDB.add(code, null, sessionUser.getIdentifiant());
        		}
        	}
        	
        	
            if (sessionUser.isMedecin()||sessionUser.isAdministrateur()) {
            	String forPath = "utilisateur";

            	/* 
            	 * Création d'autres utilisateurs (Préventeur/Assistant/Infirmier voire Médecin)
            	 */

        		if(request.getParameter("page") != null && request.getParameter("page").equals("createUser")) {
        			UtilisateurEsterDB users=new UtilisateurEsterDB();
        			
        			String email=request.getParameter("email");
        			if(!users.existMail(email)) {
        				String type=request.getParameter("typeCompte");
            			String pass=PwdGenerator.generatePassword();
            			String path = request.getRequestURL().toString();
            			path=path.substring(0, path.length()-forPath.length());
            			user.add(email,"", "", email, pass,Status.toStatus(type));
            			System.out.println(pass);
            			Mail mailSender=new Mail();
            			boolean mailSend=mailSender.sendMail(email,"Mot de passe provisoire", mailSender.mdpProvisoireBodyText(pass,path+"/connexion"), true);
            			
            			if(mailSend) {
            				request.setAttribute(ATT_MSG_SUCCESS,"Compte crée et mail envoyé");
            			}
            			else {
            				request.setAttribute(ATT_MSG_WARNING,"un problème est survenu. Veuillez réessayer plus tard.");
            			}
        			}else {
        				request.setAttribute(ATT_MSG_ERROR, "Email déjà existant");
        			}
        			
        			
        		}
        	}
        }
		this.getServletContext().getRequestDispatcher("/utilisateur/index.jsp").forward(request, response);
	}
}

