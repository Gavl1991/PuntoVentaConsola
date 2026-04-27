import java.util.Date;

public class Facturacion extends Canasta {
    public static void Factura() {
        costo = Producto.listaPrecios.get(Compra);   //Guarda el costo del Producto en la variable costo
        CantidadPrecios = costo * piezas;   //Calcula el total del Producto seleccionado por el costo unitario del Producto
        total = total + CantidadPrecios;    //Suma el total de la cuenta
        Date fecha = new Date();
        System.out.print("\n" + fecha + "\n");
        System.out.print("\n\t\tArtículos\n");
        System.out.print("Piezas\tProducto\tTotal\n");
        for(int i=0; i<listaCompra.size();i++) {
            System.out.print("  " + listaPiezas.get(i) + "\t" + listaCompra.get(i) +
                    "\t\t" + (listaPiezas.get(i)*Producto.listaPrecios.get(i)) + "\n");
        }
        System.out.print("\n\tSubtotal = \t" + (total-(total*.16)));
        System.out.print("\n\tI.V.A    =  \t" + total*.16);
        System.out.print("\n\tTotal    = \t" + total);
        System.out.println("\n\n# Productos = " + CantidadProductos);
        System.out.println("Usuario     = " + Usuario.userLog.getUserName());
    }
}