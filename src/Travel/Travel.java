
package Travel;

import FolderPlane.Plane;
import Person.Person;

import java.util.List;


public class Travel {                   //Resultado final de un viaje- esto es un objeto. Viaje.
    private Integer earnings;             ////Ganancias - total de dinero ingresado en el viaje
    private Distances distances;
    private Plane plane;
    private List<Person> passenger;    ////arreglo de pasajeros nombre y apellido  del viaje

    // TODO: Ver como crear un metodo que instancie un objeto Travel
    public Travel(Integer earnings, Distances distances, Plane plane, List<Person> passenger) {
        this.earnings = earnings;
        this.distances = distances;
        this.plane = plane;
        this.passenger = passenger;
    }


    @Override
    public String toString() {
        return "Travel{" +
                "earnings=" + earnings +
                ", distances=" + distances +
                ", plane=" + plane +
                ", passenger=" + passenger +
                '}';
    }
}



