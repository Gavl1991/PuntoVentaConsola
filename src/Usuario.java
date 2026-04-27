import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String userName;
    private String password;
    static Usuario userLog = null;
    static boolean correcto = false;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Usuario> usuarios = new ArrayList<>();

    //Método constructor vacío
    public Usuario() {
    }

    public Usuario(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //Registrar Usuario
    public static void RegistrarUsuario() {
        int estado=0;
        do {
            boolean existe = false;
            //System.out.println("\n--------------Registrar Usuario-----------");
            System.out.println("Ingresa el nombre del usuario");
            String userName = sc.nextLine();
            for (Usuario u : usuarios) {
                if (u.getUserName().equals(userName)) {
                    existe = true;
                    break;
                }
            }

            if (existe) {
                System.out.println("El nombre del usuario ya existe");
                continue;
            }
            System.out.println("Ingresa una contraseña");
            String password = sc.nextLine();
            usuarios.add(new Usuario(userName, password));
            do {
                System.out.println("\n¿Desea agregar otro usuario?\n1. Sí\n2. No");
                estado = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                if (estado != 1 && estado != 2) {
                    System.out.println("Opción inválida");
                }
            } while (estado != 1 && estado != 2);

        } while (estado == 1);
    }

    //Iniciar sesión
    public static void iniciarSesion() {
        System.out.println("\n--------------Inicio de sesión-----------");
        System.out.println("Ingresa el nombre del usuario");
        String userName = sc.nextLine();
        System.out.println("Ingresa contraseña: ");
        String password = sc.nextLine();

        for (Usuario u : usuarios) {
            if (u.getUserName().equals(userName) && u.getPassword().equals(password)) {
                System.out.println("\n\t¡Inicio de sesión correcto!\n");
                correcto = true;
                userLog = u;
                return;
            }
        }
        System.out.println("\n\t¡Usuario o contraseña incorrectos!\n");
    }

    //Cerrar sesión
    public static void cerrarSesion() {
        if (userLog != null) {
            System.out.println("\n\tSesión cerrada correctamente.\n");
            userLog = null;
            correcto = false;
        } else {
            System.out.println("\n\tNo hay ninguna sesión activa.\n");
        }
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}