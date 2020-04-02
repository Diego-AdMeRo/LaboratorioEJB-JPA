/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tallerDB.sessionBeans;

import co.tallerDB.entidades.Estudiante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diego
 */
@Local
public interface EstudianteFacadeLocal {

    public void create(Estudiante estudiante);

    public void edit(Estudiante estudiante);

    public void remove(int estudiante);

    public Estudiante find(int id);

    public List<Estudiante> findAll();

    public List<Estudiante> findRange(int[] range);

    public int count();
    
    public List<Object[]> inscripciones();
    
}
