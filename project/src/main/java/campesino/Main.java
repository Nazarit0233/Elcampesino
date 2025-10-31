package campesino;

// Importaciones necesarias
import campesino.database.*;
import campesino.modelo.*;
import campesino.controller.*;
import campesino.vista.*;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conexion = campesino.database.ConexionDatabase.getConnection();
        /* 
        ProductoController productoController = new ProductoController(conexion);

        AdministrarProductosView vista = new AdministrarProductosView(productoController);
        vista.setVisible(true);
        */

        LoginController loginController = new LoginController(conexion);

        Loginview vista = new Loginview(loginController);
        vista.setVisible(true);

        /* 
        PrincipalController principalController = new PrincipalController();
        
        Principalview principalView = new Principalview(principalController);
        principalView.setVisible(true);
        
        

        CreateAccountController createAccountController = new CreateAccountController(conexion);

        CreateAccountview createAccountView = new CreateAccountview(createAccountController);
        createAccountView.setVisible(true);
        */
    }
}