package fr.eni.encheres.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
		
	
	public void insert (Utilisateur utilisateur) throws DALException;
	public void delete (Utilisateur utilisateur) throws DALException;
	public void update (Utilisateur utilisateur) throws DALException;
	public List<Utilisateur> selectAll() throws DALException;
	public Utilisateur login(String email, String motDePasse);
	public Utilisateur selectByEmail(String email) throws DALException;
	public Utilisateur selectById(Integer noUtilisateur) throws DALException;
	public Optional<Utilisateur> findByPseudoAndMotDePasse(String pseudo, String motDePasse);
	public Utilisateur selectUserByPseudo (String pseudo) throws DALException;
	
}