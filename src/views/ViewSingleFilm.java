package views;

import controllers.ControllerList;
import controllers.ControllerSingleFilm;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import models.Film;
import tools.Config;

import java.util.ArrayList;

public class ViewSingleFilm {
    private FlowPane root;
    private VBox vBoxContainer;// Conteneur qui agence verticalement les element
    private VBox vBoxContainerFilm;// Conteneur qui agence verticalement les films
    private Image imageDelete = new Image(Config.urlIconeDelete);
    private Image imgModify = new Image(Config.urlIconeModify);

    public ViewSingleFilm(FlowPane root){
        this.root = root;

        /* CONSTRUCTION DES CONTENEURS  */
        vBoxContainer = new VBox();
        vBoxContainerFilm = new VBox();

        /* EDITION VBOXCONTENEUR */
        vBoxContainer.minWidthProperty().bind(root.widthProperty());
        vBoxContainer.maxWidthProperty().bind(root.widthProperty());
        vBoxContainer.minHeightProperty().bind(root.heightProperty());


        /* EDITION DU CONTENEUR DES FILMS */
        vBoxContainerFilm.minWidthProperty().bind(root.widthProperty());
        vBoxContainerFilm.maxWidthProperty().bind(root.widthProperty());
        vBoxContainerFilm.minHeightProperty().bind(root.heightProperty());
        vBoxContainerFilm.setPadding(new Insets(0,20,0,20));

    }

    /**
     * EventHandler
     * @param controllerList
     */
    public void setEvent(ControllerList controllerList) {
    }

    /**
     * Idem que ViewHome
     * @param viewHeader
     */
    public void clearAndInitRoot(ViewHeader viewHeader) {
        root.getChildren().clear();
        vBoxContainer.getChildren().addAll(viewHeader.getHeader(),vBoxContainerFilm);
        root.getChildren().add(vBoxContainer);
    }

    /**
     * Idem que ViewHome sauf que l'on y affiche plus d'info
     * @param arrayOfFilm
     */
    public void updateFilm(ArrayList<Film> arrayOfFilm, ControllerSingleFilm controllerSingleFilm) {
        for(Film film : arrayOfFilm){

            /*  INITIALISATION DE CHAQUE TILE */
            HBox hBoxTile = new HBox(); // Conteneur principale
            VBox vBoxDetails = new VBox(); // Conteneur Nom, Annee, Content, Realisateur,...

            /* IMG */
            ImageView img = new ImageView(Config.urlFilmImg + film.getImg());
            img.fitWidthProperty().bind(Bindings.divide(root.widthProperty(),5));

            /* BARRE DE MODIF */
            HBox hBoxBarreDeModif = new HBox();
            img.setPreserveRatio(true);

            /* TITRE */
            Label txtTitle = new Label(film.getNom());
            txtTitle.setFont(Font.font(20));
            txtTitle.setWrapText(true);

            /* ANNEE */
            Label txtAnnee = new Label(film.getNom());
            txtTitle.setWrapText(true);

            /* NOTE */
            Label txtNote = new Label(film.getNote() + "/ 5");
            txtNote.setWrapText(true);

            /* CONTENT */
            Label txtContent = new Label(film.getContent());
            txtContent.setWrapText(true);

            /* REALISATEUR */
            HBox vBoxRealisateur = new HBox();
            Label titleRealisateur = new Label("Réalisateur : ");
            Label dataRealisateur = new Label(film.getRealisateur().toString());
            titleRealisateur.setFont(Font.font("Arial",FontWeight.BOLD,14));
            vBoxRealisateur.getChildren().addAll(titleRealisateur,dataRealisateur);
            HBox.setMargin(vBoxRealisateur, new Insets(10,0,0,0)); // Petite marge entre realisateur au dessus de realisateur

            /* ACTEURS */
            HBox VboxActeur = new HBox();
            Label titleActeur = new Label("Acteurs : ");
            Label dataActeurs = new Label(film.getActeursToString());
            titleActeur.setFont(Font.font("Arial",FontWeight.BOLD,14));
            VboxActeur.getChildren().addAll(titleActeur,dataActeurs);

            /* GENRES */
            HBox vBoxGenre = new HBox();
            Label titleGenre = new Label("Genre : ");
            Label dataGenres = new Label(film.getGenresToString());
            titleGenre.setFont(Font.font("Arial",FontWeight.BOLD,14));
            vBoxGenre.getChildren().addAll(titleGenre,dataGenres);

            /* NATIONNALITE */
            HBox vBoxNationalite = new HBox();
            Label titleNationalite = new Label("Nationalité : ");
            Label dataNationalite = new Label(film.getNationalite().toString());
            titleNationalite.setFont(Font.font("Arial",FontWeight.BOLD,14));
            vBoxNationalite.getChildren().addAll(titleNationalite,dataNationalite);

            /* AJOUT DANS VBOXDETAILS */
            vBoxDetails.getChildren().addAll(txtTitle,txtAnnee,txtNote,txtContent,vBoxRealisateur,VboxActeur,vBoxGenre,vBoxNationalite);
            vBoxDetails.setPadding(new Insets(5));

            /* EDITION DE LA TUILES*/
            hBoxTile.getChildren().addAll(img,vBoxDetails);
            hBoxTile.setAlignment(Pos.CENTER);

            VBox vBoxTile = new VBox();
            vBoxTile.getStyleClass().add("shadow");
            hBoxBarreDeModif.setAlignment(Pos.CENTER_RIGHT);
            vBoxTile.getChildren().addAll(hBoxBarreDeModif,hBoxTile);
            vBoxTile.setPadding(new Insets(10));
            vBoxContainerFilm.getChildren().add(vBoxTile); // On met la tuile dans le conteneur de films
        }
    }
}
