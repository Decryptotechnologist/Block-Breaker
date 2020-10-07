/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.ball;

import com.LOGamez.blockbreaker.BlockBreaker;
import com.LOGamez.blockbreaker.Game;
import com.LOGamez.audio.Sound;
import com.LOGamez.graphics.Texture;
import com.LOGamez.player.Player;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.vecmath.Vector2d;

/**
 *
 * @author Ghomez
 */
public class Ball {
    
    /**Attributes*/

    /**x variable of Ball*/
    public int x;
    
    /**y variable of Ball*/
    private int y;
    
    /**currentVec variable of Ball*/
    private Vector2d currentVec;
    
    /**Bwidth variable of Ball*/
    private int Bwidth;
    
    /**Bheight variable of Ball*/
    private int Bheight;
    
    /**type variable of Ball*/
    int type;
    
    /**moveSpeed variable of Ball*/
    private int moveSpeed;
    
    /**bAngle variable of Ball*/
    private double bAngle;
    
    /**aBallImg1 variable of Ball*/
    private static BufferedImage aBallImg1;
    
    /**ballList variable of Ball*/
    public static List<Ball> ballList = new ArrayList<>();
    
    /**ballList1 variable of Ball*/
    private static List<Ball> ballList1 = new ArrayList<>();
    
    /**b1 variable of Ball*/
    public static Ball b1;
    
    /**xdir variable of Ball*/
    public static int xdir;
    
    /**ydir variable of Ball*/
    public static int ydir;
    
    /**islaunched variable of Ball*/
    public boolean isLaunched;
    
    /**isDead variable of Ball*/
    private boolean isDead;
    
    /**dx variable of Ball*/
    public double dx;
    
    /**dy variable of Ball*/
    private double dy;
    
    /**col variable of Ball*/
    private int col;
    
    
    /**Links*/
    
    
    /**Constructor*/
    
    
    /**
     * Ball Constructor
     * 
     * 
     * @param type
     */
    public Ball(int type) {
        this.type = type;
    }
    
    
    /**
     * Ball Constructor
     * 
     * 
     * @param _x
     * @param _y
     * @param w
     * @param h
     * @param type
     * @param _col
     */
    public Ball(int _x, int _y, int w, int h, int type, int _col) {
        System.out.println("Ball: New Ball Created");
        this.x = _x;
        this.y = _y;
        this.currentVec = new Vector2d(this.x, this.y);
        this.Bwidth = w;
        this.Bheight = h;
        this.type = type;
        this.moveSpeed = 5;
        this.bAngle = -45.0;
        
        this.dx = 0;
        this.dy = 0;
        this.xdir = 1;
        this.ydir = -1;
        this.isLaunched = false;
        this.isDead = false;
        this.col = _col;
        
        if(col == 0){
            aBallImg1 = new Texture("/Sprites/Breakout-Sprite-Ball-GOLD_128").getImage();
        }
        
        if(col == 1){
            aBallImg1 = new Texture("/Sprites/Breakout-Sprite-Ball-GRAY_128").getImage();
        }
        
        if(col == 2){
            aBallImg1 = new Texture("/Sprites/Breakout-Sprite-Ball-GREEN_128").getImage();
        }
        
        if(col == 3){
            aBallImg1 = new Texture("/Sprites/Breakout-Sprite-Ball-RED_128").getImage();
        }
        
//        resetState();
    }
    
    
    
    
    /**Public Protocol*/
    
    /**
     * move(Ball b)
     * 
     * 
     * @param b
     */
    public static void move(Ball b){
        if(b.isLaunched){
            b.dx += xdir;
            b.dy += ydir;
            b.x += xdir;
            b.y += ydir;
        }
    }

    
    /**
     * resetState()
     * 
     */
    public void resetState(){
        
        fire();
    }
    
    /**
     * launchBall()
     * 
     */
    public static void launchBall(){
        System.out.println("Launching ball:"+b1.toString());
        if(b1.isDead || b1 == null){
            if(Player.getLives() > 0){
                b1 = new Ball(BlockBreaker.getMainWidth()/2 + 10, BlockBreaker.getMainHeight() - 80, 16, 16, 1, 0);
                ballList.add(b1);
                Player.setBall(b1);
            }
        } else {
            Player.setBall(b1);
        }
        b1.isLaunched = true;
    }

    
    /**
     * setXDir()
     * 
     * @param x 
     */
    public static void setXDir(int x){
      xdir = x;      
    }

    
    /**
     * setYDir()
     * 
     * @param y 
     */
    public static void setYDir(int y){
      ydir = y;
    }
    

