package campesino.Roles;

// Importaciones necesarias
import javax.swing.JOptionPane;

public class RolAdministrator extends Rol {

    // Constructor
    public RolAdministrator() {
        super("Administrador");
    }

    @Override
    public void mostrarPermisos() {
        JOptionPane.showMessageDialog(null, "Permisos del Administrador: Acceso completo al sistema.");
    }
}