package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univangers.ester.mongodb.ServerMailDB;
import fr.univangers.ester.mongodb.Users;


@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_MSG_WARNING = "Warning";
    public static final String ATT_MSG_SUCCESS = "Success";
    private  String email;
       
   
    public ResetPassword() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get token 
		String token=request.getParameter("token");
		//check if valid
		Users users=new Users();
		ServerMailDB serverMailDB = new ServerMailDB();
		serverMailDB.addDefautServer();
		boolean valid=users.existUrlToken(token) && users.valideUrlToken(token);
		//get email and set attribute if valid token
		email=users.getIdentforToken(token);
		if(valid) {
			request.setAttribute("email", email);
		}
		users.deleteUrlToken(email);
		request.setAttribute("valid", valid);
		try {
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ResetPassword.jsp").forward(request, response);
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
		//change mot de passe
		Users users=new Users();
		String pwd=request.getParameter("password");		
		if(	users.changePasswordUserEster(email, pwd)) {
			request.setAttribute(ATT_MSG_SUCCESS,"Mot de passe modifié");
		}else {
			request.setAttribute(ATT_MSG_WARNING,"un problème a survenu.Veuillez réessayer plus tard.");
		}
		request.setAttribute("valid", true);
		request.setAttribute("email", email);
		try {
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ResetPassword.jsp").forward(request, response);
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
