package campesino.vista.vistaSwing;

// Importaciones necesarias
import campesino.database.*;
import campesino.controller.*;
import campesino.vista.*;
import campesino.dao.*;
import campesino.modelo.*;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Loginview extends JFrame {
    private static final String ROLE_ADMIN = "Administrator";
    private static final String ROLE_CLIENT = "Client";
    private static final String ROLE_DELIVERY = "Delivery";
    private static final String ROLE_CASHIER = "Cashier";
    private static final String ROLE_DISPATCHER = "Dispatcher";

    private JTextField txtCuenta;
    private JPasswordField txtContraseña;
    private JButton btnLogin;
    private JButton btnCrearCuenta; // Nuevo botón

    public Loginview(LoginController controller) {
        setTitle("Inicio de Sesión");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Credenciales de cuenta
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Ingrese sus credenciales"));

        panelFormulario.add(new JLabel("Cuenta:"));
        txtCuenta = new JTextField();
        panelFormulario.add(txtCuenta);

        panelFormulario.add(new JLabel("Contraseña:"));
        txtContraseña = new JPasswordField();
        panelFormulario.add(txtContraseña);
        add(panelFormulario, BorderLayout.CENTER);

        // Panel de botones modificado
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnLogin = new JButton("Iniciar Sesión");
        btnCrearCuenta = new JButton("Crear Cuenta");
        
        panelBotones.add(btnLogin);
        panelBotones.add(btnCrearCuenta); // Añadir nuevo botón
        add(panelBotones, BorderLayout.SOUTH);

        // Evento del botón login
        btnLogin.addActionListener(e -> {
            if (validarCampos()) {
                autenticarUsuario(controller);
            }
        });

        // Evento del botón crear cuenta
        btnCrearCuenta.addActionListener(e -> {
            try {
                // Obtener la conexión usando tu clase de conexión a base de datos
                Connection conexion = ConexionDatabase.getConnection(); ;
                
                // Crear controlador y vista
                CreateAccountController createController = new CreateAccountController(conexion);
                CreateAccountviewswing createAccountView = new CreateAccountviewswing(createController);
                
                // Mostrar la vista y ocultar el login
                createAccountView.setVisible(true);
                this.setVisible(false);
                
                createAccountView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        Loginview.this.setVisible(true);
                    }
                });
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Error al conectar con la base de datos: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    private boolean validarCampos() {
        if (txtCuenta.getText().trim().isEmpty() || 
            new String(txtContraseña.getPassword()).trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor complete todos los campos", 
                "Campos vacíos", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void autenticarUsuario(LoginController controller) {
        String cuenta = txtCuenta.getText().trim();
        String contraseña = new String(txtContraseña.getPassword()).trim();

        Cuenta usuario = controller.autenticarUsuario(cuenta, contraseña);
        if (usuario != null) {
            JOptionPane.showMessageDialog(this, "✅ Inicio de sesión exitoso.");
            abrirVistaPorRol(usuario.getRol().getNombre());
            this.dispose(); // Cerrar ventana de login
        } else {
            JOptionPane.showMessageDialog(this, "❌ Credenciales incorrectas.");
        }
    }

    private void abrirVistaPorRol(String rolNombre) {
        JFrame nuevaVista = crearVistaPorRol(rolNombre);
        if (nuevaVista != null) {
            nuevaVista.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, 
                "Error: Rol no reconocido", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private JFrame crearVistaPorRol(String rolNombre) {
        return switch (rolNombre) {
            case ROLE_ADMIN -> new Principalview();
            case ROLE_CLIENT -> new Clientview();
            case ROLE_DELIVERY -> new Deliveryview();
            case ROLE_CASHIER -> new Cashierview();
            case ROLE_DISPATCHER -> new Dispatcherview();
            default -> null;
        };
    }
}
