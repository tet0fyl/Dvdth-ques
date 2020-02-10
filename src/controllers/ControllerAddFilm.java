package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import models.RealisateurManager;
import views.ViewHandler;

import java.sql.SQLException;

public class ControllerAddFilm implements EventHandler<MouseEvent> {
    private RealisateurManager realisateurManager;
    private ViewHandler viewHandler;

    public ControllerAddFilm(ViewHandler viewHandler, RealisateurManager realisateurManager) {

        this.viewHandler = viewHandler;
        this.realisateurManager= realisateurManager;
        try {
            this.viewHandler.getViewAddFilm().addNewFilm(this.realisateurManager.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void handle(MouseEvent mouseEvent) {

    }
}
