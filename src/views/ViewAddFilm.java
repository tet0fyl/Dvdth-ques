package views;

import controllers.ControllerAddFilm;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import models.Realisateur;

import java.util.ArrayList;

public class ViewAddFilm {
    private FlowPane root;
    private VBox vBoxContainer;
    private FlowPane hBoxCotainerFormulaire;
    private ScrollPane scrollPane;
    private Text titleNouveaute;
    private HBox hBoxTitle = new HBox();
    private Button btn;


    //TODO: Sortir toute les elements
    private TextField anneeFilm;
    private ChoiceBox boxRealisateur;


    public ViewAddFilm(FlowPane root) {
        this.root = root;
        vBoxContainer = new VBox();
        scrollPane = new ScrollPane();
        titleNouveaute = new Text("Insertion : ");
        titleNouveaute.setFont(Font.font("Arial", FontWeight.BOLD,15));
        hBoxTitle.getChildren().add(titleNouveaute);

        vBoxContainer.minWidthProperty().bind(root.widthProperty());
        vBoxContainer.maxWidthProperty().bind(root.widthProperty());
        hBoxCotainerFormulaire = new FlowPane();
        hBoxCotainerFormulaire.setVgap(20);
        hBoxCotainerFormulaire.setHgap(20);
        hBoxCotainerFormulaire.setPadding(new Insets(10));
        hBoxCotainerFormulaire.setAlignment(Pos.CENTER);
        hBoxCotainerFormulaire.minWidthProperty().bind(vBoxContainer.widthProperty());
        hBoxCotainerFormulaire.maxWidthProperty().bind(vBoxContainer.widthProperty());
        scrollPane.prefHeightProperty().bind(Bindings.divide(root.heightProperty(),1.5));
        scrollPane.maxWidthProperty().bind(vBoxContainer.widthProperty());
        scrollPane.minWidthProperty().bind(vBoxContainer.widthProperty());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setContent(hBoxCotainerFormulaire);

        vBoxContainer.minHeightProperty().bind(root.heightProperty());

        initDuFormulaire();


    }

    public void clearAndInitRoot(ViewHeader viewHeader) {
        root.getChildren().clear();
        vBoxContainer.getChildren().add(viewHeader.getHeader());
        vBoxContainer.getChildren().addAll(hBoxTitle,scrollPane);
        root.getChildren().add(vBoxContainer);
    }


    public void updateRealisateurField(ArrayList<Realisateur> listReal){
        ObservableList<Realisateur> list = FXCollections.observableArrayList(listReal);
        boxRealisateur.setItems(list);
    }

    public void updateActeurField(){

    }

    public void initDuFormulaire(){

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10,5,5,5));
        VBox vBoxDetails = new VBox();
        vBoxDetails.setSpacing(15);
        vBoxDetails.setPadding(new Insets(10,5,5,5));
        VBox vBoxSaisi = new VBox();
        vBoxSaisi.setSpacing(10);
        vBoxSaisi.setPadding(new Insets(10,5,5,5));
        HBox hBox = new HBox();
        vBox.setMaxWidth(300);
        vBox.setAlignment(Pos.CENTER);
        Label txtTitle = new Label("NOM DU FILM:");
        txtTitle.setFont(Font.font(15));
        txtTitle.setWrapText(true);
        TextField nomFilm = new TextField();


        Label txtAnnee = new Label("ANNEE DU FILM:");
        txtAnnee.setFont(Font.font(15));
        txtAnnee.setWrapText(true);
        anneeFilm = new TextField();


        Label txtNote = new Label("NOTE:");
        txtNote.setFont(Font.font(15));
        txtNote.setWrapText(true);
        TextField noteFilm = new TextField();


        Label txtDesc = new Label("DESCRIPTION:");
        txtDesc.setFont(Font.font(15));
        txtDesc.setWrapText(true);
        TextArea descriptionFilm = new TextArea();
        descriptionFilm.setLayoutX(60);
        descriptionFilm.setLayoutY(20);


        Label txtNationalte = new Label("NATIONALITE:");
        txtNationalte.setFont(Font.font(15));
        txtNationalte.setWrapText(true);
        TextField Nationalite = new TextField();

        Label ChoixReal = new Label("REALISATEUR:");
        ChoixReal.setFont(Font.font(15));
        ChoixReal.setWrapText(true);
        boxRealisateur = new ChoiceBox();

        Label txtNomRealis = new Label("NOM REALISATEUR:");
        txtNomRealis.setFont(Font.font(15));
        txtNomRealis.setWrapText(true);
        TextField nomREAL = new TextField();


        Label txtPrenom = new Label("PRENOM REALISATEUR:");
        txtPrenom.setFont(Font.font(15));
        txtPrenom.setWrapText(true);
        TextField prenomREAL = new TextField();


        Label txtNomActeur = new Label("NOM ACTEUR:");
        txtNomActeur.setFont(Font.font(15));
        txtNomActeur.setWrapText(true);
        TextField NomActeur = new TextField();


        Label txtPrenomActeur = new Label("PRENOM ACTEUR:");
        txtPrenomActeur.setFont(Font.font(15));
        txtPrenomActeur.setWrapText(true);
        TextField PrenomActeur = new TextField();

        Label txtGenre = new Label(" GENRE:");
        txtGenre.setFont(Font.font(15));
        txtGenre.setWrapText(true);
        TextField Genre = new TextField();


        Label txtImage = new Label("IMAGE DU FILM:");
        txtImage.setFont(Font.font(15));
        txtImage.setWrapText(true);
        TextField image = new TextField();




        btn = new Button("envoyer");



        vBoxDetails.getChildren().addAll(txtTitle,txtAnnee,txtNote,txtNationalte, ChoixReal,txtNomRealis,txtPrenom,txtNomActeur,txtPrenomActeur,txtGenre,txtImage,txtDesc);
        vBoxSaisi.getChildren().addAll(nomFilm,anneeFilm,noteFilm,Nationalite,boxRealisateur,nomREAL,prenomREAL,NomActeur,PrenomActeur,Genre,image,descriptionFilm,btn);
        hBox.getChildren().addAll(vBoxDetails,vBoxSaisi);
        vBox.getChildren().add(hBox);
        vBox.maxWidthProperty().bind(root.widthProperty());
        vBox.minWidthProperty().bind(root.widthProperty());
        hBoxCotainerFormulaire.getChildren().add(vBox);
        btn.setOnAction(event -> {

            String valeurimage = image.getText();
            String valeurGenre = Genre.getText();
            String valeurPrenomActeur = PrenomActeur.getText();
            String valeurNomacteur = NomActeur.getText();
            String valeurprenomReal = prenomREAL.getText();
            String valeurRealisateur = nomREAL.getText();
            String valeurNationalite = Nationalite.getText();
            String valeurDescrip = descriptionFilm.getText();
            String valeurNF = nomFilm.getText();

            if (noteFilm.getText()!= null) {
                int valeurNote = Integer.parseInt(noteFilm.getText());
            }


        });


    }


        public void setEvent(ControllerAddFilm controllerAddFilm){
                btn.setOnMouseClicked(controllerAddFilm);
        }

    public FlowPane getRoot(){
        return root;
    }

    public Button getBtn(){
        return btn;
    }

    //TODO: mettre tout les getters ici
    public TextField getAnneeFilm(){
        return anneeFilm;
    }

}
