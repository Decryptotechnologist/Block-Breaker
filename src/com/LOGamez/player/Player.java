/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.player;

import com.LOGamez.graphics.Texture;
import com.LOGamez.blockbreaker.Game;
import com.LOGamez.audio.Sound;
import com.LOGamez.ball.Ball;
import com.LOGamez.bullets.P1Bullet;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.vecmath.Vector2d;

/**
 *
 * @author Ghomez
 */
public class Player {

    /**Attributes*/
    
    /**x variable of Player*/
    public int x;
    
    /**y variable of Player*/
    public int y;
    
    /**dx variable of Player*/
    double dx;
    
    /**dy variable of Player*/
    double dy;
    
    /**Pwidth variable of Player*/
    public int Pwidth;
    
    /**Pheight variable of Player*/
    public int Pheight;
    
    /**lives variable of Player*/
    public static int lives;
    
    /**startLives variable of Player*/
    int startLives;
    
    /**LALCount variable of Player*/
    int LALCount;
    
    /**levelNo variable of Player*/
    public static String levelNo;
    
    /**livesNo variable of Player*/
    public static String livesNo;
    
    /**P1Rect variable of Player*/
    public Rectangle P1Rect;
    
   /**LEFTSIDE variable of Player*/
    public Rectangle LEFTSIDE;
    
    /**CENTRESIDE variable of Player*/
    public Rectangle CENTRESIDE;
    
    /**RIGHTSIDE variable of Player*/
    public Rectangle RIGHTSIDE;
    
    /**moveSpeed variable of Player*/
    public static int moveSpeed;
    
    /**isFiring variable of Player*/
    public boolean isFiring;
    
    /**isDead variable of Player*/
    boolean isDead;
    
    /**mouseLeft variable of Player*/
    public static boolean mouseLeft;
    
    /**mouseRight variable of Player*/
    public static boolean mouseRight;
    
    /**mouseFire variable of Player*/
    public static boolean mouseFire;
    
    /**playerImg variable of Player*/
    BufferedImage playerImg;
    
    /**pLivesImg variable of Player*/
    BufferedImage pLivesImg;
    
    /**imgP1 variable of Player*/
    BufferedImage imgP1;
    
    /**imgPLives variable of Player*/
    public static BufferedImage imgPLives;
    
    /**playerName variable of Player*/
    public static String playerName;
    
    /**playerImg0 variable of Player*/
    private final BufferedImage playerImg0;
    
    /**playerImg1 variable of Player*/
    private final BufferedImage playerImg1;
    
    /**playerImg2 variable of Player*/
    private final BufferedImage playerImg2;
    
    /**turbulance variable of Player*/
    private double turbulance = 0.35;
    
    /**pAngle variable of Player*/
    double pAngle;
    
    /**currentVec variable of Player*/
    public Vector2d currentVec;
    
    /**suit variable of Player*/
    public static int suit;
    
    /**power variable of Player*/
    public static int power;
    
    /**playScore variable of Player*/
    private String playScore;
    
    /**shotsFired variable of Player*/
    private static int shotsFired;


    
    /**Links*/
    
    /**ball Ball of Player*/
    public static Ball ball;
    
    
    
    
    
    /**Constructor*/
    
    /**
     * Player Constructor
     * 
     * 
     * @param x
     * @param y
     * @param w
     * @param h
     * @param name
     * @param Lives
     */
    public Player(int x, int y, int w, int h, String name, int Lives) {
        System.out.println("Player: New Player Created");
        this.x = x;
        this.y = y;
        this.currentVec = new Vector2d(this.x, this.y);
        this.Pwidth = w;
        this.Pheight = h;
        playerName = name;
        lives = Lives;
        this.startLives = lives;
        this.LALCount = 0;
        shotsFired = 0;
        this.P1Rect = new Rectangle(x, y, w, h);
        power = 0;
        suit = power;
        
        LEFTSIDE = new Rectangle(x, y, w/2, h);
        CENTRESIDE = new Rectangle(x + w/4, y, w/2, h);
        RIGHTSIDE = new Rectangle(x + (w/4 * 3), y, w/2, h);
        
        moveSpeed = 10;
        this.pAngle = 0.0;
        isFiring = false;
        
        pLivesImg = new Texture("/Sprites/Breakout-Sprite-Paddle-RED_128").getImage();
        playerImg = new Texture("/Sprites/Breakout-Sprite-Paddle-RED_128").getImage();
        playerImg0 = new Texture("/Sprites/Breakout-Sprite-Paddle-GREEN_128").getImage();
        playerImg1 = new Texture("/Sprites/Breakout-Sprite-Paddle-GOLD_128").getImage();
        playerImg2 = new Texture("/Sprites/Breakout-Sprite-Paddle-BLUE_128").getImage();
    }
    
    
    
    
    /**Public Protocol*/
    
    
    /**
     * resetPlayer()
     * 
     */
    private static void resetPlayer() {
        Game.paddle.x = Game.gameWidth/2 + 10;
        Game.paddle.P1Rect.x = Game.gameWidth/2 + 10;
        Game.paddle.LEFTSIDE.x = Game.paddle.x;
        Game.paddle.CENTRESIDE.x = Game.paddle.x + Game.paddle.CENTRESIDE.width/4;
        Game.paddle.RIGHTSIDE.x = Game.paddle.x + Game.paddle.Pwidth/4 * 3;
        Game.paddle.isFiring = false;
        
        Ball.init();
    }
    
    
    /**
     * increasePlayerLives(int i)
     * 
     * @param i
     */
    public void increasePlayerLives(int i) {
        lives += i;
    }
    
