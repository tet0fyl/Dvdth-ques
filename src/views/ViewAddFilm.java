package views;

import javafx.scene.layout.FlowPane;

public class ViewAddFilm {
    private FlowPane root;

    public ViewAddFilm(FlowPane root) {
        this.root = root;
        //TODO : Construire un formulaire d'ajout de film

    }

    public void clearAndInitRoot(ViewHeader viewHeader) {
        root.getChildren().clear();
        root.getChildren().add(viewHeader.getHeader());
    }
}
