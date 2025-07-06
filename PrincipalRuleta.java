/**
 * Clase principal del proyecto Ruleta.
 * 
 * Esta clase contiene el método main, que es el punto de entrada del programa.
 * Se encarga de crear e inciar el menú interactivo en consola.
 * 
 
 * @author (Ivo Narváez) 
 * @version(1.0)
 */
public class PrincipalRuleta
{
    /**
     * Método main que inicia la ejecución del programa.
     * 
     * @param args parámetro de línea de comando (no utlizados en este programa).
     */
    public static void main(String args[]){
        
        /**
         * Crea una instancia de la clase MenuRuleta con new MenuRuleta()
         */
        MenuRuleta ruleta = new MenuRuleta();
        
        /**
         * Llamamos al método iniciarMenu(), que inicia el menú interactivo
         * por consola.
         */
        ruleta.iniciarMenu();
    }
}
