#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Database: Dvdtheque
#------------------------------------------------------------

DROP DATABASE IF EXISTS Dvdtheque;

CREATE DATABASE Dvdtheque;

USE Dvdtheque;

#------------------------------------------------------------
# Table: Nationalite
#------------------------------------------------------------

CREATE TABLE Nationalite(
        Id_Nationalite   Int  Auto_increment  NOT NULL ,
        Libelle_Nationalite Varchar (200) NOT NULL
	,CONSTRAINT Nationalite_PK PRIMARY KEY (Id_Nationalite)
)ENGINE=InnoDB,CHARACTER SET utf8;

#------------------------------------------------------------
# Table: Realisateur
#------------------------------------------------------------

CREATE TABLE Realisateur(
        Id_Realisateur   Int  Auto_increment  NOT NULL ,
        Nom_Realisateur Varchar (200) NOT NULL,
        Prenom_Realisateur Varchar (200) NOT NULL
	,CONSTRAINT Realisateur_PK PRIMARY KEY (Id_Realisateur)
)ENGINE=InnoDB,CHARACTER SET utf8;


#------------------------------------------------------------
# Table: Film
#------------------------------------------------------------

CREATE TABLE Film(
        Id_Film         Int  Auto_increment  NOT NULL ,
        Nom_Film      Varchar (200) NOT NULL ,
        Annee_Film       Int NOT NULL ,
        Note_Film     Int NOT NULL ,
        Content_Film     Text NOT NULL ,
        Img_Film    Varchar (100) NOT NULL,
        Realisateur_id INT,
        Nationalite_id INT
	,CONSTRAINT Film_PK PRIMARY KEY (Id_Film)
	,CONSTRAINT Realisateur_PK FOREIGN KEY (Realisateur_id) REFERENCES Realisateur(Id_Realisateur)
	,CONSTRAINT Nationalite_PK FOREIGN KEY (Nationalite_id) REFERENCES Nationalite(Id_Nationalite)
)ENGINE=InnoDB,CHARACTER SET utf8;

#------------------------------------------------------------
# Table: Acteur
#------------------------------------------------------------

CREATE TABLE Acteur(
        Id_Acteur   Int  Auto_increment  NOT NULL ,
        Nom_Acteur Varchar (200) NOT NULL,
        Prenom_Acteur Varchar (200) NOT NULL
	,CONSTRAINT Acteur_PK PRIMARY KEY (Id_Acteur)
)ENGINE=InnoDB,CHARACTER SET utf8;

#------------------------------------------------------------
# Table: Film_Genre
#------------------------------------------------------------

CREATE TABLE Film_Acteur(
        Film_id INT(100),
        Acteur_id INT(100),
	CONSTRAINT Film_PK FOREIGN KEY (Film_id) REFERENCES Film(Id_Film)
	,CONSTRAINT Acteur_PK FOREIGN KEY (Acteur_id) REFERENCES Acteur(Id_Acteur)
)ENGINE=InnoDB,CHARACTER SET utf8;

#------------------------------------------------------------
# Table: Genre
#------------------------------------------------------------

CREATE TABLE Genre(
        Id_Genre   Int  Auto_increment  NOT NULL ,
        Libelle_Genre Varchar (200) NOT NULL
	,CONSTRAINT Genre_PK PRIMARY KEY (Id_Genre)
)ENGINE=InnoDB,CHARACTER SET utf8;

#------------------------------------------------------------
# Table: Film_Genre
#------------------------------------------------------------

CREATE TABLE Film_Genre(
        Film_id INT(100),
        Genre_id INT(100),
	CONSTRAINT Film_Genre_GenreId_Pk FOREIGN KEY (Genre_id) REFERENCES Genre(Id_Genre)
	,CONSTRAINT Film_Genre_FilmId_Pk FOREIGN KEY (Film_id) REFERENCES Film(Id_Film)
)ENGINE=InnoDB,CHARACTER SET utf8;

#------------------------------------------------------------
#        Script MySQL. Injection
#------------------------------------------------------------

#------------------------------------------------------------
# Injection Table: Nationalite
#------------------------------------------------------------

INSERT INTO Nationalite VALUES
        (NULL,"americain"),
        (NULL,'hongkongais'),
        (NULL,"coréen");

#------------------------------------------------------------
# Injection Table: Genre
#------------------------------------------------------------

INSERT INTO Genre VALUES
        (NULL,"Science-Fiction"),
        (NULL,"Aventure"),
        (NULL,"Action"),
        (NULL,"Drame"),
        (NULL,"Horreur");

#------------------------------------------------------------
# Injection Table: Acteur
#------------------------------------------------------------

