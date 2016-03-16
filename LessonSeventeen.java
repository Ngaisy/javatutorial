package javatutorial;

/**
 * Created by Shawn on 2/23/16.
 */
public class LessonSeventeen {

    public static void main(String[] args){

        Thread getTime = new GetTime20();

        Runnable getMail = new GetTheMail(10);

        Runnable getMailAgain = new GetTheMail(20);

        getTime.start();

        new Thread(getMail).start();
        new Thread(getMailAgain).start();
    }
}
