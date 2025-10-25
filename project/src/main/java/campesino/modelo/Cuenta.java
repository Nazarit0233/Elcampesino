package campesino.modelo;

import javax.swing.JOptionPane;

import campesino.modelo.Roles.Rol;

public class Cuenta {
    private int id_Cuenta;
    private Rol rol;
    private String nombre;
    private String correoElectronico;
    private String contraseña;
    private String telefono;

    // Constructor vacío
    public Cuenta() {
    }

    // Constructor con todos los campos (excepto id autogenerado)
    public Cuenta(Rol rol, String nombre, String correoElectronico, String contraseña, String telefono) {
        this.rol = rol;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.telefono = telefono;

    }

    // Constructor completo (por si se carga desde BD)
    public Cuenta(int id_Cuenta, Rol rol, String nombre, String correoElectronico, String contraseña, String telefono) {
        this.id_Cuenta = id_Cuenta;
        this.rol = rol;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.telefono = telefono;

    }

    public void mostrarInfoCuenta() {
        JOptionPane.showMessageDialog(null, "ID cuenta: " + id_Cuenta +
                "\nUsuario: " + nombre +
                "\nRol: " + rol.getNombre() +
                "\nCorreo Electrónico: " + correoElectronico +
                "\nTeléfono: " + telefono);

        rol.mostrarPermisos();
    }

    // Getters y Setters
    public int getId_Cuenta() {
        return id_Cuenta;
    }

    public void setId_Cuenta(int id_Cuenta) {
        this.id_Cuenta = id_Cuenta;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Metodo toString (para mostrar en JoptionPane o consola)
    @Override
    public String toString() {
        return "Cuenta{" +
                "id_Cuenta=" + id_Cuenta +
                ", rol=" + rol.getNombre() +
                ", nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

}