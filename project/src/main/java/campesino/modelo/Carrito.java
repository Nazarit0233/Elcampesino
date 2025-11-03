package campesino.modelo;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    
    private int id_Cliente;
    private List<ItemCarrito> items;
    private double total;
    private LocalDateTime fechaCreacion;

    public Carrito(int id_Cliente) {
        this.id_Cliente = id_Cliente;
        this.items = new ArrayList<>();
        this.total = 0.0;
        this.fechaCreacion = LocalDateTime.now();
    }

    // Agregar producto
    public void agregarProducto(Producto producto, int cantidad) {
        for (ItemCarrito item : items) {
            if (item.getProducto().getId_producto() == producto.getId_producto()) {
                item.setCantidad(item.getCantidad() + cantidad);
                calcularTotal();
                return;
            }
        }
        items.add(new ItemCarrito(producto, cantidad, producto.getPrecio()));
        calcularTotal();
    }

    // Eliminar producto
    public void eliminarProducto(int idProducto) {
        items.removeIf(item -> item.getProducto().getId_producto() == idProducto);
        calcularTotal();
    }

    // Calcular total
    public void calcularTotal() {
        total = 0;
        for (ItemCarrito item : items) {
            total += item.getSubtotal();
        }
    }

    // Vaciar carrito
    public void vaciarCarrito() {
        items.clear();
        total = 0;
    }

    public double getTotal() {
        return total;
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    
}
