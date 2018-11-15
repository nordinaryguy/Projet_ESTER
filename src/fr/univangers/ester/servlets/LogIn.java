package fr.univangers.ester.servlets;

import java.io.IOException;
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
    	String inputIdentifiant = request.getParameter("Identifiant");
    	System.out.println("Reponse");
    	System.out.println(inputIdentifiant);
    	doGet(request, response);
	}

}

