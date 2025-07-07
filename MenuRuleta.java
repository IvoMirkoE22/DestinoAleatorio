import java.util.Scanner;
/**
 * La clase MenuRuleta Maneja la interacción con el usuario mediante un menú
 * en consola. Permite agregar nombres, mostrar los nombres actuales y girar 
 * una ruleta para seleccionar uno al azar.
 * 
 * Esta clase utiliza la clase RuletaAleatoria para la lógica del sorteo y
 * almacemiento de nombres. Incluye control de errores para entradas inválidas.
 * 
 * @author (Ivo Narváez) 
 * @version (1.0)
 */
public class MenuRuleta
{
    private RuletaAleatoria ruleta;
    private Scanner lector;
    
    /**
     * Constructor de la clase MenuRuleta
     * Inicializa una nueva instancia de RuletaAleatoria y el lector de entradas.
     */   
    public MenuRuleta()
    {
       ruleta = new RuletaAleatoria();
       lector = new Scanner(System.in);
    }
    /**
     * Inicia el menú interactivo en consola, ofreciendo opciones para:
     * Agregar un nombre
     * Mostrar todos los nombres ingresados
     * Girar la ruleta para seleccionar un nombre al  azar
     * Guardar nombres en archivo
     * Cargar nombres desde archivos
     * Salir del programa
     * 
     * El ciclo continúa hasta que el usuario decide salir.
     */
    public void iniciarMenu(){
        boolean continuar = true;
        while (continuar){
            System.out.println("\n---Menú Ruleta ---");
            System.out.println("1. Agregar nombre");
            System.out.println("2. Mostrar nombres");
            System.out.println("3. Girar ruleta");
            System.out.println("4. Guardar En Archivo");
            System.out.println("5. Cargar Desde Archivo");
            System.out.println("6. Eliminar nombre de la lista");
            System.out.println("7. Salir");
            System.out.println("Elige una opción: ");
            
            int opcion = lector.nextInt();
            lector.nextLine();//Limpiar buffer
            
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese un nombre: ");
                    String nombre = lector.nextLine().trim();
                   
                    try {
                        ruleta.agregarNombres(nombre);
                        System.out.println("Nombre ingresado con exito.");
                    } catch (IllegalArgumentException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    ruleta.mostrarNombres();
                    break;
                case 3:
                    try {
                    ruleta.girarRuleta();
                    } catch (IllegalArgumentException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Ingrese un nombre para el archivo: ");
                    String nombreA = lector.nextLine().trim();
                    try {
                        ruleta.guardarEnArchivo(nombreA);
                    }catch (IllegalArgumentException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;    
                case 5:
                    System.out.println("Ingrese el nombre del archivo:");
                    String nombreAcargar = lector.nextLine().trim();
                    try{
                        ruleta.cargarDesdeArchivo(nombreAcargar);
                    }catch (IllegalArgumentException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el nombre que desea eliminar:");
                    String nombreAEliminar = lector.nextLine().trim();
                    try{
                        ruleta.eliminarNombre(nombreAEliminar);
                        System.out.println("Nombre eliminado correctamente.");
                        System.out.println("¿Desea guardar los cambios en el archivo? {s/n}: ");
                        String respuestaG = lector.nextLine().trim();
                        if(respuestaG.equals("s")){
                            System.out.println("Ingrese el nombre del archivo para guardar: ");
                            String archivoGuardar = lector.nextLine().trim();
                            ruleta.guardarEnArchivo(archivoGuardar);
                        }
                    }catch (IllegalArgumentException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                case 7:
                    continuar= false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }     
        }
        
        System.out.println("¡Gracias por usar la ruleta!");
    }

}
