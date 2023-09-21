package com.mycompany.proyecto.AccesoADatos;

import com.mycompany.proyecto.entidades.Materia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MateriaData {

   private Connection con=null;
   
 
 public MateriaData() {
     con=Conexion.getConexion();
    }
    
    
    
  public void guardarMateria(Materia materia) { 
      String sql = "INSERT INTO materia (idMateria, nombre, anioMateria, activo)"
              + " VALUES (?, ?, ?, ?)";
      
    try {
        PreparedStatement ps =con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // Establecer los valores de los parámetros
        ps.setInt(1, materia.getIdMateria());
        ps.setString(2, materia.getNombre());
        ps.setInt(3, materia.getAnioMateria());
        ps.setBoolean(4, materia.isActivo());
        ps.executeUpdate();
        
        ResultSet rs=ps.getGeneratedKeys();
        
        if (rs.next()) {
             materia.setIdMateria(rs.getInt(1));
             JOptionPane.showMessageDialog(null, "Materia guardada");
            }
        ps.close();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
        
        
   
  }

    public Materia buscarMateria(int id) {
        
        String sql = "SELECT idMateria,nombre,anioMateria FROM materia"
                + " WHERE idMateria= ?  AND activo=1";
        
        Materia materia = null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anioMateria"));
                materia.setActivo(true);
            }else
                JOptionPane.showMessageDialog(null, "No encontrada en la base de datos");

            
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error al acceder a la tabla materia");
        }
        return materia;
    }


    public void modificarMateria(Materia materia) {  //para modificar alguna materia en concreto
        
        String sql="UPDATE materia SET nombre= ?,anioMateria= ?, activo= ?" 
                + " WHERE idMateria= ?";
               ///PONER ESPACIO DESPUES DEL WHERE
        
        
        try {
            PreparedStatement ps =con.prepareStatement(sql);
                
            //settear vars
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3,materia.isActivo());
            ps.setInt(4, materia.getIdMateria());
            
            //ejecutar
            int exito=ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null, "materia modificado");
            }
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a la tabla materia");
    }
    }
    public void eliminarMateria(int id) {  //para eliminar una materia al alumno
        
        String sql = "UPDATE materia SET activo = 0 WHERE idMateria=?";
       
        try {
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito=ps.executeUpdate();
            
            if (exito==1) {
                JOptionPane.showMessageDialog(null,"materia eliminada");
            }
            
            
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"error al acceder a la tabla materia");
        }
    }

    
    
    
   public List<Materia> listarMaterias()  {
        ArrayList<Materia> materias = new ArrayList<>();
        
        String sql="SELECT idMateria,nombre,anioMateria FROM materia WHERE  estado=1";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
           ResultSet rs =ps.executeQuery();
        
        while (rs.next()) {
                Materia materia= new Materia();
                materia.setNombre(rs.getString("nombre"));
                materia.setActivo(true);
                materia.setIdMateria(rs.getInt("idMateria"));
                materias.add(materia);
            }
            ps.close();
           
           
           
       
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla materia");
        }
        return materias;
}
   
   
}