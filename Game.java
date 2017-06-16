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
  private int levelInt = 1;
  private boolean levelLoaded = false;
  
  
//gravedigger
  private GraveDigger g1;
  private boolean storedArmor = false;
  private boolean storedPotion = false;
  private Image armor = Toolkit.getDefaultToolkit().getImage("armor.png");
  private Image potion = Toolkit.getDefaultToolkit().getImage("potion.png");
  
//rocks
  private Rock[] rocks;
  
  //enemy
  private Enemy e;
  
  //collectibles
  private Collectibles c1;
  
  //shop
  private Shop s1 = new Shop(this,storedArmor,storedPotion);
  protected int updatedCoins = 0;
  
  public static void main (String[] args) throws InterruptedException  {
    JFrame frame = new JFrame("GraveDigger");
    Game gd = new Game();
    frame.add(gd);
    frame.setSize(1296, 998);
    
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
      //Determines what main game menu and shop will do when various keys are pressed
      
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
        s1.keyPressed(e);
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
    this.g1 = new GraveDigger(storedArmor, storedPotion, 0, 64, 0, 0,this,l1,updatedCoins);
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
  
  public void loadGame(){
    try
    {
      //Create a new instance of the FileReader and pass it the
      //file that needs to be read
      FileReader fr = new FileReader("save.txt");
      //Create a new instance of the BufferedReader and
      //add the FileReader to it
      BufferedReader br = new BufferedReader(fr);
      //A string variable that will temporarily what you’re reading
      String line;
      //A dual purpose line! First it reads the next line and then
      //it checks to see if that line was null. If it’s null, then
      //that means you’re at the end of the file.
      while ((line=br.readLine()) != null)
      {
        char c = line.charAt(0);
        levelInt = Character.getNumericValue(c);
        if(line.charAt(1) == '1'){
          g1.setHasArmor();
          storedArmor=true;
        }
        if(line.charAt(2) == '1'){
          g1.setHasPotion();
          storedPotion=true;
        }
        setGameCoins(Integer.valueOf(line.substring(3)));
      }
      //close the file when you’re done
      br.close();
    }
    catch(IOException e)
    {
      //Error message
    }
  }
  
  public void saveGame(){
    //Saves the game
    String line;
    
    final int RADIX = 10;
    char x = Character.forDigit(levelInt, RADIX);
    System.out.println(x);
    char y;
    char z;
    if(g1.getHasArmor()){
      y = (char)'1'; 
    }
    else{
      y = (char)'0'; 
    }
    if(g1.getHasPotion()){
      z = (char)'1';
    }
    else{
      z = (char)'0';
    }
    
    line = new StringBuilder().append(x).append(y).append(z).toString();
    line = line + updatedCoins;
    
    try
    {
      //creates a new instance of the FileWriter and passes it
      //the file you’re writing to
      FileWriter fw = new FileWriter("save.txt");
      //creates an instance of PrintWriter and passes it
      //the instance of the FileWriter
      PrintWriter pw = new PrintWriter(fw);
      
      //Write the text to the file
      pw.println(line);
      //close the file
      pw.close();
    }
    catch(IOException e)
    {
      //some error message
    }
  }
  
  //Changes level int, changing levels
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
    //Paints all of the main components of the game, such as the menus, GraveDigger, collectibles, enemies, etc.
    Graphics2D g2d = (Graphics2D) g;
    super.paint(g);
    
    if(levelOn)
      l1.paint(g2d);
    if(menu.getMenuOn())
      menu.paint(g2d);
    if(levelOn)
    {
      g1.paint(g2d);
      g2d.setColor(Color.WHITE);
      g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
      g2d.drawString("Coins: " + g1.getCoins(),1200,20);
      
      for(Skeleton a:e.getSList())
        a.paint(g2d);
      
      for(Ghost a:e.getGList())
        a.paint(g2d);
      
      for(Ghoul a:e.getGhList())
        a.paint(g2d);
      
      for(Collectibles2 a:c1.getCList())
        a.paint(g2d);
     
      if (g1.getHasArmor()) g2d.drawImage(armor, 1200,20,32,32, null); 
      if (g1.getHasPotion()) g2d.drawImage(potion, 1232,20,32,32, null); 
      
    }
    if(s1.getShop()) s1.paint(g2d);
  }
  
  
  
  public void move(){
     //Allows all of the the moving components of the game to move, such as the GraveDigger, enemies, etc.
    
    if(!levelLoaded){
      levelLoad();
    }
    
    if(levelOn){
      //player movement
      g1.move();
      
      //enemy movement
      for(Skeleton b:e.getSList())
      {
        if(!b.getIsDead()) {
          b.updateTarget();
          b.move();
          g1.collision(b);
          for(Rock a:rocks){
            b.enemyRockCollision(a);
          }
        }
      }
      
      for(Ghost b:e.getGList())
        
      {
        if(!b.getIsDead()) {
          b.updateTarget();
          b.move();
          g1.collision(b);
        }
      }
      
      for(Ghoul b:e.getGhList())
      {
        if(!b.getIsDead()) {
          b.updateTarget();
          b.move();
          g1.collision(b);
          for(Rock a:rocks){
            b.enemyRockCollision(a);
          }
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
        //Runs only if the level has been completed
        storedArmor = g1.getHasArmor();
        storedPotion = g1.getHasPotion();
        setLevelOn(false);
        setLevelInt(levelInt+1);
        s1 = new Shop(this,storedArmor,storedPotion);
        s1.setShop(getCoins());
        saveGame();
      }
    }
  }
  
   public int getCoins() {
     //Returns the amount of coins the graveDigger currently has.
      System.out.println(g1.getCoins() + " coins currently");
    return g1.getCoins();
    

  }
  
  public void setGameCoins(int c)
    //Sets the amount of coins that GraveDigger has to whatevr int you feed it.
  { 
    updatedCoins = c;
  }
  
  //Setter/getter methods for armor and potion
  public void setHasArmor(){
    storedArmor=true;
    g1.setHasArmor();
  }
  
  public void getHasArmor(){
   g1.getHasArmor(); 
  }
  
  public void setHasPotion() {
    storedPotion=true;
    g1.setHasPotion();
  }
  
  public void getHasPotion(){
   g1.getHasPotion(); 
  }
  
  
}