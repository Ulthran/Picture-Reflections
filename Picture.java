import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 *
 * 02-27-15 altered by Leon Schram
 * This file is made shorter to focus on the Lab15b assignment.
 *
 */
 
 
 
//////////////////////////////////////////////////////////////////////////
//
// This is the student starting file of the Lab15b assignment.
//
// This is the only file that students use to write their methods.
//
//////////////////////////////////////////////////////////////////////////
 
 
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight()
      + " width " + getWidth();
    return output;
    
  }
  
      
 ////////////////////////////////////////////////////////////////////////  
   
      // REQUIRED FOR 80-POINTS
      public void grayScale()
      {
         Pixel[][] pixels = this.getPixels2D();
         
         for(Pixel[] pixelX: pixels)
         {
            for(Pixel pixel: pixelX)
            {
               int avg = 0;
               
               avg += pixel.getRed();
               avg += pixel.getGreen();
               avg += pixel.getBlue();
               
               avg /= 3;
               
               pixel.setColor(new Color(avg, avg, avg));
            }
         }
      }
  
//////////////////////////////////////////////////////////////////////////  

      // REQUIRED FOR 80-POINTS
      public void mirror()
      {
         Pixel[][] pixels = this.getPixels2D();
         int counter = 0;
         
         for(counter=0; counter<(pixels.length); counter++)
         {
            for(int i=0; i<(pixels[100].length); i++)
            {
               Color temp;
               
               temp = pixels[counter][i].getColor();
               pixels[counter][i].setColor(pixels[counter][pixels[100].length-i-1].getColor());
               pixels[counter][pixels[100].length-i-1].setColor(temp);
               
               i++;
            }
         }
      } 
      
////////////////////////////////////////////////////////////////////////////////////////

      // REQUIRED FOR 80-POINTS
      public void upsideDown()
      {
         Pixel[][] pixels = this.getPixels2D();
         int counter = 0;
         
         for(int i=0; i<(pixels[100].length); i++)
         {
            for(counter=0; counter<(pixels.length); counter++)
            {
               Color temp;
               
               temp = new Color(pixels[counter][i].getRed(), pixels[counter][i].getGreen(), pixels[counter][i].getBlue());
               pixels[counter][i].setColor(new Color(pixels[pixels.length-1-counter][i].getRed(), pixels[pixels.length-1-counter][i].getGreen(), pixels[pixels.length-1-counter][i].getBlue()));
               pixels[pixels.length-counter-1][i].setColor(temp);
               
               counter++;
            }
         }
      }    
      
//////////////////////////////////////////////////////////////////////////////////////////

   // REQUIRED FOR 90-POINTS
   public void mirrorVertical()
   { 
      Pixel[][] pixels = this.getPixels2D();
      
      for(int i=0; i<pixels.length; i++)
      {
         for(int j=0; j<pixels[100].length; j++)
         {
            pixels[i][pixels[100].length-j-1].setColor(pixels[i][j].getColor());
         }
      }
   }
   
//////////////////////////////////////////////////////////////////////////////////
   
   // REQUIRED FOR 90-POINTS
   public void mirrorHorizontal()
   {
      Pixel[][] pixels = this.getPixels2D();
      
      for(int i=0; i<pixels.length; i++)
      {
         for(int j=0; j<pixels[100].length; j++)
         {
            pixels[pixels.length-i-1][j].setColor(pixels[i][j].getColor());
         }
      }
   }
      
//////////////////////////////////////////////////////////////////////////////////////////////////      
    
   // REQUIRED FOR 90-POINTS
   public void mirrorDiagonal()
   {
      Pixel[][] pixels = this.getPixels2D();
      int counter = 0;
      
      for(int i=0; i+counter<pixels[100].length; i++)
      {
         for(int j=0; j<pixels.length; j++)
         {
            pixels[i][j].setColor(pixels[j][i].getColor());
         }
         counter++;
      }
   }
   
/////////////////////////////////////////////////////////////////////////////////////
   
   // REQUIRED FOR 100-POINTS
   public void mirrorTemple()
   {
      Pixel[][] pixels = this.getPixels2D();
      
      for(int i=30; i<100; i++)
      {
         for(int j=0; j<pixels[100].length; j++)
         {
            pixels[i][pixels[100].length-j-1].setColor(pixels[i][j].getColor());
         }
      }
   }
   
} 
