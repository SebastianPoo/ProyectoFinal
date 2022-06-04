package FolderPlane;

import Person.Person;
import Ticket.Ticket;
import Travel.Travel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Gestion {

    private List <Plane> planes;
    private LinkedList<Person> passenger;
    private LinkedList<Ticket> ticket;
    private LinkedList<Travel> travel;


    public Gestion (){
    }

    public static  ArrayList<Plane> add_a_Flota(ArrayList planes){

        Bronze boeing123 = new Bronze();
        Bronze boeing124 = new Bronze();
        Silver eclipse550 = new Silver();
        Silver eclipse555 = new Silver();
        Gold cessna550 = new Gold();
        Gold cessna650 = new Gold();

        planes.add(boeing123);
        planes.add(boeing124);
        planes.add(eclipse555);
        planes.add(cessna650);
        planes.add(eclipse550);
        planes.add(cessna550);

        return planes;
    }
    ///VER DEL ARCHIVO
    public static  <T> void persistencia(List<T> t, String nombre) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter whrite = null;

        try {
            whrite = new BufferedWriter(new FileWriter(new File(nombre)));
            gson.toJson(t, t.getClass(), whrite);
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (whrite != null) {
                try {
                    whrite.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
