package campesino.controlador;

// Importaciones necesarias
import campesino.dao.ProductoDAO;
import campesino.modelo.Producto;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControladorProducto {
    private ProductoDAO dao;

    // Constructor del controlador que recibe la conexión a la base de datos
    public ControladorProducto(Connection conexion) {
        dao = new ProductoDAO(conexion);
    }

    // Métodos para gestionar productos
    public void registrarProducto(int id_stock,String nombre, double precio, int cantidad_disponible) {
        try {
            dao.registrarProducto(new Producto(id_stock, nombre, precio, cantidad_disponible));
            JOptionPane.showMessageDialog(null, "✅ Producto registrado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al registrar: " + e.getMessage());
        }
    }

    public void actualizarProducto(int id_stock, String nombre, double precio, int cantidad_disponible ) {
        try {
            dao.actualizarProducto(new Producto( id_stock, nombre, precio, cantidad_disponible));
            JOptionPane.showMessageDialog(null, "✅ Producto actualizado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminarProducto(int id) {
        try {
            dao.eliminarProducto(id);
            JOptionPane.showMessageDialog(null, "🗑 Producto eliminado.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al eliminar: " + e.getMessage());
        }
    }

    public List<Producto> listarProductos() {
        try {
            return dao.listarProductos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al listar productos: " + e.getMessage());
            return null;
        }
    }
}
