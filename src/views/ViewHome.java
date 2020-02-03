package views;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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

import javax.naming.Binding;
import java.util.ArrayList;

public class ViewHome {
    private FlowPane root;
    private VBox vBoxContainer;
    private VBox hBoxHeader;
    private FlowPane hBoxCotainerFilms;
    private FlowPane flowPaneNavBar;
    private ScrollPane scrollPane;
    private Button btnHome, btnListFilm, btnAddFilm,btnExit;
    private ImageView imgNameLogo = new ImageView(Config.urlImgFullLogo);
    private HBox hBoxLogo,hBoxFooter;
    private Text titleNouveaute;
    private HBox hBoxTitle = new HBox();


    public ViewHome(FlowPane root){
        this.root = root;
        vBoxContainer = new VBox();
        scrollPane = new ScrollPane();
        titleNouveaute = new Text("Nouveauté : ");
        titleNouveaute.setFont(Font.font("Arial", FontWeight.BOLD,15));
        hBoxTitle.getChildren().add(titleNouveaute);

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
        scrollPane.maxWidthProperty().bind(vBoxContainer.widthProperty());
        scrollPane.minWidthProperty().bind(vBoxContainer.widthProperty());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setContent(hBoxCotainerFilms);


        vBoxContainer.minHeightProperty().bind(root.heightProperty());


    }

    public void clearAndInitRoot(ViewHeader viewHeader) {
        root.getChildren().clear();
        vBoxContainer.getChildren().add(viewHeader.getHeader());
        vBoxContainer.getChildren().addAll(hBoxTitle,scrollPane);
        root.getChildren().add(vBoxContainer);
    }

    public void updateAFilmTile(ArrayList<Film> arrayOfFilm){
        for(Film film : arrayOfFilm){
            VBox vBox = new VBox();
            vBox.setMaxWidth(100);
            vBox.setAlignment(Pos.CENTER);
            //vBox.setPadding(new Insets(15,0,0,0));
            ImageView img = new ImageView(Config.urlFilmImg + film.getImg());
            //vBox.minWidthProperty().bind(Bindings.divide(root.widthProperty(),4));
            //vBox.maxWidthProperty().bind(Bindings.divide(root.widthProperty(),4));
            img.fitWidthProperty().bind(vBox.widthProperty());
            vBox.setMaxWidth(200);
            vBox.setMinWidth(100);
            vBox.setPrefWidth(200);
            img.getStyleClass().add("shadow");
            //img.setFitWidth(200);
            img.setPreserveRatio(true);
            vBox.getChildren().add(img);
            hBoxCotainerFilms.getChildren().add(vBox);
        }
    }

    public FlowPane getRoot(){
        return root;
    }
}
