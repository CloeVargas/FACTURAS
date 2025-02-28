public class Factura {
    private String numero;
    private String cliente;
    private double monto;

    public Factura(String numero, String cliente, double monto) {
        this.numero = numero;
        this.cliente = cliente;
        this.monto = monto;
    }

    public String getNumero() { return numero; }
    public String getCliente() { return cliente; }
    public double getMonto() { return monto; }

    @Override
    public String toString() {
        return "Factura No: " + numero + " | Cliente: " + cliente + " | Monto: $" + monto;
    }
}
