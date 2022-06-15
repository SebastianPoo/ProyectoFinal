package FolderPlane;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Plane implements Service, Serializable {
    private String nombre;
    private int coste;
    private double fuel;
    private int maxPassenger;
    private double kmXhs;
    private double kmTraveled;
    private  TipoMotor tipoMotor;
    public List<Calendar> listPlane ;



    private Plane (){
    }



    public int getCoste() {
        return coste;
    }

    public String getNombre() {
        return nombre;
    }

    public Plane(String nombre, int coste, double fuel, int maxPassenger,
                 double kmXhs, double kmTraveled, TipoMotor tipoMotor) {
        this.nombre = nombre;
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

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public void setMaxPassenger(int maxPassenger) {
        this.maxPassenger = maxPassenger;
    }

    public boolean vacantSeat (int seats_to_be_used){
        int vacanS = getMaxPassenger();
        if (vacanS > seats_to_be_used){
            vacanS -= seats_to_be_used;
            setMaxPassenger(vacanS);
            return true;
        }
        return false;
    }
    public enum TipoMotor {
        MOTOR_A_REACCION,
        MOTOR_A_HELICE,
        MOTOR_DE_PISTONES,
    }

    @Override
    public String toString() {
        return "Plane{" +
                "nombre='" + nombre + '\'' +
                ", coste=" + coste +  '\'' +
                ", fuel=" + fuel +     '\'' +
                ", maxPassenger=" + maxPassenger +  '\'' +
                ", kmXhs=" + kmXhs +  '\'' +
                ", kmTraveled=" + kmTraveled +  '\'' +
                ", tipoMotor=" + tipoMotor +  '\'' +
                '}';
    }

}
