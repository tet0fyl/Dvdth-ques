package views;

import controllers.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.managers.RealisateurManager;
import models.managers.FilmManager;
import tools.Config;

public class ViewHandler extends Application {
    private Stage primaryStage;
    private ViewHome viewHome;
    private ViewList viewList;
    private ViewHeader viewHeader;
    private ViewLoadScreen viewLoadScreen;
    private ViewAddFilm viewAddFilm;
    private ViewSingleFilm viewSingleFilm;
    private ControllerLoadScreen controllerLoadScreen;
    private ControllerHome controllerHome;
    private ControllerList controllerList;
    private ControllerHeader controllerHeader;
    private ControllerAddFilm controllerAddFilm;
    private ControllerSingleFilm controllerSingleFilm;
    private FilmManager filmManager;
    private RealisateurManager realisateurManager;
    private FlowPane root;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        root = new FlowPane();
        root.getStyleClass().add("bg"); // Ajout d'un class CSS sur le root

        /* ON PREPARE LA SCENE */
        scene = new Scene(root,500,600);
        scene.getStylesheets().add(Config.urlStyleSheet); // Ajout du Css

        /* ON PREPARE LE HEADER */
        viewHeader = new ViewHeader(root);
        controllerHeader = new ControllerHeader(this);

        /* ON PREPARE L'OBJET FILMMANAGER QUI NOUS SERVIRA POUR TOUTE LES REQUETES */
        filmManager = new FilmManager();

        /* ON EDITE LE STAGE */
        primaryStage.setTitle("Dvdtheques");
        primaryStage.setMinHeight(600); //On defini
        primaryStage.setMinWidth(300);
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        //primaryStage.setFullScreenExitHint("");
        //primaryStage.setFullScreen(true);
        //primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

        /* ON AFFICHE SOIT LA PAGE DE CHARGEMENT SOIT LA PAGE HOME SUIVANT LA VARIABLE DANS CONFIG (tools.Config) */
        if(!Config.skipIntro){
            afficherPreloader();
        } else {
            afficherHome();
        }

    }

    /**
     * Methode pour initialiser la vue de chargement
     */
    public void afficherPreloader(){
        viewLoadScreen = new ViewLoadScreen(root);
        viewLoadScreen.clearAndInitRoot();
        controllerLoadScreen = new ControllerLoadScreen(this, filmManager);
    }

    /**
     * Methode pour initialiser la vue Home : qui contient juste les images des films
     * 1. j'initialise la viewHome
     * 2. j'efface le root et je passe en parametre la vue du Header ( comme en PHP pour avoir le même header sur toute les vues)
     * 3. j'initialise le controllerHome
     */
    public void afficherHome() {
        viewHome = new ViewHome(root);
        viewHome.clearAndInitRoot(getViewHeader());
        controllerHome = new ControllerHome(this, filmManager);
    }

    /**
     * Idem pour la vue ListFilm : qui contient les affiches avec le descriptif des films
     */
    public void afficherListFilm() {
        viewList = new ViewList(root);
        viewList.clearAndInitRoot(getViewHeader());
        controllerList = new ControllerList(this,filmManager);
    }

    /**
     * Idem pour la vue AddFilm : qui contiendra le formulaire
     */
    public void afficherAddFilm() {
        viewAddFilm = new ViewAddFilm(root);
        viewAddFilm.clearAndInitRoot(getViewHeader());
        controllerAddFilm = new ControllerAddFilm(this);
    }

    public void afficherSingleFilm(int idFilm){
        viewSingleFilm = new ViewSingleFilm(root);
        viewSingleFilm.clearAndInitRoot(getViewHeader());
        controllerSingleFilm = new ControllerSingleFilm(this, filmManager, idFilm);
    }

    /*  GETTER */
    public ViewHome getViewHome(){
        return viewHome;
    }

    public ViewLoadScreen getViewLoadScreen(){
        return viewLoadScreen;
    }

    public ViewHeader getViewHeader(){
        return viewHeader;
    }

    public ViewAddFilm getViewAddFilm()
    { return viewAddFilm; }

    public ViewList getViewList(){
        return viewList;
    }

    public ViewSingleFilm getViewSingleFilm(){
        return  viewSingleFilm;
    }

}
