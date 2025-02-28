import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazFacturacion extends JFrame {
    private GestorFacturas gestor = new GestorFacturas();

    public InterfazFacturacion() {
        setTitle("Sistema de Facturación");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JButton btnRegistrar = new JButton("Registro de facturas");
        JButton btnConsultar = new JButton("Consulta específica");
        JButton btnGuardar = new JButton("Guardar en archivo");
        JButton btnSalir = new JButton("Salir");

        btnRegistrar.addActionListener(e -> registrarFactura());
        btnConsultar.addActionListener(e -> consultarFactura());
        btnGuardar.addActionListener(e -> gestor.guardarFacturasEnArchivo());
        btnSalir.addActionListener(e -> System.exit(0));

        add(btnRegistrar);
        add(btnConsultar);
        add(btnGuardar);
        add(btnSalir);
    }

    private void registrarFactura() {
        String numero = JOptionPane.showInputDialog("Número de factura:");
        String cliente = JOptionPane.showInputDialog("Nombre del cliente:");
        double monto = Double.parseDouble(JOptionPane.showInputDialog("Monto de la factura:"));

        gestor.registrarFactura(new Factura(numero, cliente, monto));
        JOptionPane.showMessageDialog(this, "Factura registrada correctamente.");
    }

    private void consultarFactura() {
        String numero = JOptionPane.showInputDialog("Ingrese el número de factura:");
        Factura factura = gestor.buscarFactura(numero);

        if (factura != null) {
            JOptionPane.showMessageDialog(this, factura.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Factura no se encuentra registrada.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazFacturacion().setVisible(true));
    }
}
