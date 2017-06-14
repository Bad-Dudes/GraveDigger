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

public class GraveDigger
{
  private boolean hasArmor;
  private boolean hasWand;
  private boolean movingRight = false;
  private boolean movingLeft = false;
  private boolean movingUp = false;
  private boolean movingDown = false;
  private boolean movingRightFinish = false;
  private boolean movingLeftFinish = false;
  private boolean movingUpFinish = false;
  private boolean movingDownFinish = false;
  private int x;
  private int y;
  private int xa;
  private int ya;
  private int height = 32; 
  private int width = 32;
  private Game game;
  private Level level;
  private boolean isDead = false;
  private boolean hasKey = false;
  private int coins;
  
  
  public GraveDigger(boolean hasArmor, boolean hasWand,int x, int y, int xa, int ya, Game game, Level level)
  {
    this.hasArmor = hasArmor;
    
    this.hasWand = hasWand;
    this.x = x;
    this.y = y;
    this.xa = xa;
    this.ya = ya;
    
    this.game = game;
    this.level = level;
  }
  public int getPlayerX(){
    return x;
  }
  
  public int getPlayerY() {
    return y;
  }
  
  public void move(){
    
    if ((x + xa <0) || (x + xa > (1280 - width) )){
      xa *= 0;
      movingLeft = false;
      movingRight=false;
    }
    if ((y + ya <64) || (y + ya > (960) )){
      ya *= 0;
      movingUp=false;
      movingRight=false;
    }
    
    int xL = ((x + xa + 32)/32);
    if(movingLeft)
      xL++;
    int yL =((y + ya - 95)/32);
    if(movingUp)
      yL++;
    
    if(movingUp && (level.getTile(xL, yL-1)== 'r')){
      xa = 0;
      ya = 0;
      movingUp = false;
      movingDownFinish =true;
    }
    else if(movingDown && (level.getTile(xL, yL+1)== 'r')){
      xa = 0;
      ya = 0;
      movingDown = false;
      movingUpFinish=true;
    }
    else if(movingRight && (level.getTile(xL+1, yL)== 'r')){
      xa = 0;
      ya = 0;
      movingRight = false;
      movingLeftFinish=true;
    }
    else if(movingLeft && (level.getTile(xL-1, yL)== 'r')){
      xa = 0;
      ya = 0;
      movingLeft = false;
      movingRightFinish=true;
    }
    
    else{
      if(movingUp)
        yL--;
      level.setTile(xL,yL,'t');                    
    }
    
    if((x%32 != 0) || (y)%32 !=0){
      if(movingLeftFinish){
        xa = -1;
        ya = 0;
      }
      if(movingRightFinish){
        xa = 1;
        ya = 0;
      }
      if(movingUpFinish){
        ya = -1;
        xa = 0;
      }
      if(movingDownFinish){
        ya = 1;
        xa = 0;
      }
    }
    
    else if((x%32 == 0) || (y)%32 ==0){
      if(movingLeftFinish){
        movingLeftFinish = false;
        movingLeft=false;
        xa = 0;
        ya = 0;
      }
      if(movingRightFinish){
        movingRightFinish = false;
        movingRight = false;
        xa=0;
        ya=0;
      }
      if(movingUpFinish){
        movingUpFinish = false;
        movingUp = false;
        xa=0;
        ya=0;
      }
      if(movingDownFinish){
        movingDownFinish = false;
        movingDown = false;
        xa=0;
        ya=0;
      }
    }
    
    x= x+xa;
    y= y+ya;
  }
  
  public void keyPressed(KeyEvent e){
    //only allows movement in one direction at a time
    if (e.getKeyCode() == KeyEvent.VK_A)
    {
      if(ya == 0){
        xa = -1;
        movingLeft = true;
      }
    }
    if (e.getKeyCode() == KeyEvent.VK_D)
    {
      if(ya == 0){
        xa = 1;
        movingRight = true;
      }
    }
    if (e.getKeyCode() == KeyEvent.VK_W)
    {
      if(xa ==0){
        ya = -1;
        movingUp = true;
      }
    }
    if (e.getKeyCode() == KeyEvent.VK_S)
      if(xa == 0){
      ya = 1;
      movingDown = true;
    }
  }
  
  public void keyReleased(KeyEvent e){
    if(xa == -1)
      movingLeftFinish = true;
    if(xa == 1)
      movingRightFinish = true;
    if(ya == 1)
      movingDownFinish = true;
    if(ya == -1)
      movingUpFinish = true;
    
    xa = 0;
    ya = 0;
  }
  
  public void paint(Graphics g){
    Graphics2D g2 = (Graphics2D) g;
    Image graveDigger = Toolkit.getDefaultToolkit().getImage("GraveDigger.png");
    if (xa == -1) g2.drawImage(graveDigger, x,y-height,width,height, null); //left facing sprite is "default sprite"
    else g2.drawImage(graveDigger, x+width,y-height,-width,height, null); //flipped left sprite
  }
  
  public void collision(Enemy a)  {
    int dx = (x-a.x) + (xa-a.xa);
    int dy = (y-a.y) + (ya-a.ya);  
    if ((int)Math.sqrt(dx*dx+dy*dy)<=32)
    {
      
      isDead = true;
    }  
  }
  
  public void coinCollision(Collectibles2 a) {
    int dx = (x-a.x);
    int dy = (y-a.y);  
    if ((int)Math.sqrt(dx*dx+dy*dy)<32)
    {
      if (a.getIsKey()) {
        hasKey = true;
        System.out.println("yeehaw");
      }
      if (a.getPickedUp() == false)
      {
        a.setPickedUp();
        coins += 10;
        System.out.println(coins);
      }
    }
  }
  
  public boolean getDead() {
    return isDead;
  }
  
  public void setDead() {
    isDead = false;
  }
  
  public void setHasKey() {
    hasKey = true;
  }
  
  public boolean levelComplete() {
    return hasKey;
  }
} 