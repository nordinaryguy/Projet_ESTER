package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univangers.ester.beans.User;
import fr.univangers.ester.mongodb.Users;

@WebServlet("/salarie")
public class Salarie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_MSG_WARNING = "Warning";
    public static final String ATT_MSG_SUCCESS = "Success";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ATT_FIRST_CNX = "FirstConnexion";
   
    public Salarie() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	User sessionUser = (User) session.getAttribute(ATT_SESSION_USER);
        if (sessionUser != null && sessionUser.isSalarie()) {
        	
        	if(sessionUser.isFirstConnection()){
        		request.setAttribute(ATT_FIRST_CNX, true);
        	}else {
        		request.setAttribute(ATT_FIRST_CNX, false);
        	}
        }
		this.getServletContext().getRequestDispatcher("/salarie/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	User sessionUser = (User) session.getAttribute(ATT_SESSION_USER);
    	if(sessionUser.isFirstConnection()){
    		String sexe=request.getParameter("sexe");
        	String[] birthYear=request.getParameter("years").split("-",2);
        	String pcs=request.getParameter("pcs");
        	String naf=request.getParameter("naf");
        	String departement=request.getParameter("departement");
        	Users users = new Users();
        	if(users.updateSalrie(sessionUser.getIdentifiant(), sexe, Integer.parseInt(birthYear[0]), Integer.parseInt(birthYear[1]), departement, naf,pcs)){
        		request.setAttribute(ATT_MSG_SUCCESS,"Profil mis à jour ");
        		System.out.println("ajout user");
        	}
        	else {
        		request.setAttribute(ATT_MSG_WARNING,"un problème a survenu.Veuillez réessayer plus tard.");
        	}
        	
    	}
		
		this.getServletContext().getRequestDispatcher("/salarie/index.jsp").forward(request, response);
	}

}
