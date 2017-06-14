import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rock { 
  
  private Level level;
  private Game game;
  private int xPos;
  private int yPos;
  //counters
  private int fallCounter;
  private int dissapearCounter;
  //if rock has fallen
  private boolean rockFell;
  //if rock is touching another tile
  private boolean rockTouch;
  //if rock has dissapeared
  private boolean rockGone;
  
  public Rock(Level level, Game game,int xPos,int yPos){
    this.level = level;
    this.game = game;
    
    this.xPos = xPos;
    this.yPos = yPos;
    
  }
  
  public void rockFall(){
    if(!rockGone){
      if(level.getTile(xPos,yPos+1)=='d'||level.getTile(xPos,yPos+1)=='r'||level.getTile(xPos,yPos+1)=='g'||level.getTile(xPos,yPos+1)=='x'){
        rockTouch=true; 
      }
      else{
        rockTouch=false; 
      }
      if(level.getTile(xPos,yPos+1) == 't'){
        if(fallCounter>=100){
          level.setTile(xPos,yPos+1,'r');
          level.setTile(xPos,yPos,'t');
          yPos = yPos+1;
          rockFell=true;
          fallCounter=0;
        }
        if(rockFell){
          fallCounter = fallCounter + 5;
        }
        fallCounter++;
      }
      if(rockFell&&rockTouch){
        dissapearCounter++;
      }
      if(dissapearCounter==50){
        level.setTile(xPos,yPos,'t');
        rockGone=true;
      }
    }
  }
}