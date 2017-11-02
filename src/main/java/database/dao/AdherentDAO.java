package database.dao;

import database.bean.Adresse;
import database.mapper.DatabaseMapper;
import org.hibernate.boot.model.relational.Database;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ADHERENT", schema = "APP")
@NamedQueries({
        @NamedQuery(name = "AdherentDAO.countAll", query = "SELECT COUNT(x) FROM AdherentDAO x")
})
public class AdherentDAO implements Serializable, DAO{

    private static final long serialVersionUID = 1L;

    // Clé primaire
    @Id
    @Column(name = "LOGIN", nullable = false, length = 30)
    private String login;

    // Attributs
    @Column(name = "MDP", nullable = false, length = 30)
    private String mdp;

    @Column(name = "NOM", nullable = false, length = 30)
    private String nom;

    @Column(name = "PRENOM", nullable = false, length = 30)
    private String prenom;

    // Relations
    @ManyToOne
    @JoinColumn(name = "ADRESSE", referencedColumnName = "ID")
    private AdresseDAO adresse;



    public AdherentDAO() {
        super();
    }

    public AdherentDAO(String login, String mdp, String nom, String prenom, Adresse adresse) {
        this.login = login;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = (AdresseDAO) DatabaseMapper.mapBeanToDAO(adresse).get();
    }

    public AdherentDAO(String login, String mdp, String nom, String prenom, AdresseDAO adresse) {
        this.login = login;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return this.login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMdp() {
        return this.mdp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setAdresse(AdresseDAO adresse) {
        this.adresse = adresse;
    }

    public AdresseDAO getAdresse() {
        return this.adresse;
    }

    @Override
    public String toString() {
        return "DAO - AdherentDAO{" +
                "login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse=" + adresse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdherentDAO that = (AdherentDAO) o;

        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (mdp != null ? !mdp.equals(that.mdp) : that.mdp != null) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        return adresse != null ? adresse.equals(that.adresse) : that.adresse == null;
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[]{login, mdp, nom, prenom, adresse};
    }

}
