package Ticket;

import Files.FileManagement;
import FolderPlane.Gestion;
import FolderPlane.Plane;
import Menu.Menu;
import Passenger.Passenger;
import Person.Person;
import Travel.Distances;


import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Ticket {
    private UUID ticket;
    private int id;
    private int price;
    private Distances destination;
    private Plane plane;
    private Person passager;
    private String Seat;                  // --AGREGUE ENCAPSULAMIENTO
    private Calendar fechaDeViaje;

    private int agregarPasajeros;


    public Ticket() {
        this.ticket = UUID.randomUUID();
    }

    public Ticket(Distances destination, String seat, Plane plane) {
        this.ticket = UUID.randomUUID();
        this.destination = destination;
        Seat = seat;
        this.plane = plane;
    }

    public int getAgregarPasajeros() {
        return agregarPasajeros;
    }

    public void setAgregarPasajeros(int agregarPasajeros) {
        this.agregarPasajeros = agregarPasajeros;
    }

    public Distances getDestination() {
        return destination;
    }

    public void setDestination(Distances destination) {
        this.destination = destination;
    }

    public Plane getPlane() {
        return plane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public String getSeat() {
        return Seat;
    }

    public void setSeat(String seat) {
        Seat = seat;
    }

    public int travelCost(Plane plane) {
        int coste = 0;
        coste = plane.getCoste();
        //(canKm * cosKm)+(canPas * 3500)+(tarifaTipoAvion)
        return coste;
    }
    public void setFechaDeViaje(Calendar fechaDeViaje) {
        this.fechaDeViaje = fechaDeViaje;
    }


    public Ticket costoTicket() {
        Ticket ticket = new Ticket();
        ticket.price = plane.carry_on_bag(plane.getCoste());
        return ticket;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ID ticket=" + ticket +
                ", destination=" + destination.retornarNumero() +
                ", Seats='" + this.getAgregarPasajeros() +
                ", Price='" + price + '\'' +
                 ", Plane='" + plane.getNombre() + '\'' +
                '}';
    }

    public static void ticket_registration(String nombreArchivo) throws IOException {
        List<Plane> misAviones = Gestion.add_a_Flota(new ArrayList<>());
        ArrayList<Ticket> tickets = new ArrayList<>();
        FileManagement file = new FileManagement();
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();

        int option = 0;
        if (nombreArchivo.isEmpty()) {

            while (option != 2) {

                Ticket ticket = new Ticket();
                Fechas fechas = new Fechas();
                eligeDestino(ticket);
                Calendar calendar= fechas.elegir();
                ticket.setFechaDeViaje(calendar);
                 int companions= menu.addCompa();
                 ticket.setAgregarPasajeros(companions);
                int num = eligeAvion();
                System.out.println(num);
                ticket.setPlane(misAviones.get(num));
                System.out.println(ticket.toString());
                tickets.add(ticket);
                //System.out.println("tickets " + tickets.toString());
                System.out.println("Presione 1 para continar o 2 para salir");
                option = scan.nextInt();
                scan.nextLine();
                file.arrayToJsonFormat(tickets, nombreArchivo);
            }
            file.arrayToJsonFormatTicket(tickets, nombreArchivo);
        } else {
            ArrayList<Ticket> aux = new ArrayList<>();
            aux = file.jSonToArrayListTicket(nombreArchivo);
            while (option != 2) {
                Ticket ticket = new Ticket();
                Fechas fechas = new Fechas();
                eligeDestino(ticket);
                Calendar calendar= fechas.elegir();
                ticket.setFechaDeViaje(calendar);
                int companions= menu.addCompa();
                ticket.setAgregarPasajeros(companions);
                int num = eligeAvion();
                System.out.println(num);
                ticket.setPlane(misAviones.get(num));
                System.out.println(ticket.toString());
                aux.add(ticket);
                //System.out.println("Aux" + aux.toString());
                System.out.println("Presione 1 para continar o 2 para salir");
                option = scan.nextInt();
                scan.nextLine();
                file.arrayToJsonFormatTicket(aux, nombreArchivo);
            }

        }
    }

    public static int eligeAvion() throws IOException {
        Scanner scan = new Scanner(System.in);
        int respuesta;
        int pos = -1;
        do {
            tipo_de_avion();
            respuesta = scan.nextInt();
            switch (respuesta) {
                case 1:
                   //ticket1.setPlane(misAviones.get(0));
                   pos = 0;
                    break;
                case 2:
                    /*System.out.println("avion" + misAviones.get(1));
                    //ticket1.setPlane(misAviones.get(1));
                    System.out.println("ticket " + ticket1.getPlane().toString());*/
                    pos = 1;
                    break;
                case 3:
                    //ticket1.setPlane(misAviones.get(2));
                    pos = 2;
                    break;
                case 4:
                    //ticket1.setPlane(misAviones.get(3));
                    pos = 3;
                    break;
                case 5:
                   // ticket1.setPlane(misAviones.get(4));
                    pos = 4;
                    break;
                case 6:
                    //ticket1.setPlane(misAviones.get(5));
                    pos = 5;
                    break;
                case 0:
                    System.out.println("ESC");
                    break;
                default:
                    respuesta = 0;
                    System.out.println("Solo puede elegir las opciones 1, 2, 3, 4, 5, 6 o 0...");
                    break;

            }
            return pos;

        } while (respuesta != 0);

    }

    private static void tipo_de_avion() {
        System.out.println("<<< Elija opcion >>>");
        System.out.println("1- Bronze ");
        System.out.println("2- Gold ");
        System.out.println("3- Silver ");
        System.out.println("4- Bronze ");
        System.out.println("5- Gold ");
        System.out.println("6- Silver ");
        System.out.println("0- ESC");
    }

    public static void eligeDestino(Ticket tick) throws IOException {
        Scanner scan = new Scanner(System.in);
        int respuesta;

        do {
            destinos();
            respuesta = scan.nextInt();
            switch (respuesta) {
                case 1:
                    tick.setDestination(Distances.BsAs_Cor);
                    break;
                case 2:
                    tick.setDestination(Distances.Cor_San);
                    break;
                case 3:
                    tick.setDestination(Distances.Cor_Mon);
                    break;
                case 4:
                    tick.setDestination(Distances.BsAs_San);
                    break;
                case 5:
                    tick.setDestination(Distances.BsAs_Cor);
                    break;
                case 6:
                    tick.setDestination(Distances.BsAs_Mon);
                    break;
                default:
                    respuesta = 0;
                    System.out.println("Solo puede elegir las opciones 1, 2, 3, 4, 5, 6 o 0...");
                    break;
            }

        } while (respuesta == 0);
        System.out.println("Destino seleccionado !!");
    }

    private static void destinos() {
        System.out.println("<<< Elija opcion >>>");
        System.out.println("1- Montevideo_San Luis ");
        System.out.println("2- Cordoba_San luis ");
        System.out.println("3- Corboda_Montevideo ");
        System.out.println("4- Bs.As_San Luis ");
        System.out.println("5- Bs.As_Cordoba ");
        System.out.println("6- Bs.As_Montevideo ");
        System.out.println("0- ESC");
    }
}