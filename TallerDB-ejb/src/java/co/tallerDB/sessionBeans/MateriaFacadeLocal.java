/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tallerDB.sessionBeans;

import co.tallerDB.entidades.Materia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diego
 */
@Local
public interface MateriaFacadeLocal {

    public void create(Materia materia);

    public void edit(Materia materia);

    public void remove(String materia);

    public Materia find(String id);

    public List<Materia> findAll();

    public List<Materia> findRange(int[] range);

    public int count();
    
}
