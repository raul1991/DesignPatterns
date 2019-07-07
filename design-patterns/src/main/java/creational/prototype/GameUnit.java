package creational.prototype;

public abstract class GameUnit implements Cloneable
{
    private String characterName = "sherlock";

    public String name(String newName)
    {
        characterName = newName;
        return characterName;
    }

    @Override
    public GameUnit clone() throws CloneNotSupportedException
    {
        GameUnit gameUnit = (GameUnit) super.clone();
        characterName = "mycroft";
        gameUnit.reset();
        return gameUnit;
    }

    public abstract void reset();
}
