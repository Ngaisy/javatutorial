package javatutorial;

/**
 * Created by Shawn on 3/15/16.
 */
public class Cat extends Animals {
    public static void main(String[] args){
        Animals cat = new Animals("Cat", "Fish");
        cat.walkAround();
        cat.eatStuff();
        cat.getName();
    }

}
