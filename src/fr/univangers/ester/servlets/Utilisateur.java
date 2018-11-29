package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.univangers.ester.beans.User;
import fr.univangers.ester.beans.Utilisateur.Status;
import fr.univangers.ester.mail.Mail;
import fr.univangers.ester.mdp.PwdGenerator;
import fr.univangers.ester.mongodb.Users;


@WebServlet("/utilisateur")

public class Utilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_MSG_WARNING = "Warning";
    public static final String ATT_MSG_SUCCESS = "Success";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    
    public Utilisateur() {
    	super();
    }
   
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	User sessionUser = (User) session.getAttribute(ATT_SESSION_USER);
        if (sessionUser != null && sessionUser.isUtilisateur()) {
        	 if (sessionUser.isAdministrateur()) {
					if(request.getParameter("page") != null && request.getParameter("page").equals("configurationServeurMail")) {
						Users user=new Users();
						user.addDefautServer();
						request.setAttribute("email",user.getServerMail() );
						request.setAttribute("pass",user.getServerMailPass());
						request.setAttribute("host", user.getServerHost());
						request.setAttribute("port", user.getServerPort());
					}
        	 }			
         } 
		this.getServletContext().getRequestDispatcher("/utilisateur/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
   	 	User sessionUser = (User) session.getAttribute(ATT_SESSION_USER);
        if (sessionUser != null && sessionUser.isUtilisateur()) {
        	Users user=new Users();
    		user.addDefautServer();        
        	if (sessionUser.isAdministrateur()) {

				if(request.getParameter("page").equals("configurationServeurMail")) {
					request.setAttribute("Success", "Serveur mail modifié");
					user.addServerMail(request.getParameter("emailSender"), request.getParameter("password"),request.getParameter("host"),request.getParameter("port"));
				}
			}
        	
        	if (sessionUser.isMedecin()||sessionUser.isAdministrateur()||sessionUser.isPreventeur()) {
        		if(request.getParameter("page").equals("createSalarie")) {
        			String  code=PwdGenerator.generateCode();
        			request.setAttribute("message",code );
        			//ajout à la base
        			user.addCodeGenrated(code);
        		}
        	}
        	
            if (sessionUser.isMedecin()||sessionUser.isAdministrateur()) {
            	String forPath;
            	if (sessionUser.isMedecin()) {
            		forPath="Medecin";
            	}
            	else {
            		forPath="Administrateur";
            	}
            	

        		if(request.getParameter("page").equals("createUser")) {
        			String email=request.getParameter("email");
        			String type=request.getParameter("typeCompte");
        			String pass=PwdGenerator.generatePassword();
        			String path = request.getRequestURL().toString();
        			path=path.substring(0, path.length()-forPath.length());
        			user.addUserEster(email,"", "", email, pass,Status.toStatus(type));
        			Mail mailSender=new Mail();
        			boolean mailSend=mailSender.sendMail(email,"Mot de passe provisoire", mailSender.mdpProvisoireBodyText(pass,path+"connexion"), true);
        			if(mailSend) {
        				request.setAttribute(ATT_MSG_SUCCESS,"mail envoyé");
        			}
        			else {
        				request.setAttribute(ATT_MSG_WARNING,"un problème a survenu.Veuillez réessayer plus tard.");
        				}
        		}
        	}
        }
		this.getServletContext().getRequestDispatcher("/utilisateur/index.jsp").forward(request, response);
	}
}

