/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NoCountry.YouTech.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jimy
 */
@Entity
@Table(name = "broacast_medium")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BroacastMedium.findAll", query = "SELECT b FROM BroacastMedium b")
    , @NamedQuery(name = "BroacastMedium.findByIdBroacastMedium", query = "SELECT b FROM BroacastMedium b WHERE b.idBroacastMedium = :idBroacastMedium")
    , @NamedQuery(name = "BroacastMedium.findByUrImage", query = "SELECT b FROM BroacastMedium b WHERE b.urImage = :urImage")
    , @NamedQuery(name = "BroacastMedium.findByName", query = "SELECT b FROM BroacastMedium b WHERE b.name = :name")
    , @NamedQuery(name = "BroacastMedium.findByDescription", query = "SELECT b FROM BroacastMedium b WHERE b.description = :description")
    , @NamedQuery(name = "BroacastMedium.findByUrl", query = "SELECT b FROM BroacastMedium b WHERE b.url = :url")
    , @NamedQuery(name = "BroacastMedium.findByStatus", query = "SELECT b FROM BroacastMedium b WHERE b.status = :status")})
public class BroadcastMedium implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_broacast_medium")
    private Integer idBroacastMedium;
    @Basic(optional = false)
    @Column(name = "ur_image")
    private String urImage;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "id_broadcast_type", referencedColumnName = "id_broadcast_type")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BroadcastType idBroadcastType;
    @JoinColumn(name = "id_content_creator", referencedColumnName = "id_content_creator")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ContentCreator idContentCreator;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBroadcastMedium", fetch = FetchType.LAZY)
    private List<BroadcastMediumTag> broadcastMediumTagList;

    public BroadcastMedium() {
    }

    public BroadcastMedium(Integer idBroacastMedium) {
        this.idBroacastMedium = idBroacastMedium;
    }

    public BroadcastMedium(Integer idBroacastMedium, String urImage, String name, String url) {
        this.idBroacastMedium = idBroacastMedium;
        this.urImage = urImage;
        this.name = name;
        this.url = url;
    }

    public Integer getIdBroacastMedium() {
        return idBroacastMedium;
    }

    public void setIdBroacastMedium(Integer idBroacastMedium) {
        this.idBroacastMedium = idBroacastMedium;
    }

    public String getUrImage() {
        return urImage;
    }

    public void setUrImage(String urImage) {
        this.urImage = urImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BroadcastType getIdBroadcastType() {
        return idBroadcastType;
    }

    public void setIdBroadcastType(BroadcastType idBroadcastType) {
        this.idBroadcastType = idBroadcastType;
    }

    public ContentCreator getIdContentCreator() {
        return idContentCreator;
    }

    public void setIdContentCreator(ContentCreator idContentCreator) {
        this.idContentCreator = idContentCreator;
    }

    @XmlTransient
    public List<BroadcastMediumTag> getBroacastMediumTagList() {
        return broadcastMediumTagList;
    }

    public void setBroacastMediumTagList(List<BroadcastMediumTag> broadcastMediumTagList) {
        this.broadcastMediumTagList = broadcastMediumTagList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBroacastMedium != null ? idBroacastMedium.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BroadcastMedium)) {
            return false;
        }
        BroadcastMedium other = (BroadcastMedium) object;
        if ((this.idBroacastMedium == null && other.idBroacastMedium != null) || (this.idBroacastMedium != null && !this.idBroacastMedium.equals(other.idBroacastMedium))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NoCountry.YouTech.entities.BroacastMedium[ idBroacastMedium=" + idBroacastMedium + " ]";
    }
    
}
