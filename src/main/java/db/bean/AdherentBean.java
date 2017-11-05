package db.bean;

import db.dao.AdresseDAO;
import db.mapper.BeanDaoMapper;

/**
 * Représentation objet de la table ADHERENT de la base de données.
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class AdherentBean implements Bean {

    private String login;
    private String motDePasse;
    private String nom;
    private String prenom;
    private AdresseBean adresseBean;

    public AdherentBean(String login, String motDePasse, String nom, String prenom, AdresseBean adresseBean) {
        this.login = login;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseBean = adresseBean;
    }

    public AdherentBean(String login, String motDePasse, String nom, String prenom, AdresseDAO adressesDao) {
        this(login, motDePasse, nom, prenom, (AdresseBean) BeanDaoMapper.mapDAOToBean(adressesDao).getMapped().get());
    }
    
    public AdherentBean() {
    	
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

    public AdresseBean getAdresse() {
        return adresseBean;
    }

    public void setAdresse(AdresseBean adresseBean) {
        this.adresseBean = adresseBean;
    }

    @Override
    public String toString() {
        return "BEAN - AdherentBean{" +
                "login='" + login + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresseBean=" + adresseBean +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdherentBean adherentBean = (AdherentBean) o;

        if (login != null ? !login.equals(adherentBean.login) : adherentBean.login != null) return false;
        if (motDePasse != null ? !motDePasse.equals(adherentBean.motDePasse) : adherentBean.motDePasse != null) return false;
        if (nom != null ? !nom.equals(adherentBean.nom) : adherentBean.nom != null) return false;
        if (prenom != null ? !prenom.equals(adherentBean.prenom) : adherentBean.prenom != null) return false;
        return adresseBean != null ? adresseBean.equals(adherentBean.adresseBean) : adherentBean.adresseBean == null;
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[] {getLogin(), getMotDePasse(), getNom(), getPrenom(), getAdresse()};
    }

}
