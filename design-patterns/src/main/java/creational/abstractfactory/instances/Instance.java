package creational.abstractfactory.instances;


import creational.abstractfactory.storage.Storage;

public interface Instance
{
    enum Capacity{micro, small, large}
    void attachStorage(Storage storage);
    void start();
    void stop();
}
