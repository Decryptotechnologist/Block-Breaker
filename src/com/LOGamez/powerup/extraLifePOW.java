/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.powerup;

import com.LOGamez.blockbreaker.Game;
import com.LOGamez.graphics.*;
import com.LOGamez.block.Block;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ghomez
 */
public class extraLifePOW extends POW {
    
    /**Attributes*/
    
    /**animExLife variable of extraLifePOW*/
    private static final Animation animExLife = new Animation(8, 
        new Texture("/Sprites/Breakout-Sprite-Paddle-RED_128"), 
        new Texture("/Sprites/Breakout-Sprite-Paddle-GREEN_128"), 
        new Texture("/Sprites/Breakout-Sprite-Paddle-GOLD_128")
    );
    
    /**extraLifeTxtFont variable of extraLifePOW*/
    private static final Font extraLifeTxtFont = new Font("Times New Roman", Font.PLAIN, 12);
    
    /**extraLifeTxtCol variable of extraLifePOW*/
    private static Color extraLifeTxtCol = Color.decode("#00FF22");
    
    /**extraLifeTxtX variable of extraLifePOW*/
    private static int extraLifeTxtX;
    
    /**extraLifeTxtY variable of extraLifePOW*/
    private static int extraLifeTxtY;
    
    /**extraLifeTxt variable of extraLifePOW*/
    private static final String extraLifeTxt = "1UP";
    
    
    
    
    
    
    /**Constructor*/
    
    /**
     * Initialises a new extraLifePOW object
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param isDead
     * @param vis
     * @param suit
     */
    public extraLifePOW(int x, int y, int width, int height, boolean isDead, boolean vis, int suit){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isDead = isDead;
        this.visible = vis;
        this.suit = suit;
        speed = 5;
//        this.col = BlockBreaker.colours[5].getRGB();
    }
    
    
    /**
     * init(Block bl1)
     * 
     * init is used to initiate extraLifePOW objects
     * 
     * @param bl1
     */
    public static void init(Block bl1){
        extraLifePOW pow = new extraLifePOW((int) bl1.x + random.nextInt(5), (int) bl1.y, pow_w, pow_h, false, true, 4);
	extraLifePOWz.add(pow);      
    }
    
    
    /**
    * tick()
    * 
    * Updates extraLifePOW Objects
    */
    public static void tick(){
        extraLifePOWz = extraLifePOW.getAll();
    
        animExLife.run();
    }
    
    
    /**
    * render()
    * 
    * Renders/Repaints extraLifePOW Objects
    * 
    * @param g2d
    */
    public static void render(Graphics2D g2d){
        Graphics2D g2d_extraLifePOW = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        if(null == Game.aGame.menu){
            for (extraLifePOW pow : extraLifePOWz) {
                if(pow.isDead == false){
                    animExLife.render(g2d, pow.x, pow.y, pow.width, pow.height);
                    
                    extraLifeTxtX = pow.x + pow.width/2 - 10;
                    extraLifeTxtY = pow.y - 4;
                    g2d_extraLifePOW.setFont(extraLifeTxtFont);
                    g2d_extraLifePOW.setColor(extraLifeTxtCol);
                    g2d_extraLifePOW.drawString(extraLifeTxt, extraLifeTxtX, extraLifeTxtY);
                }
            }
        }
        
        g2d.setTransform(oldXForm);
        g2d_extraLifePOW.setTransform(oldXForm);
    }
    
    
    /**
    * move(extraLifePOW p)
    * 
    * Moves each of the extraLifePOW objects (depending how
    * many extraLifePOW objects remain in extraLifePOWz List) 
    * after checking that the extraLifePOW object isDead 
    * value is false and visible value is true.
    * 
    * @param p the p reference of an extraLifePOW object (within extraLifePOWz List)
    */
    public static void move(extraLifePOW p){
        p.y += speed;
    }

    
    /**
    * POWHit(extraLifePOW p1)
    * 
    * Fires an Star Explosion, creating a new starExplode object with Star
    * objects (referenced by id) x and y coordinates as a reference point via
    * starExplode.StrXDetonate() message?
    *
    * Following this Star objects (referenced by id) visible and isDead
    * values are changed to false and true respectively.
    *
    * @param p1 the p1 reference of an Star object (within stars List)
    */
    public static void POWHit(extraLifePOW p1){
	p1.visible = false;
	p1.isDead = true;
        
        //set Player1 power-up
        //Player.setPOW(p1.suit);
    }
    
    
    /**
    * getAll()
    * 
    * Returns the List of the POW objects referenced by POWz
    *
    * @return POWz
    */
    public static List<extraLifePOW> getAll() {
        extraLifePOWzA = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < extraLifePOWz.size(); i++) {
            if (extraLifePOWz.get(i).isDead == false) {
                extraLifePOWzA.add(j, extraLifePOWz.get(i));
                
                j++;
            }
        }
        
        return extraLifePOWzA;
    }

    
    /**
    * clearAll()
    * 
    * Clears the List of the POW and Rectangle objects 
    * referenced by POWz and POWzRect
    *
    */
    public static void clearAll() {
        extraLifePOWz.clear();
    }
    
    
    /**
    * getBounds()
    * 
    * returns Bounds of the EnExplode objects
    * 
    * @return new Rectangle(this.x, this.y, this.width, this.height)
    */ 
    @Override
    public Rectangle getBounds(){
      return new Rectangle(this.x, this.y, this.width, this.height);
    }
    
}
