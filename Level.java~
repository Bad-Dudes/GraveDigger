import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Level{
  private int width=32;
  private int height=32;
  private int x;
  private int y;
  private int xL = 42;
  private int yL = 33;
  private int[][] levelLayout;
  
  //sprites
  private Image dirt = Toolkit.getDefaultToolkit().getImage("Dirt.png");
  private Image grass = Toolkit.getDefaultToolkit().getImage("Grass.png");
  private Image rock = Toolkit.getDefaultToolkit().getImage("Rock.png");
  
  private String leveltxt;
  
  private Game game;
  
  
  public Level(String leveltxt, Game game){
    levelLayout = new int[xL][yL];
    this.leveltxt = leveltxt;
    this.game = game;
    try
    {
      //Create a new instance of the FileReader and pass it the
      //file that needs to be read
      FileReader fr = new FileReader(leveltxt);
      //Create a new instance of the BufferedReader and
      //add the FileReader to it
      BufferedReader br = new BufferedReader(fr);
      //A string variable that will temporarily what you’re reading
      String line;
      //A dual purpose line! First it reads the next line and then
      //it checks to see if that line was null. If it’s null, then
      //that means you’re at the end of the file.
      int yPos = 0;
      int xPos = 0;
      while ((line=br.readLine()) != null)
      {
        for(int i = 0; i < line.length(); i++){
          levelLayout[xPos][yPos] = line.charAt(i);
          xPos++;
        }
        yPos++;
        xPos = 0;
      }
      //close the file when you’re done
      br.close();
    }
    catch(IOException e)
    {
      //Error message
    }
  }
  
  public void paint(Graphics g){
    Graphics2D g2 = (Graphics2D) g;
    x = -32;
    //sky ends after y value
    y = 0;
    g2.setColor(Color.BLACK);
    g2.fillRect(0,0,1280,960);
    g2.setColor(Color.BLUE);
    g2.fillRect(0,0,1280,64);
    for(int i = 0; i < xL; i++){
      for(int z = 0; z < yL; z++){
        if(levelLayout[i][z] == 'g'){
          g2.drawImage(grass, x,y,width,height, null);
        }
        if(levelLayout[i][z] == 'd'){
          g2.drawImage(dirt, x,y,width,height, null);
        }
        if(levelLayout[i][z] == 'r'){
          g2.drawImage(rock, x,y,width,height, null);
        }
        if(levelLayout[i][z] == 't'){
          g2.setColor(Color.BLACK);
          g2.fillRect(x,y,width,height);
        }
        y = y + height;
      }
      x = x + width;
      y = 0;
    }
    if(game.getLevelInt()==0){
      g2.setColor(Color.WHITE);
      g.setFont(new Font("TimesRoman", Font.PLAIN, 28)); 
      g.drawString("The grave digger can dig up, down, left, and right with the W A S D keys or the arrow keys.", 64, 32);
      g.drawString("Rocks will fall if you dig underneath them. They will crush enemies. Watch out! They'll kill you too!", 64, 128);
      g.drawString("There are three types of enemies. Skeletons, Ghouls and Ghosts. They will kill you if they touch you.", 64, 192);
       g.drawString("Skeletons and Ghouls must go through tunnels. Ghosts can go through dirt but they are much slower.", 64, 256);
      g.drawString("Coin bags give you one coin. You can spend coins in the shop after every level.", 64, 672);
      g.drawString("Grab the key to exit the level and move on to the next one!", 64, 800);
      /* Sentences for the tutorial
       * The grave digger can dig up, down, left, and right with the wasd keys.
       * Enemeis will follow the grave digger through tunnels.
       * Enemies can be defeated by dropping rocks on them.
       * If rocks do not have any ground underneath them they will fall.
       */
    }
  }
  
  public int getTile(int x,int y){
    return levelLayout[x][y]; 
  }
  
  public void setTile(int x, int y, char p){
    levelLayout[x][y] = p; 
  }
  
  public int getRockCount(){
    int rockCounter = 0;
    
    for(int i = 0; i < xL; i++){
      for(int z = 0; z < yL; z++){
        if(levelLayout[i][z] == 'r'){
          rockCounter++; 
        }
      }
    }
    
    return rockCounter; 
  }
  
}