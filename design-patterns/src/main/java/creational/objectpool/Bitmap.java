package creational.objectpool;


import javafx.geometry.Point2D;

public class Bitmap implements Image
{
    private Point2D location;
    private String name;

    public Bitmap(String name)
    {
        this.name = name;
    }

    @Override
    public void draw()
    {

    }

    @Override
    public Point2D getLocation()
    {
        return null;
    }

    @Override
    public void setLocation(Point2D location)
    {

    }

    @Override
    public void reset()
    {

    }
}
