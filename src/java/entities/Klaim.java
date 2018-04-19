/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pahmi
 */
@Entity
@Table(name = "KLAIM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klaim.findAll", query = "SELECT k FROM Klaim k")
    , @NamedQuery(name = "Klaim.findByIdKlaim", query = "SELECT k FROM Klaim k WHERE k.idKlaim = :idKlaim")
    , @NamedQuery(name = "Klaim.findByTglKlaim", query = "SELECT k FROM Klaim k WHERE k.tglKlaim = :tglKlaim")})
public class Klaim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_KLAIM")
    private String idKlaim;
    @Column(name = "TGL_KLAIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglKlaim;
    @JoinColumn(name = "ID_ASURANSI", referencedColumnName = "ID_ASURANSI")
    @ManyToOne(fetch = FetchType.LAZY)
    private Asuransi idAsuransi;
    @JoinColumn(name = "NO_POLIS", referencedColumnName = "NO_POLIS")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nasabah noPolis;

    public Klaim() {
    }

    public Klaim(String idKlaim) {
        this.idKlaim = idKlaim;
    }

    public String getIdKlaim() {
        return idKlaim;
    }

    public void setIdKlaim(String idKlaim) {
        this.idKlaim = idKlaim;
    }

    public Date getTglKlaim() {
        return tglKlaim;
    }

    public void setTglKlaim(Date tglKlaim) {
        this.tglKlaim = tglKlaim;
    }

    public Asuransi getIdAsuransi() {
        return idAsuransi;
    }

    public void setIdAsuransi(Asuransi idAsuransi) {
        this.idAsuransi = idAsuransi;
    }

    public Nasabah getNoPolis() {
        return noPolis;
    }

    public void setNoPolis(Nasabah noPolis) {
        this.noPolis = noPolis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKlaim != null ? idKlaim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klaim)) {
            return false;
        }
        Klaim other = (Klaim) object;
        if ((this.idKlaim == null && other.idKlaim != null) || (this.idKlaim != null && !this.idKlaim.equals(other.idKlaim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Klaim[ idKlaim=" + idKlaim + " ]";
    }
    
}
