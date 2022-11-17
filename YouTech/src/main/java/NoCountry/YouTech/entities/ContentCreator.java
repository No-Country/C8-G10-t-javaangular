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
@Table(name = "content_creator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContentCreator.findAll", query = "SELECT c FROM ContentCreator c")
    , @NamedQuery(name = "ContentCreator.findByIdContentCreator", query = "SELECT c FROM ContentCreator c WHERE c.idContentCreator = :idContentCreator")
    , @NamedQuery(name = "ContentCreator.findByName", query = "SELECT c FROM ContentCreator c WHERE c.name = :name")
    , @NamedQuery(name = "ContentCreator.findByLastName", query = "SELECT c FROM ContentCreator c WHERE c.lastName = :lastName")
    , @NamedQuery(name = "ContentCreator.findByIdPseudonym", query = "SELECT c FROM ContentCreator c WHERE c.idPseudonym = :idPseudonym")
    , @NamedQuery(name = "ContentCreator.findByImageProfile", query = "SELECT c FROM ContentCreator c WHERE c.imageProfile = :imageProfile")
    , @NamedQuery(name = "ContentCreator.findByUrlGithub", query = "SELECT c FROM ContentCreator c WHERE c.urlGithub = :urlGithub")
    , @NamedQuery(name = "ContentCreator.findByUrlTwitter", query = "SELECT c FROM ContentCreator c WHERE c.urlTwitter = :urlTwitter")
    , @NamedQuery(name = "ContentCreator.findByUrlLinkedin", query = "SELECT c FROM ContentCreator c WHERE c.urlLinkedin = :urlLinkedin")})
public class ContentCreator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_content_creator")
    private Integer idContentCreator;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "id_pseudonym")
    private String idPseudonym;
    @Basic(optional = false)
    @Column(name = "image_profile")
    private String imageProfile;
    @Column(name = "url_github")
    private String urlGithub;
    @Column(name = "url_twitter")
    private String urlTwitter;
    @Column(name = "url_linkedin")
    private String urlLinkedin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContentCreator", fetch = FetchType.LAZY)
    private List<BroacastMedium> broacastMediumList;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario idUser;

    public ContentCreator() {
    }

    public ContentCreator(Integer idContentCreator) {
        this.idContentCreator = idContentCreator;
    }

    public ContentCreator(Integer idContentCreator, String name, String lastName, String imageProfile) {
        this.idContentCreator = idContentCreator;
        this.name = name;
        this.lastName = lastName;
        this.imageProfile = imageProfile;
    }

    public Integer getIdContentCreator() {
        return idContentCreator;
    }

    public void setIdContentCreator(Integer idContentCreator) {
        this.idContentCreator = idContentCreator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdPseudonym() {
        return idPseudonym;
    }

    public void setIdPseudonym(String idPseudonym) {
        this.idPseudonym = idPseudonym;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getUrlGithub() {
        return urlGithub;
    }

    public void setUrlGithub(String urlGithub) {
        this.urlGithub = urlGithub;
    }

    public String getUrlTwitter() {
        return urlTwitter;
    }

    public void setUrlTwitter(String urlTwitter) {
        this.urlTwitter = urlTwitter;
    }

    public String getUrlLinkedin() {
        return urlLinkedin;
    }

    public void setUrlLinkedin(String urlLinkedin) {
        this.urlLinkedin = urlLinkedin;
    }

    @XmlTransient
    public List<BroacastMedium> getBroacastMediumList() {
        return broacastMediumList;
    }

    public void setBroacastMediumList(List<BroacastMedium> broacastMediumList) {
        this.broacastMediumList = broacastMediumList;
    }

    public Usuario getIdUser() {
        return idUser;
    }

    public void setIdUser(Usuario idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContentCreator != null ? idContentCreator.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContentCreator)) {
            return false;
        }
        ContentCreator other = (ContentCreator) object;
        if ((this.idContentCreator == null && other.idContentCreator != null) || (this.idContentCreator != null && !this.idContentCreator.equals(other.idContentCreator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NoCountry.YouTech.entities.ContentCreator[ idContentCreator=" + idContentCreator + " ]";
    }
    
}
