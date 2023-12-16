<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
    <title>Modifier mon profil</title>
</head>
<body>
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

        <h2>Modifier mon profil</h2>
     
      <section>
        <form action="ServletUpdateProfil" method="post" class="modifprofil">
          <div class="form-columns">
            <div class="form-column">
              <label for="name">Pseudo </label>
              <input type="text" name="Pseudo" value="${ConnectedUser.pseudo}">
              
              <label for="name">Nom </label>
              <input type="text" name="Nom" value="${ConnectedUser.nom}">
              
              <label for="name">Prenom </label>
              <input type="text" name="prenom" value="${ConnectedUser.prenom}">
              
              <label for="name">Téléphone </label>
              <input type="text" name="telephone" value="${ConnectedUser.telephone}">

            </div>
            <div class="form-column">
              <label for="name">Email </label>
              <input type="email" name="email" value="${ConnectedUser.email}">

              <label for="name">Rue </label>
              <input type="text" name="rue" value="${ConnectedUser.rue}">

              <label for="name">Code Postal </label>
              <input type="text" name="codepostal" value="${ConnectedUser.codePostal}">
              
              <label for="name">Ville </label>
              <input type="text" name="Ville" value="${ConnectedUser.ville}">
            </div>
            </div>
          </form>
          <div class="btn-modif"> 
          <form action = "ServletMonProfil">
          <button class="btn-modifier"type="submit">Enregistrer</button> 
          </form>   
          </div> 
      </section>
      
</body>
</html>