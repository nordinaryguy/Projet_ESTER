package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deconnexion")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_REDIRECTION  = "/connexion";
       
    public LogOut() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        session = request.getSession();
        session.setAttribute("Success", "Vous êtes déconnecté");
        response.sendRedirect(request.getContextPath() + URL_REDIRECTION);
	}

}
