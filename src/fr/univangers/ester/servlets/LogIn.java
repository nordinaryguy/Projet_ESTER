package fr.univangers.ester.servlets;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univangers.ester.mongodb.Users;

@WebServlet("/connexion")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String vue = "/WEB-INF/jsp/C/LogIn.jsp";
    
    public LogIn() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(vue).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String type = request.getParameter("Type");
    	Users users = new Users();
    	boolean result = false;
    	if(type.equals("Salarie")) {
    		String identifiant = request.getParameter("Identifiant");
        	result = users.connectSalarie(identifiant, null);
        	if(!result) {
    			request.setAttribute("Warning", "C'est incorrect, vérifiez l'identifiant saisis");
        	}
    	}
    	else if(type.equals("Entreprise")) {
    		String email = request.getParameter("Email");
    		String password = request.getParameter("Password");
        	result = users.connectEntreprise(email, password);
        	if(!result) {
    			request.setAttribute("Warning", "C'est incorrect, vérifiez l'adresse mail et le mot de passe saisis");
        	}
    	}
    	else if(type.equals("Utilisateur")) {
    		String email = request.getParameter("Email");
    		String password = request.getParameter("Password");
        	result = users.connectUserEster(email, password);
        	if(!result) {
    			request.setAttribute("Warning", "C'est incorrect, vérifiez l'adresse mail et le mot de passe saisis");
        	}
    	}
    	if(type != null && result) {
    			request.setAttribute("Success", "Vous êtes connecté");
    	}
    	doGet(request, response);
	}

}

