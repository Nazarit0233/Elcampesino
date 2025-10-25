package campesino;

import campesino.controlador.ControladorProducto;
import campesino.vista.AdministrarProductosView;

public class Main {
    public static void main(String[] args) {
        ControladorProducto controlador = new ControladorProducto(campesino.database.ConexionDatabase.getConnection());

        AdministrarProductosView vista = new AdministrarProductosView(controlador);
        vista.setVisible(true);
    }
}