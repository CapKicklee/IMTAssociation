package database.bean;

public class Article implements Bean {

    private String code;
    private String nom;
    private String prix;
    private String stock;
    private String image;

    public Article(String code, String nom, String prix, String stock, String image) {
        this.code = code;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.image = image;
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

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "BEAN - Article{" +
                "code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", prix='" + prix + '\'' +
                ", stock='" + stock + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[]{getCode(), getNom(), getPrix(), getStock(), getImage()};
    }

}
