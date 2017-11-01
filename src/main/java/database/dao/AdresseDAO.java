package database.dao;

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

    @OneToMany(mappedBy = "adresse", targetEntity = AdherentDAO.class)
    private List<AdherentDAO> listAdherent;


    public AdresseDAO() {
        super();
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

    public void setListAdherent(List<AdherentDAO> listAdherent) {
        this.listAdherent = listAdherent;
    }

    public List<AdherentDAO> getListAdherent() {
        return this.listAdherent;
    }

    @Override
    public String toString() {
        return "DAO - AdresseDAO{" +
                "id=" + id +
                ", rue='" + rue + '\'' +
                ", cp=" + cp +
                ", ville='" + ville + '\'' +
                ", pays=" + pays +
                ", listAdherent=" + listAdherent +
                '}';
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[]{id, rue, cp, ville, pays, listAdherent};
    }

}
