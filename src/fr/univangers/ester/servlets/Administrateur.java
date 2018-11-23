package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univangers.ester.mongodb.Users;




@WebServlet("/Administrateur")
public class Administrateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Administrateur() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("page") != null && request.getParameter("page").equals("configurationServeurMail")) {
			Users user=new Users();
			request.setAttribute("email",user.getServerMail() );
			request.setAttribute("pass",user.getServerMailPass());
			request.setAttribute("host", user.getServerHost());
			request.setAttribute("port", user.getServerPort());
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Administrateur.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("page").equals("configurationServeurMail")) {
			Users user=new Users();
			request.setAttribute("Success", "Serveur mail modifié");
			user.addServerMail(request.getParameter("emailSender"), request.getParameter("password"),request.getParameter("host"),request.getParameter("port"));
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Administrateur.jsp").forward(request, response);
	}

}
