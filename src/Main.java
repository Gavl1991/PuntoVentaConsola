void main() {
    Producto newProducto = new Producto();
    do {
        System.out.println("\n-------------MENU-------------\nIngresa la opción deseada");
        System.out.println("1. Registrar Producto\n"+"2. Buscar Producto\n"+"3. Eliminar registro\n"+"4. Actualizar registro\n"+"5. Mostrar todos los registros\n"+"6. Comprar productos\n"+"7. Salir");
        System.out.println("-------------FIN--------------\n");
        Scanner opt = new Scanner(System.in);
        try {
            int opcion = opt.nextInt();
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
                    Factura.comprarProductos();
                    break;
                case 7:
                    System.exit(0); //Salir del bucle y finalizar el programa
                default:
                    System.out.println("Opción incorrecta");
            }
        }catch(InputMismatchException e){
            System.out.println("\t¡Opción incorrecta!");
        }
    }
    while (true);
}