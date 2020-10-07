/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.block;

import com.LOGamez.blockbreaker.BlockBreaker;
import com.LOGamez.blockbreaker.Game;
import com.LOGamez.audio.Sound;
import com.LOGamez.ball.Ball;
import com.LOGamez.bullets.P1Bullet;
import com.LOGamez.graphics.Texture;
import com.LOGamez.level.Level;
import com.LOGamez.player.Player;
import com.LOGamez.powerup.POW;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.vecmath.Vector2d;
import java.io.*;
import java.util.logging.Logger;

/**
 *
 * @author Ghomez
 */
public class Block {

    /**Attributes*/

    /**blockStrength variable of Block*/
    public static int blockStrength;
    
    /**invaderStrength variable of Block*/
    private static int invaderStrength;
    
    /**oldblockStrength variable of Block*/
    private static int oldblockStrength;
    
    /**oldInvaderStrength variable of Block*/
    private static int oldInvaderStrength;
    
    /**blockStrengthD variable of Block*/
    private static double blockStrengthD;
    
    /**ballBounds variable of Block*/
    private static Rectangle ballBounds;
    private static BufferedImage aBlockImg9;
    private static BufferedImage aBlockImg10;
    private static BufferedImage aBlockImg11;
    private static BufferedImage aBlockImg12;
    private static BufferedImage aBlockImg13;
    private static BufferedImage aBlockImg14;
    private static BufferedImage aBlockImg15;
    private static BufferedImage aBlockImg16;
    private static BufferedImage aBlockImg17;
    private static int solidBlock;
    private static int blocks2Break;

    /**x variable of Block*/
    public int x;
    
    /**y variable of Block*/
    public int y;
    
    /**currentVec variable of Block*/
    private Vector2d currentVec;
    
    /**blockWidth variable of Block*/
    public int blockWidth;
    
    /**blockHeight variable of Block*/
    public int blockHeight;
    
    /**type variable of Block*/
    private int type;
    
    /**B1Rect variable of Block*/
    private Rectangle B1Rect;
    
    /**B1Rect_T variable of Block*/
    private Rectangle B1Rect_T;
    
    /**B1Rect_B variable of Block*/
    private Rectangle B1Rect_B;
    
    /**B1Rect_L variable of Block*/
    private Rectangle B1Rect_L;
    
    /**B1Rect_R variable of Block*/
    private Rectangle B1Rect_R;
    
    /**blockList variable of Block*/
    public static List<Block> blockList = new ArrayList<>();
    
    /**blockListA variable of Block*/
    private static List<Block> blockListA;
    
    /**blockList variable of Block*/
    public static List<P1Bullet> bulletList = new ArrayList<>();
    
    /**blockIMGList variable of Block*/
    public static List<BufferedImage> blockIMGList = new ArrayList<>();
    
    /**random variable of Block*/
    public static Random random = new Random();
    
    /**id variable of Block*/
    private int id;
    
    /**col variable of Block*/
    private Color col = Color.MAGENTA;
    
    /**img variable of Block*/
    private BufferedImage img;
    
    /**imgA variable of Block*/
    private BufferedImage imgA;
    
    /**isDestroyed variable of Block*/
    private boolean isDestroyed;
    
    /**isDamaged variable of Block*/
    private boolean isDamaged;
    
    /**aBlockImg1 variable of Block*/
    private static BufferedImage aBlockImg1;
    
    /**aBlockImg1a variable of Block*/
    private static BufferedImage aBlockImg1a;
    
    /**aBlockImg2 variable of Block*/
    private static BufferedImage aBlockImg2;
    
    /**aBlockImg2a variable of Block*/
    private static BufferedImage aBlockImg2a;
    
    /**aBlockImg3 variable of Block*/
    private static BufferedImage aBlockImg3;
    
    /**aBlockImg3a variable of Block*/
    private static BufferedImage aBlockImg3a;
    
    /**aBlockImg4 variable of Block*/
    private static BufferedImage aBlockImg4;
    
    /**aBlockImg4a variable of Block*/
    private static BufferedImage aBlockImg4a;
    
