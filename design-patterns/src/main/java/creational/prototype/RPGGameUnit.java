package creational.prototype;

public class RPGGameUnit extends GameUnit
{
    private boolean hasGuns;

    @Override
    public void reset()
    {
        this.hasGuns = false;
    }

    public boolean hasGuns()
    {
        return hasGuns;
    }

    public void addGuns()
    {
        this.hasGuns = true;
    }
}
