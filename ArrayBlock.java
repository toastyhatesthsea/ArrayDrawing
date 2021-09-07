import processing.core.PApplet;
import java.util.Random;

/**
 * Imported the Processing libraries into an IDE
 */
public class ArrayBlock extends PApplet
{
    int[] anArray;
    int widthOfWindow = 900;
    int heightOfWindow = 600;
    float widthOfRect;
    int sizeOfArray;

    public void settings()
    {
        size(widthOfWindow, heightOfWindow);
    }


    public void setup()
    {
        widthOfWindow = 900;
        sizeOfArray = 200;
        widthOfRect = (float) widthOfWindow / (sizeOfArray + 5);
        background(126, 239, 247);
        anArray = new int[sizeOfArray];
        createArray();
    }

    public void draw()
    {
        drawArray();
    }

    public static void main(String[] args)
    {
        PApplet.main("ArrayBlock");
    }

    public void createArray()
    {
        Random aRan = new Random();

        for (int i = 0; i < 200; i++)
        {
            anArray[i] = aRan.nextInt(200);
        }
    }

    public void drawArray()
    {
        float xLocation = 10;
        float yLocation = 10;
        float yLocationBuffer = 50;

        for (int anInt : anArray)
        {
            fill(anInt);
            yLocation = this.heightOfWindow - anInt;
            rect(xLocation, yLocation - yLocationBuffer, this.widthOfRect, anInt);
            xLocation += widthOfRect;
        }
    }
}
