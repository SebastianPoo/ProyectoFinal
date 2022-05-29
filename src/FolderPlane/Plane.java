package FolderPlane;

public abstract class Plane implements Service {
    private int coste;
    private double fuel;
    private int maxPassenger;
    private double kmXhs;
    private double kmTraveled;
    private  MotorType tipoMotor;



    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getMaxPassenger() {
        return maxPassenger;
    }

    public void setMaxPassenger(int maxPassenger) {
        this.maxPassenger = maxPassenger;
    }

    public double getKmXhs() {
        return kmXhs;
    }

    public void setKmXhs(double kmXhs) {
        this.kmXhs = kmXhs;
    }

    public double getKmTraveled() {
        return kmTraveled;
    }

    public void setKmTraveled(double kmTraveled) {
        this.kmTraveled = kmTraveled;
    }

    public MotorType getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(MotorType tipoMotor) {
        this.tipoMotor = tipoMotor;
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
