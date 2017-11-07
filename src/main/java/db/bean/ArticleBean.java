package db.bean;

/**
 * Représentation objet de la table ARTICLE de la base de données.
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
public class ArticleBean implements Bean{

    private String code;
    private String nom;
    private String description;
    private Double prix;
    private Integer stock;
    private String image;

    public ArticleBean(String code, String nom, String description, Double prix, Integer stock, String image) {
        this.code = code;
        this.nom = nom;
        this.description=description;
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
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
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
                ", description='" + description + '\'' +
                ", prix='" + prix + '\'' +
                ", stock='" + stock + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleBean that = (ArticleBean) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (prix != null ? !prix.equals(that.prix) : that.prix != null) return false;
        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;
        return image != null ? image.equals(that.image) : that.image == null;
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[]{getCode(), getNom(), getDescription(), getPrix(), getStock(), getImage()};
    }


}
