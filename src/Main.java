
import FolderPlane.Gestion;
import FolderPlane.Plane;

import com.google.gson.Gson;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // TODO: 02/06/2022 Pruebas de metodos
        //Gestion.persistencia(Gestion.add_a_Flota());     todo metodo persistencia funciona
        //  muestraJson();
        String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));
        System.out.println("nombre es " + nombre + " edad: " + edad );

    }

    public static void muestraJson(){
        Gson gson = new Gson();
        try {
            File file = new File("ARCHIVO_DE_AVIONES");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Plane avion = gson.fromJson(bufferedReader, Plane.class);
            System.out.println("Lo traido del archivo gson " + avion);
        } catch (IOException e) {
            e.printStackTrace();
        } /*catch (Exception e){
            e.printStackTrace();
        }finally {
            if(file != null){
                try {
                    fSalida.close();
                }catch (IOException e){
                    e.printStackTrace();*/

    }
}
