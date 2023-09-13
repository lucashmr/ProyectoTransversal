package ProyectoTransversal;

import com.mycompany.proyecto.AccesoADatos.Conexion;
import java.sql.Connection;

public class main {

    public static void main(String[] args) {
        Connection con = Conexion.getConexion();
    }
}
