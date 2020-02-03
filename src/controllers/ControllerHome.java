package controllers;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import models.FilmManager;
import views.ViewHandler;

import java.sql.SQLException;


public class ControllerHome implements EventHandler<MouseEvent>{
    public ViewHandler viewHandler;
    public FilmManager filmManager;

    public ControllerHome(ViewHandler viewHandler, FilmManager filmManager) throws SQLException {
        this.viewHandler = viewHandler;
        this.filmManager= filmManager;
        this.viewHandler.getViewHome().updateAFilmTile(this.filmManager.getAll());
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

    }

}
