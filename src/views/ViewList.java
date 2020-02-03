package views;

import controllers.ControllerList;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import models.Acteur;
import models.Film;
import tools.Config;

import java.util.ArrayList;

public class ViewList {
    private FlowPane root;
    private VBox vBoxContainer = new VBox();
    private VBox hBoxHeader;
    private FlowPane hBoxCotainerFilms;
    private FlowPane flowPaneNavBar;
    private ScrollPane scrollPane;
    private Button btnHome, btnListFilm, btnAddFilm,btnExit;
    private ImageView imgNameLogo = new ImageView(Config.urlImgFullLogo);
    private HBox hBoxLogo,hBoxFooter;

    public ViewList(FlowPane root){
        this.root = root;
        this.root = root;
        vBoxContainer = new VBox();
        scrollPane = new ScrollPane();
        vBoxContainer.minWidthProperty().bind(root.widthProperty());
        vBoxContainer.maxWidthProperty().bind(root.widthProperty());
        hBoxCotainerFilms = new FlowPane();
        hBoxCotainerFilms.setVgap(20);
        hBoxCotainerFilms.setHgap(20);
        hBoxCotainerFilms.setPadding(new Insets(10));
        hBoxCotainerFilms.setAlignment(Pos.CENTER);
        hBoxCotainerFilms.minWidthProperty().bind(vBoxContainer.widthProperty());
        hBoxCotainerFilms.maxWidthProperty().bind(vBoxContainer.widthProperty());
        scrollPane.prefHeightProperty().bind(Bindings.divide(root.heightProperty(),1.5));
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setContent(hBoxCotainerFilms);
        vBoxContainer.minHeightProperty().bind(root.heightProperty());

    }

    public void setEvent(ControllerList controllerList) {
    }

    public void clearAndInitRoot(ViewHeader viewHeader) {
        root.getChildren().clear();
        vBoxContainer.getChildren().add(viewHeader.getHeader());
        vBoxContainer.getChildren().addAll(scrollPane);
        root.getChildren().add(vBoxContainer);
    }

    public void updateAFilmTile(ArrayList<Film> arrayOfFilm) {
        for(Film film : arrayOfFilm){
            VBox vBox = new VBox();
            VBox vBoxDetails = new VBox();
            HBox hBox = new HBox();
            vBox.setMaxWidth(100);
            vBox.setAlignment(Pos.CENTER);
            Label txtTitle = new Label(film.getNom());
            txtTitle.setFont(Font.font(20));
            txtTitle.setWrapText(true);
            Label txtContent = new Label(film.getContent((byte) 100));
            txtContent.setWrapText(true);
            Label txtNote = new Label(film.getNote() + "/ 5");
            txtNote.setWrapText(true);

            HBox vBoxRealisateur = new HBox();
            Label titleRealisateur = new Label("Réalisateur : ");
            Label dataRealisateur = new Label(film.getRealisateur().toString());
            titleRealisateur.setFont(Font.font("Arial",FontWeight.BOLD,14));
            vBoxRealisateur.getChildren().addAll(titleRealisateur,dataRealisateur);

            HBox vBoxGenre = new HBox();
            Label titleGenre = new Label("Genre : ");
            Label dataGenres = new Label(film.getGenresToString());
            titleGenre.setFont(Font.font("Arial",FontWeight.BOLD,14));
            vBoxGenre.getChildren().addAll(titleGenre,dataGenres);

            HBox vBoxNationalite = new HBox();
            Label titleNationalite = new Label("Nationalité : ");
            Label dataNationalite = new Label(film.getNationalite().toString());
            titleNationalite.setFont(Font.font("Arial",FontWeight.BOLD,14));

            vBoxNationalite.getChildren().addAll(titleNationalite,dataNationalite);


            HBox VboxActeur = new HBox();
            Label titleActeur = new Label("Acteurs : ");
            Label dataActeurs = new Label(film.getActeursToString());
            titleActeur.setFont(Font.font("Arial",FontWeight.BOLD,14));
            VboxActeur.getChildren().addAll(titleActeur,dataActeurs);
            HBox.setMargin(vBoxRealisateur, new Insets(10,0,0,0));

            vBoxDetails.getChildren().addAll(txtTitle,txtNote,txtContent,vBoxRealisateur,VboxActeur,vBoxGenre,vBoxNationalite);
            vBoxDetails.setPadding(new Insets(5));
            vBox.setPadding(new Insets(5));

            //vBox.setPadding(new Insets(15,0,0,0));
            ImageView img = new ImageView(Config.urlFilmImg + film.getImg());
            img.fitWidthProperty().bind(Bindings.divide(root.widthProperty(),5));

            vBox.getStyleClass().add("tile");
            //img.setFitWidth(200);
            img.setPreserveRatio(true);
            hBox.getChildren().addAll(img,vBoxDetails);
            vBox.getChildren().add(hBox);
            vBox.maxWidthProperty().bind(root.widthProperty());
            vBox.minWidthProperty().bind(root.widthProperty());

            hBoxCotainerFilms.getChildren().add(vBox);
        }
    }
}
