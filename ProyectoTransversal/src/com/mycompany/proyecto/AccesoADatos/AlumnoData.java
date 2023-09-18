package com.mycompany.proyecto.AccesoADatos;

import com.mycompany.proyecto.entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlumnoData {

    private Connection con=null;

    public AlumnoData() {
    con=Conexion.getConexion();
    }

    public Alumno guardarAlumno(Alumno alumno) {
        
        String sql="INSERT INTO alumno(dni,apellido,nombre,fechaNacimiento,estado)"
                + "VALUES(? , ? , ? , ? , ?)";
        
        try {
            PreparedStatement ps =con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3,alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            
           ResultSet rs=ps.getGeneratedKeys();
            
            if (rs.next()) {
             alumno.setIdAlumno(rs.getInt(1));
             JOptionPane.showMessageDialog(null, "Alumno guardado");
             
            }
           
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error al conectar a la tabla alumno");
        }
        
        return null;
       
    }

    public Alumno buscarAlumno(int id) {
      String sql="SELECT dni,apellido,nombre,fechaNacimiento FROM alumno WHERE idAlumno=? AND estado=1";
      Alumno alumno=null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
           ResultSet rs =ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
            }else{
               JOptionPane.showMessageDialog(null,"no existe ese alumno");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al acceder a la tabla alumno");
        }
        return alumno;
       
    }

    public Alumno BuscarAlumnoPorDni(int dni) {
       
        String sql="SELECT idAlumno,dni,apellido,nombre,fechaNacimiento FROM alumno WHERE dni=? AND estado=1";
      Alumno alumno=null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
           ResultSet rs =ps.executeQuery();
           
           
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
            }else{
               JOptionPane.showMessageDialog(null,"no existe ese alumno");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al acceder a la tabla alumno");
        }
        return alumno;
       
    }

    public List<Alumno> listarAlumnos() {
     
        return null;
     
    }

    public void modificarAlumno(Alumno alumno) { ///modificar alumno
       
        String sql="UPDATE alumno SET dni= ?, apellido= ?,nombre=?,fechaNacimiento=?"
                + "WHERE idAlumno= ?";
        try {
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getIdAlumno());
            int exito=ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null, "alumno modificado");
            }
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno");
        
       
    }

    }  
    public void eliminarAlumno(int id) {
  
        String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno=?";
       
        try {
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito=ps.executeUpdate();
            
            if (exito==1) {
                JOptionPane.showMessageDialog(null,"alumno eliminado");
            }
            
            
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"error al acceder a la tabla alumno");
        }
        
        
        
    }
}



