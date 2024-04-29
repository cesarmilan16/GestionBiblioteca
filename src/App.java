import java.util.Scanner;

import Modelo.Biblioteca;

public class App {

    public static Biblioteca biblioteca = new Biblioteca();
    public static void main(String[] args) throws Exception {
        boolean salir = false;
        while (!salir) {
            salir = mostrarMenuPrincipal();
        }
    }


    private static boolean mostrarMenuPrincipal() {
        boolean salir = false;
        System.out.println("*****************************");
        System.out.println("*******Menu principal********");
        System.out.println("*****************************");
        System.out.println("1.- Alta usuario");
        System.out.println("2.- Baja usuario");
        System.out.println("3.- Gestión libros");
        System.out.println("4.- Lista de los libros disponibles");
        System.out.println("5.- Lista de los libros prestados a un usuario");
        System.out.println("9.- Salir");
        
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                biblioteca.altaUsuario();
                break;/* 
            case "2":
                biblioteca.bajaUsuario();
                break;
            case "3":
                biblioteca.gestionLibros();
                break;
            case "4":
                biblioteca.listarLibrosDisponibles();
                break;
            case "5":
                biblioteca.listarLibrosListados();
                break;*/
            case "9":
                salir = true;
                break;
            default:
                break;
        }
        return salir;
    }
}