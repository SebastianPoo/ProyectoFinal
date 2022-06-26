package Ticket;

import Crud.Crud;
import Files.FileManagement;
import FolderPlane.Gestion;
import FolderPlane.Plane;
import Menu.Menu;
import Passenger.Passenger;
import Travel.Distances;


import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Ticket implements Serializable {
    private UUID ticket;
    private int price;
    private Distances destination;
    private int total_passengers;
    private Plane plane;
    private int id_Passenger;
    private String Seat;
    private Calendar fechaDeViaje;




    public Ticket() {
        this.ticket = UUID.randomUUID();
    }

    public int getId_Passenger() {
        return id_Passenger;
    }

    public void setId_Passenger(int id_Passenger) {
        this.id_Passenger = id_Passenger;
    }

    public Ticket(Distances destination, String seat, Plane plane) {
        this.ticket = UUID.randomUUID();
        this.destination = destination;
        Seat = seat;
        this.plane = plane;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal_passengers() {
        return total_passengers;
    }

    public void setTotal_passengers(int total_passengers) {
        this.total_passengers = total_passengers;
    }

    public Distances getDestination() {
        return destination;
    }

    public void setDestination(Distances destination) {
        this.destination = destination;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }


    public void setFechaDeViaje(Calendar fechaDeViaje) {
        this.fechaDeViaje = fechaDeViaje;
    }

    public void costoTicket() {
        int costo = 0;
        System.out.println("      Costo total del ticket  ");
        if (this.getTotal_passengers() > 1){
            System.out.println("Pasajeros agregados, total de boletos: " + this.getTotal_passengers());
        }
            costo = this.plane.carry_on_bag(costo) + this.plane.confort(costo)
                + this.plane.catering(costo) + this.plane.wifi(costo) + this.plane.getPlaneType() + 3500;
            costo  = (getTotal_passengers() * costo) + (this.plane.getCoste() * this.destination.retornarNumero());

        System.out.println("     Costo del viaje en avion " + "<" + plane.getNombre() +">" + " es " + plane.getPlaneType()  );
        System.out.println("     por pasajero es " + 3500 + "  total: " + costo  + "\n" );
        this.setPrice(costo) ;
    }

    @Override
    public String toString() {
        return  "ID ticket:      " + ticket.toString().substring(0,10).toUpperCase(Locale.ROOT) +  "\n" +
                "id Passsger     " + getId_Passenger() + "\n" +
                "destination:    " + destination + "\n" +
                "Seats:          " + this.getTotal_passengers() + "\n" +
                "Plane:          " + plane.getNombre() + "\n" +
                "Price:         $" + price + "\n" ;
    }

    public static void ticket_registration(String nameFileTicket, String nameFilePax) throws IOException {
        List<Plane> flota = Gestion.add_a_Flota(new ArrayList<>());
        FileManagement filePas = new FileManagement();
        FileManagement fileTi = new FileManagement();
        ArrayList <Passenger> pax = filePas.jSonToArrayList(nameFilePax);
        ArrayList <Ticket> tickets = fileTi.jSonToArrayListTicket(nameFileTicket);

        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        Crud crud = new Crud();
        Ticket ticket = new Ticket();
        Fechas fechas = new Fechas();

        int option = 0;
        if (fileTi.isFileEmpty(new File(nameFileTicket))) {

            while (option != 2) {
                System.out.println(             "NUEVO ARCHIVO DE TICKET EN PROCESO" + "\n");
                eligeDestino(ticket);

                Calendar calendar= fechas.elegir();
                ticket.setFechaDeViaje(calendar);

                int companions= menu.addCompa();
                ticket.setTotal_passengers(companions);

                int num = eligeAvion(ticket);
                ticket.setPlane(flota.get(num));
                ticket.costoTicket();

                System.out.println("ENTER DNI");
                String dni = scan.nextLine();
                newPass(nameFilePax, dni);
                pax = filePas.jSonToArrayList(nameFilePax);
                ticket.setId_Passenger(pax.get(crud.buscaPorDni(nameFilePax,dni)).getId());

                System.out.println(           "Datos del ticket" + "\n"  + ticket.toString());
                    System.out.println(       "Desea Confirmar el Ticket ?  --- S   /   N");
                    String conf= scan.nextLine().toUpperCase();
                    if (conf.contains("S")){
                        tickets.add(ticket);
                    }
                System.out.println(             "1 para modificar ticket o 2 para continuar");
                option = scan.nextInt();
                scan.nextLine();
                fileTi.arrayToJsonFormat(tickets, nameFileTicket);


            }

        } else {
            ArrayList<Ticket> aux = fileTi.jSonToArrayListTicket(nameFileTicket);
            while (option != 2) {
                eligeDestino(ticket);

                Calendar calendar= fechas.elegir();
                ticket.setFechaDeViaje(calendar);


                int companions= menu.addCompa();
                ticket.setTotal_passengers(companions);

                int num = eligeAvion(ticket);
                ticket.setPlane(flota.get(num));
                ticket.costoTicket();

                System.out.println("ENTER DNI");
                String dni = scan.nextLine();
                newPass(nameFilePax, dni);       // TODO: 6/17/2022 busca el dni en el archivo, sino existe lo agrega
                pax = filePas.jSonToArrayList(nameFilePax);  // TODO: 6/18/2022 Fue necesario traer archivo para setear pasajero

                ticket.setId_Passenger(pax.get(crud.buscaPorDni(nameFilePax,dni)).getId());

                System.out.println(            "Datos de nuevo ticket" + "\n" + ticket.toString());
                System.out.println(            "Desea Confirmar El Ticket ?  --- S   /   N");
                String conf= scan.nextLine().toUpperCase();
                if (conf.contains("S")){
                    aux.add(ticket);
                }
                System.out.println(           " 1 para modificar ticket o 2 para confirmar");
                option = scan.nextInt();
                scan.nextLine();
                fileTi.arrayToJsonFormatTicket(aux, nameFileTicket);
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

    public static void eligeDestino(Ticket tick)  {
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
                    tick.setDestination(Distances.Mon_San);
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
        System.out.println("1- Bs.As_Cordoba ");
        System.out.println("2- Cordoba_Santiago ");
        System.out.println("3- Corboda_Montevideo ");
        System.out.println("4- Bs.As_Santiago ");
        System.out.println("5- Montevideo_Santiago ");
        System.out.println("6- Bs.As_Montevideo ");
        System.out.println("0- ESC");
    }

    public static void newPass (String nameFile, String dni) throws RuntimeException, IOException {
        Crud crud = new Crud();
        try {
           if (crud.buscaPorDni(nameFile,dni)>=0){
            FileManagement file = new FileManagement();
            ArrayList<Object> aux = file.jSonToArrayList(nameFile);

            System.out.println("             Cliente encontrado " +  "\n"  + aux.get(crud.buscaPorDni(nameFile, dni)));
        }else {
                System.out.println("            Ingrese datos para nuevo pasajero");
                crud.altaPassenger(nameFile);

        }
        }catch (RuntimeException e){
            System.out.println("               Archivo no encontrado" );
        }
    }

    public static int search_DNI_ticket(ArrayList<Ticket> tickets, String dniBusca) throws RuntimeException{
        Crud crud = new Crud();
        FileManagement file = new FileManagement();
        ArrayList <Passenger>  aux = file.jSonToArrayList("ARCHIVO_PASAJEROS.json");
        int index = crud.buscaPorDni("ARCHIVO_PASAJEROS.json", dniBusca);
        /*System.out.println("Pasajero de busca_dni_ticket " + " ID " + aux.get(index).getId() + " " +
                aux.get(index));*/
        Passenger aux1 = aux.get(index);
        int index1= -1;

        try{
            for (var ticket: tickets) {
                System.out.println("Entre al try de search_DNI_ticket");
                if (aux1.getId() == ticket.getId_Passenger()){
                    index1= tickets.indexOf(ticket);
                }
                System.out.println("ticket con id de pasajero numero " + aux1.getId() +
                        " " + ticket.toString());
            }
        }catch (RuntimeException e){
            System.out.println("No se encuentran el DNI");
        }
        return index1;
    }

    public static void bajaTicket (String fileTicket, String idBusca){
        FileManagement file = new FileManagement();
        ArrayList <Ticket> aux = file.jSonToArrayListTicket(fileTicket);
        ArrayList <Passenger> aux1 = file.jSonToArrayList("ARCHIVO_PASAJEROS.json");
        System.out.println("<<<Persona>>>" + aux1.get(search_DNI_ticket(aux,idBusca)) + " index" + search_DNI_ticket(aux,idBusca)            );

        try {
            int index = search_DNI_ticket(aux, idBusca);
            aux.remove(index);

            file.arrayToJsonFormat(aux, fileTicket);
            System.out.println("El pasajero ha sido eliminado correctamente");
        } catch (Exception e){

            System.out.println("El Pasajero Buscado No Existe");
            System.out.println(e.getMessage());

        }
    }


}