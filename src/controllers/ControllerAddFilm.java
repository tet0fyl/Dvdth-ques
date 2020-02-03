package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import models.managers.FilmManager;
import views.ViewHandler;

public class ControllerAddFilm implements EventHandler<MouseEvent> {
    private FilmManager filmManager;
    private ViewHandler viewHandler;

    public ControllerAddFilm(ViewHandler viewHandler, FilmManager filmManager) {
        this.viewHandler = viewHandler;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {

    }
}
