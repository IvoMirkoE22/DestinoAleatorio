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
    /**
     * Constructor de la clase MenuRuleta
     * Inicializa una nueva instancia de RuletaAleatoria y el lector de entradas.
     */   
    private RuletaAleatoria ruleta;
    
    private Scanner lector;
    /**
     * Constructor for objects of class MenuRuleta
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
     * Salir del programa
     * 
     * El ciclo continúa hasta que el usuario decide salir.
     */
    public void inciciarMenu(){
        boolean continuar = true;
        while (continuar){
            System.out.println("\n---Menú Ruleta ---");
            System.out.println("1. Agregar nombre");
            System.out.println("2. Mostrar nombres");
            System.out.println("3. Girar ruleta");
            System.out.println("4. Salir");
            System.out.println("Elige una opción: ");
            
            int opcion = lector.nextInt();
            lector.nextLine();//Limpiar buffer
            
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese un nombre: ");
                    String nombre = lector.nextLine().trim();
                   
                    try {
                        ruleta.agregarNombres(nombre);
                        System.out.println("Nombre ingresado con exito");
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
                    continuar= false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }     
        }
        
        System.out.println("¡Gracias por usar la ruleta!");
    }

}
