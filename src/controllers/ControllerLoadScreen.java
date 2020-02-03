package controllers;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import models.managers.FilmManager;
import tools.Config;
import views.ViewHandler;

import java.nio.file.Paths;
import java.sql.SQLException;

public class ControllerLoadScreen extends AnimationTimer implements EventHandler<MouseEvent> {
    private ViewHandler viewHandler;
    private FilmManager filmManager;
    private Timeline timeline;
    private MediaPlayer logoSound, errorSound;
    private long l = 0;
    private byte step = 0;

    public ControllerLoadScreen(ViewHandler viewHandler, FilmManager filmManager) {
        this.viewHandler = viewHandler;
        this.filmManager = filmManager;
        timeline = new Timeline();
        logoSound = new MediaPlayer(new Media(Paths.get(Config.urlLogoSound).toUri().toString()));
        errorSound = new MediaPlayer(new Media(Paths.get(Config.urlErrorSound).toUri().toString()));
        viewHandler.getViewLoadScreen().setEvent(this);
        this.start();
    }

    @Override
    public void handle(long now) {
        if( step == 0 ) {
            l = now;
            step++;
            return;
        }
        if( now - l >= 1_000_000_000L && step == 1) {
            logoSound.setVolume(100);
            logoSound.play();
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO),
                    new KeyFrame(new Duration(500),
                            new KeyValue(viewHandler.getViewLoadScreen().getLogo().opacityProperty(),1),
                            new KeyValue(viewHandler.getViewLoadScreen().getHBoxLogo().maxWidthProperty(),400)));
            timeline.setCycleCount(1);
            timeline.play();
            step++;

        }

        if( now - l >= 2_000_000_000L && step == 2) {
            timeline.stop();
            viewHandler.getViewLoadScreen().startProgressIndicator();
            step++;
        }

        if( now - l >= 4_000_000_000L && step == 3) {
            logoSound.stop();
            step++;
            try {
                filmManager.checkConnection();
                viewHandler.getViewLoadScreen().stopProgressIndicator();
                viewHandler.afficherHome();
                stopAnimationTimer();
            } catch (SQLException e) {
                errorSound.play();
                e.printStackTrace();
                viewHandler.getViewLoadScreen().updateErrorNotificationStatus("la connexion à la base de données a échoué");
                viewHandler.getViewLoadScreen().stopProgressIndicator();
                stopAnimationTimer();
            }
        }

    }
    public void stopAnimationTimer() {
        this.stop();
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(viewHandler.getViewLoadScreen().getBtnExit())){
            Platform.exit();
        }
    }
}
