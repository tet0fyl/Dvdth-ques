package views;

import controllers.ControllerHome;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import models.Film;
import tools.Config;
import java.util.ArrayList;

public class ViewHome {
    private FlowPane root;
    private VBox vBoxContainer; // Conteneur qui agence verticalement les element
    private ScrollPane scrollPane; // Conteneur Scrollable
    private FlowPane flowPaneCotainerFilms; // Conteneur FlowPane
    private HBox hBoxTitle; // Conteneur du Titre
    private Text titleNouveaute;

    public ViewHome(FlowPane root){
        this.root = root;

        /* INITIALISATION DES CONTENEURS */
        vBoxContainer = new VBox();
        scrollPane = new ScrollPane();
        hBoxTitle = new HBox();
        flowPaneCotainerFilms = new FlowPane();

        /* EDITION DU TITRE */
        titleNouveaute = new Text("Nouveauté : ");
        titleNouveaute.setFont(Font.font("Arial", FontWeight.BOLD,15));
        hBoxTitle.getChildren().add(titleNouveaute);

        /* EDITION DU VBOXCONTENEUR */
        vBoxContainer.minWidthProperty().bind(root.widthProperty());
        vBoxContainer.maxWidthProperty().bind(root.widthProperty());

        /* EDITION DU CONTENEUR DES FILMS */
        flowPaneCotainerFilms.setVgap(20);
        flowPaneCotainerFilms.setHgap(20);
        flowPaneCotainerFilms.setPadding(new Insets(10));
        flowPaneCotainerFilms.setAlignment(Pos.CENTER);
        flowPaneCotainerFilms.minWidthProperty().bind(vBoxContainer.widthProperty());
        flowPaneCotainerFilms.maxWidthProperty().bind(vBoxContainer.widthProperty());
        vBoxContainer.minHeightProperty().bind(root.heightProperty());

        /* EDITION DU CONTENEUR SCROLLABLE */
        scrollPane.prefHeightProperty().bind(Bindings.divide(root.heightProperty(),1.5));
        scrollPane.maxWidthProperty().bind(vBoxContainer.widthProperty());
        scrollPane.minWidthProperty().bind(vBoxContainer.widthProperty());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setContent(flowPaneCotainerFilms);

    }

    /**
     * Vide le FlowPane root
     * Ajoute le Header et les element au conteneur qui va agencer nos element verticalement
     * Puis Ajouter la VBox Container au root
     * @param viewHeader
     */
    public void clearAndInitRoot(ViewHeader viewHeader) {
        root.getChildren().clear();
        vBoxContainer.getChildren().addAll(viewHeader.getHeader(),hBoxTitle,scrollPane);
        root.getChildren().add(vBoxContainer);
    }

    /**
     * Boucle la liste de film pour creer les differentes tuiles
     * @param arrayOfFilm
     */
    public void updateAFilmTile(ArrayList<Film> arrayOfFilm, ControllerHome controllerHome){
        for(Film film : arrayOfFilm){
            /* CREATION DU CONTENEUR QUI VA ACCEUILLIR L'IMAGE DU FILM (Tuile)*/
            VBox vBoxTile = new VBox();
            vBoxTile.setMaxWidth(100);
            vBoxTile.setAlignment(Pos.CENTER);
            vBoxTile.setMaxWidth(200); // Je ne sais pas si tout ca et neccessaire
            vBoxTile.setMinWidth(100); //
            vBoxTile.setPrefWidth(200); //

            /* CEATION ET AJOUT DE L'IMAGE */
            ImageView img = new ImageView(Config.urlFilmImg + film.getImg());
            img.fitWidthProperty().bind(vBoxTile.widthProperty());
            img.getStyleClass().add("shadow");
            img.setPreserveRatio(true);
            img.setId(film.getId());
            img.setOnMouseClicked(controllerHome);

            vBoxTile.getChildren().add(img);
            flowPaneCotainerFilms.getChildren().add(vBoxTile); // Ajout de la tuile dans le conteneur Films
        }
    }

    /*  GETTER  */
    public FlowPane getRoot(){
        return root;
    }
}
