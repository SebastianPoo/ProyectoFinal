import FolderPlane.Gold;
import FolderPlane.Plane;
import Ticket.Ticket;
import Travel.Distances;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*Distances distancia = Distances.BsAs_Cor;
        Distances distancia2 = Distances.Cor_Mon;
        int suma;
        suma= distancia.retornarNumero()+ distancia2.retornarNumero();
        System.out.println(suma);

        Gold avionGold= new Gold(1000, 500,10,1200,50000, Plane.TipoMotor.MOTOR_A_REACCION);
        Ticket ticket1 = new Ticket(17, Distances.BsAs_Cor, "hola", avionGold);
        ticket1.costoTicket();

        System.out.println(ticket1.toString());*/

        Scanner scan = new Scanner(System.in);
        int respuesta;
        do {
            System.out.println("<<< Bienvenidos a AeroTaxi >>>");
            System.out.println("1- AeroTaxi Bronze");
            System.out.println("2- AeroTaxi Plata");
            System.out.println("3- AeroTaxi Gold");
            System.out.println("0- ESC");
            respuesta = scan.nextInt();
            switch (respuesta){
                case 1:
                    System.out.println("Bronze en proceso..");
                    do {
                        System.out.println("Elija ubicación:");
                        System.out.println("1- Ventana");
                        System.out.println("2- Pasillo");
                        System.out.println("0- ESC");
                        respuesta = scan.nextInt();
                        switch (respuesta){
                            case 1:
                                System.out.println("con ventana");
                                break;
                            case 2:
                                System.out.println("en pasillo");
                                break;
                            case 0:
                                System.out.println("ESC");
                                break;
                            default:
                                System.out.println("Solo puede elegir las opciones 1 o 2");
                                break;
                        }
                    }while (respuesta != 0);
                    break;
                case 2:
                    System.out.println("Plata en proceso..");
                    do {
                        System.out.println("Elija confort:");
                        System.out.println("1- Con frazada");
                        System.out.println("2- Con almohada");
                        System.out.println("0- ESC");
                        respuesta = scan.nextInt();
                        switch (respuesta){
                            case 1:
                                System.out.println("con frazada entonces");
                                break;
                            case 2:
                                System.out.println("con almohada entonces");
                                break;
                            case 0:
                                System.out.println("ESC");
                                break;
                            default:
                                System.out.println("Solo puede elegir las opciones 1 o 2");
                                break;
                        }
                    }while (respuesta != 0);
                    break;
                case 3:
                    System.out.println("Gold en proceso..");
                    do {
                        System.out.println("Elija Comunicación:");
                        System.out.println("1- Con WiFi");
                        System.out.println("2- Sin WiFi");
                        System.out.println("0- ESC");
                        respuesta = scan.nextInt();
                        switch (respuesta){
                            case 1:
                                System.out.println("con WiFi entonces");
                                break;
                            case 2:
                                System.out.println("sin WiFi entonces");
                                break;
                            case 0:
                                System.out.println("ESC");
                                break;
                        default:
                            System.out.println("Solo puede elegir las opciones 1 o 2");
                            break;
                        }
                    }while (respuesta != 0);
                    break;
                default:
                    System.out.println("Solo puede elegir las opciones 1, 2, 3 o 0...");
                    break;
            }
        }while(respuesta != 0);
        System.out.println("despegue !!");
    }

}

