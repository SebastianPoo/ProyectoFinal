package Ticket;

import FolderPlane.Plane;
import Person.Person;
import Travel.Distances;

import java.time.LocalDate;

public class Ticket {
    private int ticket;
    private int price;
    private Distances destination;
    private Plane plane;
    private Person passager;
    private String Seat;                  // --AGREGUE ENCAPSULAMIENTO
    private LocalDate fechaDeViaje;         // ---AGREGAR FECHA DE VIAJE-NECESARIO EN TICKET-

    public Ticket() {
    }

    public Ticket(int ticket, Distances destination, String seat, Plane plane) {
        this.ticket = ticket;
        this.destination = destination;
        Seat = seat;
        this.plane = plane;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public Distances getDestination() {

        return destination;
    }

    public String getSeat() {
        return Seat;
    }

    public void setSeat(String seat) {
        Seat = seat;
    }

  public int travelCost(Plane plane){
           int coste=0;
                   coste = plane.getCoste();
                //(canKm * cosKm)+(canPas * 3500)+(tarifaTipoAvion)
      return coste;
    }

    public Ticket costoTicket() {
        Ticket ticket = new Ticket();
        ticket.price=plane.carry_on_bag(plane.getCoste());
        return ticket;
    }
    @Override
    public String toString() {
        return "Ticket.Ticket{" +
                "ticket=" + ticket +
                ", destination=" + destination.retornarNumero() +
                ", Seat='" + Seat +
                ", Price='"+ price + '\'' +
                ", Plane='" + plane.getNombre() + '\'' +
                '}';
    }
}
