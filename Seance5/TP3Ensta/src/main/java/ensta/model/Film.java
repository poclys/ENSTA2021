package ensta.model;

public class Film {

    int id;

    String titre;

    String realisateur;

    @Override
    public String toString() {
        return "Film [id=" + id + ", realisateur=" + realisateur + ", titre=" + titre + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public Film() {
    }

    public Film(int id, String titre, String realisateur) {
        this.id = id;
        this.titre = titre;
        this.realisateur = realisateur;
    }

}