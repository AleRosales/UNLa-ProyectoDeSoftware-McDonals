package unla.ProyectoSoftware.modelo;

import java.io.Serializable;

public class ItemCarrito implements Serializable {

    private Producto producto;

    private int cantidad;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
