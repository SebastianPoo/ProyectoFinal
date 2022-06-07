import FolderPlane.Gold;
import FolderPlane.Plane;
import Menu.Menu;
import Ticket.Ticket;
import Travel.Distances;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*Distances distancia = Distances.BsAs_Cor;
        Distances distancia2 = Distances.Cor_Mon;
        int suma;
        suma= distancia.retornarNumero()+ distancia2.retornarNumero();
        System.out.println(suma);

        Gold avionGold= new Gold(1000, 500,10,1200,50000, Plane.TipoMotor.MOTOR_A_REACCION);
        Ticket ticket1 = new Ticket(17, Distances.BsAs_Cor, "hola", avionGold);
        ticket1.costoTicket();

        System.out.println(ticket1.toString());*/

        Menu.primerMenu();
    }
}


