package campesino.modelo;

import javax.swing.JOptionPane;

import campesino.modelo.Roles.Rol;

public class Cuenta {
    private Rol rol;
    private String nombre;
    private String correoElectronico;
    private String contraseña;
    private String telefono;

    public Cuenta(Rol rol, String nombre, String correoElectronico, String contraseña, String telefono) {
        this.rol = rol;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.telefono = telefono;

    }

    public void mostrarInfoCuenta() {
        JOptionPane.showMessageDialog(null, "Usuario: " + nombre + 
            "\nRol: " + rol.getNombre() +
            "\nCorreo Electrónico: " + correoElectronico + 
            "\nTeléfono: " + telefono);

        rol.mostrarPermisos();
    }
}