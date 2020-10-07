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
public class speedPOW extends POW {
    
    /**Attributes*/
    
    /**animSpeed variable of speedPOW object */
    private static final Animation animSpeed = new Animation(1, 
        new Texture("/Sprites/SI_spPOWT1_0a"), 
        new Texture("/Sprites/SI_spPOWT1_1a"), 
        new Texture("/Sprites/SI_spPOWT1_2a")
    );
    
    
    
    
    /**Constructor*/
    
    /**
     * Initialises a new speedPOW object
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param isDead
     * @param vis
     * @param suit
     */
    public speedPOW(int x, int y, int width, int height, boolean isDead, boolean vis, int suit){
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
     * initiates speedPOW objects
     * 
     * @param bl1
     */
    public static void init(Block bl1){
        speedPOW pow = new speedPOW((int) bl1.x + random.nextInt(5), (int) bl1.y, pow_w, pow_h, false, true, 3);
	speedPOWz.add(pow);       
    }
    
    
    /**
    * tick()
    * 
    * Updates speedPOW Objects
    */
    public static void tick(){
        speedPOWz = speedPOW.getAll();
        
        animSpeed.run();
    }
    
    
    /**
    * render()
    * 
    * Renders/Repaints speedPOW Objects
    * 
    * @param target
    * @param g
    */
    public static void render(Graphics2D g){
        if(null == Game.aGame.menu){
            for (POW pow : speedPOWz) {
                if(pow.isDead == false){ 
                    animSpeed.render(g, pow.x, pow.y, pow.width, pow.height);
                }
            }
        }    
    }
    
    
    /**
    * move(speedPOW p)
    * 
    * Moves each of the speedPOW objects (depending how
    * many speedPOW objects remain in speedPOWz List) 
    * after checking that the speedPOW object isDead 
    * value is false and visible value is true.
    * 
    * @param p the p reference of an speedPOW object (within speedPOWz List)
    */
    public static void move(speedPOW p){
        p.y += speed;
    }

    
    /**
    * POWHit(speedPOW p)
    * 
    * speedPOW objects (referenced by id) visible and isDead
    * values are changed to false and true respectively.
    *
    * @param p the p reference of an speedPOW object
    */
    public static void POWHit(speedPOW p){
	p.visible = false;
	p.isDead = true;
        
        //set Player1 power-up
        Player.setPOW(p.suit);
    }
    
    
    /**
    * getAll()
    * 
    * Returns the List of the speedPOW objects referenced by speedPOWz
    *
    * @return speedPOWzA
    */
    public static List<speedPOW> getAll() {
        speedPOWzA = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < speedPOWz.size(); i++) {
            if (speedPOWz.get(i).isDead == false) {
                speedPOWzA.add(j, speedPOWz.get(i));
                
                j++;
            }
        }
        
        return speedPOWzA;
    }
    

    /**
    * clearAll()
    * 
    * Clears the List of the POW and Rectangle objects 
    * referenced by POWz and POWzRect
    *
    */
    public static void clearAll() {
        speedPOWz.clear();
    }
    
    
    /**
    * getBounds()
    * 
    * returns Bounds of the speedPOW objects
    * 
    * @return new Rectangle(this.x, this.y, this.width, this.height)
    */ 
    @Override
    public Rectangle getBounds(){
      return new Rectangle(this.x, this.y, this.width, this.height);
    }
    
}
