<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription</title>
</head>
 <header>
        <img class="logo-site-login" src="<%=request.getContextPath()%>/images/eni-encheres.svg"/>
    </header>
<body>
        <h1> ENI-Encheres</h1>

        <h2>Mon profil</h2>

        <form action="ServletInscription" method="post" class="">
            <div class="">
              <label for="name">Pseudo: </label>
              <input type="text" name="pseudo" id="pseudo" required />
            </div>
            <div class="">
                <label for="name">Nom: </label>
                <input type="text" name="nom" id="nom" required />
              </div>
              <div class="">
                <label for="name">Prénom: </label>
                <input type="text" name="prenom" id="prenom" required />
              </div>
              <div class="">
                <label for="name">Email: </label>
                <input type="email" name="email" id="email" required />
              </div>
              <div class="">
                <label for="name">Téléphone: </label>
                <input type="tel" name="telephone" id="telephone" required />
              </div>
              <div class="">
                <label for="name">Rue: </label>
                <input type="text" name="rue" id="rue" required />
              </div>
              <div class="">
                <label for="name">Code postal: </label>
                <input type="text" name="CP" id="CP" required />
              </div>
              <div class="">
                <label for="name">Ville: </label>
                <input type="text" name="ville" id="ville" required />
              </div>
            <div class="">
              <label for="password">Mot de passe: </label>
              <input type="password" name="password" id="password" required />
            </div>
            <div class="">
                <div class="">
                    <label for="name">Confirmation: </label>
                    <input type="password" name="passwordC" id="passwordC" required />
                  </div>

              <input type="submit" value="Créer" />
              <input type="submit" value="Annuler" />
            </div>

</form>

</body>
</html>