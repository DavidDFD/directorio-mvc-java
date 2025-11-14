package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Producto;


public class InventarioVista {

    private Scanner scanner; 

    public InventarioVista() {
        this.scanner = new Scanner(System.in);
    }

    /***+
     * Imprime el menú de opciones y retorna la opción seleccionada por el usuario.
     * @return El número de la opción seleccionada.
     */
    public int mostrarMenu() {
        System.out.println("\n--- Menú de Inventario DevSolutions ---");
        System.out.println("1. Agregar un nuevo producto");
        System.out.println("2. Buscar un producto por SKU");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar un producto");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

        int opcion = -1;
        try {
            String input = scanner.nextLine(); 
            opcion = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            mostrarMensaje("Opción inválida. Por favor, ingrese un número del 1 al 5.");
        }
        return opcion;
    }

    /**
     * **MODIFICADO:** Solicita al usuario los datos para un nuevo producto y crea el objeto Producto.
     * @return El nuevo objeto Producto creado con los datos del usuario.
     */
    public Producto pedirDatosUsuario() { 
        System.out.println("\n--- Agregar Nuevo Producto ---");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("SKU: ");
        String sku = scanner.nextLine();

        int cantidad = -1;
        while (cantidad < 0) {
            try {
                System.out.print("Cantidad (Stock): ");
                cantidad = Integer.parseInt(scanner.nextLine());
                if (cantidad < 0) {
                    mostrarMensaje("La cantidad no puede ser negativa.");
                }
            } catch (NumberFormatException e) {
                mostrarMensaje("Entrada inválida. Por favor, ingrese un número entero para la cantidad.");
            }
        }

        double precio = -1.0;
        while (precio < 0.0) {
            try {
                System.out.print("Precio Unitario: ");
                precio = Double.parseDouble(scanner.nextLine());
                if (precio < 0.0) {
                    mostrarMensaje("El precio no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                mostrarMensaje("Entrada inválida. Por favor, ingrese un número decimal o entero para el precio.");
            }
        }

        return new Producto(nombre, sku, cantidad, precio);
    }

    /**
     * Solicita al usuario que ingrese un código SKU.
     * @return El código SKU ingresado por el usuario.
     */
    public String pedirSku() {
        System.out.print("Ingrese el código SKU: ");
        return scanner.nextLine();
    }

    /**
     * Muestra la información de un producto o un mensaje de no encontrado.
     * @param producto El objeto Producto a mostrar, puede ser null.
     */
    public void mostrarProducto(Producto producto) {
        if (producto != null) {
            System.out.println("\n--- Producto Encontrado ---");
            System.out.println(producto.toString());
        } else {
            System.out.println("\nProducto no encontrado.");
        }
    }

    /**
     * Muestra la lista completa de productos registrados.
     * @param productos La lista de objetos Producto a imprimir.
     */
    public void mostrarProductos(List<Producto> productos) {
        System.out.println("\n--- Inventario Completo ---");
        if (productos == null || productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto p : productos) {
                System.out.println(p.toString());
            }
        }
    }

    /**
     * Método genérico para mostrar mensajes de éxito o error al usuario.
     * @param mensaje El mensaje a mostrar.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n[INFO] " + mensaje);
    }
}