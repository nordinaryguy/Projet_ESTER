package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univangers.ester.beans.User;
import fr.univangers.ester.mongodb.SalarieDB;
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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	User sessionUser = (User) session.getAttribute(ATT_SESSION_USER);
        if (sessionUser != null && sessionUser.isSalarie()) {
        	
        	if(sessionUser.isFirstConnection() ||  (request.getParameter("page")!= null && request.getParameter("page").equals("modifierProfil"))){
        		request.setAttribute(ATT_FIRST_CNX, true);
        	}else {
        		request.setAttribute(ATT_FIRST_CNX, false);
        	}
        }
        try {
        	this.getServletContext().getRequestDispatcher("/salarie/index.jsp").forward(request, response);
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
		HttpSession session = request.getSession();
    	User sessionUser = (User) session.getAttribute(ATT_SESSION_USER);
    	if(sessionUser.isFirstConnection() || (request.getParameter("page")!= null && request.getParameter("page").equals("modifierProfil"))){
    		//if (sessionUser.isFirstConnection()) {
    			String sexe=request.getParameter("sexe");
    		/*}
    		else {
    			String sexe = sessionUser.getSex();
    		}*/
        	String[] birthYear=request.getParameter("years").split("-",2);
        	String pcs=request.getParameter("pcs");
        	String naf=request.getParameter("naf");
        	String departement=request.getParameter("departement");
        	int birthInf=0;
            int birthSup=100;
        	try {
        		birthInf=Integer.parseInt(birthYear[0]);
        		birthSup=Integer.parseInt(birthYear[1]);
        	}catch(Exception e){
        		request.setAttribute(ATT_MSG_WARNING,"un problème a survenu.Veuillez réessayer plus tard.");
        	}
        	SalarieDB salarieDB = new SalarieDB();
        	if(salarieDB.updateSalarie(sessionUser.getIdentifiant(), sexe, birthInf, birthSup, departement, naf,pcs)){
        		request.setAttribute(ATT_MSG_SUCCESS,"Profil mis à jour ");
        	}
        	else {
        		request.setAttribute(ATT_MSG_WARNING,"un problème a survenu.Veuillez réessayer plus tard.");
        	}
        	
    	}
    	try {
        	this.getServletContext().getRequestDispatcher("/salarie/index.jsp").forward(request, response);
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
