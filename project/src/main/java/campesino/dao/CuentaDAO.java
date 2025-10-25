package campesino.dao;

// Importaciones necesarias
import campesino.modelo.Cuenta;
import campesino.Roles.Rol;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAO {
    // Conexion a la base de datos
    private Connection conexion;

    // Constructor que recibe la conexión
    public CuentaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Métodos CRUD para la cuenta
    // Crear
    public void registrarCuenta(Cuenta cuenta) throws SQLException {
        String sql = "INSERT INTO Cuenta ( rol, nombre, correoElectronico, contraseña, telefono ) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, cuenta.getRol().getNombre());
            ps.setString(2, cuenta.getNombre());
            ps.setString(3, cuenta.getCorreoElectronico());
            ps.setString(4, cuenta.getContraseña());
            ps.setString(5, cuenta.getTelefono());
            ps.executeUpdate();
        }
    }

    // Leer
    public List<Cuenta> listarCuentas() throws SQLException {
        List<Cuenta> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cuenta";
        try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                // Aquí deberías mapear el rol correctamente según tu implementación
                Rol rol = obtenerRolDesdeNombre(rs.getString("rol"));
                lista.add(new Cuenta(
                    rs.getInt("id_Cuenta"),
                    rol,
                    rs.getString("nombre"),
                    rs.getString("correoElectronico"),
                    rs.getString("contraseña"),
                    rs.getString("telefono")
                ));
            }
        }
        return lista;
    }

    // Eliminar
    public void eliminarCuenta(int id) throws SQLException {
        String sql = "DELETE FROM Cuenta WHERE id_Cuenta = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // Actualizar
    public void actualizarCuenta(Cuenta cuenta) throws SQLException {
        String sql = "UPDATE Cuenta SET rol=?, nombre=?, correoElectronico=?, contraseña=?, telefono=? WHERE id_Cuenta=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, cuenta.getRol().getNombre());
            ps.setString(2, cuenta.getNombre());
            ps.setString(3, cuenta.getCorreoElectronico());
            ps.setString(4, cuenta.getContraseña());
            ps.setString(5, cuenta.getTelefono());
            ps.setInt(6, cuenta.getId_Cuenta());
            ps.executeUpdate();
        }
    }

    // Método auxiliar para obtener el rol desde su nombre
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
            return new campesino.Roles.RolDealer();
        } else {
            return null; // O lanzar una excepción si el rol no es válido
        }

}
}