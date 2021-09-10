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
        currentArrayIndex = 1;
        frameRate(15);
        widthOfWindow = 900;
        sizeOfArray = 10;
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
        if (!drawn)
        {
            aBlockManager.drawCurrentBlock(this);
            aBlockManager.update();
            if (aBlockManager.currentIndex >= sizeOfArray)
            {
                drawn = true;
                aBlockManager.reset();
            }
        }

        if (drawn && !sorted)
        {

            aBlockManager.sortArrayHelper(this, currentArrayIndex);
            //aBlockManager.drawCurrentBlock(this);

            currentArrayIndex++;

            if (currentArrayIndex >= aBlockManager.blockArray.length)
            {
                aBlockManager.drawCurrentBlock(this);
                aBlockManager.update();
                currentArrayIndex = aBlockManager.currentIndex + 1;
            }

            if (aBlockManager.currentIndex >= sizeOfArray-1)
            {
                aBlockManager.drawCurrentBlock(this);
                sorted = true;
            }
        }



        //assert (aBlockManager.currentIndex == 200);
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