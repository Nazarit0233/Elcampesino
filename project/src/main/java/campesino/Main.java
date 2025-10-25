package campesino;

import java.sql.Connection;
import campesino.controlador.ControladorProducto;
import campesino.vista.AdministrarProductosView;

public class Main {
    public static void main(String[] args) {
        Connection conexion = campesino.database.ConexionDatabase.getConnection();
        
        ControladorProducto controlador = new ControladorProducto(conexion);

        AdministrarProductosView vista = new AdministrarProductosView(controlador);
        vista.setVisible(true);
    }
}