package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import models.Acteur;
import models.Genre;
import models.Nationalite;
import models.Realisateur;
import models.managers.ActeurManager;
import models.managers.NationaliteManager;
import models.managers.GenreManager;
import models.managers.RealisateurManager;
import tools.Config;
import views.ViewHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class ControllerAddFilm implements EventHandler<MouseEvent> {
    private RealisateurManager realisateurManager;
    private GenreManager genreManager;
    private ActeurManager acteurManager;
    private NationaliteManager nationaliteManager;
    private ViewHandler viewHandler;
    private File selectedFile;
    private ArrayList<Realisateur> dataRealisateur;
    private ArrayList<Acteur> dataActeurs;
    private ArrayList<Genre> dataGenres;
    private ArrayList<Nationalite> dataNationalite;


    public ControllerAddFilm(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.realisateurManager= new RealisateurManager();
        this.genreManager= new GenreManager();
        this.acteurManager= new ActeurManager();
        this.nationaliteManager= new NationaliteManager();
        this.viewHandler.getViewAddFilm().setEvent(this);

        try {
            dataRealisateur = realisateurManager.getAll();
            dataActeurs = acteurManager.getAll();
            dataGenres = genreManager.getAll();
            dataNationalite = nationaliteManager.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(viewHandler.getViewAddFilm().getBtnAddGenre())) {
            viewHandler.getViewAddFilm().addSuplementaireGenreField();
        }
        if(mouseEvent.getSource().equals(viewHandler.getViewAddFilm().getBtnAddActeur())) {
            viewHandler.getViewAddFilm().addSuplementaireActorField();
        }
        if(mouseEvent.getSource().equals(viewHandler.getViewAddFilm().getBtnSubmit())) {
            //TODO: Choper tout les textes field

            String valuesNomFilm = (viewHandler.getViewAddFilm().getTxtFieldNomFilm().getText());
            //int valuesAnnee = parseInt(viewHandler.getViewAddFilm().getTxtFieldAnneeFilm().getText());
            //int valuesNote = viewHandler.getViewAddFilm().getChoiceBoxNote().getSelectionModel().getSelectedIndex();
            String valuesActeurNom = (viewHandler.getViewAddFilm().getTxtFieldPrenomActeur().getText());
            String valuesActeurPrenom = (viewHandler.getViewAddFilm().getTxtFieldPrenomActeur().getText());
            String valuesRealisateurNom = (viewHandler.getViewAddFilm().getTxtFieldNomRealisateur().getText());
            String valuesRealisateurPrenom = (viewHandler.getViewAddFilm().getTxtFieldPrenomRealisateur().getText());
            String valuesDescription = (viewHandler.getViewAddFilm().getDescriptionFilm().getText());
            String valuesGenre = (viewHandler.getViewAddFilm().getTxtFieldGenre().getText());
            String valuesNationalite = (viewHandler.getViewAddFilm().getTxtFieldNationalite().getText());

            //TODO: Faire requete
           // System.out.println(valuesNomFilm + " " + valuesRealisateurNom  + " " + valuesActeurPrenom + "" +
                 //   " " + valuesActeurNom + " " + valuesRealisateurPrenom + " " + valuesDescription + " " + valuesGenre + " " + valuesNote+ " " + valuesAnnee );
            try {
                int acteur_id = acteurManager.insert(valuesActeurNom,valuesActeurPrenom);
                int genre_id = genreManager.insert(valuesGenre);
                int nationalite_id = nationaliteManager.insert(valuesNationalite);
                int real_id = realisateurManager.insert(valuesRealisateurNom,valuesRealisateurPrenom);
                //System.out.println(real_id,);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }




        if(mouseEvent.getSource().equals(viewHandler.getViewAddFilm().getBtnUploadFile())){
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");

                selectedFile = fileChooser.showOpenDialog(viewHandler.getPrimaryStage());

            if(selectedFile != null){
                try {
                    Files.copy(FileSystems.getDefault().getPath(selectedFile.getPath()),
                            (Paths.get(Paths.get("").toAbsolutePath().toString() + "/src/" + Config.urlFilmImg + "/" + selectedFile.getName())),
                            StandardCopyOption.COPY_ATTRIBUTES);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }






        }
}
