package FolderPlane;

import java.util.Calendar;

public class Gold extends Plane{
    private int planeType = 6000;               //todo -- para que era este atributo??
    private Calendar diaVuelo;

    public Gold(String nombre, int coste, double fuel, int maxPassenger,
                double kmXhs, double kmTraveled, TipoMotor tipoMotor) {
        super(nombre, coste, fuel, maxPassenger, kmXhs, kmTraveled, tipoMotor);
    }
    public Gold(String nombre, int day) {
        super(nombre, 300,3260,8,746,3700,TipoMotor.MOTOR_A_REACCION);
        Calendar dia = Calendar.getInstance();
        dia.set(Calendar.DAY_OF_WEEK,day);
        this.diaVuelo = dia;
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
