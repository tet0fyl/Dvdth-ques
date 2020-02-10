package controllers;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import models.managers.FilmManager;
import views.ViewHandler;

import java.sql.SQLException;


public class ControllerSingleFilm implements EventHandler<MouseEvent>{
    public ViewHandler viewHandler;
    public FilmManager filmManager;

    public ControllerSingleFilm(ViewHandler viewHandler, FilmManager filmManager, int idFilm) {
        this.viewHandler = viewHandler;
        this.filmManager= filmManager;
        try {
            this.viewHandler.getViewSingleFilm().updateFilm(this.filmManager.getOneFilm(idFilm), this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

    }

}
