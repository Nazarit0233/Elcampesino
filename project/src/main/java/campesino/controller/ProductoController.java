package campesino.controller;

// Importaciones necesarias
import campesino.dao.ProductoDAO;
import campesino.modelo.Producto;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductoController {
    private ProductoDAO dao;

    // Constructor del controlador que recibe la conexión a la base de datos
    public ProductoController(Connection conexion) {
        dao = new ProductoDAO(conexion);
    }

    // Métodos para gestionar productos
    // Crear
    public void registrarProducto(int id_stock,String nombre, double precio, int cantidad_disponible) {
        try {
            dao.registrarProducto(new Producto(id_stock, nombre, precio, cantidad_disponible));
            JOptionPane.showMessageDialog(null, "✅ Producto registrado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al registrar: " + e.getMessage());
        }
    }

    // Actualizar
    public void actualizarProducto(int id_stock, String nombre, double precio, int cantidad_disponible ) {
        try {
            dao.actualizarProducto(new Producto( id_stock, nombre, precio, cantidad_disponible));
            JOptionPane.showMessageDialog(null, "✅ Producto actualizado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al actualizar: " + e.getMessage());
        }
    }

    // Eliminar
    public void eliminarProducto(int id) {
        try {
            dao.eliminarProducto(id);
            JOptionPane.showMessageDialog(null, "🗑 Producto eliminado.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al eliminar: " + e.getMessage());
        }
    }

    // Leer
    public List<Producto> listarProductos() {
        try {
            return dao.listarProductos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al listar productos: " + e.getMessage());
            return null;
        }
    }
}
