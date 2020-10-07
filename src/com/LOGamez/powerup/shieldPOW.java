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
 * @author Ghomez
 * 
 */
public class shieldPOW extends POW {
    
    /**Attributes*/
    
    /**animShield variable of shieldPOW object */
    private static final Animation animShield = new Animation(1, 
        new Texture("/Sprites/SI_shPOWT1_0a"), 
        new Texture("/Sprites/SI_shPOWT1_1a"), 
        new Texture("/Sprites/SI_shPOWT1_2a")
    );
    
    
    /**Constructor*/
    
    /**
     * shieldPOW(int x, int y, int width, int height, boolean isDead, boolean vis, int suit)
     * 
     * Initialises a new shieldPOW object
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param isDead
     * @param vis
     * @param suit
     */
    public shieldPOW(int x, int y, int width, int height, boolean isDead, boolean vis, int suit){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isDead = isDead;
        this.visible = vis;
        this.suit = suit;
        this.speed = 7;
    }
    
    
    /**
     * init(Block bl1)
     * 
     * initiates shieldPOW objects
     * 
     * @param bl1
     */
    public static void init(Block bl1){
        shieldPOW pow = new shieldPOW((int) bl1.x + random.nextInt(5), (int) bl1.y, pow_w, pow_h, false, true, 2);
	shieldPOWz.add(pow);      
    }
    
    
    /**
    * tick()
    * 
    * Updates All shieldPOW Objects
    */
    public static void tick(){
        shieldPOWz = shieldPOW.getAll();
        
        animShield.run();
    }
    
    
    /**
    * render()
    * 
    * Renders/Repaints shieldPOW Objects
    * 
    * @param g
    */
    public static void render(Graphics2D g){
        if(null == Game.aGame.menu){
            for(shieldPOW pow : shieldPOWz) {
                if(pow.isDead == false){ 
                    animShield.render(g, pow.x, pow.y, pow.width, pow.height);    
                }
            }
        }    
    }
    
    
    /**
    * move(shieldPOW p)
    * 
    * Moves each of the POW objects (depending how
    * many POW objects remain in POWz List) 
    * after checking that the POW object isDead 
    * value is false and visible value is true.
    * 
    * @param p the p reference of an POW object (within POWz List)
    */
    public static void move(shieldPOW p){
        p.y += speed;
    }

    
    /**
    * POWHit(shieldPOW p)
    * 
    * shieldPOW objects (referenced by id) visible and isDead
    * values are changed to false and true respectively.
    *
    * @param p the p reference of an shieldPOW object
    */
    public static void POWHit(shieldPOW p){
	p.visible = false;
	p.isDead = true;
        
        //set Player1 power-up
        Player.setPOW(p.suit);
    }
    
    
    /**
    * getAll()
    * 
    * Returns the List of the POW objects referenced by POWz
    *
    * @return POWz
    */
    public static List<shieldPOW> getAll() {
        shieldPOWzA = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < shieldPOWz.size(); i++) {
            if (shieldPOWz.get(i).isDead == false) {
                shieldPOWzA.add(j, shieldPOWz.get(i));
                
                j++;
            }
        }
        
        return shieldPOWzA;
    }
    

    /**
    * clearAll()
    * 
    * Clears the List of the POW referenced by POWz
    *
    */
    public static void clearAll() {
        shieldPOWz.clear();
    }
    
    
    /**
    * getBounds()
    * 
    * returns Bounds of the sheildPOW objects
    * 
    * @return new Rectangle(this.x, this.y, this.width, this.height)
    */ 
    @Override
    public Rectangle getBounds(){
      return new Rectangle(this.x, this.y, this.width, this.height);
    }
    
}
