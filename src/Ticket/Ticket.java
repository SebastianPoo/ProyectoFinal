package Ticket;

import FolderPlane.Plane;
import Passenger.Passenger;

import java.util.Objects;

public class Ticket {
    private int ticket;
    Passenger passenger;
    Plane plane;
    Enum destination;
    String Seat;

    public Ticket() {
    }

    public Ticket(int ticket, Passenger passenger, Plane plane, Enum destination, String seat) {
        this.ticket = ticket;
        this.passenger = passenger;
        this.plane = plane;
        this.destination = destination;
        Seat = seat;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Enum getDestination() {
        return destination;
    }

    public void setDestination(Enum destination) {
        this.destination = destination;
    }

    public String getSeat() {
        return Seat;
    }

    public void setSeat(String seat) {
        Seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket1 = (Ticket) o;
        return ticket == ticket1.ticket && Objects.equals(passenger, ticket1.passenger) && Objects.equals(plane, ticket1.plane) && Objects.equals(destination, ticket1.destination) && Objects.equals(Seat, ticket1.Seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket, passenger, plane, destination, Seat);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticket=" + ticket +
                ", passenger=" + passenger +
                ", plane=" + plane +
                ", destination=" + destination +
                ", Seat='" + Seat + '\'' +
                '}';
    }
}
