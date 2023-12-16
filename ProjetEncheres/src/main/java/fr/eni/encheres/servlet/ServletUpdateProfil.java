package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletUpdateProfil
 */
@WebServlet("/ServletUpdateProfil")
public class ServletUpdateProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/UpdateProfil.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Verifier que l'utilisateur est bien connecté
		HttpSession session = request.getSession();

		
		//Modification des informations
		try {
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("CP");
			String ville = request.getParameter("ville");
			//String password = request.getParameter("motDePasse");
			//String newPassword = request.getParameter("newMotDePasse");
			//String confirmation = request.getParameter("confirmationMotDePasse");

			Utilisateur connectedUser = (Utilisateur) session.getAttribute("ConnectedUser");
			
			connectedUser.setPseudo(pseudo);
			connectedUser.setNom(nom);
			connectedUser.setPrenom(prenom);
			connectedUser.setEmail(email);
			connectedUser.setTelephone(telephone);
			connectedUser.setRue(rue);
			connectedUser.setCodePostal(codePostal);
			connectedUser.setVille(ville);
			//connectedUser.setMotDePasse(password);
			

			
			
		//	if (password.equals(connectedUser.getMotDePasse()) && newPassword.equals(confirmation)) {
		//		connectedUser.setMotDePasse(newPassword); }
						
		//connectedUser = UtilisateurManager.update();
			UtilisateurManager.update(connectedUser);
			session.setAttribute("ConnectedUser", connectedUser);
			
			this.getServletContext().getRequestDispatcher("/jsp/MonProfil.jsp").forward(request, response);
		

		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}

}
