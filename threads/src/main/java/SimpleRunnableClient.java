public class SimpleRunnableClient
{
    private volatile static boolean shouldKeepRunning;
    private static int number;

    public void startThread(String name)
    {
        new Thread(new RunnableThread(), name).start();
    }

    private class RunnableThread implements Runnable
    {
        @Override
        public void run()
        {
            while(!shouldKeepRunning)
            {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        new SimpleRunnableClient().startThread("DummyRunnableThread");
        shouldKeepRunning = true;
        number = 42;
    }
}
