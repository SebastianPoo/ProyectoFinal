package FolderPlane;

import java.util.Calendar;

public class Gold extends Plane{

    private Calendar diaVuelo;

    public Gold(String name, int coste, double fuel, int maxPassenger,
                double kmXhs, double kmTraveled, engineType engineType) {
        super(name, coste, fuel, maxPassenger, kmXhs, kmTraveled, engineType,6000);
    }
    public Gold(String name, int day) {
        super(name, 300,3260,8,746,3700, engineType.MOTOR_A_REACCION, 6000);
        Calendar dia = Calendar.getInstance();
        dia.set(Calendar.DATE,day);
        this.diaVuelo = dia;
    }



    @Override
    public int catering(int coste) {
        System.out.println("Precio $500");
        return coste=coste+500;
    }

    @Override
    public int wifi(int coste) {
        return coste=coste+100;
    }

    @Override
    public int carry_on_bag(int coste) {
        return coste=coste+300;
    }

    @Override
    public int confort(int coste) {
        return coste=coste+400;
    }
}
