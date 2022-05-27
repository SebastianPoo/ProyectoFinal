package FolderPlane;

import java.util.LinkedList;

public class Gestion extends Plane {

    public Gestion(int coste, double fuel, int maxPassenger, double kmXhs, double kmTraveled, TipoMotor tipoMotor) {
        super(coste, fuel, maxPassenger, kmXhs, kmTraveled, tipoMotor);
    }


    public static LinkedList<Plane> add_a_Flota(){
        LinkedList<Plane> flota = new LinkedList<>();

        Bronze boeing123 = new Bronze();
        Silver eclipse550 = new Silver();
        Gold cessna550 = new Gold();

        flota.add(boeing123);
        flota.add(eclipse550);
        flota.add(cessna550);

        return flota;
    }

    @Override
    public void catering() {

    }

    @Override
    public void wifi() {

    }

    @Override
    public void landingStrip() {

    }

    @Override
    public void sevice() {

    }

    @Override
    public void carry_on_bag() {

    }

    @Override
    public void confort() {

    }
}
