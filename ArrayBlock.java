import processing.core.PApplet;

import java.awt.*;
import java.lang.reflect.Array;
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
    int currentArrayIndex;
    float xLocation;
    float yLocation;
    float yLocationBuffer;
    boolean sorted;
    boolean drawn;
    BlockManager aBlockManager;

    public void settings()
    {
        size(widthOfWindow, heightOfWindow);
    }


    public void setup()
    {
        sorted = false;
        drawn = false;
        yLocationBuffer = 50;
        currentArrayIndex = 0;
        frameRate(60);
        widthOfWindow = 900;
        sizeOfArray = 200;
        widthOfRect = (float) widthOfWindow / (sizeOfArray);
        background(126, 239, 247);

        aBlockManager = new BlockManager(sizeOfArray, widthOfWindow, heightOfWindow);

    }


    public static void main(String[] args)
    {
        PApplet.main("ArrayBlock");
    }

    public void createArray()
    {

    }

    public boolean drawArray()
    {
        return drawn;
    }

    public void draw()
    {
        if (aBlockManager.currentIndex < sizeOfArray && !this.drawArray())
        {
            aBlockManager.drawCurrentBlock(this);
        }
        else
        {
            drawn = true;
            aBlockManager.reset();
        }

        if (drawn && !sorted)
        {

        }


        aBlockManager.update();
    }



    //TODO Fix sortArray() to work with BlockManager class
    public void sortArray()
    {
        int smallest = Integer.MAX_VALUE;
        xLocation = widthOfRect * currentArrayIndex + 10;

        for (int i = currentArrayIndex + 1; i < sizeOfArray; i++)
        {
            int currentElement = this.anArray[i];
            int firstElement = this.anArray[currentArrayIndex];


            if (firstElement >= currentElement)
            {
                this.anArray[currentArrayIndex] = currentElement;
                this.anArray[i] = firstElement;
                fill(69, 255, 0);
                int yPosition = heightOfWindow - this.anArray[currentArrayIndex];
                rect(xLocation, yPosition, this.widthOfRect, this.anArray[currentArrayIndex]);
            }
        }
        currentArrayIndex++;
        if (currentArrayIndex == 199)
        {
            sorted = true;
        }
    }
}

class Testers
{
    public static void main(String[] asdasdasd)
    {
        ArrayBlock block = new ArrayBlock();

    }
}