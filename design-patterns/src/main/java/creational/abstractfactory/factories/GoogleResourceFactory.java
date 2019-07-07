package creational.abstractfactory.factories;


import creational.abstractfactory.instances.GoogleComputeInstance;
import creational.abstractfactory.instances.Instance;
import creational.abstractfactory.storage.GoogleComputeStorage;
import creational.abstractfactory.storage.Storage;

public class GoogleResourceFactory implements ResourceFactory
{
    public Instance createInstance(Instance.Capacity capacity)
    {
        return new GoogleComputeInstance(capacity);
    }

    public Storage createStorage(int capMib)
    {
        return new GoogleComputeStorage(capMib);
    }
}
