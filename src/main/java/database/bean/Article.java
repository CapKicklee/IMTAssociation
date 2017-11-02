package database.bean;

import javax.persistence.criteria.CriteriaBuilder;

public class Article implements Bean {

    private String code;
    private String nom;
    private Double prix;
    private Integer stock;
    private String image;

    public Article(String code, String nom, Double prix, Integer stock, String image) {
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
                ", prix='" + prix + '\'' +
                ", stock='" + stock + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (code != null ? !code.equals(article.code) : article.code != null) return false;
        if (nom != null ? !nom.equals(article.nom) : article.nom != null) return false;
        if (prix != null ? !prix.equals(article.prix) : article.prix != null) return false;
        if (stock != null ? !stock.equals(article.stock) : article.stock != null) return false;
        return image != null ? image.equals(article.image) : article.image == null;
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[]{getCode(), getNom(), getPrix(), getStock(), getImage()};
    }

}
