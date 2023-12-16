package fr.eni.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class ServletTestBll
 */
@WebServlet("/ServletTestBll")
public class ServletTestBll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTestBll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Création d'une nouvelle instance de la classe UtilisateurManager
		UtilisateurManager manager = new UtilisateurManager();
		try{
		//Appel la méthode insert afin d'insérer un nouvel utilisateur	
		manager.insert(new Utilisateur("BapLeDev","Duprat","Baptiste","bap@gmail.com","0606060606","7rue","64000","angers","test123",10,true));
		} catch (DALException e) {
		}
		
		try {
			System.out.println(manager.selectAll());
		} catch (DALException e) {
			e.printStackTrace();
		}}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
