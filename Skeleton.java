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

public class Skeleton extends Enemy
{
  
  private int xa = 1;
  private int ya = 1;
  private boolean movingRight = false;
  private boolean movingLeft = false;
  private boolean movingUp = false;
  private boolean movingDown = false;
  
  public Skeleton(int x, int y, int xa, int ya, Game game, Level level,String leveltxt) {
    super(x,y,xa,ya,game,level,leveltxt);
    
  }
  
  
  public void paint(Graphics g)
  {
    if(!isDead){
      Graphics2D g2 = (Graphics2D) g;
      Image sprite = Toolkit.getDefaultToolkit().getImage("Skeleton.png");
      if (!flipped) g2.drawImage(sprite, x,y-height,width,height, null); //left facing sprite is "default sprite"
      else g2.drawImage(sprite, x+width,y-height,-width,height, null); //flipped left sprite
    }
  }
  
  
//  movingRight = false;
//  movingLeft = false;
//  movingUp = false;
//  movingDown = false;
  
//  public void move(){
//    int dif = 0;
//    
//    //if the distance between the players x and enemies x is greater than the difference between the players y and enemies y
//    if(Math.abs(playerX - x) > Math.abs(playerY-y)){
//      
//      //difference between player's x and enemy's x
//      dif = playerX - x;
//      
//      //the enemy is left of the player moves right
//      if(dif > 0){xa = 1;}
//      
//      //if the enemy is right of the player moves left
//      if(dif < 0){xa = -1;}
//      
//      //if the enemy is on the same x value as the player stops moving on the x
//      if(dif == 0){xa = 0;}
//    }
//    else if(Math.abs(playerY - y) > Math.abs(playerX- x)){
//      
//      //difference between player's y and enemy's y
//      dif = playerY - y;
//      
//      //if the enemy has a lower y value than the player / above the player, enemy moves up
//      if(dif > 0){ya = 1;}
//      
//      //if the enemy has a greater y value / is below the player, enemy moves down
//      if(dif < 0){ya = -1;}
//      
//      //if the enemy is on the same y value as the player stops moving on the y
//      if(dif == 0){ya = 0;}
//    }
//    if ((x + xa <0) || (x + xa > (1280 - width) ))
//      xa *= -1;
//    if ((y + ya <64) || (y + ya > (960) ))
//      ya *= -1;
  
  /*
   if((x%32 != 0) || (y)%32 !=0){
   if(movingLeft){
   xa = -1;
   ya = 0;
   }
   if(movingRight){
   xa = 1;
   ya = 0;
   }
   if(movingUp){
   ya = -1;
   xa = 0;
   }
   if(movingDown){
   ya = 1;
   xa = 0;
   }
   }
   else if((x%32 == 0) || (y)%32 ==0){
   if(movingLeft){
   movingLeft = false;
   xa = 0;
   ya = 0;
   }
   if(movingRight){
   movingRight = false;
   xa=0;
   ya=0;
   }
   if(movingUp){
   movingUp = false;
   xa=0;
   ya=0;
   }
   if(movingDown){
   movingDown = false;
   xa=0;
   ya=0;
   }
   }
   */
  
  
//    x = x+xa;
//    y =y+ya;
//    
//  }
  
  
}