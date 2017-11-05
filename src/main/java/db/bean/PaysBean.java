package db.bean;

/**
 * Représentation objet de la table PAYS de la base de données.
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class PaysBean implements Bean {

    private String code;
    private String nom;

    public PaysBean(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "BEAN - PaysBean{" +
                "code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaysBean paysBean = (PaysBean) o;

        if (code != null ? !code.equals(paysBean.code) : paysBean.code != null) return false;
        return nom != null ? nom.equals(paysBean.nom) : paysBean.nom == null;
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[]{getCode(), getNom()};
    }

}

