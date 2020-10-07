/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.player;

/**
 *
 * @author Ghomez
 */
public class PlayerStats {

    
    private int levelBonus;
    private int livesBonus;
    private int accuracyBonus;
    private int timeBonus;

    
    /**
    * getLevelBonus()
    * 
    * @return levelBonus
    */
    public int getLevelBonus(){       
        return levelBonus;
    }

    
    /**
    * setLevelBonus(int lvlBonus)
    * 
    * @param lvlBonus
    */
    public void setLevelBonus(int lvlBonus) {
        this.levelBonus = lvlBonus;
    }

    
    
    /**
    * getLivesBonus()
    * 
    * @return livesBonus
    */
    public int getLivesBonus() {
        return livesBonus;
    }

    
    /**
    * setLivesBonus(int lvsBonus)
    * 
    * @param lvsBonus
    */
    public void setLivesBonus(int lvsBonus) {
        this.livesBonus = lvsBonus;
    }
    
    
    
    /**
    * getAccuracyBonus()
    * 
    * @return accuracyBonus
    */
    public int getAccuracyBonus(){       
        return accuracyBonus;
    }

    
    /**
    * setAccuracyBonus(int acracyBonus)
    * 
    * @param acracyBonus
    */
    public void setAccuracyBonus(int acracyBonus) {
        this.accuracyBonus = acracyBonus;
    }

    
    
    /**
    * getTimeBonus()
    * 
    * @return timeBonus
    */
    public int getTimeBonus(){       
        return timeBonus;
    }

    
    /**
    * setTimeBonus(int timBonus)
    * 
    * @param timBonus
    */
    public void setTimeBonus(int timBonus) {
        this.timeBonus = timBonus;
    }  
    
    
}
