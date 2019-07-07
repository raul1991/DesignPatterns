package creational.factory;

public abstract class MessageCreator
{
    public Message getMessage()
    {
        final Message message = createMessage();
        //do something with the message
        return message;
    }

    abstract Message createMessage();
}
