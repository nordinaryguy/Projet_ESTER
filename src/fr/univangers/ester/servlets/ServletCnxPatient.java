package fr.univangers.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univangers.ester.mongodb.Users;


@WebServlet("/ServletCnxPatient")
public class ServletCnxPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletCnxPatient() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/CnxPatient.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("codePatient");
		
		//verifier si le code exist dans l'une des table (C_CODE_GENERE ou C_SALARIE
		Users user=new Users();
		if(user.existCode(code)) {
			//page saisi formulaire
			request.setAttribute("codePatient",code);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/FormPatient.jsp").forward(request, response);
			
		}else if(user.existSalarie(code)) {
			//page acceuil patient
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/AcceuilSalarie.jsp").forward(request, response);
			
		}else {
			//page erreur
			request.setAttribute("codePatient",code);
			request.setAttribute("message", "Veuillez vérifier que le code saisi est bien celui communiqué par votre médecin");
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/CnxPatient.jsp").forward(request, response);
		}
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/CnxPatient.jsp").forward(request, response);
	}

}
