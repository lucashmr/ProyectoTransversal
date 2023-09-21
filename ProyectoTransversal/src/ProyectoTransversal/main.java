package ProyectoTransversal;

import com.mycompany.proyecto.AccesoADatos.AlumnoData;
import com.mycompany.proyecto.AccesoADatos.Conexion;
import com.mycompany.proyecto.AccesoADatos.MateriaData;
import com.mycompany.proyecto.entidades.Alumno;
import com.mycompany.proyecto.entidades.Materia;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

public class main {

    public static void main(String[] args) {
        Connection con = Conexion.getConexion();
        
        //MATERIA
        Materia mate = new Materia (1,"literatura",1,true); //settear variables
       MateriaData mat = new MateriaData(); 
       mat.modificarMateria(mate);
      //mat.guardarMateria(mate);
      //Materia materiaEncontrada=mat.buscarMateria(1);
       // mat.eliminarMateria(1);
        
      
      
        
      //ALUMNO
//      //  Alumno juan =new Alumno (12131334,"lima","juan pedro",LocalDate.of(1980, 4, 25),true);
//        AlumnoData alu = new AlumnoData();

                //modificar alumno
////        alu.modificarAlumno(juan)

                   //guardar alumno
//            //   alu.guardarAlumno(juan);

              //eliminar alumno
//        //alu.eliminarAlumno(4);

                  //buscar alumno
//        Alumno alumnoEncontrado=alu.BuscarAlumnoPorDni(12131334);
//       
//        System.out.println("dni"+alumnoEncontrado.getDni());
//        System.out.println("apellido"+alumnoEncontrado.getApellido());



         // listar alumno
//             AlumnoData alu = new AlumnoData();
//        for (Alumno alumno:alu.listarAlumnos()) {
//            System.out.println(alumno.getDni());
//            System.out.println(alumno.getApellido()); 
//            System.out.println(alumno.getNombre());
//            System.out.println(alumno.getDni());
//            System.out.println(alumno.getFechaNac());
//            
//        }

    
    
    
  
//    mat.listarMaterias(); //listar mats

    
    
    
    }
}
