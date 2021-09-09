import java.awt.*;

public class Block
{

    float xLocation;
    float yLocation;
    float height;
    float width;
    Color aColor;

    public Block(float xLocation, float yLocation, float height, float width, Color aColor)
    {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.height = height;
        this.width = width;
        this.aColor = aColor;

    }

    public float getxLocation()
    {
        return xLocation;
    }

    public void setxLocation(float xLocation)
    {
        this.xLocation = xLocation;
    }

    public float getyLocation()
    {
        return yLocation;
    }

    public void setyLocation(float yLocation)
    {
        this.yLocation = yLocation;
    }

    public float getHeight()
    {
        return height;
    }

    public void setHeight(float height)
    {
        this.height = height;
    }

    public float getWidth()
    {
        return width;
    }

    public void setWidth(float width)
    {
        this.width = width;
    }

    public Color getaColor()
    {
        return aColor;
    }

    public void setaColor(Color aColor)
    {
        this.aColor = aColor;
    }
}
