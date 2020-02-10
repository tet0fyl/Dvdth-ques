package models;

public class Realisateur {

    public static String ID_COLNAME = "Id_Realisateur";
    public static String NOM_COLNAME = "Nom_Realisateur";
    public static String PRENOM_COLNAME = "Prenom_Realisateur";

    private String id;
    private String nom;
    private String prenom;

    public Realisateur(String id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }
}
