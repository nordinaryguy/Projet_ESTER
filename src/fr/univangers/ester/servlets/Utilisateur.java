package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.client.model.Filters;

import fr.univangers.ester.beans.User;
import fr.univangers.ester.beans.Utilisateur.Status;
import fr.univangers.ester.mail.Mail;
import fr.univangers.ester.mdp.PwdGenerator;
import fr.univangers.ester.mongodb.QuestionnairesDB;
import fr.univangers.ester.mongodb.SalarieDB;
import fr.univangers.ester.mongodb.ServerMailDB;
import fr.univangers.ester.mongodb.Users;


@WebServlet("/utilisateur")

public class Utilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_MSG_WARNING = "Warning";
    public static final String ATT_MSG_SUCCESS = "Success";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    
    public Utilisateur() {
    	super();
    }
   
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	User sessionUser = (User) session.getAttribute(ATT_SESSION_USER);
        if (sessionUser != null && sessionUser.isUtilisateur()) {
        	 if (sessionUser.isAdministrateur()) {
					if(request.getParameter("page") != null && request.getParameter("page").equals("configurationServeurMail")) {
						ServerMailDB serverMailDB = new ServerMailDB();
						serverMailDB.addDefautServer();
						request.setAttribute("email", serverMailDB.getServerMail() );
						request.setAttribute("pass", serverMailDB.getServerMailPass());
						request.setAttribute("host", serverMailDB.getServerHost());
						request.setAttribute("port", serverMailDB.getServerPort());
					}
        	 }	

	 		if(request.getParameter("page") != null && request.getParameter("page").equals("donnerQuestionnaire")) {
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
   	 	User sessionUser = (User) session.getAttribute(ATT_SESSION_USER);
        if (sessionUser != null && sessionUser.isUtilisateur()) {
        	Users user = new Users();
        	ServerMailDB serverMailDB = new ServerMailDB();
        	serverMailDB.addDefautServer();       
    		
    		if(request.getParameter("page") != null && request.getParameter("page").equals("ModifierMotDePasse")) {
        			String oldPassword=request.getParameter("oldPassword");
        			String newPassword=request.getParameter("newPassword");
        			String confirm=request.getParameter("confirm");
        			if (oldPassword.equals(((fr.univangers.ester.beans.Utilisateur)sessionUser).getPassword())) {
        				if (newPassword.equals(confirm)) {
        					user.changePasswordUserEster(sessionUser.getIdentifiant(), newPassword);
        					((fr.univangers.ester.beans.Utilisateur)sessionUser).setPassword(newPassword);
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

	 		if(request.getParameter("page") != null && request.getParameter("page").equals("donnerQuestionnaire")) {
        		String identifiantQuestionnaire = request.getParameter("IdentifiantQuestionnaire");
        		String identifiantSalarie = request.getParameter("IdentifiantSalarie");
        		SalarieDB salarieDB = new SalarieDB();
	 			QuestionnairesDB questionnairesDB = new QuestionnairesDB();
        		if(salarieDB.getQuestionnaireAnswered(identifiantSalarie).contains(identifiantQuestionnaire)) {
    	     		session.setAttribute("ListeQuestionnaires", questionnairesDB.getIdentifiantQuestionnaires());
    	     		session.setAttribute("ListeSalaries", salarieDB.getIdentifiantSalaries());
        			request.setAttribute("Warning", "Questionnaire a déja été répondus");
        		} else if(salarieDB.getQuestionnaireUnanswered(identifiantSalarie).contains(identifiantQuestionnaire)) {
    	     		session.setAttribute("ListeQuestionnaires", questionnairesDB.getIdentifiantQuestionnaires());
    	     		session.setAttribute("ListeSalaries", salarieDB.getIdentifiantSalaries());
					request.setAttribute("Warning", "Questionnaire a déja été ajouté");	
        		} else {
        			salarieDB.pushQuestionnaireUnanswered(identifiantSalarie, identifiantQuestionnaire);
    	     		session.setAttribute("ListeQuestionnaires", questionnairesDB.getIdentifiantQuestionnaires());
    	     		session.setAttribute("ListeSalaries", salarieDB.getIdentifiantSalaries());
        			request.setAttribute("Success", "Questionnaire ajouter");
        		}
	 		}
	 		
        	if (sessionUser.isAdministrateur()) {

				if(request.getParameter("page").equals("configurationServeurMail")) {
					request.setAttribute("Success", "Serveur mail modifié");
					serverMailDB.addServerMail(request.getParameter("emailSender"), request.getParameter("password"),request.getParameter("host"),request.getParameter("port"));
				}
			}
        	
        	if (sessionUser.isMedecin()||sessionUser.isAdministrateur()||sessionUser.isPreventeur()) {
        		if(request.getParameter("page").equals("createSalarie")) {
        			String  code=PwdGenerator.generateCode();
        			request.setAttribute("message",code );
        			//ajout à la base
        			SalarieDB salarieDB = new SalarieDB();
        			salarieDB.addSalarie(code, null, sessionUser.getIdentifiant());
        		}
        	}
        	
            if (sessionUser.isMedecin()||sessionUser.isAdministrateur()) {
            	String forPath;
            	if (sessionUser.isMedecin()) {
            		forPath="Medecin";
            	}
            	else {
            		forPath="Administrateur";
            	}
            	

        		if(request.getParameter("page").equals("createUser")) {
        			String email=request.getParameter("email");
        			String type=request.getParameter("typeCompte");
        			String pass=PwdGenerator.generatePassword();
        			String path = request.getRequestURL().toString();
        			path=path.substring(0, path.length()-forPath.length());
        			user.addUserEster(email,"", "", email, pass,Status.toStatus(type));
        			Mail mailSender=new Mail();
        			boolean mailSend=mailSender.sendMail(email,"Mot de passe provisoire", mailSender.mdpProvisoireBodyText(pass,path+"connexion"), true);
        			if(mailSend) {
        				request.setAttribute(ATT_MSG_SUCCESS,"mail envoyé");
        			}
        			else {
        				request.setAttribute(ATT_MSG_WARNING,"un problème a survenu.Veuillez réessayer plus tard.");
        			}
        		}
        	}
        }
		this.getServletContext().getRequestDispatcher("/utilisateur/index.jsp").forward(request, response);
	}
}