    /**aBlockImg5 variable of Block*/
    private static BufferedImage aBlockImg5;
    
    /**aBlockImg5a variable of Block*/
    private static BufferedImage aBlockImg5a;
    
    /**aBlockImg6 variable of Block*/
    private static BufferedImage aBlockImg6;
    
    /**aBlockImg6a variable of Block*/
    private static BufferedImage aBlockImg6a;
    
    /**aBlockImg7 variable of Block*/
    private static BufferedImage aBlockImg7;
    
    /**aBlockImg8 variable of Block*/
    private static BufferedImage aBlockImg8;
    
    /**xOffs variable of Block*/
    private static int xOffs;
    
    /**yOffs variable of Block*/
    private static int yOffs;

    /**bloxHit variable of Block object */
    private static int bloxHit = 0;
    
    /**Links*/
    
    
    
    
    /**Constructor*/
    
    
    /**
     * Block Constructor
     * 
     * 
     * @param xO
     * @param yO
     */
    public Block(int xO, int yO) { 
        this.xOffs = xO;
        this.yOffs = yO;
    }
    
    
    /**
     * Block Constructor
     * 
     * 
     * @param _x
     * @param _y
     * @param w
     * @param h
     * @param type
     * @param id
     * @param img
     * @param imgD
     */
    public Block(int _x, int _y, int w, int h, int type, int id, BufferedImage img, BufferedImage imgD) {
        System.out.println("Block: New Block Created x:"+_x+" y:"+_y+" w:"+w+" h:"+h);
        this.x = _x;
        this.y = _y;
        this.currentVec = new Vector2d(this.x, this.y);
        this.blockWidth = w;
        this.blockHeight = h;
        this.type = type;
        this.B1Rect = new Rectangle(this.x+2, this.y+7, 33, 17);
        
        this.B1Rect_T = new Rectangle(2 + _x + 33/4, _y+7, 33/2, 17/2);
        this.B1Rect_B = new Rectangle(2+ _x + 33/4, 7 +_y + (17/4 *3), 33/2, 17/2);
        this.B1Rect_L = new Rectangle(2 + _x, _y+7, 33/4, 17);
        this.B1Rect_R = new Rectangle(2 +_x + (33/4 *3), _y+7, 33/4, 17);
        
        this.id = id;
        this.img = img;
        this.imgA = imgD;
        this.isDestroyed = false;
        this.isDamaged = false;
    }
    
    
    
    
    /**Public Protocol*/
    
    
    
    /**
     * render(Graphics2D g2d)
     * 
     *
     * @param g2d
     */
    public void render(Graphics2D g2d){
        Graphics2D g2d_Block = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        for(Block bl1 : blockList){
            
            if(bl1.isDamaged == true){ 
                g2d_Block.drawImage(bl1.imgA, bl1.x, bl1.y, 38, 32, null);
            } else {            
                g2d_Block.drawImage(bl1.img, bl1.x, bl1.y, 38, 32, null);
            }
            
            if(Game.showBounds || Game.showBlockBounds){
                g2d_Block.setColor(Color.yellow);
                g2d_Block.drawRect(bl1.B1Rect.x, bl1.B1Rect.y, bl1.B1Rect.width, bl1.B1Rect.height);

                g2d_Block.setColor(Color.red);
                g2d_Block.drawRect(bl1.B1Rect_L.x, bl1.B1Rect_L.y, bl1.B1Rect_L.width, bl1.B1Rect_L.height);

                g2d_Block.setColor(Color.red);
                g2d_Block.drawRect(bl1.B1Rect_R.x, bl1.B1Rect_R.y, bl1.B1Rect_R.width, bl1.B1Rect_R.height);

                g2d_Block.setColor(Color.black);
                g2d_Block.drawRect(bl1.B1Rect_T.x, bl1.B1Rect_T.y, bl1.B1Rect_T.width, bl1.B1Rect_T.height);

                g2d_Block.setColor(Color.black);
                g2d_Block.drawRect(bl1.B1Rect_B.x, bl1.B1Rect_B.y, bl1.B1Rect_B.width, bl1.B1Rect_B.height);

            }
        }
        
        
        g2d.setTransform(oldXForm);
        g2d_Block.setTransform(oldXForm);
    
    }
    
