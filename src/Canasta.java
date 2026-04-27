import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Canasta {
    static int piezas = 0, CantidadProductos = 0, indice, piezasTotales=0, piezasProducto=0;
    static double costo=0.0, total = 0.0, CantidadPrecios = 0.0;
    static String agregar;
    static List<String> listaCompra = new ArrayList<>();
    static List<Integer> listaPiezas = new ArrayList<>();

    public static int Compra;
    public Canasta() {
        Compra = getCompra();
        indice = getindice();
        piezasProducto = getpiezasProducto();
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
                if (Compra < 0 || Compra >= Producto.listaProductos.size()) {
                    System.out.println("Opción inválida");
                    continue;
                }
                agregar = Producto.listaProductos.get(Compra);   //Guarda el nombre del Producto en la variable agregar
                //System.out.println("Producto = " + agregar);    //Temporal

                System.out.println("Cuantas piezas desea comprar");
                piezas = cP.nextInt();
                if (Producto.listaStock.get(Compra) < piezas) {
                    System.out.println("No hay suficiente stock");
                    continue;
                }
                if (listaCompra.contains(agregar)) {
                    indice = listaCompra.indexOf(agregar);      //Identifica el indice del producto

                    // Actualiza piezas existentes
                    listaPiezas.set(indice, listaPiezas.get(indice) + piezas);
                } else {
                    listaCompra.add(agregar);
                    if (Producto.listaStock.get(Compra) < piezas) {
                        System.out.println("No hay suficiente stock");
                        continue;
                    }

                    // Agrega nuevas piezas
                    listaPiezas.add(piezas);
                    indice = listaCompra.size() - 1;
                }
                piezasProducto = listaPiezas.get(indice);   //Guarda las piezas del Producto en la variable piezas producto  Compra -- indice
                piezasTotales += piezas;
                CantidadProductos += piezas;    //Suma el total de las piezas
                Producto.listaStock.set(Compra, Producto.listaStock.get(Compra) - piezas);    //Resta el total del stock disponible según las piezas adquiridas por el usuario
                System.out.println("Producto agregado al carrito");
                Scanner bR = new Scanner(System.in);
                try {
                    do {
                        System.out.println("\n¿Desea agregar otro producto a la canasta? \n1. Si   \n2. No");
                        Producto.Estado = bR.nextInt();
                        if (Producto.Estado != 1 && Producto.Estado != 2)
                            System.out.println("\t¡Opción invalida!");
                    }
                    while (Producto.Estado != 1 && Producto.Estado != 2);
                }catch (InputMismatchException e){
                    System.out.println("\t¡Carácter invalido!");
                    bR.nextLine();  //Limpia el buffer ante el error capturado
                }
            }
        }
        while (Producto.Estado == 1);
    }

    public static int getCompra() {
        return Compra;
    }

    public static void setCompra(int compra) {
        Compra = compra;
    }

    public static int getindice() {
        return indice;
    }

    public static void setindice(int nuevoIndice) {
        Canasta.indice = nuevoIndice;
    }

    public static int getpiezasProducto() {
        return piezasProducto;
    }

    public static void setpiezasProducto(int piezasProducto) {
        Canasta.piezasProducto = piezasProducto;
    }
}