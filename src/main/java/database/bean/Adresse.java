package database.bean;

public class Adresse implements Bean {

    private String id;
    private String rue;
    private String codePostale;
    private String ville;
    private Pays pays;

    public Adresse(String id, String rue, String codePostale, String ville, Pays pays) {
        this.id = id;
        this.rue = rue;
        this.codePostale = codePostale;
        this.ville = ville;
        this.pays = pays;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
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
    public Object[] getObjectValues() {
        return new Object[]{getId(), getRue(), getCodePostale(), getVille(), getPays()};
    }

}
