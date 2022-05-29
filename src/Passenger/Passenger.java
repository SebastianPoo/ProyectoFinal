package Passenger;

public class Passenger {
    private String name;
    private String LastName;
    private String Dni;
    private Integer age;

    public Passenger() {
    }

    public Passenger(String name, String lastName, String dni, Integer age) {
        this.name = name;
        LastName = lastName;
        Dni = dni;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Dni='" + Dni + '\'' +
                ", age=" + age +
                '}';
    }
}
