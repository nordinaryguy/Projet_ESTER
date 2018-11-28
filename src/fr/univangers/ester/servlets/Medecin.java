package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univangers.ester.mail.Mail;
import fr.univangers.ester.mdp.PwdGenerator;
import fr.univangers.ester.mongodb.Users;


@WebServlet("/Medecin")
public class Medecin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_MSG_WARNING = "Warning";
    public static final String ATT_MSG_SUCCESS = "Success";
	
    public Medecin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Medecin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("page").equals("createSalarie")) {
			String  code=PwdGenerator.generateCode();
			request.setAttribute("message",code );
			
			//ajout à la base
			Users user=new Users();
			user.addCodeGenrated(code);
		}
		if(request.getParameter("page").equals("createUser")) {
			String email=request.getParameter("email");
			String type=request.getParameter("typeCompte");
			String pass=PwdGenerator.generatePassword();
			Users user=new Users();
			user.addUserEster(email,"", "", email, pass,type);
			Mail mailSender=new Mail();
			boolean mailSend=mailSender.sendMail(email,"Mot de passe provisoire", mailSender.mdpProvisoireBodyText(pass,"http://localhost:8080/Projet_ESTER/connexion"), true);
			if(mailSend) {
				request.setAttribute(ATT_MSG_SUCCESS,"mail envoyé");
			}else {
				request.setAttribute(ATT_MSG_WARNING,"un problème a survenu.Veuillez réessayer plus tard.");
			}
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Medecin.jsp").forward(request, response);
	}

}
