package models;

import java.util.ArrayList;

public class Film {
    /* C'EST VARAIBLE STATIC CORESPONDENT AUX NOM DE COLONNE DANS LA BDD */
    public static String ID_COLNAME = "Id_Film";
    public static String ID_ASSOC_COLNAME = "Film_id";
    public static String NOM_COLNAME = "Nom_Film";
    public static String ANNEE_COLNAME = "Annee_Film";
    public static String NOTE_COLNAME = "Note_Film";
    public static String CONTENT_COLNAME = "Content_Film";
    public static String IMG_COLNAME = "Img_Film";
    public static String ACTEURS_COLNAME = "acteurs";
    public static String GENRES_COLNAME = "genres";

    private String id;
    private String nom;
    private String annee;
    private String note;
    private String content;
    private String img;
    private ArrayList<Acteur> acteurs;
    private ArrayList<Genre> genres;
    private Realisateur realisateur;
    private Nationalite nationalite;

    public Film(String id, String nom, String annee, String note, String content, String img, String acteurs, String genres, Realisateur realisateur, Nationalite nationalite) {
        this.id = id;
        this.nom = nom;
        this.annee = annee;
        this.note = note;
        this.content = content;
        this.img = img;
        this.acteurs = setActeursList(acteurs);
        this.genres = setGenresList(genres);
        this.realisateur = realisateur;
        this.nationalite = nationalite;
    }

    public ArrayList<Acteur> setActeursList(String acteurs) {
        ArrayList<Acteur> acteursTmp = new ArrayList<Acteur>();

        for (String acteur : acteurs.split(",")) {
            String[] acteurDetails = acteur.split("/");
            acteursTmp.add(new Acteur(acteurDetails[0],acteurDetails[1],acteurDetails[2]));
        }
        return acteursTmp;
    }

    public ArrayList<Genre> setGenresList(String genres) {
        ArrayList<Genre> genresTmp = new ArrayList<Genre>();

        for (String genre : genres.split(",")) {
            String[] genresDetails = genre.split("/");
            genresTmp.add(new Genre(genresDetails[0],genresDetails[1]));
        }
        return genresTmp;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAnnee() {
        return annee;
    }

    public String getNote() {
        return note;
    }

    public String getContent() {
        return content;
    }

    public String getContent(byte limit) {
        if(content.length() > limit){
            return content.substring(0,limit) + "...";
        } else {
            return content;
        }
    }

    public String getImg() {
        return img;
    }

    public ArrayList<Acteur> getActeurs() {
        return acteurs;
    }

    public String getActeursToString() {
        String data = new String();
        for(Acteur acteur : acteurs) {
            data += acteur.toString() + ",";
        }
        return data.substring(0,data.length()-1);
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public String getGenresToString() {
        String data = new String();
        for(Genre genre : genres) {
            data += genre.toString() + ",";
        }
        return data.substring(0,data.length()-1);
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public Nationalite getNationalite() {
        return nationalite;
    }
}
