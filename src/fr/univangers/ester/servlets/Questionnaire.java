package fr.univangers.ester.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univangers.ester.beans.User;
import fr.univangers.ester.mongodb.QuestionnairesDB;
import fr.univangers.ester.mongodb.ReponsesDB;
import fr.univangers.ester.mongodb.SalarieDB;

/**
 * Servlet implementation class Questionnaire
 */
@WebServlet({ "/salarie/questionnaire", "/utilisateur/questionnaire" })
public class Questionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/jsp/Questionnaire.jsp";
	private static final String RESULTAT = "/resultat";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Questionnaire() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		QuestionnairesDB questionnairesDB = new QuestionnairesDB();
    	User sessionUser = (User) session.getAttribute(ATT_SESSION_USER);
    	SalarieDB salarieDB = new SalarieDB();
    	if(sessionUser.isSalarie())
    		session.setAttribute("ListeQuestionnaires", salarieDB.getQuestionnaireUnanswered(sessionUser.getIdentifiant()));
    	else
    		session.setAttribute("ListeQuestionnaires", questionnairesDB.getIdentifiantQuestionnaires());
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
		QuestionnairesDB questionnaires = new QuestionnairesDB();
    	User sessionUser = (User) session.getAttribute(ATT_SESSION_USER);
    	
    	String identifiant = request.getParameter("Identifiant");
		if(identifiant != null && questionnaires.existQuestionnaire(identifiant)) {
			session.setAttribute("Identifiant Questionnaire", identifiant);
			session.setAttribute("Nom", questionnaires.getName(identifiant));
			session.setAttribute("Date", DateFormat.getDateInstance().format(questionnaires.getDateSubmission(identifiant)));
			session.setAttribute("IdentifiantEster", questionnaires.getIdentifiantEster(identifiant));
			session.setAttribute("Questionnaire", questionnaires.getHTMLQuestionnaire(identifiant));
			doGet(request, response);
		} else if(sessionUser != null && sessionUser.isSalarie()) {
			Enumeration<String> names = request.getParameterNames();
	        Map<String, String> reponses = new HashMap<>();
			while (names.hasMoreElements()) {
	            String identifiantQuestion = names.nextElement();
	            String reponse = request.getParameter(identifiantQuestion);
	            reponses.put(identifiantQuestion, reponse);
	    	} 
	        ReponsesDB reponsesDB = new ReponsesDB();   	
	        String identifiantQuestionnaire = session.getAttribute("Identifiant Questionnaire").toString();
			reponsesDB.addReponse(sessionUser.getIdentifiant(), identifiantQuestionnaire, reponses); 
			SalarieDB salarieDB = new SalarieDB();
			salarieDB.pushQuestionnaireAnswered(sessionUser.getIdentifiant(), identifiantQuestionnaire);
			// salarieDB.pullQuestionnaireUnanswered(sessionUser.getIdentifiant(), identifiantQuestionnaire);
			response.sendRedirect(request.getContextPath() + RESULTAT);
		} else {
			doGet(request, response);
		}
	}

}
