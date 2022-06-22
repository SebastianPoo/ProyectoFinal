package FolderPlane;

import java.util.Calendar;

public class Silver extends Plane{
    private Calendar diaVuelo;

    public Silver(String nombre, int coste, double fuel, int maxPassenger,
                  double kmXhs, double kmTraveled, engineType engineType) {
        super(nombre, coste, fuel, maxPassenger, kmXhs, kmTraveled, engineType,4000);
    }


    public Silver(String nombre, int day) {
        super(nombre, 200,1141,4,694,2084, engineType.MOTOR_A_HELICE,4000);
        Calendar dia = Calendar.getInstance();
        dia.set(Calendar.DATE,day);
        this.diaVuelo = dia;
    }


    @Override
    public int catering(int costo) {
        System.out.println("Catering: Precio $250");
        return costo=costo+250;
    }

    @Override
    public int wifi(int costo) {
        System.out.println("Wifi: Precio $25");
        return costo=costo+25;
    }

    @Override
    public int carry_on_bag(int costo) {
        System.out.println("Carry_on_bag: precio $300");
        return costo=costo+300;
    }

    @Override
    public int confort(int costo) {
        System.out.println("Confort: Precio $200");
        return costo=costo+200;
    }
}
