package campesino.Roles;

// Importaciones necesarias
import javax.swing.JOptionPane;

public class RolDelivery extends Rol {
    
    // Constructor
    public RolDelivery() {
        super("Delivery");
    }

    @Override
    public void mostrarPermisos() {
        JOptionPane.showMessageDialog(null, "Permisos del Repartidor: Entrega de productos a los clientes.");
    }
    
}
