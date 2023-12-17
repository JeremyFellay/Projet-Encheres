<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ENI Encheres - Accueil</title>
    
<!-- Bootstrap Font Icon CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
 <header>
        <img class="logo-site-login" src="<%=request.getContextPath()%>/images/eni-encheres.svg"/>
    </header>
<body>
    
    <h1>ENI-Encheres</h1>
 
    
<nav class="menu">
        <ul>
          <li><a href="encheres.html">Encheres</a></li>
          <li><a href="vente.html">Vendre un article</a></li>
          <li><a href="/ProjetEncheres/ServletMonProfil">Mon profil</a></li>
          <li><a href="/ProjetEncheres/ServletDeconnexion">Déconnexion</a></li>
        </ul>
      </nav> 
      
      <h2>Liste des encheres</h2>
      
       <div>
<h2>Filtres :</h2>
      <div> <i class="bi bi-search"> </i></div>
      <div> <input type="search" placeholder="Le nom de l'article contient" /></div>
      <div> <button class ="" type="button"> Rechercher </button> </div>
      
      <label for="">Catégorie :</label>

<select name="" id="">
  <option value="">Toutes</option>
  <option value="">Informatique</option>
  <option value="">Ameublement</option>
  <option value="">Vêtement</option>
  <option value="">Sport & Loisirs</option>
</select>

<div>
  <input class="" type="checkbox" checked="checked"> encheres ouvertes
  <input class="" type="checkbox" checked="checked"> mes encheres en cours
  <input class="" type="checkbox" checked="checked"> mes encheres remportées
</div>

<div>
  <input class="" type="checkbox" checked="checked"> mes ventes en cours
  <input class="" type="checkbox" checked="checked"> ventes non débutées
  <input class="" type="checkbox" checked="checked"> ventes terminées
</div>

    </div>
</body>
</html>