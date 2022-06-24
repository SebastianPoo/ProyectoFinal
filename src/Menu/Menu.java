package Menu;

import Files.FileManagement;
import FolderPlane.Gestion;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Crud.*;
import FolderPlane.Plane;

import Passenger.Passenger;
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

                    Ticket.ticket_registration("ARCHIVO_TICKET.json","ARCHIVO_PASAJEROS.json");
                    break;
                case 2:

                     gestionPasajeros("ARCHIVO_PASAJEROS.json");

                    break;
                case 3:
                    gestionTicket("ARCHIVO_TICKET.json");
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
    public static void gestionTicket(String nombreArchivo) throws IOException{
        List<Ticket> aux = file.jSonToArrayListTicket(nombreArchivo);
        ArrayList<Passenger> aux1 = file.jSonToArrayList("ARCHIVO_PASAJEROS.json");

        Scanner scan = new Scanner(System.in);

        int respuesta;
        do {
            opcion0();
            respuesta = scan.nextInt();
            switch (respuesta){
                case 1:
                    System.out.println("Borrando en proceso");
                    break;
                case 2:
                    Scanner scan1 = new Scanner(System.in);
                    System.out.println("ENTER DNI");
                    String dni = scan1.nextLine();
                    int pos = aux1.get(crud.buscaPorDni("ARCHIVO_PASAJEROS.json", dni)).getId();

                    System.out.println("tickte     " + aux.get(pos));
                    List<Plane> misAviones1 = FileManagement.jsonToArray("ARCHIVO_AVIONES");


                    break;
                case 0:
                    opcion3();
                    break;
                default:
                    opcionDefault();
                    break;
            }
        }while (respuesta != 0);
    }

    private static void opcion0() {
        System.out.println("1- CANCELAR VUELO");
        System.out.println("2- MOSTRAR TICKETS");
        System.out.println("0- ESC");
    }

    private static void cuestionarioInicial() {
        System.out.println("<<< Bienvenidos a AeroTaxi >>>");
        System.out.println("1- VIAJE");
        System.out.println("2- GESTION DE PASAJEROS");
        System.out.println("3- GESTION DE TICKET");
        System.out.println("0- ESC");
    }

    private static void opcion3() {
        System.out.println("ESC");
    }
    private static void opcionDefault() {
        System.out.println("Solo puede elegir las opciones 1 o 2");
    }

    public int addCompa() {
        Scanner scanner = new Scanner(System.in);

        int cantAcompanantes = 0;
        System.out.println("Ingrese la cantidad de acompanantes: ");
        cantAcompanantes = scanner.nextInt();
        int suma = 1;
        if (cantAcompanantes > 0) {

            suma=suma+cantAcompanantes;
            System.out.println("Usted reserva "+suma+" lugares ");
        }else {
            System.out.println("sin acompanantes..");
        }
        return suma;
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
            case "1" : crud.altaPassenger(ArchivoPasajero);
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