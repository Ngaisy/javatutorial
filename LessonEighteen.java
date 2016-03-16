package javatutorial;
import java.util.concurrent.ScheduledThreadPoolExecutor;
// Used to schedule when certain events should be triggered
import static java.util.concurrent.TimeUnit.*;
//Used to tell Java what unit of time I want to use

/**
 * Created by Shawn on 2/26/16.
 */
public class LessonEighteen {
    public static  void main(String[] args){
        addThreadsToPool();
    }

    // It must be big enough to hold all potential Threads
    public static void addThreadsToPool() {
        ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(5);
        //Define number of Threads

        //Add a Thread and schedule its time to execute
        eventPool.scheduleAtFixedRate(new CheckSystemTime(), 0, 2, SECONDS);

        eventPool.scheduleAtFixedRate(new PerformSystemCheck("Mail"), 5, 5,SECONDS);

        eventPool.scheduleAtFixedRate(new PerformSystemCheck("Calendar"), 10, 10,SECONDS);

        // Thread.activeCount returns the number of threads running

        System.out.println("Number of Threads: " +Thread.activeCount());

        //There are only three defined Thread, but the system shows four active ones.
        //Create an array of Threads with enough spaces for all active Threads

        Thread[] listOfThreads = new Thread[Thread.activeCount()];

        // enumerate fills the Thread array with all active threads
        Thread.enumerate(listOfThreads);

        // cycle through all the active threads and print out their names
        for(Thread i : listOfThreads){
            System.out.println(i.getName());
        }
        //Get priority of all the threads(Priority is equal to the thread
        //that created the new thread. Top priority is 10, lowest prioity is 1
        for(Thread i: listOfThreads){
            System.out.println(i.getPriority());
        }

        //in order to set priority, threadName.setPriority can be used to set the priority

        //This allows the above threads to run for approximately 20 seconds
        try{
            Thread.sleep(20000);
        }
        catch(InterruptedException e)
        {}

        // shuts down all threads in the pool
        // eventPool.shutdown();

    }
}
