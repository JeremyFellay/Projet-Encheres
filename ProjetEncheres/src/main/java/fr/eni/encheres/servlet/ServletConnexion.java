package fr.eni.encheres.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

				//Redirige vers la jsp
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Connexion.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Initialisation des variables
		String email, password;
		String erreur = null;
		PrintWriter out = response.getWriter();
		Utilisateur u;
		HttpSession ses = request.getSession();
		//Récupération des données dans la BDD 
		email = request.getParameter("email");
		password = request.getParameter("password");
		u = UtilisateurManager.getInstance().login(email, password);

		try {

			u = UtilisateurManager.getInstance().SelectByEmail(email);
//Compare l'email et le mot de passe pour se connecter.
			if (u != null && password.equals(u.getMotDePasse())) {
				request.getSession().setAttribute("ConnectedUser", u);

				this.getServletContext().getRequestDispatcher("/jsp/AccueilConnecte.jsp").forward(request, response);
//Sinon affiche un message d'erreur.
			} else {
				request.setAttribute("erreur",
						"pseudo et/ou mot de passe incorrect(s)! Veuillez ressaisir vos identifiants...");
				erreur = (String) ses.getAttribute("erreur");
				out.println(erreur);

				this.getServletContext().getRequestDispatcher("/ServletConnexion").forward(request, response);

			}
//Affiche un message d'erreur si l'email et le pseudo ne correspondent pas.
		} catch (DALException e) {
			request.setAttribute("erreur",
					"email et/ou mot de passe incorrect(s)! Veuillez ressaisir vos identifiants...");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/Connexion.jsp");
			rd.forward(request, response);		
			
		}
	}
	
}

