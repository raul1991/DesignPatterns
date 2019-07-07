public class Deadlock
{
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args)
    {
        new Thread(() -> {
            synchronized (lock1)
            {
                System.out.println("Holding lock 1");
                System.out.println("Waiting for lock 2");
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                synchronized (lock2)
                {
                    System.out.println("Holding lock 2 & 1");
                }
            }
        }, "Do this").start();


        new Thread(() -> {
            synchronized (lock2)
            {
                System.out.println("Holding lock 2");
                System.out.println("Waiting for lock 1");
                try
                {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                synchronized (lock1)
                {
                    System.out.println("Holding lock 2 & 1");
                }
            }
        }, "Do that").start();
    }
}
