package FolderPlane;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Gold extends Plane{
    private int planeType = 6000;



    public Gold(int coste, double fuel, int maxPassenger, double kmXhs, double kmTraveled, TipoMotor tipoMotor) {
        super(coste, fuel, maxPassenger, kmXhs, kmTraveled, tipoMotor);

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
