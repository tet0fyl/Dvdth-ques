package views;

import controllers.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import models.FilmManager;
import tools.Config;

import java.sql.SQLException;

public class ViewHandler extends Application {
    private Stage primaryStage;
    private ViewHome viewHome;
    private ViewList viewList;
    private ViewHeader viewHeader;
    private ViewLoadScreen viewLoadScreen;
    private ViewAddFilm viewAddFilm;
    private ControllerLoadScreen controllerLoadScreen;
    private ControllerHome controllerHome;
    private ControllerList controllerList;
    private ControllerHeader controllerHeader;
    private ControllerAddFilm controllerAddFilm;
    private FilmManager filmManager;
    private FlowPane root;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        root = new FlowPane();
        root.getStyleClass().add("bg");
        scene = new Scene(root,500,600);
        viewHeader = new ViewHeader(root);
        controllerHeader = new ControllerHeader(this);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(300);

        filmManager = new FilmManager();

        /* ON EDITE LA SCENE */
        scene.getStylesheets().add(Config.urlStyleSheet);
        primaryStage.setTitle("Dvdtheques");
        //primaryStage.setFullScreenExitHint("");
        //primaryStage.setFullScreen(true);
        //primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        primaryStage.show();

        /* ON AFFICHE PAR DEFAULT L'ECRAN DE CHARGEMENT */
        if(!Config.skipIntro){
            afficherPreloader();
        } else {
            try {
                afficherHome();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void afficherPreloader(){
        viewLoadScreen = new ViewLoadScreen(root);
        viewLoadScreen.clearAndInitRoot();
        controllerLoadScreen = new ControllerLoadScreen(this, filmManager);
    }

    public void afficherHome() throws SQLException {
        viewHome = new ViewHome(root);
        viewHome.clearAndInitRoot(getViewHeader());
        controllerHome = new ControllerHome(this, filmManager);

    }

    public void afficherListFilm() {
        viewList = new ViewList(root);
        viewList.clearAndInitRoot(getViewHeader());
        controllerList = new ControllerList(this,filmManager);
    }

    public void afficherAddFilm() {
        viewAddFilm = new ViewAddFilm(root);
        viewAddFilm.clearAndInitRoot(getViewHeader());
        controllerAddFilm = new ControllerAddFilm(this,filmManager);
    }

    public ViewHome getViewHome(){
        return viewHome;
    }

    public ViewLoadScreen getViewLoadScreen(){
        return viewLoadScreen;
    }

    public ViewHeader getViewHeader(){
        return viewHeader;
    }

    public ViewList getViewList(){
        return viewList;
    }

}
