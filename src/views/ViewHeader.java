package views;


import controllers.ControllerHeader;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import tools.Config;

public class ViewHeader {
        private FlowPane root;
        private VBox vBoxContainer;
        private VBox hBoxHeader;
        private FlowPane flowPaneNavBar;
        private Button btnHome, btnListFilm, btnAddFilm,btnExit;
        private ImageView imgNameLogo = new ImageView(Config.urlImgFullLogo);
        private HBox hBoxLogo;
        private HBox hBoxTitle = new HBox(new Text("Dernier ajout :"));


        public ViewHeader(FlowPane root){
            this.root = root;
            vBoxContainer = new VBox();
            hBoxHeader = new VBox();
            hBoxLogo = new HBox();
            flowPaneNavBar = new FlowPane();
            btnHome = new Button("HOME");
            btnListFilm = new Button("LISTE");
            btnAddFilm = new Button("ADD FILM");
            btnExit = new Button("EXIT");
            hBoxTitle.setSpacing(20);
            imgNameLogo.fitWidthProperty().bind(hBoxLogo.widthProperty());
            imgNameLogo.setPreserveRatio(true);
            hBoxLogo.getChildren().add(imgNameLogo);
            hBoxLogo.setMaxWidth(300);
            hBoxLogo.setMinWidth(100);
            VBox.setMargin(hBoxLogo, new Insets(0,50,0,50));

            hBoxHeader.setAlignment(Pos.CENTER);
            flowPaneNavBar.setAlignment(Pos.CENTER);
            flowPaneNavBar.setHgap(5);
            flowPaneNavBar.setVgap(5);
            hBoxHeader.setPadding(new Insets(0,0,10,0));
            hBoxHeader.minWidthProperty().bind(root.widthProperty());
            hBoxHeader.maxWidthProperty().bind(root.widthProperty());


            flowPaneNavBar.getChildren().addAll(btnHome,btnListFilm,btnAddFilm,btnExit);
            hBoxHeader.getChildren().addAll(hBoxLogo,flowPaneNavBar);
            hBoxHeader.minHeightProperty().bind(Bindings.divide(root.heightProperty(),4.5));


        }

        public void setEvent(ControllerHeader controllerHeader){
            btnListFilm.setOnMouseClicked(controllerHeader);
            btnHome.setOnMouseClicked(controllerHeader);
            btnAddFilm.setOnMouseClicked(controllerHeader);
            btnExit.setOnMouseClicked(controllerHeader);
        }

        public VBox getHeader(){
            return hBoxHeader;
        }

        public Button getBtnHome() {
        return btnHome;
    }

        public Button getBtnExit() {
            return btnExit;
        }

        public Button getBtnListFilm() {
            return btnListFilm;
        }

        public Button getBtnAddFilm() {
        return btnAddFilm;
    }
}
