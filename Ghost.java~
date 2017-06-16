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
    if(!enemyIsDead){
    Graphics2D g2 = (Graphics2D) g;
    if (!flipped) g2.drawImage(sprite, x,y-height,width,height, null); //left facing sprite is "default sprite"
    else g2.drawImage(sprite, x+width,y-height,-width,height, null); //flipped left sprite
    }
  }
  
//updates the variables playerX and playerY which are used by the enemies to move toward the grave digger
  public void updateTarget(){
    if(!enemyIsDead){
      //has to go through game
      playerX = game.getPlayerX();
      playerY = game.getPlayerY();
      goRight = true;
      goLeft = true;
      goUp = true;
      goDown = true;
      movementCounter++;
    }
  }
  
  
  public void move(){
    if(!enemyIsDead){
      if(movementCounter==100){
        
        difx = playerX - x;
        dify = playerY - y;
        
        //the enemy is left of the player moves right
        if(difx > 0 && goRight){
          ya = 0;
          xa = b;  
        }
        
        //if the enemy is right of the player moves left
        if(difx < 0 && goLeft){
          ya = 0;
          xa = -b;
          
        }
        
        //if the enemy is on the same x value as the player stops moving on the x
        if(difx == 0){
          xa = 0;
        }
        
        //if the enemy has a lower y value than the player / above the player, enemy moves up
        if(dify > 0 && goDown){
          xa = 0;
          ya = b; 
        }
        
        //if the enemy has a greater y value / is below the player, enemy moves down
        if(dify <0 && goUp){
          xa = 0;
          ya = -b;
        }
        
        //if the enemy is on the same y value as the player stops moving on the y
        if(dify == 0){ya = 0;}
        
        
        if((!goUp && ya == -b) || (!goDown && ya == b)){ya = 0;}
        if((!goLeft && xa == -b) || (!goRight && xa == b)){xa = 0;}
        
        x = x+xa;
        y =y+ya;
        movementCounter=0;
      }
    }
  }
  
}