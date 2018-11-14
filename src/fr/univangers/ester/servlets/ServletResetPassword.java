package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univangers.ester.mongodb.Users;


@WebServlet("/ServletResetPassword")
public class ServletResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletResetPassword() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get token 
		String token=request.getParameter("token");
		//check if valid
		Users users=new Users();
		if(users.existUrlToken(token) && users.valideUrlToken(token)) {
			//get email and set attribute
			String email=users.getIdentforToken(token);
			request.setAttribute("email", email);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ResetPassword.jsp").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ErrorUnvalid.jsp").forward(request, response);
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//change mot de passe
		Users users=new Users();
		String pwd=request.getParameter("password");
		String identifiant=request.getParameter("email");
		users.changePasswordUserEster(identifiant, pwd);
		request.setAttribute("message", "Mot de passe modifié");
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ResetPassword.jsp").forward(request, response);
	}

}
