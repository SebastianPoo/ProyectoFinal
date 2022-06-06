package Ticket;

import FolderPlane.Plane;
import Person.Person;
import Travel.Distances;

import java.util.UUID;

public class Ticket {
    private UUID idTicket;
    private int price;
    private Distances destination;
    private Plane plane;
    private Person passager;
    private String Seat;

    public Ticket() {
    }

    public Ticket( Distances destination, String seat, Plane plane, Person passager) {
        this.idTicket= UUID.randomUUID();
        this.destination = destination;
        this.Seat = seat;
        this.plane = plane;
        this.passager = passager;
    }



    public Distances getDestination() {
        return destination;
    }

    public String getSeat() {
        return Seat;
    }

    public void setPrice(int price) {
        this.price = price;
    }

/*    public int travelCost(Plane plane, Distances distances){
        int coste=0;
        coste=(distances.retornarNumero()*plane.getKmTraveled());
                //(canKm * cosKm)+(canPas * 3500)+(tarifaTipoAvion)
        return coste;
    }*/

    public void costoTicket(Ticket ticket) {
        int costo=0;
        costo=plane.carry_on_bag(costo)+plane.confort(costo)+plane.catering(costo)+ plane.wifi(costo)+plane.getCoste();

        System.out.println(costo);
        ticket.price+=costo;
    }
    @Override
    public String toString() {
        return "Ticket.Ticket{" +
                "ticket=" + idTicket +
                ", destination=" + destination.retornarNumero() +
                ", Seat='" + Seat +
                ", Persona=' " + passager.getNombre() + passager.getApellido() +
                ", Price='"+ price + '\'' +
                '}';
    }
}

