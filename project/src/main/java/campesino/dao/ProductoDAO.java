package campesino.dao;

import campesino.modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private Connection conexion;

    public ProductoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void registrarProducto(Producto producto) throws SQLException {
        String sql = "INSERT INTO Producto (id_stock, nombre, precio, cantidad_disponible) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, producto.getId_stock());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad_disponible());
            ps.executeUpdate();
        }
    }

    public List<Producto> listarProductos() throws SQLException {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Producto";
        try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Producto(
                    rs.getInt("id_producto"),
                    rs.getInt("id_stock"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad_disponible")
                ));
            }
        }
        return lista;
    }

    public void eliminarProducto(int id) throws SQLException {
        String sql = "DELETE FROM Producto WHERE id_producto = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void actualizarProducto(Producto producto) throws SQLException {
        String sql = "UPDATE Producto SET id_stock=?, nombre=?, precio=?, cantidad_disponible=? WHERE id_producto=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, producto.getId_stock());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad_disponible());
            ps.setInt(5, producto.getId_producto());
            ps.executeUpdate();
        }
    }
}


