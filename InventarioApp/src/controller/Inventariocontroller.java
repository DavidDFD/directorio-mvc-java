package controller;

import modelo.BaseDeDatos; 
import modelo.Producto;
import vista.InventarioVista;
import java.util.List;

public class Inventariocontroller {

    private final BaseDeDatos modelo;
    private final InventarioVista vista;

    public Inventariocontroller(BaseDeDatos modelo, InventarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Método principal que inicia la aplicación y gestiona el menú
    public void iniciar() {
        int opcion;
        boolean salir = false;

        while (!salir) {
            opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    buscarProducto();
                    break;
                case 3:
                    mostrarProductos();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo del sistema. ¡Hasta pronto!");
                    salir = true;
                    break;
                default:
                    // La vista maneja el -1, pero aquí capturamos otros números fuera del rango 1-5
                    if (opcion != -1) { 
                        vista.mostrarMensaje("Opción no reconocida. Intente de nuevo.");
                    }
                    break;
            }
        }
    }

    // --- Lógica del Controlador para el CRUD ---

    private void agregarProducto() {
        // 1. Pide datos a la Vista y crea el objeto Producto
        Producto nuevoProducto = vista.pedirDatosUsuario(); 
        
        // **VALIDACIÓN CLAVE:** Verifica si el SKU ya existe antes de agregarlo.
        // Si buscarProductoSku() retorna algo diferente de null, ya existe.
        if (modelo.buscarProductoSku(nuevoProducto.getSku()) == null) {
            
            // 2. Si no existe, invoca al Modelo para guardarlo.
            modelo.agregarProducto(nuevoProducto); 
            
            // 3. Muestra el resultado
            vista.mostrarMensaje("Producto agregado con éxito: " + nuevoProducto.getSku());
        } else {
            vista.mostrarMensaje("ERROR: Ya existe un producto con el SKU " + nuevoProducto.getSku() + ". No se puede agregar.");
        }
    }

    private void buscarProducto() {
        // 1. Pide el SKU a la Vista
        String sku = vista.pedirSku();
        
        // 2. Invoca al Modelo (usa el nombre del método de tu compañero)
        Producto productoEncontrado = modelo.buscarProductoSku(sku);
        
        // 3. Muestra el resultado (la vista maneja si es null o no)
        vista.mostrarProducto(productoEncontrado); 
    }
    
    private void mostrarProductos() {
        // 1. Invoca al Modelo (usa el nombre del método de tu compañero)
        List<Producto> lista = modelo.buscarTodos(); 
        
        // 2. Muestra el resultado
        vista.mostrarProductos(lista); 
    }

    private void eliminarProducto() {
        // 1. Pide el SKU a la Vista
        String sku = vista.pedirSku();
        
        // 2. Invoca al Modelo (el método ya retorna true/false, perfecto para la lógica)
        if (modelo.eliminarProducto(sku)) {
            
            // 3. Muestra el resultado
            vista.mostrarMensaje("Producto con SKU " + sku + " eliminado con éxito.");
        } else {
            vista.mostrarMensaje("ERROR: No se encontró ningún producto con el SKU: " + sku + " para eliminar.");
        }
    }
}