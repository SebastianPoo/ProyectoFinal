package FolderPlane;

public abstract class Plane implements Service {
    private int coste;
    private double fuel;
    private int maxPassenger;
    private double kmXhs;
    private double kmTraveled;
    private  TipoMotor tipoMotor;




    public Plane (){
    }

    public Plane(int coste, double fuel, int maxPassenger, double kmXhs, double kmTraveled, TipoMotor tipoMotor) {
        this.coste = coste;
        this.fuel = fuel;
        this.maxPassenger = maxPassenger;
        this.kmXhs = kmXhs;
        this.kmTraveled = kmTraveled;
        this.tipoMotor = tipoMotor;
    }
    public int getCoste() {
        return coste;
    }

    public double getFuel() {
        return fuel;
    }

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public double getKmXhs() {
        return kmXhs;
    }

    public double getKmTraveled() {
        return kmTraveled;
    }

    public TipoMotor getTipoMotor() {
        return tipoMotor;
    }

    public enum TipoMotor {
        MOTOR_A_REACCION,
        MOTOR_A_HELICE,
        MOTOR_DE_PISTONES,
    }
    @Override
    public String toString() {
        return "Plane{" +
                "coste=" + coste +
                ", fuel=" + fuel +
                ", maxPassenger=" + maxPassenger +
                ", kmXhs=" + kmXhs +
                ", kmTraveled=" + kmTraveled +
                ", tipoMotor=" + tipoMotor +
                '}';
    }
}
