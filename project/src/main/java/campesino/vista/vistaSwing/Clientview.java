package campesino.vista.vistaSwing;

// Importaciones necesarias
import campesino.controller.*;
import campesino.modelo.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Clientview extends JFrame {

    private JTable tablaProductos;
    private JTextField txtProducto;
    private JTextField txtCantidad;
    private JTextField txtDireccionEntrega;
    private JTextField txtTotal;
    private JComboBox<String> comboMetodoPago;
    private JButton btnBuscar;
    private JButton btnAgregarAlCarrito;
    private JButton btnRealizarPedido;
    private JButton btnVerCarrito;
    
    public Clientview() {
        
        setTitle("Vista del Cliente");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(0, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Realizar Pedido"));
        
        panelFormulario.add(new JLabel("Buscar Producto:"));
        txtProducto = new JTextField();
        panelFormulario.add(txtProducto);
        add(panelFormulario, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        btnBuscar = new JButton("Buscar");
        btnAgregarAlCarrito = new JButton("Agregar al Carrito");
        
    }
    
}
