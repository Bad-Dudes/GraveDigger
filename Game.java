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

public class Game extends JPanel
{
  //menu
  
  private MainMenu menu = new MainMenu(this); 
  //level
  private Level l1; 
  private boolean levelOn = false;
  private int levelInt = 2;
  private boolean levelLoaded = false;
  
//gravedigger
  private GraveDigger g1;
  
  
//rocks
  private Rock[] rocks;
  
  //enemy
  private Enemy e;
  
  //collectibles
  private Collectibles c1;
  
  
  public static void main (String[] args) throws InterruptedException  {
    JFrame frame = new JFrame("GraveDigger");
    Game gd = new Game();
    frame.add(gd);
    frame.setSize(1280, 960);
    
    frame.setVisible(true);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    while (true) {
      gd.move(); 
      gd.repaint();
      Thread.sleep(10); 
    }
  }
  
  //returns the current x coordinate of the player
  public int getPlayerX(){
    return g1.getPlayerX();
  }
  
  //returns the current y coordinate of the player
  public int getPlayerY(){
    return g1.getPlayerY();
  }
  
  public Game()
  {
    
    
    addKeyListener(new KeyListener() {
      
      @Override
      public void keyTyped(KeyEvent e) {
      } 
      
      @Override
      public void keyReleased(KeyEvent e) {
        if(menu.getMenuOn())
          menu.keyReleased(e);
        g1.keyReleased(e);
      }  
      
      @Override    
      public void keyPressed(KeyEvent e) {
        g1.keyPressed(e);
      }
    });
    
    setFocusable(true);
  }
  
  //method for creating the list of rocks (may have to be moved to level)
  public void getRockList(){
    int a = 0;
    for(int i = 0; i < 42; i++){
      for(int z = 0; z < 31; z++){
        if(l1.getTile(i,z) == 'r'){
          rocks[a] = new Rock(l1,this,i,z);
          a++;
        }
      }
    }
  }
  
  //LEVEL LOADER
  public void levelLoad(){
    String leveltxt = "level" + levelInt + ".txt";
    String enemytxt = "enemy"+levelInt+".txt";
    String collectiblestxt = "collectibles"+levelInt+".txt";
    this.l1 = new Level(leveltxt,this);
    //rocks
    rocks = new Rock[l1.getRockCount()];
    this.g1 = new GraveDigger(false, false, 0, 64, 0, 0,this,l1);
    getRockList();
    //enemy
    e = new Enemy(0,0,0,0,this,l1,enemytxt);
    e.enemyReader();
    //collectibles
    c1 = new Collectibles(0,0,this,collectiblestxt);
    c1.collectiblesReader();
    
    
    levelLoaded = true;
    if(!menu.getMenuOn()){
      setLevelOn(true);
    }
  }
  
  //Increases level int, moving to next level
  public void setLevelInt(int a){
    levelInt = a;
  }
  
  //changes levelLoaded to false, causing next level to load
  public void setLevelLoaded(){
    levelLoaded = false; 
  }
  
  public int getLevelInt(){
    return levelInt; 
  }
  
  public void setLevelOn(boolean a){
    levelOn =  a;
  }
  
  public boolean getLevelOn(){
    return levelOn; 
  }
  
  @Override
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    super.paint(g);
    
    if(levelOn)
      l1.paint(g2d);
    if(menu.getMenuOn())
      menu.paint(g2d);
    if(levelOn)
    {
      g1.paint(g2d);
      
      
      
      
      for(Skeleton a:e.getSList())
        a.paint(g2d);
      
      for(Ghost a:e.getGList())
        a.paint(g2d);
      
      for(Ghoul a:e.getGhList())
        a.paint(g2d);
      
      for(Collectibles2 a:c1.getCList())
        a.paint(g2d);
      
    }
  }
  
  public void move(){
    
    if(!levelLoaded){
      levelLoad();
    }
    
    if(levelOn){
      
      //player movement
      g1.move();
      
      //enemy movement
      for(Skeleton b:e.getSList())
      {
        b.updateTarget();
        b.move();
        g1.collision(b);
        for(Rock a:rocks){
          b.enemyRockCollision(a);
        }
      }
      
      for(Ghost b:e.getGList())
        
      {
        b.updateTarget();
        b.move();
        g1.collision(b);
      }
      
      for(Ghoul b:e.getGhList())
      {
        b.updateTarget();
        b.move();
        g1.collision(b);
        for(Rock a:rocks){
          b.enemyRockCollision(a);
        }
      }
      
      for(Rock b:rocks){
        g1.rockCollision(b);
      }
      
      for(Collectibles2 b:c1.getCList())
      {
        g1.coinCollision(b);
      }
      
      
      //rock movement
      for(int i = 0; i<rocks.length;i++){
        rocks[i].rockFall();
      }
      
      if(g1.getDead()){
        setLevelOn(false);
        g1.setDead();
        levelLoaded=false;
      }
      
      if(g1.levelComplete()){
        setLevelOn(false);
        setLevelInt(levelInt+1);
        levelLoaded=false;
      }
    }
  }
  
  
}