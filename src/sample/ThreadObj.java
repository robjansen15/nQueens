package sample;

/**
 * Created by terrabyte on 1/29/2017.
 */
public class ThreadObj extends Thread{

    public ThreadObj(int i){
        threadName = "Thread"+i;
        controller = new Controller(i);
    }

    public void run(){
        System.out.println("Running " + threadName);
        controller.Run();
    }

    public void start () {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName );
            t.start();
        }
    }

    private Thread t;
    private String threadName;
    private Controller controller;
}
