/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tallerDB.sessionBeans;

import co.tallerDB.entidades.Estudiante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Diego
 */
@Stateless
public class EstudianteFacade extends AbstractFacade<Estudiante> implements EstudianteFacadeLocal {

    @PersistenceContext(unitName = "TallerDB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }

    @Override
    public void create(Estudiante estudiante) {
        em.persist(estudiante);
    }

    @Override
    public void edit(Estudiante estudiante) {
        em.merge(estudiante);
    }

    @Override
    public void remove(int estudiante) {
        em.remove(find(estudiante));
    }

    @Override
    public Estudiante find(int id) {
        return em.find(Estudiante.class, id);
    }

    @Override
    public List<Estudiante> findAll() {
        return em.createNamedQuery("Estudiante.findAll").getResultList();
    }

    @Override
    public List<Object[]> inscripciones() {
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT i.inscripcionid, i.estudianteid.estudianteid, i.materiaid.materiaid FROM Inscripcion AS i", Object[].class);
        return query.getResultList();
    }
    

    
    
}
