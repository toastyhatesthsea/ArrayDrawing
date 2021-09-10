import processing.core.PApplet;

import java.awt.*;
import java.util.Random;

public class BlockManager extends PApplet
{
    Block[] blockArray;
    int size;
    float heightOfWindow;
    float widthOfWindow;
    int currentIndex;


    public BlockManager(int size, float widthOfWindow, float heightOfWindow)
    {
        blockArray = new Block[size];
        this.size = size;
        this.heightOfWindow = heightOfWindow;
        this.widthOfWindow = widthOfWindow;
        currentIndex = 0;

        createArray();
    }

    private void createArray()
    {
        Random aRan = new Random();
        float yLocation = 0;
        float xLocation = 0;
        float widthOfBlock = this.widthOfWindow / size;

        for (int i = 0; i < this.size; i++)
        {
            float heightOfRectangle = aRan.nextInt(200);
            yLocation = this.heightOfWindow - heightOfRectangle;

            blockArray[i] = new Block(xLocation, yLocation, widthOfBlock, heightOfRectangle, Color.GRAY);
            xLocation = xLocation + widthOfBlock;
        }
    }

    public void update()
    {
        if (currentIndex < this.blockArray.length)
        {
            currentIndex++;
        }
    }

    public void reset()
    {
        currentIndex = 0;
    }

    public Block[] getBlockArray()
    {
        return blockArray;
    }

    public Block getCurrentBlock()
    {
        return this.blockArray[currentIndex];
    }

    public void drawCurrentBlock(PApplet anApple)
    {
        Block aBlock = this.getCurrentBlock();

        anApple.fill(aBlock.aColor.getRGB());
        //fill(aBlock.aColor.getRGB());
        //rect(aBlock.xLocation, aBlock.yLocation, aBlock.width, aBlock.height);
        anApple.rect(aBlock.xLocation, aBlock.yLocation, aBlock.width, aBlock.height);
    }

    //TODO Fix Colors after sorting
    public void sortArrayHelper(PApplet anApple, int counter)
    {
        Block forLoopBlock = this.blockArray[counter];
        Block currentIndexBlock = this.getCurrentBlock();

        if (currentIndexBlock.height >= forLoopBlock.height)
        {
            float currentIndexBlockXLocation = currentIndexBlock.xLocation;
            float forLoopXLocation = forLoopBlock.xLocation;

            this.blockArray[currentIndex] = forLoopBlock;
            this.blockArray[counter] = currentIndexBlock;
            if (currentIndex >= counter)
            {
                forLoopBlock.setaColor(Color.MAGENTA);
                currentIndexBlock.setaColor(Color.MAGENTA);
            }
            else
            {
                forLoopBlock.setaColor(Color.MAGENTA);
                currentIndexBlock.setaColor(Color.GREEN);
            }


            forLoopBlock.setxLocation(currentIndexBlockXLocation);
            currentIndexBlock.setxLocation(forLoopXLocation);

            //currentIndexBlock.drawBlock(anApple);
            //forLoopBlock.drawBlock(anApple);
        }


    }

    public void sortArray(PApplet anApple, int index)
    {

        for (int i = currentIndex + 1; i < this.blockArray.length; i++)
        {
            Block forLoopBlock = this.blockArray[i];
            Block currentIndexBlock = this.getCurrentBlock();

            if (currentIndexBlock.height >= forLoopBlock.height)
            {
                float currentIndexBlockXLocation = currentIndexBlock.xLocation;
                float forLoopXLocation = forLoopBlock.xLocation;

                this.blockArray[currentIndex] = forLoopBlock;
                this.blockArray[i] = currentIndexBlock;
                forLoopBlock.setaColor(Color.MAGENTA);

                forLoopBlock.setxLocation(currentIndexBlockXLocation);
                currentIndexBlock.setxLocation(forLoopXLocation);
            }
        }

        this.getCurrentBlock().setaColor(Color.GREEN);
    }

    public void setBlockArray(Block[] blockArray)
    {
        this.blockArray = blockArray;
    }

}
