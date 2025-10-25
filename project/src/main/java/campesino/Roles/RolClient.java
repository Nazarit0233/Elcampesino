package campesino.Roles;

// Importaciones necesarias
import javax.swing.JOptionPane;

public class RolClient extends Rol {
    
    // Constructor
    public RolClient() {
        super("Client");
    }

    @Override
    public void mostrarPermisos() {
        JOptionPane.showMessageDialog(null, "Permisos del Cliente: Acceso a productos y realización de compras.");
    }

}
