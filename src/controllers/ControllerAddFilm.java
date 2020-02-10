package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import models.managers.FilmManager;
import models.managers.RealisateurManager;
import views.ViewHandler;

import java.sql.SQLException;

public class ControllerAddFilm implements EventHandler<MouseEvent> {
    private RealisateurManager realisateurManager;
    private FilmManager filmManager;
    //TODO: déclarer les managers (les créer aussi si il n'existe pas !!!)

    private ViewHandler viewHandler;

    public ControllerAddFilm(ViewHandler viewHandler) {

        this.viewHandler = viewHandler;
        this.realisateurManager= new RealisateurManager();
        this.viewHandler.getViewAddFilm().setEvent(this);

        // TODO: initialiser les manager
        try {
            //TODO: updater la view avec les valeurs

            this.viewHandler.getViewAddFilm().updateRealisateurField(this.realisateurManager.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(viewHandler.getViewAddFilm().getBtn())){
            //TODO: Choper tout les textes field

            int valeurAF = Integer.parseInt(viewHandler.getViewAddFilm().getAnneeFilm().getText());

            System.out.println(valeurAF);


            //TODO: Faire requete



        }
    }
}
