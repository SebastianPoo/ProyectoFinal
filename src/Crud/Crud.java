package Crud;

import Files.FileManagement;
import Passenger.Passenger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Crud{
    ArrayList<Passenger> passengers = new ArrayList<>();
    FileManagement file = new FileManagement();


    public Crud() {}

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


            file.arrayToJsonFormat(passengers, nombreArchivo);
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
         try {
             int index = buscaPorDni(archivoPasajero, Dni);
             aux.remove(index);
             for (var pasajero : aux) {
                 System.out.println(pasajero);
             }

             file.arrayToJsonFormat(aux, archivoPasajero);
             System.out.println("El pasajero ha sido eliminado correctamente");
         } catch (Exception e){
             System.out.println("El Pasajero Buscado No Existe");
         }
    }

    public int buscaPorDni (String archivoPasajero, String dni) {
        ArrayList <Passenger>  aux = file.jSonToArrayList(archivoPasajero);
        int index= -1;

        for (var pasajero: aux) {
            if (pasajero.getDni().contains(dni)){
                index= aux.indexOf(pasajero);
            }
        }

        return index;
    }

    public void modificarDatosPasajero (String archivoPasajero){
        Scanner scan = new Scanner(System.in);
        System.out.println(" Ingrese el dni del pasajero a buscar ");
        String dni= scan.nextLine();
        ArrayList <Passenger>  aux = file.jSonToArrayList(archivoPasajero);
        int index =buscaPorDni(archivoPasajero, dni);
        System.out.println(" Que desea modificar ?");
        System.out.println("1 - NOMBRE Y APELLIDO");
        System.out.println("1 - EDAD");
        System.out.println("3 - DNI");
        int option = scan.nextInt();
        scan.nextLine();
        switch (option){
            case 1 :
                System.out.println("Ingrese De Nuevo El Nombre");
                String name = scan.nextLine();
                aux.get(index).setName(name);
                scan.nextLine();
                System.out.println("Ingrese De Nuevo El Apellido");
                String apellido = scan.nextLine();
                aux.get(index).setLastName(apellido);
                break;
            case 2:
                System.out.println("Ingrese La Edad");
                Integer edad = scan.nextInt();
                aux.get(index).setAge(edad);
            case 3 :
                System.out.println("Ingrese El Nuevo DNI");
                String newDNI = scan.nextLine();
                aux.get(index).setDni(newDNI);
                break;

            default:
                System.out.println("La opcion es incorrecta");
        }

        file.arrayToJsonFormat(aux, archivoPasajero);
    }

}



