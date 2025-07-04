/**
 * Esta clase es la que arraca todo el programa.
 * Contiene el método main, que es el punto de entrada cuando se ejecuta el proyecto.
 * Se encarga de crear e iniciar el menú de la ruleta. 
 * 
 * @author (Ivo Narváez) 
 * @version(1.0)
 */
public class PrincipalRuleta
{
    /**
     * Método main que inicia la ejecución del programa.
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
