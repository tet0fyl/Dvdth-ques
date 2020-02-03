package controllers;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import models.managers.FilmManager;
import views.ViewHandler;

import java.sql.SQLException;


public class ControllerHome implements EventHandler<MouseEvent>{
    public ViewHandler viewHandler;
    public FilmManager filmManager;

    /**
     * Est charger de lancer la methode updateAFilmTile() de la vue Home pour construire les tuiles
     * @param viewHandler l'objet qui nous permet de connaitre toute les vues
     * @param filmManager l'objet qui nous permet de faire des requetes
     * @throws SQLException
     */
    public ControllerHome(ViewHandler viewHandler, FilmManager filmManager) {
        this.viewHandler = viewHandler;
        this.filmManager= filmManager;
        try {
            this.viewHandler.getViewHome().updateAFilmTile(this.filmManager.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

    }

}
