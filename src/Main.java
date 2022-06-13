
import FolderPlane.Bronze;
import FolderPlane.Gold;
import FolderPlane.Plane;

import Person.Person;
import Ticket.Ticket;
import Travel.Distances;
import Ticket.Fechas;
import Travel.Travel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Person person = new Person() {        };

        Gold avionGold= new Gold(6000, 500,10,1200,50000, Plane.TipoMotor.MOTOR_A_REACCION);


        Bronze avionBronze= new Bronze(2000, 200, 15, 900, 20000, Plane.TipoMotor.MOTOR_A_HELICE);




        Fechas fecha = new Fechas();
       /* Calendar calendar1 =fecha.elegir();
        Calendar calendar2 =fecha.elegir();
        Calendar calendar3 =fecha.elegir();

        //System.out.println(calendar1.get(Calendar.DATE)+"/"+calendar1.get(Calendar.MONTH)+"/"+calendar1.get(Calendar.YEAR));

        avionGold.setList(calendar1);
        avionGold.setList(calendar2);
        avionGold.setList(calendar3);

        for (Calendar calendar: avionGold.listPlane) {
            System.out.println(calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR));
        }*/

        Calendar calendar4 =fecha.elegir();
        //Calendar calendar5 =fecha.elegir();
       // Calendar calendar6 =fecha.elegir();
        Calendar calendar7 = Calendar.getInstance();
        calendar7.set(2022,7,15);
        Calendar calendar8 = Calendar.getInstance();
        calendar8.set(2022,8,15);
        Calendar calendar9 = Calendar.getInstance();
        calendar9.set(2022,9,15);

        Ticket ticket1 = new Ticket(Distances.BsAs_Cor, "hola", avionGold, person,calendar4);
        ticket1.costoTicket(ticket1);
        //System.out.println(ticket1.toString());

        //avionBronze.setList(calendar4);
        //avionBronze.setList(calendar5);
        //avionBronze.setList(calendar6);
        avionBronze.setList(calendar7);
        avionBronze.setList(calendar8);
        avionBronze.setList(calendar9);

        //System.out.println(avionBronze.toString());
        //avionBronze.getDates();


    }

    public static void muestraLista(ArrayList<Plane> lista){

        for (Plane plane : lista){
            System.out.println(plane.toString());
        }
    }
    public static void compareDates(Plane plane, Ticket ticket) {

        boolean flame=false;
        System.out.println(ticket.travelDate.get(Calendar.DATE)+"/"+ticket.travelDate.get(Calendar.MONTH));
        for (Calendar calendar: plane.listPlane ) {
            flame = ticket.equalsTicket(calendar);
            System.out.println("Posterior: "+ flame +"   "+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.MONTH) );
        }
    }
}
