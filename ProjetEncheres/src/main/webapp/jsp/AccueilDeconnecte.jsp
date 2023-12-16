<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Accueil</title>
</head>
 <header>
        <img class="logo-site-login" src="<%=request.getContextPath()%>/images/eni-encheres.svg"/>
    </header>
<body>
    
    <h1>ENI-Encheres</h1>
    
   <nav class="menu">
        <ul>
          <li><a href="/ProjetEncheres/ServletInscription">S'inscrire</a></li>
          <li><a href="/ProjetEncheres/ServletConnexion">Se connecter</a></li>
        </ul>
      </nav>
      
      <h2>Liste des encheres</h2>
      
       <div>
<h2>Filtres : </h2>
      <div> <i class="bi bi-search"> </i></div>
      <div> <input type="search" placeholder="Le nom de l'article contient" /></div>
      <div> <button class ="" type="button"> Rechercher </button> </div>
      
      <label for="">Catégorie :</label>

<select name="" id="">
  <option value="">--Choisir une catégorie--</option>
  <option value="">Informatique</option>
  <option value="">Ameublement</option>
  <option value="">Vêtement</option>
  <option value="">Sport&Loisirs</option>
</select>

    </div>
</body>
</html>