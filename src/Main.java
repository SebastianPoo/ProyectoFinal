import Crud.Crud;
import FolderPlane.Gold;
import FolderPlane.Plane;
import Ticket.Ticket;
import Travel.Distances;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Distances distancia = Distances.BsAs_Cor;
        Distances distancia2 = Distances.Cor_Mon;
        int suma;
        suma= distancia.retornarNumero()+ distancia2.retornarNumero();
        System.out.println(suma);

        Gold avionGold= new Gold(1000, 500,10,1200,50000, Plane.TipoMotor.MOTOR_A_REACCION);
        Ticket ticket1 = new Ticket(17, Distances.BsAs_Cor, "hola", avionGold);
        ticket1.costoTicket();

        System.out.println(ticket1.toString());
        Crud crud = new Crud();

        //crud.AltaPassenger("pasajeros.json");
        /// System.out.println("---------------------- --------------------");
        ///System.out.println( " Esta es la persona buscada" + crud.buscaPorDni("pasajeros.json", "35942699"));
         crud.bajaPassenger("pasajeros.json", "35942699");
         crud.modificarDatosPasajero("pasajeros.json");
    }
}
