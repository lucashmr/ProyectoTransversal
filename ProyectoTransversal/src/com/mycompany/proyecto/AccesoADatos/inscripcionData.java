package com.mycompany.proyecto.AccesoADatos;

public class inscripcionData {

    private Connection con;

    private MateriaData matData;

    private AlumnoData aluData;

    public inscripcionData() {
    }

    public Inscripcion guardarInscripcion(Inscripcion insc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Inscripcion> obtenerInscripciones() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int obtenerInscripcionesPorAlumno(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int obtenerMateriasCursadas(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int obtenerMateriasNOCursadas(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int obtenerAlumnoXMateria(int Materia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
