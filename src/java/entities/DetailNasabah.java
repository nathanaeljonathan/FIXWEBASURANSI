/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Medina
 */
@Entity
@Table(name = "DETAIL_NASABAH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailNasabah.findAll", query = "SELECT d FROM DetailNasabah d")
    , @NamedQuery(name = "DetailNasabah.findByIdDetail", query = "SELECT d FROM DetailNasabah d WHERE d.idDetail = :idDetail")
    , @NamedQuery(name = "DetailNasabah.findBySaldo", query = "SELECT d FROM DetailNasabah d WHERE d.saldo = :saldo")})
public class DetailNasabah implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DETAIL")
    private String idDetail;
    @Column(name = "SALDO")
    private BigInteger saldo;
    @JoinColumn(name = "ID_ASURANSI", referencedColumnName = "ID_ASURANSI")
    @ManyToOne(fetch = FetchType.LAZY)
    private Asuransi idAsuransi;
    @JoinColumn(name = "NO_POLIS", referencedColumnName = "NO_POLIS")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nasabah noPolis;

    public DetailNasabah() {
    }

    public DetailNasabah(String idDetail) {
        this.idDetail = idDetail;
    }

    public String getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(String idDetail) {
        this.idDetail = idDetail;
    }

    public BigInteger getSaldo() {
        return saldo;
    }

    public void setSaldo(BigInteger saldo) {
        this.saldo = saldo;
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
        hash += (idDetail != null ? idDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailNasabah)) {
            return false;
        }
        DetailNasabah other = (DetailNasabah) object;
        if ((this.idDetail == null && other.idDetail != null) || (this.idDetail != null && !this.idDetail.equals(other.idDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetailNasabah[ idDetail=" + idDetail + " ]";
    }
    
}
