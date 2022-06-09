
import FolderPlane.Gestion;
import FolderPlane.Plane;

import Ticket.Ticket;
import Travel.Distances;
import Travel.Travel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // TODO: 02/06/2022 Pruebas de metodos
        Gestion.persistencia(Gestion.add_a_Flota(new ArrayList<>()),"ARCHIVO_FLOTA");     //todo metodo persistencia funciona
        //  muestraJson();
       // String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
        //int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));
        //System.out.println("nombre es " + nombre + " edad: " + edad );
        List<Plane> misAviones = Gestion.add_a_Flota(new ArrayList<>());

        // TODO muestra ArrayList
        muestraLista((ArrayList<Plane>) misAviones);
        Ticket ticket = new Ticket(12, Distances.BsAs_Cor,"12", misAviones.get(1));
        System.out.println("El ticket es " +  ticket.toString());

        Travel viaje1 = new Travel(ticket, misAviones.get(1));
        System.out.println("El primer viaje es " + viaje1.toString());

        //Gestion.persistencia(Gestion.add_a_List_Ticket(new ArrayList<>(),misAviones.get(1)), "ARCHIVO_TICKETS");
        List<Ticket> misTickets = Gestion.add_a_Ticket(new ArrayList<>(),new Ticket(12,Distances.BsAs_Mon,"15", misAviones.get(5)));
        misTickets.add(new Ticket(15,Distances.BsAs_Cor,"11",misAviones.get(2)));
        for (Ticket ticket1 : misTickets){
            System.out.println(ticket1.toString());
        }
        //Gestion.persistencia((List<Ticket>) misTickets,"archiTickets");
        List<Travel> misTravel = 





    }

    public static void muestraJson(){     //TODO --no funciona leer archivo
        Gson gson = new Gson();
        try {
            File file = new File("ARCHIVO_DE_AVIONES");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Plane avion = gson.fromJson(bufferedReader, Plane.class);
            System.out.println("Lo traido del archivo gson " + avion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void muestraLista(ArrayList<Plane> lista){

        for (Plane plane : lista){
            System.out.println(plane.toString());
        }
    }

    public static void dias_semana(){
        System.out.println(LocalDate.now().getDayOfWeek());
        LocalDate hoy = LocalDate.parse("2022-06-07");
        System.out.println("1 miercoles " + hoy.getDayOfWeek().plus(01));
        System.out.println("2 jueves " + hoy.getDayOfWeek().plus(02));
        System.out.println("3 viernes " + hoy.getDayOfWeek().plus(03));
        System.out.println("4 sabado " + hoy.getDayOfWeek().plus(04));
        System.out.println("5 domingo " + hoy.getDayOfWeek().plus(05));
        System.out.println("6 lunes " + hoy.getDayOfWeek().plus(06));
        System.out.println("7 martes " + hoy.getDayOfWeek().plus(07));
        String viaje_a_Cordoba = String.valueOf(hoy.getDayOfWeek().plus(01));
        System.out.println("El viaje a Cordoba es " + viaje_a_Cordoba );
        String dia_de_viaje_solicitado = String.valueOf(hoy.getDayOfWeek().plus(01));
        System.out.println("Dia solicitado es " + dia_de_viaje_solicitado);
    }
}
