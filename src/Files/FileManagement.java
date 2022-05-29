package Files;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

import Passenger.Passenger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FileManagement {

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

   public void arrayListToJson (ArrayList array) throws IOException {
        try{
            String jSon=gson.toJson(array);
            BufferedWriter buffer = new BufferedWriter(new FileWriter(new File("archivoJson.txt")));
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
                    ); // hacemos esto porque necesitamos el tipo de dato

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
    }



