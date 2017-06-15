import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MainMenu{
  private Image mainMenu = null;
  private boolean menuOn = true;
  private Game game;
  
  
  public MainMenu(Game game){
    Image mainMenu = Toolkit.getDefaultToolkit().getImage("mainMenu.png");
    this.game = game;
  }
  
    public void setMenuOn(boolean a){
   menuOn =  a;
  }
  
  public boolean getMenuOn(){
   return menuOn; 
  }
  
  
  public void paint(Graphics g){
   Graphics2D g2 = (Graphics2D) g;
Image mainMenu = Toolkit.getDefaultToolkit().getImage("mainMenu.png");
g2.drawImage(mainMenu, 0,0,1280,960, null); 
  }
  
  
  public void keyReleased(KeyEvent e){
    if(e.getKeyCode() == KeyEvent.VK_1){
      // NEW GAME
      game.setLevelOn(true);
      menuOn = false;
    }
    if(e.getKeyCode() == KeyEvent.VK_2){
      // LOAD GAME
    }
    if(e.getKeyCode() == KeyEvent.VK_3){
      // EXIT
    }
  }
}