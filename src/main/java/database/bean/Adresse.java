package database.bean;

import database.dao.PaysDAO;
import database.mapper.BeanDaoMapper;

/**
 * Représentation objet de la table ADRESSE de la base de données.
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class Adresse implements Bean {

    private Integer id;
    private String rue;
    private Integer codePostale;
    private String ville;
    private Pays pays;
    //private List<Adherent> listAdherent;

    public Adresse(Integer id, String rue, Integer codePostale, String ville, Pays pays) {
        this.id = id;
        this.rue = rue;
        this.codePostale = codePostale;
        this.ville = ville;
        this.pays = pays;
    }

    public Adresse(Integer id, String rue, Integer codePostale, String ville, PaysDAO paysDAO) {
        this(id, rue, codePostale, ville, (Pays) BeanDaoMapper.mapDAOToBean(paysDAO).get());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Integer getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(Integer codePostale) {
        this.codePostale = codePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "BEAN - Adresse{" +
                "id='" + id + '\'' +
                ", rue='" + rue + '\'' +
                ", codePostale='" + codePostale + '\'' +
                ", ville='" + ville + '\'' +
                ", pays=" + pays +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adresse adresse = (Adresse) o;

        if (id != null ? !id.equals(adresse.id) : adresse.id != null) return false;
        if (rue != null ? !rue.equals(adresse.rue) : adresse.rue != null) return false;
        if (codePostale != null ? !codePostale.equals(adresse.codePostale) : adresse.codePostale != null) return false;
        if (ville != null ? !ville.equals(adresse.ville) : adresse.ville != null) return false;
        return pays != null ? pays.equals(adresse.pays) : adresse.pays == null;
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[]{getId(), getRue(), getCodePostale(), getVille(), getPays()};
    }

}
