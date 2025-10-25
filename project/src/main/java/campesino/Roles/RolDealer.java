package campesino.Roles;

// Importaciones necesarias
import javax.swing.JOptionPane;

public class RolDealer extends Rol {
    
    // Constructor
    public RolDealer() {
        super("Repartidor");
    }

    @Override
    public void mostrarPermisos() {
        JOptionPane.showMessageDialog(null, "Permisos del Repartidor: Entrega de productos a los clientes.");
    }
    
}
