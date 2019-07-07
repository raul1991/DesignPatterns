package creational.abstractfactory.factories;

import creational.abstractfactory.instances.Instance;
import creational.abstractfactory.storage.Storage;

public interface ResourceFactory
{
    Instance createInstance(Instance.Capacity capacity);
    Storage createStorage(int capMib);
}
