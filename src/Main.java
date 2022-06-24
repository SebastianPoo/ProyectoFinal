
import Files.FileManagement;
import FolderPlane.Gestion;
import FolderPlane.Plane;
import Menu.Menu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

      Menu.primerMenu();
        /*List<Plane> misAviones = Gestion.add_a_Flota(new ArrayList<>());

        for (Plane plane: misAviones){
            System.out.println("Avion" + plane.toString());
        }
        System.out.println("lista de fechas del 0" + misAviones.get(0).getListPlane());
        System.out.println("lista de fechas del 1" + misAviones.get(1).getListPlane());
        System.out.println("lista de fechas del 2" + misAviones.get(2).getListPlane());
        System.out.println("lista de fechas del 3" + misAviones.get(3).getListPlane());
        System.out.println("lista de fechas del 4" + misAviones.get(4).getListPlane());
        System.out.println("lista de fechas del 5" + misAviones.get(5).getListPlane());

        Gestion.persistencia(misAviones,"ARCHIVO_AVIONES");
        //leyendoArchivo();

        List<Plane> misAviones1 = FileManagement.jsonToArray("ARCHIVO_AVIONES");



        System.out.println("\n Mis aviones 1 " + misAviones1.get(0) );
        System.out.println("\n Mis aviones 2 " + misAviones1.get(1) );
        System.out.println("\n Mis aviones 3 " + misAviones1.get(2) );
        System.out.println("\n Mis aviones 4 " + misAviones1.get(3) );
        System.out.println("\n Mis aviones 5 " + misAviones1.get(4) );
        System.out.println("\n Mis aviones 6 " + misAviones1.get(5) );
*/

    }
    public static void leyendoArchivo() {
        // si no existe el archivo... salgo de la funcion
        if(!new File("ARCHIVO_AVIONES").exists())
            return;

        BufferedReader fEntrada = null;

        try{
            fEntrada = new BufferedReader(
                    new FileReader(new File("ARCHIVO_AVIONES"))
            );

            String linea = null;

            while((linea = fEntrada.readLine()) != null) {
                System.out.println(linea);
            }

        }catch(IOException e) {
            System.out.println(e.getMessage());

        } finally {

            // CIERRO EL ARCHIVO AL FINALIZAR

            if(fEntrada != null) {
                try {
                    fEntrada.close();
                }
                catch(IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }


}
