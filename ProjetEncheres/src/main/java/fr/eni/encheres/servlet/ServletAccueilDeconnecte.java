package fr.eni.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ServletAccueilDeconnecte
 */
@WebServlet("/ServletAccueilDeconnecte")
public class ServletAccueilDeconnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Récupérer la session
    HttpSession session = request.getSession(false);

    // Vérifier si la session existe
    if (session != null) {
    	 
    // Rediriger vers une page de confirmation de déconnexion ou la page d'accueil
    	response.sendRedirect(request.getContextPath() + "/jsp/AccueilDeconnecte.jsp");
    }
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
	}


}
  
    
