import java.awt.*;
import java.util.Random;

public class BlockManager
{
    Block[] blockArray;
    int size;
    float heightOfWindow;
    float widthOfWindow;


    public BlockManager(int size, float widthOfWindow, float heightOfWindow)
    {
        blockArray = new Block[size];
        this.size = size;
        this.heightOfWindow = heightOfWindow;
        this.widthOfWindow = widthOfWindow;

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

    public Block[] getBlockArray()
    {
        return blockArray;
    }

    public void setBlockArray(Block[] blockArray)
    {
        this.blockArray = blockArray;
    }
}
