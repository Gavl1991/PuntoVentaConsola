import javax.swing.*;
import java.util.Date;

public class Facturacion extends Canasta {
    public static void Factura() {
        if (carrito && !listaCompra.isEmpty()) {

            double total = 0; //reiniciar SIEMPRE
            Date fecha = new Date();

            System.out.println("\n" + fecha);
            System.out.println("\n\t\tArtículos");
            System.out.println("Piezas\tProducto\tTotal");

            for (int i = 0; i < listaCompra.size(); i++) {
                int piezas = listaPiezas.get(i);

                int indexProducto = Producto.listaProductos.indexOf(listaCompra.get(i));
                double precio = Producto.listaPrecios.get(indexProducto);

                double totalProducto = piezas * precio;
                total += totalProducto;

                System.out.println("  " + piezas + "\t\t" + listaCompra.get(i) +
                        "\t\t" + totalProducto);
            }

            double iva = total * 0.16;
            double subtotal = total - iva;

            System.out.printf("\n\tSubtotal = \t%.2f\n", subtotal);
            System.out.printf("\tI.V.A    = \t%.2f\n", iva);
            System.out.printf("\tTotal    = \t%.2f\n", total);

            System.out.println("\n# Productos = " + CantidadProductos);
            System.out.println("Usuario     = " + Usuario.userLog.getUserName());

        } else {
            System.out.println("El carrito está vacío.");
        }
    }
}