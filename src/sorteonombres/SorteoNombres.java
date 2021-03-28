
package sorteonombres;
import BaseDatos.clsConexion;
import ListaPuntos.Lista;
import modelos.clsmodelos;
import java.util.Scanner;


public class SorteoNombres {

   
    
    public static void main(String[] args) {

       //buscar();
      clsConexion conn = new clsConexion();
      conn.mostrarnombre();
      

    }
    
    public static void ingresar(){
        Scanner s = new Scanner(System.in);
        String nombres;
        
        clsConexion conn = new clsConexion();
        
        clsmodelos pe = new clsmodelos();
        System.out.print("ingrese un nombre: ");
        nombres = s.next();
        pe.setNombre(nombres);
        conn.inserta_nombres(pe);
    }
    
    public static void buscar(){
        Scanner s = new Scanner(System.in);
        String  id;
        System.out.print("Ingrese el id para mostrar el nombre: ");
        id = s.next();
        clsConexion conn = new clsConexion();
        
        clsmodelos pe = new clsConexion().buscar(id);
        System.out.printf("Nombre: "+pe.getNombre());
        
    }
    

    
}
