package FolderPlane;

public class Bronze extends Plane{
    private int planeType = 3000;

    public Bronze(int coste, double fuel, int maxPassenger, double kmXhs, double kmTraveled, TipoMotor tipoMotor) {
        super(coste, fuel, maxPassenger, kmXhs, kmTraveled, tipoMotor);
    }

    public Bronze() {
    }

    @Override
    public int catering(int costo) {
        System.out.println("servicio no disponible");
        return costo;
    }

    @Override
    public int wifi(int costo) {
        System.out.println("servicio no disponible");
        return costo;
    }

    @Override
    public int carry_on_bag(int costo) {
        System.out.println("precio $300");
        return costo=costo+300;
    }

    @Override
    public int confort(int costo) {
        System.out.println("Precio $200");
        return costo=costo+200;
    }
}
