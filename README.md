# Travaux pratiques Spring Boot: API

Aujourd'hui, nous allons créer une API prête à être utilisée par une application client tierce

# Partie 1: API

## 1. Création d'une nouvelle entité

Sur le modèle de l'entité Product fournie, créer une nouvelle entité Brand représentant les marques des produits. Ne pas oublier le _repository_ et le contrôleur qui vont avec.

## 2. Accéder aux entités associées

Lorsque nous avons un objet produit, plutôt que de manipuler sa propriété **brandId**, nous aimerions pouvoir disposer d'une méthode **getBrand** qui nous renverrait directement l'objet de type Brand correspondant. De la même façon, nous aimerions avoir, dans la classe **Brand**, une méthode **getProducts** qui nous revnoie la liste de tous les produits correspondant à cette marque. Chercher dans la documentation de Spring Boot comment l'on pourrait réaliser cette fonctionnalité.

## BONUS: Toutes les entités

Créer les autres entités du MCD et coder les relations entre chacune d'entre elles.

## BONUS 2: Factoriser les entités

Trouver un moyen d'avoir un seul modèle d'entité/_repository_/contrôleur que l'on puisse décliner au lieu de copier/coller le même code en changeant simplement les noms des classes.

# Partie 2: Client

Créer une nouvelle application React capable d'afficher un produit, de créer un nouveau produit, de mettre à jour un produit existant, et de supprimer un produit.

Pour que cela fonctionne, il faudra lancer **à la fois** un serveur local pour l'application React, et un serveur local pour l'application Spring.

## Afficher un produit

Créer un composant Container qui va envoyer une requête AJAX au serveur de l'API pour récupérer les données d'un produit en particulier. Ensuite, créer un composant présentationnel Product qui permette d'afficher les propriétés de ce produit.

Rappel des concepts nécessaires à cette fonctionnalité:

- **Requête asynchrone**: JavaScript continue à s'exécuter même si la requête n'a pas encore été résolue. Il faut donc déléguer à la requête la responsabilité de gérer la réponse de l'API.
- **State**: au départ, les données du produit sont vides. Elles se complètenet seulement au moment où la requête est résolue. Il faut donc avoir un composant avec un _state_.

## Afficher la liste de tous les produits

En s'inspirant de la fonctionnalité précédente, créer un nouveau composant qui permet d'afficher la liste de tous les produits.

## Créer un produit

Créer un formulaire dans un composant ProductForm qui permette de rentrer les propriétés d'un nouvel objet Product, et qui les envoie à l'API.

Rappel des concepts nécessaires à cette fonctionnalité:

- **Two-way binding**: le _state_ du composant représentant le formulaire doit contenir des propriétés qui se synchronisent automatiquement avec les valeurs des champs. Autrement dit, si je modifie un champ du formulaire, ça doit modifier une propriété du _state_, et si je modifie une propriété du _state_, ça doit modifier un champ du formulaire.
- **Event handlers**: lorsqu'on appuie sur le bouton "valider" du formulaire, cela doit déclencher une fonction que nous avons écrite nous-mêmes.
- **event.preventDefault()**: lorsqu'on appuie sur le bouton "valider", cela ne doit pas déclencher le rechargement de la page, qui est son comportement normal.

## Modifier un produit

Combiner les deux fonctionnalités précédentes pour obtenir un formulaire qui se remplit automatiquement avec les données d'un produit particulier, et qui permette d'envoyer à l'API une version modifiée.

### BONUS

Factoriser les formulaires de création et de modification de produit.

## Supprimer un produit

Le plus facile pour la fin: dans la liste des produits, rajouter en face de chaque produit un bouton qui permette d'envoyer à l'API une requête de suppression.
