package com.mycompany.proyecto.AccesoADatos;

import com.mycompany.proyecto.entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class MateriaData {

    private Connection con;
 Connection conexion = null;
    PreparedStatement statement = null;
    public MateriaData() {
    }
    //constructor vacio
    
    
  public void guardarMateria(Materia materia) {
  

    try {
        //insert materia
        String consulta = "INSERT INTO materias (idMateria, nombre, anioMateria, activo) VALUES (?, ?, ?, ?)";
        statement = conexion.prepareStatement(consulta);

        // Establecer los valores de los parámetros
        statement.setInt(1, materia.getIdMateria());
        statement.setString(2, materia.getNombre());
        statement.setInt(3, materia.getAnioMateria());
        statement.setBoolean(4, materia.isActivo());

        // Ejecutar la consulta
        statement.executeUpdate();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"ERRROR");
        
    } finally {
        // Cerrar la conexión y el statement
        try {
            if (statement != null) statement.close();
            if (conexion != null) conexion.close();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Error acá");
            
        }
    }
}
      
      
        
        
    




   public Materia buscarMateria(int id) {
        Materia materia = null;
        String query = "SELECT * FROM materias WHERE idMateria = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                materia.setIdMateria(resultSet.getInt("idMateria"));
                materia.setNombre(resultSet.getString("nombre"));
                materia.setAnioMateria(resultSet.getInt("anioMateria"));
                materia.setActivo(resultSet.getBoolean("activo"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error para buscar materia");
        }
        return materia;
    }


    public void modificarMateria(Materia materia) {  //para modificar alguna materia en concreto
        
        
    }

    public void eliminarMateria(int id) {  //para eliminar una materia al alumno
        
        
    }

   public List<Materia> listarMaterias() {
        List<Materia> materias = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            
            conn = Conexion.getConexion(); 

            String sql = "SELECT * FROM materias"; // Reemplaza materia

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Materia materia = new Materia(rs.getInt("id"), rs.getString("nombre"));
                materias.add(materia);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja la excepción 
        } finally {
            // Cierra los recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace(); // 
            }
        }

        return materias;
    }
}
