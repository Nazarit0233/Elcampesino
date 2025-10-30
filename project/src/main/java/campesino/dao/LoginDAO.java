package campesino.dao;

// Importaciones necesarias
import java.sql.*;
import campesino.modelo.Cuenta;
import campesino.Roles.Rol;

public class LoginDAO {
    
    private Connection conexion;

    public LoginDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public Cuenta autenticar(String nombre, String contraseña) throws SQLException {
        String sql = "SELECT * FROM Cuenta WHERE correoElectronico = ? AND contraseña = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, contraseña);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Rol rol = obtenerRolDesdeNombre(rs.getString("rol"));
                    return new Cuenta(
                        rs.getInt("id_Cuenta"),
                        rol,
                        rs.getString("nombre"),
                        rs.getString("correoElectronico"),
                        rs.getString("contraseña"),
                        rs.getString("telefono")
                    );
                } else {
                    return null; // Autenticación fallida
                }
            }
        }
    }
    private Rol obtenerRolDesdeNombre(String nombreRol) {
        if (nombreRol.equals("Administrator")) {
            return new campesino.Roles.RolAdministrator();
        } else if (nombreRol.equals("Client")) {
            return new campesino.Roles.RolClient();
        } else if (nombreRol.equals("Cashier")) {
            return new campesino.Roles.RolCashier();
        } else if (nombreRol.equals("Dispatcher")) {
            return new campesino.Roles.RolDispatcher();
        } else if (nombreRol.equals("Dealer")) {
            return new campesino.Roles.RolDelivery();
        } else {
            return null; // O lanzar una excepción si el rol no es válido
        }
    }
    
}
