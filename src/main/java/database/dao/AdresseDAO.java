package database.dao;

import database.bean.Pays;
import database.mapper.DatabaseMapper;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ADRESSE", schema = "APP")
@NamedQueries({
        @NamedQuery(name = "AdresseDAO.countAll", query = "SELECT COUNT(x) FROM AdresseDAO x")
})
public class AdresseDAO implements Serializable, DAO {

    private static final long serialVersionUID = 1L;

    // Clé primaire
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    // Attributs
    @Column(name = "RUE", length = 50)
    private String rue;

    @Column(name = "CP")
    private Integer cp;

    @Column(name = "VILLE", length = 30)
    private String ville;

    // Relations
    @ManyToOne
    @JoinColumn(name = "PAYS", referencedColumnName = "CODE")
    private PaysDAO pays;

    //@OneToMany(mappedBy = "adresse", targetEntity = AdherentDAO.class)
    //  private List<AdherentDAO> listAdherent;


    public AdresseDAO() {
        super();
    }

    public AdresseDAO(Integer id, String rue, Integer cp, String ville, Pays pays) {
        this.id = id;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
        this.pays = (PaysDAO) DatabaseMapper.mapBeanToDAO(pays).get();
    }

    public AdresseDAO(Integer id, String rue, Integer cp, String ville, PaysDAO pays) {
        this.id = id;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
        this.pays = pays;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getRue() {
        return this.rue;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public Integer getCp() {
        return this.cp;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getVille() {
        return this.ville;
    }

    public void setPays(PaysDAO pays) {
        this.pays = pays;
    }

    public PaysDAO getPays() {
        return this.pays;
    }

    @Override
    public String toString() {
        return "DAO - AdresseDAO{" +
                "id=" + id +
                ", rue='" + rue + '\'' +
                ", cp=" + cp +
                ", ville='" + ville + '\'' +
                ", pays=" + pays +
                //", listAdherent=" + listAdherent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdresseDAO that = (AdresseDAO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (rue != null ? !rue.equals(that.rue) : that.rue != null) return false;
        if (cp != null ? !cp.equals(that.cp) : that.cp != null) return false;
        if (ville != null ? !ville.equals(that.ville) : that.ville != null) return false;
        return pays != null ? pays.equals(that.pays) : that.pays == null;
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[]{id, rue, cp, ville, pays};
    }

}
