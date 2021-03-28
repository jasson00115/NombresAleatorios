
package Ejemplos;

import BaseDatos.clsConexion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class ClsEjemplo {
    
    public void ejemplo1(){
        String[] array = {"Zacarias", "Maria", "Abel", "Betry", "Fabrizio", };
        List<String> miLista = Arrays.asList(array);
        imprimirTodo(miLista);
        
        clsConexion conn = new clsConexion();
        conn.mostrarnombre();
        
       // System.out.println("Lista antes del orden"+miLista);
        Collections.sort(miLista);
        System.out.println("Lista ordenada="+miLista);
        int donde = Collections.binarySearch(miLista, "Abel");
        System.out.println("Abel se encuentra en el idx= "+donde);
        Collections.shuffle(miLista);
        //System.out.println("Revueltos="+miLista);
        imprimirTodo(miLista);
    }
    
    public void imprimirTodo(Collection coll){
        Iterator iter = coll.iterator();
        while(iter.hasNext()){
            System.out.println("elemento = "+iter.next());
        }
    }
    
    public void pruebaArreglo(){
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("uno");
        lista.add("dos");
        
        String[] a = new String[20];
        lista.toArray(a);
        String[] b = lista.toArray(new String[10]);
    }
}
