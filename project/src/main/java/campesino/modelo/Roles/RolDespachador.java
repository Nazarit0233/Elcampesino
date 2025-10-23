package campesino.modelo.Roles;

public class RolDespachador extends Rol {
    public RolDespachador() {
        super("Despachador");
    }

    @Override
    public void mostrarPermisos() {
        System.out.println("Permisos del Despachador: Gestión de envíos y entregas.");
    }
    
}
