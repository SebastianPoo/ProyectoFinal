package FolderPlane;

public class Silver extends Plane{
    private int planeType = 4000;

    public Silver(int coste, double fuel, int maxPassenger, double kmXhs, double kmTraveled, TipoMotor tipoMotor) {
        super(coste, fuel, maxPassenger, kmXhs, kmTraveled, tipoMotor);
    }

    @Override
    public int catering(int costo) {
        System.out.println("Precio $250");
        return costo=costo+250;
    }

    @Override
    public int wifi(int costo) {
        System.out.println("Precio $25");
        return costo=costo+25;
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
