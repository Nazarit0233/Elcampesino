package campesino.Roles;

// Importaciones necesarias
import javax.swing.JOptionPane;

public class RolDispatcher extends Rol {
    
    // Constructor
    public RolDispatcher() {
        super("Despachador");
    }

    @Override
    public void mostrarPermisos() {
        JOptionPane.showMessageDialog(null, "Permisos del Despachador: Gestión de envíos y entregas.");
    }
    
}
