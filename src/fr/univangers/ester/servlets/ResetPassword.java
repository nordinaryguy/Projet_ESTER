package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univangers.ester.mongodb.Users;


@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ResetPassword() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get token 
		String token=request.getParameter("token");
		//check if valid
		Users users=new Users();
		if(users.existUrlToken(token) && users.valideUrlToken(token)) {
			//get email and set attribute
			String email=users.getIdentforToken(token);
			request.setAttribute("email", email);
			try {
				request.setAttribute("valid", true);
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
		}else {
			try {
				request.setAttribute("valid",false);
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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//change mot de passe
		Users users=new Users();
		String pwd=request.getParameter("password");
		String identifiant=request.getParameter("email");
		users.changePasswordUserEster(identifiant, pwd);
		users.deleteUrlToken(identifiant);
		request.setAttribute("message", "Mot de passe modifié");
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
