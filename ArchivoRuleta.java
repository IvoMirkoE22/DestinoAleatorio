import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La clase ArchivoRuleta se encarga exclusivamente de las operaciones
 * relacionadas con archivos de texto para guardar, cargar o eliminar listas
 * de nombres utilizadas por la ruleta.
 * 
 * Esta separación permite una mayor modularidad y separación de responsabilidades,
 * facilitando el mantenimiento y la extensión del código.
 * 
 * Métodos disponibles:
 * - guardarEnArchivo: guarda una lista de nombres en un archivo.
 * - cargarDesdeArchivo: carga nombres desde un archivo de texto.
 * - eliminarArchivo: elimina un archivo existente del sistema.
 * 
 * Todos los métodos manejan excepciones y aseguran que el programa
 * continúe funcionando aunque ocurran errores en disco.
 * @author (Ivo Narváez) 
 * @version (1.0)
 */
public class ArchivoRuleta
{
   /**
    * Guarda una lista de nombres en un archivo de texto.
    * Cada nombre se escribe en un línea separada. Si el archivo ya existe,
    * su contenido será sobrescrito.
    * 
    * @param listaNombres Lista de nombres a guardar.
    * @param nombreArchivo Nombre del archivo (con o sin extensión .txt).
    */
    public static void guardarEnArchivo(ArrayList<String> nombres,String nombreArchivo){
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.exists()){
                Scanner confirmacion = new Scanner(System.in);
                System.out.println("El archivo ya existe.¿Desea sobreescribirlo? (S/N)");
                String reśpuesta = confirmacion.nextLine().trim().toLowerCase();
                if (!reśpuesta.equals("s")){
                    System.out.println("Operación cancelada.No se guardaron los datos.");
                    return;
                }
            }
            FileWriter escritor = new FileWriter(nombreArchivo);
            for(String nombre : nombres){
                escritor.write(nombre + "\n");
            }
            escritor.close();
            System.out.println("Lista guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar. " + e.getMessage());
        }
    }
    
   /**
     * Carga nombres desde un archivo de texto.
     * 
     * Cada línea del archivo representa un nombre. Devuelve una lista con todos
     * Los nombres leídos. Si el archivo no existe o ocurre un error de lectura,
     * se devuleve una lista vacía y se muestra un mensaje de error.
     * 
     * @param nombreDeArchivo Nombre del archivo a leer.
     * @return Lista de nombres leídos desde el archivo.
     */
    public static ArrayList<String> cargarDesdeArchivo(String nombreDeArchivo){
        ArrayList<String> nombres = new ArrayList<>();
        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreDeArchivo));
                String linea;
                while ((linea = lector.readLine()) != null){
                    linea = linea.trim();
                    if (!linea.isEmpty() && !nombres.contains(linea)){
                        nombres.add(linea);
                    }
                }
                lector.close();
                System.out.println("Lista cargada con exito.");
            } catch (IOException e) {
                System.out.println("Error al cargar: "+ e.getMessage());
            }
            return nombres;
    }
    
    /**
     * Elimina el archivo que se guardo o que se desea abrir
     * este archivo contiene la lista de personas o personajes
     * @param nombreArchivo es el nombre el cual tiene el archivo que 
     * se desea eliminar
     */
    public static  void eliminarArchivo(String nombreArchivos){
        File archivo = new File(nombreArchivos);
        if(archivo.exists()){
            if(archivo.delete()){
                System.out.println("Archivo eliminado correctamente.");
            }else{
                System.out.println("No se pudo eliminar el archivo.");
            }
        }else {
            System.out.println("El archivo no existe.");
        }
    }
}