    /**
     * tick()
     * 
     *
     */
    public void tick(){
        if(!Level.levelComplete){
            blockList = getAll();
            bulletList = P1Bullet.getAll();
            ballBounds = Player.ball.getBounds();

            for(Block bl1 : blockList){                
                if(bl1.B1Rect_B.intersects(ballBounds)){

                    if(bl1.img == aBlockImg7){
                        Ball.hit(3);
                    } else {
                        //add Score
                        Game.increaseScore(bl1);

                        hit(bl1);
                        Ball.hit(3);
                    }

                    //Play sideHit Sound
                    if(Game.getGameSound()){
                        if(Sound.sideHit.isPlaying()) Sound.sideHit.stop();
                        Sound.sideHit.play();
                    }
                    
                    break;
                }
                
                
                if(bl1.B1Rect_T.intersects(ballBounds)){

                    if(bl1.img == aBlockImg7){
                        Ball.hit(4);
                    } else {
                        //add Score
                        Game.increaseScore(bl1);

                        hit(bl1);
                        Ball.hit(4);
                    }

                    //Play sideHit Sound
                    if(Game.getGameSound()){
                        if(Sound.sideHit.isPlaying()) Sound.sideHit.stop();
                        Sound.sideHit.play();
                    }
                    
                    break;
                }
                
                if(bl1.B1Rect_L.intersects(ballBounds)){

                    if(bl1.img == aBlockImg7){
                        Ball.hit(5);
                    } else {
                        //add Score
                        Game.increaseScore(bl1);

                        hit(bl1);
                        Ball.hit(5);
                    }

                    //Play sideHit Sound
                    if(Game.getGameSound()){
                        if(Sound.sideHit.isPlaying()) Sound.sideHit.stop();
                        Sound.sideHit.play();
                    }
                    
                    break;
                }
                
                if(bl1.B1Rect_R.intersects(ballBounds)){

                    if(bl1.img == aBlockImg7){
                        Ball.hit(6);
                    } else {
                        //add Score
                        Game.increaseScore(bl1);

                        hit(bl1);
                        Ball.hit(6);
                    }

                    //Play sideHit Sound
                    if(Game.getGameSound()){
                        if(Sound.sideHit.isPlaying()) Sound.sideHit.stop();
                        Sound.sideHit.play();
                    }
                    
                    break;
                }
                
                //Block and P1Bullet Collisions
                for(P1Bullet bull1 : bulletList){ 
                    if (bull1.getBounds().intersects(bl1.getBounds())) {
                        
                        if(bl1.type == 0){
                            //message P1Bullet(id) hit
                            bull1.BulletHit(bull1);
                        } else {
                            //add Score
                            Game.increaseScore(bl1);

                            hit(bl1);

                            //message P1Bullet(id) hit
                            bull1.BulletHit(bull1);
                        }
                    }
                    //Play sideHit Sound
//                    if(Game.getGameSound()){
//                        if(Sound.sideHit.isPlaying()) Sound.sideHit.stop();
//                        Sound.sideHit.play();
//                    }
                    
                    //break;
                }
            }
        
            blockStrength = Block.getAll().size();
            invaderStrength = Block.getAll().size();
            
            if(blockStrength < oldblockStrength || invaderStrength < oldInvaderStrength){
                displayBarStrength();
            }
            
            oldblockStrength = blockStrength;
            oldInvaderStrength = invaderStrength;
            
            if(blockList.isEmpty() || blocks2Break == 0 || bloxHit == blocks2Break){
                System.out.println("Level Complete!");
                System.out.println("BlockList Empty:"+blockList.isEmpty());
                System.out.println("Blocks to Break:"+blocks2Break);
                System.out.println("Blocks Hit:"+bloxHit);
                Game.pauseTime = 150;
                Level.levelComplete = true;

            }
        }
    }
    
    
    /**
    * displayBarStrength()
    * 
    */
    public static void displayBarStrength(){
        if(blockStrength == 0){
            //System.out.println("Barricade Destroyed!");
            BlockBreaker.setStatusBar("Blocks Destroyed!"+"    Blocks Remaining: "+blocks2Break);
        } else {
            blockStrengthD = ((double) (blockStrength % 648.0 / 10.0));
            String num = String.format("%.1f", blockStrengthD);
            //System.out.println("Barricade Strength: "+num +"%");
            BlockBreaker.setStatusBar("Block Strength: "+num +"%"+"    Blocks Remaining: "+blocks2Break+ " Solid:"+solidBlock);
        }
    }
    
    
    /**
     * hit(Block bl1)
     * 
     *
     * @param bl1
     */
    public static void hit(Block bl1){
	//Block.BlockDetonate(bl1);
        bl1.img = aBlockImg8;
        if(random.nextInt(5) == 0){
            POW.init(bl1);
        }
        if(bl1.type == 2 && bl1.isDamaged == false){
            damaged(bl1);
        } else {
            destroyed(bl1);  
        }
    }
    
