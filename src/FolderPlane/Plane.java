package FolderPlane;

public abstract class Plane implements Service {
    private String nombre;                   //todo --Ver como traer el nombre de la variable al ser instanciada
    private int coste;
    private double fuel;
    private int maxPassenger;
    private double kmXhs;
    private double kmTraveled;
    private  TipoMotor tipoMotor;

    public Plane (){
    }

    public int getCoste() {
        return coste;
    }

    public String getNombre() {
        return nombre;
    }

    public Plane(String nombre, int coste, double fuel, int maxPassenger, double kmXhs, double kmTraveled, TipoMotor tipoMotor) {
        this.nombre = nombre;
        this.coste = coste;
        this.fuel = fuel;
        this.maxPassenger = maxPassenger;
        this.kmXhs = kmXhs;
        this.kmTraveled = kmTraveled;
        this.tipoMotor = tipoMotor;
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
