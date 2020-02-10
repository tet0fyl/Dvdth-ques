package models;

public class Acteur {
    public static String ID_COLNAME = "Id_Acteur";
    public static String NOM_COLNAME = "Nom_Acteur";
    public static String PRENOM_COLNAME = "Prenom_Acteur";

    private String id;
    private String nom;
    private String prenom;

    public Acteur(String id, String nom, String prenom) {
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
        return  prenom + " " + nom;
    }
}
