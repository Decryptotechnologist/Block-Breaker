/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.level;

import com.LOGamez.blockbreaker.Game;
import com.LOGamez.player.Player;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Ghomez
 */
public class HUD {
    
    /**Attributes*/
    
    /**scoreLabelScale variable of HUD*/
    public static double scoreLabelScale;
    
    /**scoreX coordinate of HUD*/
    public static int scoreX;
    
    /**scoreY coordinate of HUD*/
    public static int scoreY;
    
    /**livesLabelX coordinate of HUD*/
    public static int livesLabelX;
    
    /**livesLabelY coordinate of HUD*/
    public static int livesLabelY;
    
    /**livesLabelShadowCol coordinate of HUD*/
    public static int livesLabelBGCol;
    
    /**livesLabelShadowCol coordinate of HUD*/
    public static int livesLabelFGCol;
    
    /**playerNameX coordinate of HUD*/
    public static int playerNameX;
    
    /**playerNameY coordinate of HUD*/
    public static int playerNameY;
    
    /**livesImgScale variable of HUD*/
    public static int livesImgScale;
    
    /**livesImg0X coordinate of HUD*/
    public static int livesImg0X;
    
    /**livesImg0Y coordinate of HUD*/
    public static int livesImg0Y;
    
    /**livesImg1X coordinate of HUD*/
    public static int livesImg1X;
    
    /**livesImg1Y coordinate of HUD*/
    public static int livesImg1Y;
    
    /**livesImg2X coordinate of HUD*/
    public static int livesImg2X;
    
    /**livesImg2Y coordinate of HUD*/
    public static int livesImg2Y;
    
    /**scoreLabelX coordinate of HUD*/
    public static int scoreLabelX;
    
    /**scoreLabelY coordinate of HUD*/
    public static int scoreLabelY;
    
    /**scoreLabelBGCol coordinate of HUD*/
    public static int scoreLabelBGCol;
    
    /**scoreLabelFGCol coordinate of HUD*/
    public static int scoreLabelFGCol;
    
    /**LabelScale variable of HUD*/
    public static double LabelScale;
    
    /**fpsX coordinate of HUD*/
    public static int fpsX;
    
    /**fpsY coordinate of HUD*/
    public static int fpsY;
    
    /**upsX coordinate of HUD*/
    public static int upsX;
    
    /**upsY coordinate of HUD*/
    public static int upsY; 
    
    /**gTimeX variable of Level*/
    int gTimeX;
    
    /**gTimeY variable of Level*/
    int gTimeY;
    
    /**backgroundNo variable of Level*/
    private String fps;
    
    /**backgroundNo variable of Level*/
    private String ups;
    
    /**enterLevelNoScale variable of HUD*/
    public static double enterLevelNoScale;
    
    /**enterLevelX coordinate of HUD*/
    public static int enterLevelX;
    
    /**enterLevelY coordinate of HUD*/
    public static int enterLevelY;
    
    /**LevelX coordinate of HUD*/
    public static int LevelX;
    
    /**LevelY coordinate of HUD*/
    public static int LevelY;
    
    /**LevelNoX coordinate of HUD*/
    public static int LevelNoX;
    
    /**LevelNoY coordinate of HUD*/
    public static int LevelNoY;
    
    /**pLives0X coordinate of HUD*/
    int pLives0X = 10;
    
    /**pLives1X coordinate of HUD*/
    int pLives1X = 50;
    
    /**pLives2X coordinate of HUD*/
    int pLives2X = 90;
    
    /**pLivesScale coordinate of HUD*/
    int pLivesScale = 30;
    
    /**pLivesY coordinate of HUD*/
    int pLivesY = 8;
    
    /**click2FocusScale variable of HUD*/
    public static double click2FocusScale;
    
    /**click2FocusX coordinate of HUD*/
    public static int click2FocusX;
    
    /**click2FocusY coordinate of HUD*/
    public static int click2FocusY;
    
    
    
    /**Constructor*/
    
