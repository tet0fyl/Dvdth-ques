package models;

public class Genre {
    public static String ID_COLNAME = "Id_Genre";
    public static String LIBELLE_COLNAME = "Libelle_Genre";

    private String id;
    private String libelle;

    public Genre(String id, String libelle) {
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
