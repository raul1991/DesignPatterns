package creational.prototype;

public class DummyGameUnit extends GameUnit
{
    private boolean isDumb = true;

    public void removeDumbness()
    {
        this.isDumb = false;
    }

    public void reset()
    {
        this.isDumb = true;
    }
}
