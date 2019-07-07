package creational.abstractfactory;

import creational.abstractfactory.factories.AwsResourceFactory;
import creational.abstractfactory.instances.Instance;
import creational.abstractfactory.storage.Storage;

public class Client
{
    public static void main(String[] args)
    {
        final AwsResourceFactory awsResourceFactory = new AwsResourceFactory();
        final Instance instance = awsResourceFactory.createInstance(Instance.Capacity.large);
        final Storage storage = awsResourceFactory.createStorage(20408);
        instance.attachStorage(storage);
        instance.start();
        instance.stop();
    }
}
