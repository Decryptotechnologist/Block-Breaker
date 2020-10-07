/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.level;

import com.LOGamez.blockbreaker.*;
import com.LOGamez.audio.Sound;
import com.LOGamez.ball.Ball;
import com.LOGamez.block.Block;
import com.LOGamez.bullets.*;
import com.LOGamez.graphics.Texture;
import com.LOGamez.player.Player;
import com.LOGamez.powerup.POW;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author Ghomez
 */
public class Level {

    /**Attributes*/
    
    /**levelNo variable of Level*/
    public static int levelNo;
    
    /**gameComplete variable of Level*/
    private static boolean gameComplete;
    
    /**levelComplete variable of Level*/
    public static boolean levelComplete = false;
    
    /**levelName variable of Level*/
    static String levelName;
    
    /**firstTick variable of Level*/
    private static boolean firstTick;
    
    /**lastTick variable of Level*/
    private static boolean lastTick;
    
    /**alpha variable of Level*/
    private float alpha;
    
    /**acomp variable of Level*/
    private AlphaComposite acomp;
    
    /**currentFont variable of Level*/
    private Font currentFont;
    
    /**bonusFont variable of Level*/
    private final Font bonusFont = new Font("Times New Roman", Font.PLAIN, 12);
    
    /**gTime variable of Level*/
    private String gTime;
    
    /**levelWidth variable of Level*/
    public int levelWidth;
    
    /**levelHeight variable of Level*/
    public int levelHeight;
    
    /**imgBG variable of Level*/
    public static BufferedImage imgBG;
    
    /**imgFG variable of Level*/
    public static BufferedImage imgFG;
    
    /**blockYOffs variable of Level*/
    private int blockYOffs;
    
    /**blockXOffs variable of Level*/
    private int blockXOffs;
    
    /**levelStartCount variable of Level*/
    private int levelStartCount;
    
    /**levelCompleteCount variable of Level*/
    private int levelCompleteCount;
    
    /**theLevelTime variable of Level*/
    public static String theLevelTime = "";
    
    /**lvlCompleteTxt variable of Level*/
    private String lvlCompleteTxt;
    
    /**lvlCompleteTxtFont variable of Level*/
    private final Font lvlCompleteTxtFont = new Font("Cambria", Font.BOLD, 46);
    
    /**lvlCompleteTxtX variable of Level*/
    private final int lvlCompleteTxtX = BlockBreaker.getMainWidth()/3-100;
    
    /**lvlCompleteTxtY variable of Level*/
    private final int lvlCompleteTxtY = BlockBreaker.getMainHeight()/2-60;
    
    /**startTxtCol2 variable of Level*/
    private final Color lvlCompleteTxtCol2 = Color.decode("#3FFF00");
    
    /**blackToOrange1 variable of Level*/
    GradientPaint blackToOrange1 = new GradientPaint(150, 50, lvlCompleteTxtCol2, 100, 300, Color.ORANGE);
    
    /**livesBonusCol variable of Level*/
    private final Color livesBonusCol = Color.decode("#Feca00");
    
    /**livesBonusX variable of Level*/
    private final int livesBonusX = Game.gameWidth / 6 + 90;
    
    /**livesBonusY variable of Level*/
    private final int livesBonusY = Game.gameHeight - 355;
    
    /**timeBonusCol variable of Level*/
    private final Color timeBonusCol = Color.decode("#FF0000");
    
    /**timeBonusX variable of Level*/
    private final int timeBonusX = Game.gameWidth / 6 + 90;
    
    /**timeBonusY variable of Level*/
    private final int timeBonusY = Game.gameHeight - 325;
    
    /**accuracyBonusCol variable of Level*/
    private final Color accuracyBonusCol = Color.decode("#FFaa00");
    
    /**accuracyBonusX variable of Level*/
    private final int accuracyBonusX = Game.gameWidth / 6 + 90;
    
    /**accuracyBonusY variable of Level*/
    private final int accuracyBonusY = Game.gameHeight - 295;
    
    /**levelBonusCol variable of Level*/
    private final Color levelBonusCol = Color.decode("#FFce00");
    
    /**levelBonusX variable of Level*/
    private final int levelBonusX = Game.gameWidth / 6 + 90;
    
    /**levelBonusY variable of Level*/
    private final int levelBonusY = Game.gameHeight - 260;
    
