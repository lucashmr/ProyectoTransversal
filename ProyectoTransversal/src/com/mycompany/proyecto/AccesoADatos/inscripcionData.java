package com.mycompany.proyecto.AccesoADatos;

import com.mycompany.proyecto.entidades.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class inscripcionData {
    private Connection con = null;
    private MateriaData md = new MateriaData();
    private AlumnoData ad = new AlumnoData();

    public inscripcionData() {
      this.con= Conexion.getConexion();  
    }
    
    
    public void guardarInscripcion(Inscripcion insc){
        String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota)"
                + "VALUES (?,?, ?)";
        
        //settear
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            //ejecutar
            if(rs.next()){
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "INSCRIPCION REGISTRADA");
            }
            ps.close();
            //bloque error
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION");
        
        }
    }
        
        
        public void actualizarNota(int idAlumno, int idMateria, double nota){
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas = ps.executeUpdate();
            if(filas > 0){
                JOptionPane.showMessageDialog(null, "NOTA ACTUALIZADA");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION");
        }
        
    }
        
        
        
        
        
        
        
        
        
        public void borrarInscripcion(int idAlumno, int idMateria){
        String sql = "DELETE FROM inscripcion WHERE idAlumno = ?  AND idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas = ps.executeUpdate();
            if(filas > 0){
                JOptionPane.showMessageDialog(null, "INSCRIPCION ELIMINADA");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION");
        }        
    }
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
