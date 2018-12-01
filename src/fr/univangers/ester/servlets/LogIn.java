package fr.univangers.ester.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univangers.ester.beans.Entreprise;
import fr.univangers.ester.beans.Salarie;
import fr.univangers.ester.beans.User;
import fr.univangers.ester.beans.Utilisateur;
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
    	HttpSession session = request.getSession();
    	User user = null;
		Users userDB = new Users();
		
    	boolean result = false;
    	boolean firstConnectionSalarie = false;
    	String code=request.getParameter("Identifiant");
    	if(type.equals("Salarie")) {
    		user = new Salarie();
    		user.setIdentifiant(request.getParameter("Identifiant"));
        	result = user.validate();
        	if(userDB.existCode(code)) {
    			//page saisi formulaire
    			request.setAttribute("codePatient",code);
    			firstConnectionSalarie = true;
    		}
        	if(!result) {
    			request.setAttribute( ATT_MSG_WARNING, "Votre identifiant est incorrect.");
    		}
    	}
    	else if(type.equals("Entreprise")) {
    		user = new Entreprise();
    		user.setIdentifiant(request.getParameter("Identifiant"));
    		((Entreprise)user).setPassword(request.getParameter("Password"));
        	result = user.validate();
        	if(!result) {
    			request.setAttribute( ATT_MSG_WARNING, "Votre identifiant ou votre mot de passe est incorrect.");
        	}
    	}
    	else if(type.equals("Utilisateur")) {
    		user = new Utilisateur();
    		String identifiant = request.getParameter("Identifiant");
    		user.setIdentifiant(identifiant);
    		((Utilisateur)user).setPassword(request.getParameter("Password"));
        	result = user.validate();
        	if(!result) {
    			request.setAttribute( ATT_MSG_WARNING, "Votre identifiant ou votre mot de passe est incorrect.");
        	} else {
        		((Utilisateur)user).setStatus(userDB.getStatusUserEster(identifiant));
        	}
    	}
    	if(type != null && result) {
    		request.setAttribute( ATT_MSG_SUCCESS, "Vous êtes connecté");
    		session.setAttribute( ATT_SESSION_USER, user);
    	}
    	else {
    		session.setAttribute( ATT_SESSION_USER, null);
    	}

    	if(firstConnectionSalarie) {
    		this.getServletContext().getRequestDispatcher("/FormPatient").forward(request, response);
    		//response.sendRedirect("/FormPatient");
    	}
		else {
			doGet(request, response);
		}

	}

	
}

