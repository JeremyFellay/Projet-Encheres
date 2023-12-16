package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbc;

public class DAOFactory {
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbc();
	}
}
