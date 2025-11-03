package campesino.controller;

// Importaciones necesarias
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;


public class PrincipalController {
    private view;

    public PrincipalController(Connection conexion) {
        // Inicialización si es necesario
        view = new Principalview(conexion);
    }
    
}
