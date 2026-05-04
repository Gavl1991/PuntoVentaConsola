import javax.swing.*;
import java.util.Date;

public class Facturacion extends Canasta {
    public static void Factura() {
        if (carrito && !listaCompra.isEmpty()) {
            double total = 0;
            Date fecha;

            if (listaFechasCompra.isEmpty()) {
                fecha = new Date();
            } else {
                fecha = listaFechasCompra.get(listaFechasCompra.size() - 1);
            }
            System.out.println("\n==============================");
            System.out.println("         FACTURA");
            System.out.println("==============================");
            System.out.println("\nFecha: " + new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(fecha));
            System.out.println("\n\t\tArtículos");
            System.out.println("Piezas\tProducto\tTotal");

            for (int i = 0; i < listaCompra.size(); i++) {
                int piezas = listaPiezas.get(i);

                int indexProducto = Producto.listaProductos.indexOf(listaCompra.get(i));
                if (indexProducto == -1) {
                    System.out.println("Producto no encontrado: " + listaCompra.get(i));
                    continue;
                }

                double precio = Producto.listaPrecios.get(indexProducto);
                double totalProducto = piezas * precio;
                total += totalProducto;

                System.out.printf("%5d\t%-15s\t%.2f\n", piezas, listaCompra.get(i), totalProducto);
            }

            double subtotal = total;
            double iva = subtotal * 0.16;
            double totalFinal = subtotal + iva;
            String usuarioCompra;

            System.out.printf("\n\tSubtotal = \t%.2f\n", subtotal);
            System.out.printf("\tI.V.A    = \t%.2f\n", iva);
            System.out.printf("\tTotal    = \t%.2f\n", totalFinal);
            System.out.println("\n# Productos = " + CantidadProductos);


            if (listaUsuariosCompra.isEmpty()) {
                usuarioCompra = "Desconocido";
            } else {
                usuarioCompra = listaUsuariosCompra.get(listaUsuariosCompra.size() - 1);
            }

            System.out.println("Usuario     = " + usuarioCompra);
        } else {
            System.out.println("El carrito está vacío.");
        }
    }
}