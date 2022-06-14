package Menu;

import Files.FileManagement;
import FolderPlane.Gestion;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import Crud.*;
import Person.Passenger;
import Ticket.Ticket;

import java.util.function.ToDoubleBiFunction;

public class Menu {
    // comente clase Gestión
    static Crud crud = new Crud();
    static FileManagement file = new FileManagement();

    public static void primerMenu () throws IOException {
        Scanner scan = new Scanner(System.in);
        int respuesta;
        do {
            cuestionarioInicial();
            respuesta = scan.nextInt();
            switch (respuesta){
                case 1:
                    //case1();
                    Ticket.ticket_registration("ARCHIVO_TICKET.json");
                    break;
                case 2:
                    //opcion13();
                     gestionPasajeros("pasajeros.json");

                    break;
                case 3:

                    break;
                case 4:
                    case5();
                    break;
                case 5:
                    opcion15();
                    break;
                case 0:
                    opcion3();
                    break;
                default:
                    respuesta = 0;
                    System.out.println("Solo puede elegir las opciones 1, 2, 3, 4 o 0...");
                    break;
            }
        }while(respuesta != 0);
        System.out.println("despegue !!");
    }
    // Menu del cuestionario inicial
    private static void case1(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Cuestionario Intro..");
        int respuesta;
        do {
            opcion10();
            respuesta = scan.nextInt();
            switch (respuesta){
                case 1:
                    opcion11();
                    break;
                case 2:
                    opcion12();
                    break;
                case 0:
                    opcion3();
                    break;
                default:
                    opcionDefault(); // solo puede elegir opción 1 o 2
                    break;
            }
        }while (respuesta != 0);
    }
    // Elección de ubicación para Bronce
    public static void case4() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bronce en proceso..");
        int respuesta;
        do {
            opcion0();
            respuesta = scan.nextInt();
            switch (respuesta){
                case 1:
                    opcion1();
                    break;
                case 2:
                    opcion2();
                    break;
                case 0:
                    opcion3();
                    break;
                default:
                    opcionDefault(); // solo puede elegir opción 1 o 2
                    break;
            }
        }while (respuesta != 0);
    }
    // Elección de Confort para Plata
    private static void case2(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Plata en proceso..");
        int respuesta;
        do {
            opcion4();
            respuesta = scan.nextInt();
            switch (respuesta){
                case 1:
                    opcion5();
                    break;
                case 2:
                    opcion6();
                    break;
                case 0:
                    opcion3();
                    break;
                default:
                    opcionDefault(); // solo puede elegir opción 1 o 2
                    break;
            }
        }while (respuesta != 0);
    }
    // Elección de Conectividad para Gold
    private static void case3(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Gold en proceso..");
        int respuesta;
        do {
            opcion7();
            respuesta = scan.nextInt();
            switch (respuesta){
                case 1:
                    opcion8();
                    break;
                case 2:
                    opcion9();
                    break;
                case 0:
                    opcion3();
                    break;
                default:
                    opcionDefault(); // solo puede elegir opción 1 o 2
                    break;
            }
        }while (respuesta != 0);
    }
    // Selección de avión disponible para el viaje
    public static void case5() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Seleccione el avion disponible para su viaje: ");
        int respuesta;
        do {
            opcionIntro();
            respuesta = scan.nextInt();
            switch (respuesta){
                case 1:
                    case4();
                    break;
                case 2:
                    case2();
                case 3:
                    case3();
                    break;
                case 0:
                    opcion3();
                    break;
                default:
                    opcionDefault(); // solo puede elegir opción 1 o 2
                    break;
            }
        }while (respuesta != 0);
    }
    private static void cuestionarioInicial() {
        System.out.println("<<< Bienvenidos a AeroTaxi >>>");
        System.out.println("1- VIAJE");
        System.out.println("2- GESTION DE PASAJEROS");
        System.out.println("4- Seleccionar avion disponible en la fecha elegida: (en esta opcion, se muestra el costo total del vuelo y el usuario debe confirmar para generar el ticket o vuelo)");
        System.out.println("5- Imprimir pasajes..");
        System.out.println("0- ESC");
    }
    /*public static void case6() {
    }
    public static void case7() {
    }
    public static void case8() {
    }*/
    private static void opcionIntro() {
        System.out.println("<<< Seleccione su AeroTaxi >>>");
        System.out.println("1- AeroTaxi Bronze");
        System.out.println("2- AeroTaxi Plata");
        System.out.println("3- AeroTaxi Gold");
        System.out.println("0- ESC");
    }
    private static void opcion0() {
        System.out.println("Elija ubicacion:");
        System.out.println("1- Ventana");
        System.out.println("2- Pasillo");
        System.out.println("0- ESC");
    }
    private static void opcion1() {
        System.out.println("con ventana");
    }
    private static void opcion2() {
        System.out.println("en pasillo");
    }
    private static void opcion3() {
        System.out.println("ESC");
    }
    private static void opcionDefault() {
        System.out.println("Solo puede elegir las opciones 1 o 2");
    }
    private static void opcion4() {
        System.out.println("Elija confort:");
        System.out.println("1- Con frazada");
        System.out.println("2- Con almohada");
        System.out.println("0- ESC");
    }
    private static void opcion5() {
        System.out.println("con frazada entonces");
    }
    private static void opcion6() {
        System.out.println("con almohada entonces");
    }
    private static void opcion7() {
        System.out.println("Elija Comunicacion:");
        System.out.println("1- Con WiFi");
        System.out.println("2- Sin WiFi");
        System.out.println("0- ESC");
    }
    private static void opcion8() {
        System.out.println("con WiFi entonces");
    }
    private static void opcion9() {
        System.out.println("sin WiFi entonces");
    }
    // TODO: 10/06/2022 subMenú para el cuestionario inicial de la app
    private static void opcion10() {
        System.out.println("Elija Fechas:");
        System.out.println("1- Fecha para realizar el viaje");
        System.out.println("2- Fecha de regreso...");
        System.out.println("0- ESC");

    }
    private static void opcion11() {
        System.out.println("Fecha de partida cargada");
    }
    private static void opcion12() {
        System.out.println("Fecha de regreso cargada");
    }
    private static void opcion13() {
        Scanner scanner = new Scanner(System.in);
        String origen;
        System.out.println("Origen");
        origen = scanner.nextLine();
        System.out.println("Su origen es: "+origen);
        String destino;
        System.out.println("Destino: ");
        destino = scanner.nextLine();
        System.out.println("Su destino es: "+destino);
        System.out.println("Vuelo desde "+origen+" hacia "+destino);
    }
    public int addCompa() {
        Scanner scanner = new Scanner(System.in);

        int cantAcompanantes = 0;
        System.out.println("Ingrese la cantidad de acompanantes: ");
        cantAcompanantes = scanner.nextInt();
        int suma = 1;
        if (cantAcompanantes > 0) {
            // yo
            suma=suma+cantAcompanantes;
            System.out.println("Usted reserva "+suma+" lugares ");
        }else {
            System.out.println("sin acompanantes..");
        }
        return suma;
    }
    private static void opcion15() {
        System.out.println("Imprimiendo pasaje...");// TODO: 10/06/2022 se puede cambiar el msj, de singular a plural, según la cantidad de pasajes que se compren
    }

    public static void gestionPasajeros (String ArchivoPasajero) throws IOException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Passenger> aux = new ArrayList<>();
         aux = file.jSonToArrayList(ArchivoPasajero);
        System.out.println("1 - AGREGAR PASAJERO" +
                           " 2 - MODIFICAR PASAJERO " +
                            " 3 - BUSCAR POR DNI"+
                            " 4 - ELIMINAR PASAJERO");
        String resp =scan.nextLine();
        switch (resp){
            case "1" : crud.AltaPassenger(ArchivoPasajero);
            break;
            case "2": crud.modificarDatosPasajero(ArchivoPasajero);
            break;
            case "3":
                System.out.println("Ingrese el Dni");
                String dni= scan.nextLine();
                System.out.println(aux.get(crud.buscaPorDni(ArchivoPasajero, dni)));
                break;
            case "4":
                System.out.println("Ingrese el Dni");
                String search= scan.nextLine();
                crud.bajaPassenger(ArchivoPasajero, search);
                break;
        }
    }

}