package views;

import javafx.scene.layout.FlowPane;

public class ViewAddFilm {
    private FlowPane root;

    public ViewAddFilm(FlowPane root) {
        this.root = root;
    }

    public void clearAndInitRoot(ViewHeader viewHeader) {
        root.getChildren().clear();
        root.getChildren().add(viewHeader.getHeader());
    }
}
