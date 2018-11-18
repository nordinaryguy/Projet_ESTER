package com.ester.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ester.tests.Users;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/Test.jsp";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Users users = new Users();
		users.addEntreprise("id66", "AA", "mdp");
		users.addEntreprise("id55", "TT", "mdp");
		users.pushSalarieIntoEntreprise("id55", "id3");
		users.pushSalarieIntoEntreprise("id55", "id4");
		for(String salarie : users.getSalariesEntreprise("id55")) {
			System.out.println(salarie);
		}
		users.pullSalarieIntoEntreprise("id55","id4");
		users.changePasswordEntreprise("id55", "mpd2");
		for(String salarie : users.getSalariesEntreprise("id55")) {
			System.out.println(salarie);
		}
		System.out.println(users.connectEntreprise("id0", "mdp"));
		System.out.println(users.connectEntreprise("id0", "mdpf"));
		
		
		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
