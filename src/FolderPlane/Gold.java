package FolderPlane;

public class Gold extends Plane{

    public Gold() {
        super(300,3260,8,746,3700,TipoMotor.MOTOR_A_REACCION);
    }

    public Gold(int coste, double fuel, int maxPassenger, double kmXhs, double kmTraveled, TipoMotor tipoMotor) {
        super(coste, fuel, maxPassenger, kmXhs, kmTraveled, tipoMotor);
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
