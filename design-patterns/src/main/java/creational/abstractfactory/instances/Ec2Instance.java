package creational.abstractfactory.instances;


import creational.abstractfactory.storage.Storage;

public class Ec2Instance implements Instance
{
    private final Capacity capacity;

    public Ec2Instance(Capacity capacity)
    {
        this.capacity = capacity;
    }

    public void attachStorage(Storage storage)
    {
        System.out.println("Ec2Instance.attachStorage");
    }

    public void start()
    {
        System.out.println("Ec2 instance started");
    }

    public void stop()
    {
        System.out.println("Ec2 instance stopped");
    }
}
