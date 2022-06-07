package FolderPlane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Gestion extends Plane {

    private LinkedList<Plane> flota = new LinkedList<>();

    public Gestion(int coste, double fuel, int maxPassenger, double kmXhs, double kmTraveled, TipoMotor tipoMotor) {
        super(coste, fuel, maxPassenger, kmXhs, kmTraveled, tipoMotor);
    }




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

    public void flotaToJson (){
        persistencia(add_a_Flota());
    }


    @Override
    public int catering(int costo) {
        return 0;
    }

    @Override
    public int wifi(int costo) {
        return 0;
    }

    @Override
    public int carry_on_bag(int costo) {
        return 0;
    }

    @Override
    public int confort(int costo) {
        return 0;
    }
}
