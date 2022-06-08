package Files;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import Passenger.Passenger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FileManagement {

    public FileManagement() {
    }

    Gson gson = new Gson();




    public void escribiendoArchivo(String string) throws IOException {

        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(new File("prueba.txt")));
            buffer.write(string);
            buffer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

   public void arrayListToJson (ArrayList array, String nombreArchivo) throws IOException {
        try{
            String jSon=gson.toJson(array);
            BufferedWriter buffer = new BufferedWriter(new FileWriter(new File(nombreArchivo)));
            buffer.write(jSon);
            buffer.close();


   } catch (IOException e){
            System.out.println(e.getMessage());
        }

        }


        public ArrayList jSonToArrayList (String archivoJson){

                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                BufferedReader reader = null;

                ArrayList<Passenger> passengers= new ArrayList<>();

                try {
                    reader = new BufferedReader(new FileReader(new File(archivoJson)));
                    passengers = gson.fromJson(reader,
                            (new TypeToken<ArrayList<Passenger>>() {}.getType())
                    );

                    for(var passenger : passengers) {
                        System.out.println(passenger);
                    }

                } catch (IOException e) {
                    e.printStackTrace();

                } finally {
                    try {
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

         return passengers;
        }

    public  <T> void arrayToJsonFormat(ArrayList<T> t, String nombreArchivo) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter whrite = null;

        try {
            whrite = new BufferedWriter(new FileWriter(new File(nombreArchivo)));
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



