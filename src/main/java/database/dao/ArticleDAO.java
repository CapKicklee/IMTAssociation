package database.dao;

import java.io.Serializable;

import java.sql.Blob;

import javax.persistence.*;

/**
 * Table ARTICLE de la base de données.
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
@Entity
@Table(name = "ARTICLE", schema = "APP")
@NamedQueries({
        @NamedQuery(name = "ArticleDAO.countAll", query = "SELECT COUNT(x) FROM ArticleDAO x")
})
public class ArticleDAO implements Serializable, DAO {

    private static final long serialVersionUID = 1L;

    // Clé primaire
    @Id
    @Column(name = "CODE", nullable = false, length = 3)
    private String code;

    // Attributs
    @Column(name = "NOM", nullable = false, length = 30)
    private String nom;

    @Column(name = "PRIX", nullable = false)
    private Double prix;

    @Column(name = "STOCK", nullable = false)
    private Integer stock;

    @Lob
    @Column(name = "IMAGE")
    private Blob image;



    public ArticleDAO() {
        super();
    }

    public ArticleDAO(String code, String nom, Double prix, Integer stock, Blob image) {
        this.code = code;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.image = image;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Double getPrix() {
        return this.prix;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Blob getImage() {
        return this.image;
    }

    @Override
    public String toString() {
        return "DAO - ArticleDAO{" +
                "code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", stock=" + stock +
                ", image=" + image +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleDAO that = (ArticleDAO) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prix != null ? !prix.equals(that.prix) : that.prix != null) return false;
        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;
        return image != null ? image.equals(that.image) : that.image == null;
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[]{code, nom, prix, stock, image};
    }

}
