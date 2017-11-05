package db.bean;

import db.dao.PaysDAO;
import db.mapper.BeanDaoMapper;

/**
 * Représentation objet de la table ADRESSE de la base de données.
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class AdresseBean implements Bean {

    private Integer id;
    private String rue;
    private Integer codePostale;
    private String ville;
    private PaysBean paysBean;
    //private List<AdherentBean> listAdherent;

    public AdresseBean(Integer id, String rue, Integer codePostale, String ville, PaysBean paysBean) {
        this.id = id;
        this.rue = rue;
        this.codePostale = codePostale;
        this.ville = ville;
        this.paysBean = paysBean;
    }

    public AdresseBean(Integer id, String rue, Integer codePostale, String ville, PaysDAO paysDAO) {
        this(id, rue, codePostale, ville, (PaysBean) BeanDaoMapper.mapDAOToBean(paysDAO).getMapped().get());
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

    public PaysBean getPays() {
        return paysBean;
    }

    public void setPays(PaysBean paysBean) {
        this.paysBean = paysBean;
    }

    @Override
    public String toString() {
        return "BEAN - AdresseBean{" +
                "id='" + id + '\'' +
                ", rue='" + rue + '\'' +
                ", codePostale='" + codePostale + '\'' +
                ", ville='" + ville + '\'' +
                ", paysBean=" + paysBean +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdresseBean adresseBean = (AdresseBean) o;

        if (id != null ? !id.equals(adresseBean.id) : adresseBean.id != null) return false;
        if (rue != null ? !rue.equals(adresseBean.rue) : adresseBean.rue != null) return false;
        if (codePostale != null ? !codePostale.equals(adresseBean.codePostale) : adresseBean.codePostale != null) return false;
        if (ville != null ? !ville.equals(adresseBean.ville) : adresseBean.ville != null) return false;
        return paysBean != null ? paysBean.equals(adresseBean.paysBean) : adresseBean.paysBean == null;
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[]{getId(), getRue(), getCodePostale(), getVille(), getPays()};
    }

}
