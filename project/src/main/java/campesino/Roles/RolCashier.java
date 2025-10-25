package campesino.Roles;

import javax.swing.JOptionPane;

public class RolCashier extends Rol {
    public RolCashier() {
        super("Cajero");
    }
    @Override
    public void mostrarPermisos() {
        JOptionPane.showMessageDialog(null, "Permisos del Cajero: Manejo de caja y procesamiento de pagos.");
    }
}
