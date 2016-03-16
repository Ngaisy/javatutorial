package javatutorial;

/**
 * Created by Shawn on 2/18/16.
 */
public class Cats extends Animals
{
    public String favToy = "Yarn";
    public void playWith()
    {
        System.out.println("Yeah" + favToy);
    }

    public void walkAround()
    {
        System.out.println(this.getName() + " stalks around");
    }

    public String getToy()
    {
        return this.favToy;
    }

    public Cats()
    {

    }

    public Cats(String name, String favFood, String favToy)
    {
        super(name, favFood);
        //There is no favToy in the Animals class, so we create one.
        this.favToy =favToy;
    }

}
