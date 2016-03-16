package javatutorial;

/**
 * Created by Shawn on 2/22/16.
 */
public abstract class Crashable {

    boolean carDrivable = true;

    public void youcrashed(){
        carDrivable = false;
    }

    public abstract void setCarStrength(int carStrength);

    public abstract int getCarStrength();


}
