/*package campesino.vista.vistaFx;

// Importaciones necesarias
import campesino.Roles.*;
import campesino.controller.*;
import campesino.modelo.Cuenta;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CreateAccountViewFX extends Application {

    private TextField txtCuenta;
    private PasswordField txtContraseña;
    private ComboBox<String> comboRol;
    private TextField txtCorreoElectronico;
    private TextField txtTelefono;
    private Button btnCrear;

    private CreateAccountController controller;

    public CreateAccountViewFX(CreateAccountController controller) {
        // Constructor vacío requerido por JavaFX
        this.controller = new CreateAccountController();
    }
    

    @Override
    public void start(Stage stage) {
        stage.setTitle("Crear Nueva Cuenta - Carnes y Pollos El Campesino");
        stage.setWidth(700);
        stage.setHeight(400);

        // --- Formulario principal ---
        GridPane form = new GridPane();
        form.setPadding(new Insets(20));
        form.setHgap(10);
        form.setVgap(10);
        form.setStyle("-fx-border-color: #ccc; -fx-border-radius: 5; -fx-border-width: 1;");

        // Campos
        txtCuenta = new TextField();
        txtContraseña = new PasswordField();
        txtCorreoElectronico = new TextField();
        txtTelefono = new TextField();
        comboRol = new ComboBox<>();
        comboRol.getItems().addAll("Administrator", "Cashier", "Client", "Delivery", "Dispatcher");
        comboRol.getSelectionModel().selectFirst();

        // Añadir al formulario
        form.addRow(0, new Label("Nombre de Usuario:"), txtCuenta);
        form.addRow(1, new Label("Contraseña:"), txtContraseña);
        form.addRow(2, new Label("Correo Electrónico:"), txtCorreoElectronico);
        form.addRow(3, new Label("Teléfono:"), txtTelefono);
        form.addRow(4, new Label("Rol:"), comboRol);

        // --- Botón inferior ---
        HBox botones = new HBox(10);
        botones.setPadding(new Insets(10));
        botones.setStyle("-fx-alignment: center;");
        btnCrear = new Button("Crear Cuenta");
        botones.getChildren().add(btnCrear);

        // --- Acción del botón ---
        btnCrear.setOnAction(e -> {
            String cuenta = txtCuenta.getText().trim();
            String contraseña = txtContraseña.getText().trim();
            String rolSeleccionado = comboRol.getValue();
            String correo = txtCorreoElectronico.getText().trim();
            String telefono = txtTelefono.getText().trim();

            if (cuenta.isEmpty() || contraseña.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
                mostrarAlerta("Campos vacíos", "Por favor, complete todos los campos.", Alert.AlertType.WARNING);
                return;
            }

            Rol rolObj;
            switch (rolSeleccionado) {
                case "Administrator" -> rolObj = new RolAdministrator();
                case "Cashier" -> rolObj = new RolCashier();
                case "Client" -> rolObj = new RolClient();
                case "Delivery" -> rolObj = new RolDelivery();
                case "Dispatcher" -> rolObj = new RolDispatcher();
                default -> rolObj = null;
            }

            if (rolObj == null) {
                mostrarAlerta("Error de Rol", "Rol inválido seleccionado.", Alert.AlertType.ERROR);
                return;
            }

            Cuenta nuevaCuenta = new Cuenta(
                    rolObj,
                    cuenta,
                    correo,
                    contraseña,
                    telefono
            );

            controller.registrarCuenta(nuevaCuenta);
            mostrarAlerta("Éxito", "Cuenta creada correctamente.", Alert.AlertType.INFORMATION);
            limpiarCampos();
        });

        // --- Layout principal ---
        BorderPane root = new BorderPane();
        root.setCenter(form);
        root.setBottom(botones);
        BorderPane.setMargin(botones, new Insets(10));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // --- Métodos auxiliares ---
    private void limpiarCampos() {
        txtCuenta.clear();
        txtContraseña.clear();
        txtCorreoElectronico.clear();
        txtTelefono.clear();
        comboRol.getSelectionModel().selectFirst();
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void launch() {
        Application.launch(CreateAccountViewFX.class);
    }
}
*/