package views;

import controllers.ControllerLoadScreen;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import tools.Config;

public class ViewLoadScreen {
    private FlowPane root;
    private VBox vBoxContainer;
    private VBox vBoxInfo;
    private HBox hBoxLogo;
    private Label notificationError;
    private ProgressIndicator progressIndicator;
    private Button btnExit;

    private ImageView imgNameLogo = new ImageView(Config.urlImgFullLogo);

    public ViewLoadScreen(FlowPane root){
        this.root = root;
        btnExit = new Button("EXIT");
        VBox.setMargin(btnExit,new Insets(10,0,0,0));
        progressIndicator = new ProgressIndicator();
        progressIndicator.setStyle(" -fx-progress-color: red;");

        vBoxInfo = new VBox();
        notificationError = new Label();
        vBoxInfo.getChildren().add(notificationError);
        vBoxInfo.minWidthProperty().bind(root.widthProperty());
        vBoxInfo.maxWidthProperty().bind(root.widthProperty());
        vBoxInfo.setAlignment(Pos.CENTER);

        vBoxContainer = new VBox();
        hBoxLogo = new HBox();
        imgNameLogo.fitWidthProperty().bind(hBoxLogo.widthProperty());
        imgNameLogo.setPreserveRatio(true);
        imgNameLogo.setOpacity(0);
        hBoxLogo.getChildren().add(imgNameLogo);
        hBoxLogo.setMaxWidth(50);
        hBoxLogo.setMinWidth(50);
        VBox.setMargin(hBoxLogo,new Insets(0,50,0,50));
        vBoxContainer.setAlignment(Pos.CENTER);
        vBoxContainer.minWidthProperty().bind(root.widthProperty());
        vBoxContainer.maxWidthProperty().bind(root.widthProperty());
        vBoxContainer.minHeightProperty().bind(root.heightProperty());
        vBoxContainer.getChildren().add(hBoxLogo);
        vBoxContainer.getChildren().add(vBoxInfo);

    }

    public void clearAndInitRoot() {
        root.getChildren().clear();
        root.getChildren().add(vBoxContainer);
    }

    public ImageView getLogo(){
        return imgNameLogo;
    }

    public void startProgressIndicator(){
        vBoxContainer.getChildren().add(progressIndicator);
    }

    public void stopProgressIndicator(){
        vBoxContainer.getChildren().remove(progressIndicator);
    }

    public void updateErrorNotificationStatus(String txt) {
        notificationError.setText(txt);
        vBoxContainer.getChildren().add(btnExit);
    }

    public void setEvent(ControllerLoadScreen controllerLoadScreen){
        btnExit.setOnMouseClicked(controllerLoadScreen);
    }

    public FlowPane getRoot(){
        return root;
    }

    public HBox getHBoxLogo(){
        return hBoxLogo;
    }

    public Button getBtnExit(){
        return btnExit;
    }
}
