package campesino;

import campesino.controller.*;
import campesino.vista.*;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conexion = campesino.database.ConexionDatabase.getConnection();
        /* 
        ControladorProducto controlador = new ControladorProducto(conexion);

        
        AdministrarProductosView vista = new AdministrarProductosView(controlador);
        vista.setVisible(true);
        */

        Principalview principalView = new Principalview();
        principalView.setVisible(true);
    }
}