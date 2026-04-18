import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Factura {
    static int piezas = 0, CantidadProductos = 0, indice, piezasTotales=0;
    static Double costo = 0.0, total = 0.0, CantidadPrecios = 0.0;
    static String agregar;
    static List<String> listaCompra = new ArrayList<>();
    static List<Integer> listaPiezas = new ArrayList<>();

    public static int Compra;
    public Factura() {
    }

    // Método para comprar productos
    public static void comprarProductos() {
        Scanner cP = new Scanner(System.in);
        do {
            if (Producto.contador == 0) {
                System.out.println("No hay productos!");
                return;
            } else {
                System.out.println("\n\t\tProductos");
                for (int i = 0; i < Producto.contador; i++) {
                    System.out.println("#" + (i + 1) + "\t" + Producto.listaProductos.get(i) + "\t\t$ " + Producto.listaPrecios.get(i) + " pesos");
                }
                System.out.println("Selecciona el Producto a comprar");
                Compra = cP.nextInt()-1;
                //Compra--;
                agregar = Producto.listaProductos.get(Compra);   //Guarda el nombre del Producto en la variable agregar
                System.out.println(agregar);    //Temporal

                if (listaCompra.contains(agregar)) {    //Válida si el Producto ya fue agregado en la lista, en caso de ser correcto no lo agrega y va sumando las piezas
                }
                else {
                    listaCompra.add(agregar);   //Agrega el Producto seleccionado a la lista de compra en caso de no existir en la lista
                }
                System.out.println(listaCompra);    //Temporal
                indice = listaCompra.indexOf(agregar);      //Identifica el índice del Producto agregado
                System.out.println("Cuantas piezas desea comprar");
                piezas = cP.nextInt();
                if(listaPiezas.isEmpty()){
                    listaPiezas.add(piezas);
                }else {
                    listaPiezas.add(piezas, indice);
                }
                piezasTotales += piezas;
                System.out.println("Piezas totales: " + piezasTotales);
                //System.out.println(listaPiezas);    //Temporal
                CantidadProductos += piezas;    //Suma el total de las piezas
                System.out.println(CantidadProductos);  //Temporal
                Producto.listaStock.set(Compra, Producto.listaStock.get(Compra) - piezas);    //Resta el total del stock disponible según las piezas adquiridas por el usuario

                System.out.println("Producto agregado al carrito");
                costo = Producto.listaPrecios.get(Compra);   //Guarda el costo del Producto en la variable costo
                CantidadPrecios = costo * piezas;   //Calcula el total del Producto seleccionado por el costo unitario del Producto
                total = total + CantidadPrecios;    //Suma el total de la cuenta
                System.out.println(total);
                Producto.tryCatch();
            }
        }
        while (Producto.Estado == 1);
        {
        }
    }

    public static int getCompra() {
        return Compra;
    }

    public static void setCompra(int compra) {
        Compra = compra;
    }
}