package database.dao;

import java.io.Serializable;

import java.util.List;

import javax.persistence.*;

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

    public void setListAdresse(List<AdresseDAO> listAdresse) {
        this.listAdresse = listAdresse;
    }

    public List<AdresseDAO> getListAdresse() {
        return this.listAdresse;
    }

    @Override
    public String toString() {
        return "DAO - PaysDAO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", listAdresse=" + listAdresse +
                '}';
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[]{code, name, listAdresse};
    }

}
