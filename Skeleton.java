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
    if(!enemyIsDead){
      Graphics2D g2 = (Graphics2D) g;
      Image sprite = Toolkit.getDefaultToolkit().getImage("Skeleton.png");
      if (!flipped) g2.drawImage(sprite, x,y-height,width,height, null); //left facing sprite is "default sprite"
      else g2.drawImage(sprite, x+width,y-height,-width,height, null); //flipped left sprite
    }
  }

}