    /**levelBGX variable of Level*/
    private final int levelBGX = 0;
    
    /**levelBGY variable of Level*/
    private final int levelBGY = 26;
    
    /**levelBGW variable of Level*/
    private final int levelBGW = BlockBreaker.getMainWidth()+10;
    
    /**levelBGH variable of Level*/
    private final int levelBGH = BlockBreaker.getMainHeight()-72;
    
    /**levelFGX variable of Level*/
    private final int levelFGX = -10;
    
    /**levelFGY variable of Level*/
    private final int levelFGY = 26;
    
    /**levelFGW variable of Level*/
    private final int levelFGW = BlockBreaker.getMainWidth()+30;
    
    /**levelFGH variable of Level*/
    private final int levelFGH = BlockBreaker.getMainHeight()-46;
    
    
    
    /**Links*/
    
    /**blocks Block of Level*/
    private static Block blocks;
    
    /**balls Ball of Level*/
    public static Ball balls;
    
    
    
    
    

    /**
     * Level Constructor
     * 
     * 
     * @param lvlNo
     * @param w
     * @param h
     */
    public Level(int lvlNo, int w, int h) {
        System.out.println("Level: new Level "+lvlNo+" created");
        Game.hud = new HUD();
        levelNo = lvlNo;
        this.levelWidth = w;
        this.levelHeight = h;
        
        System.out.println("Level: Loading Level "+levelNo+" : "+getLevelName());
        
        setUp();
        
        init();
    }
    
    
    
    
    /**Public Protocol*/
    
    
    /**
     * setUp()
     *
     */
    private void setUp(){
        switch(levelNo){
            case 1:
                setUpLevel1();
                break;
            case 2:
                setUpLevel2();
                break;
            case 3:
                setUpLevel3();
                break;
            case 4:
                setUpLevel4();
                break;
            case 5:
                setUpLevel5();
                break;
            case 6:
                setUpLevel6();
                break;
            case 7:
                setUpLevel7();
                break; 
            case 8:
                setUpLevel8();
                break;
            case 9:
                setUpLevel9();
                break;
            case 10:
                setUpLevel10();
                break;
            case 11:
                setUpLevel11();
                break;
            case 12:
                setUpLevel12();
                break;
            case 13:
                setUpLevel13();
                break;
            case 14:
                setUpLevel14();
                break;
            case 15:
                setUpLevel15();
                break;
            case 16:
                setUpLevel16();
                break;
            case 17:
                setUpLevel17();
                break; 
            case 18:
                setUpLevel18();
                break;
            case 19:
                setUpLevel19();
                break;
            case 20:
                setUpLevel20();
                break;
            
                
        }
        
        //Level Background
        imgBG = getBackground(levelNo);
        imgFG = getForeground(levelNo);//new Texture("/Level/Breakout-Level-Foreground-GRAY_1").getImage();
        
        lvlCompleteTxt = "Level "+levelNo+" Completed";
    }
    
    
    /**
     * setUpLevel1()
     *
     */
    public void setUpLevel1(){
        levelName = "Level 1 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        //ballColor = 0;
        
        //Setup Blocks
        //Number of Blocks ? Read file??
        
        //Top Row Offset
        blockYOffs = 80;
        
        //Left Offset
        blockXOffs = 5;
        
        //Setup Level
        //Max Level Time       
        
//        loadLevelMap(levelNo);
    }
    
    
    /**
     * setUpLevel2()
     *
     */
    public void setUpLevel2(){
        levelName = "Level 2 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 80;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
        
    }
    
    
    /**
     * setUpLevel3()
     *
     */
    public void setUpLevel3(){
        levelName = "Level 3 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 120;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
    }
    
    
    /**
     * setUpLevel4()
     *
     */
    public void setUpLevel4(){
        levelName = "Level 4 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 120;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
    }
    
    
    /**
     * setUpLevel5()
     *
     */
    public void setUpLevel5(){
        levelName = "Level 5 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 130;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
        
    }
    
    
    /**
     * setUpLevel6()
     *
     */
    public void setUpLevel6(){
        levelName = "Level 6 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 100;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
        
    }
    
    
    /**
     * setUpLevel7()
     *
     */
    public void setUpLevel7(){
        levelName = "Level 7 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 100;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
        
    }
    
    
    /**
     * setUpLevel8()
     *
     */
    public void setUpLevel8(){
        levelName = "Level 8 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 100;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
        
    }
    
    
    /**
     * setUpLevel9()
     *
     */
    public void setUpLevel9(){
        levelName = "Level 9 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 60;
        
        //Left Offset
        blockXOffs = 37;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
        
    }
    
    
    /**
     * setUpLevel10()
     *
     */
    public void setUpLevel10(){
        levelName = "Level 10 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 120;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
        
    }
    
    
    /**
     * setUpLevel11()
     *
     */
    public void setUpLevel11(){
        levelName = "Level 11 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        //ballColor = 0;
        
        //Setup Blocks
        //Number of Blocks ? Read file??
        
        //Top Row Offset
        blockYOffs = 40;
        
        //Left Offset
        blockXOffs = 5;
        
        //Setup Level
        //Max Level Time       
        
//        loadLevelMap(levelNo);
    }
    
    
    /**
     * setUpLevel12()
     *
     */
    public void setUpLevel12(){
        levelName = "Level 12 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 80;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
        
    }
    
    
    /**
     * setUpLevel13()
     *
     */
    public void setUpLevel13(){
        levelName = "Level 13 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 120;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
    }
    
    
    /**
     * setUpLevel14()
     *
     */
    public void setUpLevel14(){
        levelName = "Level 14 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 120;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
    }
    
    
    /**
     * setUpLevel15()
     *
     */
    public void setUpLevel15(){
        levelName = "Level 15 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 130;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
        
    }
    
    
    /**
     * setUpLevel16()
     *
     */
    public void setUpLevel16(){
        levelName = "Level 16 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 100;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
        
    }
    
    
    /**
     * setUpLevel17()
     *
     */
    public void setUpLevel17(){
        levelName = "Level 17 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 100;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
        
    }
    
    
    /**
     * setUpLevel18()
     *
     */
    public void setUpLevel18(){
        levelName = "Level 18 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 100;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
        
    }
    
    
    /**
     * setUpLevel19()
     *
     */
    public void setUpLevel19(){
        levelName = "Level 19 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 80;
        
        //Left Offset
        blockXOffs = 37;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
        
    }
    
    
    /**
     * setUpLevel20()
     *
     */
    public void setUpLevel20(){
        levelName = "Level 20 name";
        
        //Setup Ball
        //Ball Speed
        
        //Ball Color
        
        
        //Setup Blocks
        //Number of Blocks
        
        //Top Row Offset
        blockYOffs = 120;
        
        //Left Offset
        blockXOffs = 5;
        
        
        //Setup Level
        //Max Level Time
        //power ups
        //different block pattern
        //change of background
        //inrease number of balls
        //paddle fires bullets
        //ball teleportation
        //obstruction items
        //point scorer
        //bein able 2 collect ball & fire it up
        //boss level
        
    }
    
    
    /**
     * setLevelNo(int lvlNo)
     * 
     * 
     * @param lvlNo
     */
    public static void setLevelNo(int lvlNo){
        levelNo = lvlNo;
        Game.level = new Level(levelNo, BlockBreaker.getMainWidth(), BlockBreaker.getMainHeight());
    }
    
    
    /**
     * setBackground(int lvlNo)
     * 
     * 
     * @param lvlNo
     */
    public static void setBackground(int lvlNo){
        imgBG = getBackground(lvlNo);
    }
    
    
    /**
     * getBackground(int lvlNo)
     * 
     * 
     * @param lvlNo
     * 
     * @return newBI
     */
    public static BufferedImage getBackground(int lvlNo){
        BufferedImage newBI = new Texture("/Level/Breakout-Level-Background-BLUE_1").getImage();
        
        //BLACK_1 || BLACK_3 || BLOOD_2 || BLOOD_3 || DARK-BLOOD_1 || DARK-BLOOD_4 || 
        //DARK-BLUE_1 - 5 || DARK-EMERALD_1 || DARK-GREEN_1 - 4 || EMERALD_1 || EMERALD_4 ||
        //GRAY_1 || RED_2 || ROSE_2 || ROSE_4 || AQUA_2 || AQUA_3
        if(lvlNo == 1) newBI = new Texture("/Level/Breakout-Level-Background-Brick-DARK-EMERALD_1").getImage();
        if(lvlNo == 2) newBI = new Texture("/Level/Breakout-Level-Background-Brick-DARK-BLUE_3").getImage();
        if(lvlNo == 3) newBI = new Texture("/Level/Breakout-Level-Background-Brick-BLOOD_2").getImage();
        if(lvlNo == 4) newBI = new Texture("/Level/Breakout-Level-Background-Brick-DARK-BLUE_5").getImage();
        if(lvlNo == 5) newBI = new Texture("/Level/Breakout-Level-Background-Brick-RED_2").getImage();
        if(lvlNo == 6) newBI = new Texture("/Level/Breakout-Level-Background-Brick-DARK-EMERALD_1").getImage();
        if(lvlNo == 7) newBI = new Texture("/Level/Breakout-Level-Background-Brick-BLOOD_3").getImage();
        if(lvlNo == 8) newBI = new Texture("/Level/Breakout-Level-Background-Brick-ROSE_4").getImage();
        if(lvlNo == 9) newBI = new Texture("/Level/Breakout-Level-Background-Brick-DARK-BLUE_1").getImage();
        if(lvlNo == 10) newBI = new Texture("/Level/Breakout-Level-Background-Brick-DARK-GREEN_1").getImage();
        
        if(lvlNo == 11) newBI = new Texture("/Level/Breakout-Level-Background-Brick-BLACK_1").getImage();
        if(lvlNo == 12) newBI = new Texture("/Level/Breakout-Level-Background-Brick-BLACK_3").getImage();
        if(lvlNo == 13) newBI = new Texture("/Level/Breakout-Level-Background-Brick-DARK-BLOOD_1").getImage();
        if(lvlNo == 14) newBI = new Texture("/Level/Breakout-Level-Background-Brick-DARK-BLOOD_4").getImage();
        if(lvlNo == 15) newBI = new Texture("/Level/Breakout-Level-Background-Brick-DARK-BLUE_2").getImage();
        if(lvlNo == 16) newBI = new Texture("/Level/Breakout-Level-Background-Brick-DARK-BLUE_4").getImage();
        if(lvlNo == 17) newBI = new Texture("/Level/Breakout-Level-Background-Brick-DARK-GREEN_2").getImage();
        if(lvlNo == 18) newBI = new Texture("/Level/Breakout-Level-Background-Brick-DARK-GREEN_3").getImage();
        if(lvlNo == 19) newBI = new Texture("/Level/Breakout-Level-Background-Brick-DARK-GREEN_4").getImage();
        if(lvlNo == 20) newBI = new Texture("/Level/Breakout-Level-Background-Brick-DARK-GREEN_1").getImage();
        
        return newBI;
    }
    
    
    /**
     * getForeground(int lvlNo)
     * 
     * 
     * @param lvlNo
     * 
     * @return newFI
     */
    public static BufferedImage getForeground(int lvlNo){
        BufferedImage newFI = new Texture("/Level/Breakout-Level-Foreground-GRAY_1").getImage();
        
        //BLACK_1 || BLACK_3 || BLOOD_2 || BLOOD_3 || DARK-BLOOD_1 || DARK-BLOOD_4 || 
        //DARK-BLUE_1 - 5 || DARK-EMERALD_1 || DARK-GREEN_1 - 4 || EMERALD_1 || EMERALD_4 ||
        //GRAY_1 || RED_2 || ROSE_2 || ROSE_4 || AQUA_2 || AQUA_3
        if(lvlNo == 1) newFI = new Texture("/Level/Breakout-Level-Foreground-BLUE_1").getImage();
        if(lvlNo == 2) newFI = new Texture("/Level/Breakout-Level-Foreground-BRONZE_1").getImage();
        if(lvlNo == 3) newFI = new Texture("/Level/Breakout-Level-Foreground-CRIMSON_1").getImage();
        if(lvlNo == 4) newFI = new Texture("/Level/Breakout-Level-Foreground-EMERALD_1").getImage();
        if(lvlNo == 5) newFI = new Texture("/Level/Breakout-Level-Foreground-GOLD_1").getImage();
        if(lvlNo == 6) newFI = new Texture("/Level/Breakout-Level-Foreground-GREEN_1").getImage();
        if(lvlNo == 7) newFI = new Texture("/Level/Breakout-Level-Foreground-EMERALD_2").getImage();
        if(lvlNo == 8) newFI = new Texture("/Level/Breakout-Level-Foreground-PURPLE_1").getImage();
        if(lvlNo == 9) newFI = new Texture("/Level/Breakout-Level-Foreground-MONEY_1").getImage();
        if(lvlNo == 10) newFI = new Texture("/Level/Breakout-Level-Foreground-PINK_1").getImage();
        
        if(lvlNo == 11) newFI = new Texture("/Level/Breakout-Level-Foreground-RED_1").getImage();
        if(lvlNo == 12) newFI = new Texture("/Level/Breakout-Level-Foreground-NAVY_1").getImage();
        if(lvlNo == 13) newFI = new Texture("/Level/Breakout-Level-Foreground-SUNBURST_1").getImage();
        if(lvlNo == 14) newFI = new Texture("/Level/Breakout-Level-Foreground-BLUE_1").getImage();
        if(lvlNo == 15) newFI = new Texture("/Level/Breakout-Level-Foreground-GRAY_1").getImage();
        if(lvlNo == 16) newFI = new Texture("/Level/Breakout-Level-Foreground-CRIMSON_1").getImage();
        if(lvlNo == 17) newFI = new Texture("/Level/Breakout-Level-Foreground-BRONZE_1").getImage();
        if(lvlNo == 18) newFI = new Texture("/Level/Breakout-Level-Foreground-PEA_1").getImage();
        if(lvlNo == 19) newFI = new Texture("/Level/Breakout-Level-Foreground-PURPLE_1").getImage();
        if(lvlNo == 20) newFI = new Texture("/Level/Breakout-Level-Foreground-MONEY_1").getImage();
        
        return newFI;
    }
    
    
    /**
     * init()
     *
     */
    private void init(){
        Texture.clearMaps();
        Block.clearAll();
        
        if(Ball.getAll().size() > 0){
            Ball.clearAll();
        }
        if(P1Bullet.getAll().size() > 0){
            P1Bullet.clearAll();
        }
        
        //Manage Level: First Tick
        if(firstTick) {
            //Set firstTick: false
            firstTick = false;
            
            //Reset Game Time
            Game.resetGameTime();
            
            //Reset Level Time
            resetLevelTime();
            
            if(Game.getGameMusic()){
                if(Game.levelNo == 1 && !Sound.Level1.isPlaying()){
                    Sound.Level1.loop();
                }
                if(Game.levelNo == 2 && !Sound.Level2.isPlaying()){
                    Sound.Level2.loop();
                }
                if(Game.levelNo == 3 && !Sound.Level3.isPlaying()){
                    Sound.Level3.loop();
                }
                if(Game.levelNo == 4 && !Sound.Level4.isPlaying()){
                    Sound.Level4.loop();
                }
                if(Game.levelNo == 5 && !Sound.Level5.isPlaying()){
                    Sound.Level5.loop();
                }
                if(Game.levelNo == 6 && !Sound.Level6.isPlaying()){
                    Sound.Level6.loop();
                }
                if(Game.levelNo == 7 && !Sound.Level7.isPlaying()){
                    Sound.Level7.loop();
                }
                if(Game.levelNo == 8 && !Sound.Level8.isPlaying()){
                    Sound.Level8.loop();
                }
            }
        }
        //Manage Level: Last Tick
        if(lastTick) {
            lastTick = false;
            Sound.stopAll();
            if(!Sound.creditsSoundtrack.isPlaying()){
                Sound.creditsSoundtrack.play();
            }
            
            //Reset Level Time
            resetLevelTime();
        }
        
        blocks = new Block(blockXOffs, blockYOffs);
        Game.bullets = new Bullet();
        Game.pows = new POW();
        balls = new Ball(1);
        
        //Create Player
        if(Player.getLives() > 0 && levelNo != 1){
            //set player lives to current player lives
            Game.paddle = new Player(Game.gameWidth/2 + 10, Game.gameHeight - 64, 64, 14, Game.getPName(), Player.getLives());
        } else {
            //set player lives to 3
            Game.paddle = new Player(Game.gameWidth/2 + 10, Game.gameHeight - 64, 64, 14, Game.getPName(), 3);
        }
        
        Block.init();
        Ball.init();
        
        loadLevelMap(levelNo);
        
        firstTick = true;
        lastTick = false;
        
    }
    
    
    /**
     * render(Render target, Graphics2D g2d)
     * 
     *
     * @param g2d
     */
    public void render(Graphics2D g2d){
        Graphics2D g2d_Level = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        
        g2d_Level.drawImage(imgBG, levelBGX, levelBGY, levelBGW, levelBGH, null);

        g2d_Level.drawImage(imgFG, levelFGX, levelFGY, levelFGW, levelFGH, null);
            
        if (Game.pauseTime > 0 && !Game.paused && Game.getGame().menu == null) {
            if(levelComplete){
                for (levelCompleteCount = 0; levelCompleteCount < 500; levelCompleteCount++) {
                    g2d_Level.setFont(lvlCompleteTxtFont);
                    g2d_Level.setPaint(blackToOrange1);
                    g2d_Level.drawString(lvlCompleteTxt, lvlCompleteTxtX, lvlCompleteTxtY);

                    g2d_Level.setFont(bonusFont);
                    g2d_Level.setColor(livesBonusCol);
                    g2d_Level.drawString("Lives Bonus: "+Game.getLivesBonus(), livesBonusX, livesBonusY);
                    g2d_Level.setColor(timeBonusCol);
                    g2d_Level.drawString("Time Bonus: "+Game.getTimeBonus(), timeBonusX, timeBonusY);
                    g2d_Level.setColor(accuracyBonusCol);
                    g2d_Level.drawString("Accuracy Bonus: "+Game.getAccuracyBonus(), accuracyBonusX, accuracyBonusY);
                    g2d_Level.setColor(levelBonusCol);
                    g2d_Level.drawString("Level Bonus: "+Game.getLevelBonus(), levelBonusX, levelBonusY);

                    BlockBreaker.setStatusBar("Level "+Game.levelNo+" : "+getLevelName()+" Completed!!");

                    if (levelCompleteCount == 0) {
                        lastTick = true;
                        break;
                    }
                }
            } else {
                for (levelStartCount = 0; levelStartCount < 100; levelStartCount++) {
                    if(levelStartCount == 100){
                        firstTick = true;
                        //Reset Level Time
                        resetLevelTime();
                        break;
                    }
                }
            }
        }
            blocks.render(g2d);
            balls.render(g2d);
            P1Bullet.render(g2d);
            POW.render(g2d);
            //Game.hud.render(g2d);
        
        g2d.setTransform(oldXForm);
        g2d_Level.setTransform(oldXForm);
    }
        
        
    /**
     * tick()
     *
     */
    public static void tick(){
    
        if(firstTick){
            firstTick = false;
            Game.resetGameTime();
            
            if(Game.getGameMusic()){
                if(Game.levelNo == 1){
                    Sound.Level1.loop();
                }
                if(Game.levelNo == 2){
                    Sound.Level2.loop();
                }
                if(Game.levelNo == 3){
                    Sound.Level3.loop();
                }
                if(Game.levelNo == 4){
                    Sound.Level4.loop();
                }
                if(Game.levelNo == 5){
                    Sound.Level5.loop();
                }
                if(Game.levelNo == 6){
                    Sound.Level6.loop();
                }
            }
        }
        if(lastTick){
            lastTick = false;
            Sound.stopAll();
//            if(!Sound.endOfLevel.isPlaying()){
//                Sound.endOfLevel.play();
//            }
            //Reset Level Time
            resetLevelTime();
        }
        
        blocks.tick();
        balls.tick();
        POW.tick();
        Bullet.tick();
    }
    
    
    /**
     * changeLevel()
     * 
     */
    public static void changeLevel(){
        if(levelNo < 8){
            levelNo++;
            setLevelNo(levelNo);
        } else {
            gameComplete = true;
        }
    }
    
    
    /**
     * getLevelName()
     * 
     *
     * @return levelName
     */
    public static String getLevelName(){
        return levelName;
    }
    
    
    /**
     * getLevelNo()
     * 
     *
     * @return Game.levelNo
     */
    public static int getLevelNo(){
        return Game.levelNo;
    }

    
    /**
     * loadLevelMap(int lvlNo)
     * 
     *
     */
    private void loadLevelMap(int lvlNo) {
        loadLevelBlockMap(lvlNo);
    }

    
    /**
     * loadLevelBlockMap(int lvlNo)
     * 
     *
     */
    private void loadLevelBlockMap(int lvlNo) {
        Block.loadBlockMap(lvlNo);
    }
    
    
    /**
    * resetLevelTime()
    * 
    */
    public static void resetLevelTime() {
        System.out.println("Level: Resetting Level Time");
        Game.levelTime = 0;
    }
    
}
