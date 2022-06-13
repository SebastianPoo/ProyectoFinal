
import FolderPlane.Gestion;
import FolderPlane.Plane;

import Menu.Menu;
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

    public static void main(String[] args) throws IOException {


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
}
