package models;

public class Nationalite {

    public static String ID_COLNAME = "Id_Nationalite";
    public static String LIBELLE_COLNAME = "Libelle_Nationalite";

    private String id;
    private String libelle;

    public Nationalite(String id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public String getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }
}
