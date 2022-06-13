

import FolderPlane.*;
import Menu.*;
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
import java.util.Calendar;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class Main {

    public static void main(String[] args) throws IOException {

        // TODO: 02/06/2022 Pruebas de metodos
        Gestion.persistencia(Gestion.add_a_Flota(new ArrayList<>()),"ARCHIVO_FLOTA");     //todo metodo persistencia funciona
          //muestraJson();
       // String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
        //int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));
        //System.out.println("nombre es " + nombre + " edad: " + edad );
        //List<Plane> misAviones = Gestion.add_a_Flota(new ArrayList<>());

        // TODO muestra ArrayList
       // muestraLista((ArrayList<Plane>) misAviones);
        //Ticket ticket = new Ticket(12, Distances.BsAs_Cor,"12", misAviones.get(1));
       // System.out.println("El ticket es " +  ticket.toString());

        //Travel viaje1 = new Travel(ticket, misAviones.get(1));
       // System.out.println("El primer viaje es " + viaje1.toString());

       // List<Ticket> misTickets = Gestion.add_a_Ticket(new ArrayList<>(),new Ticket(12,Distances.BsAs_Mon,"15", misAviones.get(5)));
        //misTickets.add(new Ticket(15,Distances.BsAs_Cor,"11",misAviones.get(2)));
       // for (Ticket ticket1 : misTickets){
      //      System.out.println(ticket1.toString());
      //  }

        // TODO: 11/06/2022 MENU
        Menu.primerMenu();






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



    public static void pruebas_calender(){
        Calendar hoyFinal = Calendar.getInstance();
        Calendar hoy = Calendar.getInstance();
        ///System.out.println(" que es esto " + hoyFinal.getTime());
       //hoyFinal.set(Calendar.DAY_OF_WEEK,6);
       // System.out.println("despues del set es " + hoyFinal.getTime());
       // hoyFinal.set(2023,9,06,22,21,20);
        System.out.println(" Y toda la fecha seteada " + hoyFinal.getTime());
        System.out.println("Esta es la semana " + hoyFinal.getFirstDayOfWeek());
        System.out.println("Sola dia de la semana " + hoyFinal.equals(hoy) );
        System.out.println("dia hoy  " + hoy.get(Calendar.DATE) + "/"  +  hoy.get(Calendar.MONTH) );
        System.out.println("dia Final" + hoyFinal.get(Calendar.DATE) + "/" + hoyFinal.get(Calendar.MONTH));
    }
    // TODO: 12/06/2022 Prueba asientos libres
    public static void pruebasAsientosLIbres(List<Plane> planeList) {
        System.out.println(planeList.get(2).vacantSeat(2));
        System.out.println(planeList.get(2).vacantSeat(1));
        System.out.println(planeList.get(2).getMaxPassenger());
        System.out.println(planeList.get(4).getMaxPassenger());
    }
}
