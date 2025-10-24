package campesino.modelo.Roles;

import javax.swing.JOptionPane;

public class RolDispatcher extends Rol {
    public RolDispatcher() {
        super("Despachador");
    }

    @Override
    public void mostrarPermisos() {
        JOptionPane.showMessageDialog(null, "Permisos del Despachador: Gestión de envíos y entregas.");
    }
    
}
