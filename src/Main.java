
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
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // TODO: 02/06/2022 Pruebas de metodos
        //Gestion.persistencia(Gestion.add_a_Flota(new ArrayList<>()),"ARCHIVO_NUEVO");     //todo metodo persistencia funciona
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
}
