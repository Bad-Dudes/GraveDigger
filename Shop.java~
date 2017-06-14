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

public class Shop extends JPanel{
  private int armorCost = 10;
  private int potionCost = 10;
  private int wandCost = 10;
  //contains how much gold the player has
  private int tensGold = 9;
  private int onesGold = 9;
  private int totalGold = 99;
  
  //these variables are for if the player has wand armor or a potion
  //they are what prevents them from buying more at the shop
  private boolean haveWand = false;
  private boolean haveArmor = false;
  private boolean havePotion = false;
  
  private Game game;
  
  //boolean which determines if the shop is painted or not. true means it is painted false means it is not.
  private boolean shopOn = true;
  
  //the x of the white selection box around the items
  private int selectX = 450;
  
  //shows if the selected item is in stock
  private boolean inStock = true;
  
  //this is the full shop background image
  private BufferedImage shopImage = null;
  
  //shows which item is selected, 1 is armor 2 is potion, 3 is wand
  private int itemType = 1;
  
  //height and width of window
  private int width = 0;
  private int height = 0;
  
  //shop takes a width and height value that should be the window size
  public Shop(int width, int height, Game game){
    this.game = game;
    this.width = width;
    this.height = height;
    try {
      shopImage = ImageIO.read(new File("shop.png"));
    } catch (IOException e) {
    }
    
  }
  
  //returns whether shop is on or off
  public boolean getShop(){
    return shopOn;
  }
  
  //turns shop on and off
  public void setShop(){
    shopOn = !shopOn;
  }
  
  //this currently only moves the white item box back and forth over the items
  public void keyPressed(KeyEvent e) {
    
    //only allows for the shops key presses to be used if shop is on the screen
    if(shopOn){
      if (e.getKeyCode() == KeyEvent.VK_SPACE){
        purchase(itemType);
      }
      
      if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
        
        setShop();
        
      }
      
      if (e.getKeyCode() == KeyEvent.VK_LEFT){
        
        //if the selection box is not on the armor it will move one item left
        if(selectX > 450){
          //the item selected is moved one box left
          itemType = itemType - 1;
          selectX = selectX-200;}
        else{
          selectX = 850;
          itemType = 3;
        }
      }
      if (e.getKeyCode() == KeyEvent.VK_RIGHT){
        //if the selection box is not on the wand it will move one item right
        if(selectX <850){
          //the item selected is moved one item to the right
          itemType = itemType +1;
          selectX = selectX+200;
        }
        else{
          selectX = 450;
          itemType = 1;
        }
      }
    }
  }
  public void updateGold(int x){
    //divide the cost into tens and ones then take those values from the onesGold and tensGold
    tensGold = (tensGold - (x/10));
    onesGold = (onesGold - (x%10));
    
  }
  
  
  //does the purchase of an item, subtracts gold cost and removes the item from the store
  public void purchase(int selectedItem){
    
    //checks to see which item is currently selected by user
    //later add checks for enough gold and if the item is in stock
    
    if((selectedItem == 1) && (!haveArmor)){
      if(armorCost <= totalGold){
      totalGold = totalGold - armorCost;
      updateGold(armorCost);
      haveArmor = true;
      }
    }
    
    if((selectedItem == 2) && (!havePotion)){
      if(armorCost <= totalGold){
      totalGold = totalGold - potionCost;
     updateGold(potionCost);
      havePotion = true;
      }
    }
    
    if((selectedItem == 3)&&(!haveWand)){
      if(armorCost <= totalGold){
      totalGold = totalGold - wandCost;
      updateGold(wandCost);
      haveWand = true;
      }
      
    }
    
  }
  
  //returns which of the three items is selected in the shop
  public int shopItemSelected(){
    return itemType;
  }
  
  //paints shop
  @Override
  public void paint(Graphics g) {
      
    Graphics2D g2d = (Graphics2D) g;
    
    
    g.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
    
    //this is the gray background
    g2d.setColor(Color.GRAY);
    g2d.fillRect(0,0,1280,974);
    
    //this is the shop image made in paint
    g.drawImage(shopImage, 6, 200, null);
    
    
    
    //WHEN WE CREATE A METHOD THAT RETURNS HOW MUCH GOLD YOU HAVE WE NEED TO PUT IT HERE
    //getGold();
    //THE METHOD SHOULD RETURN HOW MUCH THE PERSON HAS THEN DIVIDE IT INTO TENS AND ONES
    
    g2d.setColor(Color.WHITE);
    
    g.drawString(String.valueOf(onesGold), 200, 730);
    g.drawString(String.valueOf(tensGold), 150, 730);
    //AFTER DIVIDING IT INTO TENS AND ONES HAVE AN IMAGE VARIABLE FOR TENS AND ONES THEN PAINT CORRESPONDING NUMBERS NEXT TO THE GOLD CIRCLE
    //USE THE DRAW STRING METHOD IN THE PAINT CLASS THING TO MAKE THE NUMBERS FOR THE GOLD COUNTER PLEASE
    //if you have armor a potion or a wand it paints over that item in the shop and prevents you from buying more
    
    g2d.setColor(Color.GRAY);
    if(haveArmor){
      g2d.fillRect(440,225,150,150);
    }
    if(havePotion){
      g2d.fillRect(640,225,150,150);
    }
    if(haveWand){
      g2d.fillRect(840,225,150,150);
      
    }
    
    
    
    //this is the white box that surrounds the selectd item
    g2d.setColor(Color.WHITE);
    g2d.drawRect(selectX, 225, 150, 150);
    
    
  }
}