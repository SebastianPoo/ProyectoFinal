package FolderPlane;

import java.util.Calendar;

public class Silver extends Plane{
    private int planeType = 4000;
    private Calendar diaVuelo;

    public Silver(String nombre, int coste, double fuel, int maxPassenger,
                  double kmXhs, double kmTraveled, TipoMotor tipoMotor) {
        super(nombre, coste, fuel, maxPassenger, kmXhs, kmTraveled, tipoMotor);
    }


    public Silver(String nombre, int day) {
        super(nombre, 150,1141,4,694,2084,TipoMotor.MOTOR_A_HELICE);
        Calendar dia = Calendar.getInstance();
        dia.set(Calendar.DAY_OF_WEEK,day);
        this.diaVuelo = dia;
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
