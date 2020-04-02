/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tallerDB.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "MATERIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")
    , @NamedQuery(name = "Materia.findByMateriaid", query = "SELECT m FROM Materia m WHERE m.materiaid = :materiaid")
    , @NamedQuery(name = "Materia.findByNombremateria", query = "SELECT m FROM Materia m WHERE m.nombremateria = :nombremateria")
    , @NamedQuery(name = "Materia.findByNumerocreditos", query = "SELECT m FROM Materia m WHERE m.numerocreditos = :numerocreditos")
    , @NamedQuery(name = "Materia.findBySemestre", query = "SELECT m FROM Materia m WHERE m.semestre = :semestre")
    , @NamedQuery(name = "Materia.findByNumadmitidos", query = "SELECT m FROM Materia m WHERE m.numadmitidos = :numadmitidos")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MATERIAID")
    private String materiaid;
    @Size(max = 30)
    @Column(name = "NOMBREMATERIA")
    private String nombremateria;
    @Column(name = "NUMEROCREDITOS")
    private Integer numerocreditos;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Column(name = "NUMADMITIDOS")
    private Integer numadmitidos;
    @OneToMany(mappedBy = "materiaid")
    private List<Inscripcion> inscripcionList;

    public Materia() {
    }

    public Materia(String materiaid) {
        this.materiaid = materiaid;
    }

    public Materia(String materiaid, String nombremateria, Integer numerocreditos, Integer semestre, Integer numadmitidos) {
        this.materiaid = materiaid;
        this.nombremateria = nombremateria;
        this.numerocreditos = numerocreditos;
        this.semestre = semestre;
        this.numadmitidos = numadmitidos;
    }
    
     

    public String getMateriaid() {
        return materiaid;
    }

    public void setMateriaid(String materiaid) {
        this.materiaid = materiaid;
    }

    public String getNombremateria() {
        return nombremateria;
    }

    public void setNombremateria(String nombremateria) {
        this.nombremateria = nombremateria;
    }

    public Integer getNumerocreditos() {
        return numerocreditos;
    }

    public void setNumerocreditos(Integer numerocreditos) {
        this.numerocreditos = numerocreditos;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getNumadmitidos() {
        return numadmitidos;
    }

    public void setNumadmitidos(Integer numadmitidos) {
        this.numadmitidos = numadmitidos;
    }

    @XmlTransient
    public List<Inscripcion> getInscripcionList() {
        return inscripcionList;
    }

    public void setInscripcionList(List<Inscripcion> inscripcionList) {
        this.inscripcionList = inscripcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiaid != null ? materiaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.materiaid == null && other.materiaid != null) || (this.materiaid != null && !this.materiaid.equals(other.materiaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.tallerDB.entidades.Materia[ materiaid=" + materiaid + " ]";
    }
    
}
