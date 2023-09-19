package com.mycompany.proyecto.AccesoADatos;

import com.mycompany.proyecto.entidades.Materia;
import java.sql.Connection;
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
        Materia materia = null;
        String sql = "SELECT * FROM materias WHERE idMateria = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                materia.setIdMateria(resultSet.getInt("idMateria"));
                materia.setNombre(resultSet.getString("nombre"));
                materia.setAnioMateria(resultSet.getInt("anioMateria"));
                materia.setActivo(resultSet.getBoolean("activo"));
            }

            resultSet.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error para buscar materia");
        }
        return materia;
    }


    public void modificarMateria(Materia materia) {  //para modificar alguna materia en concreto
        
        
    }

    public void eliminarMateria(int id) {  //para eliminar una materia al alumno
        
        
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