    /**
     * HUD()
     * 
     */
    public HUD() {
        System.out.println("HUD: New HUD Created");
        
        setUp();
    }
    
    
    /**Public protocol*/
    
    
    /**
     * setUp()
     * 
     */
    private void setUp(){        
        Player.levelNo = "Lv";
        Player.livesNo = "L";
        
        int width = Game.gameWidth;
        switch(width){
            case 300:
                LabelScale = 0.75;
            
                scoreLabelX = Game.gameWidth - 175;
                scoreLabelY = -12;
                scoreLabelBGCol = 0x0e8100;//Dark Green
                scoreLabelFGCol = 0xffffff;//White

                scoreX = Game.gameWidth - 40;
                scoreY = 15;

                livesLabelX = 5;
                livesLabelY = -12;
                livesLabelBGCol = 0x0e8100;//Dark Green
                livesLabelFGCol = 0xffffff;//White

                playerNameX = Game.gameWidth / 2 - Game.getPName().length() * 5;
                playerNameY = 15;

                livesImgScale = 25;
                livesImg0X = 90;
                livesImg0Y = -5;

                livesImg1X = 115;
                livesImg1Y = -5;

                livesImg2X = 140;
                livesImg2Y = -5;

                enterLevelNoScale = 1;
                enterLevelX = Game.gameWidth / 6 - 30;//10
                enterLevelY = Game.gameHeight - 175;

                LevelX = Game.gameWidth - 150;//120
                LevelY = Game.gameHeight - 174;

                LevelNoX = Game.gameWidth - 60;//165
                LevelNoY = LevelY;

                click2FocusScale = 1;
                click2FocusX = Game.gameWidth / 6;
                click2FocusY = Game.gameHeight / 2 - 50;

                fpsX = 5;
                fpsY = Game.gameHeight - 55;
                upsX = 5;
                upsY = Game.gameHeight - 45;
            
                break;
                
            case 480:
                LabelScale = 1.00;
            
                scoreLabelX = Game.gameWidth - 175;
                scoreLabelY = -22;
                scoreLabelBGCol = 0x0e8100;//Dark Green
                scoreLabelFGCol = 0xffffff;//White

                scoreX = Game.gameWidth - 80;
                scoreY = 15;

                livesLabelX = 5;
                livesLabelY = -22;
                livesLabelBGCol = 0x0e8100;//Dark Green
                livesLabelFGCol = 0xffffff;//White

                playerNameX = Game.gameWidth / 2 - Game.getPName().length() * 5;
                playerNameY = 15;

                livesImgScale = 50;
                livesImg0X = 90;
                livesImg0Y = -15;

                livesImg1X = 140;
                livesImg1Y = -15;

                livesImg2X = 190;
                livesImg2Y = -15;

                enterLevelNoScale = 2;
                enterLevelX = Game.gameWidth / 6 - 30;
                enterLevelY = Game.gameHeight - 375;

                LevelX = Game.gameWidth - 290;
                LevelY = Game.gameHeight - 374;

                LevelNoX = Game.gameWidth - 135;
                LevelNoY = LevelY;

                click2FocusScale = 2.0;
                click2FocusX = Game.gameWidth / 6;
                click2FocusY = Game.gameHeight / 2 - 50;

                fpsX = 15;
                fpsY = Game.gameHeight - 60;
                upsX = 15;
                upsY = Game.gameHeight - 40;
                gTimeX = Game.gameWidth/2 - 40;//Game.gameWidth-160;
                gTimeY = upsY+5;//20;
                
                break;
                
            case 604:
                LabelScale = 1.25;
            
                scoreLabelX = Game.gameWidth - 160;
                scoreLabelY = -22;
                scoreLabelBGCol = 0xe81000;//0x0e8100;//Dark Green
                scoreLabelFGCol = 0xffffff;//White

                scoreX = Game.gameWidth - 70;
                scoreY = 15;

                livesLabelX = 5;
                livesLabelY = -22;
                livesLabelBGCol = 0x0e8100;//Dark Green
                livesLabelFGCol = 0xffffff;//White

                playerNameX = Game.gameWidth / 2 - Game.getPName().length() * 5;
                playerNameY = 15;

                livesImgScale = 50;
                livesImg0X = 90;
                livesImg0Y = -15;

                livesImg1X = 140;
                livesImg1Y = -15;

                livesImg2X = 190;
                livesImg2Y = -15;

                enterLevelNoScale = 2;
                enterLevelX = Game.gameWidth / 6 - 30;
                enterLevelY = Game.gameHeight - 465;

                LevelX = Game.gameWidth - 290;
                LevelY = Game.gameHeight - 464;

                LevelNoX = Game.gameWidth - 135;
                LevelNoY = LevelY;

                click2FocusScale = 2.0;
                click2FocusX = Game.gameWidth / 6;
                click2FocusY = Game.gameHeight / 2 - 50;

                fpsX = 15;
                fpsY = Game.gameHeight - 60;
                upsX = 15;
                upsY = Game.gameHeight - 40;
                gTimeX = Game.gameWidth/2 - 40;//Game.gameWidth-160;
                gTimeY = upsY+59;//20;
                
                break;
                
            default:
                LabelScale = 1.25;
            
                scoreLabelX = Game.gameWidth - 175;
                scoreLabelY = -22;
                scoreLabelBGCol = 0x0e8100;//Dark Green
                scoreLabelFGCol = 0xffffff;//White

                scoreX = Game.gameWidth - 70;
                scoreY = 15;

                livesLabelX = 5;
                livesLabelY = -22;
                livesLabelBGCol = 0x0e8100;//Dark Green
                livesLabelFGCol = 0xffffff;//White

                playerNameX = Game.gameWidth / 2 - Game.getPName().length() * 5;
                playerNameY = 15;

                livesImgScale = 50;
                livesImg0X = 90;
                livesImg0Y = -15;

                livesImg1X = 140;
                livesImg1Y = -15;

                livesImg2X = 190;
                livesImg2Y = -15;

                enterLevelNoScale = 2;
                enterLevelX = Game.gameWidth / 6 - 30;
                enterLevelY = Game.gameHeight - 465;

                LevelX = Game.gameWidth - 290;
                LevelY = Game.gameHeight - 464;

                LevelNoX = Game.gameWidth - 135;
                LevelNoY = LevelY;

                click2FocusScale = 2.0;
                click2FocusX = Game.gameWidth / 6;
                click2FocusY = Game.gameHeight / 2 - 50;

                fpsX = 15;
                fpsY = Game.gameHeight - 60;
                upsX = 15;
                upsY = Game.gameHeight - 40;
                gTimeX = Game.gameWidth/2 - 40;//Game.gameWidth-160;
                gTimeY = upsY+59;//20;
                
                break;
                
        }
    }
    
    
    /**
     * init()
     * 
     */
    private void init(){
        
    }
    
