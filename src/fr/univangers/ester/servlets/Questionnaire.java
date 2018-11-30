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
import fr.univangers.ester.mongodb.Questionnaires;
import fr.univangers.ester.mongodb.Reponses;

/**
 * Servlet implementation class Questionnaire
 */
@WebServlet("/questionnaire")
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
		Questionnaires questionnaires = new Questionnaires();
		session.setAttribute("ListeQuestionnaires", questionnaires.getIdentifiantQuestionnaires());
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
        Reponses reponses = new Reponses();
    	
    	String identifiant = request.getParameter("Identifiant");
		if(identifiant != null) {
			try {
				Questionnaires questionnaires = new Questionnaires();
				session.setAttribute("Identifiant Questionnaire", identifiant);
				session.setAttribute("Nom", questionnaires.getName(identifiant));
				session.setAttribute("Date", DateFormat.getDateInstance().format(questionnaires.getDateSubmission(identifiant)));
				session.setAttribute("IdentifiantEster", questionnaires.getIdentifiantEster(identifiant));
				session.setAttribute("Questionnaire", questionnaires.getHTMLQuestionnaire(identifiant));
			} catch (Exception e) {
				e.printStackTrace();
			}
			doGet(request, response);
		} else {
			Enumeration<String> names = request.getParameterNames();
	        List<Map<String, String>> reponsesQuestions = new ArrayList<>();
			while (names.hasMoreElements()) {
				Map<String, String> reponseQuestion = new HashMap<>();
	            String identifiant_question = names.nextElement();
	            String values = "Question;" + request.getParameter(identifiant_question).toString();
	            String[] valuesSplit = values.split(";");
	            reponseQuestion.put(Reponses.IDENTIFIANT_QUESTION, identifiant_question);
	            reponseQuestion.put(Reponses.QUESTION, valuesSplit[0]);
	            reponseQuestion.put(Reponses.REPONSE, valuesSplit[1]);
	            reponsesQuestions.add(reponseQuestion);
	    	}    	
			User sessionUser = (User) session.getAttribute(ATT_SESSION_USER);
            reponses.addReponse(sessionUser.getIdentifiant(), session.getAttribute("Identifiant Questionnaire").toString(), reponsesQuestions); 
            request.getRequestDispatcher(RESULTAT).forward(request, response);
		}
	}

}
