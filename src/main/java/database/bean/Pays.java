package database.bean;

public class Pays implements Bean {

    private String code;
    private String nom;

    public Pays(String code, String nom) {
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
        return "BEAN - Pays{" +
                "code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[]{getCode(), getNom()};
    }

}

