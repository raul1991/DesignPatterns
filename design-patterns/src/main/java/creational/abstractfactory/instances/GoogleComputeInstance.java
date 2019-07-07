package creational.abstractfactory.instances;


import creational.abstractfactory.storage.Storage;

public class GoogleComputeInstance implements Instance
{
    private final Capacity capacity;

    public GoogleComputeInstance(Capacity capacity)
    {
        this.capacity = capacity;
    }

    public void attachStorage(Storage storage)
    {
        System.out.printf("Attached %s%n");

    }

    public void start()
    {

    }

    public void stop()
    {

    }
}
