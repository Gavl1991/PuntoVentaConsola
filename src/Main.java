//https://1drv.ms/v/c/6e6f3306b021aaec/IQDNOrcRfKB0R7kQhklb7lt_AbsSX_IMQYIdLt7axFck7gc?e=1krdLo
void main() {
    do {
        System.out.println("\n-------------MENU-------------\nIngresa la opción deseada");
        System.out.println("""
                1. Registrar Usuario\s
                2. Iniciar sesión
                3. Salir""");
        System.out.println("-------------FIN--------------\n");
        Scanner sc = new Scanner(System.in);
        try {
            int opcion0 = sc.nextInt();
            sc.nextLine();
            switch (opcion0) {
                case 1:
                    System.out.println("\n---------Registrar Usuario---------");
                    Usuario.RegistrarUsuario();
                    break;
                case 2:
                    System.out.println("\n----------Iniciar Sesion-----------");
                    Usuario.iniciarSesion();
                    if (Usuario.correcto == true) {
                        boolean sesionActiva = true;
                        do {
                            System.out.println("\n-------------MENU-------------\nIngresa la opción deseada");
                            System.out.println("""
                                    1. Registrar Producto\s
                                    2. Buscar Producto
                                    3. Eliminar registro
                                    4. Actualizar registro
                                    5. Mostrar todos los registros
                                    6. Comprar productos
                                    7. Impresión de factura
                                    8. Cerrar sesión
                                    9. Salir""");
                            System.out.println("-------------FIN--------------\n");
                            try {
                                int opcion = sc.nextInt();
                                switch (opcion) {
                                    case 1:
                                        System.out.println("\n---------Registrar Producto---------");
                                        Producto.agregarProducto();    //Llamando método para captura de registros
                                        break;
                                    case 2:
                                        System.out.println("\n----------Buscar registro-----------");
                                        Producto.buscarRegistro();   //Llamando método para búsqueda de registros por nombre
                                        break;
                                    case 3:
                                        System.out.println("\n--------Eliminar registro-----------");
                                        Producto.eliminarRegistro(); //Llamando método para eliminar de registros
                                        break;
                                    case 4:
                                        System.out.println("\n--------Actualizar registro---------");
                                        Producto.actualizarRegistro();    //Llamando método para modificar los registros
                                        break;
                                    case 5:
                                        System.out.println("\n----Mostrar todos los registros----");
                                        Producto.mostrarDetalles();  //Llamando método para imprimir los registros capturados
                                        break;
                                    case 6:
                                        System.out.println("\n----Comprar Producto----");
                                        Canasta.comprarProductos();
                                        //Facturacion.Factura();
                                        break;
                                    case 7:
                                        Facturacion.Factura();
                                        break;
                                    case 8:
                                        Usuario.cerrarSesion();
                                        sesionActiva = false;
                                        break;
                                    case 9:
                                        System.exit(0); //Salir del bucle y finalizar el programa
                                    default:
                                        System.out.println("Opción incorrecta");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\t¡Opción incorrecta!");
                            }
                        }
                        while (sesionActiva);
                    }
                    break;
                case 3:
                    System.exit(0); //Salir del bucle y finalizar el programa
                default:
                    System.out.println("Opción incorrecta");
            }
        } catch (InputMismatchException e) {
            System.out.println("\t¡Opción incorrecta!");
        }
    }
    while (true);
}