package Files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

public class FileManagement {

    public static void escribiendoArchivo() throws IOException {

        try {
          BufferedWriter buffer = new BufferedWriter(new FileWriter(new File("prueba.txt")));
          buffer.write("Vayanse todos a la re calcada re concha de su madre");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

