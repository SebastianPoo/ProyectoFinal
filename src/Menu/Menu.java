package Menu;


import Files.FileManagement;
import FolderPlane.Bronze;
import FolderPlane.MotorType;
import FolderPlane.Plane;
import Passenger.Passenger;

import java.io.IOException;
import java.util.ArrayList;

public class Menu {
     public static void main(String[] args) throws IOException {
          Passenger person = new Passenger("Maxi", "Fernandez", "31.942.699", 30);
          Passenger person2 = new Passenger("Carlos", "Fernandez", "32.932.399", 34);
          Passenger person3 = new Passenger("Lucas", "Fernandez", "39.942.699", 20);
          Bronze plane1= new Bronze();

          System.out.println(plane1);
          ArrayList<Passenger> pasajeros = new ArrayList<>();
          ArrayList pasajerosJson = new ArrayList<>();
          pasajeros.add(person);
          pasajeros.add(person2);
          pasajeros.add(person3);
          FileManagement file = new FileManagement();
          file.arrayListToJson(pasajeros);

          pasajerosJson =file.jSonToArrayList("archivoJson.txt");
          System.out.println(pasajerosJson);
     }



}

