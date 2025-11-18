
package modelo;
public class Producto {
    
    
    private String nombre;
    private String Sku;
    private int cantidad;
    private double precio;
    private String Color;

    public Producto(String nombre, String Sku, int cantidad, double precio) {
        this.nombre = nombre;
        this.Sku = Sku;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSku() {
        return Sku;
    }

    public void setSku(String Sku) {
        this.Sku = Sku;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
    @Override
    public String toString(){
        return "Producto: "+nombre+"\n"+
               "Codigo: "+Sku+"\n"+ 
                "Cantidad: "+cantidad+"\n"+ 
                "Precio: "+precio;
    }
    
    
    
    

    
}
