/**
 * In this example we took two concepts
 * 1. Sharing ThreadLocal variable
 *
 * In this approach we saw that every thread that was created had its own separate copy of the counter variable even
 * though we used the same instance of the enclosing class ({@link ThreadLocal}
 *
 * 2. Sharing normal variables
 *
 * In this approach we saw that a common variable was being shared amongst three and the response showed that the value
 * fluctuated between 0 - 3 and the sequence of the output statements were always different. However, using a join
 * statement did make the output sequential.
 *
 * The reason that the values fluctuated is because increment or decrement operation is a multi stage operation and
 * without a synchronized block the operation does not execute sequentially leading to a lost update.
 * Some may argue that using a volatile variable is necessary here however that is not the case. Even using a volatile
 * keyword next to the sharedCounter variable did not achieve what we wanted. volatile can just ensure that the values
 * are being written/fetched from the main memory and not from the thread cache.
 *
 */
public class ThreadLocalExample
{
    private ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 42);

    private volatile int sharedCounter;

    public void increment()
    {
        this.counter.set(counter.get() + 1);
        synchronized (this)
        {
            System.out.printf("[Thread %s] Changed sharedCounter from %d to %d%n", Thread.currentThread().getName(),
                    sharedCounter, ++this.sharedCounter);
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        ThreadLocalExample example = new ThreadLocalExample();
        example.startIncrementing(example);
    }

    private void startIncrementing(ThreadLocalExample example) throws InterruptedException
    {
        for (int i = 0; i < 3; i++)
        {
            final Thread thread = new Thread(new IncrementingJob(example));
            thread.start();
            // use the below line to make this execution predictable.
//            thread.join();

        }
    }

    public class IncrementingJob implements Runnable
    {

        private final ThreadLocalExample example;

        public IncrementingJob(ThreadLocalExample example)
        {
            this.example = example;
        }

        @Override
        public void run()
        {
//            synchronized (this)
//            {
            example.increment();
//            }

        }
    }
}