    /**
     * render(Game game, Graphics2D g2d)
     *
     * @param g2d
     */
    public void render(Graphics2D g2d){
        Graphics2D g2d_Player = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        //Draw Player
        if(this.isDead == false){
//            g2d_Player.translate(x + Pwidth/2, y + Pheight/2);
//            g2d_Player.rotate(Math.toRadians(pAngle));
//            g2d_Player.translate(-Pwidth/2 - x, -Pheight/2 - y);

            if(suit == 2){ 
                g2d_Player.drawImage(imgP1, x, y-26, Pwidth+24, Pheight*5, null);
            } else {
                g2d_Player.drawImage(imgP1, x, y-26, Pwidth+12, Pheight*5, null);
            }
        
            if(Game.showBounds){
                g2d_Player.setColor(Color.red);
                g2d_Player.drawRect(P1Rect.x, P1Rect.y, P1Rect.width, P1Rect.height);
                
                g2d_Player.setColor(Color.DARK_GRAY);
                g2d_Player.drawRect(RIGHTSIDE.x, RIGHTSIDE.y, RIGHTSIDE.width, RIGHTSIDE.height);
                
                g2d_Player.setColor(Color.BLUE);
                g2d_Player.drawRect(LEFTSIDE.x, LEFTSIDE.y, LEFTSIDE.width, LEFTSIDE.height);
                
                g2d_Player.setColor(Color.black);
                g2d_Player.drawRect(CENTRESIDE.x, CENTRESIDE.y, CENTRESIDE.width, CENTRESIDE.height);
                
                g2d_Player.setColor(Color.green);
                g2d_Player.drawOval(P1Rect.x+1, P1Rect.y+1, P1Rect.width-2, P1Rect.height-2);
                
                g2d_Player.setColor(Color.orange);
                g2d_Player.drawLine(x + Pwidth/2, y, x + Pwidth/2, y+14);
                g2d_Player.drawLine(x, y + Pheight/2, x + 64, y + Pheight/2);
            }
            //g2d_Player.rotate(Math.PI/-pAngle);
        }
        
        g2d.setTransform(oldXForm);
        g2d_Player.setTransform(oldXForm);
    
    }
    
