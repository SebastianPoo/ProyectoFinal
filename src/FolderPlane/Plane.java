package FolderPlane;

public abstract class Plane implements Service {
    private int coste;
    private double fuel;
    private int maxPassenger;
    private double kmXhs;
    private double kmTraveled;
    private  TipoMotor tipoMotor;


    public enum TipoMotor{
        MOTOR_A_REACCION,
        MOTOR_A_HELICE,
        MOTOR_DE_PISTONES,
    }

    public Plane(int coste, double fuel, int maxPassenger, double kmXhs, double kmTraveled, TipoMotor tipoMotor) {
        this.coste = coste;
        this.fuel = fuel;
        this.maxPassenger = maxPassenger;
        this.kmXhs = kmXhs;
        this.kmTraveled = kmTraveled;
        this.tipoMotor = tipoMotor;
    }
}
