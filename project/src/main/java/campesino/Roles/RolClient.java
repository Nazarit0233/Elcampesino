package campesino.Roles;

import javax.swing.JOptionPane;

public class RolClient extends Rol {
    public RolClient() {
        super("Cliente");
    }

    @Override
    public void mostrarPermisos() {
        JOptionPane.showMessageDialog(null, "Permisos del Cliente: Acceso a productos y realización de compras.");
    }
    
}