    /**
    * render(Render target, Graphics2D g)
    * 
    * Renders/Repaints Level Objects
    * 
    * @param g2d
    */
    public void render(Graphics2D g2d){
        Graphics2D g2d_HUD = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        if(Game.showHUD){
            if(Game.showFPS){
                fps = Game.theFPS;
                g2d_HUD.setColor(Color.yellow);
                g2d_HUD.drawString(fps, fpsX, fpsY);
            }

            if(Game.showUPS){
                ups = Game.theUPS;
                g2d_HUD.setColor(Color.green);
                g2d_HUD.drawString(ups, upsX, upsY);
            }
            
            //Draw Game Score
            int gameScoreX = scoreX;
            Player.levelNo = "Lv"+Game.levelNo;
            Player.livesNo = "L"+Player.lives;

            if(Game.gameScore == 0){
                gameScoreX = scoreX-5;
                Game.paddle.setPlayScore("0000");
            } else if(Game.gameScore > 0  && Game.gameScore < 100){
                gameScoreX = scoreX-5;
                Game.paddle.setPlayScore("00"+Game.gameScore);
            } else if(Game.gameScore >= 100 && Game.gameScore < 1000){
                gameScoreX = scoreX-5;
                Game.paddle.setPlayScore("0"+Game.gameScore);
            } else if(Game.gameScore >= 1000 && Game.gameScore < 100000){
                gameScoreX = scoreX-5;
                Game.paddle.setPlayScore(""+Game.gameScore);
            } else if(Game.gameScore >= 100000){
                gameScoreX = scoreX-(5 + Game.paddle.getPlayScore().length());
                Game.paddle.setPlayScore(""+Game.gameScore);
            }  
            g2d_HUD.setColor(Color.decode("#00ff0c"));
            g2d_HUD.drawString(Game.paddle.getPlayScore(), gameScoreX, scoreY);
            
            if(Game.showBounds || Game.showScreenBounds){
                //Draw Bottom EOS Bounds
                g2d_HUD.setColor(Color.green);
                g2d_HUD.drawRect(Game.BOTTOMSIDE.x, Game.BOTTOMSIDE.y, Game.BOTTOMSIDE.width, Game.BOTTOMSIDE.height);

                //Draw Left EOS Bounds
                g2d_HUD.setColor(Color.green);
                g2d_HUD.drawRect(Game.LEFTSIDE.x, Game.LEFTSIDE.y, Game.LEFTSIDE.width, Game.LEFTSIDE.height);

                //Draw Right EOS Bounds
                g2d_HUD.setColor(Color.green);
                g2d_HUD.drawRect(Game.RIGHTSIDE.x, Game.RIGHTSIDE.y, Game.RIGHTSIDE.width, Game.RIGHTSIDE.height);

                //Draw Top EOS Bounds
                g2d_HUD.setColor(Color.green);
                g2d_HUD.drawRect(Game.TOPSIDE.x, Game.TOPSIDE.y, Game.TOPSIDE.width, Game.TOPSIDE.height);
            }
            
            //GUI Contd
            //Draw Game Title
            g2d_HUD.setColor(Color.GREEN);
            g2d_HUD.drawString(Game.TITLE, Game.gameWidth/2 - Game.TITLE.length() * 3, 12);

            //Draw Player Name
            g2d_HUD.setColor(Color.GRAY);
            g2d_HUD.drawString("Player Name: ", Game.gameWidth/2 - Game.getPName().length() * 10, 22);
            g2d_HUD.setColor(Color.GRAY);
            g2d_HUD.drawString(Game.getPName(), Game.gameWidth/2 + Game.getPName().length() * 3, 22);
        
            if(Game.showGameTime){
                String gameTime = Game.theGameTime;
                g2d_HUD.setColor(Color.decode("#008fea"));
                g2d_HUD.drawString(gameTime, gTimeX, gTimeY);
            }
            
            if(Game.showLevelTime){
                String levTime = Level.theLevelTime;
                g2d_HUD.setColor(Color.decode("#ff8fea"));
                g2d_HUD.drawString(levTime, gTimeX+100, gTimeY);
            }
            
            //Old
            g2d_HUD.setColor(Color.decode("#dd0f0c"));
            g2d_HUD.drawString(Player.livesNo, playerNameX-50, playerNameY);
//            g2d_HUD.setColor(Color.decode("#00ff0c"));
//            g2d_HUD.drawString(Player.playerName, playerNameX, playerNameY);
            g2d_HUD.setColor(Color.decode("#dd0f0c"));
            g2d_HUD.drawString(Player.levelNo, playerNameX+126, playerNameY);
            
            
            
            
            //Draw 4 or More Lives left
            if(Player.lives > 3){			
                g2d_HUD.drawImage(Player.imgPLives, pLives0X, pLivesY-10, pLivesScale, pLivesScale, null);

                g2d_HUD.setColor(Color.decode("#00ff0c"));
                g2d_HUD.drawString("X"+Player.lives, playerNameX-120, playerNameY-4);
            }
//            //Draw Three Lives left
//            if(Player.lives == 3){
//                g2d_HUD.drawImage(Player.imgPLives, livesImg2X, livesImg2Y, livesImgScale, livesImgScale, null);
//                g2d_HUD.drawImage(Player.imgPLives, livesImg1X, livesImg1Y, livesImgScale, livesImgScale, null);
//                g2d_HUD.drawImage(Player.imgPLives, livesImg0X, livesImg0Y, livesImgScale, livesImgScale, null);
//            }
//            //Draw Two Lives left
//            if(Player.lives == 2){			
//                g2d_HUD.drawImage(Player.imgPLives, livesImg0X, livesImg0Y, livesImgScale, livesImgScale, null);
//                g2d_HUD.drawImage(Player.imgPLives, livesImg1X, livesImg1Y, livesImgScale, livesImgScale, null);
//            }
//            //Draw One Live left
//            if(Player.lives == 1){
//                g2d_HUD.drawImage(Player.imgPLives, livesImg0X, livesImg0Y, livesImgScale, livesImgScale, null);
//            }

            //Draw Player Lives
            if(Player.lives == 3){
                g2d_HUD.drawImage(Player.imgPLives, pLives2X, pLivesY-10, pLivesScale, pLivesScale, null);
                g2d_HUD.drawImage(Player.imgPLives, pLives1X, pLivesY-10, pLivesScale, pLivesScale, null);
                g2d_HUD.drawImage(Player.imgPLives, pLives0X, pLivesY-10, pLivesScale, pLivesScale, null);
            }

            if(Player.lives == 2){
                g2d_HUD.drawImage(Player.imgPLives, pLives1X, pLivesY-10, pLivesScale, pLivesScale, null);
                g2d_HUD.drawImage(Player.imgPLives, pLives0X, pLivesY-10, pLivesScale, pLivesScale, null);
            }

            if(Player.lives == 1){
                g2d_HUD.drawImage(Player.imgPLives, pLives0X, pLivesY-10, pLivesScale, pLivesScale, null);
            }
            
        }
    
    }
    
}
