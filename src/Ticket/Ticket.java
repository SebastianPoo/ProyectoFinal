package Ticket;

import Crud.Crud;
import Files.FileManagement;
import FolderPlane.Gestion;
import FolderPlane.Plane;
import Menu.Menu;
import Passenger.Passenger;
import Travel.Distances;



import java.io.IOException;
import java.util.*;

public class Ticket {
    private UUID ticket;
    private int id;
    private int price;
    private Distances destination;
    private Plane plane;
    private Passenger person;
    private String Seat;                  // --AGREGUE ENCAPSULAMIENTO
    public Calendar fechaDeViaje;

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

    public void setPassager(Passenger person) {
        this.person = person;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
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


    public void costoTicket(Ticket ticket) {
        int costo = 0;
        costo = plane.carry_on_bag(costo) + plane.confort(costo) + plane.catering(costo) + plane.wifi(costo) + plane.getCoste();
        System.out.println("Precio total: "+costo);
        ticket.price += costo;
    }



    public static void ticket_registration(String nombreArchivo) throws IOException {
        List<Plane> misAviones = Gestion.add_a_Flota(new ArrayList<>());
        ArrayList<Ticket> tickets = new ArrayList<>();
        FileManagement file = new FileManagement();
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        Ticket ticket = new Ticket();
        Fechas fechas = new Fechas();

        int option = 0;
        if (nombreArchivo.isEmpty()) {

            while (option != 2) {

                eligeDestino(ticket);

                Calendar calendar= fechas.elegir();
                ticket.setFechaDeViaje(calendar);

                int companions= menu.addCompa();
                ticket.setAgregarPasajeros(companions);

                int num = eligeAvion(ticket);
                System.out.println(num);
                ticket.setPlane(misAviones.get(num));
                ticket.costoTicket(ticket);
                ticket.ticket_passager(ticket);


                System.out.println(ticket.toString());
                System.out.println("Desea Confirmar El Ticket ?  --- S   /   N");
                String conf= scan.nextLine().toUpperCase();
                if (conf.contains("S")){
                    tickets.add(ticket);
                }else{
                    break;
                }
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


                eligeDestino(ticket);

                Calendar calendar= fechas.elegir();
                ticket.setFechaDeViaje(calendar);

                int companions= menu.addCompa();
                ticket.setAgregarPasajeros(companions);

                int num = eligeAvion(ticket);
                System.out.println(num);
                ticket.setPlane(misAviones.get(num));
                ticket.costoTicket(ticket);
                ticket.ticket_passager(ticket);

                System.out.println(ticket.toString());
                System.out.println("Desea Confirmar El Ticket ?  --- S   /   N");
                String conf= scan.nextLine().toUpperCase();
                if (conf.contains("S")){
                    aux.add(ticket);
                }else{
                    break;
                }
                //System.out.println("Aux" + aux.toString());
                System.out.println("Presione 1 para continar o 2 para salir");
                option = scan.nextInt();
                scan.nextLine();
                file.arrayToJsonFormatTicket(aux, nombreArchivo);
            }


        }
    }
    public boolean equalsTicket(Calendar calendar) {
        if (fechaDeViaje.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) && fechaDeViaje.get(Calendar.DATE) == calendar.get(Calendar.DATE)) {
            return true;
        }else {
            return false;
        }
    }
    public static boolean ticke_dates(Plane plane, Ticket ticket){
        boolean flame = false;
        for (Calendar calendar: plane.listPlane ){
            flame = ticket.equalsTicket(calendar);
            if (flame==true){
                return true;
            }
        }
        return false;
    }
    public static void plane_ticket_dates(Ticket ticket){
        List<Plane> misAviones = Gestion.add_a_Flota(new ArrayList<>());
        boolean flame = false;
        int i=0;
        System.out.println("<<< Elija opcion >>>");
        System.out.println("Aviones disponibles para la fecha: "+ ticket.fechaDeViaje.get(Calendar.DATE)+"/"+ticket.fechaDeViaje.get(Calendar.MONTH));
        for (Plane plane: misAviones){
            flame=ticke_dates(plane, ticket);
            if (flame == false){
                System.out.println(i +"-Avion: "+ plane.getNombre());
            }
            i++;
        }
    }

    public static int eligeAvion(Ticket ticket) throws IOException {
        Scanner scan = new Scanner(System.in);
        int respuesta;
        int pos = -1;
        do {
            plane_ticket_dates(ticket);
            respuesta = scan.nextInt();

        }while(respuesta==0);

        return pos=respuesta;
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
    public static void ticket_passager(Ticket ticket) throws IOException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Passenger> aux = new ArrayList<>();
        Crud crud = new Crud();
        Menu menu = new Menu();

        FileManagement file = new FileManagement();
        aux = file.jSonToArrayList("pasajeros.json");

        System.out.println("Ingrese su DNI para vincular el ticket");
        String dni= scan.nextLine();
        int pocicion=crud.buscaPorDni("pasajeros.json", dni);
        if (pocicion>0) {
            Passenger person = aux.get(pocicion);
            System.out.println(aux.get(crud.buscaPorDni("pasajeros.json", dni)));
            ticket.setPassager(person);

        }else{
            System.out.println("No se a encontrado en el sistema. Registrese ");
            crud.AltaPassenger("pasajeros.json");
            System.out.println("Ahora ingresado vuelva a crear el ticket");
            menu.primerMenu();
        }
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ID ticket=" + ticket +
                ", Passager=" + person.getName() +
                ", Dates=" + fechaDeViaje.get(Calendar.DATE)+"/"+fechaDeViaje.get(Calendar.MONTH)+
                ", destination=" + destination +
                ", Seats='" + this.getAgregarPasajeros() +
                ", Price='" + price + '\'' +
                 ", Plane='" + plane.getNombre() + '\'' +
                '}';
    }


}