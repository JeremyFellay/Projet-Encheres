<%@ page import ="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
  <!DOCTYPE html>
<html lang="fr">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mon Profil</title>
</head>
<body class="monprofil">
  <header>
        <img class="logo-site" src="<%=request.getContextPath()%>/images/eni-encheres.svg"/>
    <nav class="menuconnecte">
      <ul>
        <li><a href="">Encheres</a></li>
        <li><a href="">Vendre un article</a></li>
        <li><a href="ServletMonProfil">Mon profil</a></li>
        <li><a href="ServletDeconnexion">Déconnexion</a></li>
      </ul>
    </nav>
  </header>

      <h2 class="titrepageprofil">Mon Profil</h2>
  
      <section>
        <form class="modifprofil">
          <div class="form-columns">
            <div class="form-column">
              <label for="Pseudo">Pseudo </label>
              <input type="text" name="Pseudo" value="${ConnectedUser.pseudo}" readonly/>
              
              <label for="Nom">Nom </label>
              <input type="text" name="Nom" value="${ConnectedUser.nom}" readonly/>
              
              <label for="prenom">Prenom </label>
              <input type="text" name="prenom" value="${ConnectedUser.prenom}" readonly/>
              
              <label for="telephone">Téléphone </label>
              <input type="text" name="telephone" value="${ConnectedUser.telephone}"readonly/>

            </div>
            <div class="form-column">
              <label for="email">Email </label>
              <input type="email" name="email" value="${ConnectedUser.email}" readonly/>

              <label for="rue">Rue </label>
              <input type="text" name="rue" value="${ConnectedUser.rue}" readonly/>

              <label for="CP">Code Postal </label>
              <input type="text" name="codepostal" value="${ConnectedUser.codePostal}" readonly/>
              
              <label for="ville">Ville </label>
              <input type="text" name="Ville" value="${ConnectedUser.ville}" readonly/>
            </div>
          </div>
        </form>
      </section>
        
  
  <div class="btn-modif"> 
  <form action="ServletUpdateProfil">
        <button class="btn-modifier" type="submit">Modifier</button>
    </form>

    <form action="ServletSupprimerProfil">
      <button class="btn-supprimer" type="submit">Supprimer</button>
    </form>
  </div> 
</body>

</html>