package fr.eni.encheres.bll;

import java.util.List;
import java.util.regex.Pattern;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	private static UtilisateurDAO dao= DAOFactory.getUtilisateurDAO();
	private static UtilisateurManager instance;
	
	public void insert(Utilisateur utilisateur) throws DALException {
		dao.insert(utilisateur);
	}

public static void update(Utilisateur utilisateur) throws DALException {
		dao.update(utilisateur);
	}

 public List<Utilisateur> selectAll() throws DALException{
	 return dao.selectAll();
	 
 }
	
	public static void delete (Utilisateur utilisateur) throws DALException {
		dao.delete(utilisateur);
	}

	public static UtilisateurManager getInstance() {
		if(instance == null) {
			try {
				instance = new UtilisateurManager();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public Utilisateur login(String email, String motDePasse) {
		{
			return dao.login(email,motDePasse);
		}
	}

	public Utilisateur SelectByEmail(String email) throws DALException {
		return dao.selectByEmail(email);
	}

	public Utilisateur SelectById(Integer noUtilisateur) throws DALException {
		return dao.selectById(noUtilisateur);
	}


// VÉRIFICATION DU FORMAT DE L'EMAIL

public static boolean isEmailValid(String email) {
	String regex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
	return Pattern.matches(regex, email);
}

public static Utilisateur selectUserByPseudo(String pseudo) throws DALException {
	return dao.selectUserByPseudo(pseudo);

}
}

	
//	return dao.login(email,Utilisateur.hashPwd(motDePasse));

	
