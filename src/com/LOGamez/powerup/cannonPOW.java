/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.powerup;

import com.LOGamez.blockbreaker.Game;
import com.LOGamez.graphics.*;
import com.LOGamez.block.Block;
import com.LOGamez.player.Player;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ghomez
 */
public class cannonPOW extends POW {
    
    /**Attributes*/
    
    /**animCannon variable of cannonPOW object */
    private static final Animation animCannon = new Animation(1, 
        new Texture("/Sprites/SI_cPOWT1_0a"), 
        new Texture("/Sprites/SI_cPOWT1_1a"), 
        new Texture("/Sprites/SI_cPOWT1_2a")
    );
    
    
    
    
    
    /**Constructor*/
    
    /**
     * Initialises a new cannonPOW object
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param isDead
     * @param vis
     * @param suit
     */
    public cannonPOW(int x, int y, int width, int height, boolean isDead, boolean vis, int suit){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isDead = isDead;
        this.visible = vis;
        this.suit = suit;
        this.speed = 6;
    }
    
    
    
    /**Public Protocol*/   
    
    /**
     * init(Block bl1)
     * 
     * init is used to initiate cannonPOW objects
     * 
     * @param bl1
     */
    public static void init(Block bl1){
        cannonPOW pow = new cannonPOW((int) bl1.x + random.nextInt(5), (int) bl1.y, pow_w, pow_h, false, true, 1);
	cannonPOWz.add(pow);        
    }
    
    
    /**
    * tick()
    * 
    */
    public static void tick(){
        cannonPOWz = cannonPOW.getAll();
        
        animCannon.run();
    }
    
    
    
    /**
     * render(Render target, Graphics2D g)
     * 
     * @param g
     */
    public static void render(Graphics2D g){
        if(null == Game.aGame.menu){
            for (POW pow : cannonPOWz) {
                if(pow.isDead == false){ 
                    animCannon.render(g, pow.x, pow.y, pow.width, pow.height);
                }
            }
        }    
    }
    
    
    /**
    * move(cannonPOW p)
    * 
    * Moves each of the POW objects (depending how
    * many POW objects remain in POWz List) 
    * after checking that the POW object isDead 
    * value is false and visible value is true.
    * 
    * @param p the p reference of an POW object (within POWz List)
    */
    public static void move(cannonPOW p){
        p.y += speed;
    }

    
    /**
    * POWHit(cannonPOW p1)
    * 
    * cannonPOW objects (referenced by id) visible and isDead
    * values are changed to false and true respectively.
    *
    * @param p1 the p1 reference of an cannonPOW object (within stars List)
    */
    public static void POWHit(cannonPOW p1){
	p1.visible = false;
	p1.isDead = true;
        
        //set Player1 power-up
        Player.setPOW(p1.suit);
    }
    
    
    /**
    * getAll()
    * 
    * Returns the List of the POW objects referenced by POWz
    *
    * @return POWz
    */
    public static List<cannonPOW> getAll() {
        cannonPOWzA = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < cannonPOWz.size(); i++) {
            if (cannonPOWz.get(i).isDead == false) {
                cannonPOWzA.add(j, cannonPOWz.get(i));
                
                j++;
            }
        }
        
        return cannonPOWzA;
    }
    
    
    /**
    * clearAll()
    * 
    * Clears the List of the POW and Rectangle objects 
    * referenced by POWz and POWzRect
    *
    */
    public static void clearAll() {
        cannonPOWz.clear();
    }
    
    /**
     * getBounds()
     * 
     * @return new Rectangle(this.x, this.y, this.width, this.height)
     */
    @Override
    public Rectangle getBounds(){
      return new Rectangle(this.x, this.y, this.width, this.height);
    }
    
}
