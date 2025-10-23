package campesino.modelo.Roles;

public class RolCliente extends Rol {
    public RolCliente() {
        super("Cliente");
    }

    @Override
    public void mostrarPermisos() {
        System.out.println("Permisos del Cliente: Acceso a productos y realización de compras.");
    }
    
}
