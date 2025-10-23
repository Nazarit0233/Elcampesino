package campesino.modelo.Roles;

public abstract class Rol {
    protected String nombre;

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Método que cada rol implementará de forma distinta
    public abstract void mostrarPermisos();
}