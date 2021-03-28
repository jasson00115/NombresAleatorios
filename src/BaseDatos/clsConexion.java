
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
import modelos.clsmodelos;



public class clsConexion {
    
    public Connection conexion;
    private final String servidor_conexion = "jdbc:mysql://localhost:3306/nombrel?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static private final String usuario = "root";
    static private final String clave = "50507563";
    
    
    
    public void AbrirConexion()
    {
        try
        {
            conexion = (Connection) DriverManager.getConnection(servidor_conexion, usuario, clave);
            System.out.println("Conexion exitosa");
            
        }
        catch(SQLException ex)
        {
           System.out.println("Error: "+ex.getMessage());
        }
    }
    
    public void CerrarConexion()
    {
        try
        {
            conexion.close();
        }
        catch(SQLException ex)
        {
            System.out.println("Error: "+ ex.getMessage());
        }
    }
    
    public void inserta_nombres(clsmodelos p){
       String Query="";
       Query += "INSERT INTO `listanombres`("
                                + "`nombre`" +
                                 ")  values ";
       String valores="";
       valores ="('"+p.getNombre()+"')";
       Query += valores; 
       
       AbrirConexion();
       Statement s;
       try{
          s = (Statement) conexion.createStatement();
          int res = s.executeUpdate(Query);
         
       }catch(SQLException ex){
           System.out.println("Error:"+ex.getMessage());
       }
       CerrarConexion();
    
   }
    
    
   public clsmodelos buscar(String correlativo){
      clsmodelos nom = new clsmodelos();
      
      try{
      AbrirConexion();
      String criterio="select * from listanombres where Id_Nombre = "+correlativo;
      Statement s = (Statement) conexion.createStatement();
      ResultSet rs = s.executeQuery(criterio);
      
      while (rs.next()){
        nom.setNombre(rs.getString("Nombre"));
      }
      
      CerrarConexion();
      }catch(SQLException ex){
          System.out.println("error:"+ ex.getMessage());
      }
      
     return nom;
     
   } 
   
   public void mostrarnombre(){
       int cantidad=10;
       String NombreG;
       String nombres;
       try{
            AbrirConexion();
            String criterio="select Nombre from listanombres ";
            Statement s = (Statement) conexion.createStatement();
            ResultSet rs = s.executeQuery(criterio);
            ArrayList<String> listN = new ArrayList<String>();
            while (rs.next()){
              nombres=(rs.getString("Nombre"));
              listN.add(nombres);
            }

            System.out.println("---Lista antes del orden= "+listN);
            Collections.sort(listN);
            System.out.println("---Lista ordenada= "+listN);
            int donde = Collections.binarySearch(listN, "jimy");
            System.out.println("---jimy se encuentra en el idx= "+donde);
            Collections.shuffle(listN);
            System.out.println("---Revueltos= "+listN);
            
            
            ArrayList<String> listG = new ArrayList<String>();
            
            while(listN.size() !=cantidad){
            NombreG = listN.get(cantidad);
            listG.add(NombreG);
            listN.remove(NombreG);
            }
            
            Collections.sort(listG);
            System.out.println("---Personas ganadoras del sorteo"+listG);

            CerrarConexion();
      }catch(SQLException ex){
            System.out.println("error:"+ ex.getMessage());
      }
       
   }
   
   
   
          
}
    

