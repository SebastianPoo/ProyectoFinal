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
import java.util.LinkedList;

public abstract class Gestion {

    private LinkedList<Plane> flota = new LinkedList<>();
    private LinkedList<Person> passenger = new LinkedList<>();   /// lista que no se repite
    private LinkedList<Ticket> ticket = new LinkedList<>();     ///lista que no se repite
    private LinkedList<Travel> travel = new LinkedList<>();     ///lista que no se repite

    public static LinkedList<Plane> add_a_Flota(){
        LinkedList<Plane> flota = new LinkedList<>();

        Bronze boeing123 = new Bronze();
        Silver eclipse550 = new Silver();
        Gold cessna550 = new Gold();

        flota.add(boeing123);
        flota.add(eclipse550);
        flota.add(cessna550);

        return flota;
    }
    ///VER DEL ARCHIVO
    public static  <T> void persistencia(LinkedList<T> t) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter whrite = null;

        try {
            whrite = new BufferedWriter(new FileWriter(new File("ARCHIVO_DE_AVIONES")));
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
