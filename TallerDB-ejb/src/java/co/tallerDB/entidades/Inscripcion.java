/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tallerDB.entidades;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "INSCRIPCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscripcion.findAll", query = "SELECT i FROM Inscripcion i")
    , @NamedQuery(name = "Inscripcion.findByInscripcionid", query = "SELECT i FROM Inscripcion i WHERE i.inscripcionid = :inscripcionid")})
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "INSCRIPCIONID")
    private Integer inscripcionid;
    @JoinColumn(name = "ESTUDIANTEID", referencedColumnName = "ESTUDIANTEID")
    @ManyToOne
    private Estudiante estudianteid;
    @JoinColumn(name = "MATERIAID", referencedColumnName = "MATERIAID")
    @ManyToOne
    private Materia materiaid;

    public Inscripcion() {
    }

    public Inscripcion(Integer inscripcionid) {
        this.inscripcionid = inscripcionid;
    }

    public Inscripcion(Integer inscripcionid, Estudiante estudianteid, Materia materiaid) {
        this.inscripcionid = inscripcionid;
        this.estudianteid = estudianteid;
        this.materiaid = materiaid;
    }
    

    public Integer getInscripcionid() {
        return inscripcionid;
    }

    public void setInscripcionid(Integer inscripcionid) {
        this.inscripcionid = inscripcionid;
    }

    public Estudiante getEstudianteid() {
        return estudianteid;
    }

    public void setEstudianteid(Estudiante estudianteid) {
        this.estudianteid = estudianteid;
    }

    public Materia getMateriaid() {
        return materiaid;
    }

    public void setMateriaid(Materia materiaid) {
        this.materiaid = materiaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inscripcionid != null ? inscripcionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripcion)) {
            return false;
        }
        Inscripcion other = (Inscripcion) object;
        if ((this.inscripcionid == null && other.inscripcionid != null) || (this.inscripcionid != null && !this.inscripcionid.equals(other.inscripcionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.tallerDB.entidades.Inscripcion[ inscripcionid=" + inscripcionid + " ]";
    }
    
}
