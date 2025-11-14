

import modelo.BaseDeDatos; 
import vista.InventarioVista;
import controller.Inventariocontroller;


public class App { 
    public static void main(String[] args) {
        
        //  Crear la instancia de `BaseDeDatos` (Modelo).
        BaseDeDatos modelo = new BaseDeDatos();
        
        // Crear la instancia de `InventarioVista` (Vista).
        InventarioVista vista = new InventarioVista();
        
        // Crear la instancia de `InventarioController` (Controlador) e inyectarle el modelo y la vista.
        Inventariocontroller controlador = new Inventariocontroller(modelo, vista); 
        
        //  Llamar a `controlador.iniciar()`.
        controlador.iniciar(); 
    }
}
