package database.bean;

public class Adherent implements Bean {

    private String login;
    private String motDePasse;
    private String nom;
    private String prenom;
    private Adresse adresse;

    public Adherent(String login, String motDePasse, String nom, String prenom, Adresse adresse) {
        this.login = login;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "BEAN - Adherent{" +
                "login='" + login + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse=" + adresse +
                '}';
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[] {getLogin(), getMotDePasse(), getNom(), getPrenom(), getAdresse()};
    }

}
