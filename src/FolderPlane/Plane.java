package FolderPlane;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.spi.CalendarDataProvider;

public abstract class Plane implements Service {
    private String nombre;                   //todo --Ver como traer el nombre de la variable al ser instanciada
    private int coste;
    private double fuel;
    private int maxPassenger;
    private double kmXhs;
    private double kmTraveled;
    private  TipoMotor tipoMotor;
    public List<Calendar> listPlane ;

    public Plane (){
    }
    public Plane( int coste, double fuel, int maxPassenger, double kmXhs, double kmTraveled, TipoMotor tipoMotor) {

        this.coste = coste;
        this.fuel = fuel;
        this.maxPassenger = maxPassenger;
        this.kmXhs = kmXhs;
        this.kmTraveled = kmTraveled;
        this.tipoMotor = tipoMotor;
        this.listPlane = new ArrayList<>();
    }

    public List<Calendar> getListPlane() {
        return listPlane;
    }

    public void setList(Calendar calendar) {

        listPlane.add(calendar);
        this.listPlane = listPlane;
    }

    public int getCoste() {
        return coste;
    }

    public String getNombre() {
        return nombre;
    }
    public enum TipoMotor {
        MOTOR_A_REACCION,
        MOTOR_A_HELICE,
        MOTOR_DE_PISTONES,
    }
    public void getDates(){
        System.out.println("Fechas ocupadas: ");
        for (Calendar calendar1: listPlane) {
            System.out.println(calendar1.get(Calendar.DATE)+"/"+calendar1.get(Calendar.MONTH)+"/"+calendar1.get(Calendar.YEAR));
        }
    }

    @Override
    public String toString() {
        return "Plane{" +
                ", coste=" + coste +  '\'' +
                ", fuel=" + fuel +     '\'' +
                ", maxPassenger=" + maxPassenger +  '\'' +
                ", kmXhs=" + kmXhs +  '\'' +
                ", kmTraveled=" + kmTraveled +  '\'' +
                ", tipoMotor=" + tipoMotor +  '\'' +
                '}';
    }

}
