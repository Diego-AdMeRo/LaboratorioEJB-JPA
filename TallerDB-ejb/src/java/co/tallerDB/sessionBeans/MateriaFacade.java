/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tallerDB.sessionBeans;

import co.tallerDB.entidades.Materia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diego
 */
@Stateless
public class MateriaFacade extends AbstractFacade<Materia> implements MateriaFacadeLocal {

    @PersistenceContext(unitName = "TallerDB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaFacade() {
        super(Materia.class);
    }

    @Override
    public void create(Materia materia) {
        em.persist(materia);
    }

    @Override
    public void edit(Materia materia) {
       em.merge(materia);
    }

    @Override
    public void remove(String materiaId) {
        super.remove(find(materiaId));
    }

    @Override
    public Materia find(String id) {
        return em.find(Materia.class, id);
    }

    @Override
    public List<Materia> findAll() {
        return em.createNamedQuery("Materia.findAll").getResultList();
    }
    
    
    
    
}
