package leetcode.others;

public class Singleton {
    private volatile static Singleton instance;
    private static Object lock;

    private Singleton() {

    }
    /*
        if a thread has been got a new instance,
        and there are other threads wait in synchronized block, when one of them get the lock
        it will go into the folloing new instance step, so we should check the instance is null or not
        then do new instance or not.
     */
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized(lock) { // other thread wait here
                if(instance == null) {
                    return instance = new Singleton();
                }
            }

        }
        return instance;
    }
}
