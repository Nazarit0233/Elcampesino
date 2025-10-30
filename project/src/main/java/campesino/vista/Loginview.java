package campesino.vista;

// Importaciones necesarias
import campesino.controller.*;
import campesino.modelo.*;
import campesino.vista.*;
import javax.swing.*;
import java.awt.*;

public class Loginview extends JFrame {

    private JTextField txtCuenta;
    private JPasswordField txtContraseña;
    private JButton btnLogin;


    public Loginview(LoginController controller) {
        setTitle("Inicio de Sesión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Cuenta:"));
        txtCuenta = new JTextField();
        add(txtCuenta);

        add(new JLabel("Contraseña:"));
        txtContraseña = new JPasswordField();
        add(txtContraseña);

        btnLogin = new JButton("Iniciar Sesión");
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            String cuenta = txtCuenta.getText();
            String contraseña = new String(txtContraseña.getPassword());

            Cuenta usuario = controller.autenticarUsuario(cuenta, contraseña);
            if (usuario != null) {
                JOptionPane.showMessageDialog(this, "✅ Inicio de sesión exitoso.");
                // Aquí puedes agregar la lógica para redirigir al usuario según su rol
            } else {
                JOptionPane.showMessageDialog(this, "❌ Credenciales incorrectas.");
            }
        });
    }    
}
