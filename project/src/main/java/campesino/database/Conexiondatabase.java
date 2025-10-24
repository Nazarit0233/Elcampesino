package campesino.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ConexionDatabase {

    public static Connection connetion = null;

    public static Connection getConnection() {

        Properties properties = new Properties();

        if (connetion == null) {
            try {

                properties.load(new FileInputStream(new File("config.properties")));

                String url = properties.getProperty("database.url");
                String user = properties.getProperty("database.user");
                String password = properties.getProperty("database.password");

                connetion = DriverManager.getConnection(url, user, password);
                JOptionPane.showMessageDialog(null, "Conexion exitosa a la base de datos.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage());
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Archivo de configuracion no encontrado: " + e.getMessage());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo de configuracion: " + e.getMessage());
            }

        }
        return connetion;
    }

    public static void closeConnection() {
        if (connetion != null) {
            try {
                connetion.close();
                JOptionPane.showMessageDialog(null, "Conexion cerrada correctamente.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }

}