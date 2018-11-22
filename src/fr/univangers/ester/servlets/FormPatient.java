package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univangers.ester.mongodb.Users;

@WebServlet("/FormPatient")
public class FormPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public FormPatient() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
        	this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/FormPatient.jsp").forward(request, response);
		}catch(ServletException e) {
			try {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
			}
			catch (IOException ioe) {
				// IOException
			}
		}
		catch (IOException e) {
				// IOException
		}
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//NB: not all variables are defined and pcs isn't included in creation in database
    	String sexe=request.getParameter("sexe");
    	int birthYear=Integer.parseInt(request.getParameter("years"));
    	//TODO should be added to table
    	String pcs=request.getParameter("pcs");
    	String departement=request.getParameter("nomDepartement");
    	String region=request.getParameter("region");
    	Users users = new Users();
    	users.addSalarie("Null", 0,"Null", sexe, birthYear,departement, region, "Null","Null", "Null");
    	try {
        	this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/FormPatient.jsp").forward(request, response);
		}catch(ServletException e) {
			try {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
			}
			catch (IOException ioe) {
				// IOException
			}
		}
		catch (IOException e) {
				// IOException
		}
	}

}
