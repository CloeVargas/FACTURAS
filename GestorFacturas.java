import java.io.*;
import java.util.*;

public class GestorFacturas {
    private List<Factura> facturas = new ArrayList<>();
    private final String archivo = "facturas.txt";

    public void registrarFactura(Factura factura) {
        facturas.add(factura);
    }

    public Factura buscarFactura(String numero) {
        for (Factura f : facturas) {
            if (f.getNumero().equals(numero)) {
                return f;
            }
        }
        return null;
    }

    public void guardarFacturasEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Factura f : facturas) {
                bw.write(f.getNumero() + "," + f.getCliente() + "," + f.getMonto());
                bw.newLine();
            }
            System.out.println("Facturas guardadas en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al guardar facturas: " + e.getMessage());
        }
    }
}
