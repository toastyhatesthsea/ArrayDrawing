import processing.core.PApplet;

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
    

    public void settings()
    {
        size(widthOfWindow, heightOfWindow);
    }


    public void setup()
    {
        sorted = false;
        drawn = false;
        xLocation = 10;
        yLocation = 10;
        yLocationBuffer = 50;
        currentArrayIndex = 0;
        frameRate(30);
        widthOfWindow = 900;
        sizeOfArray = 200;
        widthOfRect = (float) widthOfWindow / (sizeOfArray + 5);
        background(126, 239, 247);
        anArray = new int[sizeOfArray];
        createArray();
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
        int element = this.anArray[currentArrayIndex];

        fill(element);
        yLocation = this.heightOfWindow - element;
        rect(xLocation, yLocation - yLocationBuffer, this.widthOfRect, element);
        xLocation += widthOfRect;
        currentArrayIndex++;

        if (currentArrayIndex == 200)
        {
            drawn = true;
            currentArrayIndex = 0;
        }
    }

    public void draw()
    {
        /*if (!drawn)
        {
            drawArray();
        } else if */if(!sorted)
        {
            sortArray();
        }

    }

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