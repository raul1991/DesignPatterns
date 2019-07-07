package creational.abstractfactory.factories;


import creational.abstractfactory.instances.Ec2Instance;
import creational.abstractfactory.instances.Instance;
import creational.abstractfactory.storage.S3Storage;
import creational.abstractfactory.storage.Storage;

public class AwsResourceFactory implements ResourceFactory
{
    public Instance createInstance(Instance.Capacity capacity)
    {
        return new Ec2Instance(capacity);
    }

    public Storage createStorage(int capMib)
    {
        return new S3Storage(capMib);
    }
}
