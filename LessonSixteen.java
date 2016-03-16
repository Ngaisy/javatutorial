package javatutorial;

/**
 * Created by Shawn on 2/23/16.
 */
public class LessonSixteen {
    public static void main(String[] args){

        Object superCar = new Vehicle(4,3);

        System.out.println(((Vehicle)superCar).getSpeed());

        Vehicle superCar2 = new Vehicle(4,3);

        System.out.println(superCar2.getSpeed());
        // Conclusion: Object make Vehicle class, but the object can not access the info in Vehicle

        System.out.println(superCar.equals(superCar2));
        //They are not the same since one of them is object

        System.out.println(superCar.hashCode());
        System.out.println(superCar2.hashCode());
        //hashCode can show they are different

        System.out.println(superCar.getClass());
        System.out.println(superCar.getClass().getName());
        //Class of the superCar is still 'Vehicle', but it cannot access the built-in method insides

        if(superCar.getClass() == superCar2.getClass()){
            System.out.println("The Same");
        }

        System.out.println(superCar.getClass().getSuperclass());
        //SuperClass is the astract class

        System.out.println(superCar.toString());

        int randNum = 100;
        System.out.println(Integer.toString(randNum));

        superCar2.setWheels(6);
        Vehicle superCar3 = (Vehicle)superCar2.clone();

        System.out.println(superCar2.getWheels());
        System.out.println(superCar3.getWheels());
        //The results are the same, but they have different hashcode

        System.out.println("Hasscode of superCar2 & superCar3 are " + superCar2.hashCode() + " and " + superCar3.hashCode());
    }
}
