package database.bean;

import database.dao.AdresseDAO;
import database.mapper.BeanDaoMapper;

/**
 * Représentation objet de la table ADHERENT de la base de données.
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
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

    public Adherent(String login, String motDePasse, String nom, String prenom, AdresseDAO adressesDao) {
        this(login, motDePasse, nom, prenom, (Adresse) BeanDaoMapper.mapDAOToBean(adressesDao).getMapped().get());
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adherent adherent = (Adherent) o;

        if (login != null ? !login.equals(adherent.login) : adherent.login != null) return false;
        if (motDePasse != null ? !motDePasse.equals(adherent.motDePasse) : adherent.motDePasse != null) return false;
        if (nom != null ? !nom.equals(adherent.nom) : adherent.nom != null) return false;
        if (prenom != null ? !prenom.equals(adherent.prenom) : adherent.prenom != null) return false;
        return adresse != null ? adresse.equals(adherent.adresse) : adherent.adresse == null;
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[] {getLogin(), getMotDePasse(), getNom(), getPrenom(), getAdresse()};
    }

}
