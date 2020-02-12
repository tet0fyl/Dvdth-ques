package views;

import controllers.ControllerAddFilm;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import tools.Config;

import java.io.File;
import java.util.ArrayList;

public class ViewAddFilm {
    private FlowPane root;
    private VBox vBoxContainer;
    private FlowPane hBoxCotainerFormulaire;
    private ScrollPane scrollPane;
    private Text titleNouveaute;
    private HBox hBoxTitle = new HBox();
    private Button btnSubmit;

    /* ELEM DU FORMULAIRE */
    private ChoiceBox choiceBoxNote;
    private TextArea descriptionFilm;
    private TextField txtFieldAnneeFilm, txtFieldNomFilm,txtFieldNationalite, txtFieldNomRealisateur,txtFieldPrenomRealisateur, txtFieldNomActeur, txtFieldPrenomActeur, txtFieldGenre;
    private VBox vBoxAddActeur, vBoxAddGenre;
    private Button btnUploadFile, btnAddGenre, btnAddActeur;


    public ViewAddFilm(FlowPane root) {
        this.root = root;
        vBoxContainer = new VBox();
        scrollPane = new ScrollPane();
        titleNouveaute = new Text("Insertion : ");
        ImageView imgPlus = new ImageView(Config.urlIconePlus);
        ImageView imgPlus2 = new ImageView(Config.urlIconePlus);
        imgPlus.setFitWidth(8);
        imgPlus2.setFitWidth(8);
        imgPlus.setPreserveRatio(true);
        imgPlus2.setPreserveRatio(true);
        btnAddActeur = new Button();
        btnAddActeur.setGraphic(imgPlus);
        btnAddGenre = new Button();
        btnAddGenre.setGraphic(imgPlus2);
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

    public void addSuplementaireActorField(){

    }

    public void addSuplementaireGenreField(){

    }

    public void initDuFormulaire(){

        VBox vBoxFormulaire = new VBox();

        /* CHAMPS NOM FILM */
        HBox hBoxNomFilm = new HBox();
        Label lblNomFilm = new Label("NOM DU FILM:");
        lblNomFilm.setFont(Font.font(15));
        lblNomFilm.setWrapText(true);
        txtFieldNomFilm = new TextField();
        hBoxNomFilm.getChildren().addAll(lblNomFilm, txtFieldNomFilm);

        /* CHAMPS ANNEE */
        HBox hBoxAnne = new HBox();
        Label lblAnnee = new Label("ANNEE DU FILM:");
        lblAnnee.setFont(Font.font(15));
        lblAnnee.setWrapText(true);
        txtFieldAnneeFilm = new TextField();
        hBoxAnne.getChildren().addAll(lblAnnee, txtFieldAnneeFilm);

        /* CHAMPS NOTE */
        HBox hBoxNote = new HBox();
        Label lblNote = new Label("NOTE:");
        lblNote.setFont(Font.font(15));
        lblNote.setWrapText(true);
        ArrayList<Integer>listNote = new ArrayList<Integer>();
        listNote.add(0);
        listNote.add(1);
        listNote.add(2);
        listNote.add(3);
        listNote.add(4);
        listNote.add(5);
        ObservableList<Integer> list = FXCollections.observableArrayList(listNote);
        choiceBoxNote = new ChoiceBox();
        choiceBoxNote.setItems(list);
        hBoxNote.getChildren().addAll(lblNote, choiceBoxNote);

        /* CHAMPS DESCRIPTION */
        HBox hBoxDescription = new HBox();
        Label lblDescription = new Label("DESCRIPTION:");
        lblDescription.setFont(Font.font(15));
        lblDescription.setWrapText(true);
        descriptionFilm = new TextArea();
        hBoxDescription.getChildren().addAll(lblDescription,descriptionFilm);

        /* CHAMPS NATIONALITE */
        HBox hBoxNationalite = new HBox();
        Label lblNationalite = new Label("NATIONALITE:");
        lblNationalite.setFont(Font.font(15));
        lblNationalite.setWrapText(true);
        txtFieldNationalite = new TextField();
        hBoxNationalite.getChildren().addAll(lblNationalite,txtFieldNationalite);

        /* CHAMPS REALISATEUR */
        HBox hBoxRealisateur = new HBox();
        Label lblRealisateur = new Label("REALISATEUR:");
        lblRealisateur.setFont(Font.font(15));
        lblRealisateur.setWrapText(true);
        txtFieldNomRealisateur = new TextField();
        txtFieldNomRealisateur.setPromptText("Nom");
        txtFieldPrenomRealisateur = new TextField();
        txtFieldPrenomRealisateur.setPromptText("Prénom");
        hBoxRealisateur.getChildren().addAll(lblRealisateur,txtFieldNomRealisateur,txtFieldPrenomRealisateur);

        /* CHAMPS ACTEURS */
        vBoxAddActeur = new VBox();
        HBox hBoxFieldActeur = new HBox();
        HBox hBoxActeur = new HBox();
        Label lblActeur = new Label("ACTEUR:");
        lblActeur.setFont(Font.font(15));
        lblActeur.setWrapText(true);
        txtFieldNomActeur = new TextField();
        txtFieldNomActeur.setPromptText("Nom");
        txtFieldPrenomActeur = new TextField();
        txtFieldPrenomActeur.setPromptText("Prenom");
        hBoxFieldActeur.getChildren().addAll(txtFieldNomActeur,txtFieldPrenomActeur);
        vBoxAddActeur.getChildren().add(hBoxFieldActeur);
        hBoxActeur.getChildren().addAll(lblActeur,txtFieldNomActeur,vBoxAddActeur,btnAddActeur);

        /* CHAMPS GENRES */
        vBoxAddGenre = new VBox();
        HBox hBoxGenre = new HBox();
        Label lblGenre = new Label(" GENRE:");
        lblGenre.setFont(Font.font(15));
        lblGenre.setWrapText(true);
        txtFieldGenre = new TextField();
        vBoxAddGenre.getChildren().add(txtFieldGenre);
        hBoxGenre.getChildren().addAll(lblGenre,vBoxAddGenre,btnAddGenre);

        /* IMAGE AFFICHE */
        HBox hBoxImgFilm = new HBox();
        Label lblImgFil = new Label("ImageFilm");
        lblGenre.setFont(Font.font(15));
        lblGenre.setWrapText(true);
        //selectedFile = new File();
        btnUploadFile = new Button("Upload File");
        hBoxImgFilm.getChildren().addAll(lblImgFil,btnUploadFile);

        /* BTN SUBMIT */
        btnSubmit = new Button("ENVOYER");

        vBoxFormulaire.getChildren().addAll(hBoxNomFilm,hBoxAnne,hBoxNote,hBoxRealisateur,hBoxActeur,hBoxDescription,hBoxGenre,hBoxImgFilm,btnSubmit);
        scrollPane.setContent(vBoxFormulaire);

    }

    public void setEvent(ControllerAddFilm controllerAddFilm){
        btnUploadFile.setOnMouseClicked(controllerAddFilm);
        btnSubmit.setOnMouseClicked(controllerAddFilm);
    }

    //TODO: mettre tout les getters ici
    public FlowPane getRoot(){
        return root;
    }

    public VBox getvBoxContainer() {
        return vBoxContainer;
    }

    public FlowPane gethBoxCotainerFormulaire() {
        return hBoxCotainerFormulaire;
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public Text getTitleNouveaute() {
        return titleNouveaute;
    }

    public HBox gethBoxTitle() {
        return hBoxTitle;
    }

    public Button getBtnSubmit() {
        return btnSubmit;
    }

    public ChoiceBox getChoiceBoxNote() {
        return choiceBoxNote;
    }

    public TextArea getDescriptionFilm() {
        return descriptionFilm;
    }

    public TextField getTxtFieldAnneeFilm() {
        return txtFieldAnneeFilm;
    }

    public TextField getTxtFieldNomFilm() {
        return txtFieldNomFilm;
    }

    public TextField getTxtFieldNationalite() {
        return txtFieldNationalite;
    }

    public TextField getTxtFieldNomRealisateur() {
        return txtFieldNomRealisateur;
    }

    public TextField getTxtFieldPrenomRealisateur() {
        return txtFieldPrenomRealisateur;
    }

    public TextField getTxtFieldNomActeur() {
        return txtFieldNomActeur;
    }

    public TextField getTxtFieldPrenomActeur() {
        return txtFieldPrenomActeur;
    }

    public TextField getTxtFieldGenre() {
        return txtFieldGenre;
    }

    public VBox getvBoxAddActeur() {
        return vBoxAddActeur;
    }

    public VBox getvBoxAddGenre() {
        return vBoxAddGenre;
    }

    public Button getBtnUploadFile(){
        return btnUploadFile;
    }

    public Button getBtnAddGenre() {
        return btnAddGenre;
    }

    public Button getBtnAddActeur() {
        return btnAddActeur;
    }
}
