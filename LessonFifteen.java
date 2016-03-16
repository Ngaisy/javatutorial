package javatutorial;

/**
 * Created by Shawn on 2/18/16.
 */
public class LessonFifteen {

    public static void main(String[] args) {
        Vehicle car = new Vehicle(4, 100.00);
        System.out.println("Car Max Speed: " + car.getSpeed());
        System.out.println("Num of Wheels: " + car.getWheels());

        //Using methods from abstract method Crashable
        car.setCarStrength(10);
        System.out.println("Car Strength: "+car.getCarStrength());
    }
}
