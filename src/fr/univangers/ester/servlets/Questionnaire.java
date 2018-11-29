package fr.univangers.ester.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univangers.ester.mongodb.Questionnaires;

/**
 * Servlet implementation class Questionnaire
 */
@WebServlet("/questionnaire")
public class Questionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/jsp/Questionnaire.jsp";
       
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
    	
    	String identifiant = request.getParameter("Identifiant");
		if(identifiant != null) {
			try {
				Questionnaires questionnaires = new Questionnaires();
				session.setAttribute("Nom", questionnaires.getName(identifiant));
				session.setAttribute("Date", DateFormat.getDateInstance().format(questionnaires.getDateSubmission(identifiant)));
				session.setAttribute("IdentifiantEster", questionnaires.getIdentifiantEster(identifiant));
				session.setAttribute("Questionnaire", questionnaires.getHTMLQuestionnaire(identifiant));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
	       Enumeration<String> names = request.getParameterNames();
	        while (names.hasMoreElements()) {
	            String name = names.nextElement();
	            String value = request.getParameter(name).toString();
	            System.out.println(name+":"+value);
	        }
			System.out.println("A");
		}
		doGet(request, response);
	}

}
