package Ticket;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Fechas {
    /*List<Calendar> listCalendario = new ArrayList<Calendar>();*/


    public Fechas(){

    }

    public  Calendar elegir(){
        Calendar day = Calendar.getInstance();
        Calendar dayToday = Calendar.getInstance();
        Scanner scan = new Scanner(System.in);
        int respuesta;
        do {
            do {
                showdates();
                respuesta = scan.nextInt();

                switch (respuesta) {
                    case 1:
                        day.set(Calendar.DATE, 1);
                        break;
                    case 2:
                        day.set(Calendar.DATE, 2);
                        break;
                    case 3:
                        day.set(Calendar.DATE, 3);
                        break;
                    case 4:
                        day.set(Calendar.DATE, 4);
                        break;
                    case 5:
                        day.set(Calendar.DATE, 5);
                        break;
                    case 6:
                        day.set(Calendar.DATE, 6);
                        break;
                    case 7:
                        day.set(Calendar.DATE, 7);
                        break;
                    case 8:
                        day.set(Calendar.DATE, 8);
                        break;
                    case 9:
                        day.set(Calendar.DATE, 9);
                        break;
                    case 10:
                        day.set(Calendar.DATE, 10);
                        break;
                    case 11:
                        day.set(Calendar.DATE, 11);
                        break;
                    case 12:
                        day.set(Calendar.DATE, 12);
                        break;
                    case 13:
                        day.set(Calendar.DATE, 13);
                        break;
                    case 14:
                        day.set(Calendar.DATE, 14);
                        break;
                    case 15:
                        day.set(Calendar.DATE, 15);
                        break;
                    case 16:
                        day.set(Calendar.DATE, 16);
                        break;
                    case 17:
                        day.set(Calendar.DATE, 17);
                        break;
                    case 18:
                        day.set(Calendar.DATE, 18);
                        break;
                    case 19:
                        day.set(Calendar.DATE, 19);
                        break;
                    case 20:
                        day.set(Calendar.DATE, 20);
                        break;
                    case 21:
                        day.set(Calendar.DATE, 21);
                        break;
                    case 22:
                        day.set(Calendar.DATE, 22);
                        break;
                    case 23:
                        day.set(Calendar.DATE, 23);
                        break;
                    case 24:
                        day.set(Calendar.DATE, 24);
                        break;
                    case 25:
                        day.set(Calendar.DATE, 25);
                        break;
                    case 26:
                        day.set(Calendar.DATE, 26);
                        break;
                    case 27:
                        day.set(Calendar.DATE, 27);
                        break;
                    case 28:
                        day.set(Calendar.DATE, 28);
                        break;
                    case 29:
                        day.set(Calendar.DATE, 29);
                        break;
                    case 30:
                        day.set(Calendar.DATE, 30);
                        break;
                    case 31:
                        day.set(Calendar.DATE, 31);
                        break;
                    case 32:
                        respuesta = 32;
                        System.out.println("termino");
                        break;
                    default:
                        respuesta = 0;
                        System.out.println("Solo puede elegir del 1 al 31");
                        break;
                }
            } while (respuesta == 0);
            do {
                dateMonths();
                respuesta = scan.nextInt();

                switch (respuesta) {
                    case 1:
                        day.set(Calendar.MONTH, 1);
                        break;
                    case 2:
                        day.set(Calendar.MONTH, 2);
                        break;
                    case 3:
                        day.set(Calendar.MONTH, 3);
                        break;
                    case 4:
                        day.set(Calendar.MONTH, 4);
                        break;
                    case 5:
                        day.set(Calendar.MONTH, 5);
                        break;
                    case 6:
                        day.set(Calendar.MONTH, 6);
                        break;
                    case 7:
                        day.set(Calendar.MONTH, 7);
                        break;
                    case 8:
                        day.set(Calendar.MONTH, 8);
                        break;
                    case 9:
                        day.set(Calendar.MONTH, 9);
                        break;
                    case 10:
                        day.set(Calendar.MONTH, 10);
                        break;
                    case 11:
                        day.set(Calendar.MONTH, 11);
                        break;
                    case 12:
                        day.set(Calendar.MONTH, 12);
                        break;
                    default:
                        respuesta = 0;
                        System.out.println("Solo puede elegir del 1 al 12");
                        break;
                }
            } while (respuesta == 0);
        }while(day.get(Calendar.MONTH)<dayToday.get(Calendar.MONTH));
        return day;
    }

   private static void showdates(){
       System.out.println("Marque el dia para viajar");
   }
   private static void dateMonths(){
       System.out.println("1-Enero  2-Febrero  3-Marzo  4-Abril" );
       System.out.println("5-Mayo  6-Junio  7-Julio  8-Agosto" );
       System.out.println("9-Septiembre  10-Octubre  11-Noviembre  12- Diciembre");
   }
   /* Calendar dia1 = Calendar.getInstance();
    int mes = dia1.get(Calendar.MONTH);
        listCalendario.add(dia1);
        System.out.println(mes);*/


}
