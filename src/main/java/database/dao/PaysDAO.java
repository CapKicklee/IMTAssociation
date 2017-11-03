package database.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Table PAYS de la base de données.
 * @author Juliette FRETAY, Kendall FOREST, Chloé GUILBAUD
 */
@Entity
@Table(name = "PAYS", schema = "APP")
@NamedQueries({
        @NamedQuery(name = "PaysDAO.countAll", query = "SELECT COUNT(x) FROM PaysDAO x")
})
public class PaysDAO implements Serializable, DAO {

    private static final long serialVersionUID = 1L;

    // Clé primaire
    @Id
    @Column(name = "CODE", nullable = false, length = 2)
    private String code;

    // Attributs
    @Column(name = "NAME", nullable = false, length = 30)
    private String name;

    // Relations

    @OneToMany(mappedBy = "pays", targetEntity = AdresseDAO.class)
    private List<AdresseDAO> listAdresse;


    public PaysDAO() {
        super();
    }

    public PaysDAO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "DAO - PaysDAO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaysDAO paysDAO = (PaysDAO) o;

        if (code != null ? !code.equals(paysDAO.code) : paysDAO.code != null) return false;
        return name != null ? name.equals(paysDAO.name) : paysDAO.name == null;
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[]{code, name};
    }

}
