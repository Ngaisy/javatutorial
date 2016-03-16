package javatutorial;

/**
 * Created by Shawn on 2/18/16.
 */
public class LessonFourteen {

    public static void main(String[] args){
        Animals genericAnimal = new Animals();
        System.out.println(genericAnimal.getName());
        System.out.println(genericAnimal.favFood);

        Cats morris = new Cats("Morris", "Tuna", "Rubber Mouse");
        System.out.println();
        System.out.println(morris.getName());
        System.out.println(morris.favFood);
        System.out.println(morris.favToy);

        Animals tabby = new Cats("Tabby", "Salmon", "Ball");
        acceptAnimal(tabby);
    }

    public static void acceptAnimal(Animals randAnimal)
    {
        System.out.println();
        System.out.println(randAnimal.getName());
        System.out.println(randAnimal.favFood);
        System.out.println();

        randAnimal.walkAround();

        //Due "favToy" is not in Animal, so we need make randAnimal
        //temporarily a cat.
        Cats tempCat = (Cats) randAnimal;
        System.out.println(tempCat.favToy);

        //To check if randAnimal is a cat or Animals
        if(randAnimal instanceof Animals)
        {
            System.out.println(randAnimal.getName() + " is a Cat");
        }
    }
}
