package FolderPlane;

import java.util.Calendar;

public class Bronze extends Plane{

    private Integer planeType = 500;
    private Calendar diaVuelo;

    public Bronze(String nombre, int coste, double fuel, int maxPassenger,
                  double kmXhs, double kmTraveled, TipoMotor tipoMotor) {
        super( nombre, coste, fuel, maxPassenger, kmXhs, kmTraveled, tipoMotor);
    }

    public Bronze(String nombre,int day) {
        super(nombre ,150, 19325.44, 60, 876, 3440, TipoMotor.MOTOR_DE_PISTONES);
        Calendar dia = Calendar.getInstance();
        dia.set(Calendar.DATE,day);
        this.diaVuelo = dia;
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
