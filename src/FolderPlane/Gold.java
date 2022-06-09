package FolderPlane;

public class Gold extends Plane{
    private int planeType = 6000;               //todo -- para que era este atributo??

    public Gold(String nombre, int coste, double fuel, int maxPassenger, double kmXhs, double kmTraveled, TipoMotor tipoMotor) {
        super(nombre, coste, fuel, maxPassenger, kmXhs, kmTraveled, tipoMotor);
    }
    public Gold() {
        super("Gold01", 300,3260,8,746,3700,TipoMotor.MOTOR_A_REACCION);
    }

    public Gold() {
    }

    @Override
    public int catering(int costo) {
        System.out.println("Precio $500");
        return costo=costo+500;
    }

    @Override
    public int wifi(int costo) {
        return costo=costo+100;
    }

    @Override
    public int carry_on_bag(int costo) {
        return costo=costo+300;
    }

    @Override
    public int confort(int costo) {
        return costo=costo+400;
    }
}
