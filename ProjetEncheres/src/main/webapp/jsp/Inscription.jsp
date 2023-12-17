<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
<head>
 	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Inscription</title>
</head>
 <header>
       <%--  <img class="logo-site-login" src="<%=request.getContextPath()%>/images/eni-encheres.svg"/> --%>
    </header>
<body>
        

        <h2>Mon profil</h2>

        <form action="ServletInscription" method="post" class="modifprofil">
            <div class="form-columns">
            <div class="form-column">
             <label for="name">Pseudo </label>
              <input type="text" name="pseudo" required />
           
               <label for="name">Nom </label>
              <input type="text" name="nom" required />
              
              <label for="name">Prenom </label>
              <input type="text" name="prenom" required />
              
              <label for="name">Email </label>
              <input type="email" name="email" required />
             
             <label for="name">Téléphone </label>
              <input type="text" name="telephone" required />
              
              </div>
              
            <div class="form-column">
            
                 <label for="name">Rue </label>
              <input type="text" name="rue" required />
              
                <label for="name">Code Postal </label>
              <input type="text" name="CP" required />
              
              <label for="name">Ville </label>
              <input type="text" name="ville" required />
              
              <label for="password">Mot de passe: </label>
              <input type="password" name="password" required />
              
              <label for="name">Confirmation: </label>
              <input type="password" name="passwordC" required />
              </div>
              </div>

 			<button class="btn-creer"type="submit">Créer</button> 
 			<button class="btn-supprimer-inscription" type="submit">Annuler</button>
             <!--  <input type="submit" value="Créer" /> -->
             <!--  <input type="submit" value="Annuler" /> -->
            

</form>

</body>
</html>