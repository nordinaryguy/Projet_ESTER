package fr.univangers.ester.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univangers.ester.beans.UtilisateurBeans;
import fr.univangers.ester.mongodb.ReponsesDB;

@WebServlet("/resultat")
public class Resultat extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String IDEVALRISKTMS = "Eval-Risk-TMS";
	private static final String ATT_IDENTIFIANTSALARIE = "identifiantSalarie";
	private static final String ATT_LISTSALARIES = "listSalarie";
	private static final String ATT_SESSION_USER = "sessionUtilisateur";
	
    public Resultat() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ReponsesDB reponseDB = new ReponsesDB();
    	UtilisateurBeans sessionUser = (UtilisateurBeans) session.getAttribute(ATT_SESSION_USER);
		List<String> listIdentifiants = reponseDB.getListSalaire(IDEVALRISKTMS);
		if(!listIdentifiants.isEmpty() && sessionUser != null && sessionUser.isUtilisateur()) {
			session.setAttribute(ATT_IDENTIFIANTSALARIE, listIdentifiants.get(0));
			session.setAttribute(ATT_LISTSALARIES, listIdentifiants);
		}
		this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/Resultat.jsp" ).forward( request, response );
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	UtilisateurBeans sessionUser = (UtilisateurBeans) session.getAttribute(ATT_SESSION_USER);
		ReponsesDB reponseDB = new ReponsesDB();
		List<String> listIdentifiants = reponseDB.getListSalaire(IDEVALRISKTMS);
		if(!listIdentifiants.isEmpty() && sessionUser != null && sessionUser.isUtilisateur()) {
			session.setAttribute(ATT_IDENTIFIANTSALARIE, 
					listIdentifiants.contains(request.getParameter(ATT_IDENTIFIANTSALARIE)) ? 
					request.getAttribute(ATT_IDENTIFIANTSALARIE) : listIdentifiants.get(0));
			session.setAttribute(ATT_LISTSALARIES, listIdentifiants);
		}
		doGet(request, response);
	}
}