INSERT INTO Acteur VALUES
        (NULL,"Harrison", "Richard"),
        (NULL,"Abbot", "Mike"),
        (NULL,"Neill", "Sam"),
        (NULL,"Attenborough", "Richard"),
        (NULL,"Goldblum","Jeff"),
        (NULL,"Yoo","Gong"),
        (NULL,"Dong-seok","Ma"),
        (NULL,"Yu-mi","Jung "),
        (NULL,"Watts","Naomi"),
        (NULL,"Black","Jack"),
        (NULL,"Brody","Adrienw"),
        (NULL,"Scheider","Roy"),
        (NULL,"Dreyfuss","Richard");

#------------------------------------------------------------
# Injection Table: Realisateur
#------------------------------------------------------------

INSERT INTO Realisateur VALUES
        (NULL,"Ho","Godfrey"),
        (NULL,"Spielberg", "Steven"),
        (NULL,"Sang-Ho", "Yeon"),
        (NULL,"Peter", "Jackson"),
        (NULL,"Cronenberg", "David");

#------------------------------------------------------------
# Injection Table: Film
#------------------------------------------------------------

INSERT INTO Film VALUES
        (NULL,  "Hitman le Cobra",
                1989, 
                2,
                "Après une course effrénée, Phillip tue Roger, ayant vendu des informations aux Japonais. Mike, le frère de Roger, veut se venger de Phillip",
                "1-HC.jpg",
                1, 
                2),
        (NULL, "Jurassic Park",
                1993,
                5,
                "John Parker Hammond, le PDG de la puissante compagnie InGen, parvient à donner vie à des dinosaures grâce à la génétique et décide de les utiliser dans le cadre d’un parc d'attractions qu’il compte ouvrir sur une île au large du Costa Rica. Avant l'ouverture, il fait visiter le parc à un groupe d'experts pour obtenir leur aval. Pendant la visite, une tempête éclate et un informaticien corrompu par une entreprise rivale en profite pour couper les systèmes de sécurité afin de voler des embryons de dinosaures",
                "2-JP.jpg",
                2,
                1),
        (NULL, "Dernier Train pour Busan",
                2016,
                4,
                "Un virus inconnu se répand en Corée du Sud, l'état d'urgence est décrété. Les passagers du train KTX se livrent à une lutte sans merci afin de survivre jusqu'à Busan, l'unique ville où ils seront en sécurité...",
                "3-DTB.jpg",
                3,
                3),
        (NULL,  "King Kong",
                2005,
                4,
                "New York, 1933. Ann Darrow est une artiste de music-hall dont la carrière a été brisée net par la Dépression. Se retrouvant sans emploi ni ressources, la jeune femme rencontre l'audacieux explorateur-réalisateur Carl Denham et se laisse entraîner par lui dans la plus périlleuse des aventures…",
                "4-KK.jpg",
                4,
                1),
        (NULL,  "Les Dents de la mer",
                1975,
                4,
                "À quelques jours du début de la saison estivale, les habitants de la petite station balnéaire d'Amity sont mis en émoi par la découverte sur le littoral du corps atrocement mutilé d'une jeune vacancière. Pour Martin Brody, le chef de la police, il ne fait aucun doute que la jeune fille a été victime d'un requin. Il décide alors d'interdire l'accès des plages mais se heurte à l'hostilité du maire uniquement intéressé par l'afflux des touristes. Pendant ce temps, le requin continue àsemer la terreur le long des côtes et à dévorer les baigneurs...",
                "5-DM.jpg",
                2,
                1),
        (NULL, "La Mouche",
                1986,
                3,
                "Seth Brundle est un jeune biologiste très doué. Après avoir fait ses premières armes dans une brillante équipe, il se décide à travailler seul. Il met au point une invention qui doit révolutionner le monde : la téléportation qui consiste à transporter la matière à travers l'espace. Les essais sur un babouin sont peu convaincants et après des fuites dans la presse, il décide de se téléporter lui-même. Seulement il ne s'apercoit pas qu'une mouche fait partie du voyage.",
                "6-M.jpg",
                5,
                1);

#------------------------------------------------------------
# Injection Table: Film_Acteur
#------------------------------------------------------------

INSERT INTO Film_Acteur VALUES
        (1,1),
        (1,2),
        (2,3),
        (2,4),
        (2,5),
        (3,6),
        (3,7),
        (3,8),
        (4,9),
        (4,10),
        (4,11),
        (5,12),
        (5,13),
        (6,5);

#------------------------------------------------------------
# Injection Table: Film_Genre
#------------------------------------------------------------

INSERT INTO Film_Genre VALUES
        (1,3),
        (2,1),
        (2,2),
        (3,4),
        (3,5),
        (4,2),
        (4,3),
        (5,2),
        (5,5),
        (6,1),
        (6,5);
