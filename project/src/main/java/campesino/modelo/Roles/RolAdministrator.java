package campesino.modelo.Roles;

import javax.swing.JOptionPane;

public class RolAdministrator extends Rol {
    public RolAdministrator() {
        super("Administrador");
    }

    @Override
    public void mostrarPermisos() {
        JOptionPane.showMessageDialog(null, "Permisos del Administrador: Acceso completo al sistema.");
    }   
}