package FolderPlane;

import java.io.Serializable;

public abstract class Plane implements Service, Serializable {
    private String nombre;
    private int coste;
    private double fuel;
    private int maxPassenger;
    private double kmXhs;
    private double kmTraveled;
    private engineType engineType;



    private Plane (){
    }



    public int getCoste() {
        return coste;
    }

    public String getNombre() {
        return nombre;
    }

    public Plane(String nombre, int coste, double fuel, int maxPassenger,
                 double kmXhs, double kmTraveled, engineType engineType) {
        this.nombre = nombre;
        this.coste = coste;
        this.fuel = fuel;
        this.maxPassenger = maxPassenger;
        this.kmXhs = kmXhs;
        this.kmTraveled = kmTraveled;
        this.engineType = engineType;
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
    public enum engineType {
        MOTOR_A_REACCION,
        MOTOR_A_HELICE,
        MOTOR_DE_PISTONES,
    }

    @Override
    public String toString() {      // TODO: 6/17/2022 correccion salto de linea
        return "Plane > " + "\n" +
                " nombre:       " + nombre + "\n" +
                " coste:        " + coste +  "\n" +
                " fuel:         " + fuel +     "\n" +
                " maxPassenger: " + maxPassenger +  "\n" +
                " kmXhs:        " + kmXhs +  "\n" +
                " kmTraveled:   " + kmTraveled +  "\n" +
                " engineType:    " + engineType +  "\n" + "\n";
    }

}
