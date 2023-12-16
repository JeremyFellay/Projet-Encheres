package fr.eni.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class ServletSupprimerProfil
 */
@WebServlet("/ServletSupprimerProfil")
public class ServletSupprimerProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récuperation de la session
		HttpSession session = request.getSession();
		//Récuperer un attribut noUtilisateur depuis la session
		Utilisateur noUtilisateur = (Utilisateur) session.getAttribute("noUtilisateur");
		try {
			//Utilisation de la fonction delete en faisant appel à UtilisateurManager
			UtilisateurManager.delete(noUtilisateur);
		} catch (DALException e) {
			e.printStackTrace();
		}
			//Rediriger la requete vers la JSP
		request.getRequestDispatcher("/jsp/SupprimerProfil.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
