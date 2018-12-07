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
import fr.univangers.ester.beans.UtilisateurBeans;
import fr.univangers.ester.beans.UtilisateurEster;
import fr.univangers.ester.mongodb.SalarieDB;
import fr.univangers.ester.mongodb.ServerMailDB;
import fr.univangers.ester.mongodb.UtilisateurEsterDB;

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
		ServerMailDB serverMailDB = new ServerMailDB();
		if(serverMailDB.serverMailEmpty())
			serverMailDB.addDefautServer();
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String type = request.getParameter("Type");
    	HttpSession session = request.getSession();
    	UtilisateurBeans utilisateur = null;
		UtilisateurEsterDB userDB = new UtilisateurEsterDB();
    	
    	boolean result = false;
    	if(type.equals("Salarie")) {
    		utilisateur = new Salarie();
    		utilisateur.setIdentifiant(request.getParameter("Identifiant"));
        	result = utilisateur.validate();
        	if(!result) {
    			request.setAttribute( ATT_MSG_WARNING, "Votre identifiant est incorrect.");
    		} else {
        		SalarieDB salarieDB = new SalarieDB();
        		salarieDB.incCnx(request.getParameter("Identifiant"));
    		}
    	} else if(type.equals("Entreprise")) {
    		utilisateur = new Entreprise();
    		utilisateur.setIdentifiant(request.getParameter("Identifiant"));
    		((Entreprise)utilisateur).setPassword(request.getParameter("Password"));
        	result = utilisateur.validate();
        	if(!result) {
    			request.setAttribute( ATT_MSG_WARNING, "Votre identifiant ou votre mot de passe est incorrect.");
        	}
    	} else if(type.equals("Utilisateur")) {
    		utilisateur = new UtilisateurEster();
    		String identifiant = request.getParameter("Identifiant");
    		utilisateur.setIdentifiant(identifiant);
    		((UtilisateurEster)utilisateur).setPassword(request.getParameter("Password"));
        	result = utilisateur.validate();
        	if(!result) {
    			request.setAttribute( ATT_MSG_WARNING, "Votre identifiant ou votre mot de passe est incorrect.");
        	} else {
        		((UtilisateurEster)utilisateur).setStatus(userDB.getStatus(identifiant));
        	}
    	}
    	if(type != null && result) {
    		request.setAttribute( ATT_MSG_SUCCESS, "Vous êtes connecté");
    		session.setAttribute( ATT_SESSION_USER, utilisateur);
    	} else {
    		session.setAttribute( ATT_SESSION_USER, null);
    	}
    	doGet(request, response);
	}

}

