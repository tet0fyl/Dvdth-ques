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
import tools.Config;

public class ViewHeader {
        private FlowPane root;
        private VBox hBoxHeader; // Conteneur du Header
        private HBox hBoxLogo; // Conteneur du Logo
        private ImageView imgNameLogo; // img logo
        private FlowPane flowPaneNavBar; // Conteneur de la Nav Bar
        private Button btnHome, btnListFilm, btnAddFilm,btnExit; // Btn de la Nav Bar


        public ViewHeader(FlowPane root){
            this.root = root;
            imgNameLogo = new ImageView(Config.urlImgFullLogo);

            /* INITIALISATION DES BOXS */
            hBoxHeader = new VBox();
            hBoxLogo = new HBox();
            flowPaneNavBar = new FlowPane();

            /* INITIALISATION DES BUTTONS ET AJOUT DANS LE CONTENEUR NAVBAR */
            btnHome = new Button("HOME");
            btnListFilm = new Button("LISTE");
            btnAddFilm = new Button("ADD FILM");
            btnExit = new Button("EXIT");
            flowPaneNavBar.setAlignment(Pos.CENTER);
            flowPaneNavBar.setHgap(5);
            flowPaneNavBar.setVgap(5);
            flowPaneNavBar.getChildren().addAll(btnHome,btnListFilm,btnAddFilm,btnExit);

            /* AJOUT DU LOGO DANS LA HBOXLOGO   */
            imgNameLogo.fitWidthProperty().bind(hBoxLogo.widthProperty()); // .bind() permet de redimensionner l'image en suivant la taille de l'objet que l'on met dedans, dans notre cas c'est la hBoxLogo
            imgNameLogo.setPreserveRatio(true);
            hBoxLogo.setMaxWidth(300); // permet de stoper le redimensionnement du logo a 300px
            hBoxLogo.setMinWidth(100); // permet de stoper le redimensionnement du logo a 100px
            VBox.setMargin(hBoxLogo, new Insets(0,50,0,50)); // permet de mettre une marge sur le hBoxLogo
            hBoxLogo.getChildren().add(imgNameLogo);

            /* PREPARATION DU CONTENEUR HEADER ET AJOUT DU LOGO */
            hBoxHeader.setPadding(new Insets(0,0,10,0)); // permet de mettre un pading dans le header
            hBoxHeader.minWidthProperty().bind(root.widthProperty()); // redimensionnement auto du header avec le FlowPane root
            hBoxHeader.maxWidthProperty().bind(root.widthProperty()); // on ne peut pas redimensionner les hbox et vbox directement du coup j'ai jouer avec le minWidth et maxWidth
            hBoxHeader.setAlignment(Pos.CENTER);
            hBoxHeader.minHeightProperty().bind(Bindings.divide(root.heightProperty(),4.5));// redimentionement auto du header par rapport a la hauteur du root / 4.5
            hBoxHeader.getChildren().addAll(hBoxLogo,flowPaneNavBar);
        }

    /**
     * List les evenemnts au click des Btn de la NavBar
     * @param controllerHeader
     */
    public void setEvent(ControllerHeader controllerHeader){
            btnListFilm.setOnMouseClicked(controllerHeader);
            btnHome.setOnMouseClicked(controllerHeader);
            btnAddFilm.setOnMouseClicked(controllerHeader);
            btnExit.setOnMouseClicked(controllerHeader);
        }

        /*  GETTER  */
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
