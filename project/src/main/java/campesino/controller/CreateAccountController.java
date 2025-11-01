package campesino.controller;

import campesino.dao.CuentaDAO;
import campesino.modelo.Cuenta;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class CreateAccountController {
    private CuentaDAO dao;

    public CreateAccountController(Connection conexion) {
        this.dao = new CuentaDAO(conexion);
    }

    public CreateAccountController() {
        // Constructor por defecto si es necesario
    }

    public void registrarCuenta(Cuenta cuenta) {
        try {
            dao.crearCuenta(cuenta);
            JOptionPane.showMessageDialog(null, "Cuenta registrada exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la cuenta: " + e.getMessage());
        }
    } 
}
