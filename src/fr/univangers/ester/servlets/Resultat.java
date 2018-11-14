package fr.univangers.ester.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Resultat")
public class Resultat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Resultat() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
<<<<<<< HEAD
			this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/resultat.jsp" ).forward( request, response );
=======
			this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/Resultat.jsp" ).forward( request, response );
>>>>>>> 6dd11efae1e3473f43bcc21851fc7aff3a3d1abe
		}
		catch (ServletException e) {
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
		try {
			doGet(request, response);
		}
		catch (ServletException e) {
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
