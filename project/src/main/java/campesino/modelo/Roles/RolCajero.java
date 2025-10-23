package campesino.modelo.Roles;

public class RolCajero extends Rol {
    public RolCajero() {
        super("Cajero");
    }
    @Override
    public void mostrarPermisos() {
        System.out.println("Permisos del Cajero: Manejo de caja y procesamiento de pagos.");
    }
}
