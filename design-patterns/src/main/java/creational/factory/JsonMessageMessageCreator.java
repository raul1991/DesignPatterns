package creational.factory;

public class JsonMessageMessageCreator extends MessageCreator
{
    Message createMessage()
    {
        return new JsonMessage();
    }
}
