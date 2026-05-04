import java.util.*;

public class Producto {
    static int contador=0;
    static List<String> listaProductos = new ArrayList<>();
    static List<Double> listaPrecios = new ArrayList<>();
    static List<Integer> listaStock = new ArrayList<>();
    static String Producto;
    static double Precio;
    static int Estado;
    static int Stock;
    static Scanner sc = new Scanner(System.in);

    public static void agregarProducto() {
        do{
            System.out.println("\n\t\tRegistro #" + (contador + 1));
            System.out.print("Ingrese el Producto a ser agregado: ");
            Producto = sc.nextLine();
            if(listaProductos.contains(Producto.toUpperCase())){
                System.out.println("El producto ya existe en el stock");
                return;
            }else {
                listaProductos.add(Producto.toUpperCase());
            }
            System.out.print("Ingrese el precio de este Producto: ");
            Precio = sc.nextDouble();
            listaPrecios.add(Precio);
            Random random = new Random();
            int stock = random.nextInt(100) + 1; // genera entre 1 y 100
            listaStock.add(stock);
            try {
                do {
                    System.out.println("\n¿Desea ingresar otro nuevo registro? \n1. Si   \n2. No"); // Pregunta si se desea agregar otro registro
                    Estado = sc.nextInt();
                    sc.nextLine();
                    if (Estado != 1 && Estado != 2)
                        System.out.println("\t¡Opción invalida!");
                }
                while (Estado != 1 && Estado != 2);
            }catch (InputMismatchException e){
                System.out.println("\t¡Carácter invalido!");
                sc.nextLine();
            }
            contador++; // Incrementa el contador
        }while (Estado == 1);{
        }
    }

    // Método para buscar registros por nombre
    public static void buscarRegistro() {
        do{
            if(listaProductos.isEmpty()){
                System.out.println("\t\tNo existen registros!");
                return;
            }else {
                System.out.println("\nIngrese el nombre del Producto: ");    // Solicita el nombre a buscar
                Producto = sc.nextLine();
                if (listaProductos.contains(Producto.toUpperCase())) {  // Verifica si el nombre existe en la lista
                    int posicion = listaProductos.indexOf(Producto.toUpperCase());  // Obtiene la posición del registro
                    if (posicion != -1) {
                        // Muestra los datos encontrados
                        System.out.println("\t\tRegistro encontrado: ");
                        System.out.println("Producto: " + listaProductos.get(posicion));
                        System.out.println("Precio: " + listaPrecios.get(posicion));
                        System.out.println("Stock: " + listaStock.get(posicion));
                    }
                    tryCatch();
                } else {
                    System.out.println("\t\tEl registro no existe!");    // Si no se encuentra el registro
                    tryCatch();
                }
            }
        }
        while (Estado == 1);
    }

    // Método para actualizar registros
    public static void actualizarRegistro() {
        do {
            // Verifica si existen registros
            if (listaProductos.isEmpty()) {
                System.out.println("\tNo existen registros!");
                return;
            }
            // Muestra los registros disponibles
            else {
                System.out.println("Seleccione  el numero de registro a modificar: ");
                for (int i = 0; i < listaProductos.size(); i++) {
                    System.out.println("#" + (i+1) + ": " + listaProductos.get(i));
                }
                // Usuario selecciona el registro
                int indice = sc.nextInt()-1;
                sc.nextLine();
                // Actualiza los datos usando set()
                if (indice >= 0 && indice < listaProductos.size()) {
                    System.out.println("Nuevo Producto: ");
                    listaProductos.set(indice, sc.nextLine().toUpperCase());
                    System.out.println("Nuevo precio: ");
                    listaPrecios.set(indice, Double.valueOf(sc.nextLine()));
                    System.out.println("\t¡Datos actualizados correctamente!\n");
                    System.out.println("\n¿Desea actualizar otro registro? \n1. Si   \n2. No");
                    Estado = sc.nextInt();
                    sc.nextLine(); // limpiar buffer
                }
                // Si el índice no existe
                else {
                    System.out.println("\t\tEl registro no existe!");
                    try {
                        do{
                            System.out.println("\n¿Desea modificar otro registro? \n1. Si   \n2. No");
                            Estado = sc.nextInt();
                            sc.nextLine(); // limpiar buffer
                            if (Estado != 1 && Estado != 2)
                                System.out.println("\t¡Opción invalida!");
                        } while (Estado != 1 && Estado != 2);
                    }
                    catch (InputMismatchException e){
                        System.out.println("\t¡Carácter invalido!");
                        sc.nextLine();
                    }
                }
            }
        }
        while (Estado == 1);
    }

