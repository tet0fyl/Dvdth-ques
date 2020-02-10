package controllers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import models.Film;
import models.managers.FilmManager;
import views.ViewHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ControllerList implements EventHandler<InputEvent> {
    private ViewHandler viewHandler;
    private FilmManager filmManager;
    private ArrayList<Film> filmArrayList;
    private ArrayList<Film> filterFilmArrayList;


    public ControllerList(ViewHandler viewHandler, FilmManager filmManager) {
        this.viewHandler = viewHandler;
        this.filmManager = filmManager;
        try {
            filmArrayList = this.filmManager.getAll();
            this.viewHandler.getViewList().updateAFilmTile(filmArrayList, this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.viewHandler.getViewList().setEvent(this);
    }


    @Override
    public void handle(InputEvent inputEvent) {
        if(inputEvent.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
            if(((MouseEvent)inputEvent).getPickResult().getIntersectedNode().getId() != null){
                viewHandler.afficherSingleFilm(Integer.valueOf(((MouseEvent)inputEvent).getPickResult().getIntersectedNode().getId()));
            }
        }
        if(inputEvent.getEventType().equals(KeyEvent.KEY_TYPED)){
            filterFilmArrayList = filmArrayList.stream().filter( items -> (
                                    items.getNom().toLowerCase().contains(viewHandler.getViewList().getTxtFieldSearch().getText().toLowerCase()) ||
                                            items.getRealisateur().toString().toLowerCase().contains(viewHandler.getViewList().getTxtFieldSearch().getText().toLowerCase()) ||
                                            items.getActeursToString().toLowerCase().contains(viewHandler.getViewList().getTxtFieldSearch().getText().toLowerCase())
            )).collect(Collectors.toCollection(ArrayList::new));
            viewHandler.getViewList().updateAFilmTile(filterFilmArrayList,this);
        }
    }
}
