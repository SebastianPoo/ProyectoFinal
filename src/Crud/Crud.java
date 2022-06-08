package Crud;

import Files.FileManagement;
import Passenger.Passenger;
import Person.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Crud extends Person {
    ArrayList<Passenger> passengers = new ArrayList<>();
    FileManagement file = new FileManagement();


    public Crud() {
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void AltaPassenger (String nombreArchivo) throws IOException {
        Scanner scan = new Scanner(System.in);

        int option = 0;
        if (nombreArchivo.isEmpty()) {

            while (option != 2) {
                System.out.println("Ingrese El Nombre Del Pasajero ");
                String name = scan.nextLine();
                System.out.println("Ingrese El Apellido Del Pasajero ");
                String surname = scan.nextLine();
                System.out.println("Ingrese El DNI Del Pasajero ");
                String dni = scan.nextLine();
                System.out.println("Ingrese la Edad Del Pasajero ");
                Integer age = scan.nextInt();
                Passenger pasajero = new Passenger(name, surname, dni, age);
                passengers.add(pasajero);
                System.out.println("Presione 1 para continar o 2 para salir");
                option = scan.nextInt();
                scan.nextLine();
            }


            file.arrayToJsonFormat(passengers, "pasajeros.txt");
        } else {
            ArrayList<Passenger> aux = new ArrayList<>();
            aux = file.jSonToArrayList(nombreArchivo);
            while (option != 2) {
                System.out.println("Ingrese El Nombre Del Pasajero ");
                String name = scan.nextLine();
                System.out.println("Ingrese El Apellido Del Pasajero ");
                String surname = scan.nextLine();
                System.out.println("Ingrese El DNI Del Pasajero ");
                String dni = scan.nextLine();
                System.out.println("Ingrese la Edad Del Pasajero ");
                Integer age = scan.nextInt();
                Passenger pasajero = new Passenger(name, surname, dni, age);
                aux.add(pasajero);
                System.out.println("Presione 1 para continar o 2 para salir");
                option = scan.nextInt();
                scan.nextLine();
                file.arrayToJsonFormat(aux, nombreArchivo);
            }

        }
    }

    public void bajaPassenger (String archivoPasajero, String Dni){
         ArrayList <Passenger> aux = file.jSonToArrayList(archivoPasajero);
         Passenger passenger = new Passenger();
         passenger=buscaPorDni(archivoPasajero,Dni);
        for (Passenger pasajero: aux) {
            if (pasajero.equals(passenger)){
                aux.remove(pasajero);
            }
        }

        file.arrayToJsonFormat(aux, archivoPasajero);
        System.out.println("El pasajero ha sido eliminado correctamente");
    }

    public Passenger buscaPorDni (String archivoPasajero, String dni) {
        ArrayList <Passenger>  aux = file.jSonToArrayList(archivoPasajero);
       Passenger aux2 = new Passenger();

        for (var pasajero: aux) {
            if (pasajero.getDni().contains(dni)){
             aux2=pasajero;
            }
        }

        return aux2;
    }

}
