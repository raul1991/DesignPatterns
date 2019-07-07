import java.util.Random;

public class SharedVariables
{
    private static int number = 42;
    static final Random random = new Random();

    public static void main(String[] args)
    {
        System.out.printf("Initial value %d%n", number);
        startUpdateThreads(3);
    }

    private static void startUpdateThreads(int expectedNofThreads)
    {
        for (int j = 0; j < expectedNofThreads; j++)
        {
            new Thread(new UpdateThread(), String.format("[UpdateThread %d]", j)).start();
        }
    }

    public static int getNumber()
    {
        System.out.println(String.format("[%s] Read Value is %d", Thread.currentThread().getName(), number));
        return number;
    }

    public synchronized static void setNumber(int number)
    {
        System.out.println(String.format("[%s] Changing value from %d to %d", Thread.currentThread().getName(), SharedVariables.number, number));
        SharedVariables.number = number;
    }

    private static class UpdateThread implements Runnable
    {
        @Override
        public void run()
        {
            doUpdate();
        }

        public void doUpdate()
        {
            // solution : use synchronized(SharedVariables.class) instead of synchronized(this)
            synchronized (this)
            {
                getNumber();
                setNumber(random.nextInt(10000));
            }
        }
    }
}
