/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie5_2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author lesze
 */
@Entity
@Table(name = "pozycjemenu", catalog = "restauracja", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pozycjemenu.findAll", query = "SELECT p FROM Pozycjemenu p")
    , @NamedQuery(name = "Pozycjemenu.findByIdpozycjemenu", query = "SELECT p FROM Pozycjemenu p WHERE p.idpozycjemenu = :idpozycjemenu")
    , @NamedQuery(name = "Pozycjemenu.findByNazwa", query = "SELECT p FROM Pozycjemenu p WHERE p.nazwa = :nazwa")
    , @NamedQuery(name = "Pozycjemenu.findByCena", query = "SELECT p FROM Pozycjemenu p WHERE p.cena = :cena")})
public class Pozycjemenu implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpozycjemenu")
    private Integer idpozycjemenu;
    @Column(name = "nazwa")
    private String nazwa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cena")
    private Float cena;

    public Pozycjemenu() {
    }

    public Pozycjemenu(Integer idpozycjemenu) {
        this.idpozycjemenu = idpozycjemenu;
    }

    public Integer getIdpozycjemenu() {
        return idpozycjemenu;
    }

    public void setIdpozycjemenu(Integer idpozycjemenu) {
        Integer oldIdpozycjemenu = this.idpozycjemenu;
        this.idpozycjemenu = idpozycjemenu;
        changeSupport.firePropertyChange("idpozycjemenu", oldIdpozycjemenu, idpozycjemenu);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        String oldNazwa = this.nazwa;
        this.nazwa = nazwa;
        changeSupport.firePropertyChange("nazwa", oldNazwa, nazwa);
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        Float oldCena = this.cena;
        this.cena = cena;
        changeSupport.firePropertyChange("cena", oldCena, cena);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpozycjemenu != null ? idpozycjemenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pozycjemenu)) {
            return false;
        }
        Pozycjemenu other = (Pozycjemenu) object;
        if ((this.idpozycjemenu == null && other.idpozycjemenu != null) || (this.idpozycjemenu != null && !this.idpozycjemenu.equals(other.idpozycjemenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zadanie5_2.Pozycjemenu[ idpozycjemenu=" + idpozycjemenu + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
