PROJET DVDTHEQUE
=
Architecture
-
* bdd : fichier de creation et d'insertion
* lib : driver pour la Bdd
* src :
    * controller
    * models : objet + managers
        * managers : connexion + requetes Bdd
    * ressources : image/sons/css
    * tools : configuration / url des ressources
    * views   
    
    
Objet
-

* Film

| Methode        | Description | 
| ------------- |:-------------:| 
| getId():String      | id de la Bdd |
| getNom():String      | titre du film |
| getAnne():String    | l'annee du film|
| getNote():String |  la note du film sur 5 |
| getContent():String | description du film|     
| getContent(byte limit):String | description du film limitée |
| getImg():String |  l'urlImg|     
| getActeurs():ArrayList<Acteur> | liste d'objet Acteur |     
| getActeursToString():String |  liste d'acteurs concatener ave une virgule|     
| getGenres()ArrayList<Genre> | liste d'objet Genre |     
| getGenresToString():String | liste genre concatener avec une virgule|     
| getRealisateur():Realisateur | objet Realisateur|     
| getNationalite():Nationalite | obj Nationalite|

* Genre

| Methode        | Description | 
| ------------- |:-------------:| 
| getId():String      | id de la Bdd |
| getLibelle():String      | libelle du genre |

* Nationalite

| Methode        | Description | 
| ------------- |:-------------:| 
| getId():String      | id de la Bdd |
| getLibelle():String      | libelle du la nationalite |

* Acteur

| Methode        | Description | 
| ------------- |:-------------:| 
| getId():String      | id de la Bdd |
| getNom():String      | nom |
| getPrenom():String      | prenom |

* Realisateur
     
| Methode        | Description | 
| ------------- |:-------------:| 
| getId():String      | id de la Bdd |
| getNom():String      | nom |
| getPrenom():String      | prenom |