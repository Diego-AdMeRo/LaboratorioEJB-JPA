/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tallerDB.controlador;

import co.tallerDB.entidades.Estudiante;
import co.tallerDB.entidades.Inscripcion;
import co.tallerDB.entidades.Materia;
import co.tallerDB.sessionBeans.EstudianteFacadeLocal;
import co.tallerDB.sessionBeans.MateriaFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
public class Controlador extends HttpServlet {

    @EJB
    private MateriaFacadeLocal materiaFacade;

    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    
    
    
    private Estudiante estudiante;
    private Materia materia;
    private Inscripcion inscripcion;
    
    private static int num=3;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("accion").equals("Inscribir")){
            inscribirMateria(request, response);
        }if(request.getParameter("accion").contains("Estudiante")){
            estudiantes(request, response);
        }else if(request.getParameter("accion").contains("Materia")){
            materias(request, response);
        }
        
        request.setAttribute("materia", materia);
        request.setAttribute("todaMateria", materiaFacade.findAll());
        request.setAttribute("estudiante", estudiante);
        request.setAttribute("todoEstudiante", estudianteFacade.findAll());
        request.setAttribute("inscripciones", estudianteFacade.inscripciones());
        request.getRequestDispatcher("index.jsp").forward(request, response);
        

    }
    
    private void materias(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        int numeroCreditosR=0, semestreR=0, numeroEstudianteR=0;
        
        String materiaId = request.getParameter("materiaId");
        String nombreMateria = request.getParameter("nombreMateria");
        
        String numeroCreditos = request.getParameter("numeroCreditos");
        if(!numeroCreditos.equals("") && numeroCreditos != null)
            numeroCreditosR = Integer.parseInt(numeroCreditos);
        
        String semestre = request.getParameter("semestre");
        if(!semestre.equals("") && semestre != null)
            semestreR = Integer.parseInt(semestre);
        
        String numeroEstudiante = request.getParameter("numeroEstudiantes");
        if(!numeroEstudiante.equals("") && numeroEstudiante != null)
            numeroEstudianteR = Integer.parseInt(numeroEstudiante);
        
        String accion = request.getParameter("accion");
        
        materia = new Materia(materiaId, nombreMateria, numeroCreditosR, semestreR, numeroEstudianteR);
        
        if("Add Materia".equals(accion)){
            materiaFacade.create(materia);
        }else if ("Editar Materia".equals(accion)){
            materiaFacade.edit(materia);
        }else if ("Eliminar Materia".equals(accion)){
            materiaFacade.remove(materiaId);
        }else if ("Buscar Materia".equals(accion)){
            materia = materiaFacade.find(materiaId);
        }
    }
    
    
    private void estudiantes(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        String estudianteId = request.getParameter("estudianteId");
        int estudianteIdR =0;
        if (!estudianteId.equals("") && estudianteId != null)
            estudianteIdR = Integer.parseInt(estudianteId);
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        
        String anioEstudio = request.getParameter("anioEstudio");
        int anioEstudioR =0;
        if(!anioEstudio.equals("") && anioEstudio != null){
            anioEstudioR = Integer.parseInt(anioEstudio);
        }
        
        String accion = request.getParameter("accion");
        
        estudiante = new Estudiante(estudianteIdR, nombre, apellido, anioEstudioR);
        
        if("Add Estudiante".equals(accion)){
            estudianteFacade.create(estudiante);
        }else if ("Editar Estudiante".equals(accion)){
            estudianteFacade.edit(estudiante);
        }else if ("Eliminar Estudiante".equals(accion)){
            estudianteFacade.remove(estudianteIdR);
        }else if ("Buscar Estudiante".equals(accion)){
            estudiante = estudianteFacade.find(estudianteIdR);
        }
    }
    
    
    private void inscribirMateria(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        String materiaId = request.getParameter("materiaId");
        int estudianteId = Integer.parseInt(request.getParameter("estudianteId"));
        
        estudiante = estudianteFacade.find(estudianteId);
        materia = materiaFacade.find(materiaId);
        
        inscripcion = new Inscripcion(estudianteId+num, estudiante, materia);
        num++;
        
        estudiante.getInscripcionList().add(inscripcion);
        
        estudianteFacade.edit(estudiante);
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
