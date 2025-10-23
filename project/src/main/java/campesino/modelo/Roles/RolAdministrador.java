package campesino.modelo.Roles;

public class RolAdministrador extends Rol {
    public RolAdministrador() {
        super("Administrador");
    }

    @Override
    public void mostrarPermisos() {
        System.out.println("Permisos del Administrador: Acceso completo al sistema.");
    }   
}