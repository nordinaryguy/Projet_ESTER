package fr.univangers.ester.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univangers.ester.beans.UtilisateurBeans;
import fr.univangers.ester.mongodb.QuestionnairesDB;
import fr.univangers.ester.mongodb.ReponsesDB;
import fr.univangers.ester.mongodb.SalarieDB;

@WebServlet({ "/salarie/questionnaire", "/utilisateur/questionnaire" })
public class Questionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/jsp/Questionnaire.jsp";
	private static final String RESULTAT = "/resultat";
    private static final String ATT_SESSION_USER = "sessionUtilisateur";
    private static final int TIMEOUT = 1;
       
    public Questionnaire() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		QuestionnairesDB questionnairesDB = new QuestionnairesDB();
    	UtilisateurBeans sessionUser = (UtilisateurBeans) session.getAttribute(ATT_SESSION_USER);
    	SalarieDB salarieDB = new SalarieDB();
    	// Si l'utilisateur est un salarie alors retourne les questionnaire a repondre sinon (utiliateur ou medecin) les retourne tous
    	if(sessionUser.isSalarie())
    		session.setAttribute("ListeQuestionnaires", salarieDB.getQuestionnaireUnanswered(sessionUser.getIdentifiant()));
    	else
    		session.setAttribute("ListeQuestionnaires", questionnairesDB.getIdentifiantQuestionnaires());
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
		QuestionnairesDB questionnaires = new QuestionnairesDB();
    	UtilisateurBeans sessionUser = (UtilisateurBeans) session.getAttribute(ATT_SESSION_USER);
    	
    	String identifiant = request.getParameter("Identifiant");
    	// Si l'identifiant du questionnaire passé en parametre existe
		if(identifiant != null && questionnaires.existQuestionnaire(identifiant)) {
			// Alors retourne les informations du questionnaire
			session.setAttribute("Identifiant Questionnaire", identifiant);
			session.setAttribute("Nom", questionnaires.getName(identifiant));
			session.setAttribute("Date", DateFormat.getDateInstance().format(questionnaires.getDateSubmission(identifiant)));
			session.setAttribute("IdentifiantEster", questionnaires.getIdentifiantEster(identifiant));
			session.setAttribute("Questionnaire", questionnaires.getHTMLQuestionnaire(identifiant));
			doGet(request, response);
		// Si l'utilisateur est un salarie
		} else if(sessionUser != null && sessionUser.isSalarie()) {
			Enumeration<String> names = request.getParameterNames();
	        Map<String, String> reponses = new HashMap<>();
	        // Récupere tous les reponses envoyer
			while (names.hasMoreElements()) {
	            String identifiantQuestion = names.nextElement();
	            String reponse = request.getParameter(identifiantQuestion);
	            reponses.put(identifiantQuestion, reponse);
	    	} 
	        ReponsesDB reponsesDB = new ReponsesDB();   	
	        String identifiantQuestionnaire = session.getAttribute("Identifiant Questionnaire").toString();
	        // Ajoute la réponse dans la base de données
			reponsesDB.addReponse(sessionUser.getIdentifiant(), identifiantQuestionnaire, reponses); 
			SalarieDB salarieDB = new SalarieDB();
			// Passe le questionnaire en répondus 
			salarieDB.pushQuestionnaireAnswered(sessionUser.getIdentifiant(), identifiantQuestionnaire);
			Executors.newScheduledThreadPool(1).schedule(new Runnable() { 
				@Override
				public void run() {
					salarieDB.pullQuestionnaireUnanswered(sessionUser.getIdentifiant(), identifiantQuestionnaire);
				}}, TIMEOUT, TimeUnit.MINUTES
			);
			response.sendRedirect(request.getContextPath() + RESULTAT);
		} else {
			doGet(request, response);
		}
	}

}
