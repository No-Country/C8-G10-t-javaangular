/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NoCountry.YouTech.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jimy
 */
@Entity
@Table(name = "broacast_medium_tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BroacastMediumTag.findAll", query = "SELECT b FROM BroacastMediumTag b")
    , @NamedQuery(name = "BroacastMediumTag.findByIdBroacastMediumTag", query = "SELECT b FROM BroacastMediumTag b WHERE b.idBroacastMediumTag = :idBroacastMediumTag")})
public class BroadcastMediumTag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_broacast_medium_tag")
    private Long idBroacastMediumTag;
    @JoinColumn(name = "id_broadcast_medium", referencedColumnName = "id_broacast_medium")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BroadcastMedium idBroadcastMedium;
    @JoinColumn(name = "id_tag", referencedColumnName = "id_tag")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tag idTag;

    public BroadcastMediumTag() {
    }

    public BroadcastMediumTag(Long idBroacastMediumTag) {
        this.idBroacastMediumTag = idBroacastMediumTag;
    }

    public Long getIdBroacastMediumTag() {
        return idBroacastMediumTag;
    }

    public void setIdBroacastMediumTag(Long idBroacastMediumTag) {
        this.idBroacastMediumTag = idBroacastMediumTag;
    }

    public BroadcastMedium getIdBroadcastMedium() {
        return idBroadcastMedium;
    }

    public void setIdBroadcastMedium(BroadcastMedium idBroadcastMedium) {
        this.idBroadcastMedium = idBroadcastMedium;
    }

    public Tag getIdTag() {
        return idTag;
    }

    public void setIdTag(Tag idTag) {
        this.idTag = idTag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBroacastMediumTag != null ? idBroacastMediumTag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BroadcastMediumTag)) {
            return false;
        }
        BroadcastMediumTag other = (BroadcastMediumTag) object;
        if ((this.idBroacastMediumTag == null && other.idBroacastMediumTag != null) || (this.idBroacastMediumTag != null && !this.idBroacastMediumTag.equals(other.idBroacastMediumTag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NoCountry.YouTech.entities.BroacastMediumTag[ idBroacastMediumTag=" + idBroacastMediumTag + " ]";
    }
    
}
