package Files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.Gson;

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

   public void arrayToJson (ArrayList array) throws IOException {
        try{
            String jSon=gson.toJson(array);
            BufferedWriter buffer = new BufferedWriter(new FileWriter(new File("archivoJson.txt")));
            buffer.write(jSon);
            buffer.close();


   } catch (IOException e){
            System.out.println(e.getMessage());
        }

        }
   }



