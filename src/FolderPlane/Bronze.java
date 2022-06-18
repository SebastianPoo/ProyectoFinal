package FolderPlane;

import java.util.Calendar;

public class Bronze extends Plane{

    private Integer planeType = 500;
    private Calendar diaVuelo;

    public Bronze(String name, int coste, double fuel, int maxPassenger,
                  double kmXhs, double kmTraveled, engineType engineType) {
        super( name, coste, fuel, maxPassenger, kmXhs, kmTraveled, engineType);
    }



    public Bronze(String name,int day) {
        super(name ,150, 19325.44, 60, 876, 3440, engineType.MOTOR_DE_PISTONES);
        Calendar dia = Calendar.getInstance();
        dia.set(Calendar.DATE,day);
        this.diaVuelo = dia;
    }


    @Override
    public int catering(int coste) {
        System.out.println("service not available");
        return coste;
    }

    @Override
    public int wifi(int coste) {
        System.out.println("service not available");
        return coste;
    }

    @Override
    public int carry_on_bag(int coste) {
        System.out.println("Coste $300");
        return coste=coste+300;
    }

    @Override
    public int confort(int coste) {
        System.out.println("Precio $200");
        return coste=coste+200;
    }

}
