package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import models.managers.FilmManager;
import views.ViewHandler;

import java.sql.SQLException;

public class ControllerList implements EventHandler<MouseEvent> {
    private ViewHandler viewHandler;
    private FilmManager filmManager;

    public ControllerList(ViewHandler viewHandler, FilmManager filmManager) {
        this.viewHandler = viewHandler;
        this.filmManager = filmManager;
        try {
            this.viewHandler.getViewList().updateAFilmTile(this.filmManager.getAll(), this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getPickResult().getIntersectedNode().getId() != null){
            viewHandler.afficherSingleFilm(Integer.valueOf(mouseEvent.getPickResult().getIntersectedNode().getId()));
        }
    }
}