    /**
     * tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire)
     * 
     * 
     * @param game
     * @param up
     * @param down
     * @param left
     * @param right
     * @param fire
     */
    public void tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire){//, boolean rotLeft, boolean rotRight){
        
        //Load Player Lives Image
        imgPLives = pLivesImg;
        
        if(suit == 0){
            imgP1 = playerImg;
        } 
        if(suit == 1){
            imgP1 = playerImg0;
        }
        if(suit == 2){
            imgP1 = playerImg1;
        }
        if(suit == 3){
            imgP1 = playerImg2;
        }
        
        if(System.currentTimeMillis() / 20 % 10 == 0){
            //turbulance += 0.00015;//Low Turbulance
            //turbulance += 0.0015;//Mid Turbulance
            turbulance += 0.015;//Hi Turbulance
        } else {
            //turbulance -= 0.00015;//Low Turbulance
            //turbulance -= 0.0015;//Mid Turbulance
            turbulance -= 0.015;//Hi Turbulance
        }
        
        
        if(left){
            if(x > 4){
                dx -= moveSpeed;
                P1Rect.x -= moveSpeed;
                LEFTSIDE.x -= moveSpeed;
                RIGHTSIDE.x -= moveSpeed;
                CENTRESIDE.x -= moveSpeed;
                if(!ball.isLaunched){
                    ball.x -= moveSpeed;
                }
            }
        }
        
        if(right){
            if(x < game.getWidth() - 68){//width - 68
                dx += moveSpeed;
                P1Rect.x += moveSpeed;
                RIGHTSIDE.x += moveSpeed;
                CENTRESIDE.x += moveSpeed;
                LEFTSIDE.x += moveSpeed;
                if(!ball.isLaunched){
                    ball.x += moveSpeed;
                }
            }
        }
        
        if(fire){
            if(game.menu == null){
                if(isFiring == false){
                    ball.fire();
                    //isFiring = true;
                    if(suit == 1){
                        P1Bullet.FireP1(this);
                        isFiring = true;
                        shotsFired++;
                    }
                }
            }
        }
        
        
//        if(mouseLeft){
//            if(x > 4){
//                dx -= Game.MouseSpeed * 1.6;
//                P1Rect.x -= Game.MouseSpeed * 1.6;
//                RIGHTSIDE.x -= Game.MouseSpeed * 1.6;
//                CENTRESIDE.x -= Game.MouseSpeed * 1.6;
//                LEFTSIDE.x -= Game.MouseSpeed * 1.6;
//            }
//        }
        
//        if(mouseRight){
//            if(x < game.getWidth() - 68){
//                dx += Game.MouseSpeed * 1.6;
//                P1Rect.x += Game.MouseSpeed * 1.6;
//                RIGHTSIDE.x += Game.MouseSpeed * 1.6;
//                CENTRESIDE.x += Game.MouseSpeed * 1.6;
//                LEFTSIDE.x += Game.MouseSpeed * 1.6;
//            }
//        }
        
//        if(mouseFire){
//            if(game.menu == null){
//                if(isFiring == false){
//                    ball.fire();
//                    //isFiring = true;
//                    fire = false;
//                    if(suit == 1){
//                        P1Bullet.FireP1(this);
//                        isFiring = true;
//                        shotsFired++;
//                    }
//                }
//            }
//        }
        
        if(Player.lives == 0){
            dead();
        }
        lives = getLives();
        x += dx;
        y += dy;
        this.currentVec.x += dx;
        this.currentVec.y += dy;
        
        dx = 0;
        dy = 0;
        turbulance = 0;
        isFiring = false;
    }
    
    /**
     * getPlayScore()
     * 
     * @return playScore
     */
    public String getPlayScore() {
        return playScore;
    }

    /**
     * setPlayScore(String playScore)
     * 
     * @param playScore
     */
    public void setPlayScore(String playScore) {
        this.playScore = playScore;
    }
    
    public void P1Hit(){
        loseALife();
        if(LALCount < startLives){
            LALCount += 1;
        } else {
            LALCount = 0;
        }
    }
    
    public void loseALife(){
        if(LALCount < 1){
            if(lives >= 1){
                lives--;
                suit = 0;

                Game.paddle.resetPlayer();
                if(Game.getGameSound()){
                    Sound.P1Exp.play();
                }
            }
        }
    }
    
    /**
     * dead()
     * 
     */
    public void dead(){
        System.out.println("Player: GAME OVER!!!");
        isDead = true;
        Game.loseGame();
    }
    
    /**
     * getLives()
     * 
     * 
     * @return lives
     */
    public static int getLives() {
        return lives;
    }
    
    /**
    * setPLives(int i)
    * 
    * @param i
    */
    public static void setLives(int i) {
        lives = i;
    }
    
    /**
     * getShotsFired()
     * 
     * 
     * @return shotsFired
     */
    public static int getShotsFired() {
        return shotsFired;
    }
    
    
    /**
     * resetShotsFired()
     * 
     */
    public static void resetShotsFired() {
        shotsFired = 0;
    }
    
    
    /**
     * setPlayerName(String name)
     * 
     * 
     * @param name
     */
    public void setPlayerName(String name) {
        this.playerName = name;
    }
    
    
    /**
     * setBall(Ball b1)
     * 
     * 
     * @param b1
     */
    public static void setBall(Ball b1) {
        System.out.println("Setting new ball:"+b1.toString()+"Player Firing:"+Game.paddle.isFiring);
        if(ball != b1) ball = b1;
    }
    
    /**
    * setPOW(int i)
    * 
    * 
    * @param i
    */
    public static void setPOW(int i) {
        if(power < 4){
            power = i;
        } else {
            power = 0;
            if(getLives() < 3){
                Game.increaseGameLives(1);
            }
        }
        suit = power;
        if(suit == 3){
            moveSpeed = 26;
        } else {
            moveSpeed = 17;
        }
    }
    
    
    /**
    * getPOW()
    * 
    * 
    * @return power
    */
    public static int getPOW() {
        return power;
    }

    /**
    * extraLife()
    * 
    * Checks if LALCount is less than 1 then 
    * checks if live is greater than or equal 
    * to 1. As the checks pass lives is 
    * decremented by 1 and a P1Explode is 
    * fired via the P1Explode.P1Detonate(this) 
    * message.
    * 
    */
    public void extraLife(){
	lives++;
	
        setPOW(getPOW());
    }

}
