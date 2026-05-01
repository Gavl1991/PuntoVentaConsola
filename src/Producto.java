import java.util.*;

public class Producto {
    static int contador=0;
    static List<String> listaProductos = new ArrayList<>();
    static List<Double> listaPrecios = new ArrayList<>();
    static List<Integer> listaStock = new ArrayList<>();
    private static String Producto;
    public static double Precio;
    static int Estado, Stock;

    // Constructor de la clase Persona
    public Producto() {
        // Inicializa los atributos usando los métodos get
        Producto = getProducto();
        Precio = getPrecio();
        Stock = getStock();
        Estado = getEstado();
    }

    public static void agregarProducto() {
        do{
            Scanner add = new Scanner(System.in);
            System.out.println("\n\t\tRegistro #" + (contador + 1));
            System.out.print("Ingrese el Producto a ser agregado: ");
            Producto = add.nextLine();
            if(listaProductos.contains(Producto.toUpperCase())){
                System.out.println("El producto ya existe en el stock");
                return;
            }else {
                listaProductos.add(Producto.toUpperCase());
            }
            System.out.print("Ingrese el precio de este Producto: ");
            Precio = add.nextDouble();
            listaPrecios.add(Precio);
            Random random = new Random();
            int stock = random.nextInt(100) + 1; // genera entre 1 y 100
            listaStock.add(stock);
            try {
                do {
                    System.out.println("\n¿Desea ingresar otro nuevo registro? \n1. Si   \n2. No"); // Pregunta si se desea agregar otro registro
                    Estado = add.nextInt();
                    if (Estado != 1 && Estado != 2)
                        System.out.println("\t¡Opción invalida!");
                }
                while (Estado != 1 && Estado != 2);
            }catch (InputMismatchException e){
                System.out.println("\t¡Carácter invalido!");
                add.nextLine();
                //agregarProducto();
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
                Scanner bR = new Scanner(System.in);
                System.out.println("\nIngrese el nombre del Producto: ");    // Solicita el nombre a buscar
                Producto = bR.nextLine();
                if (listaProductos.contains(Producto.toUpperCase())) {  // Verifica si el nombre existe en la lista
                    int posicion = listaProductos.indexOf(Producto.toUpperCase());  // Obtiene la posición del registro
                    if (posicion != -1) {
                        // Muestra los datos encontrados
                        System.out.println("\t\tRegistro #" + (contador + 1));
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
        while (Estado == 1);{
        }
    }

    // Método para actualizar registros
    public static void actualizarRegistro() {
        do {
            Scanner aR = new Scanner(System.in);
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
                int indice = aR.nextInt()-1;
                aR.nextLine();
                // Actualiza los datos usando set()
                if (indice >= 0 && indice < listaProductos.size()) {
                    System.out.println("Nuevo Producto: ");
                    listaProductos.set(indice, aR.nextLine().toUpperCase());
                    System.out.println("Nuevo precio: ");
                    listaPrecios.set(indice, Double.valueOf(aR.nextLine()));
                    //System.out.println("Stock: ");
                    //listaStock.set(indice, Integer.valueOf(aR.nextLine()));
                    System.out.println("\t¡Datos actualizados correctamente!\n");
                    System.out.println("\n¿Desea actualizar otro registro? \n1. Si   \n2. No");
                    Estado = aR.nextInt();
                }
                // Si el índice no existe
                else {
                    System.out.println("\t\tEl registro no existe!");
                    try {
                        do{
                            System.out.println("\n¿Desea modificar otro registro? \n1. Si   \n2. No");
                            Estado = aR.nextInt();
                            if (Estado != 1 && Estado != 2)
                                System.out.println("\t¡Opción invalida!");
                        } while (Estado != 1 && Estado != 2);
                    }
                    catch (InputMismatchException e){
                        System.out.println("\t¡Carácter invalido!");
                        aR.nextLine();
                        actualizarRegistro();
                    }
                }
            }
        }
        while (Estado == 1);{
        }
    }

    // Método para eliminar registros
    public static void eliminarRegistro() {
        do {
            Scanner eR = new Scanner(System.in);
            if(listaProductos.isEmpty()){
                System.out.println("\t\tNo existen registros!");
                return;
            }else {
                // Muestra todos los registros disponibles
                System.out.println("Selecciona el registro a eliminar: ");
                for (int i = 0; i < contador; i++) {
                    System.out.println("# " + (i + 1) + " " + listaProductos.get(i));
                }
                try{
                    System.out.println("Presiona 0 (cero) para salir");
                    Scanner dell = new Scanner(System.in);
                    int delete = dell.nextInt();    // El usuario selecciona el registro
                    if (delete > contador) {
                        System.out.println("\t¡Opción invalida!");
                        eliminarRegistro();
                    } else {
                        if (delete == 0) { // Si elige 0 regresa al menú
                            return;
                        } else {
                            // Elimina el registro de todas las listas
                            listaProductos.remove(delete - 1);
                            listaPrecios.remove(delete - 1);
                            listaStock.remove(delete - 1);
                            contador--; // Reduce el contador
                            System.out.println("¡Registro eliminado correctamente!");
                        }
                        // Pregunta si desea eliminar otro registro
                        try {
                            do {
                                System.out.println("\n¿Desea eliminar otro registro? \n1. Si   \n2. No");
                                Estado = eR.nextInt();
                                if (Estado != 1 && Estado != 2)
                                    System.out.println("\t¡Opción invalida!");
                            } while (Estado != 1 && Estado != 2);
                        } catch (InputMismatchException e) {
                            System.out.println("\t¡Carácter invalido!");
                            dell.nextLine();
                            eliminarRegistro();
                        }
                    }
                }catch (InputMismatchException e){
                    System.out.println("\t¡Carácter invalido!");
                }
            }
        }
        while (Estado == 1);{
        }
    }

    // Método para mostrar todos los registros
    public static void mostrarDetalles() {
        if(contador == 0){  // Si no hay registros
            System.out.println("\n\t ¡No existen registros!");
        }else{
            for(int i = 0; i < contador; i++){  // Recorre todas las listas mostrando los datos
                System.out.println(("\n\t\tRegistro #") + (i+1));
                System.out.println("Producto: " + listaProductos.get(i));
                System.out.println("Precio: $ " + listaPrecios.get(i) + " pesos");
                System.out.println("Stock: " + listaStock.get(i) + " piezas");
            }
        }
    }
    // Método para atrapar errores
    public static void tryCatch() {
        Scanner bR = new Scanner(System.in);
        try {
            do {
                System.out.println("\n¿Desea buscar otro registro? \n1. Si   \n2. No");
                Estado = bR.nextInt();
                if (Estado != 1 && Estado != 2)
                    System.out.println("\t¡Opción invalida!");
            }
            while (Estado != 1 && Estado != 2);
        }catch (InputMismatchException e){
            System.out.println("\t¡Carácter invalido!");
            bR.nextLine();  //Limpia el buffer ante el error capturado
        }
    }

    public static String getProducto() {

        return Producto;
    }

    public static void setProducto(String Producto) {
        Producto = Producto;
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