    /**
     * getBlocksHit()
     * 
     * @return bloxHit
     */
    public static int getBlocksHit() {
        return bloxHit;
    }
    
    
    /**
     * resetBlocksHit()
     * 
     */
    public static void resetBlocksHit() {
        bloxHit = 0;
    }
    
    /**
     * init()
     * 
     *
     */
    public static void init(){
        System.out.println("Block: Initializing Block Objects");
        blockList = new ArrayList<>();
        
        aBlockImg1 = new Texture("/Sprites/Breakout-Sprite-Brick-AQUA_128").getImage();
        aBlockImg1a = new Texture("/Sprites/Breakout-Sprite-Brick-AQUA_128A").getImage();
        aBlockImg2 = new Texture("/Sprites/Breakout-Sprite-Brick-BLUE_128").getImage();
        aBlockImg2a = new Texture("/Sprites/Breakout-Sprite-Brick-BLUE_128A").getImage();
        aBlockImg3 = new Texture("/Sprites/Breakout-Sprite-Brick-BRONZE_128").getImage();
        aBlockImg3a = new Texture("/Sprites/Breakout-Sprite-Brick-BRONZE_128A").getImage();
        aBlockImg4 = new Texture("/Sprites/Breakout-Sprite-Brick-EMERALD_128").getImage();
        aBlockImg4a = new Texture("/Sprites/Breakout-Sprite-Brick-EMERALD_128A").getImage();
        aBlockImg5 = new Texture("/Sprites/Breakout-Sprite-Brick-GOLD_128").getImage();
        aBlockImg5a = new Texture("/Sprites/Breakout-Sprite-Brick-GOLD_128A").getImage();
        aBlockImg6 = new Texture("/Sprites/Breakout-Sprite-Brick-RED_128").getImage();
        aBlockImg6a = new Texture("/Sprites/Breakout-Sprite-Brick-RED_128A").getImage();
        aBlockImg7 = new Texture("/Sprites/Breakout-Sprite-Brick-BLACK_128").getImage();
        
        aBlockImg9 = new Texture("/Sprites/Breakout-Sprite-Brick-METAL_128").getImage();
        aBlockImg10 = new Texture("/Sprites/Breakout-Sprite-Brick-MINT_128").getImage();
        aBlockImg11 = new Texture("/Sprites/Breakout-Sprite-Brick-NAVYBLUE_128").getImage();
        aBlockImg12 = new Texture("/Sprites/Breakout-Sprite-Brick-PINK_128").getImage();
        aBlockImg13 = new Texture("/Sprites/Breakout-Sprite-Brick-ROSE_128").getImage();
        aBlockImg14 = new Texture("/Sprites/Breakout-Sprite-Brick-SKYBLUE_128").getImage();
        aBlockImg15 = new Texture("/Sprites/Breakout-Sprite-Brick-YELLOW_128").getImage();
        aBlockImg16 = new Texture("/Sprites/Breakout-Sprite-Brick-WHITE_128").getImage();
        aBlockImg17 = new Texture("/Sprites/Breakout-Sprite-Brick-WHITE_128").getImage();
        
        aBlockImg8 = new Texture("/Sprites/Breakout-Sprite-Brick-WHITE_128").getImage();
        
        blockIMGList.add(aBlockImg1);
        blockIMGList.add(aBlockImg2);
        blockIMGList.add(aBlockImg3);
        blockIMGList.add(aBlockImg4);
        blockIMGList.add(aBlockImg5);
        blockIMGList.add(aBlockImg6);
        blockIMGList.add(aBlockImg7);
        blockIMGList.add(aBlockImg8);
        blockIMGList.add(aBlockImg9);
        blockIMGList.add(aBlockImg10);
        blockIMGList.add(aBlockImg11);
        blockIMGList.add(aBlockImg12);
        blockIMGList.add(aBlockImg13);
        blockIMGList.add(aBlockImg14);
        blockIMGList.add(aBlockImg15);
        blockIMGList.add(aBlockImg16);
        blockIMGList.add(aBlockImg17);
        
        //loadRandomBlocks();
        
    }    

    
    private static void loadRandomBlocks() {
        int idc = 0;
        Block aBlock;
        System.out.println("Loading BlockMap: Random.txt");
        
        
        if(Game.levelNo == 1){
            //          x(10)        to              x(600 - 32)
            //          y(88)        to              y(340)
            for(int x = 5; x < 458; x+=34){
                for(int y = 88; y < 166; y+=18){
                    if(y < 106){
                        aBlock = new Block(x, y, 32, 16, random.nextInt(4), idc, blockIMGList.get(6), blockIMGList.get(6));
                    } else {
                        aBlock = new Block(x, y, 32, 16, random.nextInt(4), idc, blockIMGList.get(random.nextInt(12)/2), blockIMGList.get(random.nextInt(12)/2));
                    }
                    blockList.add(aBlock);
                    idc++;
                }
            }
        }

        if(Game.levelNo == 2){
            //          x(10)        to              x(600 - 32)
            //          y(88)        to              y(340)
            for(int x = 5; x < 458; x+=34){
                for(int y = 88; y < 166; y+=18){
                    if(y < 106 || x < 39 || x > 424){
                        aBlock = new Block(x, y, 32, 16, random.nextInt(4), idc, blockIMGList.get(6), blockIMGList.get(6));
                    } else {
                        aBlock = new Block(x, y, 32, 16, random.nextInt(4), idc, blockIMGList.get(random.nextInt(12)/2), blockIMGList.get(random.nextInt(12)/2));
                    }
                    blockList.add(aBlock);
                    idc++;
                }
            }
        }
        
        if(Game.levelNo == 3){
            //          x(10)        to              x(600 - 32)
            //          y(80)        to              y(340)
            for(int x = 5; x < 458; x+=34){
                for(int y = 80; y < 340; y+=18){
                    aBlock = new Block(x, y, 32, 16, random.nextInt(4), idc, blockIMGList.get(random.nextInt(12)/2), blockIMGList.get(random.nextInt(12)/2));
                    blockList.add(aBlock);
                    idc++;
                }
            }
        }
        
        if(Game.levelNo == 4){
            //          x(10)        to              x(600 - 32)
            //          y(80)        to              y(340)
            for(int x = 5; x < 458; x+=34){
                for(int y = 80; y < 340; y+=18){
                    aBlock = new Block(x, y, 32, 16, random.nextInt(4), idc, blockIMGList.get(random.nextInt(12)/2), blockIMGList.get(random.nextInt(12)/2));
                    blockList.add(aBlock);
                    idc++;
                }
            }
        }
        
        if(Game.levelNo == 5){
            //          x(10)        to              x(600 - 32)
            //          y(80)        to              y(340)
            for(int x = 5; x < 458; x+=34){
                for(int y = 80; y < 340; y+=18){
                    aBlock = new Block(x, y, 32, 16, random.nextInt(4), idc, blockIMGList.get(random.nextInt(12)/2), blockIMGList.get(random.nextInt(12)/2));
                    blockList.add(aBlock);
                    idc++;
                }
            }
        }
        
        if(Game.levelNo == 6){
            //          x(10)        to              x(600 - 32)
            //          y(80)        to              y(340)
            for(int x = 5; x < 458; x+=34){
                for(int y = 80; y < 340; y+=18){
                    aBlock = new Block(x, y, 32, 16, random.nextInt(4), idc, blockIMGList.get(random.nextInt(12)/2), blockIMGList.get(random.nextInt(12)/2));
                    blockList.add(aBlock);
                    idc++;
                }
            }
        }
        
        if(Game.levelNo == 7){
            //          x(10)        to              x(600 - 32)
            //          y(80)        to              y(340)
            for(int x = 5; x < 458; x+=34){
                for(int y = 80; y < 340; y+=18){
                    aBlock = new Block(x, y, 32, 16, random.nextInt(4), idc, blockIMGList.get(random.nextInt(12)/2), blockIMGList.get(random.nextInt(12)/2));
                    blockList.add(aBlock);
                    idc++;
                }
            }
        }
        
        if(Game.levelNo == 8){
            //          x(10)        to              x(600 - 32)
            //          y(80)        to              y(340)
            for(int x = 5; x < 458; x+=34){
                for(int y = 80; y < 340; y+=18){
                    aBlock = new Block(x, y, 32, 16, random.nextInt(4), idc, blockIMGList.get(random.nextInt(12)/2), blockIMGList.get(random.nextInt(12)/2));
                    blockList.add(aBlock);
                    idc++;
                }
            }
        }
        
        if(Game.levelNo == 9){
            //          x(10)        to              x(600 - 32)
            //          y(80)        to              y(340)
            for(int x = 5; x < 458; x+=34){
                for(int y = 80; y < 340; y+=18){
                    aBlock = new Block(x, y, 32, 16, random.nextInt(4), idc, blockIMGList.get(random.nextInt(12)/2), blockIMGList.get(random.nextInt(12)/2));
                    blockList.add(aBlock);
                    idc++;
                }
            }
        }
        
        if(Game.levelNo == 10){
            //          x(10)        to              x(600 - 32)
            //          y(80)        to              y(340)
            for(int x = 5; x < 458; x+=34){
                for(int y = 80; y < 340; y+=18){
                    aBlock = new Block(x, y, 32, 16, random.nextInt(4), idc, blockIMGList.get(random.nextInt(12)/2), blockIMGList.get(random.nextInt(12)/2));
                    blockList.add(aBlock);
                    idc++;
                }
            }
        }
    }
    
    
    public static void loadBlockMap(int lNo) {
        //Load Block Map
        //Read text file into char list/List<Char>
        List<String> lvl_Map = new ArrayList<>();
        clearAll();
        
        BufferedReader reader;
        String line;
        String fileName = "Level ";
        System.out.println("Loading BlockMap: "+fileName+lNo+".txt");
        
        try {
            reader = new BufferedReader(new FileReader("res/sys/"+fileName+lNo+".txt"));
            while((line = reader.readLine()) != null){
                lvl_Map.add(line);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            loadRandomBlocks();
            //Logger.getLogger(Block.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Block.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        int xN = 0;
        int yN = 0;
        solidBlock = 0;
        blocks2Break = 0;
        resetBlocksHit();
        int idc = 0;
        Block aBlock = null;
        int newWidth = 34;
        int newHeight = 18;
        
        //Read List of Chars
        for(int i = 0; i < lvl_Map.size(); i++){
            for(int j = 0; j < lvl_Map.get(i).length(); j++){
                char chr = lvl_Map.get(i).charAt(j);
                xN = xOffs + (j * newWidth);
                yN = yOffs + (i * newHeight);
                
                
                switch(chr){
                    case 'S':
                        aBlock = new Block(xN, yN, newWidth, newHeight, 0, idc, blockIMGList.get(6), blockIMGList.get(6));
                        System.out.println("New SOLID Block created: x:"+xN+" y:"+yN);
                        solidBlock++;
                        
                        break;
                    case 'R':
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(random.nextInt(12)/2), blockIMGList.get(random.nextInt(12)/2));
                        System.out.println("New RANDOM Block created: x:"+xN+" y:"+yN);
                    
                        break;
                    case '1':
                        //AQUA
                        aBlock = new Block(xN, yN, newWidth, newHeight, 2, idc, blockIMGList.get(0), aBlockImg1a);
                        System.out.println("New AQUA Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case '2':
                        //BLUE
                        aBlock = new Block(xN, yN, newWidth, newHeight, 2, idc, blockIMGList.get(1), aBlockImg2a);
                        System.out.println("New BLUE Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case '3':
                        //BRONZE
                        aBlock = new Block(xN, yN, newWidth, newHeight, 2, idc, blockIMGList.get(2), aBlockImg3a);
                        System.out.println("New BRONZE Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case '4':
                        //EMERALD
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(3), aBlockImg4a);
                        System.out.println("New EMERALD Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case '5':
                        //GOLD
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(4), aBlockImg5a);
                        System.out.println("New GOLD Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case '6':
                        //RED
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(5), aBlockImg6a);
                        System.out.println("New RED Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case '7':
                        //BLACK
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(6), blockIMGList.get(6));
                        System.out.println("New BLACK Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case '8':
                        //WHITE
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(7), blockIMGList.get(7));
                        System.out.println("New WHITE Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case '9':
                        //DIAMOND
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(8), blockIMGList.get(8));
                        System.out.println("New WHITE Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case '0':
                        //DIAMOND
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(9), blockIMGList.get(9));
                        System.out.println("New WHITE Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case 'X':
                        //DIAMOND
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(10), blockIMGList.get(10));
                        System.out.println("New WHITE Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case 'Y':
                        //DIAMOND
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(11), blockIMGList.get(11));
                        System.out.println("New WHITE Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case 'Z':
                        //DIAMOND
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(12), blockIMGList.get(12));
                        System.out.println("New WHITE Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case 'A':
                        //ROSE
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(13), blockIMGList.get(13));
                        System.out.println("New WHITE Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case 'B':
                        //DIAMOND
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(14), blockIMGList.get(14));
                        System.out.println("New WHITE Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case 'C':
                        //DIAMOND
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(15), blockIMGList.get(15));
                        System.out.println("New WHITE Block created: x:"+xN+" y:"+yN);
                        
                        break;
                    case 'D':
                        //DIAMOND
                        aBlock = new Block(xN, yN, newWidth, newHeight, 1, idc, blockIMGList.get(16), blockIMGList.get(16));
                        System.out.println("New WHITE Block created: x:"+xN+" y:"+yN);
                        
                        break;
                
                }
                if(aBlock != null){
                    blockList.add(aBlock);
                    idc++;
                    //if(aBlock.type != 0) blocks2Break++;
                }
                //blocks2Break = blockList.size()-solidBlock;
                
            }
        }
        blocks2Break = blockList.size() - solidBlock;
        System.out.println("Blocks created:"+blockList.size());
        System.out.println("Solid Blocks created:"+solidBlock);
        System.out.println("Blocks to break:"+blocks2Break);
    }
    
    private static void destroyed(Block bl1) {
        bl1.isDestroyed = true;
        bloxHit++;
        //blocks2Break--;
    }
    
    private static void damaged(Block bl1) {
        bl1.isDamaged = true;
    }
    
    
    /**
     * getAll()
     * 
     *
     * @return blockListA
     */
    public static List<Block> getAll() {
        blockListA = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < blockList.size(); i++) {
            if (blockList.get(i).isDestroyed == false || blockList.get(i).type == 0) {
                blockListA.add(j, blockList.get(i));
                j++;
                if(blockList.get(i).type == 0){
                    blockList.get(i).img = aBlockImg7;
                }
            }
        }
        
        return blockListA;
    }
    
    /**
     * clearAll()
     * 
     *
     */
    public static void clearAll() {
        blockList.clear();
    }
    
    /**
     * getBounds()
     * 
     * 
     * @return B1Rect
     */
    private Rectangle getBounds() {
        return this.B1Rect;//new Rectangle(this.x, this.y, this.blockWidth, this.blockHeight);
    }
    
}
