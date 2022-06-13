package Ticket;

import FolderPlane.Plane;
import Person.Person;
import Travel.Distances;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.UUID;

public class Ticket {
    private UUID idTicket;
    private int price;
    private Distances destination;
    private Plane plane;
    private Person passager;
    private String seat;                  // --AGREGUE ENCAPSULAMIENTO
    public Calendar travelDate;         // ---AGREGAR FECHA DE VIAJE-NECESARIO EN TICKET-

    public Ticket() {
    }

    public Ticket(Distances destination, String seat, Plane plane, Person passager, Calendar travelDate ) {
        this.idTicket = UUID.randomUUID();
        this.destination = destination;
        this.seat = seat;
        this.plane = plane;
        this.passager = passager;
        this.travelDate= travelDate;
    }


    public Distances getDestination() {

        return destination;
    }


    public int travelCost(Plane plane) {
        int coste = 0;
        coste = plane.getCoste();
        //(canKm * cosKm)+(canPas * 3500)+(tarifaTipoAvion)
        return coste;
    }

    public void costoTicket(Ticket ticket) {
        int costo = 0;
        costo = plane.carry_on_bag(costo) + plane.confort(costo) + plane.catering(costo) + plane.wifi(costo) + plane.getCoste();
        System.out.println(costo);
        ticket.price += costo;
    }


    public boolean equalsTicket(Calendar calendar) {
        if (travelDate.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) && travelDate.get(Calendar.DATE) == calendar.get(Calendar.DATE)) {
            return true;
        }else {
            return false;
        }
    }


    @Override
    public String toString() {
        return "Ticket.Ticket{" +
                "ticket=" + idTicket +
                ", destination=" + destination.retornarNumero() +
                ", Seat='" + seat +
                ", Price='" + price + '\'' +
                ", Persona=' " + passager.getNombre() + passager.getApellido() +
                '}';
    }
}

