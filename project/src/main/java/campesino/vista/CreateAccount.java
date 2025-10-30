package campesino.vista;

// Importaciones necesarias

import campesino.controller.*;
import campesino.modelo.*;
import campesino.vista.*;
import javax.swing.*;
import java.awt.*;

public class CreateAccount extends JFrame {

    private JTextField txtCuenta;
    private JPasswordField txtContraseña;
    private JComboBox<String> comboRol;
    private JButton btnCrear;

    public CreateAccount(CreateAccountController controller) {
        setTitle("Crear Cuenta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Cuenta:"));
        txtCuenta = new JTextField();
        add(txtCuenta);

        add(new JLabel("Contraseña:"));
        txtContraseña = new JPasswordField();
        add(txtContraseña);

        add(new JLabel("Rol:"));
        comboRol = new JComboBox<>(new String[]{"Administrator, Cashier, Client, Delivery, Dispatcher"});
        add(comboRol);

        btnCrear = new JButton("Crear Cuenta");
        add(btnCrear);

        btnCrear.addActionListener(e -> {
            String cuenta = txtCuenta.getText();
            String contraseña = new String(txtContraseña.getPassword());
            String rol = (String) comboRol.getSelectedItem();

            campesino.modelo.Cuenta nuevaCuenta = new campesino.modelo.Cuenta(rol, cuenta, contraseña);
            controller.registrarCuenta(nuevaCuenta);
        });
    }
    
}
