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
@Table(name = "ESTUDIANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findByEstudianteid", query = "SELECT e FROM Estudiante e WHERE e.estudianteid = :estudianteid")
    , @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estudiante.findByApellido", query = "SELECT e FROM Estudiante e WHERE e.apellido = :apellido")
    , @NamedQuery(name = "Estudiante.findByA\u00f1oestudiado", query = "SELECT e FROM Estudiante e WHERE e.a\u00f1oestudiado = :a\u00f1oestudiado")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTUDIANTEID")
    private Integer estudianteid;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "A\u00d1OESTUDIADO")
    private Integer añoestudiado;
    @OneToMany(mappedBy = "estudianteid")
    private List<Inscripcion> inscripcionList;

    public Estudiante() {
    }

    public Estudiante(Integer estudianteid) {
        this.estudianteid = estudianteid;
    }

    public Estudiante(Integer estudianteid, String nombre, String apellido, Integer añoestudiado) {
        this.estudianteid = estudianteid;
        this.nombre = nombre;
        this.apellido = apellido;
        this.añoestudiado = añoestudiado;
    }
    
    

    public Integer getEstudianteid() {
        return estudianteid;
    }

    public void setEstudianteid(Integer estudianteid) {
        this.estudianteid = estudianteid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getAñoestudiado() {
        return añoestudiado;
    }

    public void setAñoestudiado(Integer añoestudiado) {
        this.añoestudiado = añoestudiado;
    }

    @XmlTransient
    public List<Inscripcion> getInscripcionList() {
        return inscripcionList;
    }

    public void setInscripcionList(List<Inscripcion> inscripcionList) {
        this.inscripcionList = inscripcionList;
    }
    
    public void addInscripcion(Inscripcion inscripcion){
        inscripcionList.add(inscripcion);
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudianteid != null ? estudianteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.estudianteid == null && other.estudianteid != null) || (this.estudianteid != null && !this.estudianteid.equals(other.estudianteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.tallerDB.entidades.Estudiante[ estudianteid=" + estudianteid + " ]";
    }
    
}
