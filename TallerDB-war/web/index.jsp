<%-- 
    Document   : index
    Created on : 16/03/2020, 04:57:56 PM
    Author     : Diego
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información de Institución</title>
    </head>
    <body>
        <h1>Información de Estudiantes</h1>
        <form action="./Controlador" method="POST">
            <table>
                <tr>
                    <td>ID Estudiantil</td>
                    <td><input type="text" name="estudianteId" value="${estudiante.estudianteid}" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${estudiante.nombre}" /></td>
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apellido" value="${estudiante.apellido}" /></td>
                </tr>
                <tr>
                    <td>Año de Estudio</td>
                    <td><input type="text" name="anioEstudio" value="${estudiante.añoestudiado}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="accion" value="Add Estudiante" />
                        <input type="submit" name="accion" value="Editar Estudiante" />
                        <input type="submit" name="accion" value="Eliminar Estudiante" />
                        <input type="submit" name="accion" value="Buscar Estudiante" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Año de Estudio</th>
                <c:forEach items="${todoEstudiante}" var="estudiantes">
                <tr>
                    <td>${estudiantes.estudianteid}</td>
                    <td>${estudiantes.nombre}</td>
                    <td>${estudiantes.apellido}</td>
                    <td>${estudiantes.añoestudiado}</td>
                </tr>
            </c:forEach> 
        </table>
        
        <hr/>
        
        <h1>Información de Materias</h1>
        <form action="./Controlador" method="POST">
            <table>
                <tr>
                    <td>ID Materia</td>
                    <td><input type="text" name="materiaId" value="${materia.materiaid}" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombreMateria" value="${materia.nombremateria}" /></td>
                </tr>
                <tr>
                    <td>Numero de Creditos</td>
                    <td><input type="text" name="numeroCreditos" value="${materia.numerocreditos}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestre" value="${materia.semestre}" /></td>
                </tr>
                <tr>
                    <td>Numero Estudiantes</td>
                    <td><input type="text" name="numeroEstudiantes" value="${materia.numadmitidos}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="accion" value="Add Materia" />
                        <input type="submit" name="accion" value="Editar Materia" />
                        <input type="submit" name="accion" value="Eliminar Materia" />
                        <input type="submit" name="accion" value="Buscar Materia" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID Materia</th>
            <th>Nombre</th>
            <th>Numero de Creditos</th>
            <th>Semestre</th>
            <th>Numero Estudiantes</th>
                <c:forEach items="${todaMateria}" var="materias">
                <tr>
                    <td>${materias.materiaid}</td>
                    <td>${materias.nombremateria}</td>
                    <td>${materias.numerocreditos}</td>
                    <td>${materias.semestre}</td>
                    <td>${materias.numadmitidos}</td>
                </tr>
            </c:forEach> 
        </table>
        
        <hr/>
        <h1>Inscribir Materias</h1>
        <form action="./Controlador"  method="POST">
            <label for="estudianteId">Estudiante ID</label>
            <input type="text" name="estudianteId" id="estudianteId">
            
            <label for="materiaId"> Materia ID</label>
            <input type="text" name="materiaId" id="materiaId">
            
            <input type="submit" name="accion" value="Inscribir">
        </form>
        
        <table border="1">
            <th>Inscripcion ID</th>
            <th>Estudiante ID</th>
            <th>Materia ID</th>
                <c:forEach items="${inscripciones}" var="inscripcion">
                <tr>
                    <td>${inscripcion[0]}</td>
                    <td>${inscripcion[1]}</td>
                    <td>${inscripcion[2]}</td>
                </tr>
            </c:forEach> 
        </table>
        
    </body>
</html>