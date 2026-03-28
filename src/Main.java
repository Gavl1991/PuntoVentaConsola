void main() {
    producto newProducto = new producto();
    do {
        System.out.println("\n-------------MENU-------------\nIngresa la opcion deseada");
        System.out.println("1. Registrar producto\n"+"2. Buscar producto\n"+"3. Eliminar registro\n"+"4. Actualizar registro\n"+"5. Mostrar todos los registros\n"+"6. Comprar productos\n"+"7. Salir");
        System.out.println("-------------FIN--------------\n");
        Scanner opt = new Scanner(System.in);
        try {
            int opcion = opt.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\n---------Registrar producto---------");
                    producto.agregarProducto();    //Llamando metodo para captura de registros
                    break;
                case 2:
                    System.out.println("\n----------Buscar registro-----------");
                    producto.buscarRegistro();   //Llamando metodo para busqueda de registros por nombre
                    break;
                case 3:
                    System.out.println("\n--------Eliminar registro-----------");
                    producto.eliminarRegistro(); //Llamando metodo para eliminar de registros
                    break;
                case 4:
                    System.out.println("\n--------Actualizar registro---------");
                    producto.actualizarRegistro();    //Llamando metofo para modificar los registros
                    break;
                case 5:
                    System.out.println("\n----Mostrar todos los registros----");
                    producto.mostrarDetalles();  //Llamando metodo para imprimir los registros capturados
                    break;
                case 6:
                    System.out.println("\n----Comprar producto----");
                    producto.mostrarProductos();
                    break;
                case 7:
                    System.exit(0); //Salir del bucle y finalizar el programa
                default:
                    System.out.println("Opcion incorrecta");
            }
        }catch(InputMismatchException e){
            System.out.println("\t¡Opcion incorrecta!");
        }
    }
    while (true);
}