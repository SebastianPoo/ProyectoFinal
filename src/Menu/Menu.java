package Menu;

//import FolderPlane.Gestion;

import java.util.Scanner;

public class Menu {
    // comente clase Gestion

    public static void primerMenu () {
        Scanner scan = new Scanner(System.in);
        int respuesta;
        do {
        opcionIntro();
        respuesta = scan.nextInt();
        switch (respuesta){
            case 1:
                case1();
                break;
            case 2:
                case2();
                break;
            case 3:
                case3();
                break;
            default:
                System.out.println("Solo puede elegir las opciones 1, 2, 3 o 0...");
                break;
        }
    }while(respuesta != 0);
        System.out.println("despegue !!");
}

    private static void case1(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Bronze en proceso..");
        int respuesta;
        do {
            opcion0();
            respuesta = scan.nextInt();
            switch (respuesta){
                case 1:
                    opcion1();
                    break;
                case 2:
                    opcion2();
                    break;
                case 0:
                    opcion3();
                    break;
                default:
                    opcionDefault();
                    break;
            }
        }while (respuesta != 0);
    }
    private static void case2(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Plata en proceso..");
        int respuesta;
        do {
            opcion4();
            respuesta = scan.nextInt();
            switch (respuesta){
                case 1:
                    opcion5();
                    break;
                case 2:
                    opcion6();
                    break;
                case 0:
                    opcion3();
                    break;
                default:
                    opcionDefault();
                    break;
            }
        }while (respuesta != 0);
    }
    private static void case3(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Gold en proceso..");
        int respuesta;
        do {
            opcion7();
            respuesta = scan.nextInt();
            switch (respuesta){
                case 1:
                    opcion8();
                    break;
                case 2:
                    opcion9();
                    break;
                case 0:
                    opcion3();
                    break;
                default:
                    opcionDefault();
                    break;
            }
        }while (respuesta != 0);
    }
    private static void opcionIntro() {
        System.out.println("<<< Bienvenidos a AeroTaxi >>>");
        System.out.println("1- AeroTaxi Bronze");
        System.out.println("2- AeroTaxi Plata");
        System.out.println("3- AeroTaxi Gold");
        System.out.println("0- ESC");
    }
    private static void opcion0() {
        System.out.println("Elija ubicación:");
        System.out.println("1- Ventana");
        System.out.println("2- Pasillo");
        System.out.println("0- ESC");
    }
    private static void opcion1() {
        System.out.println("con ventana");
    }
    private static void opcion2() {
        System.out.println("en pasillo");
    }
    private static void opcion3() {
        System.out.println("ESC");
    }
    private static void opcionDefault() {
        System.out.println("Solo puede elegir las opciones 1 o 2");
    }
    private static void opcion4() {
        System.out.println("Elija confort:");
        System.out.println("1- Con frazada");
        System.out.println("2- Con almohada");
        System.out.println("0- ESC");
    }
    private static void opcion5() {
        System.out.println("con frazada entonces");
    }
    private static void opcion6() {
        System.out.println("con almohada entonces");
    }
    private static void opcion7() {
        System.out.println("Elija Comunicación:");
        System.out.println("1- Con WiFi");
        System.out.println("2- Sin WiFi");
        System.out.println("0- ESC");
    }
    private static void opcion8() {
        System.out.println("con WiFi entonces");
    }
    private static void opcion9() {
        System.out.println("sin WiFi entonces");
    }



}
