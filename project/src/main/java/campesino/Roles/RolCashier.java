package campesino.Roles;

// Importaciones necesarias
import javax.swing.JOptionPane;

public class RolCashier extends Rol {

    // Constructor
    public RolCashier() {
        super("Cashier");
    }

    @Override
    public void mostrarPermisos() {
        JOptionPane.showMessageDialog(null, "Permisos del Cajero: Manejo de caja y procesamiento de pagos.");
    }
}
