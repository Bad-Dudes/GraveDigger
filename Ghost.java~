import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener; 

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class Ghost extends Enemy
{
  

  
    
  public Ghost(int x, int y, int xa, int ya, Game game,Level level,String leveltxt) {
    super(x,y,xa,ya,game,level,leveltxt);
    sprite = Toolkit.getDefaultToolkit().getImage("Ghost.png");
    
  }
  

  public void paint(Graphics g)
  {
    Graphics2D g2 = (Graphics2D) g;
    if (!flipped) g2.drawImage(sprite, x,y-height,width,height, null); //left facing sprite is "default sprite"
    else g2.drawImage(sprite, x+width,y-height,-width,height, null); //flipped left sprite

  }
  
//  public void move(){
//    if ((x + xa <0) || (x + xa > (1280 - width) ))
//      xa *= -1;
//    if ((y + ya <78) || (y + ya > (960) ))
//      ya *= -1;
//    x= x+xa;
//    y= y+ya;
//  }
  
}