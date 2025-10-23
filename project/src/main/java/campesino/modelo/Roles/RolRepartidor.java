package campesino.modelo.Roles;

public class RolRepartidor extends Rol {
    public RolRepartidor() {
        super("Repartidor");
    }

    @Override
    public void mostrarPermisos() {
        System.out.println("Permisos del Repartidor: Entrega de productos a los clientes.");
    }
    
}
