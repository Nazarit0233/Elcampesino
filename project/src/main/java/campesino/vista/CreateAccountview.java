package campesino.vista;

// Importaciones necesarias

import campesino.controller.*;
import campesino.modelo.*;
import campesino.vista.*;
import campesino.Roles.*;
import javax.swing.*;
import java.awt.*;

public class CreateAccountview extends JFrame {

    private JTextField txtCuenta;
    private JPasswordField txtContraseña;
    private JComboBox<String> comboRol;
    private JButton btnCrear;

    public CreateAccountview(CreateAccountController controller) {
        setTitle("Crear Cuenta");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Credenciales de nueva cuenta
        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Ingrese los datos de la nueva cuenta"));
        
        panelFormulario.add(new JLabel("Cuenta (correo):"));
        txtCuenta = new JTextField();
        panelFormulario.add(txtCuenta);

        panelFormulario.add(new JLabel("Contraseña:"));
        txtContraseña = new JPasswordField();
        panelFormulario.add(txtContraseña);

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

            // Construir Cuenta con Rol (uso correo como nombre y correo; teléfono vacío)
            campesino.modelo.Cuenta nuevaCuenta = new campesino.modelo.Cuenta(rolObj, cuenta, cuenta, contraseña, "");
            controller.registrarCuenta(nuevaCuenta);
        });
    }
    
}
