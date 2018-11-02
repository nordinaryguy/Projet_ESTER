package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univangers.ester.mongodb.Users;

@WebServlet("/ServletsFormPatient")
public class ServletFormPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServletFormPatient() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/FormPatient.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//NB: not all variables are defined and pcs isn't included in creation in database
    	String sexe=request.getParameter("sexe");
    	int birthYear=Integer.parseInt(request.getParameter("years"));
    	String pcs=request.getParameter("pcs");
    	String departement=request.getParameter("nomDepartement");
    	String region=request.getParameter("region");
    	Users users = new Users();
    	users.addSalarie("Null", 0,"Null", sexe, birthYear,departement, region, "Null","Null", "Null");
	}

}
