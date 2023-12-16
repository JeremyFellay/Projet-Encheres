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
 * Servlet implementation class ServletMonProfil
 */
@WebServlet("/ServletMonProfil")
public class ServletMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Récuperation de la session
		HttpSession session = request.getSession();
		Utilisateur connectedUser = (Utilisateur) session.getAttribute("ConnectedUser");
		//Récupération des informations relatives au pseudo connecté 		
		String pseudo = connectedUser.getPseudo();
		// Initialisation de la variable userAffiche avec une valeur null
		Utilisateur userAffiche = null;
		
		
		try {
			userAffiche = UtilisateurManager.selectUserByPseudo(pseudo);
						
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		if (userAffiche != null && connectedUser != null) {
		
			// Liaison avec la JSP	
			request.setAttribute("utilisateur", userAffiche);
			//Rediriger la requete vers la JSP
			this.getServletContext().getRequestDispatcher("/jsp/MonProfil.jsp").forward(request, response);	
			//
			
		} 
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
		
		
	}

}
