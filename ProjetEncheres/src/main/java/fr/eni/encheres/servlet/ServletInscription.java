package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Déclaration d'une variable u de type Utilisateur
		Utilisateur u;
		//Récupérer les valeurs associées aux clés 
		u = new Utilisateur(request.getParameter("pseudo"),
				request.getParameter("nom"),
				request.getParameter("prenom"),
				request.getParameter("email"),
				request.getParameter("telephone"),
				request.getParameter("rue"),
				request.getParameter("CP"),
				request.getParameter("ville"),
				request.getParameter("password"));
				
		try {
			UtilisateurManager.getInstance().insert(u);
		} catch (DALException e) {
			e.printStackTrace();
		}
	this.getServletContext().getRequestDispatcher("/jsp/Connexion.jsp").forward(request, response);
	
	}

}
