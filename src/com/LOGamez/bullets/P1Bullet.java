package com.LOGamez.bullets;

import com.LOGamez.audio.Sound;
import com.LOGamez.graphics.*;
import com.LOGamez.blockbreaker.*;
import java.awt.*;
import java.util.List;
import com.LOGamez.player.Player;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * P1Bullet objects represent Player 1 bullets in the game
 * represented by a small white square shape bullets
 *  fired by the player. 
 * 
 * @author(s) Ghomez
 */
public class P1Bullet extends Bullet {

    
    /**Attributes*/                                      
    
    /**p1BullIMG BufferedImage of P1Bullet object*/
    private static final BufferedImage p1BullIMG = new Texture("/Sprites/SI_PlayerBullet0_1").getImage();


    /**Constructor*/
        
    /**
    * P1Bullet(int x, int y, int h, int w, boolean isDead)
    * 
    * Initialises a new P1Bullet object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w, this.visible 
    * set to vis
    * 
    * @param x - the x coordinate of P1Bullet
    * @param y - the y coordinate of P1Bullet
    * @param h - the height of P1Bullet
    * @param w - the width of P1Bullet
    * @param isDead - the isDead boolean of P1Bullet
    */
    public P1Bullet(int x, int y, int h, int w, boolean isDead){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.isDead = isDead;
    }

    /**
     * setUp()
     * 
     */
    public static void setUp(){
        int width = BlockBreaker.getMainWidth();
        switch(width){
            case 300:
                playerBulletScale = 0.225;
                playerBulletXoffs = (64/8)-1;
                playerBulletYoffs = -3;
            
                break;
                
            case 480:
                playerBulletScale = 0.45;
                playerBulletXoffs = -15;
                playerBulletYoffs = 6;
                
                break;
                
            case 604:
                playerBulletScale = 0.45;
                playerBulletXoffs = 64;//(64/2)-12;
                playerBulletYoffs = 16;
                
                break;
                
            default:
                playerBulletScale = 0.45;
                playerBulletXoffs = 64;//(64/2)-12;
                playerBulletYoffs = 16;
                
                break;
                
        }
        
    }
    
    /**
    * FireP1(Player player)
    * 
    * Fires a bullet, creating a new P1Bullet 
    * object with Player 1 objects x and y 
    * coordinates as a starting point
    * 
    * @param player - a reference to a Player object
    */
    public static void FireP1(Player player){
        P1Bullet p1b;
        //P1Bullet p1b1;
        //P1Bullet p1b2;
        
//        if(Player.suit == 1){
//            p1b = new P1Bullet((int) player.x+Bullet.playerBulletXoffs, (int) player.y+Bullet.playerBulletYoffs, w, h, false);
//            p1b1 = new P1Bullet((int) player.x+Bullet.playerBulletXoffs-32, (int) player.y+Bullet.playerBulletYoffs, w/2, h/2, false);
//            p1b2 = new P1Bullet((int) player.x+Bullet.playerBulletXoffs+32, (int) player.y+Bullet.playerBulletYoffs, w/2, h/2, false);
//            
//            P1B.add(p1b);
//            P1B.add(p1b1);
//            P1B.add(p1b2);
//            
//            if(Game.getGameSound()){
//                Sound.P1ShootCannon.play();
//            }
//        } else {
            p1b = new P1Bullet((int) player.x+32, (int) player.y+Bullet.playerBulletYoffs, w, h, false);
            P1B.add(p1b);
        //}
        
        if(Game.getGameSound()){
            Sound.P1Shoot.play();
        }
        Game.paddle.isFiring = false;
    }

    
    /**
    * move(int id)
    * 
    * Moves each of the P1Bullet objects (depending how
    * many P1Bullet objects remain in P1Bulletz List) 
    * after checking that the P1Bullet object isDead 
    * value is false and visible value is true.
    * 
    * @param pB the pB reference of an P1Bullet object (within P1Bulletz List)
    */  
    public static void move(P1Bullet pB){
        if(pB.isDead == false){
            if(pB.y < BlockBreaker.getMainHeight()){
                pB.y -= bulletSpeed;
            }
        } else {
            P1BHit(pB);
        }
    }

    
    /**
    * P1BHit(P1Bullet pB)
    * 
    * P1Bullet objects (referenced by id) 
    * visible and isDead values are changed to false 
    * and true respectively. Before this a P1BDetonate(id) 
    * message is sent
    * 
    * @param pB the pB reference of an P1Bullet object (within P1Bulletz List)
    */
    public static void P1BHit(P1Bullet pB){
	//P1BExplode.P1BDetonate(pB);
	pB.isDead = true;
    }

    
    /**
    * tick()
    * 
    * Updates P1Bullet Objects
    */
    public static void tick(){
        P1B = P1Bullet.getAll();
    }
    
    
    /**
     * render(Graphics2D g2d)
     * 
     * 
     * @param g2d
     */
    public static void render(Graphics2D g2d){
        Graphics2D g2d_P1Bullet = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        if(Game.getGame().menu == null){
            //Draw P1Bullets
            for (P1Bullet P1B1 : P1B) {
                if (P1B1.isDead == false) {
                    g2d_P1Bullet.drawImage(p1BullIMG, P1B1.x, P1B1.y, P1B1.width, P1B1.height*2, null);
                    if(Game.showBounds){
                        g2d_P1Bullet.setColor(Color.green);
                        g2d_P1Bullet.drawRect(P1B1.x+13, P1B1.y+P1B1.height-8, P1B1.width/4, P1B1.height);
                    }
                }
            }            
        }
        
        g2d.setTransform(oldXForm);
        g2d_P1Bullet.setTransform(oldXForm);
    }
    
    
    /**
    * getAll()
    * 
    * Returns the List of the P1Bullet 
    * objects referenced by P1Bulletz
    * 
    * @return P1Bulletz
    */
    public static List<P1Bullet> getAll() {
        P1BA = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < P1B.size(); i++) {
            if (P1B.get(i).isDead == false) {
                P1BA.add(j, P1B.get(i));
                
                j++;
            }
        }
        
	return P1B;
    }

    
    
    /**
    * clearAll()
    * 
    */
    public static void clearAll() {
        P1B.clear();
    }
    
    
    /**
     * getBounds()
     * 
     * @return new Rectangle(this.x, this.y, this.width, this.height)
     */
    public Rectangle getBounds(){
      return new Rectangle(this.x+13, this.y+this.height-8, this.width/4, this.height);
    }
    
}
