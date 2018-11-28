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
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  ForgotPassword.TimeLimit delai;
	public static final String ATT_MSG_WARNING = "Warning";
    public static final String ATT_MSG_SUCCESS = "Success";
	
    public ForgotPassword() {
        super();
        delai=new TimeLimit(0,0,3,0);
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";
		request.setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ForgotPassword.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("Email");
		Users users=new Users();
		users.addDefautServer();
		Mail mailSender=new Mail();
		String path = request.getRequestURL().toString();
		path=path.substring(0, path.length()-"ForgotPassword".length());

		if(users.existUserEster(email)) {
			if(users.hasUrlToken(email))
				request.setAttribute(ATT_MSG_WARNING,"un mail valide vous a été déjà envoyé");
			else {
				//create urlToken and expireDate
				String token = UUID.randomUUID().toString();
				Date expireDate= delai.addTimeLimitToDate(new Date());
				//add urlToken to database
				users.addUrlToken(email, token, expireDate);
				//create url to be sent in email (protocol://host:port/path?query#ref)
				//TODO must be automaticaly changed
				URL urlToken=new URL(path+"ResetPassword?"+"token="+token);
				//send email
				boolean mailSend=mailSender.sendMail(email,"Demande de réinitialisation de mot de passe", mailSender.mdpOublieBodyText(urlToken.toString()), true);
				if(mailSend) {
					request.setAttribute(ATT_MSG_SUCCESS,"mail envoyé");
				}else {
					request.setAttribute(ATT_MSG_WARNING,"un problème a survenu.Veuillez réessayer plus tard.");
					//if message not sent delete token in database
					users.deleteUrlToken(email);
				}
			}
		}else {
			request.setAttribute(ATT_MSG_WARNING,"Email n'existe pas");
		}
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
