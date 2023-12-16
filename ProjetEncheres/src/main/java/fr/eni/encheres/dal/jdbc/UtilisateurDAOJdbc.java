package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbc implements UtilisateurDAO {

// Préparer les requetes SQL parametrées afin d'insérer des données dans une BDD
	private static final String INSERT = "insert into utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETE = "delete from utilisateurs where no_utilisateur=?";
	private static final String UPDATE = "update utilisateurs set pseudo =?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=? where no_utilisateur=?";
	private static final String SELECTALL = "select * from utilisateurs";
	private static final String SELECTBYID = "select * from utilisateurs where no_utilisateur=?";
	private static final String SELECTBYEMAIL = "select * from utilisateurs where email=?";
	private static final String SELECTUSERBYPSEUDO = "select * from utilisateurs where pseudo=?";


//=======================================================================//
	//
	// 								INSERT
	//
	// =======================================================================//

 //Mise en place de la methode création d'un utilisateur 
	@Override
	public void insert(Utilisateur utilisateur) throws DALException {
		try (Connection con = ConnectionProvider.getConnection();
				//Préparer une requete SQL d'insertion et spécifie de retourner les clés générées
				PreparedStatement rqt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);) {
					//Définir les valeurs des différents paramètres et renvoyer les valeurs
			rqt.setString(1, utilisateur.getPseudo());
			rqt.setString(2, utilisateur.getNom());
			rqt.setString(3, utilisateur.getPrenom());
			rqt.setString(4, utilisateur.getEmail());
			rqt.setString(5, utilisateur.getTelephone());
			rqt.setString(6, utilisateur.getRue());
			rqt.setString(7, utilisateur.getCodePostal());
			rqt.setString(8, utilisateur.getVille());
			rqt.setString(9, utilisateur.getMotDePasse());
			rqt.setInt(10, utilisateur.getCredit());
			rqt.setBoolean(11, utilisateur.setAdministrateur());

		//Execute la requete SQL et stock le nombre de ligne dans la variable nbRows
			int nbRows = rqt.executeUpdate();
		// Vérifie si une seule ligne a été affectée par la requete et récupere les clés générées
			if (nbRows == 1) {
				try (ResultSet rs = rqt.getGeneratedKeys();) {
					if (rs.next()) {
						//Affecte à l'attribut noUtilisateur la valeur récupérée par le ResultSet
						utilisateur.setNoUtilisateur(rs.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new DALException("Insert utilisateur failed -" + utilisateur, e);
		}
		return;
	}

//=======================================================================//
	//
	// 								DELETE
	//
	// =======================================================================//


 //Mise en place de la methode de suppression d'un utilisateur 

	public void delete(Utilisateur utilisateur) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
				PreparedStatement rqt = con.prepareStatement(DELETE);
				rqt.setInt(1, utilisateur.getNoUtilisateur());
				
				}catch (Exception e) {
						e.printStackTrace();
						throw new DALException("Delete utilisateur failed -" + utilisateur, e);
			}
		}

//=======================================================================//
	//
	// 								UPDATE
	//
	// =======================================================================//


 //Mise en place de la methode de mise à jour d'un utilisateur 

	@Override
	public void update(Utilisateur utilisateur) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
				PreparedStatement rqt = con.prepareStatement(UPDATE);
					rqt.setString(1, utilisateur.getPseudo());
					rqt.setString(2, utilisateur.getNom());
					rqt.setString(3, utilisateur.getPrenom());
					rqt.setString(4, utilisateur.getEmail());
					rqt.setString(5, utilisateur.getTelephone());
					rqt.setString(6, utilisateur.getRue());
					rqt.setString(7, utilisateur.getCodePostal());
					rqt.setString(8, utilisateur.getVille());
					rqt.setInt(9, utilisateur.getNoUtilisateur());
					
					rqt.executeUpdate();
					
					}catch (Exception e) {
						e.printStackTrace();
						throw new DALException("Update utilisateur failed -" + utilisateur, e);
			}
		}

//=======================================================================//
	//
	// 								SELECTALL
	//
	// =======================================================================//


 //Mise en place de la methode de sélection de la liste des utilisateurs

	@Override
	public List<Utilisateur> selectAll() throws DALException {
		List<Utilisateur> utilisateur = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()) {
				PreparedStatement rqt = con.prepareStatement(SELECTALL);
				
				ResultSet rs = rqt.executeQuery();
				
				while (rs.next()) {
					
					Utilisateur currentUtilisateur = new Utilisateur();
					utilisateur.add(currentUtilisateur);
				}
					}catch (Exception e) {
						e.printStackTrace();
						throw new DALException("SelectAll utilisateur failed -" + utilisateur, e);
				}
					return utilisateur;
			}



	
	//=======================================================================//
		//
		// 								LOGIN
		//
		// =======================================================================//
	

	// //Mise en place de la methode de connexion d'un utilisateur 

	@Override
	public Utilisateur login(String email, String motDePasse) {
			Utilisateur utilisateur=null;
			try
				(Connection con = ConnectionProvider.getConnection()){
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM utilisateurs where email=? and mot_de_passe=?");
				pstmt.setString(1,email);
				pstmt.setString(2,motDePasse);
				ResultSet res = pstmt.executeQuery();
				if(res.next())
				{
					utilisateur= new Utilisateur();
					utilisateur.setNom(res.getString("nom"));
					utilisateur.setPrenom(res.getString("prenom"));
					utilisateur.setEmail(res.getString("email"));
					utilisateur.setMotDePasse(res.getString("mot_de_passe"));
					utilisateur.setNoUtilisateur(res.getInt("no_utilisateur"));
	 
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return utilisateur; 
	}
	
	//=======================================================================//
		//
		// 								SELECTBYEMAIL
		//
		// =======================================================================//
		

		 //Mise en place de la methode de selection via l'email  

	public Utilisateur selectByEmail(String email) throws DALException {
		Utilisateur utilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(SELECTBYEMAIL);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));

			} else {
				throw new DALException("Aucun utilisateur trouvé avec l'email " + email);
			}
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la récupération de l'utilisateur par email", e);
		}
		return utilisateur;
	}
	
	// VÉRIFICATION DU FORMAT DE L'EMAIL
	
	public static boolean isEmailValid(String email) {
		String regex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
		return Pattern.matches(regex, email);
	}

	@Override
	public Optional<Utilisateur> findByPseudoAndMotDePasse(String pseudo, String motDePasse) {
		return Optional.empty();
	}
	
	//=======================================================================//
		//
		// 								SELECTBYID
		//
		// =======================================================================//
	

	 //Mise en place de la methode de selection via le numero d'utilisateur 

	public Utilisateur selectById(Integer noUtilisateur) throws DALException {
		Utilisateur utilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(SELECTBYID);
			pst.setInt(1, noUtilisateur);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));

			} else {
				throw new DALException("Aucun utilisateur trouvé avec le numéro d'utilisateur " + noUtilisateur);
			}
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la récupération de l'utilisateur par id", e);
		}
		return utilisateur;
	}

	//=======================================================================//
		//
		// 								SELECTUSERBYPSEUDO
		//
		// =======================================================================//
	
	
	 //Mise en place de la methode de selection via le pseudo de l'utilisateur 

@Override
	public Utilisateur selectUserByPseudo(String pseudo) throws DALException {
		Utilisateur utilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(SELECTUSERBYPSEUDO);
			pst.setString(1, pseudo);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));

			} else {
				throw new DALException("Aucun utilisateur trouvé avec le pseudo " + pseudo);
			}
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la récupération de l'utilisateur par pseudo", e);
		}
		return utilisateur;
	}
		
}

		

