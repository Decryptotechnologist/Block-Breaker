/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.graphics;


import com.LOGamez.blockbreaker.Game;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Ghomez
 */
public class Texture {
    
    /**Attributes*/
    
    /**texMap Map<String, BufferedImage> of Texture object*/
    static Map<String, BufferedImage> texMap = new HashMap<String, BufferedImage>();
    
    /**renMap Map<String, Render> of Texture object*/
    static Map<String, Render> renMap = new HashMap<String, Render>();
    
    /**Attributes*/
    static Render render;
    
    /**Attributes*/
    static String renderFileName;
    
    /**Attributes*/
    static int renWidth;
    
    /**Attributes*/
    static int renHeight;
    
    /**Attributes*/
    static BufferedImage renIMG;
    
    /**Attributes*/
    BufferedImage img;
    
    /**Attributes*/
    String fileName;
    
    /**Attributes*/
    String filePath;
    
    /**Attributes*/
    static int width;
    
    /**Attributes*/
    static int height;
    
    
    //public static final Render p1 = loadBitmap("/Sprites/player1a.png");
    
    //public static final Render spriteSheet1 = loadBitmap("/Sprites/GD1-spriteSheet-1.png");
    
    /**fonts Render of Texture object*/
    public static Render fonts = loadBitmap("/Sprites/font2018.png");
    
    /**credits0 Render of Texture object*/
    public static Render creditsBlank = loadBitmap("/menu/credits/credits_Blank.png");
    
    /**creditsPublisher Render of Texture object*/
    public static Render creditsPublisher = loadBitmap("/menu/credits/credits_Publisher.png");
    
    /**creditsPublisherBlank Render of Texture object*/
    public static Render creditsPublisherBlank = loadBitmap("/menu/credits/credits_Publisher_Blank.png");
    
    /**credits0 Render of Texture object*/
    public static Render credits0 = loadBitmap("/menu/credits/credits_Director.png");
    
    /**credits1 Render of Texture object*/
    public static Render credits1 = loadBitmap("/menu/credits/credits_Producer.png");
    
    /**credits2 Render of Texture object*/
    public static Render credits2 = loadBitmap("/menu/credits/credits_Art_Director.png");
    
    /**credits3 Render of Texture object*/
    public static Render credits3 = loadBitmap("/menu/credits/credits_Lead_Programmer.png");
    
    /**credits4 Render of Texture object*/
    public static Render credits4 = loadBitmap("/menu/credits/credits_Snr_Game_Designer.png");
    
    /**credits5 Render of Texture object*/
    public static Render credits5 = loadBitmap("/menu/credits/credits_Lead_QA_Tester.png");
    
    /**credits6 Render of Texture object*/
    public static Render credits6 = loadBitmap("/menu/credits/credits_Technical_Lead.png");
    
    /**credits7 Render of Texture object*/
    public static Render credits7 = loadBitmap("/menu/credits/credits_Environment_Artist.png");
    
    /**credits8 Render of Texture object*/
    public static Render credits8 = loadBitmap("/menu/credits/credits_Sound_Engineer.png");
    
    /**credits9 Render of Texture object*/
    public static Render credits9 = loadBitmap("/menu/credits/credits_Level_Designer.png");
    
    /**credits10 Render of Texture object*/
    public static Render credits10 = loadBitmap("/menu/credits/credits_GUI_Artist.png");
    
    
    /**creditsA0 Render of Texture object*/
    public static Render creditsA0 = loadBitmap("/menu/credits/credits_Director0.png");
    
    /**creditsA1 Render of Texture object*/
    public static Render creditsA1 = loadBitmap("/menu/credits/credits_Producer0.png");
    
    /**creditsA2 Render of Texture object*/
    public static Render creditsA2 = loadBitmap("/menu/credits/credits_Art_Director0.png");
    
    /**creditsA3 Render of Texture object*/
    public static Render creditsA3 = loadBitmap("/menu/credits/credits_Lead_Programmer0.png");
    
    /**creditsA4 Render of Texture object*/
    public static Render creditsA4 = loadBitmap("/menu/credits/credits_Snr_Game_Designer0.png");
    
    /**creditsA5 Render of Texture object*/
    public static Render creditsA5 = loadBitmap("/menu/credits/credits_Lead_QA_Tester0.png");
    
    /**creditsA6 Render of Texture object*/
    public static Render creditsA6 = loadBitmap("/menu/credits/credits_Technical_Lead0.png");
    
    /**creditsA7 Render of Texture object*/
    public static Render creditsA7 = loadBitmap("/menu/credits/credits_Environment_Artist0.png");
    
    /**creditsA8 Render of Texture object*/
    public static Render creditsA8 = loadBitmap("/menu/credits/credits_Sound_Engineer0.png");
    
    /**creditsA9 Render of Texture object*/
    public static Render creditsA9 = loadBitmap("/menu/credits/credits_Level_Designer0.png");
    
    /**creditsA10 Render of Texture object*/
    public static Render creditsA10 = loadBitmap("/menu/credits/credits_GUI_Artist0.png");
    
    
    /**creditsB0 Render of Texture object*/
    public static Render creditsB0 = loadBitmap("/menu/credits/credits_Director1.png");
    
    /**creditsB1 Render of Texture object*/
    public static Render creditsB1 = loadBitmap("/menu/credits/credits_Producer1.png");
    
    /**creditsB2 Render of Texture object*/
    public static Render creditsB2 = loadBitmap("/menu/credits/credits_Art_Director1.png");
    
