package javatutorial;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Shawn on 2/26/16.
 */
public class PerformSystemCheck implements Runnable{

    private String checkWhat;

    // Creates a lock for your method

    ReentrantLock lock = new ReentrantLock();

    public PerformSystemCheck(String checkWhat){
        this.checkWhat = checkWhat;
    }

    //By putting synchronized before a method, you make sure only one
    //thread at a time will be executed. However, synchronizing slows
    //down Java, so it should only be used with necesary.

    /* synchronized */ public void run(){
        lock.lock();
        //this locks down the method just like synchronized

        System.out.println("Checking " + this.checkWhat);

        // unlike the method like synchronized

        lock.unlock();
    }

}
