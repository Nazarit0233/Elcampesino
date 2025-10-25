package campesino.Roles;

import javax.swing.JOptionPane;

public class RolDealer extends Rol {
    public RolDealer() {
        super("Repartidor");
    }

    @Override
    public void mostrarPermisos() {
        JOptionPane.showMessageDialog(null, "Permisos del Repartidor: Entrega de productos a los clientes.");
    }
    
}
