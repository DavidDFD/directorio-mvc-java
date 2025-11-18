
package modelo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseDeDatos {
    
    
    private List<Producto>productos;

    public BaseDeDatos() {
        this.productos = new  ArrayList<>(); 
    }
    
    public void agregarProducto(Producto producto){
        
     this.productos.add(producto);   
    }
        
    
    
    
    public Producto buscarProductoSku(String Sku){
        
        
        for (Producto p : productos) {
            if (p.getSku().equalsIgnoreCase(Sku)) {
                return p; 
            }
        }
        return null; 
    }
    
    public List<Producto> buscarTodos(){
        
        return new ArrayList<>(productos);
    }
    
    public boolean eliminarProducto(String Sku){
        Iterator<Producto> iterator = productos.iterator();
        
        while (iterator.hasNext()) {
            Producto p = iterator.next();
            if (p.getSku().equalsIgnoreCase(Sku)) {
                iterator.remove(); 
                return true; 
            }
        }
        return false; 
        
        //Prueba 78
    }
        
    //Prueba roca lite 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
