package campesino.controller;

// Importaciones necesarias
import campesino.dao.LoginDAO;
import campesino.modelo.Cuenta;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {
    private LoginDAO dao;

    public LoginController(Connection conexion) {
        this.dao = new LoginDAO(conexion);
    }

    public Cuenta autenticarUsuario(String nombre, String contraseña) {
        try {
            return dao.autenticar(nombre, contraseña);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error de autenticación: " + e.getMessage());
            return null;
        }
    }
    
    
}
