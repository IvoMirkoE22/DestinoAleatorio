import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
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
        if(nombresUnicos.contains(nombre.toLowerCase())){
            throw new IllegalArgumentException("Este nombre ya fue añadido con anterioridad");
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
    * Guarda todos los nombres actuales de la ruleta en un archivo de texto.
    * 
    * Cada nombre se guarda en una línea separada en el archivo. Si el archivo ya existe,
    * será sobrescrito con los nombres actuales.
    * 
    * El método recorre la lista de nombres y escribe cada uno en el archivo, en el mismo
    * orden en que fueron agregados. Si ocurre algún error durante la escritura, se muestra
    * un mensaje de error por consola.
    * 
    * @param nombreDeArchivo El nombre (o ruta relativa) del archivo donde se guardarán los nombres.
    */
    public void guardarEnArchivo(String nombreArchivo){
        try {
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
     * Carga nombres desde un archivo de texto y los agrega a la ruleta.
     * 
     * Cada línea del archivo debe contener un solo nombre. Los nombres duplicados
     * (ignorando mayúsculas/minúsculas) serán descartados automáticamente.
     * 
     * El método recorre el archivo línea por línea, intentando agregar cada nombre
     * mediante el método {@code agregarNombres(String nombre)}. Si un nombre ya
     * estaba en la lista, se ignora silenciosamente.
     * 
     * Si el archivo no existe o ocurre un error de lectura, se muestra un mensaje
     * de error por consola sin interrumpir la ejecución del programa.
     * 
     * @param nombreDeArchivo El nombre (o ruta relativa) del archivo a cargar.
     */
    public void cargarDesdeArchivo(String nombreDeArchivo){
        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreDeArchivo));
                String linea;
                while ((linea = lector.readLine()) != null){
                    try {
                        agregarNombres(linea);
                        
                    } catch (IllegalArgumentException e){
                        //Si el nombre ya estaba, lo ignoramos
                    }
                }
                lector.close();
                System.out.println("Lista cargada con exito.");
            } catch (IOException e) {
                System.out.println("Error al cargar: "+ e.getMessage());
            }
    }
    
}
