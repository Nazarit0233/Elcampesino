package campesino.vista.vistaSwing;

import campesino.controller.ProductoController;
import campesino.modelo.Producto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AdministrarProductosView extends JFrame {

    // Atributos
    private ProductoController controlador;
    private JTable tabla;
    private JTextField txtNombre, txtPrecio, txtCantidad, txtId;

    // Constructor
    public AdministrarProductosView(ProductoController controlador) {
        this.controlador = controlador;
        inicializar();
    }

    // Método para inicializar la interfaz gráfica
    private void inicializar() {
        setTitle("Gestión de Productos - Carnes y Pollos El Campesino (MySQL)");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));

        // Campos modificables del producto
        panelFormulario.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelFormulario.add(txtId);

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panelFormulario.add(txtPrecio);

        panelFormulario.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        panelFormulario.add(txtCantidad);
        add(panelFormulario, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnRefrescar = new JButton("Refrescar");

        // Agregar acciones a los botones
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnRefrescar);
        add(panelBotones, BorderLayout.SOUTH);

        // Tabla para mostrar productos
        tabla = new JTable();
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);
        cargarTabla();

        // Acciones de los botones
        btnRegistrar.addActionListener(e -> {
            controlador.registrarProducto(Integer.parseInt(txtId.getText()),
                    txtNombre.getText(),
                    Double.parseDouble(txtPrecio.getText()),
                    Integer.parseInt(txtCantidad.getText()));
            cargarTabla();
        });

        btnActualizar.addActionListener(e -> {
            controlador.actualizarProducto(
                    Integer.parseInt(txtId.getText()),
                    txtNombre.getText(),
                    Double.parseDouble(txtPrecio.getText()),
                    Integer.parseInt(txtCantidad.getText()));
            cargarTabla();
        });

        btnEliminar.addActionListener(e -> {
            controlador.eliminarProducto(Integer.parseInt(txtId.getText()));
            cargarTabla();
        });

        btnRefrescar.addActionListener(e -> cargarTabla());

        tabla.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && tabla.getSelectedRow() != -1) {
                txtId.setText(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
                txtNombre.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
                txtPrecio.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
                txtCantidad.setText(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
            }
        });
    }

    // Método para cargar los productos en la tabla
    private void cargarTabla() {
        List<Producto> lista = controlador.listarProductos();
        String[] columnas = {"ID", "Nombre", "Precio", "Cantidad"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        if (lista != null) {
            for (Producto p : lista) {
                Object[] fila = {p.getId_producto(), p.getNombre(), p.getPrecio(), p.getCantidad_disponible()};
                modelo.addRow(fila);
            }
        }
        tabla.setModel(modelo);
    }
}
