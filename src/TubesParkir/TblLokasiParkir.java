/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TubesParkir;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author thor
 */
@Entity
@Table(name = "TblLokasiParkir", catalog = "DBSmartParkir", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "TblLokasiParkir.findAll", query = "SELECT t FROM TblLokasiParkir t")
    , @NamedQuery(name = "TblLokasiParkir.findByIDLokasi", query = "SELECT t FROM TblLokasiParkir t WHERE t.iDLokasi = :iDLokasi")
    , @NamedQuery(name = "TblLokasiParkir.findByNamaLokasi", query = "SELECT t FROM TblLokasiParkir t WHERE t.namaLokasi = :namaLokasi")
    , @NamedQuery(name = "TblLokasiParkir.findByStatus", query = "SELECT t FROM TblLokasiParkir t WHERE t.status = :status")
    , @NamedQuery(name = "TblLokasiParkir.findByDeleted", query = "SELECT t FROM TblLokasiParkir t WHERE t.deleted = :deleted")})
public class TblLokasiParkir implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDLokasi")
    private String iDLokasi;
    @Column(name = "NamaLokasi")
    private String namaLokasi;
    @Lob
    @Column(name = "Keterangan")
    private String keterangan;
    @Column(name = "Status")
    private Integer status;
    @Column(name = "Deleted")
    private Integer deleted;

    public TblLokasiParkir() {
    }

    public TblLokasiParkir(String iDLokasi) {
        this.iDLokasi = iDLokasi;
    }

    public String getIDLokasi() {
        return iDLokasi;
    }

    public void setIDLokasi(String iDLokasi) {
        String oldIDLokasi = this.iDLokasi;
        this.iDLokasi = iDLokasi;
        changeSupport.firePropertyChange("IDLokasi", oldIDLokasi, iDLokasi);
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public void setNamaLokasi(String namaLokasi) {
        String oldNamaLokasi = this.namaLokasi;
        this.namaLokasi = namaLokasi;
        changeSupport.firePropertyChange("namaLokasi", oldNamaLokasi, namaLokasi);
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        String oldKeterangan = this.keterangan;
        this.keterangan = keterangan;
        changeSupport.firePropertyChange("keterangan", oldKeterangan, keterangan);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        Integer oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        Integer oldDeleted = this.deleted;
        this.deleted = deleted;
        changeSupport.firePropertyChange("deleted", oldDeleted, deleted);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDLokasi != null ? iDLokasi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblLokasiParkir)) {
            return false;
        }
        TblLokasiParkir other = (TblLokasiParkir) object;
        if ((this.iDLokasi == null && other.iDLokasi != null) || (this.iDLokasi != null && !this.iDLokasi.equals(other.iDLokasi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TubesParkir.TblLokasiParkir[ iDLokasi=" + iDLokasi + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
