package ProyectoTransversal;

import com.mycompany.proyecto.AccesoADatos.AlumnoData;
import com.mycompany.proyecto.AccesoADatos.Conexion;
import com.mycompany.proyecto.entidades.Alumno;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

public class main {

    public static void main(String[] args) {
        Connection con = Conexion.getConexion();
        
      //  Alumno juan =new Alumno (12131334,"lima","juan pedro",LocalDate.of(1980, 4, 25),true);
        AlumnoData alu = new AlumnoData();
//        alu.modificarAlumno(juan)
            //   alu.guardarAlumno(juan);
        //alu.eliminarAlumno(4);
       Alumno alumnoEncontrado=alu.BuscarAlumnoPorDni();
       
        System.out.println("dni"+alumnoEncontrado.getDni());
        System.out.println("apellido"+alumnoEncontrado.getApellido());
    }
}
