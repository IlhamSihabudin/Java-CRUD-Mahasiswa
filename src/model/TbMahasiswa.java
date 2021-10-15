/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ilham Sihabudin
 */
@Entity
@Table(name = "tb_mahasiswa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMahasiswa.findAll", query = "SELECT t FROM TbMahasiswa t")
    , @NamedQuery(name = "TbMahasiswa.findByNrp", query = "SELECT t FROM TbMahasiswa t WHERE t.nrp = :nrp")
    , @NamedQuery(name = "TbMahasiswa.findByNama", query = "SELECT t FROM TbMahasiswa t WHERE t.nama = :nama")
    , @NamedQuery(name = "TbMahasiswa.findByAngkatan", query = "SELECT t FROM TbMahasiswa t WHERE t.angkatan = :angkatan")
    , @NamedQuery(name = "TbMahasiswa.findBySekolahAsal", query = "SELECT t FROM TbMahasiswa t WHERE t.sekolahAsal = :sekolahAsal")})
public class TbMahasiswa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nrp")
    private String nrp;
    @Column(name = "nama")
    private String nama;
    @Column(name = "angkatan")
    private String angkatan;
    @Column(name = "sekolah_asal")
    private String sekolahAsal;

    public TbMahasiswa() {
    }

    public TbMahasiswa(String nrp) {
        this.nrp = nrp;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getSekolahAsal() {
        return sekolahAsal;
    }

    public void setSekolahAsal(String sekolahAsal) {
        this.sekolahAsal = sekolahAsal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrp != null ? nrp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMahasiswa)) {
            return false;
        }
        TbMahasiswa other = (TbMahasiswa) object;
        if ((this.nrp == null && other.nrp != null) || (this.nrp != null && !this.nrp.equals(other.nrp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbMahasiswa[ nrp=" + nrp + " ]";
    }
    
}
