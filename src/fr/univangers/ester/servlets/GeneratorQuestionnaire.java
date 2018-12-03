package fr.univangers.ester.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univangers.ester.beans.UtilisateurBeans;
import fr.univangers.ester.mongodb.QuestionnairesDB;

/**
 * Servlet implementation class questionnaire
 */
@WebServlet("/utilisateur/generateur_questionnaire")
public class GeneratorQuestionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String ATT_SOURCE  = "source";
    public static final String ATT_IDENTIFIANT = "Identifiant";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ATT_NOM = "Nom";
    public static final String ATT_MSG_WARNING = "Warning";
    public static final String ATT_MSG_SUCCESS = "Success";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneratorQuestionnaire() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/generateur_de_question.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String source = request.getParameter(ATT_SOURCE);
   		HttpSession session = request.getSession();
   		if(source != null) {
   			String identifiant = request.getParameter(ATT_IDENTIFIANT);
   			String nom = request.getParameter(ATT_NOM);
   			String identifiantEster = ((UtilisateurBeans)session.getAttribute(ATT_SESSION_USER)).getIdentifiant();
   			QuestionnairesDB questionnaires = new QuestionnairesDB();
   			if(questionnaires.existQuestionnaire(identifiant)) {
			   session.setAttribute(ATT_MSG_WARNING, "Identifiant deja utilisé");
   			} else {
			   session.setAttribute(ATT_MSG_SUCCESS, "Questionnaire sauvegarder");
			   questionnaires.addQuestionnaire(nom, identifiant, source, identifiantEster);
   			}
   	       createFile(source);	
       }
       this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/generateur_de_question.jsp").forward(request, response); 
	}
	protected String StyleForm() {
		return "  <style type=\"text/css\">\r\n" + 
				"      body {\r\n" + 
				"        padding-bottom: 10px;\r\n" + 
				"        background: repeating-linear-gradient(-45deg, white, white 4px, #e9e8e7 4px, white 6px);\r\n" + 
				"      }\r\n" +
				" fieldset{\r\n" + 
				"	  text-align: center;\r\n" + 
				"	  font-style: italic;\r\n" + 
				"	  }"+
				"    </style>";
	}
	protected String createFormHeader() {
		return "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"  <head>\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <title>generateur de questionnaire</title>\r\n" +
				StyleForm() + 
				"  </head>\r\n" + 
				"  <body>\r\n" + 
				"  \r\n" + 
				"   <!-- questionnaire -->\r\n" + 
				"    <div class=\"container\" style=\"background-color: white; margin-top: 5%;\"> ";
	}
	protected String createFormfooter() {
		return " <!--submit btn-->\r\n" + 
				"      <div class=\"row\" style=\"text-align: center;\">\r\n" + 
				"        <input type=\"submit\"  value=\"enregistrer\" > \r\n" + 
				"      </div>\r\n" + 
				"   </div>\r\n" + 
				"  </body>\r\n" + 
				"</html>\r\n" + 
				"";
	}
	protected void createFile(String text) {
		try
		{
			File file = new File("C:/Users/IMANE/eclipse-workspace/Projet_Ester/file.html");
			file.getParentFile().mkdirs();
			PrintWriter printWriter = new PrintWriter(file);
			printWriter.println(createFormHeader());
			printWriter.println(text);
			printWriter.println(createFormfooter());
			printWriter.close();
			System.out.println("fichier cree ");
		}
		catch (IOException exception)
		{
		    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
	}

}
