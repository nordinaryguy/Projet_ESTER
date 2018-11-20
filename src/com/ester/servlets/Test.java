package com.ester.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ester.beans.Entreprise;
import com.ester.beans.EsterUser;
import com.ester.beans.Questionnaire;
import com.ester.beans.Salarie;
import com.ester.dao.EsterUserDAO;
import com.ester.dao.SalarieDAO;
import com.ester.tests.Users;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/Test.jsp";

	//Objets DAO
	private EsterUserDAO eudao;
	private SalarieDAO sdao;

	public void init() throws ServletException{
		com.ester.dao.DAOFactory daoFactory = com.ester.dao.DAOFactory.getInstance();
		this.eudao = daoFactory.getUserEsterDao();
		this.sdao = daoFactory.getSalarieDao();
	}

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

		/*Users users = new Users();
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
		ArrayList<String> rights = new ArrayList<>();
		rights.add("r");
		rights.add("w");
		EsterUser eu = new EsterUser("pLastName", "pFirstName", "pIdCountGeneration", "pMail", "pPassword", "pUserRole",  rights);
		eudao.addUserEster(eu);
		 */

		//Test création d'un salarié en base :
		Salarie s = new Salarie("pSecureIdGenerated", "pSexe", "pYearOfbirth", "pDepartment", "pPCS");
		s.setmAttachedCompany(new Entreprise("E1"));
		Questionnaire q1 = new Questionnaire("Q1");
		Questionnaire q2 = new Questionnaire("Q2");

		ArrayList<Questionnaire> listQ = new ArrayList<>();
		listQ.add(q1);
		listQ.add(q2);
		s.setmUnansweredQuestionnaires(listQ);

		sdao.addSalarie(s);

		//Récupération d'un salarié depuis son id unique
		Salarie s1 = new Salarie();
		s1 = sdao.getSalarie("pSecureIdGenerated");
		System.out.println(s1.toString());

		//Modification d'un salarié
		s1.setmSexe("Femme");
		s1.setmPCS("NewPCS");
		sdao.updateSalarie(s1, "pSecureIdGenerated");
		System.out.println(s1.toString());

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
