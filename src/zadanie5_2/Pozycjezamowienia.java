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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author lesze
 */
@Entity
@Table(name = "pozycjezamowienia", catalog = "restauracja", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pozycjezamowienia.findAll", query = "SELECT p FROM Pozycjezamowienia p")
    , @NamedQuery(name = "Pozycjezamowienia.findByIdpozycjezamowienia", query = "SELECT p FROM Pozycjezamowienia p WHERE p.idpozycjezamowienia = :idpozycjezamowienia")
    , @NamedQuery(name = "Pozycjezamowienia.findByIdpozycjemenu", query = "SELECT p FROM Pozycjezamowienia p WHERE p.idpozycjemenu = :idpozycjemenu")
    , @NamedQuery(name = "Pozycjezamowienia.findByIlosc", query = "SELECT p FROM Pozycjezamowienia p WHERE p.ilosc = :ilosc")})
public class Pozycjezamowienia implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpozycjezamowienia")
    private Integer idpozycjezamowienia;
    @Column(name = "idpozycjemenu")
    private Integer idpozycjemenu;
    @Column(name = "ilosc")
    private Integer ilosc;
    @JoinColumn(name = "idzamowienia", referencedColumnName = "idzamowienia")
    @ManyToOne
    private Zamowienia idzamowienia;

    public Pozycjezamowienia() {
    }

    public Pozycjezamowienia(Integer idpozycjezamowienia) {
        this.idpozycjezamowienia = idpozycjezamowienia;
    }

    public Integer getIdpozycjezamowienia() {
        return idpozycjezamowienia;
    }

    public void setIdpozycjezamowienia(Integer idpozycjezamowienia) {
        Integer oldIdpozycjezamowienia = this.idpozycjezamowienia;
        this.idpozycjezamowienia = idpozycjezamowienia;
        changeSupport.firePropertyChange("idpozycjezamowienia", oldIdpozycjezamowienia, idpozycjezamowienia);
    }

    public Integer getIdpozycjemenu() {
        return idpozycjemenu;
    }

    public void setIdpozycjemenu(Integer idpozycjemenu) {
        Integer oldIdpozycjemenu = this.idpozycjemenu;
        this.idpozycjemenu = idpozycjemenu;
        changeSupport.firePropertyChange("idpozycjemenu", oldIdpozycjemenu, idpozycjemenu);
    }

    public Integer getIlosc() {
        return ilosc;
    }

    public void setIlosc(Integer ilosc) {
        Integer oldIlosc = this.ilosc;
        this.ilosc = ilosc;
        changeSupport.firePropertyChange("ilosc", oldIlosc, ilosc);
    }

    public Zamowienia getIdzamowienia() {
        return idzamowienia;
    }

    public void setIdzamowienia(Zamowienia idzamowienia) {
        Zamowienia oldIdzamowienia = this.idzamowienia;
        this.idzamowienia = idzamowienia;
        changeSupport.firePropertyChange("idzamowienia", oldIdzamowienia, idzamowienia);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpozycjezamowienia != null ? idpozycjezamowienia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pozycjezamowienia)) {
            return false;
        }
        Pozycjezamowienia other = (Pozycjezamowienia) object;
        if ((this.idpozycjezamowienia == null && other.idpozycjezamowienia != null) || (this.idpozycjezamowienia != null && !this.idpozycjezamowienia.equals(other.idpozycjezamowienia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zadanie5_2.Pozycjezamowienia[ idpozycjezamowienia=" + idpozycjezamowienia + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
