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

public class Ghoul extends Enemy
{
  

  private boolean movingRight = false;
  private boolean movingLeft = false;
  private boolean movingUp = false;
  private boolean movingDown = false;
  
    
   public Ghoul(int x, int y,int xa, int ya,Game game, Level level,String leveltxt) {
    super(x,y,xa,ya,game,level,leveltxt);
    sprite = Toolkit.getDefaultToolkit().getImage("Ghoul.png");
    
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
//    if ((y + ya <64) || (y + ya > (960) ))
//      ya *= -1;
//    
//    if((x%32 != 0) || (y)%32 !=0){
//      if(movingLeft){
//        xa = -1;
//        ya = 0;
//      }
//      if(movingRight){
//        xa = 1;
//        ya = 0;
//      }
//      if(movingUp){
//       ya = -1;
//       xa = 0;
//      }
//      if(movingDown){
//       ya = 1;
//       xa = 0;
//      }
//    }
//    else if((x%32 == 0) || (y)%32 ==0){
//      if(movingLeft){
//      movingLeft = false;
//      xa = 0;
//      ya = 0;
//      }
//      if(movingRight){
//      movingRight = false;
//      xa=0;
//      ya=0;
//      }
//      if(movingUp){
//      movingUp = false;
//      xa=0;
//      ya=0;
//      }
//      if(movingDown){
//      movingDown = false;
//      xa=0;
//      ya=0;
//      }
//    }
//    x= x+xa;
//    y= y+ya;
//    
//
//    
//  }
  
}