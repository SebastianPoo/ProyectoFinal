package FolderPlane;



public class Gold extends Plane{

    public Gold(String name, int coste, double fuel, int maxPassenger,
                double kmXhs, double kmTraveled, engineType engineType) {
        super(name, coste, fuel, maxPassenger, kmXhs, kmTraveled, engineType,6000);
    }
    public Gold(String name) {
        super(name, 300,3260,8,746,3700,
                engineType.MOTOR_A_REACCION, 6000);

    }



    @Override
    public int catering(int coste) {
        System.out.println("Cateting: $500");
        return coste=coste+500;
    }

    @Override
    public int wifi(int coste) {
        System.out.println("Wifi: $100");
        return coste=coste+100;
    }

    @Override
    public int carry_on_bag(int coste) {
        System.out.println("Carry_on_bag:  $300");
        return coste=coste+300;
    }

    @Override
    public int confort(int coste) {
        System.out.println("Confort: 400");
        return coste=coste+400;
    }
}
