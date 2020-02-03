package controllers;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import views.ViewHandler;

import java.sql.SQLException;

public class ControllerHeader implements EventHandler<MouseEvent> {
    private ViewHandler viewHandler;

    public ControllerHeader(ViewHandler viewHandler){
        this.viewHandler = viewHandler;

        this.viewHandler.getViewHeader().setEvent(this);
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(viewHandler.getViewHeader().getBtnExit())){
            Platform.exit();
        }
        if(mouseEvent.getSource().equals(viewHandler.getViewHeader().getBtnListFilm())){
            viewHandler.afficherListFilm();
        }

        if(mouseEvent.getSource().equals(viewHandler.getViewHeader().getBtnAddFilm())){
            viewHandler.afficherAddFilm();
        }

        if(mouseEvent.getSource().equals(viewHandler.getViewHeader().getBtnHome())){
            try {
                viewHandler.afficherHome();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
