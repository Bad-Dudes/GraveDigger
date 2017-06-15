import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;


public class Collectibles{
  
  //x and y of the collectible
  protected int x = 0;
  protected int y = 0;
  protected int width = 32;
  protected int height = 32;
  private Image collectibles;
  private int xL = 42;
  private int yL = 31;
  
  private Game game;
  
  
  private int[][] collectiblesLayout;
  private Collectibles2[] cList;
  private int coinNumber = 0;
  
  private String collectiblestxt;
  
  public Collectibles(int x, int y, Game game,String collectiblestxt){
    this.x=x;
    this.y=y;
    this.game=game;
    this.collectiblestxt = collectiblestxt;
    
    collectiblesLayout = new int[xL][yL];
    try
    {
      //Create a new instance of the FileReader and pass it the
      //file that needs to be read
      FileReader fr2 = new FileReader(collectiblestxt);
      
      //Create a new instance of the BufferedReader and
      //add the FileReader to it
      BufferedReader br2 = new BufferedReader(fr2);
      //A string variable that will temporarily what you’re reading
      String line;
      //A dual purpose line! First it reads the next line and then
      //it checks to see if that line was null. If it’s null, then
      //that means you’re at the end of the file.
      int yPos = 0;
      int xPos = 0;
      while ((line=br2.readLine()) != null)
      {
        for(int i = 0; i < line.length(); i++){
          collectiblesLayout[xPos][yPos] = line.charAt(i);
          xPos++;
        }
        yPos++;
        xPos = 0;
      }
      //close the file when you’re done
      br2.close();
    }
    catch(IOException e)
    {
      //Error message
    }
  }
  
  public void collectiblesReader() {
    
    for(int i = 0; i < 42; i++){
      for(int z = 0; z < 31; z++){
        if(collectiblesLayout[i][z] == 'c'||collectiblesLayout[i][z] =='k'){
          coinNumber++;
        }
      }
    }
    
    cList = new Collectibles2[coinNumber];
    
    x = 0;
    //sky ends after y value
    y = 64;
    int a = 0;
    for(int i = 0; i < xL; i++){
      for(int z = 0; z < yL; z++){
        if(collectiblesLayout[i][z] == 'c'){
          cList[a] = new Collectibles2((32*(i-1)),32*(z+3),game,false,collectiblestxt);
          
          a++;
        }
        if(collectiblesLayout[i][z] == 'k'){
          cList[a] = new Collectibles2(32*(i-1),32*(z+3),game,true,collectiblestxt);         
          a++;
        }
        
        y = y + height;
      }
      x = x + width;
      y = 64;
    }
  }
  
  
  
  public Collectibles2[] getCList() {
    return cList;
  }
  
  
}