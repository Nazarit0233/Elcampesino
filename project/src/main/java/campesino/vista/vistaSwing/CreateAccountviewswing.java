package campesino.vista.vistaSwing;

// Importaciones necesarias
import campesino.controller.*;
import campesino.Roles.*;
import javax.swing.*;
import java.awt.*;

public class CreateAccountviewswing extends JFrame {

    private JTextField txtCuenta;
    private JPasswordField txtContraseña;
    private JComboBox<String> comboRol;
    private JTextField txtCorreElectronico;
    private JTextField txtTelefono;
    private JButton btnCrear;

    public CreateAccountviewswing(CreateAccountController controller) {
        
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        

        // Credenciales de nueva cuenta
        JPanel panelFormulario = new JPanel(new GridLayout(0, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Ingrese los datos de la nueva cuenta"));
        
        panelFormulario.add(new JLabel("Nombre:"));
        txtCuenta = new JTextField();
        panelFormulario.add(txtCuenta);

        panelFormulario.add(new JLabel("Contraseña:"));
        txtContraseña = new JPasswordField();
        panelFormulario.add(txtContraseña);

        panelFormulario.add(new JLabel("Correo:"));
        txtCorreElectronico = new JTextField();
        panelFormulario.add(txtCorreElectronico);

        panelFormulario.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panelFormulario.add(txtTelefono);

        panelFormulario.add(new JLabel("Rol:"));
        comboRol = new JComboBox<>(new String[]{"Administrator", "Cashier", "Client", "Delivery", "Dispatcher"});
        panelFormulario.add(comboRol);
        add(panelFormulario, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        btnCrear = new JButton("Crear Cuenta");
        
        // Agregar acción al botón
        panelBotones.add(btnCrear);
        add(panelBotones, BorderLayout.SOUTH);

        // Acción del botón de crear cuenta
        btnCrear.addActionListener(e -> {
            String cuenta = txtCuenta.getText().trim();
            String contraseña = new String(txtContraseña.getPassword()).trim();
            String rolSeleccionado = (String) comboRol.getSelectedItem();
            String correo = txtCorreElectronico.getText().trim();
            String telefono = txtTelefono.getText().trim();

            // Mapear nombre de rol a objeto Rol
            Rol rolObj;
            switch (rolSeleccionado) {
                case "Administrator":
                    rolObj = new RolAdministrator();
                    break;
                case "Cashier":
                    rolObj = new RolCashier();
                    break;
                case "Client":
                    rolObj = new RolClient();
                    break;
                case "Delivery":
                    rolObj = new RolDelivery();
                    break;
                case "Dispatcher":
                    rolObj = new RolDispatcher();
                    break;
                default:
                    rolObj = null;
            }

            if (rolObj == null) {
                JOptionPane.showMessageDialog(this, "Rol inválido.");
                return;
            }

            // Crear nueva cuenta y llamar al controlador
            campesino.modelo.Cuenta nuevaCuenta = new campesino.modelo.Cuenta(
                rolObj,
                cuenta,
                correo,
                contraseña,
                telefono
            );
            controller.registrarCuenta(nuevaCuenta);
        });
    }
    
}