    /**
     * getYDir()
     * 
     * @return 
     */
    public static int getYDir(){
      return ydir;
    }
    
    
    /**
     * getAll()
     * 
     * @return 
     */
    public static List<Ball> getAll() {
        ballList1 = new ArrayList<>();
        int j = 0;
        
        for(int i = 0; i < ballList.size(); i++){
            if(ballList.get(i).isDead == false){
                ballList1.add(j, ballList.get(i));
                j++;
            }
        }
        
        return ballList1;
    }
    
    
    /**
     * checkCollisions()
     * 
     */
    public void checkCollisions() {
        for(Ball aBall : ballList){
            if(aBall.isLaunched){
                if(aBall.isDead == false){// && b1.life > 0){
                    move(aBall);

                    //Check collisions between Ball & Screen Edge
                    if(aBall.getBounds().intersects(Game.LEFTSIDE)){//b.x == 5) {//Ball hits left

                        hit(1);
                      
                        //Play sideHit Sound
                        if(Game.getGameSound()){
                            Sound.sideHit.play();
                        }
                    }

                    if(aBall.getBounds().intersects(Game.RIGHTSIDE)){//b.x == BALL_RIGHT) {//Ball hits right

                        hit(2);
                        
                        //Play sideHit Sound
                        if(Game.getGameSound()){
                            Sound.sideHit.play();
                        }
                    }

                    if(aBall.getBounds().intersects(Game.TOPSIDE)){//b.y == 0) {//Ball hits top

                        hit(0);
                        
                        //Play sideHit Sound
                        if(Game.getGameSound()){
                            Sound.sideHit.play();
                        }
                    }

                    if(aBall.getBounds().intersects(Game.BOTTOMSIDE)){//b.y == 0) {//Ball hits top
                        hit(7);
                        
                        //Game.paddle.P1Hit();
                        
                        //break;
                    }

                    if(aBall.getBounds().intersects(Game.paddle.LEFTSIDE)){//b.y == 0) {//Ball hits top
                        setXDir(-1);
                        setYDir(-1);
                        aBall.bAngle = -40.0;
                        
                        //Play sideHit Sound
                        if(Game.getGameSound()){
                            Sound.sideHit.play();
                        }
                    }

                    if(aBall.getBounds().intersects(Game.paddle.CENTRESIDE)){//b.y == 0) {//Ball hits top
                        setYDir(-1);
                        aBall.bAngle = 0.0;   
                        
                        //Play sideHit Sound
                        if(Game.getGameSound()){
                            Sound.sideHit.play();
                        }
                    }

                    if(aBall.getBounds().intersects(Game.paddle.RIGHTSIDE)){//b.y == 0) {//Ball hits top
                        setXDir(-1);
                        setYDir(-1);
                        aBall.bAngle = 40.0;   
                        
                        //Play sideHit Sound
                        if(Game.getGameSound()){
                            Sound.sideHit.play();
                        }
                    }
                }
            }
        }        
    }

    
    /**
     * clearAll()
     * 
     */
    public static void clearAll() {
        ballList.clear();
    }
    
    
    /**
     * render(Game game, Graphics2D g2d)
     * 
     *
     * @param g2d
     */
    public void render(Graphics2D g2d){
        Graphics2D g2d_Ball = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        g2d_Ball.drawImage(aBallImg1, b1.x, b1.y, b1.Bwidth+2, b1.Bheight+2, null);
        
        if(Game.showBounds){
            g2d_Ball.setColor(Color.yellow);
            g2d_Ball.drawRect(b1.x, b1.y+1, b1.Bwidth, b1.Bheight);
            g2d_Ball.setColor(Color.red);
            g2d_Ball.drawOval(b1.x+1, b1.y+2, b1.Bwidth-2, b1.Bheight-2);

            g2d_Ball.setColor(Color.black);
            g2d_Ball.drawLine(b1.x + b1.Bwidth/2, b1.y+16, b1.x + b1.Bwidth/2, b1.y);
            g2d_Ball.drawLine(b1.x, b1.y + b1.Bheight/2+1, b1.x + 15, b1.y + b1.Bheight/2+1);
        }
        
        g2d.setTransform(oldXForm);
        g2d_Ball.setTransform(oldXForm);
    
    }
     
    
    /**
     * tick()
     *
     */
    public void tick(){
        ballList = Ball.getAll();
        if(b1.isLaunched && Player.getLives() > 0){
            checkCollisions();
        }
        
        for(Ball ball1 : ballList){
            if(ball1.isLaunched){
                if(ball1.isDead == false && Player.getLives() > 0){// && b1.life > 0){
                    double xa = Math.sin(ball1.bAngle * Math.PI/180) * ball1.moveSpeed; 
                    double ya = Math.cos(ball1.bAngle * Math.PI/180) * -ball1.moveSpeed;

                    ball1.x += ball1.dx + xa;
                    ball1.y += ball1.dy + ya;
                    ball1.currentVec.x += ball1.dx;
                    ball1.currentVec.y += ball1.dy;
                    ball1.dx = 0;
                    ball1.dy = 0;
                } else {
                    ball1.dead();
                }       
            } else {
                break;
            }
        }
        
    }
    
    
    /**
     * init()
     * 
     */
    public static void init(){
        if(Ball.getAll().size() > 0){
            Ball.clearAll();
        }
        b1 = new Ball(BlockBreaker.getMainWidth()/2 + 10, BlockBreaker.getMainHeight() - 80, 16, 16, 1, 1);
        ballList.add(b1);
        
        //System.out.println("Initiating ball:"+b1.toString()+"isDead:"+b1.isDead);
        Player.setBall(b1);
    }

    
    /**
     * fire()
     *
     */
    public void fire() {
        System.out.println("Firing ball:"+b1.toString());
        launchBall();
        //Game.paddle.isFiring = false;
    }
    
    
    /**
     * dead()
     *
     */
    public void dead() {
        this.isDead = true;
    }

    
    /**
     * getBounds()
     * 
     *
     * @return new Rectangle(b1.x, b1.y+1, b1.Bwidth, b1.Bheight)
     */
    public Rectangle getBounds() {
        return new Rectangle(b1.x, b1.y+1, b1.Bwidth, b1.Bheight);
    }
    
    
    /**
     * hit()
     *
     */
    public static void hit() {
        if(getYDir() == 1){
            setXDir(-1);
            b1.bAngle = -135.0;
        } else {
            setYDir(1);
            b1.bAngle = 135.0;
        }
    }
    
    
    /**
     * hit()
     *
     * @param col
     */
    public static void hit(int col) {
        System.out.println("Collision Detected:"+col+" Angle:"+b1.bAngle);
        switch (col) {
            case 0:
                //Ball hit top game bounds
                //change y && invert angle?
                setYDir(1);
                b1.bAngle = -180;//-135.0;
                
                break;
            case 1:
                //Ball hit left game bounds
                //change x && invert angle?
                setXDir(1);
                b1.bAngle = 45.0;
                
                break;
            case 2:
                //Ball hit right game bounds
                //change x && invert angle?
                setXDir(-1);
                b1.bAngle = -130.0;
                
                break;
            case 3:
                //Ball hit bottom block bounds
                //change y && invert angle?
                setYDir(1);
                b1.bAngle = 135.0;
                
                break;
            case 4:
                //Ball hit top block bounds
                //change y && invert angle?
                setYDir(-1);
                b1.bAngle = -135.0;
                
                break;
            case 5:
                //Ball hit left block bounds
                //change x && invert angle?
                setXDir(-1);
                b1.bAngle = -75.0;
                
                break;
            case 6:
                //Ball hit right block bounds
                //change x && invert angle?
                setXDir(1);
                b1.bAngle = 45.0;
                
                break;
            case 7:
                //Ball hit Bottom bounds
                Game.paddle.P1Hit();
                
                break;
            default:
                setXDir(1);
                setYDir(-1);
                b1.bAngle = 0.0;
                
                break;
        }
        
        System.out.println("New Angle:"+b1.bAngle);
    }
    
}
