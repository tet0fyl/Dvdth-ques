package controllers;

import models.FilmManager;
import views.ViewHandler;

import java.sql.SQLException;

public class ControllerList {
    private ViewHandler viewHandler;
    private FilmManager filmManager;

    public ControllerList(ViewHandler viewHandler, FilmManager filmManager) {
        this.viewHandler = viewHandler;
        this.filmManager = filmManager;
        try {
            this.viewHandler.getViewList().updateAFilmTile(this.filmManager.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
