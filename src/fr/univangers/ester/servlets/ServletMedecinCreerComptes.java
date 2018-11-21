package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univangers.ester.mdp.PwdGenerator;
import fr.univangers.ester.mongodb.Users;

@WebServlet("/ServletMedecin")
public class ServletMedecinCreerComptes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletMedecinCreerComptes() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/MedecinCreerCompte.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  code=PwdGenerator.generateCode();
		request.setAttribute("message",code );
		//ajout à la base
		Users user=new Users();
		user.addCodeGenrated(code);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/MedecinCreerCompte.jsp").forward(request, response);
	}

}
