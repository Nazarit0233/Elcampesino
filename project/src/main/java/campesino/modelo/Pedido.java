package campesino.modelo;

import java.sql.Timestamp;

public class Pedido {
    private int id_Pedido; // ID_PEDIDO
    private int id_Cliente; // ID_CLIENTE (FK a Cuenta o Cliente)
    private int idEstadoPedido; // ID_ESTADO_PEDIDO (FK a tabla ESTADO_PEDIDO)
    private Timestamp fechaPedido; // FECHA_PEDIDO
    private double totalPedido; // TOTAL_PEDIDO
    private String metodoPago; // METODO_PAGO
    private String direccionEntrega; // DIRECCION_ENTREGA

    // 🔹 Constructor vacío
    public Pedido() {
    }

    // 🔹 Constructor con todos los campos (excepto id autogenerado)
    public Pedido(int id_Cliente, int idEstadoPedido, double totalPedido,
            String metodoPago, String direccionEntrega) {
        this.id_Cliente = id_Cliente;
        this.idEstadoPedido = idEstadoPedido;
        this.fechaPedido = new Timestamp(System.currentTimeMillis());
        this.totalPedido = totalPedido;
        this.metodoPago = metodoPago;
        this.direccionEntrega = direccionEntrega;
    }

    // 🔹 Constructor completo (por si se carga desde BD)
    public Pedido(int id_Pedido, int id_Cliente, int idEstadoPedido, Timestamp fechaPedido,
            double totalPedido, String metodoPago, String direccionEntrega) {
        this.id_Pedido = id_Pedido;
        this.id_Cliente = id_Cliente;
        this.idEstadoPedido = idEstadoPedido;
        this.fechaPedido = fechaPedido;
        this.totalPedido = totalPedido;
        this.metodoPago = metodoPago;
        this.direccionEntrega = direccionEntrega;
    }

    // 🔹 Getters y Setters
    public int getid_Pedido() {
        return id_Pedido;
    }

    public void setid_Pedido(int id_Pedido) {
        this.id_Pedido = id_Pedido;
    }

    public int getid_Cliente() {
        return id_Cliente;
    }

    public void setid_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public int getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(int idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public Timestamp getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Timestamp fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    // 🔹 Método toString (para mostrar en JOptionPane o consola)
    @Override
    public String toString() {
        return "Pedido #" + id_Pedido + "\n" +
                "Cliente: " + id_Cliente + "\n" +
                "Estado: " + idEstadoPedido + "\n" +
                "Fecha: " + fechaPedido + "\n" +
                "Total: $" + totalPedido + "\n" +
                "Pago: " + metodoPago + "\n" +
                "Entrega: " + direccionEntrega;
    }
}
