package campesino.dao;

import campesino.modelo.Pedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    
    // Conexión a la base de datos
    private Connection conexion;

    // Constructor que recibe la conexión
    public PedidoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Aquí irían los métodos CRUD para la entidad Pedido
    // Crear
    public void registrarPedido(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO Pedido (id_Cuenta, fecha, total) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, pedido.getid_Cliente());
            ps.setDate(2, new java.sql.Date(pedido.getFechaPedido().getTime()));
            ps.setDouble(3, pedido.getTotalPedido());
            ps.executeUpdate();
        }
    }

    // Leer
    public List<Pedido> listarPedidos() throws SQLException {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM Pedido";
        try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Pedido(
                    rs.getInt("id_Pedido"),
                    rs.getInt("id_Cliente"),
                    rs.getInt("id_Estado_Pedido"),
                    rs.getTimestamp("fechaPedido"),
                    rs.getDouble("totalPedido"),
                    rs.getString("metodoPago"),
                    rs.getString("direccionEntrega")
                ));
            }
        }
        return lista;
    }
    
    // Eliminar
    public void eliminarPedido(int id) throws SQLException {
        String sql = "DELETE FROM Pedido WHERE id_Pedido = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // Actualizar
    public void actualizarPedido(Pedido pedido) throws SQLException {
        String sql = "UPDATE Pedido SET id_Cliente=?, id_Estado_Pedido=?, fechaPedido=?, totalPedido=?, metodoPago=?, direccionEntrega=? WHERE id_Pedido=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, pedido.getid_Cliente());
            ps.setInt(2, pedido.getid_Estado_Pedido());
            ps.setTimestamp(3, pedido.getFechaPedido());
            ps.setDouble(4, pedido.getTotalPedido());
            ps.setString(5, pedido.getMetodoPago());
            ps.setString(6, pedido.getDireccionEntrega());
            ps.setInt(7, pedido.getid_Pedido());
            ps.executeUpdate();
        }
    }


}