    /**creditsB3 Render of Texture object*/
    public static Render creditsB3 = loadBitmap("/menu/credits/credits_Lead_Programmer1.png");
    
    /**creditsB4 Render of Texture object*/
    public static Render creditsB4 = loadBitmap("/menu/credits/credits_Snr_Game_Designer1.png");
    
    /**creditsB5 Render of Texture object*/
    public static Render creditsB5 = loadBitmap("/menu/credits/credits_Lead_QA_Tester1.png");
    
    /**creditsB6 Render of Texture object*/
    public static Render creditsB6 = loadBitmap("/menu/credits/credits_Technical_Lead1.png");
    
    /**creditsB7 Render of Texture object*/
    public static Render creditsB7 = loadBitmap("/menu/credits/credits_Environment_Artist1.png");
    
    /**creditsB8 Render of Texture object*/
    public static Render creditsB8 = loadBitmap("/menu/credits/credits_Sound_Engineer1.png");
    
    /**creditsB9 Render of Texture object*/
    public static Render creditsB9 = loadBitmap("/menu/credits/credits_Level_Designer1.png");
    
    /**creditsB10 Render of Texture object*/
    public static Render creditsB10 = loadBitmap("/menu/credits/credits_GUI_Artist1.png");
    
    
    /**creditsLightening Render of Texture object*/
    public static Render creditsLightening = loadBitmap("/menu/credits/lighteningA0.png");
    
    /**creditsLightening0 Render of Texture object*/
    public static Render creditsLightening0 = loadBitmap("/menu/credits/lightening1.png");
    
    /**creditsLightening1 Render of Texture object*/
    public static Render creditsLightening1 = loadBitmap("/menu/credits/lightening2.png");
    
    /**creditsLightening Render of Texture object*/
    public static Render creditsLightening2 = loadBitmap("/menu/credits/lightening3.png");
    
    /**creditsLightening0 Render of Texture object*/
    public static Render creditsLightening3 = loadBitmap("/menu/credits/lightening4.png");
    
    /**creditsLightening1 Render of Texture object*/
    public static Render creditsLightening4 = loadBitmap("/menu/credits/lightening5.png");
    
    /**SI2015Logo Render of Texture object*/
    public static Render SI2015Logo = loadBitmap("/menu/credits/SI2015-Logo2018.png");
    
    /**buttonsA Render of Texture object*/
    public static Render buttonsA = loadBitmap("/menu/credits/Buttons2018.png");
    
    /**Links*/
    
    
    
    /**Constructor*/
    
    /**
     * Texture Constructor
     * 
     * 
     * @param fileName
     */
    public Texture(String fileName){
        this.fileName = fileName;
        this.filePath = "res"+fileName+".png";
        BufferedImage oldTex = texMap.get(fileName);
        if(oldTex != null){
            this.img = oldTex;
        } else {
            try {
                System.out.println("Texture: Loading Texture: "+Game.textCount+": "+fileName);
                this.img = ImageIO.read(Texture.class.getResource(fileName+".png"));
                texMap.put(fileName, img);
                Game.textCount++;
            } catch (IOException e){
                Logger.getLogger(Texture.class.getName()).log(Level.SEVERE, null, e);
            }
            
            this.width = img.getWidth();
            this.height = img.getHeight();
               
        }
        
    }
    
    /**
    * render(Graphics2D g, int x, int y, int width, int height)
    * 
    * Renders/Repaints Texture Objects
    * 
    * @param g
    * @param x - the x variable Texture object
    * @param y - the y variable Texture object
    * @param width - the width variable Texture object
    * @param height - the height variable Texture object
    */
    public void render(Graphics2D g, int x, int y, int width, int height){
        g.drawImage(img, x, y, width, height, null);
    }
    
    
    /**
    * render(Graphics2D g, int x, int y, int width, int height, Color col)
    * 
    * Renders/Repaints Texture Objects
    * 
    * @param g
    * @param x - the x variable Texture object
    * @param y - the y variable Texture object
    * @param width - the width variable Texture object
    * @param height - the height variable Texture object
    * @param col - the color variable Texture object
    */
    public void render(Graphics2D g, int x, int y, int width, int height, Color col){
        g.drawImage(img, x, y, width, height, col, null);
    }
    
    
    public static Render loadBitmap(String fileName){
        renderFileName = fileName;
        
        Render oldRen = renMap.get(fileName);
        if(oldRen != null){
            render = oldRen;
        } else {
            try {
                System.out.println("Texture: Loading Render: "+Game.renderCount+": "+renderFileName);
                renIMG = ImageIO.read(Texture.class.getResource(renderFileName));
                renWidth = renIMG.getWidth();
                renHeight = renIMG.getHeight();
                render = new Render(renWidth, renHeight);
                renIMG.getRGB(0, 0, renWidth, renHeight, render.pixels, 0, renWidth);
                for(int i = 0; i < render.pixels.length; i++){
                    int in = render.pixels[i];
                    int col = (in & 0xf) >> 2;
                    if(in == 0xffff00ff){
                        col = -1;
                    }
                    render.pixels[i] = col;
                }
                renMap.put(renderFileName, render);
                Game.renderCount++;
            } catch (IOException e){
                Logger.getLogger(Texture.class.getName()).log(Level.SEVERE, null, e);
            }
               
        }
        return renMap.get(renderFileName);
    }
    
    
    /**
     * getImage()
     * 
     * @return img
     */
    public BufferedImage getImage(){
        return img;
    }
    
    /**
     * clearMaps()
     * 
     */
    public static void clearMaps() {
        texMap.clear();
        renMap.clear();
    }
    
}
