package fr.univangers.ester.servlets;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univangers.ester.mail.Mail;
import fr.univangers.ester.mongodb.Users;

@WebServlet("/ForgotPassword")
public class ServletForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  ServletForgotPassword.TimeLimit delai;
	
    public ServletForgotPassword() {
        super();
        delai=new TimeLimit(0,0,3,0);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user=new Users();
		user.addUserEster("mail", "nom", "prenom", "mail", "", null);
		String message="";
		request.setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ForgotPassword.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("Email");
		String message="l'adresse email saisi n'est pas valide";
		Users users=new Users();
		if(users.existUserEster(email)) {
			Mail mail = new Mail("sender","mdp",email,"smtp.gmail.com","587");
			//create urlToken and expireDate
			String token = UUID.randomUUID().toString();
			Date expireDate= delai.addTimeLimitToDate(new Date());
			//add urlToken to database
			users.addUrlToken(email, token, expireDate);
			//create url to be sent in email (protocol://host:port/path?query#ref)
			URL urlToken=new URL("http://localhost:8080/Projet_ESTER/resetpassword?"+"token="+token);
			//send email
			boolean mailSend=mail.sendMail("Demande de réinitialisation de mot de passe", mail.mdpOublieBodyText("", urlToken.toString()), true);
			if(mailSend) {
				message="mail envoyé";
			}else {
				message="un problème a survenu.Veuillez réessayer plus tard.";
				//if message not sent delete token in database
				users.deleteUrlToken(email);
			}
			
		}else {
			message="Email n'existe pas";
		}
		request.setAttribute("email", email);
		request.setAttribute("message", message);
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ForgotPassword.jsp").forward(request, response);
	}
	
	public class TimeLimit{
		int nbJours;
		int nbHeures;
		int nbMinutes;
		int nbSecondes;
		
		public TimeLimit(int nbJours,int nbHeures,int nbMinutes,int nbSecondes) {
			this.nbJours=nbJours;
			this.nbHeures=nbHeures;
			this.nbMinutes=nbMinutes;
			this.nbSecondes=nbSecondes;
		}
		
		public Date addTimeLimitToDate(Date date) {
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    calendar.add(Calendar.DATE, this.nbJours);
		    calendar.add(Calendar.HOUR_OF_DAY, this.nbHeures);
		    calendar.add(Calendar.MINUTE, this.nbMinutes);
		    calendar.add(Calendar.SECOND, this.nbSecondes);
		    return calendar.getTime();
		}
		
	}

}
