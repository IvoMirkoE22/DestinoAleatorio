import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;

/**
 * La clase RuletaAleatoria permite agregar nombres únicos a una lista y seleccionar
 * uno de ellos de forma aleatoria, simulando el comportamiento de una ruleta.
 * Tambíen proporciona métodos para mostrar la lista de nombres actuales
 * 
 * Evita la repetición de nombres y lanza excepciones en caso de operaciones inválidas,
 * como intentar girar la ruleta sin nombres cargados.
 * 
 * @author (Ivo Narváez) 
 * @version (1.0)
 */
public class RuletaAleatoria
{
    private ArrayList<String> nombres;
    private HashSet<String> nombresUnicos;
    private Random random;
    
    /**
     * Constructor de la clase RuletaAleatoria
     * Inicializa la lista de nombres, el conjunto de nombres únicos (para evitar repetidos),
     * y un generador de números aleatorios.
     */
    public RuletaAleatoria()
    {
        nombres = new ArrayList<>();
        nombresUnicos = new HashSet<>();
        random = new Random();
    }
    
    /**
     * Agrega un nuevo nombre a la ruleta si aún no ha sido ingresado.
     * La verificación es insensible a mayúsculas/minúsculas.
     * 
     * @param  nombre  que ingresa el usuario para este ser agregado a la lista
     * @return true si el nombre fue agregado exitosamente.
     * @throws IllegalArgumentException si el nombre ya existe en la lista.
     */
    public boolean agregarNombres(String nombre){
        if(nombre == null || nombre.trim().isEmpty()){
            System.out.println("El nombre que ingreso es inválido");
        }
        if(nombresUnicos.contains(nombre.toLowerCase())){
            throw new IllegalArgumentException("El nombre no puede estar vacío o solo contener espacios.");
        }
        nombres.add(nombre);
        nombresUnicos.add(nombre.toLowerCase());
        return true;
    }
    
    /**
     * Gira la ruleta seleccionando aleatoriamente uno de los nombres ingresados.
     * @throws IllegalStateException si no hay nombre en la ruleta.
     */
    public void girarRuleta(){
        if(nombres.isEmpty()){
            throw new IllegalStateException("La lista esta vacia, ingresa almenos un nombre");
        }
        int index = random.nextInt(nombres.size());
        String nombre = nombres.get(index);
        
        System.out.println("El nombre elegido es: "+ nombre);
        
    }
    /**
     * Muestra todos los nombres actualmente agregados a la ruleta
     * @throws IllgalStateEception si la lista de nombres está vacía.
     */
    public void mostrarNombres(){
        if(nombres.isEmpty()){
            throw new IllegalStateException("La lista es vacia");
        }
        System.out.println("Nombres de la ruleta");
        for(String nombre : nombres){
            System.out.println(" - " + nombre);
        }
    }
    
    /**
     * Devuelve la lista actual de nombres cargados en la ruleta.
     * 
     * Esta lista puede usarse para mostrar, guardar o manipular desde otras clases
     * como MenuRuleta o ArchivoRuleta.
     */
    public ArrayList<String> getListaDeNombres() {
        return nombres;
    }
    
    /**
     * Elimina un nombre de la ruleta si existe
     * 
     * @param nombre el nombre a eliminar.
     * @throws IllegalArgumentException si el nombre no existe o el parámetro es inválido.
     */
    
    public void eliminarNombre(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Debe ingresar un nombre válido");
        }
        boolean eliminado = false;
        for(int i = 0; i < nombres.size(); i++){
            if(nombres.get(i).equalsIgnoreCase(nombre)){
                nombres.remove(i);
                nombresUnicos.remove(nombre.toLowerCase());
                eliminado = true;
                break;
            }
        }
        if(!eliminado){
            throw new IllegalArgumentException("El nombre no se encuentra en la ruleta.");
        }
    }
    
    /**
     * Elimina todos los nombres de la ruleta.
     * nombres.clear() limpia todos los elementos de la lista
     * nombresUnicos.clear() limpia también el conjunto de nombres únicos
     * 
     * @throws IllegalStateException
     */
    public void eliminarLista(){
        if(nombres == null || nombres.isEmpty()){
            throw new IllegalStateException("No puedes eliminar una lista vacia");
        }
        nombres.clear(); 
        nombresUnicos.clear();
    }
    
    /**
     * Devuelve la cantidad de nombres actualmente captados en la ruleta.
     */
    public int nombresCargados(){
        return nombres.size();
    }
    
}
