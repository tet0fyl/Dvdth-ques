package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import models.managers.ActeurManager;
import models.managers.NationaliteManager;
import models.managers.GenreManager;
import models.managers.RealisateurManager;
import views.ViewHandler;

import java.sql.SQLException;

public class ControllerAddFilm implements EventHandler<MouseEvent> {
    private RealisateurManager realisateurManager;
    private GenreManager genreManager;
    private ActeurManager acteurManager;
    private NationaliteManager nationaliteManager;
    private ViewHandler viewHandler;

    public ControllerAddFilm(ViewHandler viewHandler) {

        this.viewHandler = viewHandler;
        this.realisateurManager= new RealisateurManager();
        this.genreManager= new GenreManager();
        this.acteurManager= new ActeurManager();
        this.nationaliteManager= new NationaliteManager();
        this.viewHandler.getViewAddFilm().setEvent(this);

        // TODO: initialiser les manager
        try {
            //TODO: updater la view avec les valeurs

            this.viewHandler.getViewAddFilm().updateRealisateurField(this.realisateurManager.getAll());
            this.viewHandler.getViewAddFilm().updateGenreField(this.genreManager.getAll());
            this.viewHandler.getViewAddFilm().updateActeurField(this.acteurManager.getAll());
            this.viewHandler.getViewAddFilm().updateNationaliteField(this.nationaliteManager.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(viewHandler.getViewAddFilm().getBtn())){
            //TODO: Choper tout les textes field

                String valeurNomFilm = (viewHandler.getViewAddFilm().getNomFilm().getText());
                String valeurimage = (viewHandler.getViewAddFilm().getImage().getText());
                String valeurGenre = (viewHandler.getViewAddFilm().getGenre().getText());
                String valeurPrenomActeur = (viewHandler.getViewAddFilm().getPrenomActeur().getText());
                String valeurNomacteur = (viewHandler.getViewAddFilm().getNomActeur().getText());
                String valeurprenomReal = (viewHandler.getViewAddFilm().getPrenomREAL().getText());
                String valeurRealisateur = (viewHandler.getViewAddFilm().getNomREAL().getText());
                String valeurNationalite = (viewHandler.getViewAddFilm().getNationalite().getText());
                String valeurDescrip = (viewHandler.getViewAddFilm().getDescriptionFilm().getText());
                int valeurAF = Integer.parseInt(viewHandler.getViewAddFilm().getAnneeFilm().getText());
                int valeurNote = Integer.parseInt(viewHandler.getViewAddFilm().getNoteFilm().getText());



            //TODO: Faire requete



        }
    }
}
