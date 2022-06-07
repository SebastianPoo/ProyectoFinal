
package Travel;

import FolderPlane.Plane;
import Person.Person;
import Ticket.Ticket;

import java.time.LocalDateTime;
import java.util.List;


public class Travel {                   //Resultado final de un viaje- esto es un objeto. Viaje.
    private LocalDateTime fecha;
    private Integer earnings;             ////Ganancias - total de dinero ingresado en el viaje
    private Distances distance;
    private Ticket ticket;
    private Plane plane;
    private List<Person> pax;    ////arreglo de pasajeros nombre y apellido  del viaje
    private List<Ticket> tickets;      // arreglos de todos los tickets del viaje

    // TODO: Ver como crear un metodo que instancie un objeto Travel
    public Travel(LocalDateTime fecha, Integer earnings, Distances distances, Plane plane, List<Person> passenger, List<Ticket> tickets) {
        this.fecha = fecha;
        this.earnings = earnings;
        this.distance = distances;
        this.plane = plane;
        this.pax = pax;
        this.tickets = tickets;
    }

    public Travel (Ticket ticket){
        this.fecha = LocalDateTime.now();           // TODO: 05/06/2022 --Es necesario un get de la fecha del  ticket--
        this.earnings = ticket.travelCost(this.plane);
        this.plane = plane;
        this.distance = this.ticket.getDestination();
    }

    @Override
    public String toString() {
        return "Travel{" + '\'' +
                "fecha=" + fecha + '\'' +
                ", earnings=" + earnings + '\'' +
                ", distances=" + distance.name() + '\'' +
                ", plane=" + plane.getNombre() + '\'' +
                ", pax=" + pax + '\'' +
                '}';
}
}
// TODO: 05/06/2022  ----Vamos a intanciar un tavel en el main*----


