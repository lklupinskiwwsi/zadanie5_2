/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie5_2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author lesze
 */
@Entity
@Table(name = "zamowienia", catalog = "restauracja", schema = "")
@NamedQueries({
    @NamedQuery(name = "Zamowienia.findAll", query = "SELECT z FROM Zamowienia z")
    , @NamedQuery(name = "Zamowienia.findByIdzamowienia", query = "SELECT z FROM Zamowienia z WHERE z.idzamowienia = :idzamowienia")
    , @NamedQuery(name = "Zamowienia.findByWartosc", query = "SELECT z FROM Zamowienia z WHERE z.wartosc = :wartosc")
    , @NamedQuery(name = "Zamowienia.findByTelefon", query = "SELECT z FROM Zamowienia z WHERE z.telefon = :telefon")
    , @NamedQuery(name = "Zamowienia.findByUlica", query = "SELECT z FROM Zamowienia z WHERE z.ulica = :ulica")
    , @NamedQuery(name = "Zamowienia.findByNumer", query = "SELECT z FROM Zamowienia z WHERE z.numer = :numer")
    , @NamedQuery(name = "Zamowienia.findByKodpocztowy", query = "SELECT z FROM Zamowienia z WHERE z.kodpocztowy = :kodpocztowy")
    , @NamedQuery(name = "Zamowienia.findByMiasto", query = "SELECT z FROM Zamowienia z WHERE z.miasto = :miasto")})
public class Zamowienia implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idzamowienia")
    private Integer idzamowienia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "wartosc")
    private Float wartosc;
    @Column(name = "telefon")
    private String telefon;
    @Column(name = "ulica")
    private String ulica;
    @Column(name = "numer")
    private String numer;
    @Column(name = "kodpocztowy")
    private String kodpocztowy;
    @Column(name = "miasto")
    private String miasto;
    @OneToMany(mappedBy = "idzamowienia")
    private List<Pozycjezamowienia> pozycjezamowieniaList;

    public Zamowienia() {
    }

    public Zamowienia(Integer idzamowienia) {
        this.idzamowienia = idzamowienia;
    }

    public Integer getIdzamowienia() {
        return idzamowienia;
    }

    public void setIdzamowienia(Integer idzamowienia) {
        Integer oldIdzamowienia = this.idzamowienia;
        this.idzamowienia = idzamowienia;
        changeSupport.firePropertyChange("idzamowienia", oldIdzamowienia, idzamowienia);
    }

    public Float getWartosc() {
        return wartosc;
    }

    public void setWartosc(Float wartosc) {
        Float oldWartosc = this.wartosc;
        this.wartosc = wartosc;
        changeSupport.firePropertyChange("wartosc", oldWartosc, wartosc);
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        String oldTelefon = this.telefon;
        this.telefon = telefon;
        changeSupport.firePropertyChange("telefon", oldTelefon, telefon);
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        String oldUlica = this.ulica;
        this.ulica = ulica;
        changeSupport.firePropertyChange("ulica", oldUlica, ulica);
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        String oldNumer = this.numer;
        this.numer = numer;
        changeSupport.firePropertyChange("numer", oldNumer, numer);
    }

    public String getKodpocztowy() {
        return kodpocztowy;
    }

    public void setKodpocztowy(String kodpocztowy) {
        String oldKodpocztowy = this.kodpocztowy;
        this.kodpocztowy = kodpocztowy;
        changeSupport.firePropertyChange("kodpocztowy", oldKodpocztowy, kodpocztowy);
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        String oldMiasto = this.miasto;
        this.miasto = miasto;
        changeSupport.firePropertyChange("miasto", oldMiasto, miasto);
    }

    public List<Pozycjezamowienia> getPozycjezamowieniaList() {
        return pozycjezamowieniaList;
    }

    public void setPozycjezamowieniaList(List<Pozycjezamowienia> pozycjezamowieniaList) {
        this.pozycjezamowieniaList = pozycjezamowieniaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idzamowienia != null ? idzamowienia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zamowienia)) {
            return false;
        }
        Zamowienia other = (Zamowienia) object;
        if ((this.idzamowienia == null && other.idzamowienia != null) || (this.idzamowienia != null && !this.idzamowienia.equals(other.idzamowienia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zadanie5_2.Zamowienia[ idzamowienia=" + idzamowienia + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