    // Método para eliminar registros
    public static void eliminarRegistro() {
        do {
            if(listaProductos.isEmpty()){
                System.out.println("\t\tNo existen registros!");
                return;
            }
                // Muestra todos los registros disponibles
                System.out.println("Selecciona el registro a eliminar: ");
                for (int i = 0; i < listaProductos.size(); i++) {
                    System.out.println("# " + (i + 1) + " " + listaProductos.get(i));
                }
                try{
                    System.out.println("Presiona 0 (cero) para salir");
                    //Scanner dell = new Scanner(System.in);
                    int delete = sc.nextInt();    // El usuario selecciona el registro
                    sc.nextLine(); // limpiar buffer
                    if (delete == 0) { // Si elige 0 regresa al menú
                        return;
                    }
                    if (delete < 1 || delete > listaProductos.size()) {
                        System.out.println("\t¡Opción invalida!");
                        continue;
                    }
                    // Elimina el registro de todas las listas
                    /*System.out.println("\n¿Está seguro de eliminar este producto?");
                    System.out.println("Producto: " + listaProductos.get(delete - 1));
                    System.out.println("1. Sí   2. No");*/

                    int confirm;
                    do {
                        System.out.println("\n¿Está seguro de eliminar este producto?");
                        System.out.println("Producto: " + listaProductos.get(delete - 1));
                        System.out.println("1. Sí   2. No");

                        confirm = sc.nextInt();
                        sc.nextLine();

                        if (confirm != 1 && confirm != 2) {
                            System.out.println("\t¡Opción inválida!");
                        }

                    } while (confirm != 1 && confirm != 2);

                    if (confirm == 1) {
                        listaProductos.remove(delete - 1);
                        listaPrecios.remove(delete - 1);
                        listaStock.remove(delete - 1);
                        //contador--;
                        contador = listaProductos.size();

                        System.out.println("¡Registro eliminado correctamente!");
                    } else {
                        System.out.println("Operación cancelada.");
                    }
                    do {
                        System.out.println("\n¿Desea eliminar otro registro? \n1. Si   \n2. No");
                        Estado = sc.nextInt();
                        sc.nextLine(); // limpiar buffer
                    } while (Estado != 1 && Estado != 2);
                } catch (InputMismatchException e) {
                    System.out.println("\t¡Carácter invalido!");
                    sc.nextLine();
                }
        }
        while (Estado == 1);
    }

    // Método para mostrar todos los registros
    public static void mostrarDetalles() {
        if(listaProductos.isEmpty()){  // Si no hay registros
            System.out.println("\n\t ¡No existen registros!");
        }else{
            for(int i = 0; i < listaProductos.size(); i++){  // Recorre todas las listas mostrando los datos
                System.out.println(("\n\t\tRegistro #") + (i+1));
                System.out.println("Producto: " + listaProductos.get(i));
                System.out.println("Precio: $ " + listaPrecios.get(i) + " pesos");
                System.out.println("Stock: " + listaStock.get(i) + " piezas");
            }
        }
    }
    // Método para atrapar errores
    public static void tryCatch() {
        try {
            do {
                System.out.println("\n¿Desea buscar otro registro? \n1. Si   \n2. No");
                Estado = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                if (Estado != 1 && Estado != 2)
                    System.out.println("\t¡Opción invalida!");
            }
            while (Estado != 1 && Estado != 2);
        }catch (InputMismatchException e){
            System.out.println("\t¡Carácter invalido!");
            sc.nextLine();  //Limpia el buffer ante el error capturado
        }
    }

    public static String getProducto() {

        return Producto;
    }

    public static void setProducto(String producto) {
        Producto = producto;
    }

    public static double getPrecio() {
        return Precio;
    }

    public static void setPrecio(double precio) {
        Precio = precio;
    }

    public static int getStock() {
        return Stock;
    }

    public static void setStock(int stock) {
        Stock = stock;
    }
    public static int getEstado() {
        return Estado;
    }

    public static void setEstado(int estado) {
        Estado = estado;
    }
}