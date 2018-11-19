package fr.univangers.ester.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univangers.ester.mongodb.Users;

@WebServlet("/connexion")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/jsp/LogIn.jsp";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ATT_MSG_WARNING = "Warning";
    public static final String ATT_MSG_SUCCESS = "Success";
    
    public LogIn() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String type = request.getParameter("Type");
    	Users users = new Users();
    	HttpSession session = request.getSession();
    	
    	boolean result = false;
    	if(type.equals("Salarie")) {
    		String identifiant = request.getParameter("Identifiant");
        	result = users.connectSalarie(identifiant, null);
        	if(!result) {
    			request.setAttribute( ATT_MSG_WARNING, "Votre identifiant est incorrect.");
        	}
    	}
    	else if(type.equals("Entreprise")) {
    		String email = request.getParameter("Email");
    		String password = request.getParameter("Password");
        	result = users.connectEntreprise(email, password);
        	if(!result) {
    			request.setAttribute( ATT_MSG_WARNING, "Votre identifiant ou votre mot de passe est incorrect.");
        	}
    	}
    	else if(type.equals("Utilisateur")) {
    		String email = request.getParameter("Email");
    		String password = request.getParameter("Password");
        	result = users.connectUserEster(email, password);
        	if(!result) {
    			request.setAttribute( ATT_MSG_WARNING, "Votre identifiant ou votre mot de passe est incorrect.");
        	}
    	}
    	if(type != null && result) {
    		request.setAttribute( ATT_MSG_SUCCESS, "Vous êtes connecté");
    		session.setAttribute( ATT_SESSION_USER, null);
    	}
    	else {
    		session.setAttribute( ATT_SESSION_USER, true);
    	}
    	doGet(request, response);
	}

}

